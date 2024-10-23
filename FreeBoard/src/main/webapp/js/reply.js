/**
 * reply.js
 * replyService 생성했던 메소드 활용
 * <table id="replyList" class="table">
	<thead>
		<tr>
			<th>댓글번호</th><th>내용</th><th>작성자</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>
svc.replylist(212//bno
	, function(result) {
		console.log(result);
		let fields = ['replyNo', 'reply', 'replyer'];
		for (let i = 0; i < result.length; i++) {
			let tr = document.createElement('tr');
			for (let j = 0; j < fields.length; j++) {
				let td = document.createElement('td');
				td.innerHTML = result[i][fields[j]]
				tr.appendChild(td);
			}
			document.querySelector('#replyList tbody').appendChild(tr);
		}
	}	//successFnc 
	, function(err) {
		console.log('요기', err);
	}	//errorFnc
)
 */

let page = 1; //댓글 페이지 변수


//댓글등록 버튼
document.querySelector('#addReply').addEventListener('click', addReplyHandlerFnc);

function addReplyHandlerFnc(e) {
	let reply = document.querySelector('#reply').value;
	if (!reply || !logId) {
		alert('필수값 없습니다')
		return;
	}
	//게시글번호:bno 댓글내용:reply, 댓글작성: logId 
	svc.addReply({ bno, reply, replyer: logId },
		result => {
			console.log(result);
			if (result.retCode == 'OK') {
				alert('정상 처리');
				//let template = makeLi(result.retVal);
				//document.querySelector(".reply ul li").after(template);
				page =1;
				showList();
				svc.getReplyCount(bno, createPageList, err => console.log(err));
				
			} else if (result.retCode == 'FAIL') {
				alert('처리중 예외');
			} else {
				alert('알수 없는 코드');
			}
		},
		err => {
			console.log(err);
		}
	)
}//addReplyHandlerFnc(e)

//목록출력
/*svc.replylist(bno//bno
	//successFnc 
	, function(result) {
		console.log(result);
		for (let i = 0; i < result.length; i++) {
			let template = document.querySelector(".reply ul li").cloneNode(true);
			console.log(template);
			template.querySelector('span').innerText = result[i]['replyNo'];
			template.querySelector('span:nth-of-type(2)').innerText = result[i]['reply'];
			template.querySelector('span:nth-of-type(3)').innerText = result[i]['replyer'];
			template.querySelector('span:nth-of-type(4)').innerHTML = '<button onclick="deleteRow(event)">삭제</button>';

			document.querySelector(".reply ul").appendChild(template);
		}
	}
	//errorFnc
	, function(err) {
		console.log('요기', err);
	}
);*/

// pagination a 클릭이벤트
function linkMove() {
   document.querySelectorAll('nav ul.pagination a').forEach(function(aTag) {
      aTag.addEventListener('click', function(e) {
         e.preventDefault();   // 이동차단
         console.log(aTag.innerHTML);
         page = aTag.dataset.page;   // <a data-page="2">2</a>
         showList();   // 목록보여주고
        svc.getReplyCount(bno, createPageList, err => console.log(err));   // 페이징목록보여주고
      })
   })
}

// 페이지목록을 출력하는 함수
svc.getReplyCount(bno, createPageList, err => console.log(err));
//createPageList();
function createPageList(result) {   // page = 2
console.log(result.totalCount)

   let totalCnt = result.totalCount;
   let startPage, endPage, realEnd;
   let prev, next;

   endPage = Math.ceil(page / 5) * 5;   // 5page
   startPage = endPage - 4;   // 1page
   realEnd = Math.ceil(totalCnt / 5)   // 7page
   endPage = endPage > realEnd ? realEnd : endPage;

   prev = startPage > 1;   // false
   next = endPage < realEnd;   // true

	// 페이지리스트 출력

   let list = '';

   list += '<li class="page-item">';
   if (prev) // 이전페이지 출력.
		list += '  <a class="page-link" href="#" aria-label="Previous" data-page="' + (startPage - 1) + '">&laquo;</a>';
	else
		list += '  <span class="page-link disabled" aria-hidden="true">&laquo;</span>';
	list += '    </li>';
   //<li class="page-item"><a class="page-link" href="#">3</a></li>
   for (let p = startPage; p <= endPage; p++) {
      list += '<li class="page-item"><a class="page-link" href="#" data-page="'+ p +'">' + p + '</a></li>'
   }

   list += '<li class="page-item">';
   if (next) // 이후페이지 출력.
		list += '  <a class="page-link" href="#" aria-label="Next" data-page="' + (endPage + 1) + '">&raquo;</a>';
	else
		list += '  <span class="page-link disabled" aria-hidden="true">&raquo;</span>';
	list += '    </a></li>';
   document.querySelector('nav ul.pagination').innerHTML = list;
   
   linkMove();
}


/*let li = document.createElement('li');
li.className = 'page-item';
let a = document.createElement('a');
a.className = 'page-link';
a.setAttribute('href', '#');
a.innerText = p;
li.appendChild(a);

document.querySelector('nav ul.pagination').appendChild(li);

	}
}*/

//댓글목록 축력함수
showList();
function showList() {
	//출력목록을 화면에서 지우고
	document.querySelectorAll('div.reply div.content li').forEach((li, idx) => {
		if (idx > 0)
			li.remove();
	})
	//목록출력
	svc.replylist({ bno, page }//bno
		//successFnc 
		, function(result) {
			console.log(result);
			for (let i = 0; i < result.length; i++) {
				let template = makeLi(result[i]);
				document.querySelector(".reply ul").appendChild(template);

			}
		},
		function(err) {
			console.log('요기', err);
		}
	);
}//end of showList
//댓글정보 한건있으면 <li>.....</li> 함수생성
function makeLi(rvo = { replyNo, reply, replyer }) {
	let template = document.querySelector(".reply ul li").cloneNode(true);
	console.log(template);
	template.querySelector('span').innerText = rvo.replyNo;
	template.querySelector('span:nth-of-type(2)').innerText = rvo.reply;
	template.querySelector('span:nth-of-type(3)').innerText = rvo.replyer;
	template.querySelector('span:nth-of-type(4)').innerHTML = '<button onclick="deleteRow(event)">삭제</button>';

	return template
}

//댓글 삭제하는 함수
function deleteRow(e) {
	let rno = e.target.parentElement.parentElement.firstElementChild.innerText;
	console.log(rno);
	// 삭제기능 호출
	svc.removeReply(rno,
		result => {
			if (result.retCode == 'OK') {
				alert('정상 처리');
				e.target.parentElement.parentElement.remove();
				showList();
				svc.getReplyCount(bno, createPageList, err => console.log(err));
			} else if (result.retCode == 'FAIL') {
				alert('처리중 예외');
			} else {
				alert('알수 없는 코드');
			}
		},   // 정상처리 실행함수
		err => console.log(err)   // 예외발생 실행함수
	)
}






/*function makeList(result) {
	console.log(result)
	for (let i = 0; i < result.length; i++) {
		let tr = makeRow(result[i]);
		document.querySelector('#replyList tbody').appendChild(tr);
	}
}*/


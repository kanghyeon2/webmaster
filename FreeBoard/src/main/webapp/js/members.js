/**'
 * members.js
 */
//JSP => req.getDispatch...("board/boardList.tiles").forward(req,resp);
//json => json데이터 활용페이지그리기

// JSON형태의 회원목록 출력하는 데이터 필요
// "등록" 버튼에 이벤트 추가 
document.querySelector('#addBtn').addEventListener('click', function(e) {
	let id = document.querySelector('#member_id').value;
	let name = document.querySelector('#member_name').value;
	let phone = document.querySelector('#member_phone').value;

	fetch('addMemberJson.do?id=' + id + '&name=' + name + '&phone=' + phone)
		.then(resolve =>  resolve.json())
		.then(result => {
			console.log(result); //{retCode: 'OK"}
			if (result.retCode == 'OK') {
				let tr = makeRow({ memberId: id, memberName: name, phone: phone });
				document.querySelector('#show tbody').appendChild(tr);
			} else if (result.retCode == 'FAIL') {
				alert('처리중 에러가 발생')
			}
		})
		.catch(err => { console.log(err) })
})

//1. 목록출력
fetch('memberJson.do')
	.then(resolve => resolve.json())
	.then(result => {
		console.log(result);
		makeList(result);
	})
	.catch(err => console.log(err));



function makeList(obj = []) {
	for (let i = 0; i < obj.length; i++) {
		let tr = makeRow(obj[i]);
		document.querySelector('#show tbody').appendChild(tr);
	}
}



function makeRow(obj = {}) {
	let fields = ['memberId', 'memberName', 'phone'];
	let tr = document.createElement('tr');
	tr.setAttribute('data-id', obj.memberId);
	//td 생성
	for (let j = 0; j < fields.length; j++) {
		let td = document.createElement('td');
		td.innerHTML = obj[fields[j]]; //obj.name, obj['name']
		tr.appendChild(td);
	}
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.addEventListener('click', deleteRowFnc);
	btn.innerHTML = "삭제";
	td.appendChild(btn);
	tr.appendChild(td);

	return tr;
}

function deleteRowFnc(e) { 
	console.log(e);
	//console.dir(e.target.parentElement.parentElement.firstElementChild.innerText);
	console.dir(e.target.parentElement.parentElement.dataset.id);
	let id = e.target.parentElement.parentElement.dataset.id;
	fetch('removeMemberJson.do?id=' + id)
	.then(resolve => resolve.json())
	.then(result => {
		if(result.retCode == 'OK'){
			alert('성공')
			e.target.parentElement.parentElement.remove(); //화면에서 삭제
			
		}else if(result.retCode =='FAIL'){
			alert('처리중 에러가 발생')
		}
	})
	.catch(err => console.log(err))
	 }

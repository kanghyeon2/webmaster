/**
 * reply.js
 * replyService 생성했던 메소드 활용
 */
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



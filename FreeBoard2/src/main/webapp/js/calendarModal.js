/**
 * calendarModal.js
 */

function modalShow(arg) {
	modalArg = arg; //여러함수에서 사용
	// body 태그
	let body = document.querySelector('body')
	body.className = 'modal-open';
	body.style.overflow = 'hidden';
	body.style.paddingRight = '15px';

	let div = document.createElement('div');
	div.className = 'modal-backdrop fade show'
	body.appendChild(div);

	// 모달태그
	let modal = document.querySelector('#exampleModal')
	modal.classList.add('show');
	modal.setAttribute('aria-modal', true);
	modal.setAttribute('role', 'dialog');
	modal.removeAttribute('aria-hidden')
	modal.style.display = 'block'

	start.value = modalArg.startStr;
	end.value = modalArg.endStr;

}
function modalClose() {
	let body = document.querySelector('body')
	body.removeAttribute('style');
	body.removeAttribute('class');

	let div = document.querySelector('.modal-backdrop.fade.show');
	div.remove();

	let modal = document.querySelector('#exampleModal')
	modal.classList.remove('show');
	modal.removeAttribute('aria-modal');
	modal.removeAttribute('role', 'dialog');
	modal.removeAttribute('style')
	modal.setAttribute('aria-hidden', true)

}
function modalSave() {
	let title = document.querySelector("#title").value
	let startStr = document.querySelector("#start").value
	let endStr = document.querySelector("#end").value

	console.log(modalArg.start)
	fetch('addEvent.do?title=' + title + '&start=' + startStr + '&end=' + endStr)
		.then(resolve => resolve.json())
		.then(result => {
			if (result.retCode == 'OK') {
				alert('굿')
				calendar.addEvent({
					title: title,
					start: modalArg.start,
					end: modalArg.end,
					allDay: modalArg.allDay
				}) //end of 화면출력
				modalClose()
			} else if (result.retCode == 'FAIL') {
				alert('실패')
			}
		})
		.catch(err => console.log(err));

}

function startChange(event) {
	console.log(event);
	modalArg.start = new Date(event.target.value); // 2024-10-21

}
function endChange(event) {
	console.log(event);
	modalArg.end = new Date(event.target.value); // 2024-10-21
}

function deleteExe() {
	let text = document.querySelector('#userValue').value
	console.log(text)
	let span1 = document.querySelectorAll('.container span')
	console.log(span1)
	for (let i = 0; i < span1.length; i++) {
		if (text == span1[i].innerHTML) {
			span1[i].remove();
		}
	}
}
	
	/*for (i of span1){
		if(i.innerHTML==text){
			i.remove();
		}
	}*/
	





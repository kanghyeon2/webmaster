/**
 * ajax1.js
 * Asynchronous Javascript Anx Xml 비동기방식 
 */

let xhtp = new XMLHttpRequest(); //비동기방식처리(Ajax)
xhtp.open('get', 'memberJson.do');
xhtp.send(); // 서버창 resource 필수

let data = [];
xhtp.onload = function() {
	let obj = JSON.parse(xhtp.responseText); //parse >> 객체로 타입 변환
	console.log(obj);
	data = obj;
	console.log('1', data);
	for (let i = 0; i < data.length; i++) {
		console.log(data[i]);
	}
}

	console.log('2', data);



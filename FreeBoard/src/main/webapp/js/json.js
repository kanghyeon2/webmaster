/**
 * json.js
 * {name: "홍길동", age: 20} => object
 * {"name": "홍길동", "age": 20} => json object
 * json문자열 => 자바스크립트 객체 => json문자열
 * <table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>firstName</th>
				<th>lastName</th>
				<th>Email</th>
				<th>Salary</th>
				<th>삭제</th>
				
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
 */
let obj = { name: "홍길동", age: 20 };
let json = JSON.stringify(obj);	//object -> string(타입 변환)
obj = JSON.parse(json); // string -> object(타입 변환)

// JSP => 페이지 출력
// JSON 데이터 => 페이지 작성

fetch('js/MOCK_DATA.json')
.then(function(resolve){
	console.log(resolve);
	return resolve.json(); // json 객체타입으로 표현
})
.then(function(result){
	console.log(result);
	makeList(result);
})

//obj = JSON.parse(data); // 배열
//console.log(obj);

// obj배열에 있는 건수만큼 tr생성 tbody 하위요소 등록
function makeList(obj = [] ) {
	let fields = ['id', 'first_name', 'last_name', 'email', 'salary'];
	for (let i = 0; i < obj.length; i++) {
		let tr = document.createElement('tr');
		tr.addEventListener('mouseover', function(e){tr.style.backgroundColor = 'gray'});
		tr.addEventListener('mouseout', function(e){tr.style.backgroundColor = ''});
		//td 생성
		for (let j = 0; j < fields.length; j++) {
			let td = document.createElement('td');
			td.innerHTML = obj[i][fields[j]]; //obj.name, obj['name']
			tr.appendChild(td);
		}
		td = document.createElement('td');
		let btn = document.createElement('button')
		btn.addEventListener('click', function(e){btn.parentElement.parentElement.remove()});
		btn.innerHTML = "삭제";
		td.appendChild(btn);
		tr.appendChild(td);
		
		
		document.querySelector('#show tbody').appendChild(tr);

	}
}
//makeList();

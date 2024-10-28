<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<title>jQuery Element Selection</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
		/*$(function() {
			$("p").on("click", function() {
				$(".jq").css("backgroundColor", "red");	// 클래스가 "jq"인 요소를 모두 선택함.
			});
		});*/
		//javascript
		document.addEventListener('DOMContentLoaded', function(e){
			//모든 p요소 선택
			document.querySelectorAll('p').forEach(item=>{
				//클릭이벤트
			item.addEventListener('click' , function(e){
				document.querySelectorAll('.jq').forEach(jq=> {
				jq.style.backgroundColor = 'red';					
				});
			});
		});
	});
		
	[1,2,3,4,5].forEach((item, i) => {		
		console.log(i);
		console.log(item);
	})	
	</script>
</head>

<body>

	<h1>클래스 선택자</h1>

	<p class="jq">이제부터 제이쿼리를 다 같이 공부해보죠!!</p>
	<p class="jq">클래스 선택자로 특정 요소들을 한 번에 선택할 수 있어요!!</p>
	<p>마우스로 글씨를 클릭해보세요!!</p>

</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>javascript.jsp</h3>

<table class="table">
	<tr>
		<th>아이디</th><td><input type="text" id="member_id"></td>
	</tr>
	<tr>
		<th>이름</th><td><input type="text" id="member_name"></td>
	</tr>
	<tr>
		<th>휴대폰</th><td><input type="text" id="member_phone"></td>
	</tr>
	<tr>
		<td align ="center" colspan="2"><button id="addBtn">등록</button></td>
	</tr>
</table>


<div id="show">
	<!-- 회원목록출력(JSON데이터) -->
	<table class="table">
		<thead>
			<tr>
				<th>회원아이디</th>
				<th>회원이름</th>
				<th>휴대폰</th>
				<th>삭제</th>

			</tr>
		</thead>
		<tbody></tbody>
	</table>


</div>




<!--<script src="js/data.js"></script>-->
<!--<script src="js/json.js"></script>-->
<script src="js/members.js"></script>
<!-- <script src="js/ajax1.js"></script> -->

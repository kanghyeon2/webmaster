<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>상세페이지(board.jsp)</h3>
<%
BoardVO bvo = (BoardVO) request.getAttribute("boardvo");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String wdate = sdf.format(bvo.getWriteDate());
%>


<table class="table">
	<tr>
		<th>글번호</th>
		<td><%=bvo.getBoardNo()%></td>
		<th>조회수</th>
		<td><%=bvo.getViewCnt()%></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><%=bvo.getTitle()%></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea cols="50" rows="10"></textarea></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><%=bvo.getWriter()%></td>
	</tr>
	<tr>
		<th>작성일시</th>
		<td><%=wdate%></td>
	</tr>
	<tr>
		<td colspan='2' align="center">
		<input type="submit" value="수정" class='btn btn-warning'> 
		<input type="submit" value="삭제" class='btn btn-danger'>
		</td>
	</tr>

</table>
<jsp:include page="../includes/footer.jsp"></jsp:include>

<script>
	document.querySelector('input[value="수정"]').addEventListener('click',
			function(e) {
				location.href = 'modifyBoard.do?bno=<%=bvo.getBoardNo()%>'
			});
	document.querySelector('input[value="삭제"]').addEventListener('click',
			function(e) {
				location.href = 'deleteBoard.do?bno=<%=bvo.getBoardNo()%>'
			});

</script>


<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.account.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>상세페이지(board.jsp)</h3>
<%
BoardVO bvo = (BoardVO) request.getAttribute("boardvo");
String pg = (String) request.getAttribute("page");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String wdate = sdf.format(bvo.getWriteDate());
String sc = (String) request.getAttribute("searchCondition");
String kw = (String) request.getAttribute("keyword");
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
		<th>작성자</th>
		<td><%=bvo.getWriter()%></td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3"><textarea cols="50" rows="10"></textarea></td>
	</tr>
	<tr>
		<th>이미지</th>
		<td colspan="3"><img src="images/<%=bvo.getImg() %>" width="100px"></td>
	</tr>
	<tr>
		<th>작성일시</th>
		<td colspan="3"><%=wdate%></td>
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
				location.href = 'modifyBoard.do?searchCondition=<%=sc %>&keyword=<%=kw %>&page=<%=pg %>&bno=<%=bvo.getBoardNo() %>'
			});
	document.querySelector('input[value="삭제"]').addEventListener('click',
			function(e) {
				location.href = 'deleteBoard.do?bno=<%=bvo.getBoardNo()%>'
			});

</script>


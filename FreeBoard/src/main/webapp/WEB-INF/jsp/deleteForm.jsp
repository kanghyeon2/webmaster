<%@page import="com.yedam.vo.account.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:include page="../includes/header.jsp"></jsp:include>
 <%
 String msg = (String) request.getAttribute("msg");
 BoardVO board = (BoardVO) request.getAttribute("boardvo");
 %>
 
 <%if(msg!= null){ %>
 <p style="color: red;"><%=msg %></p>
 <%} %>
 
 <h3>삭제화면(deleteForm.jsp)</h3>
 <form action="deleteBoard.do" method ="post">
 <input type="hidden" name="bno" value="<%=board.getBoardNo() %>">
 <table class='table'>
 <tr>
 	<th>글번호</th><td><%=board.getBoardNo() %></td>
 </tr>
 
 <tr>
	 <td colspan="3"><h3>진짜로 삭제하시겠습니까?</h3></td>
 </tr>
 
 <tr>
	<td colspan='4' align='center'>
		<input type="submit" value="삭제"  class='btn btn-success'>	
		<input type="reset" value="취소"  class='btn btn-danger'>	
	</td>		
	</tr>
 
 </table>
 </form>
 <jsp:include page="../includes/footer.jsp"></jsp:include>
 
 <script>
	document.querySelector('input[value="취소"]').addEventListener('click',
			function(e) {
				location.href = 'boardList.do'
			});
</script>
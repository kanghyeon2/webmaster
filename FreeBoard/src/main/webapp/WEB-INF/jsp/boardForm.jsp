<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:include page="../includes/header.jsp"></jsp:include>
 
 <h3>등록화면(boardFrom.jsp)</h3>
 
 <%
 String msg = (String) request.getAttribute("msg");
 %>
 
 <%if(msg!= null){ %>
 <p style="color: red;"><%=msg %></p>
 <%} %>
 <form action="addBoard.do" method ="get">
 <table class='table'>
 <tr>
	 <th>제목</th><td><input class="form-control" type="text" name="title"></td>
 </tr>
 <tr>
 	<th>내용</th><td><textarea class="form-control" name = "content" cols="30" rows="5"></textarea></td>
 </tr>
 <tr>
 	<th>작성자</th><td><input class="form-control" type="text" name="writer"></td>
 </tr>
 <tr>
	<td colspan='2'>
		<input type="submit" value="저장"  class='btn btn-success'>	
		<input type="reset" value="취소"  class='btn btn-danger'>	
	</td>		
	</tr>
 
 </table>
 </form>
 
 <jsp:include page="../includes/footer.jsp"></jsp:include>
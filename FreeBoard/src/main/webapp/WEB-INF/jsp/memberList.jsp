<%@page import="com.yedam.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



	<h3>회원목록</h3>

	<%
	List<MemberVO> list = (List<MemberVO>) request.getAttribute("memberList");
	System.out.println(list);
	%>
	<table class="table">
		<tbody>
		<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>폰</td>
			</tr>
			<%
			for (MemberVO mvo : list) {
			%>
			<tr>
				<td><%=mvo.getMemberId()%></td>
				<td><%=mvo.getMemberName()%></td>
				<td><%=mvo.getPhone()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>



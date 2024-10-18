<%@page import="com.yedam.service.MemberServiceImpl"%>
<%@page import="com.yedam.service.MemberService"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- MVC 디자인: View(JSP페이지) , Model(DB처리) , 컨트롤 -->
	<!-- Expression Language : EL -->
	<!--  jsp action tag -->
	<!--  jsp Standard Tag Library : JSTL-->

	<P>${logId }</P>
	<c:set var="name" value="Hong"></c:set>
	<c:out value="홍길동"></c:out>

	<c:set var="age" value="60"></c:set>
	<c:if test="${age>=20 }">
		<p>성년입니다.</p>
	</c:if>

	<c:choose>
		<c:when test="${age>=60 }">
			<p>노인</p>
		</c:when>
		<c:when test="${age>=20 }">
			<p>성인</p>
		</c:when>
		<c:otherwise>
			<p>미성년</p>
		</c:otherwise>
	</c:choose>
	
	<c:forEach var="i" begin="1" end="5" step="2">
	<p>i의 값은 ${1 }입니다.</p>
	</c:forEach>
	
	<c:set var="page" value="boardList.do"></c:set>
	<jsp:forward page="${page }"></jsp:forward>
</body>
</html>
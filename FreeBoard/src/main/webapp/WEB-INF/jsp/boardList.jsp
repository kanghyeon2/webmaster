<%@page import="com.yedam.common.PageDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>글목록(boardList.jsp)</h3>
<%
List<BoardVO> list = (List<BoardVO>)request.getAttribute("boardlist");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    PageDTO paging = (PageDTO) request.getAttribute("page");
    String sc = (String) request.getAttribute("searchCondition");
    String kw = (String) request.getAttribute("keyword");
    kw = kw == null ? "" : kw;
%>



<form action = "boardList.do" class="row g-3">
  <div class="col-md-3"> 
    <select name="searchCondition" class="form-select">
      <option selected value="">선택하세요</option>
      <option value="T" <%=(sc != null && sc.equals("T") ? "selected" : "")%> >제목</option>
      <option value="W" >작성자</option>
      <option value="TW">제목 & 작성자</option>
    </select>
  </div>
  <div class="col-md-4">
    <input type="text" class="form-control" name="keyword" value='<%=kw %>'>
  </div>
  <div class="col-md-5">
    <button type="submit" class="btn btn-primary">조회</button>
  </div>
</form>


<table class="table">
<thead>
<tr>
<th>글번호</th><th>제목</th><th>작성자</th><th>작성일자</th>
</tr>
</thead>
</tbody>


<c:forEach var="board" items="${boardList }">
     <tr>
    <td><c:out value="${board.boardNo}"/></td>
    <td><a href='board.do?searchCondition=${sc}&keyword=${kw}&page=${paging.page}&bno=${board.boardNo}'>${board.title}</a></td>
    <td><c:out value="${board.writer}"/></td>
    <td><fmt:formatDate value="${board.writeDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
  </tr>
      </c:forEach>
</table>

<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <c:choose>
      <c:when test="${paging.isPrev()}">
        <li class="page-item">
          <a class="page-link" href="boardList.do?searchCondition=${sc}&keyword=${kw}&page=${paging.page - 1}">Previous</a>
        </li>
      </c:when>
      <c:otherwise>
        <li class="page-item disabled">
          <a class="page-link">Previous</a>
        </li>
      </c:otherwise>
    </c:choose>

    <c:forEach var="p" begin="${paging.getStartPage()}" end="${paging.getEndPage()}">
      <c:choose>
        <c:when test="${paging.getPage() == p}">
          <li class="page-item active">
            <span class="page-link">${p}</span>
          </li>	
        </c:when>
        <c:otherwise>
          <li class="page-item">
            <a class="page-link" href="boardList.do?searchCondition=${sc}&keyword=${kw}&page=${p}">${p}</a>
          </li>
        </c:otherwise>
      </c:choose>
    </c:forEach>

    <c:choose>
      <c:when test="${paging.isNext()}">
        <li class="page-item">
          <a class="page-link" href="boardList.do?searchCondition=${sc}&keyword=${kw}&page=${paging.page + 1}">Next</a>
        </li>
      </c:when>
      <c:otherwise>
        <li class="page-item disabled">
          <a class="page-link">Next</a>
        </li>
      </c:otherwise>
    </c:choose>
  </ul>
</nav>
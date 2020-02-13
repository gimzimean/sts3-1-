<%@page import="javax.servlet.jsp.tagext.Tag"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<tr>
	<td colspan="5" align="right">
	<a href="input">글쓰기</a>	
	
	</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>

		<c:forEach items="${list }" var="board">
			<tr>
				<td>${board.bno }</td>
				<td><a href="update?bno=${board.bno}">${board.title }</a></td>
				<td>${board.writer }</td>
				<td><fmt:formatDate value="${board.regdate }"/></td>
				<td>${board.readcount}</td>
			</tr>
		</c:forEach>
		</table>
		<input type="button"
					value="글쓰기" onclick="location.href:'/input'" />
			
		
		
	
</body>
</html>
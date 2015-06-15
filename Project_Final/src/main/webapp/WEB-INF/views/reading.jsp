<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>성적 열람 화면</title>
</head>
<body>
<h1>성적 열람 화면</h1>
<table border=0>
			<tr>
				<th>강좌번호</th>
				<th>과목명</th>
				<th>담당교수</th>
				<th>연도</th>
				<th>학년</th>
				<th>학점</th>
				<th>정원</th>
				<th>평점<th>
			</tr>
		<c:forEach var="list" items="${sugangList}">
			<tr>
				<td><c:out value="${list.gangjwaid }"/></td>
				<td><c:out value="${list.subject}"/></td>
				<td><c:out value="${list.prof}"/></td>
				<td><c:out value="${list.years}"/></td>
				<td><c:out value="${list.grade}"/></td>
				<td><c:out value="${list.score}"/></td>
				<td><c:out value="${list.maxnum}"/></td>
				<td><c:out value="${list.avgscore}"/></td>
			</tr>
		</c:forEach>
	</table>
	<script>
function myFunction() {
    alert("로그아웃을 하겠습니다.");
}
</script>	
<a href="${pageContext.request.contextPath}/loginController/logout" onclick="myFunction()">로그아웃</a>
</body>
</html>
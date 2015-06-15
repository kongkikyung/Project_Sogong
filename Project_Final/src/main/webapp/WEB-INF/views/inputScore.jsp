<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>성적 부여 화면</title>
</head>
<body>
	<table border=0>
			<tr>
				<th>학생</th>
				<th>성적</th>
				<th>성적부여</th>
				<th></th>
			</tr>
			<c:forEach var="list" items="${sugang}">
			<form action="${pageContext.request.contextPath}/gangjwaController/inputresult" method="post">
			<tr>
				<input type="hidden" name="gangjwaid" value="${list.gangjwaid }"/>
				<input type="hidden" name="id" value="${list.id }"/>
				<td><c:out value="${list.name }"/></td>
				<td><c:out value="${list.avgscore }"/></td>
				<td><input type="text" name="inputscore"></td>
				<td><input type="submit" value="성적 부여"/></td>
			</tr>
			</form>
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
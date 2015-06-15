<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>성적 부여 화면 메인</title>
</head>
<body>
<h1>성적 부여 화면 메인</h1>
	<table border=0>
			<tr>
				<th>강좌번호</th>
				<th>과목명</th>
				<th>개설년도</th>
				<th>학년</th>
				<th>정원</th>
				<th>학점</th>
			</tr>
		<c:forEach var="list" items="${gangjwalist}">
			<tr>
				<td><c:out value="${list.gangjwaid }"/></td>
				<td><c:out value="${list.subject}"/></td>
				<td><c:out value="${list.years}"/></td>
				<td><c:out value="${list.grade }"/></td>
				<td><c:out value="${list.maxnum }"/></td>
				<td><c:out value="${list.score }"/></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	성적을 부여할 과목의 강좌번호를 입력해주세요<br>
	<form action="${pageContext.request.contextPath}/gangjwaController/findGangjwa.do" method="post">
		<input type="text" name="gangjwaid">
		<input type="submit" value="성적 부여하기">
	</form>
	<script>
function myFunction() {
    alert("로그아웃을 하겠습니다.");
}
</script>	
<a href="${pageContext.request.contextPath}/loginController/logout" onclick="myFunction()">로그아웃</a>
</body>
</html>
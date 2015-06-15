<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>강좌 리스트</h1>
	
	<table border=0>
			<tr>
				<th>강좌번호</th>
				<th>과목명</th>
				<th>담당교수</th>
				<th>연도</th>
				<th>학년</th>
				<th>학점</th>
				<th>정원</th>
				<th>신청하기<th>
			</tr>
		<c:forEach var="list" items="${gangjwalist}">
		<form action="${pageContext.request.contextPath}/sugangController/sincheong" method="post">
			<input type="hidden" name="gangjwaid" value="${list.gangjwaid }"/>
			<input type="hidden" name="id" value="${userSession.userID }"/>
			<input type="hidden" name="subject" value="${list.subject }"/>
			<input type="hidden" name="name" value="${list.name }"/>
			<input type="hidden" name="years" value="${list.years }"/>
			<input type="hidden" name="grade" value="${list.grade }"/>
			<input type="hidden" name="score" value="${list.score }"/>
			<input type="hidden" name="maxnum" value="${list.maxnum }"/>
			<input type="hidden" name="userName" value="${userName }"/><br>
			<tr>
				<td><c:out value="${list.gangjwaid }"/></td>
				<td><c:out value="${list.subject}"/></td>
				<td><c:out value="${list.name}"/></td>
				<td><c:out value="${list.years}"/></td>
				<td><c:out value="${list.grade}"/></td>
				<td><c:out value="${list.score}"/></td>
				<td><c:out value="${list.maxnum}"/></td>
				<td><input type="submit" value="신청"></td>
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
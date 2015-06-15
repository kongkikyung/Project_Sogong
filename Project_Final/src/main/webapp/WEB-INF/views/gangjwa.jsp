<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>강좌 개설 화면</h1>
	<form action="${pageContext.request.contextPath}/gangjwaController/gaeseol" method="post">
		강좌번호 <input type="text" name="gangjwaid"><br>
		과목명 <input type="text" name="subject"><br>
		연도 <input type="text" name="years"><br>
		학년 <input type="text" name="grade"><br>
		정원<input type="text" name="maxnum"><br>
		학점<input type="text" name="score"><br>
		<input type="hidden" name="name" value="${userName }"/><br>
		<input type="submit" value="과목 개설"><br>
	</form>
	<script>
function myFunction() {
    alert("로그아웃을 하겠습니다.");
}
</script>	
<a href="${pageContext.request.contextPath}/loginController/logout" onclick="myFunction()">로그아웃</a>
</body>
</html>
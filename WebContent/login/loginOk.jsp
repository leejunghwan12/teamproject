<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="MypageController?id=${accountInfo.id}">
		&nbsp;${sessionScope.accountInfo.name }님's Page &nbsp;|</a>
	<a href="LogoutController">&nbsp;로그아웃 </a>

</body>
</html>
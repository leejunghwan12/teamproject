<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="MypageController?id=${info.j_id }" name="myForm"
		method="post">
		<table class="ozMypage">
			<tr>
				<td colspan="2" id="ozMypageT">My Page</td>
			</tr>
			<tr>
				<td>NAME</td>
				<td>${info.j_name }</td>
			</tr>
			<tr>
				<td>ID</td>
				<td><input name="id" value="${info.j_id }" type="hidden">${info.j_id }</td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input name="pw" type="password"></td>
			</tr>
			<tr>
				<td>BIRTH</td>
				<td>${info.j_birth }</td>
			</tr>
			<tr>
				<td>GENDER</td>
				<td>${info.j_gender}</td>
			</tr>
			<tr>
				<td>PHONE NUMBER</td>
				<td>${info.j_phoneNum}</td>
			</tr>
			<tr>
				<td>ADDRESS</td>
				<td>${info.j_add }</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button onclick="return ChangeInfo('${db_pw}')">수정</button>
					 <%-- <button onclick="DeleteInfo(${db_pw})">삭제</button> --%>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
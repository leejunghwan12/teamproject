<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<br>


	<form action="JoinController" name="myForm" method="post"
		onsubmit="return check()">
		<table class="ozJoin">
			<tr>
				<td colspan="2" id="ozJoinT">Join</td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><input name="name"></td>
			</tr>
			<tr>
				<td>ID</td>
				<td><input name="id" id="id" onclick="idCheck();"
					placeholder="영문+숫자"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input name="pw" type="password"></td>
			</tr>
			<tr>
				<td>PW 확인</td>
				<td><input name="pw2" type="password"></td>
			</tr>
			<tr>
				<td>BIRTH</td>
				<td><select name="birth_y" required="required">
						<optgroup label="년">
							<c:forEach var="i" begin="0" end="${2021-1950}">

								<c:set var="yearOption" value="${2021-i}" />

								<option value="${yearOption}">${yearOption}</option>
							</c:forEach>
						</optgroup>
				</select>년 <select name="birth_m" required="required">
						<optgroup label="월">
							<c:forEach begin="1" end="12" var="mm">
								<option value=${mm }>${mm}</option>
							</c:forEach>
						</optgroup>
				</select>월 <select name="birth_d" required="required">
						<optgroup label="일">
							<c:forEach begin="1" end="31" var="dd">
								<option value=${dd }>${dd}</option>
							</c:forEach>
						</optgroup>
				</select>일</td>
			</tr>
			<tr>
				<td>GENDER</td>
				<td><input name="gen" type="radio" value="male">남성 <input
					name="gen" type="radio" value="female">여성</td>
			</tr>
			<tr>
				<td>PHONENUMBER</td>
				<td><input class="phoneNum" name="phoneNum_f" value="010">
					- <input class="phoneNum" name="phoneNum_s"> - <input
					class="phoneNum" name="phoneNum_t"></td>
			</tr>
			<tr>
				<td>ADDRESS</td>
				<td><input name="add" placeholder="ex)서울특별시 종로구"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button onclick="location.href='JoinController'">가입</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
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

	<h1>My Page</h1>
	<form action="ChangeInfoController" method="post">
		<table class="ozMypage">
			<tr>
				<td>NAME</td>
				<td><input name="name" value="${sessionScope.accountInfo.name }"
					readonly="readonly"></td>
			</tr>
			<tr>
				<td>ID</td>
				<td><input name="id" value="${sessionScope.accountInfo.id }" readonly="readonly"></td>
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
				</select>년 <select name="birth_m">
						<c:forEach var="mm" begin="1" end="12">
							<option value="${mm}">${mm}</option>
						</c:forEach>
				</select>월 <select name="birth_d">
						<c:forEach var="dd" begin="1" end="31">
							<option value="${dd}">${dd}</option>
						</c:forEach>
				</select>일</td>
			</tr>
			<tr>
				<td>GENDER</td>
				<td><input name="gen" type="radio" value="male">남성 <input
					name="gen" type="radio" value="female">여성</td>
			</tr>
			<tr>
				<td>PHONENUMBER</td>
				<td><input class="phoneNum" name="phoneNum_f" value="${phoneNum_f}">-
				<input class="phoneNum" name="phoneNum_s" value="${phoneNum_s}">-
				<input class="phoneNum" name="phoneNum_t" value="${phoneNum_t}">
				</td>
			</tr>
			<tr>
				<td>ADDRESS</td>
				<td><input name="add" value="${sessionScope.accountInfo.add}"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button onclick=>수정</button>
					<!-- <button onclick="location.href='DeleteInfoController'">삭제</button> -->
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
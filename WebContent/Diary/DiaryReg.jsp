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

	<form action="DiaryRegController" method="post"
		enctype="multipart/form-data">
		<table class="kimR1">
			<tr>
				<td colspan="2" align="center" class="kimTi1">오조의 기록</td>
			</tr>
			<tr>
				<td>Title</td>
				<td><input name="title"></td>
			</tr>
			<tr>
				<td>Story</td>
				<td><textarea rows="" cols="" name="story"></textarea></td>
			</tr>
			<tr>
				<td>Img</td>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td> <input type="hidden" name="writer" value="${ accountInfo.id}"> </td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button>등록</button>
				</td>
			</tr>
		</table>
	</form>

	<c:forEach var="d" items="${diarys }">
		<table class="kimReg2">
			<tr>
				<td>Title</td>
				<td class="kimTd1">${d.d_title}</td>
			</tr>
			<tr>
				<td>Story</td>
				<td class="kimTd1">${d.d_story}</td>
			</tr>
			<tr>
				<td id="kimTd2" rowspan="4"><img src="../Diary/img/${m.m_img}"
					width="100px"></td>
			</tr>
			<tr>
				<td>
					<button
						onclick="location.href='DiaryUpdateController?no=${d.d_no}'">
						수정</button>
				</td>
				<td>
					<button onclick="DiaryDel('${d.d_no}');">삭제</button>
				</td>
			</tr>

		</table>

	</c:forEach>
</body>
</html>
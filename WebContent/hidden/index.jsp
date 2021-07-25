<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="index.css">
</head>
<body>

	<table border="1">
		<tr>
			<td align="right"><jsp:include page="${loginPage }"></jsp:include>
			 ${r } </td>
		</tr>
	</table>

	<table border="1">
		<tr>
			<td><a href="HC">logo</a></td>
			<td><a href="PlannerController">Planner</a></td>
			<td><a href="DiaryController">Diary</a></td>
			<td><a href="ListController">List</a></td>
			<td><a href="GalleryController">Gallery</a></td>
			<td><a href="ETCController">ETC</a></td>
		</tr>
		<tr>
			<td colspan="6">
				<table>
					<tr>
						<td><jsp:include page="${contentPage}"></jsp:include></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>
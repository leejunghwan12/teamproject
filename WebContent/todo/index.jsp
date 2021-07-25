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


	<table class="leeTbl">

		<tr>
			<td colspan="2" align="right"><a href="TodoRegController">등록</a></td>
		</tr>


		<tr>
			<td style="border: 1px solid RGB(40, 181, 175);" class="leeTodo1">Todo</td>
			<td style="border: 1px solid RGB(255, 126, 64);" class="leeDone1">Done</td>

		</tr>
		
		<tr>

			<td style="border: 1px solid RGB(40, 181, 175);" class="leeTodo2"
				valign="top">
						<jsp:include page="${todoPage}"></jsp:include>
			</td>

			<td style="border: 1px solid RGB(255, 126, 64);" class="leeDone2"
				valign="top"><jsp:include page="${donePage}"></jsp:include></td>
		</tr>








	</table>

</body>
</html>
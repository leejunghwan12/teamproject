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
	<form action="TodoRegController" name="todoReg" method="post"
		onsubmit="return call()">
		<table class="leeregTbl">



			<tr>
				<td class="leeregTd" width="100px">같이 할 일</td>
				<td align="center"><input name="todo"
					style="text-align: center; width: 250px;"
					placeholder="친구와 같이 할 일을 써주세요"></td>
			</tr>




			<tr>
				<td class="leeregTd">우선순위</td>
				<td align="center">1 <input name="priority" type="radio"
					checked="checked" value="1"> 2 <input name="priority"
					type="radio" value="2"> 3 <input name="priority"
					type="radio" value="3"></td>
			</tr>

			<tr>
				<td class="leeregTd">누구랑?</td>
				<td id="names" align="center" width="330px"><c:forEach var="n"
						items="${namelist }">
						<c:if test="${n.name ne 'Admin'}">
					
					${n.name}<input name="who" type="checkbox" value="${n.name}">
						</c:if>

					</c:forEach></td>
			</tr>


			<tr>
				<td colspan=100% align="center">
					<button>등록</button>
				</td>
			</tr>

		</table>

	</form>
</body>
</html>
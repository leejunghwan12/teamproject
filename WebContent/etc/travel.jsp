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


	<h1>여행지 추천받기</h1>
	<table class="leeTravel3">
		
		<c:if test="${accountInfo.id eq 'Admin'}">
			<tr>
				<td colspan="4" align="right">
					<button onclick="location.href='Travel_UpdateController'">등록</button>
				</td>
			</tr>
		</c:if>

		<tr>
			<td style="border: 1px solid RGB(40, 181, 175);" height="200px"
				width="200px">쉴수있는 여행지</td>

			<td style="border: 1px solid RGB(40, 181, 175);" height="200px"
				width="200px">활동적인 여행지</td>

			<td style="border: 1px solid RGB(40, 181, 175);" height="200px"
				width="200px">번화한 여행지</td>

			<td style="border: 1px solid RGB(40, 181, 175);" height="200px"
				width="200px">감성적인 여행지</td>


		</tr>

		<tr align="center">
			<td><button onclick="location.href='Travel_RelController'">Start!
				</button></td>
			<td>
				<button onclick="location.href='Travel_ActController'">Start!
				</button>
			</td>
			<td>
				<button onclick="location.href='Travel_HotController'">Start!
				</button>
			</td>
			<td><button onclick="location.href='Travel_SenController'">Start!
				</button></td>
		</tr>



	</table>


</body>
</html>
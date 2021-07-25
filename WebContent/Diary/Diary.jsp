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

<h1>DIARY</h1>
	<form action="DiaryRegController" method="get">
		<table id="kimTb0" width="1000px">
			<tr>
				<td class="kimR1" align="right">
					<button>기록하기</button>
				</td>
			</tr>

		</table>
	</form>
	<form action="DiaryRegController" method="post"
		enctype="multipart/form-data">

		<table id="kimTb1">
			<tr>
				<td class="kimTi1" colspan="2">오조의 일상~</td>

			</tr>

			<c:choose>
				<c:when test="${ !empty diarys }">

					<c:forEach var="d" items="${diarys }">
						<tr class="kim_tr1">
							<td onclick="location.href='DiaryDetailController?no=${d.d_no }'"
								class="kim_tr1">${d.d_title}</td>
							<td class="kim_tr2" width="100px"><fmt:formatDate
									value="${d.d_date}" dateStyle="short" /></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<td class="kimTd1">게시글이 없습니다.<br></td>
				</c:otherwise>
			</c:choose>
			
		</table>
		<table id="kimTb2">
			<tr>
				<td id="kim_pageTd" align="center"><a
					href="DiaryPageController?p=${1}"> [맨 처음]</a> <c:forEach var="p"
						begin="1" end="${pageCount }">
						<a href="DiaryPageController?p=${p}"> [${p}]</a>
					</c:forEach> <a href="DiaryPageController?p=${pageCount}"> [맨 끝]</a></td>
			</tr>
		</table>

	</form>
</body>
</html>
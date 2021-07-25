<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<c:forEach var="d" items="${donelist }">
		<c:if test = "${fn : contains(d.d_names, accountInfo.name)}">
			
			<table id="mTbl2" >
				<tr>
					<td class="leeTd2" >해야할 일</td>
					<td id="title">${d.d_title}</td>
				</tr>

				<tr>
					<td class="leeTd2">우선순위</td>
					<td id="prior">${d.d_priority }</td>
				</tr>

				<tr>
					<td class="leeTd2">해야할 사람</td>
					<td id="names">${d.d_names }</td>
				</tr>

				<tr style="display: none;">
					<td id="no">${d.d_no }</td>
				</tr>
				
				<tr>
					<td height="40" colspan="2"><button onclick="deleteDone(${d.d_no });">삭제</button> </td>
				</tr>


			</table>
			</c:if>
			
		</c:forEach>
	
	



</body>
</html>
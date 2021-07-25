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

	<form action="ListController" method="post">
		<c:forEach var="t" items="${todolist }">
			<c:if test = "${fn : contains(t.t_names, accountInfo.name)}">
			<table id="mTbl2" >
	
				<tr>
					<td class="leeTd">해야할 일 <input type="hidden" name="title"
						value="${t.t_title}">
					</td>
					<td id="title">${t.t_title}</td>
				</tr>

				<tr>
					<td class="leeTd">우선순위 <input type="hidden" name="prior"
						value="${t.t_priority}">
					</td>
					<td id="prior">${t.t_priority }</td>
				</tr>

				<tr>
					<td class="leeTd">해야할 사람 <input type="hidden" name="names"
						value="${t.t_names}">
					</td>
					<td id="names">${t.t_names }</td>
				</tr>

				<tr style="display: none;">
					<td id="no">${t.t_no }<input type="hidden" name="no"
						value="${t.t_no}">
					</td>
				</tr>
				<tr>
					<td height="40" colspan="2">
						<button>완료</button>
					<button type="button" onclick="deleteTodo(${t.t_no });">삭제</button>
					</td>
				</tr>
			</table>
			</c:if>
		</c:forEach>
	</form>
	
</body>

</html>
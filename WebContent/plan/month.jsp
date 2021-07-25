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

	<h1>PLANNER</h1>
	<table id="">
		<tr>
			<td><input type="button" value="MONTH"
				onclick="location.href='PlannerController?year=${year}&month=${month}'"
				class="sjb1">
		
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="PlannerController?year=${year}&month=${month-1}">◀</a>&nbsp; <b>${year}년&nbsp;&nbsp;${month}월</b>
				<a href="PlannerController?year=${year}&month=${month+1}">&nbsp;▶</a>

				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

				<button
					onclick="window.open('plan/regPlan.jsp', '일정등록', 'top=210, left=450, width=500, height=400');"
					class="sjb1">일정등록</button></td>
				
		</tr>
		
		
	</table>

	<table border="1" id="sjTbl">
		<tr>
			<td class="sjTd1">일</td>
			<td class="sjTd1">월</td>
			<td class="sjTd1">화</td>
			<td class="sjTd1">수</td>
			<td class="sjTd1">목</td>
			<td class="sjTd1">금</td>
			<td class="sjTd1">토</td>
		</tr>

		<tr>
			<c:forEach begin="1" end="${week-1}">
				<td class="sjTd">&nbsp;</td>
			</c:forEach>

			<c:forEach var="i" begin="1" end="${endDay}">
				<c:set var="j" value="${week+i}" />
				<c:if test="${j % 7 == 2}">
					<tr>
				</c:if>
				<c:choose>
					<c:when test="${j % 7 == 2}">
						<td class="sjTd">${i}&nbsp;<br> <c:forEach
								items="${calenderlist }" var="c">

								<c:if
									test="${c.s_year == year && c.s_month == month && i == c.s_day}">
									<a class="eventN" onclick="updatePlan();" style="background-color: RGB(255, 206, 183);">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${c.e_name }</a>
								</c:if>

								<c:if
									test="${year >= c.s_year && year <= c.e_year 
								&& month >= c.s_month && month <= c.e_month
								&& i > c.s_day && i <= c.e_day}">
									<a class="eventD" onclick="updatePlan();" style="background-color: RGB(255, 206, 183);"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
								</c:if>

							</c:forEach>

						</td>
					</c:when>
					<c:when test="${j % 7 == 1 }">
						<td class="sjTd">${i}&nbsp;<c:forEach
								items="${calenderlist }" var="c">

								<c:if
									test="${c.s_year == year && c.s_month == month && i == c.s_day}">
									<br>
									<a class="eventN" onclick="updatePlan();" style="background-color: RGB(255, 206, 183);">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${c.e_name }</a>
								</c:if>
								<c:if
									test="${year >= c.s_year && year <= c.e_year 
								&& month >= c.s_month && month <= c.e_month
								&& i > c.s_day && i <= c.e_day}">
									<a class="eventD" onclick="updatePlan();" style="background-color: RGB(255, 206, 183);"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
								</c:if>

							</c:forEach>
						</td>
					</c:when>
					<c:otherwise>
						<td class="sjTd">${i}&nbsp;<c:forEach
								items="${calenderlist }" var="c">

								<c:if
									test="${c.s_year == year && c.s_month == month && i == c.s_day}">
									<br>
									<a class="eventN" onclick="updatePlan();" style="background-color: RGB(255, 206, 183);">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${c.e_name }</a>
								</c:if>
								<c:if
									test="${year >= c.s_year && year <= c.e_year 
								&& month >= c.s_month && month <= c.e_month
								&& i > c.s_day && i <= c.e_day}">
									<a class="eventD" onclick="window.open('plan/plan.jsp', '일정수정', 'top=210, left=450, width=500, height=400');" style="background-color: RGB(255, 206, 183);"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
								</c:if>
							</c:forEach>

						</td>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</tr>
	</table>



</body>
</html>
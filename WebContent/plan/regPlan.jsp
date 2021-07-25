<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/plan.css">
<script type="text/javascript" src="../js/plan.js"></script>
</head>
<body>

	<h1 align="center">일정등록</h1>
   <form action="../PlanRegController" name="myForm">
      <table id="sjReg">
         <tr>
            <td class="sjReg1" align="center"><br>이름</td>
            <td><br>&nbsp;&nbsp;<input name="name"></td>
         </tr>
         <tr>
            <td class="sjReg1" align="center" ><br>시작</td>
            <td><br>&nbsp;&nbsp;<input name="startDate" type="date"></td>
         </tr>
         <tr>
            <td class="sjReg1" align="center" ><br>종료</td>
            <td><br>&nbsp;&nbsp;<input name="endDate" type="date"></td>
         </tr>
         <tr>
            <td>
            </td>
            <td align="left">
               <br>&nbsp;&nbsp;&nbsp;&nbsp;<button class="sjb1" onclick="regPlan()">등록</button>
            </td>
         </tr>
      </table>
   </form>

</body>
</html>
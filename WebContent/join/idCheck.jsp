<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/join_login.css">
<script type="text/javascript" src="js/join.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

${r}

<table class="Joincheck">
      <tr>
      <td>
      <c:if test="${okok != 1 }">
         <input name="id" id="checkId">
      </c:if>
      <c:if test="${okok == 1 }">
      <input name="id" id="checkId" value="${iid }">
      </c:if>
      <button onclick="checkId2();">중복확인</button></td>
      </tr>
      <tr >
         <td><button onclick="idDelivery()">이 ID 사용</button>
      </tr>
   </table>


</body>
</html>
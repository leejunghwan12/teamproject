<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>선택된 여행지</h1>

   <table style="border: 1px solid RGB(255, 126, 64);" class="leeEtcR">
   
   
      <tr><td><br><img src="img/${r.t_title} " ></td></tr>
      <tr><td>${r.t_titleName}</td></tr>

      
      <tr><td><br><img src="img/${r.t_restaurant} "></td></tr>
      <tr><td>${r.t_restaurantName}</td></tr> 
      
      <tr><td><br><img src="img/${r.t_famous}"></td></tr>
      <tr><td>${r.t_famousName} </td></tr>
      <tr><td> <br> </td></tr>

   </table>
   
   
<table class="leeTravel6">
   <tr>
   <td>
   <button value="한번 더 해보기" onclick="history.back(-2);">한번 더 해보기</button>
   <a href="TravelController"><button >여행지 다시 선택</button></a>
</td>
</tr>
</table>


</body>
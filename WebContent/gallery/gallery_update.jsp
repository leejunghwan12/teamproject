<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="GalleryController">
		<table id="wonBT" width="1080">
		<tr>
		<td align="right">
		<button> 목록으로 </button>
	</table>
</form>


<form action="PhotoUpdateController?no=${photo.p_no }" method="post" enctype="multipart/form-data" >
<table class="wonTbl5">
<tr>
<td colspan="2" width="900" height="50" class="wonTd51">수정페이지</td>
</tr>

<tr>
<td width="80" height="50" class="wonTd5">글 번호</td>
    <td><input readonly="readonly" value="${photo.p_no }"></td> 
 
</tr>

<tr>
<td width="80" height="50" class="wonTd5"> 작성날짜 </td>
<td><fmt:formatDate value="${photo.p_date}"
type="both" dateStyle="short" timeStyle="short" /> </td>
</tr>

<tr>
<td width="80" height="50" class="wonTd5">제목</td>
 <td><input name="title" value="${photo.p_title }"></td>
</tr>

<tr>
<td width="80" height="300" class="wonTd5"> 사진 </td>
     <td><input name="file" type="file" value="${photo.p_img}"></input></td>
</tr>


<tr>
<td colspan="2" height="50" align="right">
<button > 수정완료 </button>
</td>

</tr>

</table>

   </form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<button> 등록취소 </button>
	</table>
</form>

<form action="PhotoRegController" method="post"
		enctype="multipart/form-data">
		<table class="wonTbl3" width="500">
			<tr>
			<td width="100" height="50" colspan="2" id="wonTd3"> 사진 등록하기 </td>
			</tr>
		
			<tr>
				<td width="100" height="50">사진제목</td>
				<td><input name="title"></td>
			</tr>
			<tr>
				<td width="100" height="50">사진</td>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
				<button>업로드</button></td>
			</tr>
		</table>
	</form>
	<br>
	<br>
	
	
	
</body>
</html>
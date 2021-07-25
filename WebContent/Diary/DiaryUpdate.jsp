<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="DiaryUpdateController" method="post"
		enctype="multipart/form-data" >
		<table >
			<tr>
			<td colspan="2" align="center" class="kimTi1">오조의 기록</td>
		</tr>
			<tr>
				<td>Title</td>
				<td id="kimTb4"><input name="title" value="${d.d_title}"></td>
			</tr>
			<tr>
				<td>Story</td>
				<td class="kimTb5" align="center" ><textarea name="story"> ${d.d_story }</textarea> </td> 
			</tr>
			<tr>
				<td>Img</td>
				<td id="kimTb4"><input type="file" name="file">
				<input type="hidden" name="file2" value="${d.d_img}">
					<img src="img/${d.d_img}" width="200px"></td>
			</tr>
			<tr>
				<td><input name="no" value=${param.no } type="hidden"></td>
				<td colspan="1" class="kimR1" align="right">
					<button>수정</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
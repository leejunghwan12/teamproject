<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>GALLERY</h1>
<form action="GalleryController2" method="post"	enctype="multipart/form-data">
		
		<table id="wonBT" width="1080">
		<tr>
		<td align="right">	${r }
		<button> 글쓰기 </button>
	</table>
</form>


<table id="wonTbl1">
		<c:choose>
		<c:when test="${ not empty photos}">
		
		<c:forEach var="p" items="${photos }">
				<td class="wonTd1" onclick="location.href='GalleryDetailController?no=${p.p_no }'">
				<img src="img/${p.p_img }"><br>
				${p.p_title}</td>
				</c:forEach>
				
			</c:when>
			
		<c:otherwise>
		<td>게시글이 없습니다.<br></td>
		</c:otherwise>
		</c:choose>
		
	</table>


	<table id="wonTbl2">
	
		<c:choose>
		<c:when test="${ not empty photos}">
		<tr><td>
			<a href="GalleryPageController?p=1"> ◀	</a>		
			
			<c:forEach var="p" begin="1" end="${pageCount }">
			<a href="GalleryPageController?p=${p}"> [${p }]	</a>		
			</c:forEach>
			
			<a href="GalleryPageController?p=${pageCount}"> ▶	</a>		
			
			</td>
		</tr>
			</c:when>
			
		<c:otherwise>
			
		</c:otherwise>
		</c:choose>
		
	</table>



</body>
</html>
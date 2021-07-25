<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<form action="GalleryController">
		<table id="wonBT" width="1000">
			<tr>
				<td align="right">
					<button>목록으로</button>
		</table>
	</form>

	<table class="wonTbl4">
		<tr>
			<td width="80" height="50" class="wonTd4">글 제목</td>
			<td width="900" height="50">${photo.p_title}</td>
			<td></td>
		</tr>

		<tr>
			<td width="80" height="50" class="wonTd4">작성자</td>
			<td width="900" height="50">${accountInfo.id}</td>
		</tr>


		<tr>
			<td width="80" height="50" class="wonTd4">작성날짜</td>
			<td><fmt:formatDate value="${photo.p_date}" type="both"
					dateStyle="long" timeStyle="short" /></td>
		</tr>

		<tr>
			<td width="80" height="300" class="wonTd4">내용</td>
			<td><br> <img src="img/${photo.p_img }"><br> <br></td>
		</tr>

		<tr>
			<td align="right" colspan="2">
			
			<a href="PhotoUpdateController?no=${photo.p_no}">
				
				<button>
						수정</button></a>
				<button onclick="PhotoDel(${photo.p_no});">삭제</button>
				
				</td>
		</tr>

	</table>


	<table class="comment" width="850">
		<c:forEach var="c" items="${commentlist}">
			<tr>
				<td rowspan="2" class="commentTd">${c.c_id}</td>

				<td colspan="2">${c.c_text}</td>
			</tr>
			<tr>
				<td class="commentDay"><fmt:formatDate value="${c.c_rdate}"
						type="both" dateStyle="short" timeStyle="short" /></td>


				<td width="120">
					<div id="btn" style="text-align: center;">
						<!-- 댓글 작성자만 수정, 삭제 가능하도록 -->
						<c:if test="${c.c_id == accountInfo.id}">
							<button
								onclick="commentUpd('${photo.p_no}','${c.c_no}','${c.c_text}');">수정</button>
							<button onclick="commentDel('${photo.p_no}','${c.c_no}',);">삭제</button>
						</c:if>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="3"><br></td>
			</tr>

		</c:forEach>


		<tr>
			<td class="commentTd">댓글</td>

			<td colspan="2">
				<form action="CommentRegController">
					<input type="hidden" value="${accountInfo.id}" name="c_id">
					<input type="hidden" value="${accountInfo.id}" name="name">
					<input type="hidden" value="${photo.p_no}" name="c_board">
					<input type="hidden" value="${photo.p_no }" name="no">
					<textarea class="commentreg" name="c_text"></textarea>
					
					<tr>
					<td colspan="3" align="right">
					<button>등록</button>
					</td>
					</tr>
				</form>
			</td>
		</tr>
		<tr>
			<td><br> <br> <br> <br> <br></td>
		</tr>



	</table>





</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jsp/DiaryDel.js"></script>
</head>
<body>

	<table class="kimDet1">
		<tr>
			<td colspan="2" align="center" class="kimTi3">오조의 기록</td>
		</tr>
		<tr>
			<td class="kimTi1">No.</td>
			<td class="kimTi2">${d.d_no}</td>
		</tr>
		<tr>
			<td class="kimTi1">Title</td>
			<td class="kimTi2">${d.d_title}</td>
		</tr>
		<tr>
			<td class="kimTi1">Img</td>
			<td class="kimTi2"><img src="img/${d.d_img}" width="300px">
			</td>
		</tr>
		<tr>
			<td class="kimTi1">Story</td>
			<td class="kimTi2">${d.d_story}</td>
		</tr>
		<tr>
			<td class="kimTi1">Date</td>
			<td class="kimTi2">${d.d_date}</td>
		</tr>
		<tr>
			<td class="kimTi1">Writer</td>
			<td class="kimTi2">${d.d_writer}</td>
		</tr>
		<tr>
			<td colspan="2" align="right" class="kimR1"><a
				href="DiaryController">
					<button>목록으로</button>

			</a> <c:if test="${d.d_writer == accountInfo.id}">
					<a href="DiaryUpdateController?no=${d.d_no}">
						<button onclick="DiaryReg(${r})">수정</button>
					</a>
					<button onclick="DiaryDel(${d.d_no})">삭제</button>
				</c:if></td>
		</tr>
	</table>

	<table class="comment">
		<c:forEach var="c" items="${commentlist2}">
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
								onclick="commentDUpd('${d.d_no}','${c.c_no}','${c.c_text}');">수정</button>
							<button onclick="commentDDel('${d.d_no}','${c.c_no}',);">삭제</button>
						</c:if>
					</div>
				</td>
			<tr>
				<td colspan="3"><br></td>
			</tr>
		</c:forEach>

		<tr>
			<td class="commentTd">댓글</td>

			<td colspan="2">
				<form action="CommentDRegController">
					<input type="hidden" value="${accountInfo.id}" name="c_id">
					<input type="hidden" value="${accountInfo.id}" name="name">
					<input type="hidden" value="${d.d_no}" name="c_board"> <input
						type="hidden" value="${d.d_no}" name="no">
					<textarea class="commentreg" name="c_text"></textarea>
					<tr>
						<td colspan="3" align="right">
							<button>등록</button>
						</td>
					</tr>

				</form>
			</td>
		</tr>



	</table>

</body>
</html>
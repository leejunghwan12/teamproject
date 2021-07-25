<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
.hidden {
	display: none;
}
</style>

<body>
<h1> 여행지 등록하기 </h1>
	<form action="Travel_RelUpdController" method="post" enctype="multipart/form-data">
		<table  class="leeTravel4">
			<tr>
			<td class="leeTravel5" colspan="4"> 쉴수있는 여행지</td>
			</tr>
			<tr>
				<td>플레이스 넘버</td>
				<td> <input type="number" name="t_placeNo"></td>
				<td>여행지사진</td>
				<td> <input name="t_title" type="file"></td>
				</tr>
				<tr>
				<td>여행지제목</td>
				<td> <input name="t_titleName"></td>
				<td>주소</td>
				<td> <input name="t_address"></td>
				</tr>
				<tr>
				<td>레스토랑</td>
				<td> <input name="t_restaurant" type="file"></td>
				<td>레스토랑 이름</td>
				<td> <input name="t_restaurantName"></td>
				</tr>
				<tr>
				<td>관광지</td>
				<td> <input name="t_famous" type="file"></td>
				<td>관광지 이름</td>
				<td> <input name="t_famousName"></td>
				<tr>
				<td class="leeTravel5" colspan="4">  <button> 등록 </button> </td>	

			</tr>
		</table>
	</form>
			<!-- 나중에 클래스 히든으로 -->
	<form action="Travel_ActUpdController" method="post" enctype="multipart/form-data">
		<table class="leeTravel4">
		<tr>
			<td class="leeTravel5" colspan="4"> 활동적인 여행지</td>
			</tr>
			<tr>
				<td>플레이스 넘버</td>
				<td> <input type="number" name="t_placeNo"></td>
				<td>여행지사진</td>
				<td> <input name="t_title" type="file"></td>
				</tr>
				<tr>
				<td>여행지제목</td>
				<td> <input name="t_titleName"></td>
				<td>주소</td>
				<td> <input name="t_address"></td>
				</tr>
				<tr>
				<td>레스토랑</td>
				<td> <input name="t_restaurant" type="file"></td>
				<td>레스토랑 이름</td>
				<td> <input name="t_restaurantName"></td>
				</tr>
				<tr>
				<td>관광지</td>
				<td> <input name="t_famous" type="file"></td>
				<td>관광지 이름</td>
				<td> <input name="t_famousName"></td>
				<tr>
				<td class="leeTravel5" colspan="4">   <button> 등록 </button> </td>
			</tr>
		</table>
		
		</form>

	<form action="Travel_HotUpdController" method="post" enctype="multipart/form-data">
		<table class="leeTravel4">
		<tr>
			<td class="leeTravel5" colspan="4"> 번화한 여행지</td>
			</tr>
			<tr>
				<td>플레이스 넘버</td>
				<td> <input type="number" name="t_placeNo"></td>
				<td>여행지사진</td>
				<td> <input name="t_title" type="file"></td>
				</tr>
				<tr>
				<td>여행지제목</td>
				<td> <input name="t_titleName"></td>
				<td>주소</td>
				<td> <input name="t_address"></td>
				</tr>
				<tr>
				<td>레스토랑</td>
				<td> <input name="t_restaurant" type="file"></td>
				<td>레스토랑 이름</td>
				<td> <input name="t_restaurantName"></td>
				</tr>
				<tr>
				<td>관광지</td>
				<td> <input name="t_famous" type="file"></td>
				<td>관광지 이름</td>
				<td> <input name="t_famousName"></td>
				<tr>
				<td class="leeTravel5" colspan="4">   <button> 등록 </button> </td>
			</tr>
		</table>
		
	</form>

	<form action="Travel_SenUpdController" method="post" enctype="multipart/form-data">
		<table class="leeTravel4">
		<tr>
			<td class="leeTravel5" colspan="4"> 감성적인 여행지</td>
			</tr>
			<tr>
				<td>플레이스 넘버</td>
				<td> <input type="number" name="t_placeNo"></td>
				<td>여행지사진</td>
				<td> <input name="t_title" type="file"></td>
				</tr>
				<tr>
				<td>여행지제목</td>
				<td> <input name="t_titleName"></td>
				<td>주소</td>
				<td> <input name="t_address"></td>
				</tr>
				<tr>
				<td>레스토랑</td>
				<td> <input name="t_restaurant" type="file"></td>
				<td>레스토랑 이름</td>
				<td> <input name="t_restaurantName"></td>
				</tr>
				<tr>
				<td>관광지</td>
				<td> <input name="t_famous" type="file"></td>
				<td>관광지 이름</td>
				<td> <input name="t_famousName"></td>
				<tr>
				<td class="leeTravel5" colspan="4">   <button> 등록 </button> </td>

			</tr>
		</table>
	</form>

	
	


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<title>더치페이 계산</title>
<script src="goDutch.js"></script>

<body>

	<h1>더치페이 계산기</h1>
	<form action="DutchpayRController">
	

			<table class="leedutch1">
				<tr>
					<td>누구 ?</td>
				</tr>
				<tr>
					<td>선진 <input name="who" type="checkbox" checked="checked"
						value="선진"> 수민 <input name="who" type="checkbox"
						value="수민"> 세영 <input name="who" type="checkbox"
						value="세영"> 정환 <input name="who" type="checkbox"
						value="정환"></td>
				</tr>
				<tr>
					<td>
						<button>누가 걸리나 ?</button>
					</td>
				</tr>
				<tr>
					<td>▼걸린사람▼ </td>
					</tr>
					<tr>
					<td>${who } </td>
				</tr>

			</table>
	</form>

<h2>▼</h2>
<h2>▼</h2>



	<table class="leedutch2">
		<tr>
			<td>
					총액 : 
				</td>
				<td><input type="number" placeholder="숫자만입력하시오" id="amount">
				</td>
				</tr>
				<tr>
				<td>
					사람 수 : </td>
					<td>
					<input type="number" placeholder="숫자만입력하시오" id="num">
				</td></tr>
				<tr><td colspan="2">
					 <button onclick="getResult('${who }');"> 내야할 돈 </button>
				</td></tr>
		
		<tr>
			<td colspan="2">
				<p id="result"></p>
			</td>
		</tr>
	</table>


</body>
</html>
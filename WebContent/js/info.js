function ChangeInfo(n) {
	let pw = document.myForm.pw;
	let id = document.myForm.id;

	if (n == pw.value) {
		
		location.href = 'ChangeInfoController?id=' + id.value;

	} else {
		pw.value = '';
		pw.focus;
		alert("비밀번호를 확인해주세요")

		return false;
		//location.href="MypageController?id="+id.value;


	}
};

function DeleteInfo(n) {

	let pw = document.myForm.pw;
	let id = document.myForm.id;

	if (n == pw.value) {
		let ok = confirm("삭제하시겠습니까?")

		location.href = 'DeleteInfoController?id=' + id.value;
		
	} else {
		pw.value = '';
		pw.focus;
		alert("비밀번호를 확인해주세요")
		
		return false;
	}




}
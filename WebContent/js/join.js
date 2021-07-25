function check() {
	let nInput = document.myForm.name;
	let iInput = document.myForm.id;
	let pInput = document.myForm.pw;
	let p2Input = document.myForm.pw2;
	let bInput = document.myForm.birth;
	let gInput = document.myForm.gen;
	let phoneInput = document.myForm.phoneNum;
	let aInput = document.myForm.add;

	if (isEmpty(nInput) || lessThan(nInput, 2)) {

		alert("NAME을 확인하세요")

		nInput.value = "";
		nInput.focus;

		return false;
	}

	if (isEmpty(iInput)) {
		alert("ID를 확인하세요")

		iInput.value = "";
		iInput.focus;

		return false;
	}

	if (isEmpty(pInput) || notEquals(pInput, p2Input)) {
		alert("PW를 확인하세요")

		p2Input.value = "";
		p2Input.focus;

		return false;
	}

	if (isEmpty(bInput)) {
		alert("BIRTH를 확인하세요")

		bInput.value = "";
		bInput.focus;

		return false;
	}

	if (isEmpty(gInput)) {
		alert("GENDER를 확인하세요")

		gInput.value = "";
		gInput.focus;

		return false;
	}

	if (isEmpty(phoneInput)) {
		alert("PHONENUMBER를 확인하세요")

		phoneInput.value = "";
		phoneInput.focus;

		return false;
	}

	if (isEmpty(aInput)) {
		alert("ADDRESS를 확인하세요")

		aInput.value = "";
		aInput.focus;

		return false;
	}

}


function idCheck() {
	window.open("RedubController", "중복확인", "top=350, left=600, width=300, height=150");
}

function idDelivery() {
	opener.document.getElementById("id").value = document.getElementById("checkId").value;
	self.close();
}



function checkId2() {
	let id = document.getElementById("checkId");
	if(id.value == "") {
		alert("ID를 입력하세요");
		location.href = "RedubController";

	} else {
		location.href = "RedubController?id=" + id.value;
		window.close;
	}
}












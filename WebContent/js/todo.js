
function deleteTodo(n) {


	let ok = confirm('정말 삭제합니까?');

	if (ok) {

		location.href = 'TodoDelController?no=' + n;


	}

		
}





function deleteDone(n) {


	let ok = confirm('정말 삭제합니까?');

	if (ok) {

		location.href = 'DoneDelController?no=' + n;


	}


	
}
function isEmpty(input) {
		return !input.value; // 값이 없다.
	}

function call() {

		let todoInput = document.todoReg.todo;

		if (isEmpty(todoInput)) {
			alert('해야할 일을 입력해주세요!');
			todoInput.value = "";
			todoInput.focus();
			return false;
		}
		var box_count = 0;
		var checkboxs = document.getElementsByName("who");
		for (var i = 0; i < checkboxs.length; i++)
			if (eval(checkboxs[i].checked) == true) {
				box_count++;
			}
		if (box_count <= 0) {
			alert("친구를 체크해주세요! ");
			return false;
		} 
		return true;
	}

/*
	var chk_box	= document.getElementsByName("who");

	opener.parent.location = '../NameListController?who='+ chk_box;
	window.close();
*/
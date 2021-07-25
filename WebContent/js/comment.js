
function commentDel(n, n2) {


	let ok = confirm('정말 삭제합니까?');

	if (ok) {

		location.href = "CommentDelController?no="+ n +"&no2="+ n2;


	}

		
}


function commentDDel(n, n2) {


	let ok = confirm('정말 삭제합니까?');

	if (ok) {

		location.href = "CommentDDelController?no="+ n +"&no2="+ n2;


	}

		
}

function commentUpd(n,n2,t) {

	let t1 = prompt("수정 할 내용", t);
	location.href = "CommentUpdateController?no="+ n +"&text="+ t1 +"&no2=" + n2;
	
}



function commentDUpd(n,n2,t) {

	let t1 = prompt("수정 할 내용", t);
	location.href = "CommentDUpdateController?no="+ n +"&text="+ t1 +"&no2=" + n2;
	
}
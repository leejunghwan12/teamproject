
function replyDel(n, n2) {


	let ok = confirm('정말 삭제합니까?');

	if (ok) {

		location.href = "GalleryReplyDelController?no="+ n +"&no2="+ n2;


	}

		
}


function replyUpdate(n, t) {

	let t1 = prompt("수정 할 내용", t);
	location.href = "GalleryReplyUpdateController?no="+ n +"&text="+ t1;
	
}
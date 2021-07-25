function PhotoDel(n){
	let ok = confirm('정말 삭제하시겠습니까?');

	if(ok){
		location.href = 'PhotoDelController?no=' + n;
	}
	
}


/**
 * js 파일 홈에 추가해주세요
 */
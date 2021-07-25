function DiaryDel(n){
	
	let ok = confirm('정말 삭제합니까?');
	
	if(ok){
		location.href = 'DiaryDelcontroller?no='+n;
	}
	
}


function regPlan() {

	let n = document.myForm.name;
	let s = document.myForm.startDate;
	let e = document.myForm.endDate;

	alert('등록되었습니다');

	opener.parent.location = '../PlanRegController?name='+n.value+'&startDate='+s.value+'&endDate='+e.value;
	window.close();

}

function UpdatePlan() {

	window.open('UpdatePlanController', '일정수정', 'top=210, left=450, width=500, height=400');
	
}
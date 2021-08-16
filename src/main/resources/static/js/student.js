$(function() {

});

function addList() {
	var form = document.studentForm;
	var ele = document.createElement('input');

	ele.setAttribute('type', 'hidden');
	ele.setAttribute('name', 'add');

	form.appendChild(ele);

	form.submit();
}

function removeList(obj){
	var val = obj.value;
	var form = document.studentForm;
	var ele = document.createElement('input');

	ele.setAttribute('type', 'hidden');
	ele.setAttribute('name', 'remove');
	ele.setAttribute('value', val);

	form.appendChild(ele);

	form.submit();
}
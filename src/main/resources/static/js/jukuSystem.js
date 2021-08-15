$(function(){
	// サイドメニューアコーディオン
	$('.js-menu_item_link').each(function(){
		$(this).on('click', function(){
			$('+.submenu', this).slideToggle();
			return false;
		});
	});

	$("#allCheck").on('click', function(){
		$('input[name="subjects"]').prop('checked', true);
	});

	$("#removeCheck").on('click', function(){
		$('input[name="subjects"]').prop('checked', false);
	});

	$('#target').datepicker();
})

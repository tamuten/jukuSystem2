$(function(){
	// サイドメニューアコーディオン
	$('.js-menu_item_link').each(function(){
		$(this).on('click', function(){
			$('+.submenu', this).slideToggle();
			return false;
		});
	});
})

//导航栏收缩
$('.menu_sil').click(function(){
		$('#box').toggleClass('nepadmin-sidebar-shrink');
	})
//头部选项卡
$('.dang_tabs .nepadmin-tabs-btn').each(function(){
	$(this).click(function(){
		$(this).addClass('nepadmin-tabs-active');
		$(this).siblings().removeClass('nepadmin-tabs-active');
	})
})
//侧边导航
$('.dang_nav li').each(function(){
	$(this).click(function(){
		$(this).siblings().removeClass('layui-nav-itemed');
		$(this).siblings().removeClass('layui-this');
	})
})

$('.dang_input_f').change(function(){
	$(this).siblings('.dang_input').html($(this).val());
})

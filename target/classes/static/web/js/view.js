function aa () {
	var wid = 0;
$('.dang_nav a').each(function() {
	if($(this).attr('href')) {
		var _this = $(this);
		var has = false;
		$(this).click(function(e) {
			//										e.preventDefault();
			//										e.stopPropagation();
			$('.nepadmin-tabs-menu a').each(function() {
				if(_this.attr('href') == $(this).attr('href')) {
					has = true;
					$(this).parents('li').addClass('nepadmin-tabs-active');
					$(this).parents('li').siblings().removeClass('nepadmin-tabs-active');
				}
			});
			if(has == false) {
				$('.nepadmin-tabs-menu li').removeClass('nepadmin-tabs-active');
				var con = '<li data-type="page" class="nepadmin-tabs-btn nepadmin-tabs-active"><a href="' + _this.attr('href') +
					'" target="frame"><i class="bot"></i>' + _this.attr('title') + '<b class="layui-icon nepadmin-tabs-close close"></b></a></li>';
				$('.nepadmin-tabs-menu').append(con);
			};
			wid = 0;
			$('.nepadmin-tabs-menu li').each(function(index) {
				wid = $(this).width() + 30 + wid;
			});
			$('.nepadmin-tabs-menu').width(wid);
		})
	}
});
$('.nepadmin-tabs-menu li').each(function() {
	$(this).click(function() {
		$(this).addClass('nepadmin-tabs-active');
		$(this).siblings().removeClass('nepadmin-tabs-active');
	})
})
$('.nepadmin-tabs-menu .nepadmin-tabs-close').click(function(e) {
	e.preventDefault();
	e.stopPropagation();
	$(this).parents('li').remove();
	wid = 0;
	$('.nepadmin-tabs-menu li').each(function() {
		wid = $(this).width() + 30 + wid;

	});
	$('.nepadmin-tabs-menu').width(wid);
})
var left = 250;
$('#nepadmin-tabs-next').click(function(e) {
	e.preventDefault();
	e.stopPropagation();
	if($('.nepadmin-tabs-menu').width() > ($('.nepadmin-tabs-wrap ').width() - 320)) {
		left = left - ($('.nepadmin-tabs-wrap ').width() - 320) * 0.5;
		$('.nepadmin-tabs-menu')[0].style.left = left + 'px';
		var maxLeft = $('.nepadmin-tabs-menu').width() - ($('.nepadmin-tabs-wrap ').width());
		if(-left > maxLeft) {
			left = -maxLeft;
			$('.nepadmin-tabs-menu')[0].style.left = -maxLeft + 'px';
		}
	};

});
$('#nepadmin-tabs-prev').click(function(e) {
	e.preventDefault();
	e.stopPropagation();
	if(left < 250) {
		left = left + ($('.nepadmin-tabs-wrap ').width() - 320) * 0.5;
		$('.nepadmin-tabs-menu')[0].style.left = left + 'px';
	};
	if(left > 250) {
		left = 250;
		$('.nepadmin-tabs-menu')[0].style.left = left + 'px';
	}
})
}

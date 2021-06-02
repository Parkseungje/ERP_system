$(document).ready(function() {
	$.fn_modal_ready();

	$('.layerPop').hide();
	
//	$('#mask').click(function () {
//		$(this).hide();
//		$('.layerPop').hide();
//	});

});

$.fn_modal_ready = function(){
	/* s:모달팝업*/
//	$('a[name=modal]').click(function(e) {
//		e.preventDefault();
//
//		var id = $(this).attr('href');
//
//		var maskHeight = $(document).height();
//		var maskWidth = $(document).width();
//
//		$('#mask').css({'width':maskWidth,'height':maskHeight});
//
//		$('#mask').fadeIn(200);
//		$('#mask').fadeTo("fast", 0.5);
//
//		var winH = $(window).height();
//		var winW = $(window).width();
//		var scrollTop = $(window).scrollTop();
//
//		$(id).css('top', winH/2-$(id).height()/2+scrollTop);
//		$(id).css('left', winW/2-$(id).width()/2);
//
//		$(".layerPop").hide();
//		$(id).fadeIn(100); //페이드인 속도..숫자가 작으면 작을수록 빨라집니다.
//
//	});

	$('.closePop').click(function (e) {
		e.preventDefault();

		$('#mask').hide();
		$('.layerPop').hide();
	});
	/* e:모달팝업*/
	
	/* s:모달(상단고정)팝업*/
	$('a[name=modal_top]').click(function(e) {
		e.preventDefault();

		var id = $(this).attr('href');

		var scrollTop = $(window).scrollTop();
		var maskHeight = $(document).height();
		var maskWidth = $(document).width();
		var maskHeightTop = $(id).height() + 180 +scrollTop;
		
		var winH = $(window).height();
		var winW = $(window).width();

		$('#mask').css({'width':maskWidth,'height':maskHeight});
		
		if (maskHeight < maskHeightTop) {
			$('#mask').css({'height':maskHeightTop});
		};
		
		$('#mask').fadeIn(200);
		$('#mask').fadeTo("fast", 0.5);

		$(id).css('top', 100 + scrollTop);
		$(id).css('left', winW/2-$(id).width()/2);

		$(".layerPop").hide();
		$(id).fadeIn(100); //페이드인 속도..숫자가 작으면 작을수록 빨라집니다.
	});
	/* e:모달(상단고정)팝업*/

	/* e:알림팝업*/
	$('a[name=alert]').click(function(e) {
		e.preventDefault();

		var id = $(this).attr('href');

		var maskHeight = $(document).height();
		var maskWidth = $(document).width();

		var winH = $(window).height();
		var winW = $(window).width();
		var scrollTop = $(window).scrollTop();

		$(id).css('top', winH/2-$(id).height()/2+scrollTop);
		$(id).css('left', winW/2-$(id).width()/2);

		//$(".layerPop").hide();
		$(id).fadeIn(100); //페이드인 속도..숫자가 작으면 작을수록 빨라집니다.

	});

	$('.closePop2').click(function (e) {
		e.preventDefault();

		$('.layerAlert').hide();
	});
	/* e:알림팝업*/
};

/** 모달 팝업 */
function gfModalPop(id) {

	//var id = $(this).attr('href');
	
	var maskHeight = $(document).height();
	var maskWidth = $(document).width();

	$('#mask').css({'width':maskWidth,'height':maskHeight});

	$('#mask').fadeIn(200);
	$('#mask').fadeTo("fast", 0.5);

	var winH = $(window).height();
	var winW = $(window).width();
	var scrollTop = $(window).scrollTop();

	$(id).css('top', winH/2-$(id).height()/2+scrollTop);
	$(id).css('left', winW/2-$(id).width()/2);

	$(".layerPop").hide();
	$(id).fadeIn(100); //페이드인 속도..숫자가 작으면 작을수록 빨라집니다.
}

/** 모달 팝업-상단고정 */
function gfModalPopTop(id) {

	var scrollTop = $(window).scrollTop();
	var maskHeight = $(document).height();
	var maskWidth = $(document).width();
	var maskHeightTop = $(id).height() + 180 +scrollTop;
	
	var winH = $(window).height();
	var winW = $(window).width();

	$('#mask').css({'width':maskWidth,'height':maskHeight});
	
	if (maskHeight < maskHeightTop) {
		$('#mask').css({'height':maskHeightTop});
	};
	
	$('#mask').fadeIn(200);
	$('#mask').fadeTo("fast", 0.5);

	$(id).css('top', 50 + scrollTop);
	$(id).css('left', winW/2-$(id).width()/2);

	$(".layerPop").hide();
	$(id).fadeIn(100); //페이드인 속도..숫자가 작으면 작을수록 빨라집니다.
}

/** 모달 닫기 */
function gfCloseModal() {
	
	$('#mask').hide();
	$('.layerPop').hide();
	$('#wrap_pop .scroll').scrollTop(0);
}

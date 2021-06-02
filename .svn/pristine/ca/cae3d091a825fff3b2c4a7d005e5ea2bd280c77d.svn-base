$(document).ready(function() {
	
	//var tdW = 100% - 10;
	//$('td').find('.p94').css('width', tdW);
	
	
	/*****수정 20151215******/
//	var conInH = $('#container li.contents div.content').height();
//	//var conInH = $('#container ul').height();
//	//var conH = $(document).height();
//	//var lnbH = $(document).height();
//	
//	$('#container li.lnb').css('height', conInH +116);
//	$('#container li.contents').css('height', conInH +116);
//	$('#container li.contents div.content').css('height', conInH);
	/**************************/
	
	// LNB 메뉴
	$('ul.lnbMenu li dl dd').hide(); // 이미 없애놓음

	$('ul.lnbMenu a.lnbBtn').click(function(e) {
		e.preventDefault();
		
		if ($("ul.lnbMenu a.lnbBtn").hasClass("on")) {
			$("ul.lnbMenu a.lnbBtn").removeClass("on")
			$("ul.lnbMenu a.lnbBtn").parents("dl").children("dd").slideUp();
		};
		
		$(this).parents("dl").children("dd").slideDown();
		$(this).addClass("on");
	});
	
	
	//qna table
	$("table.qna tr.view").hide();
	$("#tab01").show();
	$('table.qna td a.viewOpen').click(function(e) {
		e.preventDefault();

		$('table.qna tr.view').hide();
		$(this).parents("tr").next("tr.view").show();
	});
	

	/**
	 * start 현재 페이지 메뉴 ON 시키기
	 * 현재 URL을 받아와 사이트명을 잘라 저장된 메뉴의 ID 값과 매칭 시켜 ON 한다.
	 * */
	var locaHref = location.href;
	var locaUrls = locaHref.split('/');
	var locaUrl = '';
	if(locaUrls[locaUrls.length -1].indexOf('=') > -1 && locaUrls[locaUrls.length -1].indexOf('cmnt') > -1){  //파라미터가 있는 커뮤니티 게시판 URL
		locaUrl = locaUrls[locaUrls.length -1].split('=')[locaUrls[locaUrls.length -1].split('=').length -1];
	}else{ //파라미터가 없는 URL
		locaUrl = locaUrls[locaUrls.length -1].split('.')[0];		
	}
	
	$('#lnb_'+locaUrl).parents("dd").show();
	$('#lnb_'+locaUrl).css("color","white");
	$('#lnb_'+locaUrl).parents("dl").children("dt").children("a").addClass("on");
	//end

});



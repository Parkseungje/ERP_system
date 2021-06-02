var slickConfig = {
		  slidesToShow: 3,
		  slidesToScroll: 1,
		  autoplay: true,
		  autoplaySpeed: 2500,
		  arrows : true,
		  dots : true,
          dotsClass: 'slick-dots',
		  pauseOnHover : true,
		  prevArrow: '<div class="slick-prev">다음</div>',
          nextArrow: '<div class="slick-next">이전</div>',
		};

$(function() {

	fSlideProductData();
	
	fDatePickerInit();
	
});

function fDatePickerInit(){
	$("#startDate").datepicker({
		minDate : "+1d"
    	        	
    })
	
    $("#endDate").datepicker({
    	
    	minDate : "+1d",
      maxDate : "+1m"     	
      })
}

function fSelectedOptions(category){
	
	fSlideProductData(category);
	
}

function fSlideProductData(category){
	
	
	var resultCallback = function(data) {
		
		fSlideProduct(data.slideProductInfoList);
		
		fCategoryInit(data.productCategoryList);
		
	};
	
	
	if(category == undefined || category == null || category == ''){

		callAjax("/dashboard/epc/slide", "post", "json", true, null, resultCallback);
		
	} else {

		
		var data = {
				detail_name : category
		}
		
		callAjax("/dashboard/epc/slide", "post", "json", true, data, resultCallback);
	}
	
}

function fSlideProduct(data){
	
	var slideProduct = data;
	

	if(slideProduct.length == 0){
		alert('제품 준비 중입니다.');
		return
	}
	
	
	
	if( $('.post-wrapper').hasClass('slick-initialized') ){
		$('.post-wrapper').slick('unslick');//슬릭해제
	}

	$(".post-wrapper").children().remove();
	
	for(var i = 0 ; i < slideProduct.length; i++){
		
		$(".post-wrapper").append("<div class='post'>"+
				"<img src="+slideProduct[i].file_server_path+" class='slider-image' onclick=fPopModalProductList('"+slideProduct[i].pro_no+"');>"
				+
				'<div class="post-info">'
				+
				"<img src='/images/view/dashboard/epc/cart.png' style='height: 40px; width: 40px; float:right;' onclick=fPopModalProductList('"+slideProduct[i].pro_no+"');>"
				+
				'<h4><a class="post-subject">제품명 :'+slideProduct[i].pro_name+'</a></h4>'
				+
				'<h6><i class="far fa-user" style="height:10%;">가격 :'+slideProduct[i].pro_price+'</i></h6>'
				+
				'<i class="far fa-user" style="height:10%;">'+slideProduct[i].pro_detail+'</i>'
				+
				"</div></div>");
		
		console.log(slideProduct[i].pro_name + ", " + slideProduct[i].pro_detail);
		
	}
	

    	$('.post-wrapper').slick(slickConfig);
    
	
}

function fCategoryInit(data){
	
	var productCategory = data;
	
	$("#productCategory").children().remove();
	
	$("#productCategory").append("<option value=''>제품 분류</option>");
	for(var i = 0 ; i < productCategory.length; i++){
		
		$("#productCategory").append("<option value='"+productCategory[i].detail_name+"'>"+
				productCategory[i].detail_name+"</option>");
		
		console.log(productCategory[i].detail_code + ", " + productCategory[i].detail_name);
	}
	
	
	$("#productCategory").chosen({no_results_text: "검색 결과가 없습니다 :("});
	
}

function fImgClick(data){
	
	alert(data);
	
}
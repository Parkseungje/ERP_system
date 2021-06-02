// 그룹코드 페이징 설정
var pageSizeDailyOrder = 5;
var pageBlockSizeDailyOrder = 10;
	
// 상세코드 페이징 설정
var pageSizeComnDtlCod = 5;
var pageBlockSizeComnDtlCod = 10;

$(function() {
	// 일일 수주 조회
	fListDailyOrderHistroy();

	// 버튼 이벤트 등록
	fRegisterButtonClickEvent();
	    
	// datePicker
	fDatePicker();
	
});

function fModelNameSearch(){
	

	let startDate = $("#startDate").val();
    let endDate = $("#endDate").val();
	
	let url = "/dlm/refundBuyer.do/list/refund";

	let currentPage = $("#currentPageDailyOrder").val();
	
	
	let model_name_searchbar_val = $("#model_name_searchbar").val();
	
	let datePickerClieckedFlag = $("#datePickerClieckedFlag").val() * 1;
	
	var date;
	
	if(model_name_searchbar_val.replace(/\s|　/gi, "").length == 0){
		$("#model_name_searchbar").val('');
		
		if(datePickerClieckedFlag==0){
			date = {
				    currentPage: currentPage, 
				    pageSize: pageSizeDailyOrder
				};
		} else{
			
			date = {
				startDate : startDate,
				endDate : endDate,
			    currentPage: currentPage, 
			    pageSize: pageSizeDailyOrder
			};
			
		}
		
		
		
		
		var resultCallback = function(data) {
			flistDailyOrderHistroyResult(data, currentPage);
		};
		callAjax(url, "get", "text", true, date, resultCallback);
		
		
		return
	}
	

	if(datePickerClieckedFlag==0){
		date = {
			    currentPage: currentPage, 
			    pageSize: pageSizeDailyOrder,
			    user_company : model_name_searchbar_val
			};
	} else{
		
		date = {
				startDate : startDate,
				endDate : endDate,
			    currentPage: currentPage, 
			    pageSize: pageSizeDailyOrder,
			    pro_name : model_name_searchbar_val
			};
		
	}
	
	
	
	
	var resultCallback = function(data) {
		flistDailyOrderHistroyResult(data, currentPage);
	};
	callAjax(url, "get", "text", true, date, resultCallback);
	
	
}


function fRefundNote(selected){
	
	let refund_note = selected.value;
	
	var this_row_pro_no = $(selected).parent().parent().children().eq(1).text();
	
	let already_refund_note = $(".refund_list_"+this_row_pro_no).find('.fd_refund_note').val();
	
	if(already_refund_note != null || already_refund_note != undefined){
		$(".refund_list_"+this_row_pro_no).find('.fd_refund_note').val(refund_note);
		return
	}
	
	
	$(".refund_list_"+this_row_pro_no).append("<input type='hidden' class='fd_refund_note' value='"+refund_note+"'>");
	
}


function faddRefundBtn(){
	
	let refund_no = $("#selectedRefundNo").val();

	  
	  var resultCallback = function(data) {
		  faddRefundBtnResult(data);
	  };
	  // Ajax실행 방식
	  // callAjax("Url",type,return,async or sync방식,넘겨준거,값,Callback함수 이름)
	  // html로 받을거라 text
	  callAjax("/dlm/refundBuyer.do/refund/"+refund_no, "patch", "json", true, null, resultCallback);
	


}

function faddRefundBtnResult(data){
	
	if(data.result=="SUCCESS"){
		
		swal(data.msg);
		
		$("#orderDetailList").children().remove();
		  // 재고 처리 버튼 hide
		$("#refundBtn").hide();
		
		fListDailyOrderHistroy();
		
		return
	}
	
	swal(data.msg);
}




function fSelectTR(refund_no){

	  // 재고 처리 버튼 hide
	$("#refundBtn").show();
	
	$("#selectedRefundNo").val(refund_no);
	
	  var param = {
			  refund_no : refund_no
	  };
	  
	  var resultCallback = function(data) {
		  fOrderDetailList(data);
	  };
	  // Ajax실행 방식
	  // callAjax("Url",type,return,async or sync방식,넘겨준거,값,Callback함수 이름)
	  // html로 받을거라 text
	  callAjax("/dlm/refundBuyer.do/list/detail", "post", "text", true, param, resultCallback);
}

	/** 일별 수주 내역 조회 콜백 함수 */
function fOrderDetailList(data) {

	  // alert(data);
	  console.log(data);

	  // 기존 목록 삭제
	  $('#orderDetailList').empty();

	  var $data = $($(data).html());

	  $("#orderDetailList").append(data);
	  

}


function fDatePicker(){
    $.datepicker.setDefaults($.datepicker.regional['ko']); 
    $( "#startDate" ).datepicker({
         changeMonth: true, 
         changeYear: true,
         nextText: '다음 달',
         prevText: '이전 달', 
         dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
         dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
         monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
         monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
         showAnim: "slide", //애니메이션을 적용한다.
         dateFormat: "yy-mm-dd",
         maxDate: 0,                       // 선택할수있는 최소날짜, ( 0 : 오늘 이후 날짜 선택 불가)
         onClose: function( selectedDate ) {    
              //시작일(startDate) datepicker가 닫힐때
              //종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
             $("#endDate").datepicker( "option", "minDate", selectedDate );
             
             var endDate = $("#endDate").val();
             fDateSearch(selectedDate, endDate);
             
             $("#datePickerClieckedFlag").val(1);
         }    

    });
    $( "#endDate" ).datepicker({
         changeMonth: true, 
         changeYear: true,
         nextText: '다음 달',
         prevText: '이전 달', 
         dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
         dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
         monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
         monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
         showAnim: "slide", //애니메이션을 적용한다.
         dateFormat: "yy-mm-dd",                    // 선택할수있는 최대날짜, ( 0 : 오늘 이후 날짜 선택 불가)
         onClose: function( selectedDate ) {    
             // 종료일(endDate) datepicker가 닫힐때
             // 시작일(startDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 시작일로 지정
             $("#startDate").datepicker( "option", "maxDate", selectedDate );
             
             var startDate = $("#startDate").val();

             fDateSearch(startDate, selectedDate);

             $("#datePickerClieckedFlag").val(1);
         }    

    }); 
    
    $("#startDate").datepicker('setDate', 'today');
    $("#endDate").datepicker('setDate', 'today');
}

function fDateSearch(startDate, endDate){
	
	
	
	
	
	
		let url = "/dlm/refundBuyer.do/list/refund";

		let currentPage = $("#currentPageDailyOrder").val();
		
		

		let model_name_searchbar_val = $("#model_name_searchbar").val();
		
		
		if(model_name_searchbar_val.replace(/\s|　/gi, "").length == 0){
			$("#model_name_searchbar").val('');
			
			let date = {
					startDate : startDate,
					endDate : endDate,
				    currentPage: currentPage, 
				    pageSize: pageSizeDailyOrder
				};
			
			var resultCallback = function(data) {
				flistDailyOrderHistroyResult(data, currentPage);
			};
			callAjax(url, "get", "text", true, date, resultCallback);
			
			
			return
		}
		
		
		
		let date = {
			startDate : startDate,
			endDate : endDate,
		    currentPage: currentPage, 
		    pageSize: pageSizeDailyOrder,
		    pro_name : model_name_searchbar_val
		};
		
		
		var resultCallback = function(data) {
			flistDailyOrderHistroyResult(data, currentPage);
		};
		callAjax(url, "get", "text", true, date, resultCallback);
		
		
	
}

/** 버튼 이벤트 등록 */
function fRegisterButtonClickEvent() {
	$('a[name=btn]').click(function(e) {
		e.preventDefault();

		var btnId = $(this).attr('id');

		switch (btnId) {
			case 'refundDoneBtn' :
				fsendRefundInfo();
				break;
			case 'searchBtn' :
				fModelNameSearch();
				break;
			case 'btnClosePurDir' :
			case 'btnClose' :
				gfCloseModal();
				break;
		}
	});
}


/** 일별 수주 내역 조회 */
function fListDailyOrderHistroy(currentPage) {
	

  currentPage = currentPage || 1;

  console.log("currentPage : " + currentPage);

  var param = {
    currentPage: currentPage
    , pageSize: pageSizeDailyOrder
  }

  var resultCallback = function(data) {
    flistDailyOrderHistroyResult(data, currentPage);
  };
  // Ajax실행 방식
  // callAjax("Url",type,return,async or sync방식,넘겨준거,값,Callback함수 이름)
  // html로 받을거라 text
  callAjax("/dlm/refundBuyer.do/list/refund", "post", "text", true, param, resultCallback);
}

/** 일별 수주 내역 조회 콜백 함수 */
function flistDailyOrderHistroyResult(data, currentPage) {

  // alert(data);
  console.log(data);

  // 재고 처리 버튼 hide
  $("#refundBtn").hide();
  
  // 기존 목록 삭제
  $('#orderList').empty();

  var $data = $($(data).html());

  $("#orderList").append(data);

  // 총 개수 추출
  let totalCntDailyOrder = $("#totalCntDailyOrder").val();
  
  // 페이지 네비게이션 생성
  var paginationHtml = getPaginationHtml(currentPage, totalCntDailyOrder, pageSizeDailyOrder, pageBlockSizeDailyOrder, 'fListDailyOrderHistroy');
  console.log("paginationHtml : " + paginationHtml);

  $("#orderListPagination").empty().append(paginationHtml);

  // 현재 페이지 설정
  $("#currentPageDailyOrder").val(currentPage);
  
}

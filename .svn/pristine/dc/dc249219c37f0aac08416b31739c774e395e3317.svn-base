// 그룹코드 페이징 설정
var pageSizeDailyOrder = 10;
var pageBlockSizeDailyOrder = 10;
	
// 상세코드 페이징 설정
var pageSizeComnDtlCod = 5;
var pageBlockSizeComnDtlCod = 10;

$(function() {
	// 일일 수주 조회
	fListDailyOrderHistroy();

	// 버튼 이벤트 등록
	fRegisterButtonClickEvent();
	    
	// 반품 체크 검색 이벤트 등록
	fCheckRefundClickEvent();
	
	// datePicker
	fDatePicker();
	
});

function fExcelDownload(tableID, fileID){
	 $("#"+tableID).table2excel({
		 exclude: ".noExl",
		 name: "Excel Document Name",
		 filename: fileID +'.xls', //확장자를 여기서 붙여줘야한다.
		 fileext: ".xls",
		 exclude_img: true,
		 exclude_links: true,
		 exclude_inputs: true
		 });
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
             
         }    

    }); 
    
    $("#startDate").datepicker('setDate', 'today');
    $("#endDate").datepicker('setDate', 'today');
}

function fRefundCheck(currentPage){
	
	  currentPage = currentPage || 1;

	  console.log("currentPage : " + currentPage);
	  
	let url = "/scm/dailyOrderHistory.do/orders/nonDeposit";

	//let currentPage = $("#currentPageDailyOrder").val();
	
	let date = {
	    currentPage: currentPage, 
	    pageSize: pageSizeDailyOrder
	};
	
	
	var resultCallback = function(data) {
		fRefundCheckResult(data, currentPage);
	};
	callAjax(url, "get", "text", true, date, resultCallback);
}

/** 일별 수주 내역 조회 콜백 함수 */
function fRefundCheckResult(data, currentPage) {

  // alert(data);
  console.log(data);

  // 기존 목록 삭제
  $('#listDailyOrderHistroy').empty();

  var $data = $($(data).html());

  $("#listDailyOrderHistroy").append(data);

  // 총 개수 추출
  let totalCntDailyOrder = $("#totalCntDailyOrder").val();
  
  // 페이지 네비게이션 생성
  var paginationHtml = getPaginationHtml(currentPage, totalCntDailyOrder, pageSizeDailyOrder, pageBlockSizeDailyOrder, 'fRefundCheck');
  console.log("paginationHtml : " + paginationHtml);

  $("#dailyOrderPagination").empty().append(paginationHtml);

  // 현재 페이지 설정
  $("#currentPageDailyOrder").val(currentPage);
  
}

function fDateSearch(startDate, endDate){
	
	if ($("#refundCheck").is(":checked")) {
		
		let url = "/scm/dailyOrderHistory.do/orders/dateNonDeposit";

		let currentPage = $("#currentPageDailyOrder").val();
		
		let date = {
		    currentPage: currentPage, 
		    pageSize: pageSizeDailyOrder
		};
		
		
		var resultCallback = function(data) {
			fRefundCheckResult(data, currentPage);
		};
		callAjax(url, "get", "text", true, date, resultCallback);
		
	} else{
		let url = "/scm/dailyOrderHistory.do/orders/dateOrder";

		let currentPage = $("#currentPageDailyOrder").val();
		
		let date = {
			startDate : startDate,
			endDate : endDate,
		    currentPage: currentPage, 
		    pageSize: pageSizeDailyOrder
		};
		
		
		var resultCallback = function(data) {
			fRefundCheckResult(data, currentPage);
		};
		callAjax(url, "get", "text", true, date, resultCallback);
		
		
	}
	
	

	
}

/** 버튼 이벤트 등록 */
function fRegisterButtonClickEvent() {
	$('a[name=btn]').click(function(e) {
		e.preventDefault();

		var btnId = $(this).attr('id');

		switch (btnId) {
			case 'shippingDoneBtn' :
				fShippingDone();
				break;
			case 'btnPurDirDone' :
				fPurchaseDone();
				break;
			case 'btnClosePurDir' :
			case 'btnClose' :
				fHiddenDel();
				gfCloseModal();
				break;
		}
	});
}

function fHiddenDel(){

	$("#whInfoData").children().remove();
	$("#productDetail").children().remove();
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
  callAjax("/scm/dailyOrderHistory.do/orders/dailyOrder", "post", "text", true, param, resultCallback);
}

/** 일별 수주 내역 조회 콜백 함수 */
function flistDailyOrderHistroyResult(data, currentPage) {

  // alert(data);
  console.log(data);

  // 기존 목록 삭제
  $('#listDailyOrderHistroy').empty();

  var $data = $($(data).html());

  $("#listDailyOrderHistroy").append(data);

  // 총 개수 추출
  let totalCntDailyOrder = $("#totalCntDailyOrder").val();
  
  // 페이지 네비게이션 생성
  var paginationHtml = getPaginationHtml(currentPage, totalCntDailyOrder, pageSizeDailyOrder, pageBlockSizeDailyOrder, 'fListDailyOrderHistroy');
  console.log("paginationHtml : " + paginationHtml);

  $("#dailyOrderPagination").empty().append(paginationHtml);

  // 현재 페이지 설정
  $("#currentPageDailyOrder").val(currentPage);
  
}


/** 주문 정보 배송 지시서 모달 실행 */
function fPopModalDeliDirection(order_no, pro_no) {

	if ($("#refundCheck").is(":checked")) {
		
		swal("반품 요청된 주문 입니다.");

		return
		
	}
	
    // Tranjection type 설정
    $("#action").val("U");
    
    $("#shipping_tbody").children().remove();
    
    $("#order_qty_upper").val('');
    
    // 주문 번호, 제품 번호 단건 조회
    fSelectOrderNoAndProNo(order_no, pro_no);
  
}



function fPopModalPurchaseDirection(pro_no) {
	

	if ($("#refundCheck").is(":checked")) {
		
		swal("반품 요청된 주문 입니다.");

		return
		
	}
	
    // Tranjection type 설정
    $("#action").val("U");
    
    $("#purchase_tbody").children().remove();
    
    // 제품 번호 단건 조회
    fSelectProductNo(pro_no);
	
}

/** 주문 단건 조회 */
function fSelectProductNo(pro_no) {

  var resultCallback = function(data) {
	  
	  console.log(data.productDetail);
	  
	  fSelectProductNoResult(data, 'pur_ware_name_option');
	  
  };
  
  var prefix = "/scm/dailyOrderHistory.do/product/";
  var url = prefix + pro_no;

  callAjax(url, "get", "json", true, null, resultCallback);
}





function fSelectProductNoResult(data, optionId){
	
	
	$("#"+optionId).find("option").remove();
	$("#productDetail").children().remove();
	
	$("#"+optionId).append("<option value=''> 창고 선택 </option>");
	
	// 해당 제품들 정보 hidden 저장
	$("#productDetail").find("input").remove();
	
	for (var i=0 ; i<data.productDetail.length ; i++) {
		var model = data.productDetail[i];
		$("#"+optionId).append("<option value='"+model.ware_no+"' >"+model.ware_name+"</option>");
		$("#productDetail").append("<div class='"+model.ware_no+"'"+"id="+model.ware_no+">"+"</div>");
		$("#"+model.ware_no).append("<input type='hidden' class='pd_ware_no' value='"+model.ware_no+"'>");

		$("#"+model.ware_no).append("<input type='hidden' class='pd_ware_name' value='"+model.ware_name+"'>");
		$("#"+model.ware_no).append("<input type='hidden' class='pd_pro_no' value='"+model.pro_no+"'>");
		$("#"+model.ware_no).append("<input type='hidden' class='pd_pro_name' value='"+model.pro_name+"'>");
		$("#"+model.ware_no).append("<input type='hidden' class='pd_company' value='"+model.deli_company+"'>");
		$("#"+model.ware_no).append("<input type='hidden' class='pd_pro_ware_qty' value='"+model.pro_ware_qty+"'>");
	}
	

	$("#"+optionId).trigger("chosen:updated");
	$("#"+optionId).chosen({no_results_text: "검색 결과가 없습니다 :("});
	
	
	
	let productDetail = data.productDetail[0];
	
	$("#pur_login_id").text(productDetail.login_id);
    $("#pur_pro_no").text(productDetail.pro_no);
    $("#pur_pro_name").text(productDetail.pro_name);
    $("#pur_deli_company").text(productDetail.deli_company);
    
    $("#pur_pro_no").focus();
    
    $("#pur_pro_ware_qty_upper").val('');

    $("#pur_order_qty_upper").text('');
    // 모달 팝업
    gfModalPop("#purchaseDirection");
}


function fPurchaseSelectedOptions(ware_no, optionId){

	$("#pur_order_qty_upper").val('');
	
	let option_pro_ware_qty = $("#productDetail").find('.'+ware_no).children('.pd_pro_ware_qty').val();
	
	$("#pur_pro_ware_qty_upper").val(option_pro_ware_qty);
	
}






function fPurchaseDone() {
	
	// 히든 데이터 삭제
	fHiddenDel();
	
	
	
	
	let purchase_body_length = $("#purchase_tbody tr").length * 1;
	
	if(purchase_body_length == 0){
		swal("발주 목록을 추가 해주세요.");
		return
	}
	
	var purchaseDirectionList = new Array(purchase_body_length);
	
	var pro_no = 1;
	var ware_no = 1;
	var purchase_qty = 1;
	var loginID = 1;
	
	for(let i = 0; i < purchase_body_length; i++){
		pro_no = $("#purchase_tbody").children().eq(i).children().eq(0).text();
		ware_no = $("#purchase_tbody").children().eq(i).children().eq(3).text();
		purchase_qty = $("#purchase_tbody").children().eq(i).children().eq(5).text();
		loginID = $("#purchase_tbody").children().eq(i).children().eq(6).text();
		
		var puerchaseDirectionDTO = {
				pro_no : pro_no,
				ware_no : ware_no,
				purchase_qty : purchase_qty,
				loginID : loginID
		};
		
		purchaseDirectionList[i] = puerchaseDirectionDTO;
		
		console.log(i+"번째 : "+" pro_no : " + pro_no + " ware_no : " + ware_no + 
				" purchase_qty : " + purchase_qty + " loginID : " + loginID);
	}
	
	var resultCallback = function(data) {
		const result = data.result;
		if(result == 'SUCCESS'){
			swal(data.msg);
			
			fListDailyOrderHistroy();
			
			gfCloseModal();
		} else if(result =='FAIL'){
			swal(data.msg);
		}
	};
	
	let url = "/scm/dailyOrderHistory.do/direction/purchase";
	
	$.ajax({
        url: url,
        contentType: 'application/json',
        dataType: "json", //json 형태의 타입
        data: JSON.stringify(purchaseDirectionList),
        type: "POST",
        success: function(data){
        	resultCallback(data);
        },
        error: function(xhr, status, error){
            console.log("xhr:"+xhr+", status:"+ status + ", error:"+error);
        }
});
	
}



function faddPurchaseBtn(){
	
	let pur_order_qty_upper = $("#pur_order_qty_upper").val() * 1;
	
	// 0개 발주의 경우
	if(pur_order_qty_upper<=0){
		swal("1개 이상의 수량만 수주 가능합니다.")
		return
	}
	if(!numCheck(pur_order_qty_upper)){
		swal("소숫점은 입력할 수 없습니다.");
		return
	}
	
	let seleted_ware_no = $("#pur_ware_name_option option:selected").val();
	
	let purchase_tbody_tr_length = $('#purchase_tbody tr').length;
	
	// 이미 해당 창고에서 주문한 경우
	for(var i = 0 ; i<purchase_tbody_tr_length; i++){

		let existing_ware_no = $("td[id=pur_ware_no]:eq(" + i + ")").text() * 1;
		
		if(seleted_ware_no == existing_ware_no){
			swal("해당 창고에서 이미 발주량을 결정 하셨습니다.");
			return
		}
	}
	
	
	let seleted_ware_name = $("#pur_ware_name_option option:selected").text();
	

	let seleted_pro_no = $("#productDetail").find('.'+seleted_ware_no).children('.pd_pro_no').val();
	let seleted_pro_name = $("#productDetail").find('.'+seleted_ware_no).children('.pd_pro_name').val();
	let seleted_deli_company = $("#productDetail").find('.'+seleted_ware_no).children('.pd_company').val();
	var pur_login_id = $("#pur_login_id").text();
	// alert(seleted_ware_name);
	
	
	let html = "<tr>" +"<td id='pur_pro_no'>"+seleted_pro_no+"</td>"+
	"<td id='pur_pro_name'>"+seleted_pro_name+"</td>"+
	"<td id='pur_deli_company'>"+seleted_deli_company+"</td>"+
	"<td id='pur_ware_no'>"+seleted_ware_no+"</td>"+
	"<td id='pur_ware_name'>"+seleted_ware_name+"</td>"+
	"<td id='purchase_qty'>"+pur_order_qty_upper+"</td>"+
	"<td id='pur_login_id'>"+pur_login_id+"</td>"+
	"<td><a class='btnType gray' id='deletePurchaseBtn' name='deletePurchaseBtn'><span>삭제</span></a></td></tr>"
	;
	
	$("#purchase_tbody").append(html);
	
	
	$('a[name=deletePurchaseBtn]').click(function(e) {
		e.preventDefault();
		$(this).parent().parent().remove();
	});
	
	// 주문 개수 입력 란 비워 주기
	$("#pur_order_qty_upper").val('');
}















// 미입금 주문 팝업
function fNotDepositPopUp(){
	swal("입금되지 않은 주문입니다.");
}

// 재고가 부족한 상황
function fNoneWareQtyPopUp(){
	swal("재고가 부족합니다. 발주 지시서를 작성해주세요.");
}

/** 주문 단건 조회 */
function fSelectOrderNoAndProNo(order_no, pro_no) {

  var param = { 
		  order_no : order_no,
		  pro_no : pro_no
		  };

  var resultCallback = function(data) {
	  fSelectOrderNoAndProNoResult(data);
  };
  
  var prefix = "/scm/dailyOrderHistory.do/order/";
  var suffix = "/product/";
  var url = prefix + order_no + suffix + pro_no;

  callAjax(url, "get", "json", true, null, resultCallback);
}



/** 주문 단건 조회 콜백 함수 */
function fSelectOrderNoAndProNoResult(data) {

    // 일별 수주내역 폼 데이터 설정
    fInitFormDeliyDirection(data.orderDetail);


    // 모달 팝업
    gfModalPop("#deliDirection");

}



/** 일별 수주 내역 폼 초기화 */
function fInitFormDeliyDirection(object) {
  $("#order_no").focus();
  if (object == "" || object == null || object == undefined) {

    $("#order_no").val("");
    $("#order_date").val("");
    $("#user_company").val("");
    $("#pro_name").val("");
    $("#pro_ware_qty").val("");
    $("#name").val("");
    $("#order_cd").val("");
    $("#order_no").focus();

  } else {

	    $("#order_no").text(object.order_no);
	    $("#order_date").text(object.order_date);
	    $("#user_company").text(object.user_company);
	    $("#pro_name").text(object.pro_name);
	    $("#order_qty").text(object.order_qty);
/*
 * $("#name").text(object.name); $("#order_cd").text(object.order_cd);
 */
	    $("#order_no").focus();
	    
	    
	    $("#ware_name").text('');
	    $("#pro_ware_qty_upper").val('');

	    $("#pro_name_bottom").text('');
	    
	    
	    
	    
	    
  }
  
  
  // pro_no로 wh정보 가져오기
  fMakeWHInfoDropdownByProNo(object.pro_no);
  
}

function fMakeWHInfoDropdownByProNo(pro_no){

	var prefix = "/scm/dailyOrderHistory.do/warehouse/";
	var url = prefix + pro_no;
	

	var resultCallback = function(data) {
		fMakeWHInfoDropdownByProNoResult(data, 'ware_name_option');
	};
	
	callAjax(url, "get", "json", true, null, resultCallback);
	
}

function fMakeWHInfoDropdownByProNoResult(data, optionId){
	
		$("#"+optionId).find("option").remove();
		$("#whInfoData").children().remove();
		
		$("#"+optionId).append("<option value=''> 창고 선택 </option>");
		

		// 해당 제품들 정보 hidden 저장
		$("#whInfoData").find("input").remove();
		
		for (var i=0 ; i<data.whInfoList.length ; i++) {
			var model = data.whInfoList[i];
			$("#"+optionId).append("<option value='"+model.ware_no+"' >"+model.ware_name+"</option>");
			$("#whInfoData").append("<div class='"+model.ware_no+"'"+"id="+model.ware_no+">"+"</div>");
			$("#"+model.ware_no).append("<input type='hidden' class='wb_ware_no' value='"+model.ware_no+"'>");

			$("#"+model.ware_no).append("<input type='hidden' class='wb_ware_name' value='"+model.ware_name+"'>");
			$("#"+model.ware_no).append("<input type='hidden' class='wb_pro_no' value='"+model.pro_no+"'>");
			$("#"+model.ware_no).append("<input type='hidden' class='wb_pro_name' value='"+model.pro_name+"'>");
			$("#"+model.ware_no).append("<input type='hidden' class='wb_name' value='"+model.name+"'>");
			
			$("#"+model.ware_no).append("<input type='hidden' class='wb_pro_ware_qty' value='"+model.pro_ware_qty+"'>");

		}
		

		$("#"+optionId).trigger("chosen:updated");
		$("#"+optionId).chosen({no_results_text: "검색 결과가 없습니다 :("});
		
}

function fSelectedOptions(ware_no, optionId){
	
	$("#order_qty_upper").val('');
	
	let option_pro_ware_qty = $("#whInfoData").find('.'+ware_no).children('.wb_pro_ware_qty').val();
	
	$("#pro_ware_qty_upper").val(option_pro_ware_qty);
	
}
function numCheck(obj){
	 var num_check=/^[0-9]*$/;
		if(!num_check.test(obj)){
		return false;
	}
	return true;
}
function faddShppingBtn(){
	
	
	let order_qty_upper = $("#order_qty_upper").val() * 1;
	
	let order_qty = $("#order_qty").text() * 1;
	
	
	// 많은 수량 주문 or 0개 주문의 경우
	if(order_qty_upper > order_qty){
		swal("주문 수량보다 많은 양의 수주량입니다.");
		return
	} else if(order_qty_upper<=0){
		swal("1개 이상의 수량만 수주 가능합니다.");
		return
	}
	
	if(!numCheck(order_qty_upper)){
		swal("소숫점은 입력할 수 없습니다.");
		return
	}
	
	
	// 해당 창고의 재고수 보다 많은 주문량 경고
	
	let pro_ware_qty = $("#pro_ware_qty_upper").val();
	if(order_qty_upper > pro_ware_qty){
		swal("재고 수량보다 많은 양의 수주량입니다.");
		return
	}

	let seleted_ware_no = $("#ware_name_option option:selected").val();
	
	let shpping_tbody_tr_length = $('#shipping_tbody tr').length;
	
	// 이미 해당 창고에서 주문한 경우
	for(var i = 0 ; i<shpping_tbody_tr_length; i++){

		let existing_ware_no = $("td[id=ware_no]:eq(" + i + ")").text() * 1;
		
		if(seleted_ware_no == existing_ware_no){
			swal("해당 창고에서 이미 수주량을 결정 하셨습니다.")
			return
		}
	}
	
	
	let seleted_ware_name = $("#ware_name_option option:selected").text();
	

	let seleted_pro_no = $("#whInfoData").find('.'+seleted_ware_no).children('.wb_pro_no').val();
	let seleted_pro_name = $("#whInfoData").find('.'+seleted_ware_no).children('.wb_pro_name').val();
	
	var seleted_shpping_master_name = $("#whInfoData").find('.'+seleted_ware_no).children('.wb_name').val();
	// alert(seleted_ware_name);
	
	
	let html = "<tr>" +"<td id='ware_no'>"+seleted_ware_no+"</td>"+
	"<td id='ware_name'>"+seleted_ware_name+"</td>"+
	"<td id='pro_no'>"+seleted_pro_no+"</td>"+
	"<td id='pro_name'>"+seleted_pro_name+"</td>"+
	"<td id='shpping_qty'>"+order_qty_upper+"</td>"+
	"<td id='shpping_master_name'>"+seleted_shpping_master_name+"</td>"+
	"<td><a class='btnType gray' id='deleteShppingBtn' name='deleteShppingBtn'><span>삭제</span></a></td></tr>"
	;
	
	$("#shipping_tbody").append(html);
	
	
	$('a[name=deleteShppingBtn]').click(function(e) {
		e.preventDefault();
		
		let this_order_qty = $(this).parent().parent().children().eq(4).text() * 1;
		
		let order_qty = $("#order_qty").text() * 1;
		
		$("#order_qty").text(this_order_qty + order_qty);
		
		let warehouse_qty = $("#pro_ware_qty_upper").val() * 1;
		
		$("#pro_ware_qty_upper").val(warehouse_qty + this_order_qty);
		
		$(this).parent().parent().remove();
	});
	
	// 주문 개수 입력 란 비워 주기
	$("#order_qty_upper").val('');
	
	// 재고 개수 겉값 변경
	$("#pro_ware_qty_upper").val(pro_ware_qty - order_qty_upper);
	
	// 주문개수 - 수주개수 해주기
	let changed_order_qty = order_qty - order_qty_upper;
	
	$("#order_qty").text(changed_order_qty);
	
	
}

function fShippingDone(){
	

	// 히든 데이터 삭제
	fHiddenDel();
	
	let left_order_qty = $("#order_qty").text() * 1;
	
	if(left_order_qty!=0){
		swal("처리 되지 않은 주문이 남았습니다.");
		return
	}

	let shipping_body_length = $("#shipping_tbody tr").length * 1;
	
	var shippingDirectionList = new Array(shipping_body_length);
	
	var ware_no = 1;
	var pro_no = 1;
	var ship_qty = 1;
	var deli_master_name = 1;
	var order_no = $("#order_no").text();
	
	for(let i = 0; i < shipping_body_length; i++){
		ware_no = $("#shipping_tbody").children().eq(i).children().eq(0).text();
		pro_no = $("#shipping_tbody").children().eq(i).children().eq(2).text();
		ship_qty = $("#shipping_tbody").children().eq(i).children().eq(4).text();
		deli_master_name = $("#shipping_tbody").children().eq(i).children().eq(5).text();
		
		var shippingDirectionDTO = {
				order_no : order_no,
				ware_no : ware_no,
				pro_no : pro_no,
				ship_qty : ship_qty,
				deli_master_name : deli_master_name
		};
		
		shippingDirectionList[i] = shippingDirectionDTO;
		
		console.log(i+"번째 : "+" ware_no : " + ware_no + " pro_no : " + pro_no + 
				" ship_qty : " + ship_qty + " deli_master_name : " + deli_master_name + " order_no : " + order_no);
	}
	
	var resultCallback = function(data) {
		const result = data.result;
		if(result == 'SUCCESS'){
			swal(data.msg);
			
			fListDailyOrderHistroy();
			
			
			gfCloseModal();
		} else if(result =='FAIL'){
			swal(data.msg);
		}
	};
	
	let url = "/scm/dailyOrderHistory.do/direction/shipping";
	
	$.ajax({
        url: url,
        contentType: 'application/json',
        dataType: "json", //json 형태의 타입
        data: JSON.stringify(shippingDirectionList),
        type: "POST",
        success: function(data){
        	resultCallback(data);
        },
        error: function(xhr, status, error){
            console.log("xhr:"+xhr+", status:"+ status + ", error:"+error);
        }
});
	
	
}

function fCheckRefundClickEvent(currentPage){

	currentPage = currentPage || 1;
	
	$("#refundCheck").change(
			function() {
				if ($("#refundCheck").is(":checked")) {
					
					let url ="/scm/dailyOrderHistory.do/orders/nonDeposit";
					var param = {
						currentPage : currentPage,
						pageSize : pageSizeDailyOrder
					}
					var resultCallback = function(data) {
						fRefundCheckResult(data, currentPage);
					};
					callAjax(url, "get", "text", true, param, resultCallback);
					

				} else {
					
					let url = "/scm/dailyOrderHistory.do/orders/dailyOrder";
					var param = {
						currentPage : currentPage,
						pageSize : pageSizeDailyOrder
					}

					var resultCallback = function(data) {
						flistDailyOrderHistroyResult(data, currentPage);
					};

					callAjax(url, "get", "text", true, param, resultCallback);
					
					
				}
				
			});
}




















/** 그룹코드 저장 validation */
function fValidateGrpCod() {

  var chk = checkNotEmpty(
    [
      ["grp_cod", "그룹 코드를 입력해 주세요."],
      ["grp_cod_nm", "그룹 코드 명을 입력해 주세요"],
      ["grp_cod_eplti", "그룹 코드 설명을 입력해 주세요."]
    ]);
  if (!chk) {
    return;
  }
  return true;
}


/** 그룹코드 저장 */
function fSaveGrpCod() {

  // vaildation 체크
  if (!fValidateGrpCod())  {
    return;
  }

  var resultCallback = function(data) {
    fSaveDailyOrderHistoryResult(data);
  };

  callAjax("/system/saveComnGrpCod.do", "get", "json", true, $("#myForm").serialize(), resultCallback);
}


/** 그룹코드 저장 콜백 함수 */
function fSaveDailyOrderHistoryResult(data) {

  // 목록 조회 페이지 번호
  var currentPage = "1";
  if ($("#action").val() != "I") {
    currentPage = $("#currentPageDailyOrder").val();
  }

  if (data.result == "SUCCESS") {

    // 응답 메시지 출력
    swal(data.resultMsg);

    // 모달 닫기
    gfCloseModal();

    // 목록 조회
    fListDailyOrderHistroy(currentPage);

  } else {
    // 오류 응답 메시지 출력
    swal(data.resultMsg);
  }

  // 입력폼 초기화
  fInitFormDiailyOrderHistory();
}


/** 그룹코드 삭제 */
function fDeleteDailyOrderHistroy() {

  var resultCallback = function(data) {
    fDeleteDailyOrderHistroyResult(data);
  };

  callAjax("/system/deleteComnGrpCod.do", "post", "json", true, $("#myForm").serialize(), resultCallback);
}


/** 그룹코드 삭제 콜백 함수 */
function fDeleteDailyOrderHistroyResult(data) {

  var currentPage = $("#currentPageDailyOrder").val();

  if (data.result == "SUCCESS") {

    // 응답 메시지 출력
    swal(data.resultMsg);

    // 모달 닫기
    gfCloseModal();

    // 일별수주 목록 조회
    fListDailyOrderHistroy(currentPage);

  } else {
    swal(data.resultMsg);
  }
}

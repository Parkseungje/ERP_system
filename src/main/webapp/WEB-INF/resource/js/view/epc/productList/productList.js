// 그룹코드 페이징 설정
var pageSizeProductList = 5;
var pageBlockSizeProductList = 5;




$(function() {
	// 그룹코드 조회
	fListProductList();
	fRegisterButtonClickEvent();
	
	
	fSelect();
	fSelectDetail();
	
	fDatepicker();
	
});

function fDatepicker() {
	$("#startDate").datepicker({
		minDate : "+1d"
    	        	
    })
	
    $("#endDate").datepicker({
    	
    	minDate : "+1d",
      maxDate : "+1m"     	
      })
}
/** 버튼 이벤트 등록 */
function fRegisterButtonClickEvent() {
	$('a[name=btn]').click(function(e) {
		e.preventDefault();

		var btnId = $(this).attr('id');

		switch (btnId) {
		
			
			case 'btnSearch' :
				board_search();
				break;
			case 'btnInOrder' :
				fInsertOrder();
				break;
				
			case 'btnInBasket' :
				fExSelect();
				break;	
			
			case 'btnSelect' :
				fSelect();
				break;
				
			case 'btnCloseProductList' :
				//swal("잘되나 찍어봅세");
				gfCloseModal();
				break;
				
				
			case 'btnOrder' :
				fOrderProductList();
		}
	});
}

/** 그룹코드 조회 */
function fListProductList(currentPage) {
	var v = $("#good option:selected").val();
	var p = $("#searchKey option:selected").val();
    var sname = $('#sname');
    var searchKey = document.getElementById("searchKey");
	var oname = searchKey.options[searchKey.selectedIndex].value;
	
	currentPage = currentPage || 1;
	console.log("currentPage : " + currentPage);
	
	var param = {
				v:v
			  ,	p:p
			  ,	sname:sname.val()
			  , oname:oname
	          ,	currentPage : currentPage
			  ,	pageSize : pageSizeProductList
	}
	
	var resultCallback = function(data) {
		flistProductListResult(data, currentPage);
	};
	//Ajax실행 방식
	//callAjax("Url",type,return,async or sync방식,넘겨준거,값,Callback함수 이름)
	callAjax("/epc/listProductList.do", "post", "text", true, param, resultCallback);
}
/** 그룹코드 조회 콜백 함수 */
function flistProductListResult(data, currentPage) {
	
	//swal(data);
	console.log(data);
	
	// 기존 목록 삭제
	$('#listProductList').empty();
	
	// 신규 목록 생성
	$("#listProductList").append(data);
	
	// 총 개수 추출
	var totalCntProductList = $("#totalCntProductList").val();
	//swal(totalCntProductList);
	
	
	// 페이지 네비게이션 생성
	
	
	var paginationHtml = getPaginationHtml(currentPage, totalCntProductList, pageSizeProductList, pageBlockSizeProductList, 'fListProductList');
	console.log("paginationHtml : " + paginationHtml);
	//swal(paginationHtml);
	$("#ProductListPagination").empty().append( paginationHtml );
	
	// 현재 페이지 설정
	$("#currentPageProductList").val(currentPage);
}
// 검색 기능
function board_search(currentPage) {
    
	var v = $("#good option:selected").val();
	var p = $("#searchKey option:selected").val();
    var sname = $('#sname');
    var searchKey = document.getElementById("searchKey");
	var oname = searchKey.options[searchKey.selectedIndex].value;
	
	currentPage = currentPage || 1;
	
	console.log("currentPage : " + currentPage);     
	
    var param = {
    			v:v
    	  ,		p:p
    	  ,	  sname : sname.val()
    	  ,	  oname : oname
          ,   currentPage : currentPage
          ,   pageSize : pageSizeProductList
    }
    
    var resultCallback = function(data) {
    	flistProductListResult(data, currentPage); 
    };
    
    callAjax("/epc/listProductList.do", "post", "text", true, param, resultCallback);
    
}




/**  모달 실행 */
function fPopModalProductList(pro_num) {
	if (pro_num == null || pro_num == ""){
		//swal("찍어보자");
		$("#action").val("I");
		
		gfModalPop("#layer1");
	// 신규 저장
	} else {
		
		$("action").val("U");
		fdetailModal(pro_num);
		//swal("여기 오는지 찍어봅세");
	}
	 /*회원정보 상세 조회*/
	 
	 function fdetailModal(pro_num){
		 //swal(" 상세 조회  ");
		 
		 var param = {pro_num : pro_num
				 	  };
		 var resultCallback2 = function(data){
			 fdetailResult(data);
		 };
		 
		 callAjax("/epc/detailProduct.do", "post", "json", true, param, resultCallback2);
		 //swal("뽑아보자");
		 
	 }
	 
	 /*  공지사항 상세 조회 -> 콜백함수   */
	 function fdetailResult(data){

		  //swal("공지사항 상세 조회  33");
		 if(data.resultMsg == "SUCCESS"){
			 //모달 띄우기 
			 gfModalPop("#layer1");
			 
			// swal(data.result);
			// 모달에 정보 넣기 
			frealPopModal(data.result);
		 
		 }else{
			 swal(data.resultMsg);
		 }
	 }

}


/* 팝업 _ 초기화 페이지(신규) 혹은 내용뿌리기  */
function frealPopModal(object){
	 // 여기는 object 값없을때 여기로 
	 if(object == "" || object == null || object == undefined){
		 
		 $("#pro_model_no").val(""); // pro_model_no 되돌리기
		 // $("#pro_model_no").attr("readonly", false); // pro_model_no 되돌리기
		 // $("#pro_model_no").css("border",""); // pro_model_no 되돌리기

		 
		 $("#btnDeletePro").hide(); // 삭제버튼 숨기기
		 $("#btnUpdatePro").hide();
		 $("#btnSavePro").show();
		
		 
	 }else{
		 $("#pro_num").val(object.pro_num);
		 $("#pro_num").attr("readonly", true); // 수정불가 
		 $("#pro_num").css("border","none");  // 보더 없애는거
		 
		 $("#tempImg").attr("src", object.file_server_path);
		 
		 $("#pro_manu_nm").val(object.pro_manu_nm);
		 $("#pro_manu_nm").attr("readonly", true); 
		 $("#pro_manu_nm").css("border","none"); 
		 
		 $("#pro_prc").val(object.pro_prc);
		 $("#pro_prc").attr("readonly", true); 
		 $("#pro_prc").css("border","none");  
		 
		 $("#pro_cd").val(object.pro_cod).change();
		 
		 $("#pro_det").val(object.pro_det);
		 $("#pro_det").attr("readonly", true); 
		 $("#pro_det").css("border","none"); 
		 
		 $("#od_qty").val("1");
		 $("#startDate").val('');
		 
		 $("#btnCloseProductList").show(); // 삭제버튼 보이기 
		
		
		
		 
	 }
}
/*소숫점 방지*/

function numCheck(obj){
	 var num_check=/^[0-9]*$/;
		if(!num_check.test(obj)){
		return false;
	}
	return true;
}


/** 주문 저장 validation */
function fValidateOrder() {
	
	var	chk = $("#od_qty").val();
	var	chk2 = $("#startDate").val();
	if(!numCheck(chk)){
		swal("소숫점은 입력할 수 없습니다.");
		return;
	}else if ( (chk == 0) && (chk2 =="")) {
		
		swal(" 주문수량, 배송일자를  확인하세요");
	
		return; 
	}
	
	return true;
}


/** 주문 저장 */
function fInsertOrder() {

	// vaildation 체크
	if ( ! fValidateOrder() ) {
		return;
	}
	
	var resultCallback = function(data) {
		fInsertOrderResult(data);
	};
	
	callAjax("/epc/inOrder.do", "post", "json", true, $("#myForm").serialize(), resultCallback);
}

/** 주문 저장 콜백 함수 */
function fInsertOrderResult(data) {
	
	
	
	if (data.result == "SUCCESS") {
		
		// 응답 메시지 출력
		swal(data.resultMsg);
		
		// 모달 닫기
		gfCloseModal();
		
		
		
	} else {
		// 오류 응답 메시지 출력
		swal(data.resultMsg);
	}
	
	
}

/** 장바구니 중복체크 */
function fExSelect() {

	
	var resultCallback = function(data) {
		fExBasket(data);
	};
	
	callAjax("/epc/exBasket.do", "post", "json", true, $("#myForm").serialize(), resultCallback);
}


/** 장바구니 중복체크 리턴값 */
function fExBasket(data) {
	var chk3 = data.exBasket;
	
	  
	/*console.log(chk3);
	swal("잘오나 찍어봅시다.");
	swal(chk3);
	*/
	if(chk3 == 1){
		swal("이미 장바구니에 있는 품목입니다.");
		return false;
	}
	if(chk3 == 0){
		
		fInsertBasket();
	}
		
}

/** 장바구니 저장 validation */
function fValidateBasket() {
	
	var	chk = $("#od_qty").val();
	var	chk2 = $("#startDate").val();
	//swal("asdf");
	if(!numCheck(chk)){
		swal("소숫점은 입력할 수 없습니다.");
		return false;
	}else if ( chk2 == "") {
		
		swal("배송일자를  확인하세요");
		return false; 
	}else if ( chk == 0) {
		
		swal("주문수량을 확인하세요");
		return false; 
	}
	
	return true;
	
}


/** 장바구니 저장 */
function fInsertBasket() {
	/*swal("sdaf");*/
	// vaildation 체크
	if ( ! fValidateBasket() ) {
		/*swal("123123");*/
		return;
	}
	
	var resultCallback = function(data) {
		fInsertBasketResult(data);
	};
	
	callAjax("/epc/inBasket.do", "post", "json", true, $("#myForm").serialize(), resultCallback);
}

/** 장바구니 저장 콜백 함수 */
function fInsertBasketResult(data) {
	
	
	
	if (data.result == "SUCCESS") {
		
		// 응답 메시지 출력
		swal(data.resultMsg);
		
		// 모달 닫기
		gfCloseModal();
		
		
		
	} else {
		// 오류 응답 메시지 출력
		swal(data.resultMsg);
	}
	
	
}





/** 셀렉트박스 */
function fSelect() {
	var v = $("#good option:selected").val();
	var p = $("#searchKey option:selected").val();
	var param = {p:p
				,v:v};
	
	var resultCallback = function(data) {
		fSelectResult(data);
	};
	
	callAjax("/epc/selectProduct.do", "post", "json", true, param, resultCallback);
}

/** 셀렉트박스 콜백 함수 */
function fSelectResult(data) {
	
	
	$('#good').empty();
	//console.log("data" + data.cListobj);
	//swal(JSON.stringify(data.cListobj[0].pro_manu_nm));
	
	var json = data.cListobj; 
	//swal(data.cListobj);
	
	var target = document.getElementById("good");
	 json.forEach(function(data){
		 var i = data.pro_manu_nm;
		 var opt = document.createElement("option");
		 opt.value = i;
		 opt.innerText = i;
		 target.appendChild(opt);
		//console.log(data.pro_manu_nm);		 
	 });
	 
	/** 
	 for (x in json) {
		    var opt = document.createElement("option");
		    opt.value =json;
		    opt.innerText = json[1];
		    target.appendChild(opt);
		  } 
	*/
	
		// 오류 응답 메시지 출력
		//swal(data.cListobj);
	
	
}

/** 셀렉트상품 박스 */
function fSelectDetail() {
	var v = $("#good option:selected").val();
	var p = $("#searchKey option:selected").val();
	var param = {p:p
				,v:v};
	
	var resultCallback = function(data) {
		fSelectDetailResult(data);
	};
	
	callAjax("/epc/selectDetail.do", "post", "json", true, param, resultCallback);
}

/** 셀렉트상품  박스 콜백 함수 */
function fSelectDetailResult(data) {
	
	
	$('#searchKey').empty();
	//console.log("data" + data.cListobj);
	//swal(JSON.stringify(data.cListobj[0].pro_manu_nm));
	
	var json = data.dListobj; 
	//swal(data.cListobj);
	
	
	
	var target = document.getElementById("searchKey");
	
	target.options.length = 1;
	 json.forEach(function(data){
		 var i = data.detail_name;
		 var opt = document.createElement("option");
		 opt.value = i;
		 opt.innerText = i;
		 target.appendChild(opt);
		console.log(opt);
		 
	 });
	 
}

// 은행 보여주기 모달

function fAdminBankModal(loginID) {
	//swal("넘어오나요??");
	
	var	chk = $("#od_qty").val();
	var	chk2 = $("#startDate").val();
	
	if ( chk2 =="") {
		
		swal("배송일자를  확인하세요");
		return false; 
	}else if ( chk == 0) {
		
		swal("주문수량을 확인하세요");
	
		return; 
	}else if(!numCheck(chk)){
		swal("소숫점은 입력할 수 없습니다.");
		return;
	}
	else {
		fBankModal();
	}
}

function fBankModal() {
	//swal("입금 조회  ");
	
	var	od_qty = $("#od_qty").val();
	var pro_num = $("#pro_num").val();
	
	var param = {od_qty:od_qty,
				 pro_num:pro_num
	};
	var resultCallback2 = function(data) {
		fBankResult(data);
	};

	callAjax("/epc/Bank.do", "post", "json", true, param,
			resultCallback2);
	//swal(" 상세 조회  22");

}

/* 콜백함수   */
function fBankResult(data) {

	//swal("admin bank  33");
	if (data.resultMsg == "SUCCESS") {
		//모달 띄우기 
		gfModalPop("#admin_bank");

		//swal(data.result);
		// 모달에 정보 넣기 
		fbankPopModal(data.result);

	} else {
		swal(data.resultMsg);
	}
}
function fbankPopModal(object) {

	if (!(object == "" && object == null && object == undefined)) {
		//swal("??");
		console.log(object);

		$('#checkstaff option').each(function(){
			$(this).prop('disabled', false);
		}); 


		$("#rloginID").val("");
		$("#rloginID").attr("readonly", false);

		$("#name").text(object.name);
		$("#bank_name").text(object.bank_name);
		$("#user_account").text(object.user_account);
		$("#totalHap").text(object.pro_prc);

		
		$("#btnInOrder").show();
		/*$("#duplicate_check").show();*/
		

	}
}

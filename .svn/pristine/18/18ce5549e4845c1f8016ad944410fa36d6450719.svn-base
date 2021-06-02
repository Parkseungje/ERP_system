/**
 *  발주 목록 조회, 발주 상세 내역 조회, 데이트 피커 함수
 */

// 발주 지시서 목록 조회
function purchaseOrderList(currentPage) {
  currentPage = currentPage || 1;

  const param = {
    currentPage: currentPage,
    pageSize: pageSizePurchaseOrderList,
    searchKey: $("#searchKey").val(),
    searchWord: $("#searchWord").val(),
    startDate: $("#startDate").val(),
    endDate: $("#endDate").val()
  }

  const resultCallback = function(data) {
    purchaseOrderListResult(data, currentPage);
  }

  callAjax("/dlm/purchaseOrderList.do", "get", "text", true, param, resultCallback);
}

// 발주 지시서 목록 조회 콜백
function purchaseOrderListResult(data, currentPage) {
  console.log(data);

  // 검색 시 상세 페이지 remove
  $("#listPurchaseOrderDtlPagination").empty();
  $("#listPurchaseOrderDtl").empty();


  // 발주 리스트 뿌리기
  $("#listPurchaseOrder").empty().append(data);

  // 총 개수 추출
  const purchaseOrderListTotal = $("#purchaseOrderListTotal").val();

  // 페이지 네비게이션 생성
  const paginationHtml = getPaginationHtml(currentPage, purchaseOrderListTotal, pageSizePurchaseOrderList, pageBlockSizePurchaseOrderList, "purchaseOrderList");

  $("#listPurchaseOrderPagination").empty().append(paginationHtml);

  $("#currentPagePurchaseOrderList").val(currentPage);
}




// 발주 지시서 상세 목록 조회
function purchaseOrderDtlList(currentPage, deli_no) {

  currentPage = currentPage || 1;
  let deli = deli_no;

  if (deli_no === null || deli_no === undefined || deli_no === "") {
    deli = $("#deli_no").val();
  }
  const param = {
    currentPage: currentPage,
    pageSize: pageSizePurchaseOrderDtlList,
    deli_no: deli,
    startDate: $("#startDate").val(),
    endDate: $("#endDate").val()
  }
  const resultCallback = function(data) {
    purchaseOrderDtlListResult(data, currentPage);
  }

  callAjax("/dlm/purchaseOrderDtlList.do", "get", "text", true, param, resultCallback);
}

//발주 지시서 상세 목록 조회 콜백
function purchaseOrderDtlListResult(data, currentPage) {
  console.log(data);
  //const $data = $( $(data).html() );
  //console.log($data);

  // 발주 리스트 뿌리기
  $("#listPurchaseOrderDtl").empty().append(data);

  // 총 개수 추출
  const purchaseOrderDtlListTotal = $("#purchaseOrderDtlListTotal").val();

  // 페이지 네비게이션 생성
  const paginationHtml = getPaginationHtml(currentPage, purchaseOrderDtlListTotal, pageSizePurchaseOrderDtlList, pageBlockSizePurchaseOrderDtlList, "purchaseOrderDtlList");

  $("#listPurchaseOrderDtlPagination").empty().append(paginationHtml);

  $("#currentPagePurchaseOrderDtlList").val(currentPage);
}

// 데이트 피커 함수
function fDatePicker() {
  $.datepicker.setDefaults($.datepicker.regional['ko']);
  $("#startDate").datepicker({
    changeMonth: true,
    changeYear: true,
    nextText: '다음 달',
    prevText: '이전 달',
    dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    showAnim: "slide", // 애니메이션을 적용한다.
    dateFormat: "yy-mm-dd",
    maxDate: 0, // 선택할수있는 최소날짜, ( 0 : 오늘 이후 날짜 선택 불가)
    onClose: function(selectedDate) {
      // 시작일(startDate) datepicker가 닫힐때
      // 종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
      $("#endDate").datepicker("option", "minDate", selectedDate);
    }
  });
  $("#endDate").datepicker({
    changeMonth: true,
    changeYear: true,
    nextText: '다음 달',
    prevText: '이전 달',
    dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    showAnim: "slide", //애니메이션을 적용한다.
    dateFormat: "yy-mm-dd", // 선택할수있는 최대날짜, ( 0 : 오늘 이후 날짜 선택 불가)
    onClose: function(selectedDate) {
      // 종료일(endDate) datepicker가 닫힐때
      // 시작일(startDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 시작일로 지정
      $("#startDate").datepicker("option", "maxDate", selectedDate);
    }
  });

  //$("#startDate").datepicker('setDate', 'today');
  //$("#endDate").datepicker('setDate', 'today');
}
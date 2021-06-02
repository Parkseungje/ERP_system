/**
 *  전역 변수 설정, 페이지 로드 시 실행될 함수부
 */

// 상단테이블 페이징 설정
const pageSizePurchaseOrderList = 5;
const pageBlockSizePurchaseOrderList = 5;

// 하단테이블 페이징 설정
const pageSizePurchaseOrderDtlList = 10;
const pageBlockSizePurchaseOrderDtlList = 5;

// 페이지로드 작동 메서드
$(document).ready(function() {

  // 발주 지시서 목록 가져오기
  purchaseOrderList();

  // 데이트피커 활성화        
  fDatePicker();

  // 버튼 이벤트 등록
  fButtonClickEvent();

});

function fButtonClickEvent() {
  $('a[name=btn]').click(function(e) {
    e.preventDefault();

    const btnId = $(this).attr('id');

    //alert("btnId : " + btnId);

    switch (btnId) {
      case 'btnRefundOrder':
        fRefundOrder();
        break;
      case 'btnPurchaseOrder':
        fPurchaseOrder();
        break;
    }
  });
}

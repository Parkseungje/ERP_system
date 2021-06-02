/**
 *  테이블 페이징 단위 설정과 페이지로드 시 처음 불리는 함수 부분
    전역 변수 부분
 */
 
   //  테이블 페이징 설정
  const pageSizeWHInfo = 5;
  const pageBlockSizeWHInfo = 5;

  // 등록모달, 수정모달 구분자
  const init = "init";
  const modify = "modify";

  const produce = "produce";
  const update = "update";
  //const del = "delete";

  //  페이지로드 작동 메서드
  $(document).ready(function() {

    //  창고별 제품 목록 조회    
    whInfoList();

  });

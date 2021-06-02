/**
 * 창고 조회 javascript
 */

//창고별 재고 조회
function whInfoList(currentPage) {
  currentPage = currentPage || 1;

  //select태그에서 selected된 태그의 value 받아오기.
  const s = document.getElementById("searchKey");
  const searchKey = s.options[s.selectedIndex].value;
  const searchWord = document.getElementById("searchWord").value;

  const param = {
    currentPage: currentPage,
    pageSize: pageSizeWHInfo,
    searchKey: searchKey,
    searchWord: searchWord
  }

  const resultCallback = function(data) {
    whInfoListResult(data, currentPage);
  }

  callAjax("/scm/wh", "get", "text", true, param, resultCallback);
}

//창고 조회 콜백
function whInfoListResult(data, currentPage) {

  //var $data = $($(data).html());
  console.log(data);

  // 기존 목록 삭제
  $('#listWHInfo').empty();

  // 받아온 목록 추가
  $("#listWHInfo").append(data);

  // 총 개수 추출

  const totalcnt = $("#totalcnt").val();
  //console.log("totalcnt : " + totalcnt);

  // 페이지 네비게이션 생성
  const paginationHtml = getPaginationHtml(currentPage, totalcnt, pageSizeWHInfo, pageBlockSizeWHInfo, 'whInfoList');
  console.log("paginationHtml : " + paginationHtml);

  $("#WHInfoPagination").empty().append(paginationHtml);

  // 현재 페이지 설정
  $("#WHInfoPagination").val(currentPage);
}
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html lang="ko">
<head>
<style>
th{
    position: relative;
    padding: 5px 10px;
    border: 1px solid #bbc2cd;
    font-weight: bold;
    text-align: center;
}
</style>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Job Korea :: 월별매출현황</title>
<!-- sweet alert import -->
<script src='${CTX_PATH}/js/sweetalert/sweetalert.min.js'></script>
<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">
	var dateArr = new Array();  //년도
	var odnumArr = new Array();  //주문건수
	var salesArr = new Array();  //매출
	var costArr = new Array();  //매출원가
	var scostArr = new Array();  //영업비
	var marArr = new Array();   //매출총이익(마진)
	var sproArr = new Array();  //영업이익
	var sproRateArr = new Array();  //영업이익률
	var avg = 0;

	
	$(function(){
		// 버튼 이벤트 등록 (조회)
		fButtonClickEvent();
		
	});
	
	

	function dateAddDel(sDate, nNum, type) {
		var yyyy = parseInt(sDate.substr(0, 4), 10);
		var mm = parseInt(sDate.substr(5, 2), 10);
		d = new Date(yy, mm - 1 + nNum);
		yyyy = d.getFullYear();
		mm = d.getMonth() + 1;
		mm = (mm < 10) ? '0' + mm : mm;
		return yyyy + '-' + mm;
	}

	/* 버튼 이벤트 등록 - 조회  */
	function fButtonClickEvent() {
		$('a[name=btn]').click(function(e) {
			e.preventDefault(); // ?? 

			var btnId = $(this).attr('id');

			switch (btnId) {
			case 'btnSearch':
				board_search();
				viewmmChart();
				break;
			}
		});
	}

	// 월별 손익통계 검색기능
	function board_search(currentPage) {
		var fromDate = $('#fromDate').val();
		var toDate = $('#toDate').val();
		var searchKey = $("#searchKey option:selected").val();
		
		var param = {
			fromDate : fromDate,
			toDate : toDate,
			searchKey : searchKey
		}

		var resultCallback = function(data) {
			console.log("resultCallback : " + data);
			
			listAccSlipResult(data);
			//if(searchKey != 'user_input') {
			//	viewmmChart(data); // 사용자 입력은 주석처리
			//}
		}

		callAjax("/sales/listMSales.do", "post", "text", true, param,
				resultCallback);

	}

	function viewmmChart() {
		var fromDate = $('#fromDate').val();
		var toDate = $('#toDate').val();
		var searchKey = $("#searchKey option:selected").val();
		
		var param = {
			fromDate : fromDate,
			toDate : toDate,
			searchKey : searchKey
		}

		var resultCallback = function(data) {
			showChart(data);

		}

		callAjax("/sales/viewmmChart.do", "post", "text", true, param,
				resultCallback);

	}

	function listAccSlipResult(data) {

		//swal(data);
		console.log(data);

		// 기존 목록 삭제
		$('#mmRevList_main').empty();

		// 신규 목록 생성
		$('#mmRevList_main').append(data);
		
		//showChart(data);

	}

	function showChart(data) {

		// 기존 목록 삭제
		$('#chart_div_main').empty();

		// 신규 목록 생성
		$('#chart_div_main').append(data);
	}
</script>

</head>
<body>
<form id="myForm" action=""  method="">
	<input type="hidden" name="action" id="action" value="">
	
	<!-- 모달 배경 -->
	<div id="mask"></div>

	<div id="wrap_area">

		<h2 class="hidden">header 영역</h2>
		<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

		<h2 class="hidden">컨텐츠 영역</h2>
		<div id="container">
			<ul>
				<li class="lnb">
					<!-- lnb 영역 --> <jsp:include
						page="/WEB-INF/view/common/lnbMenu.jsp"></jsp:include> <!--// lnb 영역 -->
				</li>
				<li class="contents">
					<!-- contents -->
					<h3 class="hidden">contents 영역</h3> <!-- content -->
					<div class="content">
					
						<!-- 최상단 집/매출/일별매출현황 -->
						<p class="Location">
							<a href="../dashboard/dashboard.do" class="btn_set home">메인으로</a> 
							<span class="btn_nav bold">매출</span> 
							<span class="btn_nav bold">월별매출현황</span> 
							<a href="../system/comnCodMgr.do" class="btn_set refresh">새로고침</a>
						</p>

						<!-- 일별매출현황 제목 -->
						<p class="conTitle">
							<span>월별매출현황</span> <span class="fr"> 
							</span>
						</p>
						
						<!-- 검색창 --> 
							<!-- 거거래처명 콤보박스 --> 
						<span>기   간</span>  
     	                 <select id="searchKey" name="searchKey" style="width: 150px;">
									<option value="user_input" >직접입력</option>
					     </select> 
						 
						
					    <!-- 날짜 선택 -->
     	                 <input type="text" style="width: 150px; height: 25px;" id="fromDate" name="fromDate" value="${fromDate}">
     	                 <span>-</span>
     	                 <input type="text" style="width: 150px; height: 25px;" id="toDate" name="toDate" value="${toDate}">                    
	                     <a href="" class="btnType blue" id="btnSearch" name="btn">
	                     <span>검  색</span></a>
						<!-- 검색창 끝 -->
						
						<!-- 월별 매출통게 차트영역 -->
						<div id="chart_div_main"></div>

						
						<!-- 월별매출조회 테이블 -->
						<div class="divmmRevList">
							<caption>(단위:십만원)</caption>
							<table id="mmRevList_main" class="col">
							</table>
						</div>
						
					<h3 class="hidden">풋터 영역</h3>
						<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
				</li>
			</ul>
		</div>
	</div>
</form>
</body>
</html>
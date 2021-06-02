<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="https://www.gstatic.com/charts/loader.js"></script>
<!DOCTYPE html>
<html lang="ko">
<head>
<style>
caption {
	font-style:50px;
	font-weight: bold;
	margin: 15px;
	display: table-caption;
	caption-side:top;
	text-align:right;
}
</style>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Job Korea :: 년도별매출현황</title>
<!-- sweet alert import -->
<script src='${CTX_PATH}/js/sweetalert/sweetalert.min.js'></script>
<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="https://www.gstatic.com/charts/loader.js"></script>


<script type="text/javascript">
var dateArr = new Array(); //년도
var nprofitArr = new Array(); //닫기순이익
var sumProArr = new Array(); //영업이익
var salesArr = new Array(); //매출
var salaryArr = new Array(); //인건비
var etcArr = new Array(); //기타지출
var incRateArr = new Array(); //전년대비증가율
var avg = 0;

function average(array) {
	var sum = 0.0;

	for (var i = 0; i < array.length; i++)
		sum += parseInt(array[i]);

	return Math.round(sum / array.length * 1000) / 1000;
}

	$(function(){
		// 버튼 이벤트 등록 (조회)
		fButtonClickEvent();
		
	});

	/* 버튼 이벤트 등록 - 조회  */
	function fButtonClickEvent() {
		$('a[name=btn]').click(function(e) {
			e.preventDefault(); // ?? 

			var btnId = $(this).attr('id');

			switch (btnId) {
			case 'btnSearch':
				board_search();
				viewyyChart();
				break;
			}
		});
	}

	// 년도별 손익통계 조회
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
			listYSalesResult(data);
		}

		callAjax("/sales/listYSales.do", "post", "text", true, param,
				resultCallback);

	}
	
	function viewyyChart() {
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

		callAjax("/sales/viewyyChart.do", "post", "text", true, param,
				resultCallback);

	}

	function listYSalesResult(data) {

		//swal(data);
		console.log(data);

		// 기존 목록 삭제
		$('#listyyRevenue').empty();
		// 신규 목록 생성
		$('#listyyRevenue').append(data);
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
					
						<!-- 최상단 집/매출/년도별매출현황 -->
						<p class="Location">
							<a href="../dashboard/dashboard.do" class="btn_set home">메인으로</a> 
							<span class="btn_nav bold">매출</span> 
							<span class="btn_nav bold">년도별매출현황</span> 
							<a href="../system/comnCodMgr.do" class="btn_set refresh">새로고침</a>
						</p>

						<!-- 년도별매출현황 제목 -->
						<p class="conTitle">
							<span>년도별매출현황</span> <span class="fr"> 
						</p>
						
						<!-- 검색창 --> 
						<span>기   간</span>  
						<select id="searchKey" name="searchKey" style="width: 150px;">
									<option value="user_input" >직접입력</option>
									<option value="qaurter" >1-4분기</option>
									<option value="half" >상/하반기</option>
					     </select> 
					     
					    <!-- 날짜 선택 -->
     	                 <input type="text" style="width: 150px; height: 25px;" id="fromDate" name="fromDate" value="${fromDate}">
     	                 <span>-</span>
     	                 <input type="text" style="width: 150px; height: 25px;" id="toDate" name="toDate" value="${toDate}">                    
	                     <a href="" class="btnType blue" id="btnSearch" name="btn">
	                     <span>검  색</span></a>
						<!-- 검색창 끝 -->
						
						<!-- 년도별 손익통계 차트 -->
						<div id="chart_div_main"></div> 
						
						<!-- 년도별 손익통계 테이블 -->
						<div class="divyyRevenueList">
						<caption >단위: 십만원</caption>
							<table id="listyyRevenue" class="col" width="100px">
							
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
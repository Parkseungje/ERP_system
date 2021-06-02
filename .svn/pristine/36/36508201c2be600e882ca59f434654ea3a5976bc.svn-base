<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.userType ne 'A'}">
    <c:redirect url="/dashboard/dashboard.do"/>
</c:if>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Job Korea :: 공통 코드 관리</title>
<!-- sweet alert import -->
<script src='${CTX_PATH}/js/sweetalert/sweetalert.min.js'></script>
<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>
<!-- sweet swal import -->

<script type="text/javascript">

	// 그룹코드 페이징 설정
	var pageSize = 5;
	var pageBlock = 5;

	var listvue;
	var vuesumtable;

	$(function(){
		
		// 버튼 이벤트 등록 (저장, 수정, 삭제, 모달창 닫기)
		fButtonClickEvent();
		
		
	});
	
	/** 오늘날짜 출력 */
	function getTimeStamp() {

		var d = new Date();
		var s = leadingZeros(d.getFullYear(), 4) + '-'
				+ leadingZeros(d.getMonth() + 1, 2) + '-'
				+ leadingZeros(d.getDate(), 2);

		return s;
	}
	function leadingZeros(n, digits) {

		var zero = '';
		n = n.toString();

		if (n.length < digits) {
			for (i = 0; i < digits - n.length; i++)
				zero += '0';
		}//if
		return zero + n;
	}/**--여기까지 오늘날짜 출력 */


	/** 1일 전 날짜 출력 */
	function beforeday() {
		var today = $("#todayDate").val();
		var newday = "";

		var datearr = today.split("-");

		var currdate = new Date(datearr[0], datearr[1], datearr[2]);
		currdate.setDate(currdate.getDate() - 1);

		var y = currdate.getFullYear();
		var m = currdate.getMonth();
		var d = currdate.getDate();

		if (m < 10) {
			m = "0" + m;
		}//if
		if (d < 10) {
			d = "0" + d;
		}//if
		newday = y + "-" + m + "-" + d;

		$("#todayDate").val(newday);
	}

	/** 1일 후 날짜 출력 */
	function nextday() {
		var today = $("#todayDate").val();
		var newday = "";

		var datearr = today.split("-");

		var currdate = new Date(datearr[0], datearr[1], datearr[2]);
		currdate.setDate(currdate.getDate() + 1);

		var y = currdate.getFullYear();
		var m = currdate.getMonth();
		var d = currdate.getDate();

		if (m < 10) {
			m = "0" + m;
		}//if
		if (d < 10) {
			d = "0" + d;
		}//if
		newday = y + "-" + m + "-" + d;

		$("#todayDate").val(newday);
	}

	/* 버튼 이벤트 등록 - 저장, 수정, 삭제  */
	function fButtonClickEvent(){
		$('a[name=btn]').click(function(e){
			e.preventDefault(); // ?? 
					
			var btnId = $(this).attr('id');
			
			//alert("btnId : " + btnId);
			
			switch(btnId){
			case 'btnSearch' : board_search();  // 검색하기
				break;
			}
		});
	}
	
	// 검색기능
	function board_search(currentPage) {

		var todayDate = $('#todayDate').val();
		var searchKey = $("#searchKey option:selected").val();

		currentPage = currentPage || 1;

		console.log("currentPage : " + currentPage);

		var param = {
			todayDate : todayDate,
			searchKey : searchKey,
			currentPage : currentPage,
			pageSize : pageSize
		}

		var resultCallback = function(data) {
			listAccSlipResult(data,currentPage);
		}

		callAjax("/sales/listAccSlip.do", "post", "text", true, param,
				resultCallback);

	}
	
	function board_search_sum() {

		var todayDate = $('#todayDate').val();
		var searchKey = $("#searchKey option:selected").val();

		var param = {
			todayDate : todayDate,
			searchKey : searchKey
		}

		var resultCallback = function(data) {
			listddAmtSum(data);
		}

		callAjax("/sales/listddAmtSum.do", "post", "text", true, param,
				resultCallback);

	}

	function listAccSlipResult(data,currentPage) {

		//swal(data);
		console.log(data);

		// 기존 목록 삭제
		$('#listddRevenue').empty();

		// 신규 목록 생성
		$('#listddRevenue').append(data);

		// 총 개수 추출

		var totalCntddRevenue = $("#totalCntddRevenue").val();

		console.log("totalCntddRevenue : " + totalCntddRevenue);
		
		//--> sweet alert 사용법 찾아서 쓰삼
		//swal(totalCntddRevenue);

		// 페이지 네비게이션 생성

		var paginationHtml = getPaginationHtml(currentPage, totalCntddRevenue,
				pageSize, pageBlock, 'board_search');
		console.log("paginationHtml : " + paginationHtml);
		//swal(paginationHtml);
		$("#ddRevenuePagination").empty().append(paginationHtml);

		// 현재 페이지 설정
		$("#currentPageddRevenue").val(currentPage);
		
		board_search_sum();
	}
	
	function listddAmtSum(data) {

		console.log(data);

		// 기존 목록 삭제
		$('#listddRevenueSum').empty();

		// 신규 목록 생성
		$('#listddRevenueSum').append(data);
	}
	
	</script>

</head>
<body>
<form id="myForm" action=""  method="">
	<input type="hidden" id="currentPageddRevenue" value="1">
	<input type="hidden" id="currentPageComnDtlCod" value="1">
	<input type="hidden" id="tmpGrpCod" value="">
	<input type="hidden" id="tmpGrpCodNm" value="">
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
					
						<!-- 최상단 집/시스템관리/공통코드관리 -->
						<p class="Location">
							<a href="../dashboard/dashboard.do" class="btn_set home">메인으로</a> 
							<span class="btn_nav bold">매출</span> 
							<span class="btn_nav bold">일별매출현황</span> 
							<a href="../system/comnCodMgr.do" class="btn_set refresh">새로고침</a>
						</p>

						<!-- 일별매출현황 제목 -->
						<p class="conTitle">
							<span>일별매출현황</span> <span class="fr"> 
							<!--상위매출확인시 사용 -->
<!-- 							<a class="btnType blue" href="javascript:fPopModalComnGrpCod();" name="modal">
							<span>신규등록</span></a> -->
							</span>
						</p>
						
							<!-- 그룹코드/그룹코드명 콤보박스 -->   
     	                 <select id="searchKey" name="searchKey" style="width: 150px;">
									<option value="client_nm" >그룹코드</option>
									<option value="client_nm" >그룹코드명</option>
					     </select> 
						
					    <!-- 콤보박스 검색창 -->
					    
     	                 <input type="text" style="width: 300px; height: 25px;" id="todayDate" name="todayDate" value="${tody}">                    
	                     <a href="" class="btnType blue" id="btnSearch" name="btn">
	                     <span>검  색</span></a>
	                     <a href="javascript:beforeday();" class="btnType blue" id="btnPrevious" name="btnPrevious"><span>≪</span></a>
                        <a href="" class="btnType blue" id="bgnToday" name="btnToday"><span>오 늘</span></a>
                        <a href="javascript:nextday();" class="btnType blue" id="btnNext" name="btnNext"><span>≫</span></a>
						
						<!-- 일별매출조회 테이블 -->
						<div class="divddRevenueList"> <!-- divComGrpCodList -->
							<table class="col">
								<caption>caption</caption>
								<colgroup>
									<col width="8%">
									<col width="11%">
									<col width="11%">
									<col width="11%">
									<col width="11%">
									<col width="10%">
									<col width="10%">
									<col width="10%">
								</colgroup>
	
								<thead>
									<tr>
										<th scope="col">전표번호</th>
										<th scope="col">날짜</th>
										<th scope="col">주문코드</th>
										<th scope="col">거래처명</th>
										<th scope="col">계정대분류코드</th>
										<th scope="col">계정대분류명</th>
										<th scope="col">계정세분류코드</th>
										<th scope="col">계정과목명</th>
										<th scope="col">수입금액</th>
										<th scope="col">지출금액</th>
									</tr>
								</thead>
								<tbody id="listddRevenue"></tbody>
							</table>
						</div>
	
						<!-- 페이징에리어 -->
						<div class="paging_area"  id="ddRevenuePagination"> </div>
							<table style="margin-top: 10px" width="100%" cellpadding="5"
								cellspacing="0" border="1" align="left"
								style="collapse; border: 1px #50bcdf;">
								<tr style="border: 0px; border-color: blue">
									<td width="80" height="25" style="font-size: 120%;">&nbsp;&nbsp;</td>
									<td width="50" height="25"
										style="font-size: 100%; text-align: left; padding-right: 25px;">
									</td>
								</tr>
							</table>

						
 
                     
						<!-- 일별손익통계 -->
						<p class="conTitle mt50">
							<span>일별손익통계</span> <span class="fr"> 
							</span>
						</p>
	
						<div class="divddRevenueSumList">  <!-- divComDtlCodList -->
							<table class="col">
								<caption>caption</caption>
								<colgroup>
									<col width="10%">
									<col width="10%">
									<col width="10%">
									<col width="10%">
								</colgroup>
	
								<thead>
									<tr>
										<th scope="col">매출총액①</th>
										<th scope="col">지출총액②</th>
										<th scope="col">미수금총액③</th>
										<th scope="col">손익총계(①-②)</th>
									</tr>
								</thead>
								<tbody id="listddRevenueSum">
									<tr>
										<td colspan="12">조회 버튼을 클릭해 주세요.</td>
									</tr>
								</tbody>
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
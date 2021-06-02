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
<title>Job Korea :: 급여 관리</title>

<!-- sweet alert import -->
<script src='${CTX_PATH}/js/sweetalert/sweetalert.min.js'></script>
<!-- 공통 js/css src 모은 jsp -->
<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>

<script type="text/javascript">
	//사원 급여지급내역 리스트 페이징 설정
	var pageSizeEmpPayment = 5;
	var pageBlockSizeEmpPayment = 5;
	
	//사원 급여지급내역 개인 조회 페이징 설정
	var pageSizeEmpDtlPayment = 5;
	var pageBlockSizeEmpDtlPayment = 5;

	/* onload */
	$(document).ready(function(){
		var date = new Date(); 
		var year = date.getFullYear(); 
		var month = new String(date.getMonth()+1); 
		
		
		//공통코드 검색조건
		selectComCombo("dept", "searchKey_dept", "all", ""); //부서
		comcombo("POScd", "searchKey_poscd", "all", "0");
		
		// 한자리수일 경우 0을 채워준다. 
		if(month.length == 1){ 
		  month = "0" + month; 
		} 
		var initdate = year + "-" + month;
		$("#from_date").val(initdate);
		
		empPaymentList();
	});
	
	function empPaymentList(currentPage){
		currentPage = currentPage || 1;
		var searchKey_dept = $('#searchKey_dept').val();
		var searchKey_poscd = $('#searchKey_poscd').val();
		var searchKey = $('#searchKey').val();
		var searchWord = $('#searchWord').val();
		var payment_state = $('#payment_state').val();
		var from_date = $("#from_date").val();

		var param = {
				  	  searchKey_dept : searchKey_dept
					, searchKey_poscd : searchKey_poscd
					, searchKey : searchKey
					, searchWord : searchWord
					, payment_state : payment_state
					, from_date : from_date
					, currentPage : currentPage
					, pageSize : pageSizeEmpPayment
		}
		
		var resultCallback = function(data){
			empPaymentListResult(data, currentPage);
		};
		callAjax("/employee/empPaymentList.do", "post", "text", true, param, resultCallback);
	}
	
	function empPaymentListResult(data, currentPage){
		console.log(data);
		
		$('#listEmpPayment').empty();
		
		$('#listEmpPayment').append(data);
		
		var empPaymentTotalCnt = $('#empPaymentTotalCnt').val();
		
		var paginationHtml = getPaginationHtml(currentPage, empPaymentTotalCnt, pageSizeEmpPayment, pageBlockSizeEmpPayment, 'empPaymentList');
		console.log("paginationHtml : " + paginationHtml);
		//swal(paginationHtml);
		$("#empPaymentPagination").empty().append(paginationHtml);
		
		// 현재 페이지 설정
		$("#currentPageEmpPayment").val(currentPage);
	}
	
	function empDtlPayment(currentPage, loginID){
		currentPage = currentPage || 1;
		
		var param = {
				 currentPage : currentPage
	           , pageSize : pageSizeEmpDtlPayment
	           , loginID : loginID
		}
		
		var resultCallback = function(data) {
	         empDtlPaymentListResult(data, currentPage);
     	};
     	
     	callAjax("/employee/listEmpDtlPayment.do", "post", "json", true, param, resultCallback);
     	
	}
	
	function empDtlPaymentListResult(data, currentPage){
		var loginID = data.empDtl.loginID;
		$('#loginID').val(loginID);
		$('#name').val(data.empDtl.name);
		$('#dept_cd').val(data.empDtl.dept_name);
		$('#current_poscd').val(data.empDtl.poscd);
		
		var empDtlPaymentTotalCnt = data.empDtlPaymentTotalCnt;
		var empDtlPaymentList = '';
		
		$.each(data.listEmployeeModel, function(index, items){
			$('#listEmpDtlPayment').empty();
			if (empDtlPaymentTotalCnt == 0 || empDtlPaymentTotalCnt == null){
				empDtlPaymentList += '<tr><td colspan = "10">데이터가 존재하지 않습니다.</td>';
			} else {
				empDtlPaymentList += '<tr>';
				empDtlPaymentList += '<td>'+items.payment_date+'</td>';
				empDtlPaymentList += '<td>'+items.year_salary+'</td>';
				empDtlPaymentList += '<td>'+items.salary+'</td>';
				empDtlPaymentList += '<td>'+items.nat_ps+'</td>';
				empDtlPaymentList += '<td>'+items.h_insure+'</td>';
				empDtlPaymentList += '<td>'+items.ohs_insure+'</td>';
				empDtlPaymentList += '<td>'+items.e_insure+'</td>';
				empDtlPaymentList += '<td>'+items.income_tax+'</td>';
				if(items.extra_pay == 0 || items.extra_pay == null){
					empDtlPaymentList += '<td>0</td>';
					empDtlPaymentList += '<td>'+items.net_pay+'</td>';
				} else if (items.extra_pay != 0 || items.extra_pay != null){
					empDtlPaymentList += '<td>'+items.extra_pay+'</td>';
					empDtlPaymentList += '<td>'+(items.extra_pay + items.net_pay)+'</td>';
				}
			}
			
			$('#listEmpDtlPayment').append(empDtlPaymentList);
		});//each
		
		var paginationHtml = getPaginationHtml(currentPage, empDtlPaymentTotalCnt, pageSizeEmpDtlPayment, pageBlockSizeEmpDtlPayment, 'empDtlPayment', [loginID]);
		
		$("#empDtlPaymentPagination").empty().append(paginationHtml);
		
		// 현재 페이지 설정
		$("#currentPageEmpDtlPayment").val(currentPage);
	}
	
	function empPaymentProcess(loginID){
		var from_date = $("#from_date").val();
		
		var param = {
				  loginID : loginID
				, from_date : from_date
		}
		
		swal("지급처리하겠습니까?", {
			buttons : {
				yes : "지급",
				no : "취소"
			}
		}).then((value) => {
			switch(value){
			case "yes" :
				var resultCallback = function(data){
					empPaymentProcessResult(data);
				};
				
				callAjax("/employee/empPaymentProcess.do", "post", "json", true, param, resultCallback);
				
				break;
			case "no" :
				break;
			}
		});
	}
	
	function empPaymentProcessResult(data){
		if(data.result == "SUCCESS"){
			swal(data.resultMsg);
			gfCloseModal();
			var currentPageEmpPayment = $("#currentPageEmpPayment").val();
			empPaymentList(currentPageEmpPayment);
		}else {
			swal("지급처리에 실패하였습니다.");
		}
	}
	
	function allEmpPayment(){
		var from_date = $("#from_date").val();
		
		var param = {
				 from_date : from_date
		}
		
		swal("일괄지급처리하겠습니까?", {
			buttons : {
				yes : "지급",
				no : "취소"
			}
		}).then((value) => {
			switch(value){
			case "yes" :
				var resultCallback = function(data){
					allEmpPaymentResult(data);
				};
				
				callAjax("/employee/allEmpPayment.do", "post", "json", true, param, resultCallback);
				
				break;
			case "no" :
				break;
			}
		});
	}
	
	function allEmpPaymentResult(data){
		if(data.result == "SUCCESS"){
			swal(data.resultMsg);
			gfCloseModal();
			var currentPageEmpPayment = $("#currentPageEmpPayment").val();
			
			empPaymentList(currentPageEmpPayment);
		}else {
			swal("지급처리에 실패하였습니다.");
		}
	}
</script>
</head>
<body>
<form id="myForm" action=""  method="">
	<input type="hidden" id="currentPageEmpPayment" value="1">
	<input type="hidden" id="currentPageEmpDtlPayment" value="1">
	<input type="hidden" id="tmpPaymentStatus" value="">
	
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
					
						<p class="Location">
							<a href="../dashboard/dashboard.do" class="btn_set home">메인으로</a> 
							<span class="btn_nav bold">인사•급여</span> 
							<span class="btn_nav bold">급여관리</span> 
							<a href="/employee/empPayment.do" class="btn_set refresh">새로고침</a>
						</p>

						<p class="conTitle">
							<span>급여 지급 내역 조회</span> <span class="fr"> 
						</p>
						<table style="margin-bottom : 10px; border: 1px #e2e6ed; border-style:solid !important;" height = "50px" width="100%" align="left">
							<tr style="border: 0px; border-color: blue">
	                           	<td width="6%" height="25" style="font-size: 120%; text-align : center;">부서</td>
	                           	<td width="7.5%" height="25" style="font-size: 100%; text-align:left;">
	     	                   		<select id="searchKey_dept" name="searchKey_dept" style="width: 70px;"></select>
								</td>
								<td width="6%" height="25" style="font-size: 120%; text-align:center;">직급</td>
								<td width="8%" height="25" style="font-size: 100%; text-align:left;">
	     	                    	<select id="searchKey_poscd" name="searchKey_poscd" style="width: 70px;"></select>
								</td>
								<td width="9%" height="25" style="font-size: 100%; text-align:left; padding-left: 14px;">
	     	                      <select id="searchKey" name="searchKey" style="width: 70px;">
										<option value="loginID" >사번</option>
										<option value="name" >사원명</option>
								</select>
								</td>
								<td width="26%" height="25">
	     	                       <input type="text" style="width: 180px; height: 25px;" id="searchWord" name="searchWord">                    
	                           	</td>
								<td width="8%" height="25" style="font-size: 120%; text-align:center;">지급상태</td>
								<td width="9%" height="25" style="font-size: 100%; text-align:left;">
	     	                    	<select id="payment_state" name="payment_state" style="width: 70px;">
	     	                    		<option value = "">전체</option>
										<option value="0" >미지급</option>
										<option value="1" >지급</option>
	     	                    	</select>
								</td>
	                           	<td>
	                           		<span class="fr" >
										<Strong>급여년월&nbsp</Strong><input type="month" id="from_date" name="from_date" value="yyyy-mm" max >
									</span>
	                           	</td>
	                           	<td width = "*" height="25" align="right" style="padding-right : 7px;">
	                           		<a href="javascript:empPaymentList()" class="btnType3 color2" id="btnSearchEmpPayment" name="btn"><span>검  색</span></a>
	                           	</td>
	                        </tr>
                     	</table>
                     	<span class="fr" style ="margin-bottom : 5px;"> 
							<a id="lump_sum_Payment" class="btnType3 color2" href="javascript:allEmpPayment()"><span>일괄 지급</span></a> 
						</span>
						
						<!-- 급여지급조회 전체사원리스트 -->
						<div class="divEmpPaymentList">
							<table class="col">
								<caption>caption</caption>
								<colgroup>
									<col width="7%">
									<col width="6%">
									<col width="5%">
									<col width="6%">
									<col width="6%">
									<col width="8%">
									<col width="7%">
									<col width="7%">
									<col width="7%">
									<col width="7%">
									<col width="7%">
									<col width="6%">
									<col width="7%">
									<col width="7%">
									<col width="*">
								</colgroup>
								<thead>
									<tr>
										<th scope="col">지급년월</th>
										<th scope="col">부서</th>
										<th scope="col">직급</th>
										<th scope="col">사번</th>
										<th scope="col">사원명</th>
										<th scope="col">연봉</th>
										<th scope="col">기본급</th>
										<th scope="col">국민연금</th>
										<th scope="col">건강보험</th>
										<th scope="col">산재보험</th>
										<th scope="col">고용보험</th>
										<th scope="col">소득세</th>
										<th scope="col">비고금액</th>
										<th scope="col">실급여</th>
										<th scope="col">지급</th>
									</tr>
								</thead>
								<tbody id="listEmpPayment"></tbody>
							</table>
						</div>
	
						<div class="paging_area"  id="empPaymentPagination"> </div>
                     
						<!-- 급여지급상세조회 -->
						<p class="conTitle mt50">
							<span>급여 지급 내역 상세 조회</span>
						</p>
	
						<div class="divEmpDtlPaymentList">
							<table style="margin-bottom : 10px; border: 1px #e2e6ed; border-style:solid !important;" height = "50px" width="100%" align="left">
		                         <tr style="border: 0px; border-color: blue">
		                           	<td width="6%" height="25" style="font-size: 120%; text-align : center;">사번</td>
		                           	<td width="4%" height="25">
		     	                   		<input type="text" style="font-size: 110%; width: 120px; height: 25px; text-align:center;" id="loginID" name="loginID" readonly>
									</td>
									<td width="8%" height="25" style="font-size: 120%; text-align : center;">사원명</td>
		                           	<td width="4%" height="25">
		     	                   		<input type="text" style="font-size: 110%; width: 120px; height: 25px; text-align:center;" id="name" name="name" readonly>
									</td>
									<td width="8%" height="25" style="font-size: 120%; text-align : center;">부서명</td>
		                           	<td width="4%" height="25">
		     	                   		<input type="text" style="font-size: 110%; width: 120px; height: 25px; text-align:center" id="dept_cd" name="dept_cd" readonly>
									</td>
		                           	<td width="*" height="25" style="font-size: 120%; text-align:right; padding-left: 25px;">현재 직급</td>
									<td width="15%" height="25" style="padding-left : 15px;">
		     	                       <input type="text" style="font-size: 110%; width: 120px; height: 25px; text-align:center;" id="current_poscd" name="current_poscd" readonly>                    
		                           	</td>
		                        </tr>
	                     	</table>
							<table class="col">
								<caption>caption</caption>
								<colgroup>
									<col width="7%">
									<col width="8%">
									<col width="7%">
									<col width="7%">
									<col width="7%">
									<col width="7%">
									<col width="7%">
									<col width="7%">
									<col width="7%">
									<col width="8%">
								</colgroup>
	
								<thead>
									<tr>
										<th scope="col">지급년월</th>
										<th scope="col">연봉</th>
										<th scope="col">기본급</th>
										<th scope="col">국민연금</th>
										<th scope="col">건강보험</th>
										<th scope="col">산재보험</th>
										<th scope="col">고용보험</th>
										<th scope="col">소득세</th>
										<th scope="col">비고금액</th>
										<th scope="col">실급여</th>
									</tr>
								</thead>
								<tbody id="listEmpDtlPayment">
									<tr>
										<td colspan="10">조회할 사원을 선택해 주세요.</td>
									</tr>
								</tbody>
							</table>
						</div>
						
						<!-- 페이징에리어 -->
						<div class="paging_area"  id="empDtlPaymentPagination"> 
						
						</div>

					</div> <!--// content -->

					<h3 class="hidden">풋터 영역</h3>
						<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
				</li>
			</ul>
		</div>
	</div>
</form>
</body>
</html>
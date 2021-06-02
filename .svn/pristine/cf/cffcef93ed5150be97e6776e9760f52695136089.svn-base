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
<title>Job Korea :: 승진 내역 관리</title>

<!-- sweet alert import -->
<script src='${CTX_PATH}/js/sweetalert/sweetalert.min.js'></script>
<!-- 공통 js/css src 모은 jsp -->
<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>

<script type="text/javascript">

	// 승진이력 전체 조회 페이징 설정
	var pageSizeEmpGrade = 5;
	var pageBlockSizeEmpGrade = 5;
	
	// 사원 승진이력 개인 조회 페이징 설정
	var pageSizeEmpDtlGrade = 5;
	var pageBlockSizeEmpGradeDtl = 5;
	
	
	/** OnLoad event */ 
	$(document).ready(function(){
	
		// 승진이력 전체 조회
		listEmpGrade();
		
		//검색 조건
		selectComCombo("dept", "searchKey_dept", "all", ""); //부서
		comcombo("POScd", "searchKey_poscd", "all", "0"); //직급
		
		$("#to_date").change(function() {
			if ($("#to_date").val() < $("#from_date").val()) {
				swal("최소기간 보다 작을수 없습니다.")
				$("#to_date").val('');
			}
		});
	});
	
	//승진이력 전체 조회
	function listEmpGrade(currentPage){
		currentPage = currentPage || 1;
		var searchKey_dept = $('#searchKey_dept').val();
		var searchKey_poscd = $('#searchKey_poscd').val();
		var searchKey = $('#searchKey').val();
		var searchWord = $('#searchWord').val();
		var from_date = $("#from_date").val();
		var to_date = $("#to_date").val();
		
		var param = {
				  searchKey_dept : searchKey_dept
				, searchKey_poscd : searchKey_poscd
				, searchKey : searchKey
				, searchWord : searchWord
				, from_date : from_date
				, to_date : to_date
				, currentPage : currentPage
				, pageSize : pageSizeEmpGrade
		}
		
		var resultCallback = function(data){
			empGradeListResult(data, currentPage);
		};
		callAjax("/employee/listEmpGrade.do", "post", "text", true, param, resultCallback);
	}
	
	function empGradeListResult(data, currentPage){
		$('#listEmpGrade').empty();
		
		$('#listEmpGrade').append(data);
		
		var empGradeTotalCnt = $('#empGradeTotalCnt').val();
		
		var paginationHtml = getPaginationHtml(currentPage, empGradeTotalCnt, pageSizeEmpGrade, pageBlockSizeEmpGrade, 'listEmpGrade');
		console.log("paginationHtml : " + paginationHtml);
		//swal(paginationHtml);
		$("#empGradePagination").empty().append(paginationHtml);
		
		// 현재 페이지 설정
		$("#currentPageEmpGrade").val(currentPage);
	}
	
	function empDtlGrade(currentPage, loginID){
		currentPage = currentPage || 1;
		
		var param = {
			 	 currentPage : currentPage
	           , pageSize : pageSizeEmpDtlGrade
	           , loginID : loginID
		}
		
		var resultCallback = function(data) {
	         empDtlGradeListResult(data, currentPage);
      	};
      	
      	callAjax("/employee/listEmpDtlGrade.do", "post", "json", true, param, resultCallback);
      	
	}
	
	function empDtlGradeListResult(data, currentPage){
		var loginID = data.empDtl.loginID;
		$('#loginID').val(loginID);
		$('#name').val(data.empDtl.name);
		var dept_cd = data.empDtl.dept_cd;
		if(dept_cd == "10"){
			$('#dept_cd').val("구매부");
		}else if (dept_cd == "20"){
			$('#dept_cd').val("배송부");
		}else if (dept_cd == "30"){
			$('#dept_cd').val("영업부");
		}else if (dept_cd == "40"){
			$('#dept_cd').val("총무부");
		}else if (dept_cd == "50"){
			$('#dept_cd').val("관리부");
		}else if (dept_cd == "60"){
			$('#dept_cd').val("SCM부");
		}
		
		var current_poscd = data.empDtl.poscd;
		switch(current_poscd){
			case '1' :
				$('#current_poscd').val("전무");
				break;
			case '2' :
				$('#current_poscd').val("상무");
				break;
			case '3' :
				$('#current_poscd').val("이사");
				break;
			case '4' :
				$('#current_poscd').val("부장");
				break;
			case '5' :
				$('#current_poscd').val("차장");
				break;
			case '6' :
				$('#current_poscd').val("과장");
				break;
			case '7' :
				$('#current_poscd').val("대리");
				break;
			case '8' :
				$('#current_poscd').val("사원");
				break;
		} //현재 직급 swtich
		
		var empDtlGradeTotalCnt = data.empDtlGradeTotalCnt;
		var empDtlGradeList = '';
		$.each(data.listEmployeeModel, function(index, items){
			$('#listEmpDtlGrade').empty();
			if(empDtlGradeTotalCnt == 0 || empDtlGradeTotalCnt == null){
				empDtlGradeList += '<tr><td colspan = "12">데이터가 존재하지 않습니다.</td>';
			}else {
				empDtlGradeList += '<tr>';
				empDtlGradeList += '<td>'+items.promotion_date+'</td>';
				empDtlGradeList += '<td>'+items.poscd+"</td>";
			}
			
			$('#listEmpDtlGrade').append(empDtlGradeList);
		});//each
		
		var paginationHtml = getPaginationHtml(currentPage, empDtlGradeTotalCnt, pageSizeEmpDtlGrade, pageBlockSizeEmpGradeDtl, 'empDtlGrade', [loginID]);
		
		$("#empDtlGradePagination").empty().append(paginationHtml);
		
		// 현재 페이지 설정
		$("#currentPageEmpDtlGrade").val(currentPage);
	}
	
</script>

</head>
<body>
<form id="myForm" action=""  method="">
	<input type="hidden" id="currentPageEmpGrade" value="1">
	<input type="hidden" id="currentPageEmpDtlGrade" value="1">
	
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
							<span class="btn_nav bold">승진내역관리</span> 
							<a href="/employee/empGrade.do" class="btn_set refresh">새로고침</a>
						</p>

						<p class="conTitle">
							<span>승진내역 조회</span> <span class="fr"> 
						</p>
						<table style="margin-bottom : 10px; border: 1px #e2e6ed; border-style:solid !important;" height = "50px" width="100%" align="left">
	                        <tr style="border: 0px; border-color: blue">
	                           	<td width="7%" height="25" style="font-size: 120%; text-align : center;">부서</td>
	                           	<td width="9%" height="25" style="font-size: 100%; text-align:left;">
	     	                   		<select id="searchKey_dept" name="searchKey_dept" style="width: 70px;"></select>
								</td>
								<td width="7%" height="25" style="font-size: 120%; text-align:center;">직급</td>
								<td width="10%" height="25" style="font-size: 100%; text-align:left;">
	     	                    	<select id="searchKey_poscd" name="searchKey_poscd" style="width: 70px;"></select>
								</td>
								<td width="9%" height="25" style="font-size: 100%; text-align:left; padding-left: 14px;">
	     	                      <select id="searchKey" name="searchKey" style="width: 70px;">
										<option value="loginID" >사번</option>
										<option value="name" >사원명</option>
								</select>
								</td>
								<td width="20%" height="25">
	     	                       <input type="text" style="width: 180px; height: 25px;" id="searchWord" name="searchWord">                    
	                           	</td>
	                           	<td width = "*" height="25" align="right" style="padding-right : 7px;">
	                           		<a href="javascript:listEmpGrade()" class="btnType3 color2" id="btnSearchEmpGrade" name="btn"><span>검  색</span></a>
	                           	</td>
	                        </tr>
                     	</table>
                     	<span class="fr">
							<p class="Location">
								<Strong>기간별 조회&nbsp</Strong> 
								<input type="date" id="from_date" style = "width : 33%;">&nbsp~&nbsp<input type="date" id="to_date" style = "width : 33%;">
								<a class="btn_icon search" href="javascript:listEmpGrade()" name="search"><span id="searchEnter">조회</span></a>
							</p>
						</span>
						
						<!-- 승진이력조회 전체사원리스트 -->
						<div class="divEmpGradeList">
							<table class="col">
								<caption>caption</caption>
								<colgroup>
									<col width="6%">
									<col width="17%">
									<col width="20%">
									<col width="20%">
									<col width="10%">
								</colgroup>
								<thead>
									<tr>
										<th scope="col">사번</th>
										<th scope="col">사원명</th>
										<th scope="col">부서명</th>
										<th scope="col">직급</th>
										<th scope="col">발령일자</th>
									</tr>
								</thead>
								<tbody id="listEmpGrade"></tbody>
							</table>
						</div>
	
						<div class="paging_area"  id="empGradePagination"> </div>
                     
						<!-- 상세코드 -->
						<p class="conTitle mt50">
							<span>승진내역 상세조회</span> <span class="fr">
						</p>
	
						<div class="divEmpDtlGradeList">
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
									<col width="6%">
									<col width="10%">
								</colgroup>
	
								<thead>
									<tr>
										<th scope="col">발령일자</th>
										<th scope="col">발령내용</th>
									</tr>
								</thead>
								<tbody id="listEmpDtlGrade">
									<tr>
										<td colspan="12">조회할 사원을 선택해 주세요.</td>
									</tr>
								</tbody>
							</table>
						</div>
						
						<!-- 페이징에리어 -->
						<div class="paging_area"  id="empDtlGradePagination"> 
						
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
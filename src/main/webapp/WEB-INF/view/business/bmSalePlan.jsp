<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<style type="text/css">



#bmSalePlanHeader li{
	float: left;
	width : 180px;
	margin-right : 20px;
	margin-bottom : 10px;
}


</style>


<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>

<script type="text/javascript">

	// 그룹코드 페이징 설정
	var pageSizeBmSalePlan = 10;
	var pageBlockSizeBmSalePlan = 5;

	
	/** OnLoad event */ 
	
	$(function() {
		
		productCombo("l", "plall", "all", "");
		
		// 영업실적조회 함수 호출
		fListBmSalePlan();
		
	});
	

	
	/** 영업실적 조회 */
	function fListBmSalePlan(currentPage) {
		
		
		var sales_reg_date = $("#sales_reg_date").val();		
		var loginID_header = $("#loginID_header").val();
		var large_classifi = $("#plall").val();
		var small_classifi = $("#pmall").val();
		var product_cd 	   = $("#divproducttall").val();
				
		currentPage = currentPage || 1;
		
		console.log("currentPage : " + currentPage);
		
		var param = {
					currentPage : currentPage
				,	pageSize    : pageSizeBmSalePlan
				,   sales_reg_date   : sales_reg_date
				,   loginID_header   : loginID_header
				, 	large_classifi	 : large_classifi
				,   small_classifi	 : small_classifi
				,   product_cd       : product_cd	
		}
		
		console.log(param);
		
		
		var resultCallback = function(data) {
			flistBmSalePlanResult(data, currentPage);
		};
		//Ajax실행 방식
		//callAjax("Url",type,return,async or sync방식,넘겨준거,값,Callback함수 이름)
		callAjax("/business/listBmSalePlan.do", "post", "text", true, param, resultCallback);
	}
	
	
	/** 그룹코드 조회 콜백 함수 */
	function flistBmSalePlanResult(data, currentPage) {
		
		//alert(data);
		console.log(data);
		
		// 기존 목록 삭제
		$('#listBmSalePlan').empty();
		
		// 신규 목록 생성
		$("#listBmSalePlan").append(data);
		
		// 총 개수 추출
		var totalCntBmSalePlan = $("#totalCntBmSalePlan").val();
		
		// 페이지 네비게이션 생성
		var paginationHtml = getPaginationHtml(currentPage, totalCntBmSalePlan, pageSizeBmSalePlan, pageBlockSizeBmSalePlan, 'fListBmSalePlan');
		console.log("paginationHtml : " + paginationHtml);
		//alert(paginationHtml);
		$("#bmSalePlanPagination").empty().append( paginationHtml );
		
		// 현재 페이지 설정
		$("#currentPageBmSalePlan").val(currentPage);
	
		console.log("totalCntBmSalePlan : " + totalCntBmSalePlan);
	}
	
	

    function selectmidcat(){
      var largecd = $("#plall").val();
      productCombo("m", "pmall", "all", largecd);   // 조회 종류   l : 대분류  m : 중분류  p:중분류 제품,   Combo Name, Option("all" : 전체     "sel" : 선택 ,  중분류 코드(제품 목록 조회시 필수))  

      $("#pmall").find("option").remove();
      $("#divproducttall").find("option").remove();
    }
    
    function selectproductlistcombo(){
      var margecd = $("#pmall").val();
      productCombo("p", "divproducttall", "all", margecd);   // 조회 종류   l : 대분류  m : 중분류  p:중분류 제품,   Combo Name, Option("all" : 전체     "sel" : 선택 ,  중분류 코드(제품 목록 조회시 필수))  
    }
	
    
    
    function productCombo(comtype, combo_name, type, code, selvalue){
    	
    	console.log("productCombo Start !!!!!!!!!!!!!! ");
    	
    	var selectbox = document.getElementById(combo_name);

    	var data = {
    			"comtype" : comtype
    		   ,"code" : code
    		};	
    	
    	$(selectbox).find("option").remove();
      		
    	$.ajax({ 
    	     type: "POST",  
    	     url: "/system/productCombo.do", 
    	     dataType: "json",  
    	     data : data,
    	     success: function(data)
    	     { 				
    	    	 
    		     var json_obj = $.parseJSON(JSON.stringify(data));//parse JSON 
    		     var jsonstr = json_obj.list;
    		     console.log("jsonstr : " + jsonstr);
    		     
    		     var jsonstr_obj = $.parseJSON(JSON.stringify(jsonstr));//parse JSON 
    		     var listLen = jsonstr_obj.length;

    	    	 if(type == "all") {
    	    	    $(selectbox).append("<option value=''>전체</option>");
    	    	 }		     
    		     
    	    	 if(type == "sel") {
    		    	$(selectbox).append("<option value=''>선택</option>");
    		     }
    	    	 console.log(" selvalue : " + selvalue);
    	         for(var i=0; i<listLen; i++)
    	         { 		
    	        	 var eleString = JSON.stringify(jsonstr_obj[i]);
    	        	 var item_obj = $.parseJSON(eleString);//parse JSON
                
    	        	 if(selvalue != null && selvalue != null && selvalue != "") {
    	        		 if(selvalue == item_obj.dtl_cod) {
    	        			 console.log(" item_obj.cd : " + item_obj.cd);
    	        			 
    	        			 $(selectbox).append("<option value='"+ item_obj.cd + "' selected>" + item_obj.name + "</option>");
    	        		 } else {
    	        			 $(selectbox).append("<option value='"+ item_obj.cd + "'>" + item_obj.name + "</option>");
    	        		 }
    	        	 } else {
    	        		 $(selectbox).append("<option value='"+ item_obj.cd + "'>" + item_obj.name + "</option>");
    	        	 }
    	        	 
    	        	 
    	         } 
    	         
    	         $(selectbox).val(selvalue);
    	     },
    	     error:function(request,status,error){ alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error); }
    	});  
    }; 


</script>

</head>
<body>
<form id="myForm" action=""  method="">
	<input type="hidden" id="currentPageBmSalePlan" value="1">
	<input type="hidden" id="tmpBmSalePlan" value="">
	<input type="hidden" id="tmpBmSalePlan" value="">
	<input type="hidden" name="action" id="action" value="">
	<input type="hidden" name="userType" id="userType" value="${userType}">
	
	
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
							<a href="#" class="btn_set home">메인으로</a> <a href="#"
								class="btn_nav">영업</a> <span class="btn_nav bold">영업실적조회</span> <a href="#" class="btn_set refresh">새로고침</a>
						</p>


						<p class="conTitle">
							<span>영업실적조회</span> <span class="fr">
							  <a class="btnType blue"
										href="javascript:fListBmSalePlan()" name="search"><span
										id="searchEnter">조회</span></a><br/>
							</span>
						</p>


						<div id = "bmSalePlanHeader">
							<ul>	
							<c:if test="${userType eq 'B'}">
								<li>
									<strong>아이디</strong>
										<input type="text" class="inputTxt p100" name="loginID_header" id="loginID_header"/>	
								</li>
							</c:if>	
								<li>
									<strong>대분류명</strong>
									<select id="plall" name="plall" onChange="javascript:selectmidcat();">
									</select>
								</li>	
								<li>
									<strong>중분류명</strong>
									<select id="pmall" name="pmall" onChange="javascript:selectproductlistcombo();">
									</select>
								</li>	
								<li>
									<strong>제품명</strong>
									<select id="divproducttall" name="divproducttall">
									</select>
								</li>	
								<li>
									<strong>계획등록일</strong>
									<input type = "date" id="sales_reg_date">
								</li>	
							</ul>
						</div>
						
						<div class="divBmSalePlanList">
							<table class="col">
								<caption>caption</caption>
								<colgroup>
										<col width="*%">
									<c:if test="${userType eq 'B'}">
										<col width="*%">
									</c:if>
										<col width="*%">
										<col width="*%">
										<col width="*%">
										<col width="*%">
										<col width="*">
									<c:if test="${userType eq 'B'}">	
										<col width="*">
									</c:if>	
										<col width="*%">
								</colgroup>
	
								<thead>
									<tr>
										<th scope="col">계획등록일</th>
									<c:if test="${userType eq 'B'}">
										<th scope="col">아이디</th>
									</c:if>
										<th scope="col">대분류명</th>
										<th scope="col">중분류명</th>
										<th scope="col">제품명</th>
										<th scope="col">목표수량</th>
										<th scope="col">실적수량</th>
									<c:if test="${userType eq 'B'}">	
										<th scope="col">달성률(%)</th>
									</c:if>	
										<th scope="col">비고</th>
									</tr>
								</thead>
								<tbody id="listBmSalePlan"></tbody>
							</table>
						</div>
	
						<div class="paging_area"  id="bmSalePlanPagination"> </div>
	
					

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
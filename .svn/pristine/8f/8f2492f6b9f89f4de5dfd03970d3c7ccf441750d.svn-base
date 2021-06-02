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
	var pageSizeComnGrpCod = 5;
	var pageBlockSizeComnGrpCod = 5;
	
	// 상세코드 페이징 설정
	var pageSizeComnDtlCod = 5;
	var pageBlockSizeComnDtlCod = 10;
	
	
	/** OnLoad event */ 
	$(function() {
	
		// 그룹코드 조회
		fListComnGrpCod();
		
		// 버튼 이벤트 등록
		fRegisterButtonClickEvent();
	});
	

	/** 버튼 이벤트 등록 */
	function fRegisterButtonClickEvent() {
		$('a[name=btn]').click(function(e) {
			e.preventDefault();

			var btnId = $(this).attr('id');

			switch (btnId) {
			
				// 저장 그룹 코드
				case 'btnSaveGrpCod' :
					fSaveGrpCod();
					break;
				//삭제 그룹 코드 
				case 'btnDeleteGrpCod' :
					fDeleteGrpCod();
					break;
				// 저장 디테일 코드 
				case 'btnSaveDtlCod' :
					fSaveDtlCod();
					break;
				// 삭제 디테일 코드 
				case 'btnDeleteDtlCod' :
					fDeleteDtlCod();
					break;
					
				// 검색 그룹코드 코드 
				case 'btnSearchGrpcod':
					board_search();
					break;
				// 닫기 그룹코드 
				// 닫기 디테일코드 
				case 'btnCloseGrpCod' :
				case 'btnCloseDtlCod' :
					gfCloseModal();
					break;
			}
		});
	}
	
	
	/** 그룹코드 폼 초기화 */
	function fInitFormGrpCod(object) {
		$("#grp_cod").focus();
		if( object == "" || object == null || object == undefined) {
			
			$("#grp_cod").val("");
			$("#grp_cod_nm").val("");
			$("#grp_cod_eplti").val("");
			$("#grp_tmp_fld_01").val("");
			$("#grp_tmp_fld_02").val("");
			$("#grp_tmp_fld_03").val("");
			$("input:radio[name=grp_use_poa]:input[value='Y']").attr("checked", true);
			$("#grp_cod").attr("readonly", false);
			$("#grp_cod").css("background", "#FFFFFF");
			$("#grp_cod").focus();
			$("#btnDeleteGrpCod").hide();
			
		} else {
			
			$("#grp_cod").val(object.grp_cod);
			$("#grp_cod_nm").val(object.grp_cod_nm);
			$("#grp_cod_eplti").val(object.grp_cod_eplti);
			
			$("#grp_tmp_fld_01").val(object.tmp_fld_01);
			$("#grp_tmp_fld_02").val(object.tmp_fld_02);
			$("#grp_tmp_fld_03").val(object.tmp_fld_03);
			$("input:radio[name=grp_use_poa]:input[value="+object.use_poa+"]").attr("checked", true);
			$("#grp_cod").attr("readonly", true);
			$("#grp_cod").css("background", "#F5F5F5");
			$("#grp_cod_nm").focus();
			
			
			
			if(object.tmp_fld_01>0){
				$("#btnDeleteGrpCod").hide();
			}else{
				$("#btnDeleteGrpCod").show();	
			}
		}
	}
	
	// 검색기능
	function board_search(currentPage) {
        
        var sname = $('#sname');
        var searchKey = document.getElementById("searchKey");
		var oname = searchKey.options[searchKey.selectedIndex].value;
		
		currentPage = currentPage || 1;
		
		console.log("currentPage : " + currentPage);     
		
        var param = {
        		  sname : sname.val()
        	  ,	  oname : oname
              ,   currentPage : currentPage
              ,   pageSize : pageSizeComnGrpCod
        }
        //swal(JSON.stringify(param));
        var resultCallback = function(data) {
        	flistGrpCodResult(data, currentPage); 
        };
        
        callAjax("/system/listComnGrpCod.do", "post", "text", true, param, resultCallback);
        
  } 

	
	/** 상세코드 폼 초기화 */
	function fInitFormDtlCod(object) {

		var grpCod = $("#tmpGrpCod").val();
		var grpCodNm = $("#tmpGrpCodNm").val();

		if( object == "" || object == null || object == undefined) {
			
			$("#dtl_grp_cod").val(grpCod);
			$("#dtl_grp_cod_nm").val(grpCodNm);
			$("#dtl_cod").val("");
			$("#dtl_cod_nm").val("");
			$("#dtl_odr").val("");
			$("#dtl_cod_eplti").val("");
			$("#dtl_tmp_fld_01").val("");
			$("#dtl_tmp_fld_02").val("");
			$("#dtl_tmp_fld_03").val("");
			$("#dtl_tmp_fld_04").val("");
			$("input:radio[name=dtl_use_poa]:input[value='Y']").attr("checked", true);
			
			$("#dtl_grp_cod").attr("readonly", true);
			$("#dtl_grp_cod").css("background", "#F5F5F5");
			$("#dtl_grp_cod_nm").attr("readonly", true);
			$("#dtl_grp_cod_nm").css("background", "#F5F5F5");
			$("#dtl_cod").attr("readonly", false);
			$("#dtl_cod").css("background", "#FFFFFF");
			$("#btnDeleteDtlCod").hide();
			$("#dtl_cod").focus();
			
		} else {

			$("#dtl_grp_cod").val(object.grp_cod);
			$("#dtl_grp_cod_nm").val(object.grp_cod_nm);
			$("#dtl_cod").val(object.dtl_cod);
			$("#dtl_cod_nm").val(object.dtl_cod_nm);
			$("#dtl_odr").val(object.odr);
			$("#dtl_cod_eplti").val(object.dtl_cod_eplti);
			$("#dtl_tmp_fld_01").val(object.tmp_fld_01);
			$("#dtl_tmp_fld_02").val(object.tmp_fld_02);
			$("#dtl_tmp_fld_03").val(object.tmp_fld_03);
			$("#dtl_tmp_fld_04").val(object.tmp_fld_04);
			$("input:radio[name=dtl_use_poa]:input[value='"+object.use_poa+"']").attr("checked", true);
			
			$("#dtl_grp_cod").attr("readonly", true);
			$("#dtl_grp_cod").css("background", "#F5F5F5");
			$("#dtl_grp_cod_nm").attr("readonly", true);
			$("#dtl_grp_cod_nm").css("background", "#F5F5F5");
			$("#dtl_cod").attr("readonly", true);
			$("#dtl_cod").css("background", "#F5F5F5");
			$("#btnDeleteDtlCod").show();
			$("#dtl_cod_nm").focus();
		}
	}
	
	
	/** 그룹코드 저장 validation */
	function fValidateGrpCod() {

		var chk = checkNotEmpty(
				[
						[ "grp_cod", "그룹 코드를 입력해 주세요." ]
					,	[ "grp_cod_nm", "그룹 코드 명을 입력해 주세요" ]
					,	[ "grp_cod_eplti", "그룹 코드 설명을 입력해 주세요." ]
				]
		);

		if (!chk) {
			return;
		}

		return true;
	}
	
	
	/** 상세코드 저장 validation */
	function fValidateDtlCod() {

		var chk = checkNotEmpty(
				[
						[ "dtl_grp_cod", "그룹 코드를 선택해 주세요." ]
					,	[ "dtl_cod", "상세 코드를 입력해 주세요." ]
					,	[ "dtl_cod_nm", "상세 코드 명을 입력해 주세요" ]
					,	[ "dtl_cod_eplti", "상세 코드 설명을 입력해 주세요." ]
					,	[ "dtl_odr", "상세 코드 설명을 입력해 주세요." ]
				]
		);

		if (!chk) {
			return;
		}

		return true;
	}
	
	
	/** 그룹코드 모달 실행 */
	function fPopModalComnGrpCod(grp_cod) {
		
		// 신규 저장
		if (grp_cod == null || grp_cod=="") {
			//swal("여기도 찍어봅세  ");
			// Tranjection type 설정
			$("#action").val("I");
			
			// 그룹코드 폼 초기화
			fInitFormGrpCod();
			
			// 모달 팝업
			gfModalPop("#layer1");

		// 수정 저장
		} else {
			// Tranjection type 설정
			$("#action").val("U");
			
			// 그룹코드 단건 조회
			fSelectGrpCod(grp_cod);
		}
	}
	
	
	/** 그룹코드 조회 */
	function fListComnGrpCod(currentPage) {
		
		currentPage = currentPage || 1;
		
		var sname = $('#sname');
        var searchKey = document.getElementById("searchKey");
		var oname = searchKey.options[searchKey.selectedIndex].value;
		
		
		console.log("currentPage : " + currentPage);
		
		var param = {	
					sname : sname.val()
				,	oname : oname
				,	currentPage : currentPage
				,	pageSize : pageSizeComnGrpCod
		}
		
		var resultCallback = function(data) {
			flistGrpCodResult(data, currentPage);
		};
		//Ajax실행 방식
		//callAjax("Url",type,return,async or sync방식,넘겨준거,값,Callback함수 이름)
		callAjax("/system/listComnGrpCod.do", "post", "text", true, param, resultCallback);
	}
	
	
	/** 그룹코드 조회 콜백 함수 */
	function flistGrpCodResult(data, currentPage) {
		
		//swal(data);
		console.log(data);
		
		// 기존 목록 삭제
		$('#listComnGrpCod').empty();
		
		// 신규 목록 생성
		$("#listComnGrpCod").append(data);
		
		// 총 개수 추출
		
		var totalCntComnGrpCod = $("#totalCntComnGrpCod").val();
		
		//--> sweet alert 사용법 찾아서 쓰삼
		//swal(totalCntComnGrpCod);
		
		// 페이지 네비게이션 생성
		
		var paginationHtml = getPaginationHtml(
				currentPage, 
				totalCntComnGrpCod, 
				pageSizeComnGrpCod, 
				pageBlockSizeComnGrpCod, 
				'fListComnGrpCod'
				);
		
		console.log("paginationHtml : " + paginationHtml);
		//swal(paginationHtml);
		$("#comnGrpCodPagination").empty().append( paginationHtml );
		
		// 현재 페이지 설정
		$("#currentPageComnGrpCod").val(currentPage);
	}
	
	
	/** 그룹코드 단건 조회 -> 수정버튼을 눌렀을 때 모달창에 기존 정보를 불러오기 위함 */
	function fSelectGrpCod(grp_cod) {
		
		var param = { grp_cod : grp_cod };
		
		var resultCallback = function(data) {
			fSelectGrpCodResult(data);
		};
		
		callAjax("/system/selectComnGrpCod.do", "post", "json", true, param, resultCallback);
	}
	
	
	/** 그룹코드 단건 조회 콜백 함수*/
	function fSelectGrpCodResult(data) {

		if (data.result == "SUCCESS") {

			// 모달 팝업
			gfModalPop("#layer1");
			
			// 그룹코드 폼 데이터 설정
			fInitFormGrpCod(data.comnGrpCodModel);
			
		} else {
			swal(data.resultMsg);
		}	
	}
	
	
	/** 그룹코드 저장 */
	function fSaveGrpCod() {

		// vaildation 체크
		if ( ! fValidateGrpCod() ) {
			return;
		}
		
		var resultCallback = function(data) {
			fSaveGrpCodResult(data);
		};
		
		callAjax("/system/saveComnGrpCod.do", "post", "json", true, $("#myForm").serialize(), resultCallback);
	}
	
	
	/** 그룹코드 저장 콜백 함수 */
	function fSaveGrpCodResult(data) {
		
		// 목록 조회 페이지 번호
		var currentPage = "1";
		if ($("#action").val() != "I") {
			currentPage = $("#currentPageComnGrpCod").val();
		}
		
		if (data.result == "SUCCESS") {
			
			// 응답 메시지 출력
			swal(data.resultMsg);
			
			// 모달 닫기
			gfCloseModal();
			
			// 목록 조회
			fListComnGrpCod(currentPage);
			
		} else {
			// 오류 응답 메시지 출력
			swal(data.resultMsg);
		}
		
		// 입력폼 초기화
		fInitFormGrpCod();
	}

	
	/** 그룹코드 삭제 */
	function fDeleteGrpCod() {
		
		swal("정말 삭제하겠습니까? \n삭제시 복구불가합니다.", {
			  buttons:{
				  yes : "예",
				  no : "아니오"
			  }
			}).then((value) => {  /* 이건 이클립스가 게을러서 뜨는 에러!  */
				switch(value){
				case "yes":
					
					var resultCallback = function(data) {
					fDeleteGrpCodResult(data);
					};
				
					callAjax("/system/deleteComnGrpCod.do", "post", "json", true, $("#myForm").serialize(), resultCallback);
				
					break;
				case "no": 
					break;
				}
			});
		
		
	}
	
	
	/** 그룹코드 삭제 콜백 함수 */
	function fDeleteGrpCodResult(data) {
		
		var currentPage = $("#currentPageComnGrpCod").val();
		
		if (data.result == "SUCCESS") {
			
			// 응답 메시지 출력
			swal(data.resultMsg);
			
			// 모달 닫기
			gfCloseModal();
			
			// 그룹코드 목록 조회
			fListComnGrpCod(currentPage);
			
		} else {
			swal(data.resultMsg);
		}	
	}
	
	
	/** 상세코드 모달 실행 */
	function fPopModalComnDtlCod(grp_cod, dtl_cod) {
		
		// 신규 저장
		if (dtl_cod == null || dtl_cod=="") {
		
			if ($("#tmpGrpCod").val() == "") {
				swal("그룹 코드를 선택해 주세요.");
				return;
			}
			
			// Tranjection type 설정
			$("#action").val("I");
			
			// 상세코드 폼 초기화
			fInitFormDtlCod();
			
			// 모달 팝업
			gfModalPop("#layer2");

		// 수정 저장
		} else {
			
			// Tranjection type 설정
			$("#action").val("U");
			
			// 상세코드 단건 조회
			fSelectDtlCod(grp_cod, dtl_cod);
		}
	}
	
	
	/** 상세코드 목록 조회 */
	function fListComnDtlCod(currentPage, grp_cod, grp_cod_nm) {
		
		currentPage = currentPage || 1;
		
		// 그룹코드 정보 설정
		$("#tmpGrpCod").val(grp_cod);
		$("#tmpGrpCodNm").val(grp_cod_nm);
		
		var param = {
					grp_cod : grp_cod
				,	currentPage : currentPage
				,	pageSize : pageSizeComnDtlCod
		}
		
		var resultCallback = function(data) {
			flistDtlCodResult(data, currentPage);
		};
		
		callAjax("/system/listComnDtlCod.do", "post", "text", true, param, resultCallback);
	}
	
	
	/** 상세코드 조회 콜백 함수 */
	function flistDtlCodResult(data, currentPage) {
		
		// 기존 목록 삭제
		$('#listComnDtlCod').empty(); 
		
		var $data = $( $(data).html() );

		// 신규 목록 생성
		var $listComnDtlCod = $data.find("#listComnDtlCod");		
		$("#listComnDtlCod").append($listComnDtlCod.children());
		
		// 총 개수 추출
		var $totalCntComnDtlCod = $data.find("#totalCntComnDtlCod");
		var totalCntComnDtlCod = $totalCntComnDtlCod.text(); 
		
	
		
		// 페이지 네비게이션 생성
		var grp_cod = $("#tmpGrpCod").val();
		var grp_cod_nm = $("#tmpGrpCodNm").val();
		var paginationHtml = getPaginationHtml(currentPage, totalCntComnDtlCod, pageSizeComnDtlCod, pageBlockSizeComnDtlCod, 'fListComnDtlCod', [grp_cod]);
		$("#comnDtlCodPagination").empty().append( paginationHtml );
		
		// 현재 페이지 설정
		$("#currentPageComnDtlCod").val(currentPage);
	}
	
	    
	/** 상세코드 단건 조회 */
	function fSelectDtlCod(grp_cod, dtl_cod) {

		var param = {
					grp_cod : grp_cod
				,	dtl_cod : dtl_cod
		};
		
		var resultCallback = function(data) {
			fSelectDtlCodResult(data);
		};
		
		callAjax("/system/selectComnDtlCod.do", "post", "json", true, param, resultCallback);
	}
	
	
	/** 상세코드 단건 조회 콜백 함수*/
	function fSelectDtlCodResult(data) {

		if (data.result == "SUCCESS") {

			// 모달 팝업
			gfModalPop("#layer2");
			
			// 그룹코드 폼 데이터 설정
			fInitFormDtlCod(data.comnDtlCodModel);
			
		} else {
			swal(data.resultMsg);
		}	
	}
	
	
	/** 상세코드 저장 */
	function fSaveDtlCod() {

		// vaildation 체크
		if ( ! fValidateDtlCod() ) {
			return;
		}
		
		var resultCallback = function(data) {
			fSaveDtlCodResult(data);
		};
		
		callAjax("/system/saveComnDtlCod.do", "post", "json", true, $("#myForm").serialize(), resultCallback);
	}
	
	
	/** 상세코드 저장 콜백 함수 */
	function fSaveDtlCodResult(data) {
		
		// 목록 조회 페이지 번호
		var currentPage = "1";
		if ($("#action").val() != "I") {
			currentPage = $("#currentPageComnDtlCod").val();
		}
		
		if (data.result == "SUCCESS") {
			
			// 응답 메시지 출력
			swal(data.resultMsg);
			
			// 모달 닫기
			gfCloseModal();
			
			// 목록 조회
			var grp_cod = $("#tmpGrpCod").val();
			var grp_cod_nm = $("#tmpGrpCodNm").val();
			fListComnDtlCod(currentPage, grp_cod, grp_cod_nm);
			
		} else {
			// 오류 응답 메시지 출력
			swal(data.resultMsg);
		}
		
		// 입력폼 초기화
		fInitFormDtlCod();
	}
	
	
	/** 상세코드 삭제 */
	function fDeleteDtlCod() {
		
		var resultCallback = function(data) {
			fDeleteDtlCodResult(data);
		};
		
		callAjax("/system/deleteComnDtlCod.do", "post", "json", true, $("#myForm").serialize(), resultCallback);
	}
	
	
	/** 상세코드 삭제 콜백 함수 */
	function fDeleteDtlCodResult(data) {
		
		var currentPage = $("#currentPageComnDtlCod").val();
		
		if (data.result == "SUCCESS") {
			
			// 응답 메시지 출력
			swal(data.resultMsg);
			
			// 모달 닫기
			gfCloseModal();
			
			// 그룹코드 목록 조회
			var grp_cod = $("#tmpGrpCod").val();
			var grp_cod_nm = $("#tmpGrpCodNm").val();
			fListComnDtlCod(currentPage, grp_cod, grp_cod_nm);
			
		} else {
			swal(data.resultMsg);
		}	
	}
</script>

</head>
<body>
<form id="myForm" action=""  method="">
	<input type="hidden" id="currentPageComnGrpCod" value="1">
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
							<span class="btn_nav bold">시스템 관리</span> 
							<span class="btn_nav bold">공통코드관리</span> 
							<a href="../system/comnCodMgr.do" class="btn_set refresh">새로고침</a>
						</p>

						<!-- 공통코드관리/신규등록 -->
						<p class="conTitle">
							<span>공통코드관리</span> <span class="fr"> 
							<a class="btnType blue" href="javascript:fPopModalComnGrpCod();" name="modal">
							<span>신규등록</span></a>
							</span>
						</p>
						
						<!-- 공통코드관리 테이블 -->
						<div class="divComGrpCodList">
							<table class="col">
								<caption>caption</caption>
								<colgroup>
									<col width="6%">
									<col width="17%">
									<col width="20%">
									<col width="20%">
									<col width="10%">
									<col width="15%">
									<col width="10%">
								</colgroup>
	
					
								
								<tbody id="listComnGrpCod"></tbody>
							</table>
						</div>
	
						<!-- 페이징에리어 -->
						<div class="paging_area"  id="comnGrpCodPagination"> </div>
						  <table style="margin-top: 10px" width="100%" cellpadding="5" cellspacing="0" border="1"
                                 align="left" style="collapse; border: 1px #50bcdf;">
                            <tr style="border: 0px; border-color: blue">
                              <td width="80" height="25" style="font-size: 120%;">&nbsp;&nbsp;</td>
                              <td width="50" height="25" style="font-size: 100%; text-align:left; padding-right:25px;">
     	                      
     	                 <!-- 그룹코드/그룹코드명 콤보박스 -->   
     	                 <select id="searchKey" name="searchKey" style="width: 150px;" v-model="searchKey">
									<option value="grp_cod" >그룹코드</option>
									<option value="grp_cod_nm" >그룹코드명</option>
					     </select> 
						
					    <!-- 콤보박스 검색창 -->
     	                 <input type="text" style="width: 300px; height: 25px;" id="sname" name="sname">                    
	                     <a href="" class="btnType blue" id="btnSearchGrpcod" name="btn">
	                     <span>검  색</span></a>
                         </td> 
                       </tr>
                     </table> 
                     
						<!-- 상세코드 -->
						<p class="conTitle mt50">
							<span>상세 코드</span> <span class="fr"> <a
								class="btnType blue"  href="javascript:fPopModalComnDtlCod();" name="modal"><span>신규등록</span></a>
							</span>
						</p>
	
						<div class="divComDtlCodList">
							<table class="col">
								<caption>caption</caption>
								<colgroup>
									<col width="6%">
									<col width="10%">
									<col width="10%">
									<col width="10%">
									<col width="10%">
									<col width="5%">
									<col width="5%">
								</colgroup>
	
								<thead>
									<tr>
										<th scope="col">순번</th>
										<th scope="col">그룹코드</th>
										<th scope="col">상세코드</th>
										<th scope="col">상세코드명</th>
										<th scope="col">상세코드 설명</th>
										<th scope="col">사용여부</th>
										<th scope="col">비고</th>
									</tr>
								</thead>
								<tbody id="listComnDtlCod">
									<tr>
										<td colspan="12">그룹코드를 선택해 주세요.</td>
									</tr>
								</tbody>
							</table>
						</div>
						
						<!-- 페이징에리어 -->
						<div class="paging_area"  id="comnDtlCodPagination"> 
						
						</div>

					</div> <!--// content -->

					<h3 class="hidden">풋터 영역</h3>
						<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
				</li>
			</ul>
		</div>
	</div>

	<!-- 모달팝업 -->
	<div id="layer1" class="layerPop layerType2" style="width: 600px;">
		<dl>
			<dt>
				<strong>그룹코드 관리</strong>
			</dt>
			<dd class="content">
				<!-- s : 여기에 내용입력 -->
				<table class="row">
					<caption>caption</caption>
					<colgroup>
						<col width="120px">
						<col width="*">
						<col width="120px">
						<col width="*">
					</colgroup>

					<tbody>
						<tr>
							<th scope="row">그룹 코드 <span class="font_red">*</span></th>
							<td><input type="text" class="inputTxt p100" name="grp_cod" id="grp_cod" /></td>
							<th scope="row">그룹 코드 명 <span class="font_red">*</span></th>
							<td><input type="text" class="inputTxt p100" name="grp_cod_nm" id="grp_cod_nm" /></td>
						</tr>
						<tr>
							<th scope="row">코드 설명 <span class="font_red">*</span></th>
							<td colspan="3"><input type="text" class="inputTxt p100"
								name="grp_cod_eplti" id="grp_cod_eplti" /></td>
						</tr>
				
						<tr>
							<th scope="row">사용 유무 <span class="font_red">*</span></th>
							<td colspan="3"><input type="radio" id="radio1-1"
								name="grp_use_poa" id="grp_use_poa_1" value='Y' /> <label for="radio1-1">사용</label>
								&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" id="radio1-2"
								name="grp_use_poa" id="grp_use_poa_2" value="N" /> <label for="radio1-2">미사용</label></td>
						</tr>
					</tbody>
				</table>

				<!-- e : 여기에 내용입력 -->

				<div class="btn_areaC mt30">
					<a href="" class="btnType blue" id="btnSaveGrpCod" name="btn"><span>저장</span></a> 
					<a href="" class="btnType blue" id="btnDeleteGrpCod" name="btn"><span>삭제</span></a> 
					<a href=""	class="btnType gray"  id="btnCloseGrpCod" name="btn"><span>취소</span></a>
				</div>
			</dd>
		</dl>
		<a href="" class="closePop"><span class="hidden">닫기</span></a>
	</div>

	<div id="layer2" class="layerPop layerType2" style="width: 600px;">
		<dl>
			<dt>
				<strong>상세코드 관리</strong>
			</dt>
			<dd class="content">

				<!-- s : 여기에 내용입력 -->

				<table class="row">
					<caption>caption</caption>
					<colgroup>
						<col width="120px">
						<col width="*">
						<col width="120px">
						<col width="*">
					</colgroup>

					<tbody>
						<tr>
							<th scope="row">그룹 코드 ID <span class="font_red">*</span></th>
							<td><input type="text" class="inputTxt p100" id="dtl_grp_cod" name="dtl_grp_cod" /></td>
							<th scope="row">그룹 코드 명 <span class="font_red">*</span></th>
							<td><input type="text" class="inputTxt p100" id="dtl_grp_cod_nm" name="dtl_grp_cod_nm" /></td>
						</tr>
						<tr>
							<th scope="row">상세 코드 ID <span class="font_red">*</span></th>
							<td><input type="text" class="inputTxt p100" id="dtl_cod" name="dtl_cod" /></td>
							<th scope="row">상세 코드 명 <span class="font_red">*</span></th>
							<td><input type="text" class="inputTxt p100" id="dtl_cod_nm" name="dtl_cod_nm" /></td>
						</tr>
						
						<tr>
							<th scope="row">코드 설명</th>
							<td colspan="3"><input type="text" class="inputTxt p100"
								id="dtl_cod_eplti" name="dtl_cod_eplti" /></td>
						</tr>
					
						<tr>
							<th scope="row">사용 유무 <span class="font_red">*</span></th>
							<td colspan="3"><input type="radio" id="dtl_use_poa_1"
								name="dtl_use_poa" value="Y" /> <label for="radio1-1">사용</label>
								&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" id="dtl_use_poa_2"
								name="dtl_use_poa" value="N" /> <label for="radio1-2">미사용</label></td>
						</tr>
					</tbody>
				</table>

				<!-- e : 여기에 내용입력 -->

				<div class="btn_areaC mt30">
					<a href="" class="btnType blue" id="btnSaveDtlCod" name="btn"><span>저장</span></a>
					<a href="" class="btnType blue" id="btnDeleteDtlCod" name="btn"><span>삭제</span></a>  
					<a href="" class="btnType gray" id="btnCloseDtlCod" name="btn"><span>취소</span></a>
				</div>
			</dd>
		</dl>
		<a href="" class="closePop"><span class="hidden">닫기</span></a>
	</div>
	<!--// 모달팝업 -->
</form>
</body>
</html>
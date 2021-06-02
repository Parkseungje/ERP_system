<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<style type="text/css">


.btnType{
	float:right;
}

.app_date_apply{
	 height : 25px;
	 margin-bottom:5px;
}

.selectEmpDv{
	margin-bottom:10px;
	overflow : hidden;
}

.selectEmpDv li{
	float:left;
	margin-right: 30px;	
}

#empDvReg{
	border : 1px solid #000;
}

#dv_form{
	display : none;
}

</style>

<title>지출결의서 신청</title>

<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>

<script type="text/javascript">
		
		
		/* 조회 조건 파라미터 변수 선언 */
		var from_date;
		var	to_date;
		var account_cd;
		var detail_account_cd;
		var dv_app_yn;
		
		/*지출 결의서 페이징 설정*/

		var pageSizeEmpDv= 10;
		var pageBlockSizeEmpDv = 5;

		
		/** OnLoad event */ 

		$(document).ready(function() {
			
			comcombo("ACCcd", "account_cd", "all");
			comcombo("ACCcd", "account_cd_modal", "all");
			fRegisterButtonClickEvent();
			fListEmpDv(); // 지출결의서 신청건 조회
		

			$("#account_cd_modal option[value='A100']").remove();
			$("#account_cd_modal option[value='B200']").remove();
			$("#account_cd_modal option[value='C300']").remove();
		
		});

		
		/** 지출결의서 신청건 조회  **/
		function fListEmpDv(currentPage) {
			
			currentPage = currentPage || 1;
			
			console.log("currentPage : " + currentPage);
			
			from_date = $("#from_date").val(); // 신청날짜 - 시작날짜
			to_date	  = $("#to_date").val();	// 신청날짜 - 끝날짜	
			account_cd = $("#account_cd").val(); // 대분류코드
			detail_account_cd = $("#detail_account_cd").val(); //상세분류코드
			dv_app_yn = $("#dv_app_yn").val();   //	승인여부
			
			
			var param = {
						from_date : from_date
					,	to_date   : to_date
					,	account_cd : account_cd
					,	detail_account_cd : detail_account_cd 	
					,	dv_app_yn   : dv_app_yn
					,	currentPage : currentPage
					,	pageSize    : pageSizeEmpDv
			}
			
			var resultCallback = function(data) {
				fempDvResult(data, currentPage);
			};
			
			//Ajax실행 방식
			//callAjax("Url",type,return,async or sync방식,넘겨준거,값,Callback함수 이름)
			
			callAjax("/accounting/listEmpDv.do", "post", "text", true, param, resultCallback);
		}

		
		/** 지출결의 신청건 조회 콜백 함수 */
		function fempDvResult(data, currentPage) {
			
			//alert(data);
			console.log(data);
			
			// 기존 목록 삭제
			$('#listEmpDv').empty();
			
			// 신규 목록 생성
			$("#listEmpDv").append(data);
			
			// 총 개수 추출
			var totalCntEmpDv = $("#totalCntEmpDv").val();
			
			// 페이지 네비게이션 생성
			var paginationHtml = getPaginationHtml(currentPage, totalCntEmpDv, pageSizeEmpDv, pageBlockSizeEmpDv, 'fListEmpDv');
			console.log("paginationHtml : " + paginationHtml);
			//alert(paginationHtml);
			$("#empDvPagination").empty().append( paginationHtml );
			
			// 현재 페이지 설정
			$("#currentPageEmpDv").val(currentPage);
		}
	
		
		/** 그룹코드 모달 실행 */
		function fPopModalEmpDv(dv_no) {
			
			// 신규 저장
			if (dv_no == null || dv_no=="") {
			
				// Tranjection type 설정
				$("#action").val("I");
				
				// 그룹코드 폼 초기화
				fInitFormEmpDv();
				
				// 모달 팝업
				gfModalPop("#layer1");

			// 수정 저장
			} else {
				
				// 그룹코드 단건 조회
				fSelectEmpDv(dv_no);
			}
		} 
	
		/** 지출결의건 단건 조회 함수*/
		
		function fSelectEmpDv(dv_no) {

			var param = {
							dv_no : dv_no
						};
			
			var resultCallback = function(data) {
				fSelectEmpDvResult(data);
			};
			
			callAjax("/accounting/selectEmpDv.do", "post", "json", true, param, resultCallback);
		}
		
		/** 지출 결의건 모달 초기화 함수 */	
		function fInitFormEmpDv(object) {
	
		
		var now = new Date();
		var year = now.getFullYear();
		var month = now.getMonth()+1;
		var date = now.getDate();
		
		if((month+"").length<2){
			month = "0" + month;
		}			
		
		if((date+"").length < 2){
			date = "0" + date;
		}
		
		var getToday = year + "-" + month + "-" + date;
		var loginID = $("#curloginID").val();
		
		
		    $("#dv_no").focus();
			
		    if( object == "" || object == null || object == undefined) {			
				
				$("#dv_no").val("");
				$("#loginID").val(loginID);
				$("#name").val("");
				$("#account_cd_modal").val("");
				$("#detail_account_cd_modal").val("");
				$("#acc_name").val("");
				$("#dv_reg_date").val(getToday);
				$("#dv_use_date").val("");
				$("#dv_amt").val("");
				$("#att_file").val("");
				$("#dv_memo").val("");
				$("#btnDeleteEmpDv").hide();
				$("#btnSaveEmpDv").show();
				$("#att_file_form").show();
				
				$("#dv_use_date").attr("readonly", false);
				$("#dv_amt").attr("readonly", false);
				$("#dv_memo").attr("readonly", false);
				$("#acc_name").attr("readonly", false);
				$("#dv_return_form").hide();
				
				
				$("#account_cd_modal").prop("disabled", "");
				$("#detail_account_cd_modal").prop("disabled", "");
		    } else {
				
		    	console.log(object.dv_app_yn);
		    	
		    	console.log(object.dv_no);
		    	
				$("#dv_no").val(object.dv_no);
				$("#loginID").val(object.loginID);
				$("#name").val(object.name);
				$("#account_cd_modal").val(object.account_cd);
				$("#detail_account_cd_modal").val(object.detail_account_cd);
				$("#acc_name").val(object.acc_name);
				$("#dv_reg_date").val(object.dv_reg_date);
				$("#dv_use_date").val(object.dv_use_date);
				$("#dv_amt").val(object.dv_amt);
				$("#att_file").val(object.att_file);
				$("#dv_memo").val(object.dv_memo);
				$("#btnDeleteEmpDv").show();
				$("#att_file_form").hide();
				$("#dv_use_date").attr("readonly", true);
				$("#dv_amt").attr("readonly", true);
				$("#dv_memo").attr("readonly", true);
				$("#acc_name").attr("readonly", true);
				$("#dv_return_form").show();
				$("#dv_return").val(object.dv_return);
				
				$("#account_cd_modal").prop("disabled", "disabled");
				$("#detail_account_cd_modal").prop("disabled", "disabled");
				
				
				if((object.dv_app_yn == 2) || (object.dv_app_yn == 3)){
					$("#btnDeleteEmpDv").hide();
					$("#btnSaveEmpDv").hide();
				}
				else{
					$("#btnDeleteEmpDv").show();
					$("#btnSaveEmpDv").hide();
				}
		    }
		
		}
	
	
		/* 그룹코드 단건 조회 콜백 함수*/
	
		function fSelectEmpDvResult(data) {

				gfModalPop("#layer1");
				
				fInitFormEmpDv(data.empDvModel);
		
		}
		
		
		/** 버튼 이벤트 등록 */
		function fRegisterButtonClickEvent() {
			$('a[name=btn]').click(function(e) {
				e.preventDefault();

				
				var btnId = $(this).attr('id');

				switch (btnId) {
					case 'btnSaveEmpDv' :
						fSaveEmpDv();
						break;
					case 'btnDeleteEmpDv' :
						fDeleteEmpDv();
						break;
					case 'btnCloseEmpDv'  :
						gfCloseModal();
						break;
				}
			});
		}		
		
		
		/** 지출결의건 저장 validation */
		function fValidateEmpDv() {

			var chk = checkNotEmpty(
					[
							[ "account_cd_modal", "계정대분류명을 입력해 주세요." ]
						,	[ "detail_account_cd_modal", "상세과목명을 입력해 주세요" ]
						,	[ "acc_name", "거래처명을 입력해 주세요." ]
						,	[ "dv_use_date", "사용일자를 입력해 주세요."]
						,   [ "dv_amt", "지출금액을 입력해 주세요"]	
					]
			);

			if (!chk) {
				return;
			}

			return true;
		}
		
		/** 지출결의건 저장 */
		function fSaveEmpDv() {
			var saveEmpDvForm = document.getElementById("empDvReg");
			
			// vaildation 체크
			if ( ! fValidateEmpDv() ) {
				return;
			}
			
			saveEmpDvForm.enctype = 'multipart/form-data';
			
			var fileData = new FormData(saveEmpDvForm);
			var resultCallback = function(data) {
				fSaveEmpDvResult(data);
			};
			
			callAjaxFileUploadSetFormData("/accounting/saveEmpDv.do", "post", "json", true, fileData, resultCallback);
		}
		
		
		/** 지출결의 저장 콜백 함수 */
		function fSaveEmpDvResult(data) {
			
			// 목록 조회 페이지 번호
			var currentPage = "1";
			if ($("#action").val() != "I") {
				currentPage = $("#currentPageEmpDv").val();
			}
			
			if (data.result == "SUCCESS") {
				
				// 응답 메시지 출력
				alert(data.resultMsg);
				
				// 모달 닫기
				gfCloseModal();
				
				// 목록 조회
				fListEmpDv(currentPage);
				
			} else {
				// 오류 응답 메시지 출력
				alert(data.resultMsg);
			}

		}
		
		
			/* 조회조건 계정정보 콤보박스 */
			
			function fn_selectComCombo() {				
				
				var account_cd = $("#account_cd").val();
				
				selectComCombo("acc", "detail_account_cd", "all",account_cd,"101");
		  		
				$("#account_cd option[value='A100']").remove();
				$("#account_cd option[value='B200']").remove();
				$("#account_cd option[value='C300']").remove();
			}
	
			
			/* 모달 단건조회 콤보박스  */
			
			
			function fn_selectComCombo_modal() {				
		
				var account_cd_modal = $("#account_cd_modal").val();
				
				selectComCombo("acc", "detail_account_cd_modal", "all",account_cd_modal,"101");
		 
				$("#account_cd_modal option[value='A100']").remove();
				$("#account_cd_modal option[value='B200']").remove();
				$("#account_cd_modal option[value='C300']").remove();
			
			}
		
		 	/* 지출결의 신청건 삭제 함수*/
		 	function fDeleteEmpDv() {
				
				var resultCallback = function(data) {
					fDeleteEmpDvResult(data);
				};
				
				callAjax("/accounting/deleteEmpDv.do", "post", "json", true, $("#empDvReg").serialize(), resultCallback);
			}
			
			/* 지출결의 삭제 콜백 함수*/
			function fDeleteEmpDvResult(data) {
				
				var currentPage = $("#currentPageEmpDv").val();
				
				if (data.result == "SUCCESS") {
					
					// 응답 메시지 출력
					alert(data.resultMsg);
					
					// 모달 닫기
					gfCloseModal();
					
					fListEmpDv();
					
				} else {
					alert(data.resultMsg);
				}		
			}
</script>

</head>
<body>
<form id="myForm" action=""  method="">
	<input type="hidden" id="currentPageEmpDv" value="1">
	<input type="hidden" id="tmpEmpDv" value="">
	<input type="hidden" id="tmpEmpDvNm" value="">
	<input type="hidden" name="userType" id="userType" value="${userType}">
	<input type="hidden" name="curloginID" id="curloginID" value="${loginID}">
	
	
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
								class="btn_nav">회계</a> <span class="btn_nav bold">
								지출결의서 신청</span> <a href="#" class="btn_set refresh">새로고침</a>
						</p>

						<p class="conTitle">
							<span>지출결의서 신청</span> <span class="fr">
							  <a class="btnType blue"
										href="javascript:fListEmpDv()" name="search"><span
										id="searchEnter">조회</span></a><br/>
							</span>
						</p>
						
			<!-- 지출결의서 조회 조건 -->
						
						<div class = "app_date_apply">
							<Strong>신청일자</Strong> <input type = "date" id="from_date">~<input
										type="date" id="to_date">
							<a class="btnType blue"  href = "javascript: fPopModalEmpDv() " name="modal"><span>신규등록</span></a>
						</div>	
						
						
						<div class = "selectEmpDv">
							<ul>
								<li>
								<strong>계정대분류명</strong>
									<select id ="account_cd" name ="account_cd" onChange="javascript:fn_selectComCombo()">
									<option></option>
									</select>	
								</li>
								<li>
								<strong>상세분류명</strong>
									<select id ="detail_account_cd" name ="detail_account_cd">
									<option></option>
									</select>
								</li>
								<li>
								<strong>승인여부</strong>
								<select id = "dv_app_yn" name= "dv_app_yn">
									<option value = "" selected>전체</option>
									<option value = "1">승인대기중</option>
									<option value = "2">승인</option>
									<option value = "3">반려</option>
								</select>
								</li>	
							</ul>
					</div>
			
			<!-- 페이지에 출력할 컬럼명 -->			
						
					<div class="divDvList">
						<table class="col">
							<caption>caption</caption>
								<colgroup>
									<col width="8%">
									<col width="9%">
									<col width="*%">
									<col width="*%">
									<col width="10%">
									<col width="10%">
									<col width="9%">
									<col width="*">
									<col width="10%">
									<col width="8%">
								</colgroup>
	
								<thead>
									<tr>
										<th scope="col">결의번호</th>
										<th scope="col">계정대분류명</th>
										<th scope="col">상세분류명</th>
										<th scope="col">거래처명</th>
										<th scope="col">신청일자</th>
										<th scope="col">사용일자</th>
										<th scope="col">지출금액</th>
										<th scope="col">승인여부</th>
										<th scope="col">승인/반려일자</th>
										<th scope="col">승인자</th>
									</tr>
								</thead>
							<tbody id="listEmpDv"></tbody>
						</table>
							</div>
						<div class="paging_area"  id="empDvPagination"> </div>
					</div>
						<h3 class="hidden">풋터 영역</h3>
						<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
					</li>
				</ul>
			</div>
		</div>
	</form>
		
		
	<!-- 지출결의서 신규 등록 및 수정 모달(단건 조회) -->	
	<form id="empDvReg">
		<input type ="hidden" name = "action" id = "action" value = "">
		<div id = "layer1" class="layerPop layerType2" style="width: 600px;">
			<dl>
			<dt>
				<strong>지출결의서 신청 및 삭제</strong>
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
							<tr id = "dv_form">
								<th scope="row">결의번호</th>
								<td><input type="text" class="inputTxt p100" name="dv_no" id="dv_no"/></td>
							</tr>
							<tr>
								<th scope="row">아이디</th>
								<td><input type="text" class="inputTxt p100" name="loginID" id="loginID" readonly/></td>
							</tr>
							<tr>
								<th scope="row">사원명</th>
								<td><input type="text" class="inputTxt p100" name="name" id="name" readonly/></td>
							</tr>
							<tr>
								<th scope="row">계정대분류명<span class="font_red">*</span></span></th>
								<td colspan="3">
								<select id ="account_cd_modal" name = "account_cd_modal" onChange = "javascript:fn_selectComCombo_modal()">
								</select></td>
							</tr>
							<tr>
								<th scope="row">상세과목명<span class="font_red">*</span></th>
								<td colspan="3">
								<select id ="detail_account_cd_modal" name = "detail_account_cd_modal">
								</select></td>
							</tr>
	
							<tr>
								<th scope="row">거래처명<span class="font_red">*</span></th>
								<td colspan="3"><input type="text" class="inputTxt p100"
									name="acc_name" id="acc_name" /></td>
							</tr>
							<tr>
								<th scope="row">신청일자</th>
								<td colspan="3"><input type="text" class="inputTxt p100"
									name="dv_reg_date" id="dv_reg_date" readonly/></td>
							</tr>
							<tr>
								<th scope="row">사용일자<span class="font_red">*</span></th>
								<td colspan="3"><input type="date" 
									name="dv_use_date" id="dv_use_date" class ="inputTxt p100" style ="font-size : 92%"/></td>
							</tr>
							<tr>
								<th scope="row">지출금액<span class="font_red">*</span></th>
								<td colspan="3"><input type="text" class="inputTxt p100"
									name="dv_amt" id="dv_amt" /></td>
							</tr>
							<tr id = "att_file_form">
								<th scope="row">증빙서류</th>
								<td colspan="3"><input type = "file" name = "att_file" id = "att_file"/></td>
							</tr>
							<tr style = "height: 100px">
								<th scope="row">비고</th>
								<td colspan="3"><textarea cols="20" rows="10" name = "dv_memo" id="dv_memo"  class = "p100" style = "height: 100px"/></textarea></td>
							</tr>
							<tr id = "dv_return_form">
								<th scope ="row">반려사유</th>
								<td colspan ="3"><textarea cols="20" rows="10" name = "dv_return" id="dv_return" readonly/></textarea></td>
							</tr>	
						</tbody>
					</table>

					<!-- e : 여기에 내용입력 -->

					<div class="btn_areaC mt30">
						<a href="" class="btnType blue" id="btnSaveEmpDv" name="btn"><span>저장</span></a> 
						<a href="" class="btnType blue" id="btnDeleteEmpDv" name="btn"><span>삭제</span></a> 
						<a href=""	class="btnType gray"  id="btnCloseEmpDv" name="btn"><span>닫기</span></a>
					</div>
				</dd>
			</dl>
			<a href=""  class="closePop"><span class="hidden">닫기</span></a>
		</div>				
	</form> <!--// content -->

</body>
</html>
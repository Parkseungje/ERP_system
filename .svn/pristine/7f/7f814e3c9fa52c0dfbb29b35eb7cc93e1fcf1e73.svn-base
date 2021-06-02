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

.dv_form{
	display : none;
}

.att_file_open{
	float : left;
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

		var pageSizeBmDv= 10;
		var pageBlockSizeBmDv = 5;

		
		/** OnLoad event */ 

		$(document).ready(function() {
			
			comcombo("ACCcd", "account_cd", "all");
			$("input:radio[name=dv_radio]").click(function(){
				 
			        if($("input[name=dv_radio]:checked").val() == "2"){
			            $("#dv_return").prop("disabled",true);
			            // radio 버튼의 value 값이 2이라면 반려사유창 비활성화
			 
			        }else if($("input[name=dv_radio]:checked").val() == "3"){
			              $("#dv_return").prop("disabled",false);
			            // radio 버튼의 value 값이 3이라면 반려사유창 활성화
			        }
			    });
			
			fListBmDv(); // 지출결의서 신청건 조회
			fRegisterButtonClickEvent(); //버튼 이벤트 초기화
		});

		
		/** 지출결의서 신청건 조회  **/
		function fListBmDv(currentPage) {
			
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
					,	pageSize    : pageSizeBmDv
			}
			
			var resultCallback = function(data) {
				fBmDvResult(data, currentPage);
			};
			
			//Ajax실행 방식
			//callAjax("Url",type,return,async or sync방식,넘겨준거,값,Callback함수 이름)
			
			callAjax("/accounting/listBmDv.do", "post", "text", true, param, resultCallback);
		}

		
		/** 지출결의 신청건 조회 콜백 함수 */
		function fBmDvResult(data, currentPage) {
			
			//alert(data);
			console.log(data);
			
			// 기존 목록 삭제
			$('#listBmDv').empty();
			
			// 신규 목록 생성
			$("#listBmDv").append(data);
			
			// 총 개수 추출
			var totalCntBmDv = $("#totalCntBmDv").val();
			
			// 페이지 네비게이션 생성
			var paginationHtml = getPaginationHtml(currentPage, totalCntBmDv, pageSizeBmDv, pageBlockSizeBmDv, 'fListBmDv');
			console.log("paginationHtml : " + paginationHtml);
			//alert(paginationHtml);
			$("#bmDvPagination").empty().append( paginationHtml );
			
			// 현재 페이지 설정
			$("#currentPageBmDv").val(currentPage);
		}
	
		
		/** 그룹코드 모달 실행 */
		function fPopModalBmDv(dv_no) {
			

				gfModalPop("#layer1");

				fSelectBmDv(dv_no);
			
		} 
	
		/** 지출결의건 단건 조회 함수*/
		
		function fSelectBmDv(dv_no) {

			var param = {
							dv_no : dv_no
						};
			
			var resultCallback = function(data) {
				fSelectBmDvResult(data);
			};
			
			callAjax("/accounting/selectBmDv.do", "post", "json", true, param, resultCallback);
		}
		
		/** 지출 결의건 모달 초기화 함수 */	
		function fInitFormBmDv(object) {
	
		   		$("#dv_no").focus();
				$("#dv_no").val(object.dv_no);
				$("#loginID").val(object.loginID);
				$("#name").val(object.name);
				$("#account_cd_modal").val(object.account_cd); 
				$("#detail_account_cd_modal").val(object.detail_account_cd); 
				$("#account_nm_modal").val(object.group_name); 
				$("#detail_account_nm_modal").val(object.detail_account_nm); 
				$("#acc_name").val(object.acc_name);
				$("#dv_reg_date").val(object.dv_reg_date);
				$("#dv_use_date").val(object.dv_use_date);
				$("#dv_amt").val(object.dv_amt);
				$("#att_file").val(object.att_file);
				$("#dv_memo").val(object.dv_memo);
				$("#dv_return").val(object.dv_return);
				$("#btnDeleteBmDv").show();
			   
				console.log(object);
				
				if( object.att_filename == "" || object.att_filename == null || object.att_filename == undefined)
				{
					$("#att_file_form").hide();
				}
				else{
					$("#att_file_form").show();
				}
				
				
				console.log(object.dv_app_yn);
				
				if((object.dv_app_yn == 2) || (object.dv_app_yn == 3)){
					$("#btnSaveBmDv").hide();
					$("#dv_app_yn_form").hide();	
					$("#dv_return").prop("readonly", true);
				}
				else{
					$("#btnSaveBmDv").show();
					$("#dv_app_yn_form").show();
					$("#dv_return").prop("readonly", false);
				}
			}
		
		/* 그룹코드 단건 조회 콜백 함수*/
	
		function fSelectBmDvResult(data) {

				gfModalPop("#layer1");
				
				fInitFormBmDv(data.bmDvModel);		
		}
		
		/** 버튼 이벤트 등록 */
		function fRegisterButtonClickEvent() {
			$('a[name=btn]').click(function(e) {
				e.preventDefault();

				var btnId = $(this).attr('id');

				switch (btnId) {
					case 'btnSaveBmDv' :
						fSaveAppDv();
						break;
					case 'btnCloseBmDv'  :
						gfCloseModal();
						break;
				}
			});
		}		
		
		/** 지출결의건 승인 및 반려 */
		function fSaveAppDv() {
			
			
			var resultCallback = function(data) {
				fAppDvResult(data);
			};
			
			callAjax("/accounting/saveAppDv.do", "post", "json", true, $("#bmDvReg").serialize(), resultCallback);
		
		
		}	
		
		/* 지출결의 삭제 콜백 함수*/
		function fAppDvResult(data) {
			
			var currentPage = $("#currentPageEmpDv").val();
			
			if (data.result == "SUCCESS") {
				
				// 응답 메시지 출력
				alert(data.resultMsg);
				
				// 모달 닫기
				gfCloseModal();
				
				fListBmDv();
				
			} else {
				alert(data.resultMsg);
			}		
		}
		
		
		/* 조회조건 계정정보 콤보박스 */
		
		function fn_selectComCombo() {				
			var account_cd = $("#account_cd").val();
			
			//console.log("account_cd : " + account_cd);
			selectComCombo("acc", "detail_account_cd", "all",account_cd,"101");
	   
			$("#account_cd option[value='A100']").remove();
			$("#account_cd option[value='B200']").remove();
			$("#account_cd option[value='C300']").remove();
		}


		/* 지출결의 첨부파일 경로 가져오기 */
		function fDownloadAttFile(){
			
			 var dv_no = $("#dv_no").val();
			 
			 var params = "";
			   params += "<input type='hidden' name='dv_no' value='"+ dv_no +"' />";
			   
			   jQuery("<form action='/accounting/downloadDvFile.do' method='post'>"
					   +params+"</form>").appendTo('body').submit().remove();
			
		} 
				
</script>

</head>
<body>
<form id="myForm" action=""  method="">
	<input type="hidden" id="currentPageBmDv" value="1">
	<input type="hidden" id="tmpBmDv" value="">
	<input type="hidden" id="tmpBmDvNm" value="">
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
								지출결의서 조회 및 승인</span> <a href="#" class="btn_set refresh">새로고침</a>
						</p>

						<p class="conTitle">
							<span>지출결의서 조회 및 승인</span> <span class="fr">
							  <a class="btnType blue"
										href="javascript:fListBmDv()" name="search"><span
										id="searchEnter">조회</span></a><br/>
							</span>
						</p>
						
			<!-- 지출결의서 조회 조건 -->
						
						<div class = "app_date_apply">
							<Strong>신청일자</Strong> <input type = "date" id="from_date">~<input
										type="date" id="to_date">
						</div>	
						
						<div class = "selectEmpDv">
							<ul>
								<li>
								<strong>계정대분류명</strong>
									<select id ="account_cd" name ="account_cd" onChange="javascript:fn_selectComCombo()">
									</select>	
								</li>
								<li>
								<strong>상세분류명</strong>
									<select id ="detail_account_cd" name ="detail_account_cd">
									</select>
								</li>
								<li>
								<strong>승인여부</strong>
								<select id = "dv_app_yn" name = "dv_app_yn">
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
									<col width="*%">
									<col width="*">
									<col width="*">
									<col width="*">
									<col width="*">
									<col width="*">
									<col width="*">
									<col width="*%">
									<col width="*%">
									<col width="*%">
									<col width="*%">
								</colgroup>
	
								<thead>
									<tr>
										<th scope="col">결의번호</th>
										<th scope="col">아이디</th>
										<th scope="col">사원명</th>
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
							<tbody id="listBmDv"></tbody>
						</table>
						<div class="paging_area"  id="bmDvPagination"> </div>
					</div>
					<h3 class="hidden">풋터 영역</h3>
						<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
					</li>
				</ul>
			</div>
		</div>
	</form>
	<!-- 지출결의서 신규 등록 및 수정 모달(단건 조회) -->	
		<form id = "bmDvReg">
		<div id="layer1" class="layerPop layerType2" style="width: 600px;">
			<dl>
			<dt>
				<strong>지출결의서 승인 및 반려</strong>
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
							<tr class = "dv_form">
								<th scope="row">결의번호</th>
								<td><input type="text" class="inputTxt p100" name="dv_no" id="dv_no"></td>
							</tr>
							<tr>
								<th scope="row">아이디</th>
								<td><input type="text" class="inputTxt p100" name="loginID" id="loginID" readonly/></td>
							</tr>
							<tr>
								<th scope="row">사원명</th>
								<td><input type="text" class="inputTxt p100" name="name" id="name" readonly/></td>
							</tr>
							<tr class = "dv_form">
								<th scope="row">계정과목코드</th>
								<td colspan="3">
								<input type="text" class="inputTxt p100" name="account_cd_modal" id="account_cd_modal" readonly/>
								</td>
							</tr>
							<tr>
								<th scope="row">계정대분류명 </th>
								<td colspan="3">				
								<input type="text" class="inputTxt p100" name="account_nm_modal" id="account_nm_modal" readonly/>
								</td>
							</tr>
							<tr class = "dv_form">
								<th scope="row">상세과목코드</th>
								<td colspan="3">
								<input type="text" class="inputTxt p100" name="detail_account_cd_modal" id="detail_account_cd_modal" readonly/>
								</td>
							</tr>
							<tr>
								<th scope="row">상세과목명</th>
								<td colspan="3">
								<input type="text" class="inputTxt p100" name="detail_account_nm_modal" id="detail_account_nm_modal" readonly/>
								</td>
							</tr>
							<tr>
								<th scope="row">거래처명</th>
								<td colspan="3"><input type="text" class="inputTxt p100"
									name="acc_name" id="acc_name" readonly/></td>
							</tr>
							<tr>
								<th scope="row">신청일자</th>
								<td colspan="3"><input type="text" class="inputTxt p100" name="dv_reg_date" id="dv_reg_date" readonly/></td>
							</tr>
							<tr>
								<th scope="row">사용일자</th>
								<td colspan="3"><input type="text" class="inputTxt p100" name="dv_use_date" id="dv_use_date" readonly/></td>
							</tr>
							<tr>
								<th scope="row">지출금액</th>
								<td colspan="3"><input type="text" class="inputTxt p100"
									name="dv_amt" id="dv_amt" readonly/></td>
							</tr>
							<tr id = "att_file_form">
								<th scope="row">증빙서류</th>
								<td colspan="3">
								 <a class="btnType gray att_file_open"
										href="javascript:fDownloadAttFile()" name="att_file_download"><span
										id="att_file_download">다운로드</span></a><br/>
								</td>
							</tr>
							<tr style = "height: 100px">
								<th scope ="row">비고</th>
								<td colspan ="3"><textarea cols="20" rows="10" name = "dv_memo" id="dv_memo"  class = "p100" style = "height: 100px" readonly/></textarea></td>
							</tr>
							<tr id ="dv_app_yn_form">
							<th scope="row">승인구분 <span class="font_red">*</span></th>
							<td colspan="3"><input type="radio" id="radioYes"
								name="dv_radio"  value="2" /> <label for="radioYes">승인</label>
								<input type="radio" id="radioNo"
								name="dv_radio"  value="3" /> <label for="radioNo">반려</label></td>
							</tr>
							<tr>
								<th scope ="row">반려사유</th>
								<td colspan ="3"><textarea cols="20" rows="10" name = "dv_return" id="dv_return"/></textarea></td>
							</tr>
						</tbody>
					</table>
					<!-- e : 여기에 내용입력 -->

					<div class="btn_areaC mt30">
						<a href="" class="btnType blue" id="btnSaveBmDv" name="btn"><span>저장</span></a> 
						<a href=""	class="btnType gray"  id="btnCloseBmDv" name="btn"><span>닫기</span></a>
					</div>
				</dd>
			</dl>
			<a href=""  class="closePop"><span class="hidden">닫기</span></a>
			</div>
			</form>	
		 <!--// content -->
	
	
	
	
</body>
</html>
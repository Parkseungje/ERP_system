<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>QnA</title>

<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>

<script type="text/javascript">

	// 1:1문의 페이징 설정
	var pageSizeQnA = 10;
	var pageBlockSizeQnA = 5;
	
	
	/** OnLoad event */ 
	$(function() {
	
		// 1:1문의 조회
		fListQnA();
		
		// 버튼 이벤트 등록
		fRegisterButtonClickEvent();
	});
	

	/** 버튼 이벤트 등록 */
	function fRegisterButtonClickEvent() {
		$('a[name=btn]').click(function(e) {
			e.preventDefault();

			var btnId = $(this).attr('id');
           
			switch (btnId) {
				case 'btnSaveQnA' :
					fSaveQnAAns();
					break;
				case 'btnDeleteInqAns' :
					fDeleteInqAns();
					break;
				case 'btnSaveDtlCod' :
					fSaveDtlCod();
					break;
				case 'btnDeleteDtlCod' :
					fDeleteDtlCod();
					break;
				case 'btnCloseGrpCod' :
				case 'btnCloseDtlCod' :
					gfCloseModal();
					break;
			}
		});
	}
	
	
	/** 1:1문의 조회 */
	function fListQnA(currentPage) {
		
		currentPage = currentPage || 1;
		
		console.log("currentPage : " + currentPage);
		
		var param = {
					currentPage : currentPage
				,	pageSize : pageSizeQnA
		}
		
		var resultCallback = function(data) {
			fListQnAResult(data, currentPage);
		};
		
		//Ajax실행 방식
		//callAjax("Url",type,return,async or sync방식,넘겨준거,값,Callback함수 이름)
		//html로 받을거라 text
		callAjax("/community/listQnA.do", "post", "text", true, param, resultCallback);
	}
	
	
	/** 1:1문의 조회 콜백 함수 */
	function fListQnAResult(data, currentPage) {
				//alert(data);
		console.log(data);		
		
		// 기존 목록 삭제
		$('#listQnA').empty();
		$("#listQnA").append(data);
		
		// 총 개수 추출
		var totalCntlistQnA = $("#totalCntlistQnA").val();
			
	
		// 페이지 네비게이션 생성
		var paginationHtml = getPaginationHtml(currentPage, totalCntlistQnA, pageSizeQnA, pageBlockSizeQnA, 'fListQnA');
		console.log("paginationHtml : " + paginationHtml);

		$("#listQnAPagination").empty().append( paginationHtml );

	}
	
	
	/** 1:1문의 모달 실행 */
	function fPopModalQnA(inq_no) {

		 $("#selectedInqNo").val(inq_no);
		 
		console.log(typeof(inq_no));
		console.log(inq_no);
		var url = "/community/QnAByInqNo.do";
		var param = {
				inq_no : inq_no
		};
		
		var callback = function(data){
			console.log(JSON.stringify(data));
			$("#inq_cod_nm").val(data.inqNoData.name);
			$("#inq_cod_day").val(data.inqNoData.inq_regdate);
			$("#inq_title").val(data.inqNoData.inq_title);
			$("#inq_content").val(data.inqNoData.inq_content);
			$("#ans_title").val(data.inqNoData.ans_title);
			$("#ans_content").val(data.inqNoData.ans_content);
			gfModalPop("#QnAModal");		
		}
		
		callAjax(url, "post", "json", true, param, callback);
		
		
		
	}
	
	 /* 공지사항 모달창(팝업) 실행  */
	 function fQnAModal(inq_no) {
		 
		 // 신규저장 하기 버튼 클릭시 (값이 null)
		 if(inq_no == null || inq_no==""){
			// Tranjection type 설정
			//alert("넘을 찍어보자!!!!!!" + inq_no);
			
			$("#action").val("I"); // insert 
			frealPopModal(inq_no); // 공지사항 초기화 
			
			//모달 팝업 모양 오픈! (빈거) _ 있는 함수 쓰는거임. 
			gfModalPop("#QnAModal");
			
		 }else{
			// Tranjection type 설정
			$("#action").val("U");  // update
			fdetailModal(inq_no); //번호로 -> 공지사항 상세 조회 팝업 띄우기
		 }

	 }
	
	/** 1:1문의 단건 조회 */
	function fSelectGrpCod(inq_no) {
		
		var param = { inq_no : inq_no };
		
		var resultCallback = function(data) {
			fSelectGrpCodResult(data);
		};
		
		callAjax("/community/selectComnGrpCod.do", "post", "json", true, param, resultCallback);
	}
	
	
	/** 1:1문의 단건 조회 콜백 함수*/
	function fSelectGrpCodResult(data) {

		if (data.result == "SUCCESS") {

			// 모달 팝업
			gfModalPop("#layer1");
			
			// 1:1문의 폼 데이터 설정
			fInitFormGrpCod(data.comnGrpCodModel);
			
		} else {
			alert(data.resultMsg);
		}	
	}
	
	

	
	//1:1답변 저장
	function fSaveQnAAns(){
		
		var select_inq_no = $("#selectedInqNo").val();
		var ans_title = $("#ans_title").val();
		var ans_content = $("#ans_content").val();
		
		var param = {
				ans_title : ans_title,
				ans_content : ans_content,
				inq_no : select_inq_no
		};
		
		var resultCallback = function(data) {
			fSaveAnsByQnA(data);
		};
		
		callAjax("/community/QnAInAns.do", "post", "json", true, param, resultCallback)
		
	}
	
	 /* 팝업 _ 초기화 페이지(신규) 혹은 내용뿌리기  */
	 function frealPopModal(object){
		 
		 if(object == "" || object == null || object == undefined){
			 var writer = $("#swriter").val();
			 //var Now = new Date();
			 
			 $("#loginID").val(writer);
			 $("#loginID").attr("readonly", true);
			 
			 $("#write_date").val();
			 
			 $("#inq_title").val("");
			 $("#inq_note").val("");
			 
			 $("#btnDeleteInqAns").hide(); // 삭제버튼 숨기기
			 $("#btnCloseGrpCod").hide();
			 $("#btnSaveQnA").show();
			
			 
		 }else{
			 
			 //alert("숫자찍어보세 : " + object.wno);// 페이징 처리가 제대로 안되서 
			 $("#loginID").val(object.loginID);
			 $("#loginID").attr("readonly", true); // 작성자 수정불가 
			 
			 $("#write_date").val(object.write_date);
			 $("#write_date").attr("readonly", true); // 처음 작성된 날짜 수정불가 
			 
			 $("#inq_title").val(object.nt_title);
			 $("#inq_note").val(object.nt_note);

			 
			 $("#inq_no").val(object.nt_no); // 중요한 num 값도 숨겨서 받아온다. 
			 
			 $("#btnDeleteInqAns").show(); // 삭제버튼 보이기 
			 $("#btnSaveQnA").hide();
			 $("#btnCloseGrpCod").css("display","");
			 //if문써서 로그인 아이디 == 작성자 아이디 일치시  --- 추가하기 
			 //$("#grp_cod").attr("readonly", false);  // false, true(읽기만)로 수정
			
			 
		 }
	 }
	 
	/** 1:1문의 저장 콜백 함수 */
	function fSaveAnsByQnA(data) {
		
		// 목록 조회 페이지 번호
		var currentPage = "1";
		if ($("#action").val() != "I") {
			currentPage = $("#currentPageComnGrpCod").val();
		}
		
		if (data.result == "SUCCESS") {
			
			// 응답 메시지 출력
			alert(data.resultMsg);
			
			// 모달 닫기
			gfCloseModal();
			
			// 목록 조회
			fListQnA(currentPage);
			
		} else {
			// 오류 응답 메시지 출력
			alert(data.resultMsg);
		}
		
		// 입력폼 초기화
		$("#ans_title").val("");
		$("#ans_content").val("");
	}

	
	/** 1:1문의 삭제 */
	function fDeleteInqAns() {
		
		var inq_no = $("#selectedInqNo").val();
		
		console.log(inq_no);
		
		var param = {inq_no : inq_no};
		var resultCallback = function(data) {
			fDeleteInqAnsResult(data);
		};
		
		callAjax("/community/deleteInqAns.do", "post", "json", true, param, resultCallback);
	}
	
	
	/** 1:1문의 삭제 콜백 함수 */
	function fDeleteInqAnsResult(data) {
		
		var currentPage = $("#currentPageComnGrpCod").val();
		
		if (data.result == "SUCCESS") {
			
			// 응답 메시지 출력
			alert(data.resultMsg);
			
			// 모달 닫기
			gfCloseModal();
			
			// 목록 조회
			fListQnA(currentPage);
			
			
		} else {
			alert(data.resultMsg);
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
	<input type="hidden" id="selectedInqNo" value="">
	
	
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
								class="btn_nav">커뮤니티</a> <span class="btn_nav bold">1:1문의
								</span> <a href="#" class="btn_set refresh">새로고침</a>
						</p>
					
						
						<p class="search"></p>
						<p class="conTitle">
							<span>QnA</span> 
							<span class="fr"> 
								<c:set var="nullNum" value=""></c:set>
								<a class="btnType blue" href="javascript:fQnAModal(${nullNum});" name="modal">
								<span>글작성</span></a>
							</span>
							<!-- <span class="fr">
			                  <select id="searchKey" name="searchKey" style="width: 80px;" v-model="searchKey">
			                    <option value="all" id="option1" selected>전체</option>
			                    <option value="ware_name" id="option1">제목</option>
			                    <option value="ware_address" id="option2">내용</option>
			                  </select> <input type="text" id="searchWord" name="searchWord" v-model="searchWord" placeholder="" style="height: 28px;  width: 600px;"> <a class="btnType blue" href="javascript:whInfoFormList()" onkeydown="enterKey()" name="search"><span id="searchEnter">검 색</span></a>
			                </span> -->

						
						</p>
						
						<div class="divComGrpCodList">
							<table class="col">
								<caption>caption</caption>
								<colgroup>
									<col width="5%">
									<col width="45%">
									<col width="20%">
									<col width="15%">
									<col width="15%">
								</colgroup>
	
								<thead>
									<tr>
										<th scope="col">번호</th>
										<th scope="col">제목</th>
										<th scope="col">작성일</th>
										<th scope="col">작성자</th>
										<th scope="col">답변</th>
									</tr>
								</thead>
								<tbody id="listQnA">
								</tbody>
							</table>
						</div>
	
						<div class="paging_area"  id="listQnAPagination"> </div>
	
					</div> <!--// content -->

					</li>
			</ul>
		</div>
	</div>

	<!-- 모달팝업 -->
	<div id="QnAModal" class="layerPop layerType2" style="width: 900px;">
		<dl>
			<dt>
				<strong>QnA</strong>
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
							<th scope="row">작성자 </th>
							<td><input type="text" class="inputTxt p100" name="grp_cod" id="inq_cod_nm" readonly/></td>
							<th scope="row">작성일 </th>
							<td><input type="text" class="inputTxt p100" name="grp_cod_nm" id="inq_cod_day" readonly /></td>
						</tr>
						<tr>
							<th scope="row">제목 </th>
							<td colspan="3"><input type="text" class="inputTxt p100"
								name="grp_cod_eplti" id="inq_title" maxlength="100"readonly/></td>
						</tr>
						
						<tr>
							<th scope="row"></th>
							<td colspan="3" ><textarea class="inputTxt p100"
							style="height: 200px; word-break : break-all;"
								name="grp_cod_eplti" id="inq_content"readonly></textarea></td>
						</tr>

						<tr>
							<th scope="row">답변제목 <span class="font_red">*</span></th>
							<td colspan="3"><input type="text" class="inputTxt p100"
								name="ans_title" id="ans_title" maxlength="100"/></td>
						</tr>
						
						<tr>
							<th scope="row">답변내용 <span class="font_red">*</span></th>
							<td colspan="3" ><textarea class="inputTxt p100"
							style="height: 200px; word-break : break-all;"
								name="ans_content" id="ans_content"></textarea></td>
						</tr>
						</tbody>
				</table>

				<!-- e : 여기에 내용입력 -->

				<div class="btn_areaC mt30">
				    <a href="" class="btnType blue" id="btnSaveQnA" name="btn"><span>저장</span></a> 
					<a href="" class="btnType blue" id="btnDeleteInqAns" name="btn"><span>삭제</span></a> 
					<a href="" class="btnType gray" id="btnCloseGrpCod" name="btn"><span>취소</span></a>
				</div>
			</dd>
		</dl>
		<a href="" class="closePop"><span class="hidden">닫기</span></a>
	</div>

</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>지원현황(기업)</title>
<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>
<script type="text/javascript">
	//페이징입니다.
	var pageSizelist = 5;
	var pageBlockSizelist = 5;

	//유저페이징입니다.
	var pageSizeDtlList = 5;
	var pageBlockSizeDtlList = 5;
	//ON LOAD EVENT****
	$(function() {
		fcnsList();

		fRegisterButtonClickEvent();
	});
	function fRegisterButtonClickEvent() {
		$('a[name=btn]').click(function(e) {
			e.preventDefault();

			var btnId = $(this).attr('id');

			switch (btnId) {
			case 'btnSave':
				fSaveUserList();
				break;
			case 'btnCloseGrpCod':
				gfCloseModal();
				break;
			case 'btnDeleteClist':
				fDeleteClist();
				break;
			}
		});
	}
	//키 다운
	function enterKey() {

		if (event.keyCode == '13') {
			fcnsList();
		}
	}

	// 프로젝트 리스트(기업)
	function fcnsList(currentPage) {

		var searchKey = $("#searchKey").val();
		var searchWord = $("#searchWord").val();
		var stddate = $("#stddate").val();
		var enddate = $("#enddate").val();
		
		currentPage = currentPage || 1;

		var param = {
			currentPage : currentPage,
			pageSize : pageSizelist,
			searchKey : searchKey,
			searchWord : searchWord,
			stddate : stddate,
			enddate : enddate			
		}

		var resultCallback = function(data) {

			fcnsListResult(data, currentPage);
		};

		callAjax("/conSupport/projectListC.do", "post", "text", true, param, resultCallback);
	}
	//과정콜백
	function fcnsListResult(data, currentPage) {
		console.log("data : " + data);
		
		

		$('#prolist').empty();
		$('#prolist').append(data);
		
		var totalCntlist = $("#totcnt").val();

		var paginationHtml = getPaginationHtml(currentPage, totalCntlist,
				pageSizelist, pageBlockSizelist, 'fcnsList');
		
		$("#listPagiNation").empty().append(paginationHtml);
		//$("#currentPagelist").val(currentPage);

	}
	//프로젝트 지원자 목록 조회
	function fcnsUserList(currentPage, lec_seq, lec_nm) {

		currentPage = currentPage || 1;

		$("#tmpLecSeq").val(lec_seq);
		$("#tmpLecNm").val(lec_nm);

		var param = {
			lec_seq : lec_seq,
			currentPage : currentPage,
			pageSize : pageSizeDtlList
		}

		var resultCallback = function(data) {

			fcnsUserListResult(data, currentPage);
		};

		callAjax("/conSupport/SupportBUserList.do", "post", "text", true, param,
				resultCallback);
	}
	//유저 뽑기 콜백
	function fcnsUserListResult(data, currentPage) {

		$('#cnsUserDtlList').empty();

		var $data = $($(data).html());

		var $cnsUserDtlList = $data.find("#cnsUserDtlList");
		$("#cnsUserDtlList").append($cnsUserDtlList.children());

		var $totalCntDtlList = $data.find('#totalCntDtlList');
		var totalCntDtlList = $totalCntDtlList.text();

		var lec_seq = $("#tmpLecSeq").val();
		var lec_nm = $("#tmpLecNm").val();
		var paginationHtml = getPaginationHtml(currentPage, totalCntDtlList,
				pageSizeDtlList, pageBlockSizelist, 'fcnsUserList', [ lec_seq ]);
		$("#listDtlPagiNation").empty().append(paginationHtml);

		$("#currentPageDtlList").val(currentPage);
	}
	//유저모달 실행
	function fPopModalUserList(cns_seq, loginId, lecNm) {
		$("#cns_seq").val("");
		$("#cns_date").val("");
		$("#cns_place").val("");
		$("#cns_cstnt").val("");
		$("#cns_cstee").val(loginId);
		$("#task_tm").val("");
		$("#enr_user").val("");
		$("#enr_date").val("");
		$("#upd_user").val("${sessionScope.loginId}");
		$("#upd_date").val("");
		$("#cns_check").val("");
		$("#cns_content").val("");
		$("birthday1").val("");//달력설정
		$("#cns_nm").val(lecNm);
		
		var lec_nm = $("#tmpLecNm").val();
		
		$("#cns_nm").val(lec_nm);
		gfModalPop("#layer1");
	}
	//단건 유저 뽑기
	function fSelectDtlCns(loginID, lec_seq) {

		alert(loginID, lec_seq);
		var param = {
			lec_seq : lec_seq,
			loginID : loginID
		};
		var resultCallback = function(data) {
			fSelectDtlCnsResult(data);
		};

		callAjax("/mss/selectUserList.do", "post", "json", true, param,
				resultCallback);
	}
	//단건 유저 뽑기 콜백
	function fSelectDtlCnsResult(data) {
		if (data.result == "SUCCESS") {
			console.log(data.cnsList);
			gfModalPop("#layer2");

			//fInitFormaPlist(data.cnsList);
		} else {
			alert("실패");
		}
	}
	//코드 저장띠
	function fSaveUserList() {

		$("#action").val("I");
		if (!fValidateUserList()) {
			return;
		}

		var resultCallback = function(data) {
			fSaveUserListResult(data);
		};

		callAjax("/mss/saveUserList.do", "post", "json", true, $("#myForm")
				.serialize(), resultCallback);
	}

	//그룹코드 저장띠 콜백
	function fSaveUserListResult(data) {

		var currentPage = "1";
		if ($("#action").val() != "I") {
			currentPage = $("#currentPageDtlList").val();
		}

		if (data.result == "SUCCESS") {
			alert(data.resultMsg);

			gfCloseModal();

			var lec_seq = $("#tmpLecSeq").val();
			var lec_nm = $("#tmpLecNm").val();
			fcnsUserList(currentPage, lec_seq, lec_nm);

		} else {

			alert(data.resultMsg);
		}
		fInitFormlist();
	}

	//유저리스트 저장 validation
	function fValidateUserList() {

		var chk = checkNotEmpty([ [ "cns_cotent", "상담내용을 입력하세요." ],
				[ "cns_nm", "강의명을 입력해주세요." ], ]);
		if (!chk) {
			return;
		}
		return true;
	}
	//상담삭제
	
	function fDeleteClist(){
		
		var resultCallback = function(data){
			fDeleteClistResult(data);
		};
		callAjax("/mss/deleteClist.do", "post", "json", true, $("#myForm")
				.serialize(), resultCallback);
	}
	
	function fDeleteClistResult(data){
		
		var currentPage = $("#currentPagelist").val();
		
		if (data.result == "SUCEESS"){
			alert(data.resultMsg);
			
			gfCloseModal();
			
			fcnsList(currentPage, searchWord);
		}
	}
</script>
</head>
<body>
	<form id="myForm" action="" method="">
		<input type="hidden" id="currentPagelist" value="1"> <input
			type="hidden" id="currentPageDtlList" value="1"> <input
			type="hidden" id="tmpLecSeq" value=""> <input type="hidden"
			id="tmpLecNm" value=""> <input type="hidden" id="action"
			name="action" value="">

		<div id="mask"></div>
		<div id="wrap_area">

			<h2 class="hidden">header 영역</h2>
			<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

			<h2 class="hidden">컨텐츠 영역</h2>
			<div id="container">
				<ul>
					<li class="lnb"><jsp:include
							page="/WEB-INF/view/common/lnbMenu.jsp"></jsp:include> <!--// lnb 영역 -->
					</li>
					<li class="contents">
						<!-- contents -->
						<h3 class="hidden">contents 영역</h3>

						<div class="content">
							<p class="Location">
								<a href="#" class="btn_set home">메인으로</a> <a href="#"
									class="btn_nav">마이페이지</a> <span class="btn_nav bold">
									일반 지원현황 </span> <a href="#" class="btn_set refresh">새로고침</a>
							</p>
							
							<p class="conTitle">
								<span id="">일반 지원현황</span>
							</p>
							 
						
							
							<p class="search">
								<select id="searchKey" name="searchKey" style="width: 100px;">
									<option value="lec_nm" id="option1" selected="selected">회사명</option>
									
								</select> <input type="text" id="searchWord" name="searchWord"
									placeholder="" style="height: 28px;">
									
								
									
											
							 마감일자              			    
                     			    <input type="date" name="stddate" id="stddate" style="font-size: 15px" />                     			        
                     			     ~                  			    
                     			    <input type="date" class="" name="enddate" id="enddate" style="font-size: 15px" />          
									
							 <a	class="btnType blue" href="javascript:fcnsList()"
									onkeydown="enterKey()" name="search"><span id="searchEnter">검색</span></a>
							</p>
							
							 <p class="conTitle mt10">
								<span></span><span class="fr">
								</span>
							</p> 
							
							
							
							<span style="font-weight: bold; color: gray;"></span>
							<div class="divlist">
								<table class="col">
									<caption>caption</caption>
									<colgroup>
										
										<col width="20%">
										<col width="20%">
										<col width="20%">
										<col width="20%">
										<col width="20%">
									</colgroup>
									<thead>
										<tr>
											<th scope="col">회사명</th>
											<th scope="col">프로젝트명</th>
											<th scope="col">마감일자</th>
											<th scope="col">지원자수</th>
											<th scope="col">취소여부</th>
											
										</tr>
									</thead>
									<tbody id="prolist"></tbody>
								</table>
							</div>
							<div class="paging_area" id="listPagiNation"></div>

							 <p class="conTitle mt50">
								<span></span><span class="fr">
								</span>
							</p> 

							<div class="divCnsUserDtlList">
								<table class="col">
									<caption>caption</caption>
									<colgroup>
										<col width="5%">
										<col width="5%">
										<col width="5%">
										<col width="5%">
										<col width="5%">
									</colgroup>
									<thead>
										<tr>
											<th scope="col">성명</th>
											<th scope="col">직무</th>
											<th scope="col">희망연봉</th>
											<th scope="col">등급</th>
											<th scope="col">전문기술</th>
										</tr>
									</thead>
									<tbody id="cnsUserDtlList">
										<tr>
											<td colspan="12">이름을 클릭하여 확인해주세요.</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="paging_area" id="listDtlPagiNation"></div>
						</div>
					</li>
				</ul>
			</div>
		</div>
		<%-- <!-- 모달팝업 -->
		<div id="layer1" class="layerPop layerType2" style="width: 600px;">
			<dl>
				<dt>
					<strong>수강상담관리등록</strong>
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
							<a><span class="font_red">※등록/수정 후 저장을 눌러주세요.</span></a>
							<tr>
								<th scope="row">상담과목 <span class="font_red"></span></th>
								<td><input type="text" class="inputTxt p100" name="cns_nm"
									id="cns_nm" /> <input type="hidden" class="inputTxt p100"
									name="cns_seq" id="cns_seq" /></td>
								<th scope="row">상담장소</th>
								<td colspan="3"><input type="text" class="inputTxt p100"
									name="cns_place" id="cns_place" /></td>
							</tr>
							<tr>
								<th scope="row">상담자 <span class="font_red"></span></th>
								<td><input type="text" class="inputTxt p100"
									name="cns_cstnt" id="cns_cstnt" />
								<th scope="row">대상자</th>
								<td colspan="3"><input type="text" class="inputTxt p100"
									name="cns_cstee" id="cns_cstee" /></td>
							</tr>
							<tr>
								<th scope="row">상담일자 <span class="font_red"></span></th>
								<td colspan="3"><input type="date" class="inputTxt p100" name="cns_date"
									id="cns_date" style="font-size: 15px" />
							</tr>
							<tr>
								<th scope="row">등록자 <span class="font_red"></span></th>
								<td><input type="text" class="inputTxt p100"
									name="enr_user" id="enr_user" />
								<th scope="row">수정자</th>
								<td colspan="3"><input type="text" class="inputTxt p100"
									name="upd_user" id="upd_user" /></td>

							</tr>
							<tr>
								<th scope="row">상담내용 <span class="font_red">*</span></th>
								<td colspan="3"><textarea class="inputTxt p100"
										name="cns_content" id="cns_content"
										placeholder="상담 내용을 입력하세요." /></textarea></td>
							</tr>

							<tr>
								<th scope="row">확인여부 <span class="font_red"></span></th>
								<td><input type="text" class="inputTxt p100"
									name="cns_check" id="cns_check" style="font-size: 15px" />
							</tr>
					</table>


					<!-- e : 여기에 내용입력 -->

					<div class="btn_areaC mt30">
						<a href="" class="btnType blue" id="btnSave" name="btn"><span>저장</span></a>
						<a href="" class="btnType blue" id="btnDeleteClist" name="btn"><span>삭제</span></a>
						<a href="" class="btnType gray" id="btnCloseGrpCod" name="btn"><span>취소</span></a>
					</div>
				</dd>
			</dl>
			<a href="" class="closePop"><span class="hidden">닫기</span></a>
		</div> --%>
	</form>
</body>
</html>
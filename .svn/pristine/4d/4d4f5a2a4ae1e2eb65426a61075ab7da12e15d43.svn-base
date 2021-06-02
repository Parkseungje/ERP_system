<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title> 공지사항  </title>

<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>

<script type="text/javascript">

	// 페이징 설정 
	var pageSize = 5;    	// 화면에 뿌릴 데이터 수 
	var pageBlock = 5;		// 블럭으로 잡히는 페이징처리 수
	
	/* onload 이벤트  */
	
	// 날짜세팅
	
	$(function(){
		
        var today = new Date();
		
        
        fButtonClickEvent();
        
		// 공지사항 리스트 뿌리기 함수 
		selectNoticeList();		
		
	});
	
	/* 버튼 이벤트 등록 - 저장, 수정, 삭제  */
	function fButtonClickEvent(){
		$('a[name=btn]').click(function(e){
			e.preventDefault(); // ?? 
					
			var btnId = $(this).attr('id');
			
			//alert("btnId : " + btnId);
			
			switch(btnId){
			case 'btnSaveNotice' : fSaveNotice(); // save 안에 저장,수정
				//alert("저장버튼 클릭!!!이벤트!!");
				break;
			case 'btnDeleteNotice' : fDeleteNotice();	// 만들자 
				// alert("삭제버튼 클릭!!!이벤트!!");		
				break;
			case 'btnClose' : gfCloseModal();  // 모달닫기 
			selectNoticeList(); // 첫페이지 다시 로딩 
				break;
			case 'btnUpdateNotice' : fUpdateNotice();  // 수정하기
				break;
			case 'searchBtn' : selectNoticeList();  // 검색하기
				break;
				
			//case 'commentWrite' : fCommentInsert();   // 댓글--> 답변글로 변경 // 저장 
				//break;
			}
		});
	}
	
	/* 공지사항 리스트 불러오기  */
	function selectNoticeList(currentPage){
		
		currentPage = currentPage || 1;   // or		
		
//alert("지금 현재 페이지를 찍어봅시다. " + currentPage);
		var title = $("#title").val();
		var from_date =$("#from_date").val();
		var to_date =$("#to_date").val();
		var contents =$("#contents").val();
		var userID = $("#userID").val();
		
		//alert(userID);
		
		var param = {
				title : title , 
				currentPage : currentPage ,
				pageSize : pageSize , 
				from_date:from_date,
				to_date:to_date,
				contents:contents,
				userID:userID
		}

		console.log("param : " + param);
		
		var resultCallback = function(data){  // 데이터를 이 함수로 넘깁시다. 
			noticeListResult(data, currentPage); 
		}
		
		callAjax("/system/noticenewList.do","post","text", true, param, resultCallback);
		
	}
	
	/* callAjax 공통 common.js 에서 퍼옴  -> 이렇게 생긴 함수입니다.  
	
	function fOnloadImg(param){
		var resultCallback = function(data) {
			fOnloadImgResult(data);
		};
		callAjax("/image/selectImgSize.do", "post", "json", false, param, resultCallback);
	 } */
	

	 /* 공지사항 리스트 data를 콜백함수를 통해 뿌려봅시당   */
	 function noticeListResult(data, currentPage){
		 
		 console.log(data);
		 
		 // 일단 기존 목록을 삭제합니다. (변경시 재부팅 용)
		 $('#noticeList').empty();
		 
		 $('#noticeList').append(data);	
		 
		 // 리스트의 총 개수를 추출합니다. 
		 //var totalCnt = $data.find("#totalCnt").text();
		 var totalCnt = $("#totcnt").val();  // qnaRealList() 에서보낸값 
		 
		 // * 페이지 네비게이션 생성 (만들어져있는 함수를 사용한다 -common.js)
		 // function getPaginationHtml(currentPage, totalCount, pageRow, blockPage, pageFunc, exParams)
		 // 파라미터를 참조합시다. 
	     var list = $("#tmpList").val();
		 //var listnum = $("#tmpListNum").val();
	     var pagingnavi = getPaginationHtml(currentPage, totalCnt, pageSize, pageBlock, 'selectNoticeList',[list]);
		 
	     console.log("pagingnavi : " + pagingnavi);
		 // 비운다음에 다시 append 
	     $("#pagingnavi").empty().append(pagingnavi); // 위에꺼를 첨부합니다. 
		 
		 // 현재 페이지 설정 
	    $("#currentPage").val(currentPage);
		 
	 }
	 
	
	 
	 /* 공지사항 모달창(팝업) 실행  */
	 function fNoticeModal(noticeNo) {
		 // 신규저장 하기 버튼 클릭시 (값이 null)
		 if(noticeNo == null || noticeNo==""){
			// Tranjection type 설정
			//alert("넘을 찍어보자!!!!!!" + noticeNo);
			
			$("#action").val("I"); // insert 
			frealPopModal(noticeNo); // 공지사항 초기화 
			
			//모달 팝업 모양 오픈! (빈거) _ 있는 함수 쓰는거임. 
			gfModalPop("#notice");
			
		 }else{
			// Tranjection type 설정
			$("#action").val("U");  // update
			fdetailModal(noticeNo); //번호로 -> 공지사항 상세 조회 팝업 띄우기
		 }

	 }
	 	 
	 /*공지사항 상세 조회*/
	 function fdetailModal(noticeNo){
		 //alert("공지사항 상세 조회  ");
		 
		 $("#noticeNo").val(noticeNo);
		 
	
		 var param = {no : noticeNo};
		 var resultCallback2 = function(data){
			 fdetailResult(data);
		 };
		 
		 callAjax("/system/detailNotice.do", "post", "json", true, param, resultCallback2);
		 //alert("공지사항 상세 조회  22");
	 }
	 
	 /*  공지사항 상세 조회 -> 콜백함수   */
	 function fdetailResult(data){

		 //alert("공지사항 상세 조회  33");
		 if(data.resultMsg == "SUCCESS"){
			 //모달 띄우기 
			 gfModalPop("#notice");
				 
			// 모달에 정보 넣기 
			frealPopModal(data.result);
		 
		 }else{
			 alert(data.resultMsg);
		 }
	 }
	 
	 /* 팝업 _ 초기화 페이지(신규) 혹은 내용뿌리기  */
	 function frealPopModal(object){
		 if(object == "" || object == null || object == undefined){
			 var writer = $("#swriter").val();
			 //var Now = new Date();
			 $("#loginId").val(writer);
			 $("#loginId").attr("readonly", true);			 
			 
			 $("#write_date").val();
			 
			 $("#noticeTitle").val("");
			 $("#noticeContent").val("");
			 
			 $("#btnDeleteNotice").hide(); // 삭제버튼 숨기기
			 $("#btnUpdateNotice").hide();
			 $("#btnSaveNotice").show();
			 
			 $("#action").val("I");  // insert
						 
		 }else{
		   console.log('확인',object)
		   // ***************************************
		   // 이 부분이 상세조회 모달이 출력되는 코드입니다(기존 코드 주석처리)
			 //alert("숫자찍어보세 : " + object.wno);// 페이징 처리가 제대로 안되서 
			 /* $("#loginId").val(object.loginId);
			 $("#loginId").attr("readonly", true); // 작성자 수정불가 
			 
			 $("#write_date").val(object.noticeRegdate);
			 $("#write_date").attr("readonly", true); // 처음 작성된 날짜 수정불가 
			 
			 $("#noticeTitle").val(object.noticeTitle);
			 $("#noticeContent").val(object.noticeContent);
			//////object.noticeNo
			 
			 $("#noticeNo").val(object.noticeNo); // 중요한 num 값도 숨겨서 받아온다. 
			 */
			 $("#btnDeleteNotice").show(); // 삭제버튼 보이기 
			 $("#btnSaveNotice").hide();
			 $("#btnUpdateNotice").css("display",""); 
			 
			 $("#loginId").attr("readonly", true);
			 $("#noticeTitle").attr("readonly", true); //readonly
			 
			 // **** 추가코드 ****
			 $('#noticeNo').val(object.no);
			 $('#noticeTitle').val(object.title);
			 $('#loginId').val(object.name);
			 $('#noticeContent').val(object.contents);
			 //if문써서 로그인 아이디 == 작성자 아이디 일치시  --- 추가하기 
			// $("#grp_cod").attr("readonly", false);  // false, true(읽기만)로 수정	
			
			$("#action").val("U");  // insert
		 }
	 }
	 	 
	 /* 팝업내 수정, 저장 validation */
	 function fValidatePopup(){
		 var chk = checkNotEmpty(
				 [
					 ["noticeTitle", "제목을 입력해주세요!"],
					 ["loginId", "작성자를 입력해주세요!"]
				 ]
		 );
	 
	 	if(!chk){return;}
	 	return true;
	 }
	 
	 /* 공지사항 등록(저장) */
	 function fSaveNotice(){
		 
		 //alert("저장 함수 타는지!!!!!?? ");
		 // validation 체크 
		 if(!(fValidatePopup())){ return; }
		 
		 var resultCallback3 = function(data){
			 fSaveNoticeResult(data);
		 };
		 
		 $("#action").val("I");  // insert
		 
		 callAjax("/system/noticeSave.do", "post", "json", true, $("#myNotice").serialize(), resultCallback3);
	 	// $("#myNotice").serialize() => 직렬화해서 name 값들을 그냥 넘김.
	 }	 
	 
	 /* 저장, 수정, 삭제 콜백 함수 처리  */   
	 function fSaveNoticeResult(data){
		 var currentPage = currentPage || 1; 
		 
		 console.log("fSaveNoticeResult : " + JSON.stringify(data) );
		 
		 
		 if($("#action").val() != "I"){
			 currentPage = $("#currentPage").val();
		 }
		 
		 if(data.resultMsg == "SUCCESS"){
			 //alert(data.resultMsg);	// 받은 메세지 출력 
			 alert("저장되었습니다.");
		 }else if(data.resultMsg == "UPDATED") {
			 alert("수정되었습니다.");
		 }else if(data.resultMsg == "DELETED") {
			 alert("삭제되었습니다.");
		 }else{
			 alert(data.resultMsg); //실패시 이거 탄다. 
			// alert("실패했습니다.");
		 }
		 
		 gfCloseModal();	// 모달 닫기
		 selectNoticeList(currentPage); // 목록조회 함수 다시 출력 
		 frealPopModal();// 입력폼 초기화
	 }
	 
	 /* 공지사항 등록(수정) */
	 function fUpdateNotice(){
		 
		 alert("수정하겠습니까?");
		 // validation 체크 
		 if(!(fValidatePopup())){ return; }
		 
		 var resultCallback3 = function(data){
			 fSaveNoticeResult(data);
		 };
		 
		 $("#action").val("U");  // update
		 
		 callAjax("/system/noticeSave.do", "post", "json", true, $("#myNotice").serialize(), resultCallback3);
	 	
	 }
	 
	 /* 공지사항 게시판 1건 삭제 */
	 function fDeleteNotice(){
		 var con = confirm("정말 삭제하겠습니까? \n 삭제 시 복구불가합니다."); 		 
		 
		 if(con){
			 var resultCallback3 = function(data){
				 fSaveNoticeResult(data);
			 };
			 $("#action").val("D");  // delete
			 
			 callAjax("/system/noticeDelete.do", "post", "json", true, $("#myNotice").serialize(), resultCallback3);			 		 
			
		 }else{
			 gfCloseModal();	// 모달 닫기
			 selectNoticeList(currentPage); // 목록조회 함수 다시 출력 
			 frealPopModal();// 입력폼 초기화
		 }
	 }
	 
</script>

</head>

<!-- ///////////////////// html 페이지  ///////////////////////////// -->
<body>

<form id="myNotice" action="" method="">
	
	<input type="hidden" id="currentPage" value="1">  <!-- 현재페이지는 처음에 항상 1로 설정하여 넘김  -->
	<input type="hidden" id="tmpList" value=""> <!-- ★ 이거뭐임??? -->
	<input type="hidden" id="tmpListNum" value=""> <!-- 스크립트에서 값을 설정해서 넘길거임 / 임시 리스트 넘버 -->
	<input type="hidden" name="action" id="action" value=""> 
	<input type="hidden" id="swriter" value="${loginId}"> <!-- 작성자 session에서 java에서 넘어온값 -->

		
	<div id="wrap_area">

		<h2 class="hidden">header 영역</h2>
		<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

			<h2 class="hidden">컨텐츠 영역</h2>
			<div id="container">
				<ul>
					<li class="lnb">
						<!-- lnb 영역 --> 
						<jsp:include page="/WEB-INF/view/common/lnbMenu.jsp"></jsp:include> <!--// lnb 영역 -->
					</li>
					<li class="contents">
						<!-- contents -->
						<h3 class="hidden">contents 영역</h3> <!-- content -->
						
						<div class="content">
						
						<!-- 최상단 집/시스텝관리/공지사항 -->
						<p class="Location">
							<a href="../dashboard/dashboard.do" class="btn_set home">메인으로</a>
							<a href="#" class="btn_nav bold">시스템 관리</a> 
							<span class="btn_nav bold">공지사항</span> 
							<a href="../system/notice.do" class="btn_set refresh">새로고침</a>
						</p>

						<!-- 공지사항 -->
						<p class="conTitle">
							<span>공지사항 </span> 
							<span class="fr"> 
							<c:set var="nullNum" value=""></c:set>
							</span>
						</p>
						
						
      <!--검색창  -->	
	   <table style="margin-bottom : 18px; margin-top : 15px; border : 1px solid #ddd; "height = "65px" width="100%" align="left">
	    <tr>
	      <td width="6%" style="font-size: 100%; text-align : center;">제목</td>
	      <td>
	      <input type="text" id="title" name="title" style="width: 180px; height: 25px;">                    
	      </td>
	       
	      <td width="6%" height="25px" style="font-size: 100%; text-align : center;">날짜</td>
	      <td>
	      <input type="date" style="width: 140px; cursor:pointer; font-size:92%" id="from_date" name="from_date">
          <input type="date" style="width: 140px; cursor:pointer; font-size:92%" id="to_date" name="to_date">                   
	      </td>
	       
	      <td width="6%" height="25px" style="font-size: 100%; text-align : center;">내용</td>
	      <td>
	      <input type="text" id="contents" name="contents" style="width: 180px; height: 25px;">                    
	      </td>
	       
	      <td width="6%" height="25px" style="font-size: 100%; text-align : center;">작성자</td>
	      <td style="padding-right : 20px;">
	      <input type="text" id="userID" name="userID" style="width: 120px; height: 25px;">                    
	      </td>
	      	       
	      <td height="25px" style="padding-right : 10px;">
	      <a href="javascript:selectNoticeList()" class="btnType blue" id="searchBtn" name="searchbtn" style="float:right;">
          <span>검  색</span></a>
	      </td>
	      </tr>
	  </table>
	   
           <!-- 등록버튼 -->
           <c:if test="${sessionScope.userType eq 'A'}">					
		    <div class="sign_up" >
		    <a class="btnType blue" href="javascript:fNoticeModal(${nullNum});" name="modal" style="float:right; padding-bottom : 10px;">
			<span>등 록</span>
			</a>
			</div>
      </c:if>
						<!-- 공지사항리스트 -->
						<div class="divNoticeList">
							<table class="col">
								<caption>caption</caption>
	
		                            <colgroup>
						                   <col width="50px">
						                   <col width="200px">
						                    <col width="50px">
						                   <col width="60px">
					                 </colgroup>
								<thead>
									<tr>
							              <th scope="col">번호</th>
							              <th scope="col">제목</th>
							              <th scope="col">작성자</th>
							              <th scope="col">날짜</th>							              
									</tr>
								</thead>
								<tbody id="noticeList"></tbody>
							</table>
							
							<!-- 페이징 처리  -->
							<div class="paging_area" id="pagingnavi">
							 <div class="paging">
							</div>
											
						</div>
		
					</div> <!--// content -->

					<h3 class="hidden">푸터 영역</h3>
						<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
				</li>
			</ul>
		</div>
	</div>


	<!-- 등록 버튼 클릭 시 모달팝업 -->
	<div id="notice" class="layerPop layerType2" style="width: 600px;">
		<input type="hidden" id="noticeNo" name="noticeNo" value="${noticeNo}"> 
		<!-- 수정시 필요한 num 값을 넘김  -->
		
		<dl>
			<dt>
				<strong>공지사항</strong>
			</dt>
			<dd class="content">
				<!-- s : 여기에 내용입력 -->
				<table class="row">
					<caption>caption</caption>

					<tbody>
						<tr>
							<th scope="row">작성자 <span class="font_red">*</span></th>
							<td><input type="text" class="inputTxt p100" name="loginId" id="loginId" /></td>
							<!-- <th scope="row">작성일<span class="font_red">*</span></th>
							<td><input type="text" class="inputTxt p100" name="write_date" id="write_date" /></td> -->
						</tr>
						<tr>
							<th scope="row">제목 <span class="font_red">*</span></th>
							<td colspan="3"><input type="text" class="inputTxt p100"
								name="noticeTitle" id="noticeTitle" /></td>
						</tr>
						<tr>
							<th scope="row">내용</th>
							<td colspan="3">
								<textarea class="inputTxt p100" name="noticeContent" id="noticeContent">
								</textarea>
							</td>
						</tr>						
					</tbody>
				</table>

				<!-- e : 여기에 내용입력 -->
        <!-- **** 권한 추가 **** -->
        <c:if test="${sessionScope.userType eq 'A'}">
  				<div class="btn_areaC mt30">
  					<a href="" class="btnType blue" id="btnSaveNotice" name="btn"><span>저장</span></a> 
  					<a href="" class="btnType blue" id="btnUpdateNotice" name="btn" style="display:none"><span>수정</span></a> 
            <a href="" class="btnType blue" id="btnDeleteNotice" name="btn"><span>삭제</span></a> 
  					<a href="" class="btnType gray" id="btnClose" name="btn"><span>취소</span></a>
  				</div>
        </c:if>
			</dd>
		</dl>
		<a href="" class="closePop"><span class="hidden">닫기</span></a>
		</div>
</form>

</body>
</html>

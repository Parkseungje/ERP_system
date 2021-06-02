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
<title>Job Korea :: 부서코드</title>
<!-- sweet alert import -->
<script src='${CTX_PATH}/js/sweetalert/sweetalert.min.js'></script>
<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>
<!-- sweet swal import -->

<script type="text/javascript">

	// 페이징 설정 
	var pageSize = 5;    	// 화면에 뿌릴 데이터 수 
	var pageBlock = 5;		// 블럭으로 잡히는 페이징처리 수
	
	/* onload 이벤트  */
	
	// 날짜세팅
	
	$(function(){
		
        var today = new Date();
		
        fButtonClickEvent();
        
		// 부서관리 리스트 뿌리기 함수 
		selectDeptList();
		
	});
	
	/* 버튼 이벤트 등록 - 저장, 수정, 삭제  */
	function fButtonClickEvent(){
		$('a[name=btn]').click(function(e){
			e.preventDefault(); // ?? 
					
			var btnId = $(this).attr('id');
			
			//alert("btnId : " + btnId);
			switch(btnId){
			case 'btnSaveDept' : fSaveDept(); // save 안에 저장,수정
				//alert("저장버튼 클릭!!!이벤트!!");
				break;
			case 'btnDeleteDept' : fDeleteDept();	// 만들자 
				//alert("삭제버튼 클릭!!!이벤트!!");		
				break;
			case 'btnClose' : gfCloseModal();  // 모달닫기 
			selectDeptList(); // 첫페이지 다시 로딩 
				break;
			case 'btnUpdateDept' : fUpdateDept();  // 수정하기
				break;
			case 'searchBtn' : selectDeptList();  // 검색하기
				break;
				
			//case 'commentWrite' : fCommentInsert();   // 댓글--> 답변글로 변경 // 저장 
				//break;
			}
		});
	}
	
	/* 부서관리 리스트 불러오기  */
	function selectDeptList(currentPage){
		
		currentPage = currentPage || 1;   // or		
		
//alert("지금 현재 페이지를 찍어봅시다. " + currentPage);
		var dept_nm = $("#deptSearch").val();
		
		var param = {
				dept_nm : dept_nm ,
				currentPage : currentPage ,
				pageSize : pageSize  

		}

		console.log("param : " + param);
		
		var resultCallback = function(data){  // 데이터를 이 함수로 넘깁시다. 
			deptListResult(data, currentPage); 
		}
		
		callAjax("/system/listdept.do","post","text", true, param, resultCallback);
		
	}
	
	/* callAjax 공통 common.js 에서 퍼옴  -> 이렇게 생긴 함수입니다.  
	
	function fOnloadImg(param){
		var resultCallback = function(data) {
			fOnloadImgResult(data);
		};
		callAjax("/image/selectImgSize.do", "post", "json", false, param, resultCallback);
	 } */
	

	 /* 부서관리 리스트 data를 콜백함수를 통해 뿌려봅시당   */
	 function deptListResult(data, currentPage){
		 
		 console.log(data);
		 
		 // 일단 기존 목록을 삭제합니다. (변경시 재부팅 용)
		 $('#deptList').empty();
		 
		 $('#deptList').append(data);	
		 
		 // 리스트의 총 개수를 추출합니다. 
		 //var totalCnt = $data.find("#totalCnt").text();
		 var totalCnt = $("#totcnt").val();  // qnaRealList() 에서보낸값 
		 
		 // * 페이지 네비게이션 생성 (만들어져있는 함수를 사용한다 -common.js)
		 // function getPaginationHtml(currentPage, totalCount, pageRow, blockPage, pageFunc, exParams)
		 // 파라미터를 참조합시다. 
	     var list = $("#tmpList").val();
		 //var listnum = $("#tmpListNum").val();
	     var pagingnavi = getPaginationHtml(currentPage, totalCnt, pageSize, pageBlock, 'selectDeptList',[list]);
		 
	     console.log("pagingnavi : " + pagingnavi);
		 // 비운다음에 다시 append 
	     $("#pagingnavi").empty().append(pagingnavi); // 위에꺼를 첨부합니다. 
		 
		 // 현재 페이지 설정 
	    $("#currentPage").val(currentPage);
		 
	 }
	 
	
	 
	 /* 부서관리 모달창(팝업) 실행  */
	 function fDeptModal(deptNo) {
		 // 신규저장 하기 버튼 클릭시 (값이 null)
		 if(deptNo == null || deptNo==""){
			// Tranjection type 설정
			// alert("넘을 찍어보자!!!!!!" + deptNo);
			
			$("#action").val("I"); // insert 
			frealPopModal(deptNo); // 부서관리 초기화 
			
			//모달 팝업 모양 오픈! (빈거) _ 있는 함수 쓰는거임. 
			gfModalPop("#dept");
			
		 }else{
			// Tranjection type 설정
			$("#action").val("U");  // update
			fdetailModal(deptNo); //번호로 -> 부서관리 상세 조회 팝업 띄우기
		 }

	 }
	 	 
	 /*부서관리 상세 조회*/
	 function fdetailModal(deptNo){
		 //alert("부서관리 상세 조회  ");
		 var currentPage = 1 || currentPage;
		  console.log('확인', pageSize, '현재페이지',currentPage)
		 var param = {
				 deptNo : deptNo,
				 currentPage : currentPage,
				 pageSize : pageSize
		 };
		 var resultCallback2 = function(data){
			 console.log('응답',data)
			 fdetailResult(data);
		 };
		 
		 callAjax("/system/deptdetail.do", "post", "json", true, param, resultCallback2);
		 //alert("부서관리 상세 조회  22");
	 }
	 
	 /*  부서관리 상세 조회 -> 콜백함수   */
	 function fdetailResult(data){

		 //alert("부서관리 상세 조회  33");
		 if(data.resultMsg == "SUCCESS"){
			 //모달 띄우기 
			 gfModalPop("#dept");
			 
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
			 
			 $("#dept_cd").val("");
			 $("#dept_nm").val("");
			 
			 $("#btnDeleteDept").hide(); // 삭제버튼 숨기기
			 $("#btnUpdateDept").hide();
			 $("#btnSaveDept").show();
						 
		 }else{
			 
			 //alert("숫자찍어보세 : " + object.wno);// 페이징 처리가 제대로 안되서 
			 $("#loginId").val(object.loginId);
			 $("#loginId").attr("readonly", true); // 작성자 수정불가 
			 
			 
			 $("#write_date").val(object.deptRegdate);
			 $("#write_date").attr("readonly", true); // 처음 작성된 날짜 수정불가 
			 $("#dept_cd").attr("readonly", true);
			 
			 $("#dept_cd").val(object.dept_cd);
			 $("#dept_nm").val(object.dept_name);
			 // hidden값 설정
			  $("#hidden_dept_cd").val(object.dept_cd);
			 
			//////object.deptNo
			 
			 //$("#deptNo").val(object.deptNo); // 중요한 num 값도 숨겨서 받아온다. 
			 			 
			 $("#btnDeleteDept").show(); // 삭제버튼 보이기 
			 $("#btnSaveDept").hide();
			 $("#btnUpdateDept").css("display","");
			 //if문써서 로그인 아이디 == 작성자 아이디 일치시  --- 추가하기 
			 //$("#grp_cod").attr("readonly", false);  // false, true(읽기만)로 수정	
			 
		 }
	 }
	 	 
	 /* 팝업내 수정, 저장 validation */
	 function fValidatePopup(){
		 var chk = checkNotEmpty(
				 [
					 ["subject", "제목을 입력해주세요!"],
					 ["content", "내용을 입력해주세요!"]
				 ]
		 );
	 
	 	if(!chk){return;}
	 	return true;
	 }
	 
	 /* 부서관리 등록(저장) */
	 function fSaveDept(){
		 //alert("저장 함수 타는지!!!!!?? ");
		 // validation 체크 
		 if(!(fValidatePopup())){ return; }
		 
		 var resultCallback3 = function(data){
			 fSaveDeptResult(data);
		 };
		 
		 $("#action").val("I");  // insert
		 
		 callAjax("/system/deptSave.do", "post", "json", true, $("#myDept").serialize(), resultCallback3);
	 	// $("#myDept").serialize() => 직렬화해서 name 값들을 그냥 넘김.
	 }	 
	 
	 /* 저장, 수정, 삭제 콜백 함수 처리  */   
	 function fSaveDeptResult(data){
		 var currentPage = currentPage || 1; 
		 
		 if($("#action").val() != "I"){
			 currentPage = $("#currentPage").val();
		 }
		 
		 if(data.resultMsg == "SUCCESS"){
			 //alert(data.resultMsg);	// 받은 메세지 출력 
			 alert("저장 되었습니다.");
		 }else if(data.resultMsg == "UPDATED") {
			 alert("수정 되었습니다.");
		 }else if(data.resultMsg == "DELETED") {
			 alert("삭제 되었습니다.");
		 }else{
			 alert(data.resultMsg); //실패시 이거 탄다. 
			 //alert("실패 했습니다.");
		 }
		 
		 gfCloseModal();	// 모달 닫기
		 selectDeptList(currentPage); // 목록조회 함수 다시 출력 
		 frealPopModal();// 입력폼 초기화
	 }
	 
	 /* 부서관리 등록(수정) */
	 function fUpdateDept(){
		 
		 //alert("수정  함수 타는지!!!!!?? ");
		 // validation 체크 
		 if(!(fValidatePopup())){ return; }
		
		 var resultCallback3 = function(data){
			 fSaveDeptResult(data);
		 };
		 
		 $("#action").val("U");  // update
		 
		 callAjax("/system/deptSave.do", "post", "json", true, $("#myDept").serialize(), resultCallback3);
		 //callAjax("/system/deptSave.do", "post", "json", true, $("#myDept").serialize(), resultCallback3);
	 	// $("#myQna").serialize() => 직렬화해서 name 값들을 그냥 넘김.
	 }
	 
	 /* 부서관리 게시판 1건 삭제 */
	 function fDeleteDept(){
		 var con = confirm("정말 삭제하겠습니까? \n 삭제시 복구불가합니다."); 
		 if(con){
			 var resultCallback3 = function(data){
				 fSaveDeptResult(data);
			 }
			 $("#action").val("D");  // delete
			 callAjax("/system/deptDelete.do", "post", "json", true, $("#myDept").serialize(), resultCallback3);
			 // num만 넘겨도되지만 그냥 귀찮으니깐...^^... 
		 }else{
			 gfCloseModal();	// 모달 닫기
			 selectDeptList(currentPage); // 목록조회 함수 다시 출력 
			 frealPopModal();// 입력폼 초기화
		 }
	 }
	 
</script>

</head>

<!-- ///////////////////// html 페이지  ///////////////////////////// -->
<body>

<form id="myDept" action="" method="">
	
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
						
						<!-- 최상단 집/시스텝관리/부서관리 -->
						<p class="Location">
							<a href="../dashboard/dashboard.do" class="btn_set home">메인으로</a>
							<a href="#" class="btn_nav bold">시스템 관리</a> 
							<span class="btn_nav bold">부서관리</span> 
							<a href="../system/deptMgr.do" class="btn_set refresh">새로고침</a>
						</p>

						<!-- 부서관리 -->
						<p class="conTitle">
							<span>부서관리</span> <span class="fr"> 
							</span>
						</p>
						
	    <!-- 검색 -->     	            		
     	<table style="margin-bottom : 18px; margin-top : 15px; border : 1px solid #ddd; "height = "65px" width="100%" align="left">
	    <tr>
	    	   	    
	   	  <td>
	   	  <td width="5%" height="25" style="font-size: 100%; text-align : center;">부서명</td>
	      <td width="10%">
	      <input type="text" id="deptSearch" name="deptSearch" style="width: 200px; height: 25px;">                    
	      </td> <!-- 여기 부서명과  아래 부서명 id,name 체크 -->
	      </td>
	      	      	       
	      <td width="47%" height="25" style="padding-left:10px;">
	      <a href="javascript:selectDeptList()" class="btnType blue" id="searchBtn" name="btn" style="float:left;">
          <span>검  색</span></a>
	      </td>	
	          
	    </tr>
	    </table>
	   
           <!-- 등록버튼 -->					
		    <div class="sign_up">
		    <a class="btnType blue" href="javascript:fDeptModal(${nullNum});" name="modal" style="float:right; padding-bottom : 10px;">
			<span>등 록</span>
			</a>
			</div>
						<!-- 부서코드리스트 -->
						<div class="divDeptList">
							<table class="col">
								<caption>caption</caption>
								<colgroup>
									<col width="50%">
									<col width="50%">
								</colgroup>
	
								<thead>
									<tr>
										<th scope="col">부서명</th>
										<th scope="col">부서코드</th>
									</tr>
								</thead>
								<tbody id="deptList"></tbody>								
							</table>
						</div>
							
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
	<div id="dept" class="layerPop layerType2" style="width: 600px;">
		<input type="hidden" id="deptNo" name="deptNo" value="${deptNo}"> 
		<input type="hidden" id="hidden_dept_cd"  name="hidden_dept_cd" value="${dept_cd}"> 
		<!-- 수정시 필요한 num 값을 넘김  -->
		
		<dl>
			<dt>
				<strong>부서관리</strong>
			</dt>
			<dd class="content">
				<!-- s : 여기에 내용입력 -->
				<table class="row">
					<caption>caption</caption>

					<tbody>
						<tr>							
							<th scope="row">부서코드 <span class="font_red">*</span></th>
							<td><input type="text" class="inputTxt p100" name="dept_cd" id="dept_cd" /></td>
							<th scope="row">부서명 <span class="font_red">*</span></th>
							<td><input type="text" class="inputTxt p100" name="dept_nm" id="dept_nm" /></td>						
						</tr>
					</tbody>
				</table>

				<!-- e : 여기에 내용입력 -->
				<!--버 튼 추가 -->
				<div class="btn_areaC mt30">
					<a href="" class="btnType blue" id="btnSaveDept" name="btn"><span>저장</span></a>
					<a href="" class="btnType blue" id="btnUpdateDept" name="btn" style="display:none"><span>수정</span></a> 
					<!-- <a href="" class="btnType blue" id="btnDeleteDept" name="btn"><span>삭제</span></a> --> 
					<a href="" class="btnType gray" id="btnClose" name="btn"><span>취소</span></a>
				</div>
			</dd>
		</dl>
		<a href="" class="closePop"><span class="hidden">닫기</span></a>
		</div>
	
</form>

</body>
</html>

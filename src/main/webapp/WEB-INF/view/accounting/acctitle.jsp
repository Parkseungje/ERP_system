<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>JobKorea</title>

<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<script src="${CTX_PATH}/js/summernote/summernote-ko-KR.js"></script>

<script type="text/javascript">

var currentPage;

// 그룹코드 페이징 설정
var pageSize = 5;
var pageBlockSize = 5;  // 한번에 보여주는 로우수

$(document).ready(function(){
	
	comcombo("ACCcd", "bigSelect", "all", "");
	
	fAccList();
	
	
});

/* 조회조건 계정정보 대분류에따른 소분류 콤보박스 */

function fn_selectComCombo() {				
	var account_cd = $("#bigSelect").val();
	selectComCombo("acc", "accSmall", "all",account_cd,"");
	//console.log("account_cd : " + account_cd);
	
}


//새 계정과목 등록
function fWrite(){
   
    
 	var bigSelect2 = $("#bigSelect2").val();  //A100 
	var accSmall2 = $("#accSmall2").val();   //계정세부명
	var accContents2 = $("#accContents2").val();   //세부내용
	var payment2 = $("#payment2").val();           // 수입지출구분
	
	
     var param = {
    		 bigSelect2 : bigSelect2
    		 ,accSmall2 : accSmall2
    		 ,accContents2 : accContents2
    		 ,payment2 : payment2
     	}
     
     var resultCallback = function(param) {
    	 fModalResult(param);
    	 
     	};
    
     callAjax("/accounting/acctitleWrite.do", "post", "json", true, param, resultCallback);
	

	
  }
  


//관리자 공지사항 리스트 데이터 받아오기
function fAccList(currentPage) {
	var bigSelect = $("#bigSelect").val();
	var accsmall = $("#accSmall").val();
	var payment = $("#payment").val();
	var use = $("#use").val();
	var account_cd = $('#account_cd').val();
	
	currentPage = currentPage || 1;
 
	var param = {
		bigSelect : bigSelect,
		accsmall : accsmall,
		payment : payment,
		use : use,
		pageSize : pageSize,
		currentPage : currentPage,
		account_cd : account_cd
	}

	var resultCallback = function(data) {
		fAccResult(data, currentPage);
	};

	//Ajax실행 방식
	//callAjax("Controller Url",type,return,async or sync방식,넘겨준거,값,Callback함수 이름)
	// json으로 보내서 오류가 났음 , -> text
	callAjax("/accounting/acctitleList.do", "post", "text", true, param,resultCallback);
	}
//관리자 공지사항 리스트 데이터 출력
function fAccResult(data, currentPage) {

	console.log("값가져오ㅏ ㅇㅅㅇ" + data);
	
	// 기존 목록 삭제
	$('#acctitleList').empty();  // tbody id넣는곳
	//$('#listLec').find("tr").remove() 

	var $data = $($(data).html());

	// 신규 목록 생성
	var $admNoticeList = $data.find("#acctitleList");
	$("#acctitleList").append($admNoticeList.children());

	// 총 개수 추출
	var $admNoticeCnt = $data.find("#acctitleList");
	var admNoticeCnt = $admNoticeCnt.text();

	// 페이지 네비게이션 생성
	var paginationHtml = getPaginationHtml(currentPage, admNoticeCnt,
			pageSize, pageBlockSize, 'fAccList');
	
	//alert(paginationHtml);
	$("#admPagination").empty().append(paginationHtml);

	// 현재 페이지 설정
	$("#admCurrentPage").val(currentPage);

	}
	
   // 등록 모달창 띄우기
   function fPopModalAccEnroll(){
		gfModalPop('#layer1');
	}
   
   
   
   // 단건 수정 모달창
   function fPopModalDetail(group_code, detail_account_cd){
	    
	 
	    var param = { group_code : group_code , detail_account_cd : detail_account_cd };
		
		var resultCallback = function(data) {
			fAccSelectResult(data);
		};
		
		callAjax("/accounting/acctitleUpdateSelect.do", "post", "json", true, param, resultCallback);
		
	}  
   
   /** 그룹코드 단건 조회 콜백 함수*/
	function fAccSelectResult(data) {

		if (data.result == "SUCCESS") {

			// 모달 팝업
			gfModalPop('#layer2');
			
			// 그룹코드 폼 데이터 설정
			fInitFormAcc(data.acctitleUpdate);
			
		} else {
			alert(data.resultMsg);
		}	
	}
   
	/** 단건조회 폼 초기화 */
	function fInitFormAcc(object) {
			$("#M2bigSelect").val(object.group_name);
			$("#M2accSmall").val(object.detail_account_nm);
			$("#M2accSmall_cd").val(object.detail_account_cd);
			$("#M2accContents").val(object.note);
			$("#M2use_yn").val(object.use_yn);
			$("#M2payment").val(object.account_type_cd);			
			$("#account_cd").val(object.group_code); //여기서 input hidden 태그로 계정대분류코드 값이 넘어감
			
			//console.log("object.account_type_cd : " + object.account_type_cd);
			//alert("object.account_type_cd : " + object.account_type_cd);
			
	}
   
 //새 계정과목 등록하기
	function fupdate(){
	   
	    
	 	
		var accSmall = $("#M2accSmall").val();   
		var accContents = $("#M2accContents").val();   
		var use_yn = $("#M2use_yn").val();
		var account_type = $("#M2payment").val();
		var accSmall_cd = $("#M2accSmall_cd").val(); 
		var account_cd = $("#account_cd").val();   
		
		
		//if(!fValidate()) return;
			
		if(
		   accSmall != null &&
		   use_yn != null &&
		   account_type != null &&
		
		   accSmall != '' &&
		   use_yn != ''&&
		   account_type != '' 
		){
        var param = {
        		
       		   accSmall : accSmall
       		   ,accContents : accContents
       		   ,use_yn : use_yn
       		   ,account_type : account_type
       		   ,accSmall_cd : accSmall_cd
       		   ,account_cd : account_cd
        	}
       
        var resultCallback = function(param) {
       	 fModalResult2(param);
        	};
        
        callAjax("/accounting/acctitleUpdate.do", "post", "json", true, param, resultCallback);
		}
	
		else{alert("작성이 완료되지 않았습니다.")}
     }
 
	function fValidate() {

		var chk = checkNotEmpty(
				[
						[ "accSmall", "상세코드명을 입력해 주세요." ]
					
				]
		);

		if (!chk) {
			return;
		}

		return true;
	}
 
	//모달 결과 
	function fModalResult2(data) {

		if (data.result == "SUCCESS") {

			// 모달 팝업
			gfCloseModal();
			alert(data.resultMsgYes);
			fAccList();

		} else {
			gfCloseModal();
			alert(data.resultMsg);
		}

	}
	
	//모달 결과 
	function fModalResult(data) {

		if (data.result == "게시글 작성을 성공하였습니다.") {

			// 모달 팝업
			gfCloseModal();
			alert(data.result);
			fAccList();

			$("#accSmall").val("");
			$("#accContents").val("");

		} 
		
		else {
			gfCloseModal();
			alert(data.result);
		}

	}
	
	
</script>

<style>
#date{margin:20px 5px 10px 5px;}
#text1{font-size:105%; font-weight:normal;}
.inputt{width:100px;}
#accbig{width:10%; margin-left:1%;}
#accsmall{width:10%; margin-left:1%;}
#payment{width:10%; margin-left:1%;}
#use{width:10%; margin-left:1%;}


#text2{margin-left:2%}
#text3{margin-left:2%}
#text4{margin-left:2%}

.inputT p100{width:10%;}

</style>


</head>
<body>
<form id="myForm" action=""  method="">
   <input type="hidden" id="currentPageComnGrpCod" value="1">
   <input type="hidden" id="currentPageComnDtlCod" value="1">
   <input type="hidden" id="tmpGrpCod" value="">
   <input type="hidden" id="tmpGrpCodNm" value="">
   <input type="hidden" name="action" id="action" value="">
   <input type="hidden" name="account_cd" id="account_cd" value="">
   
   <!-- 계정과목 초기화면 -->
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
                        class="btn_nav">시스템 관리</a> <span class="btn_nav bold">공통코드
                        관리</span> <a href="#" class="btn_set refresh">새로고침</a>
                  </p>
				  
                   
                  <p class="conTitle">
                     <span>계정과목 관리</span> 
                  </p>    
                  
                  <p class="conTitle">
                     <form> 				
        				<span id="text1" >계정 대분류 
        				<select id="bigSelect" name="bigSelect" onChange="javascript:fn_selectComCombo()" >
  						</select></span> 
  						<span id="text2" >계정 세부목록 
        				<select id="accSmall" name="accsmall" class="boxx">
    						<option value="" selected>전체</option>
  						</select> </span>
  						<span id="text3">구분 
        				<select id="payment" name="payment" class="boxx">
    						<option value="" selected>전체</option>
    						<option value="1" >수입</option>
    						<option value="2" >지출</option>
  						</select> </span>
  						<span id="text4" >사용여부
  						<select id="use" name="use" class="boxx">
    						<option value="" selected>전체</option>
   						    <option value="Y" >Y</option>
    						<option value="N">N</option>
  						</select></span> 
  						 <a class="btnType blue" href="javascript:fAccList()" ><span id="searchEnter">검색</span></a>
    				 </form>
    				 <form>
    				 <span class="fr"> <a
                        class="btnType blue" href="javascript:fPopModalAccEnroll();" name="modal"><span>등록</span></a>
                     	</span>
    				 </form>    
                  </p> 
                  
                  <div class="divComGrpCodList"  id="vuetable">
                     <table class="col">
                        <caption>caption</caption>
                        <colgroup>
                           <col width="10%">
                           <col width="10%">
                           <col width="10%">
                           <col width="15%">
                           <col width="10%">
                           <col width="20%">
                           <col width="7%">
                        </colgroup>
   
                        <thead>
                           <tr>
                              <th scope="col">계정대분류코드</th>
                              <th scope="col">계정대분류명</th>
                              <th scope="col">계정세부코드</th>
                              <th scope="col">계정세부명</th>
                              <th scope="col">구분</th>
                              <th scope="col">상세내용</th>
                              <th scope="col">사용여부</th>
                           </tr>
                        </thead>
                        <tbody id="acctitleList"></tbody>
                     </table>
                  </div>
   
                 *<div class="paging_area" id="admPagination">
                  	<div class="paging">
                  		<a class="first" href="javascript:fAdmList(1)">
                  		<span class="hidden">맨앞</span>
                  		</a>
                  		<a class="pre" href="javascript:fAdmList(1)">
                  		<span class="hidden">이전</span>
                  		</a>
                  		<strong>1</strong>
                  		<a href="javascript:fAdmList(2)">2</a>
                  		<a class="next" href="javascript:fAdmList(2)">
                  		<span class="hidden">다음</span>
                  		</a>
                  		<a class="last" href="javascript:fAdmList(2)">
                  		<span class="hidden">맨뒤</span>
                  		</a>
                  	</div>
                  </div>

               </div> <!--// content -->

               <h3 class="hidden">풋터 영역</h3>
                  <jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
            </li>
         </ul>
      </div>
   </div>

   <!-- 계정과목 등록 모달팝업 -->
   
   <div id="layer1" class="layerPop layerType2" style="width: 600px;">
      <dl>
         <dt>
            <strong>계정과목 등록</strong>
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
                     <th scope="row" colspan="3">계정 대분류명 <span class="font_red">*</span></th>
                     <td colspan="3">
                     	<select id="bigSelect2" name="bigSelect2" >
   						    <option value="A100" selected>온라인매출</option>
    						<option value="B200">영업매출</option>
    						<option value="C300">급여</option>
    						<option value="D400">복리후생비</option>
    						<option value="E500">접대비</option>
    						<option value="F600">통신비</option>
  						</select>
  					 </td>              
                  </tr>
                  <tr>
                     <th scope="row" colspan="3">계정 세부명 <span class="font_red">*</span></th>
                     <td colspan="3"><input type="text" class="inputT p100"
                        name="accSmall2" id="accSmall2" /></td>
                  </tr>
                  <tr>
                     <th scope="row" colspan="3">상세내용</th>
                     <td colspan="3"><input type="text" class="inputT p100"
                        name="accContents2" id="accContents2" /></td>
                  </tr>
                  <tr>
                     <th scope="row" colspan="3">구분</th>
                     <td colspan="3">
                     	<select id="payment2" name="payment2" >
    						<option value="1" selected>수입</option>
   						    <option value="2" >지출</option>
  						</select>
  					 </td>
                  </tr>
                  
                  
               </tbody>
            </table>

            <!--계정과목 등록모달창 등록버튼 -->

            <div class="btn_areaC mt30">    
              <a href="javascript:fWrite();" class="btnType blue" id="submitBtn"><span id="">등록</span></a>
               <a href="" class="btnType gray"  id="btnCloseGrpCod" name="btn"><span>취소</span></a>
            </div>0
            
         </dd>
      </dl>
      <a href="" class="closePop"><span class="hidden">닫기</span></a>
   </div>
  
  
  
   <div id="layer2" class="layerPop layerType2" style="width: 600px;">
       <dl>
         <dt>
            <strong>계정과목 수정</strong>
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
                     <th scope="row" colspan="3">계정 대분류명 <span class="font_red">*</span></th>
                     <td colspan="3"><input type="text" class="inputT p100" name="M2bigSelect" id="M2bigSelect" style="background-color:#DCE1E6" readonly /></td>
                  </tr>
                  <tr>
                     <th scope="row" colspan="3">계정 세부명 <span class="font_red">*</span></th>
                     <td colspan="3"><input type="text" class="inputT p100" name="M2accSmall" id="M2accSmall" /></td>
                  </tr>
                  <tr>
                     <th scope="row" colspan="3">계정 세부코드 <span class="font_red">*</span></th>
                     <td colspan="3"><input type="text" class="inputT p100" name="M2accSmall_cd" id="M2accSmall_cd" style="background-color:#DCE1E6" readonly /></td>
                  </tr>
                  <tr>
                     <th scope="row" colspan="3">상세내용</th>
                     <td colspan="3"><input type="text" class="inputT p100" name="M2accContents" id="M2accContents" /></td>
                  </tr>
                  <tr>
                     <th scope="row" colspan="3">사용여부</th>
                     <td colspan="3">
                     	<select id="M2use_yn" name="M2use_yn" >
    						<option value="Y" selected>Y</option>
   						    <option value="N" >N</option>
  						</select>
  					 </td>
                  </tr>
                  <tr>
                     <th scope="row" colspan="3">구분</th>
                     <td colspan="3">
                     	<select id="M2payment" name="M2payment" >
    						<option value="1" selected>수입</option>
   						    <option value="2" >지출</option>
  						</select>
  					 </td>
                  </tr>
                  
                  
               </tbody>
            </table>

            <!--계정과목 등록모달창 등록버튼 -->

            <div class="btn_areaC mt30">    
              <a href="javascript:fupdate();" class="btnType blue" id="submitBtn"><span id="">수정</span></a>
              <a href="" class="btnType gray"  id="btnCloseGrpCod" name="btn"><span>취소</span></a>
            </div>
            
         </dd>
      </dl>
      <a href="" class="closePop"><span class="hidden">닫기</span></a>
   </div>
   
   
</form>


</body>
</html>
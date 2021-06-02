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
	
	
	fArmngList();
	
});

/* 조회조건 계정정보 대분류에따른 소분류 콤보박스 */

/*
function fn_selectComCombo() {				
	var receiveName = $("#receiveName").val();
	
	selectComCombo("acc", "accSmall", "all",receiveName,"");
}*/


//새 계정과목 등록
function fWrite(){
   
    
 	var bigSelect2 = $("#bigSelect2").val();       //A100 
	var accSmall2 = $("#accSmall2").val();         //계정세부명
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
function fArmngList(currentPage) {
	var receiveStart = $("#receiveStart").val();
	var receiveEnd = $("#receiveEnd").val();
	var receiveName = $("#receiveName").val();
	var scm_yn = $("#scm_yn").val();
	
	/*if(receiveStart == null && receiveStart == '' && receiveEnd == null && receiveEnd == ''){
		alert("수주일자를 입력해주세요")
	}else{}
	if(receiveName == null && receiveName == '' && receiveName == null && receiveName == ''){
		alert("거래처를 입력해주세요")
	}else{}*/

	currentPage = currentPage || 1;
 
	var param = {
			receiveStart : receiveStart,
			receiveEnd : receiveEnd,
			receiveName : receiveName,
			scm_yn : scm_yn,
			currentPage : currentPage,
			pageSize : pageSize
	}
	
	
	
	var resultCallback = function(data) {
		
		fArmngResult(data, currentPage);
	};

	//Ajax실행 방식
	//callAjax("Controller Url",type,return,async or sync방식,넘겨준거,값,Callback함수 이름)
	// json으로 보내서 오류가 났음 , -> text
	
	callAjax("/sales/armngList.do", "post", "text", true, param,resultCallback);
	}
	

	
//관리자 공지사항 리스트 데이터 출력
function fArmngResult(data, currentPage) {

	console.log("값가져오ㅏ ㅇㅅㅇ" + data);
	
	// 기존 목록 삭제
	$('#armngList').empty();  // tbody id넣는곳
	//$('#listLec').find("tr").remove() 

	var $data = $($(data).html());

	// 신규 목록 생성
	var $admNoticeList = $data.find("#armngList");
	$("#armngList").append($admNoticeList.children());

	// 총 개수 추출
	var $admNoticeCnt = $data.find("#armngList");
	var admNoticeCnt = $admNoticeCnt.text();

	// 페이지 네비게이션 생성
	var paginationHtml = getPaginationHtml(currentPage, admNoticeCnt,
			pageSize, pageBlockSize, 'fArmngList');
	
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
   function fPopModalDetail(order_cd){
	    
	   
	    
	    var param = { order_cd : order_cd
	    			  
	    			};
		
		var resultCallback = function(data) {
			fArmngSelectResult(data);
		};
		
		callAjax("/sales/armngSelect.do", "post", "json", true, param, resultCallback);
		
	}  
   
   /** 그룹코드 단건 조회 콜백 함수*/
	function fArmngSelectResult(data) {

	    console.log("fArmngSelectResult : " + JSON.stringify(data));
	   
		if (data.result == "SUCCESS") {

			// 모달 팝업
			gfModalPop('#layer2');
			
			// 그룹코드 폼 데이터 설정
			fInitFormAcc(data.armngModel, data.loginID);
			
		} else {
			alert(data.resultMsg);
		}	
	}
   
	/** 상세 모달창 폼 초기화 */
	function fInitFormAcc(object, object2) {
			
			$("#booking_date").val(object.receive_date); //수주일자 0
			$("#subject").val(object.scm_yn); // 처리주체 0
			$("#booking_no").val(object.order_cd); // 수주번호 0
			$("#total_sum_cost").val(object.price);  // 미수금(총 공급가액=납입할 총액)0 
			$("#prod_name").val(object.prod_nm); // 제품명 0
			$("#price").val(object.price); // 제품 공급가액 0
			$("#tax").val(object.tax); // 제품 부가세 0
			$("#unit_cost").val(object.unit_cost); // 제품 단가  0
			$("#client_mng").val(object.emp_nm); // 거래처 담당자 0
			$("#client_tel").val(object.emp_hp); // 거래처 담당자 번호 0 
			$("#client_nm").val(object.client_nm); // 거래처명 0
			$("#estimate_cnt").val(object.estimate_cnt); // 수량 0
			$("#sum_cost").val(object.price); // 제품당 합계액 0
			$("#total_sum_cost2").val(object.price); // 총 공급가액(미수금=납입할 총액)0 
			$("#total_surtax").val(object.tax); // 총 부가세  0
			$("#total_price").val(object.unit_cost); // 총 단가  0
			$("#total_estimate_cnt").val(object.estimate_cnt); // 총 수량 0
			$("#client_cd").val(object.client_cd); //
			$("#pro_cd").val(object.product_cd); // 상품코드
			$("#company_mng").val(object2);   // 처리자
			
				
	}
   
 //새 계정과목 등록하기
	function fupdate(){
	   
		   
		var order_cd = $("#booking_no").val();
		var total_sum_cost2 = $("#total_sum_cost2").val();
		var client_cd = $("#client_cd").val();
		var accContents2 = $("#accContents2").val();
		
		
		
		
		//if(!fValidate()) return;
			
		if(booking_no != null && booking_no != '' ){
       		 
			var param = {
							
        					total_sum_cost2 : total_sum_cost2,
        					client_cd : client_cd,
        					accContents2 : accContents2,
        					order_cd : order_cd
        					
        				  }
			
			
       
      	    var resultCallback = function(param) {
				
       	             fModalResult2(param);
        	           };
        
            callAjax("/sales/armngUpdate.do", "post", "json", true, param, resultCallback);
	    	}
	
		else{alert("입금이 되지 않습니다.")
			
		}
 
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
			fArmngList();

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
   <input type="hidden" name="client_cd" id="client_cd" value="">
   <input type="hidden" name="order_cd" id="order_cd" value="">
   
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
                     <span>미수금 관리</span> 
                  </p>    
                  
                  <p class="conTitle">
                     <form> 				
        				<span id="text1" >수주일자
        				<input type="date" id="receiveStart" name="receiveStart" />~<input type="date" id="receiveEnd" name="receiveEnd" />
        				</span> 
  						<span id="text2" >거래처
  						<input type="text" id="receiveName" name="receiveName" />
        				</span>
  						<span id="text3">처리주체
        				<select id="scm_yn" name="scm_yn" >
    						<option value="" selected>전체</option>
    						<option value="scm부" >scm부</option>
    						<option value="영업부" >영업부</option>
  						</select> </span>
  						 <a class="btnType blue" href="javascript:fArmngList()" ><span id="searchEnter">검색</span></a>
    				 </form>	   
                  </p> 
                  
                  <div class="divComGrpCodList"  id="vuetable">
                     <table class="col">
                        <caption>caption</caption>
                        <colgroup>
                           <col width="10%">
                           <col width="10%">
                           <col width="10%">
                           <col width="10%">
                           <col width="10%">
                           <col width="10%">
                        </colgroup>
   
                        <thead>
                           <tr>
                              <th scope="col">수주일자</th>
                              <th scope="col">수주번호</th>
                              <th scope="col">거래처</th>
                              <th scope="col">처리주체</th>
                              <th scope="col">제품명</th>
                              <th scope="col">미수금</th>
                           </tr>
                        </thead>
                        <tbody id="armngList"></tbody>
                     </table>
                  </div>
   
                  <div class="paging_area" id="admPagination">
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
                     <th scope="row" colspan="3">수주일자 <span class="font_red"></span></th>
                     <td colspan="3"><input type="text" class="inputT p100" name="booking_date" id="booking_date" style="background-color:#DCE1E6" readonly /></td>
                     <th scope="row" colspan="3">처리주체 <span class="font_red"></span></th>
                     <td colspan="3"><input type="text" class="inputT p100" name="subject" id="subject" style="background-color:#DCE1E6" readonly /></td>
                  </tr>
                  <tr>
                     <th scope="row" colspan="3">수주번호 <span class="font_red"></span></th>
                     <td colspan="3"><input type="text" class="inputT p100" name="booking_no" id="booking_no" style="background-color:#DCE1E6" readonly /></td>
                     <th scope="row" colspan="3">미납액 <span class="font_red"></span></th>
                     <td colspan="3"><input type="text" class="inputT p100" name="total_sum_cost" id="total_sum_cost" style="background-color:#DCE1E6" readonly /></td>
                  </tr>
                  <tr>
                  	 <th scope="row" colspan="3" style="background-color:white">제품정보 <span class="font_red">*</span></th>
                     <th scope="row" colspan="3" style="background-color:white"> <span class="font_red"></span></th>
                  	 <th scope="row" colspan="3" style="background-color:white">거래처 정보 <span class="font_red">*</span></th>
                  </tr>
                  <tr>
                     <th scope="row" colspan="3">제품명</th>
                     <td colspan="3"><input type="text" class="inputT p100" name="prod_name" id="prod_name" style="background-color:#DCE1E6" readonly /></td>
  					 <th scope="row" colspan="3">거래처</th>
                     <td colspan="3"><input type="text" class="inputT p100" name="client_nm" id="client_nm" style="background-color:#DCE1E6" readonly /></td>
                  </tr>
                  <tr>
                     <th scope="row" colspan="3">공급가액</th>
                     <td colspan="3"><input type="text" class="inputT p100" name="price" id="price" style="background-color:#DCE1E6" readonly /></td>
                     <th scope="row" colspan="3">거래처 담당자</th>
                     <td colspan="3"><input type="text" class="inputT p100" name="client_mng" id="client_mng" style="background-color:#DCE1E6" readonly /></td>
                  </tr>
                  <tr>
                     <th scope="row" colspan="3">부가세</th>
                     <td colspan="3"><input type="text" class="inputT p100" name="tax" id="tax" style="background-color:#DCE1E6" readonly /></td>
                     <th scope="row" colspan="3">거래처<br> 담당자번호</th>
                     <td colspan="3"><input type="text" class="inputT p100" name="client_tel" id="client_tel" style="background-color:#DCE1E6" readonly /></td>
                  </tr>
                  <tr>
                     <th scope="row" colspan="3">단가</th>
                     <td colspan="3"><input type="text" class="inputT p100" name="unit_cost" id="unit_cost" style="background-color:#DCE1E6" readonly /></td>
                  </tr>
                  <tr>
                     <th scope="row" colspan="3">수량</th>
                     <td colspan="3"><input type="text" class="inputT p100" name="estimate_cnt" id="estimate_cnt" style="background-color:#DCE1E6" readonly /></td>
                  </tr>
                  <tr>
                     <th scope="row" colspan="3">합계액</th>
                     <td colspan="3"><input type="text" class="inputT p100" name="sum_cost" id="sum_cost" style="background-color:#DCE1E6" readonly /></td>
                  </tr>
                  <tr>
                     <th scope="row" colspan="3" style="background-color:white">제품총액 <span class="font_red">*</span></th>
                  </tr>
                  <tr>
                     <th scope="row" colspan="3">총 공급가액</th>
                     <td colspan="3"><input type="text" class="inputT p100" name="total_sum_cost2" id="total_sum_cost2" style="background-color:#DCE1E6" readonly /></td>
                  </tr>
                  <tr>
                     <th scope="row" colspan="3">총 부가세</th>
                     <td colspan="3"><input type="text" class="inputT p100" name="total_surtax" id="total_surtax" style="background-color:#DCE1E6" readonly /></td>
                  </tr>
                  <tr>
                     <th scope="row" colspan="3">총 단가</th>
                     <td colspan="3"><input type="text" class="inputT p100" name="total_price" id="total_price" style="background-color:#DCE1E6" readonly /></td>
                  </tr> 
                  <tr>
                     <th scope="row" colspan="3">총 수량</th>
                     <td colspan="3"><input type="text" class="inputT p100" name="total_estimate_cnt" id="total_estimate_cnt" style="background-color:#DCE1E6" readonly /></td>
                  </tr>
                  <tr>
                     <th scope="row" colspan="3" style="background-color:white">처리자<span class="font_red">*</span></th>
                  </tr>
                 <tr>
                     <th scope="row" colspan="3">처리자 </th>
                     <td colspan="3"><input type="text" class="inputT p100" name="company_mng" id="company_mng" style="background-color:#DCE1E6" readonly /></td>
                  </tr>      
               </tbody>
            </table>
			
            <!--계정과목 등록모달창 등록버튼 -->

            <div class="btn_areaC mt30">    
              <a href="javascript:fupdate();" class="btnType blue" id="submitBtn"><span id="">입금</span></a>
            </div>
            
         </dd>
      </dl>
      <a href="" class="closePop"><span class="hidden">닫기</span></a>
   </div>
   
   
</form>


</body>
</html>
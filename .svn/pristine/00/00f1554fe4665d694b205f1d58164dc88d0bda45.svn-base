<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>JobKorea</title>


<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> <!-- 다음 api   -->

<!-- 거래처 관리  -->

<style>
	#layer1 {
  overflow-y: scroll;
}
</style>

<script type="text/javascript">

// 우편번호 검색 
function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('zip_code').value = data.zonecode;
            document.getElementById("addr").value = roadAddr;
            document.getElementById("addr_detail").value = data.jibunAddress;

        }
    }).open();
}


/* -------------------------------------------------------------------  */
/* -------------------------------------------------------------------  */


   // 페이징 설정 
   var pageSizeClientList = 5; // 행 다섯개 
   var pageBlockSizeClientList = 5;  // 블록 갯수 일단 출력
 

   
   // 함수 시작
	$(document).ready(function(){
		
		//거래처 목록
		 clientList();
		
		//모달창 초기화
		 bizInitFormClient();
			
		// 버튼 이벤트 등록
		bRegisterButtonClickEvent();
		
		// 공통코드 comcombo 사용방법 ->
		// Group Code, Combo Name, Option("all" : 전체 / "sel" : 선택 , Select Value ) 사원등록 모달창
		comcombo("BKcd", "bank", "sel", "0"); //은행계좌


		// datepicker 사용 선언 
		$('#from_date').datepicker();
		$('#to_date').datepicker();


	});
   
 
   


	/** 버튼 이벤트 등록 */
	function bRegisterButtonClickEvent() {
		$('a[name=btn]').click(function(e) {
			e.preventDefault();

			var btnIdBIz = $(this).attr('id'); // id값 들어오면 변수에 넣어준다 

			switch (btnIdBIz) {
				case 'btnSaveBiz' : // 신규등록 , 수정사항 저장
					bSaveBiz();
					break;
				case 'btnDeleteBiz' : // 삭제 
					bDeleteBiz();
					break;
				case 'btnSearchBiz': // 검색 
					bSearchBiz();
					break;
				case 'btnCloseBiz' : // 모달 닫기 함수 [나는 하나로 썼음 ]
					gfCloseModal();
					break;
			}
		});
	}
	
   

	   /*  1. 등록 모달 :  모달 실행 */
	   function BizPartnerModal1(client_cd){
	      
	      // 신규 저장
	      if (client_cd == null || client_cd =="") {
	      
	         // Tranjection type 설정
	         $("#action").val("I");
	         
	         
	         //모달창 수정쪽  초기화 - 데이터 없음ㅡIF문 타고 신규등록으로감
	         bizInitFormClient();
	         
	         // 모달 팝업         	
			 gfModalPop("#layer1");
	            
	         // 수정 저장 - 수정모달창
	      } else {
	         
	         // Tranjection type 설정
	         $("#action").val("U");
	         
	         // 그룹코드 단건 조회
	         clientOne(client_cd);   
	      }
	   }
		
	
	
   
   /*  2 .단건조회 등등  모달창 값 초기화  */
	function bizInitFormClient(data) {
	   
	   
		$("#cliCnt").focus();
		 
	
	
		//2 - 1 신규등록	일 때
		if( data == "" || data == null || data == undefined) {
			

		
			$("#client_nm").val("");
			

			$("#local_tel1").val("");
			$("#local_tel2 ").val("");
			$("#local_tel3").val("");
			
			$("#emp_nm").val("");
			$("#emp_hp").val("");
			$("#zip_code").val("");

			

			$("#addr").val("");
			$("#addr_detail").val("");
			
			
			$("#job_type").val("");
			$("#cop_no1").val("");
			$("#cop_no2").val("");
			$("#cop_no3 ").val("");
			
			

			$("#bank").val("");
			$("#account").val("");
			$("#reg_date").val(""); 
			
			
			$("#phone_tel1").val("");
			$("#phone_tel2").val("");
			$("#phone_tel3").val("");
			
			
			
			$("#email1").val("");
			$("#email2").val("none_email");
			
			$("#memo").val("");
			
			$('#divtitle').empty();
			
			$("#divtitle").append("<strong>거래처등록</strong>");
			

		} else {


			//2 - 2 단건조회 수정 모달창 
			$("#client_cd").val(data.client_cd);
		 	
		 	$("#client_nm").val(data.client_nm); // data.실제컬럼이름

			
			
			// 회사번호 
			$("#local_tel2").val(data.tel);	
			var beta0 = $("#local_tel1").val();
			var beta1 = $("#local_tel2").val();
			var beta1Answer = beta1.split("-");



			console.log("beta1Answer    ",beta1Answer);
			
			
			$("#local_tel2").val(beta1Answer[1]);
			var beta2 = $("#local_tel3").val();

			console.log("beta1Answer    ",beta1Answer[2]);
			$("#local_tel3").val(beta1Answer[2]);
			
			if(beta0 != beta1Answer[0]){
				console.log("beta0    " ,  beta0);
				
				$("#local_tel1").val(beta1Answer[0]);
			}
			
			

			//담당자 이름
			$("#emp_nm").val(data.emp_nm);
			
			//담당자 번호 split [표본]
			$("#phone_tel2").val(data.emp_hp);
		
			
			var alpa0 =$("#phone_tel1").val();
			var alpa1 = $("#phone_tel2").val();
			var alpa1Answer = alpa1.split("-");
			
			console.log("alpa1Answer    ",alpa1Answer);
			
			
			$("#phone_tel2").val(alpa1Answer[1]);
			var alpa2 = $("#phone_tel3").val();
			console.log("alpa1Answer    ",alpa1Answer[2]);
			$("#phone_tel3").val(alpa1Answer[2]);
			
			if(alpa0 != alpa1Answer[0]){
				console.log("alpa0    " ,  alpa0);
				
				$("#phone_tel1").val(alpa1Answer[0]);
			}
			

			$("#zip_code").val(data.zip_code);
			$("#addr").val(data.addr);
			$("#addr_detail").val(data.addr_detail);
			

			$("#email1").val(data.email);
			var gamma0 = $("#email1").val();
			var gamma0Answer = gamma0.split('@');
			console.log("gamma0Answer" , gamma0Answer[0]);

			$("#email1").val(gamma0Answer[0]);
			
			var gamma1 = $("#email2").val();		
			if(gamma1 != gamma0Answer[1]){
				$("#email2").val(gamma0Answer[1]);	
			}
			
			
			
			$("#job_type").val(data.job_type);
			
			
			$("#cop_no1").val(data.cop_no1);
			$("#cop_no2").val(data.cop_no2);
			$("#cop_no3 ").val(data.cop_no3);
			
			
			
			// 셀렉트 
			$("#bank").val(data.bank).text();
			var bank0 = $("#bank").val();
			console.log("bank0 " ,  bank0);

			$("#account").val(data.account);
			$("#memo").val(data.memo);
			

			

			// 작성자 본인일때만 수정,삭제영역 보임
		 	if(clientList.login_id!="${loginId}"){
				$("#changeArea").hide();
			} else{
				$("#changeArea").show();
			}
			
			
			$('#divtitle').empty();
			
			$("#divtitle").append("<strong>거래처수정</strong>");
		}
	}
   

   
	/**  3.  목록 뿌려주기 */
	function clientList(currentPage) {  
	
		currentPage = currentPage || 1;

        var param = {
        	
             	currentPage : currentPage
             	,pageSize : pageSizeClientList

        }

	     console.log(" param : " ,param);
		 console.log("param.valueOf()",  param.valueOf());
		
		 
		 //콜백
		var resultCallback = function(data) {
			console.log("=======resultCallback========");
		
			//목록 조회 결과 
			clinetListResult(data,currentPage);
			console.log(" 목록뿌려주기 조회결과 data ",data);
		};
		
		/*  보낼 링크 / 컨트롤러로 보낼 방식 /  받을 방식 ,데이터,, 비동기? 동기,     돌려 줄 함수  */
		callAjax("/business/bizPartnerList.do", "post", "text",  true,param, resultCallback); //text
	 			//callAjax("/system/listComnGrpCod.do", "post", "text", true, param, resultCallback); 
	}


	/**  3-1.목록조회 콜백 함수 */
	function clinetListResult(data,currentPage) {
		
		console.log("목록조회 콜백함수 ",data);

		// 기존 목록 삭제
		$('#listBizParter').empty(); 
		// 신규 목록 생성
		$("#listBizParter").append(data);
		// 총 갯수 추출
		var cliCnt = $("#cliCnt").val();
		

		
		// 네비게이션
		//	현재페이지  , 행 갯수 , 리스트사이즈 , 블록 갯수 , 목록리스트함수 
		var bizPartHtml = getPaginationHtml(
				currentPage, 
				cliCnt,
				pageSizeClientList ,  
				pageBlockSizeClientList,
				'clientList'
				);
		
		console.log("bizPartHtml : " + bizPartHtml);

		//네비게이션 비우고 다시 채우기
		$("#BizPagination").empty().append( bizPartHtml );
		
		// BizCurrentPage 에 현재 페이지 설정
		$("#BizCurrentPage").val(currentPage);
		
		// 값이제대로 왔다 확인 
		var BizCurrentPage = $("#BizCurrentPage").val();
		console.log("BizCurrentPage " +  BizCurrentPage);
		
		
	}
	

	/** 4. 단건 조회 */
	function clientOne(client_cd) {

		var param = {
				client_cd : client_cd
		};
		
		var resultCallback = function(data) {
			clientOneResult(data);
		};
		callAjax("/business/bizPartListSelect.do", "post", "json", true, param, resultCallback);
	}
	

	
	
	/**  4-1 단건 조회 콜백 함수*/
	function clientOneResult(data) {
		
		if (data.result == "SUCCESS") {

			// 모달 팝업
			gfModalPop("#layer1");
			
			// 그룹코드 폼 데이터 설정
			bizInitFormClient(data.bizpart);

			
	 		var bank =  $("#bank").prop("checked");
	 		console.log("bank",bank);
			
		} else {

		}	
	}
	
	
	 /* 팝업내 수정, 저장 validation */
	 function bValidatePopup(){
		 var chk = checkNotEmpty(
				 [
					 ["client_nm", "업체명을 입력해주세요!"],
					 ["local_tel2", "번호를 입력해주세요"],
					 ["local_tel3", "번호를 입력해주세요"],
					 ["emp_nm", "담당자를 입력해주세요"],
					 ["phone_tel1", "번호를 선택해주세요"],
					 ["phone_tel2", "번호를 입력해주세요"],
					 ["phone_tel3", "번호를 입력해주세요"],
					 ["cop_no1", "번호를 입력해주세요"],
					 ["cop_no2", "번호를 입력해주세요"],
					 ["cop_no3", "번호를 입력해주세요"],
					 ["account", "번호를 입력해주세요"]
				]
		 );
	 
	 	if(!chk){return;}
	 	return true;
	 }
	 
	 /*  모달창 == form   저장 */
	 function bSaveBiz(){
		 
		 alert("저장 함수 타는지!!!!!?? ");
		 
		 
		 // validation 체크 
		 if(!(bValidatePopup())){ return; }
		 
		 var resultCallback = function(data){
			 
			 bSaveBizResult(data); // 저장 콜백 함수 
		 };
		 
		//폼이름 =>$("#myNotice").serialize() => 직렬화해서 name 값들을 그냥 넘김.
		 callAjax("/business/bizPartListSave.do", "post", "json", true, $("#bizForm").serialize(), resultCallback);
	 	
	 }
	 
	 
	/*  [저장 & 수정  & 삭제 함수 콜백 함수 */
	 function  bSaveBizResult(data){

		 var currentPage = currentPage || 1; 
	
		 if($("#action").val() != "I"){
			 currentPage = $("#currentPage").val();	
			 client_cd =  $('client_cd').val();
			 
		 }

		 if(data.resultMsg == "SUCCESS"){
			
			 alert(data.resultMsg);	// 받은 메세지 출력 
			 alert("저장 되었습니다.");
			 
		 }else if(data.resultMsg == "UPDATED") {
			 alert("수정 되었습니다.");
			 
		 }else if(data.resultMsg == "DELETED") {
			 alert("삭제 되었습니다.");
			 
		 }else{
			 alert(data.resultMsg); //실패시 이거 탄다. 

		 }

		 gfCloseModal();	// 모달 닫기
		 clientList(currentPage); // 목록조회 함수 다시 출력 
		 bizInitFormClient();// 입력폼 초기화
	 }
	 /*  1건 삭제 */
	 function bDeleteBiz(){
		 var con = confirm("정말 삭제하겠습니까? \n 삭제시 복구불가합니다."); 
		 if(con){
			 var resultCallback = function(data){
				 bSaveBizResult(data); // 삭제한걸 저장
			 }																				 	// serialize => 함수를 json형태로 정렬한다 
			 callAjax("bizPartListDelete.do", "post", "json", true, $("#bizForm").serialize(), resultCallback);
		
		 }else{
			 gfCloseModal();	// 모달 닫기
			 clientList(currentPage); // 목록조회 함수 다시 출력 
			 bizInitFormClient();// 입력폼 초기화
		 }
	 }
	 
	 
	 
	 //검색구현
		function bSearchBiz(currentPage) {
		 
		 
		 /* 달력=>datepicker 사용했음 
		 document.ready에서 		
		$('#from_date').datepicker();
		$('#to_date').datepicker();  작성 후 검색구현 함수에서 값 가져오기  */
			
		currentPage = currentPage || 1;
	
			// 날짜 1
			var to_date = $("#to_date").val();
			// 날짜 2
			var from_date = $("#from_date").val();
			
			console.log('to_date' , to_date);
			console.log('from_date' , from_date);


			// 값 내용물 
			console.log("from_date : " + from_date.valueOf());     
			console.log("to_date : " + to_date.valueOf());     
			
			
	        var param = {
	                  currentPage : currentPage //컨트롤러로 넘어가는 데이터들
	              ,    pageSize : pageSizeClientList //컨트롤러로 넘어가는 데이터들
	              ,    from_date : from_date //컨트롤러로 넘어가는 데이터들
	              ,    to_date : to_date //컨트롤러로 넘어가는 데이터들
	        }
		     console.log(" param : " ,param);
			 console.log("param.valueOf()",  param.valueOf());
			
			var resultCallback = function(data) {
				console.log("=======resultCallback========");
			
				//목록 조회 결과 
				clinetListResult(data,currentPage);
				console.log(" 검색 조회결과 data ",data);
			};
			
			
			// 목록조회에 던져준다.
			/*  순서 주의 :  보낼 링크 / 컨트롤러로 보낼 방식 /  받을 방식 ,데이터,, 비동기? 동기,     돌려 줄 함수  */
			callAjax("/business/bizPartnerList.do", "post", "text",  true,param, resultCallback); //text

	        
	  } 
	 
	 
	 

 </script>
 

</head>
<body>
	<form id="bizForm" action=""  method="">
	


<!--  BizPartnerCallBack으로 보내는 데이터들 -->
	   <input type="hidden" id="BizCurrentPage" value="1">
  
	   <input type="hidden" name="action" id="action" value=""> <!-- form을 Callback으로 보냄  -->

	   
		   
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
	                        class="btn_nav">영업</a> <span class="btn_nav bold"> 거래처관리
	                        </span> <a href=javascript:location.reload(); class="btn_set refresh">새로고침</a>
	                  </p>
	
	                  <p class="conTitle">
	                     <span>거래처관리</span> <span class="fr"> <a
	                        class="btnType blue" href="javascript:BizPartnerModal1();" name="modal"><span>거래처등록</span></a>
	                     </span>
	                  </p>
	                  
	                  

	          <!-- 검색조회 -->
	          <!-- form 안에 form이 맞나? 버튼두고 자바스크립트로  보내기  자바스크립트 함수 하나 만들기   xxxxxx안하기로 함  -->        
	          <!--  == 콤보박스로 체크  -->   
	     
                 <!--검색   -->
                 <br>       
                 <div style = "padding : 3% 10% 3% 13%  ; border : 3px #CDECFA; border-style : solid ; margin: auto;">
	
	
						
					<div style ="padding: 2% 2% 0 1% ; margin: auto" >	
						<b style ="padding: 0 1% 0 1%" >거래처</b>
						<select name="client_search">
						  <option value="">미래에셋증권</option>
						  <option value="">프렌즈</option>
						</select>
					
	                  	<!-- 달력 조회  -->
							<b style ="padding: 0 3% 0 5%">날짜 </b>
							<input type="text" id="from_date"  style="padding : 0.5%;">~<input type="text" id="to_date"  style="padding : 0.5% 0 0.5% 0;" >
					
							<a href="" class="btnType blue" id="btnSearchBiz" name="btn" style ="float : right; ">
							 	<span>조회</span>
							</a> 
					 </div>
                  </div>
                   <!-- 검색조건 끝 -->
							
							
	                <!-- 조회목록 윗칸띄우기 -->
	                  <div class="zldf" style ="padding-top: 2%;margin: auto;"> </div>

	                     <table class="col">
	                        <caption>caption</caption>
	                        <colgroup>
	                           <col width="10%">
	                           <col width="14%">
	                           <col width="14%">
	                           <col width="14%">
	                           <col width="14%">
	                           <col width="10%">
	                           <col width="*">
	                        </colgroup>
	                        
	                        
	                       <thead>
	                           <tr>
	                             <th scope="col">등록일</th>
	                              <th scope="col">거래처이름</th>
	                               <th scope="col">주소</th>
	                              <th scope="col">회사전화</th>
	                              <th scope="col">담당자</th>
	                              <th scope="col">email</th>
	                              <th scope="col">tel</th>
	                              <th scope="col">비고</th>
	                           </tr>
	                        </thead>

	                        <tbody id=listBizParter></tbody> <!--BizParnerCallBack으로 넘어감.여기는 틀만 만드는곳  -->
	                     </table>
	                  	<!-- 페이징에리어 -->
						<div class="paging_area"  id="BizPagination"></div>
	               </div> 
	               <!-- content end -->
	         </div>
					 <h3 class="hidden">풋터 영역</h3>
	                 <jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
	          </div>








	   <!-- 모달팝업 ==  거래처 등록 1 -->
	   <div id="layer1" class="layerPop layerType2"  style="width: 800px;">
	      <dl>
	         <dt>
	            <div id="divtitle" style="color:white">거래처 등록</div>
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
				
						  <td hidden=""><input type="text" class="inputTxt p100" name="client_cd" id="client_cd" /></td> <!-- int가 아니므로 hidden 값   -->
	     
	                     <th scope="row">업체명 <span class="font_red">*</span></th>
	                     <td hidden=""><input type="hidden" id="client_cd"></td>
	                     <td><input type="text" class="inputTxt p100" name="client_nm" id="client_nm" /></td>
	                     
	                     <th scope="row">업체전화<span class="font_red">*</span></th>
	                     <td  class="inputTxt p100">
	                     	<select style ="width :20%" id="local_tel1" name = "local_tel1" >
	                     	  	<option value ="" selected>선택</option>
		                    	 <option value ="02">02</option>
		                     	 <option value ="031">031</option>
		                     	 <option value ="053">053</option>
	                     	 </select>
	                     	 -<input type="text"   name="local_tel2" id="local_tel2" style ="width :30%; height :70%" maxlength="4" >
	                     	 -<input type="text"  name="local_tel3" id="local_tel3" style ="width :30%; height :70%" maxlength="4"/>
		                  </tr>
		                  <tr>
		                     <th scope="row">담당자<span class="font_red">*</span></th>
		                     <td><input type="text" class="inputTxt p100" name="emp_nm" id= "emp_nm" /></td>
		                     
		                     <th scope="row">휴대전화<span class="font_red">*</span></th>
		                     <td  class="inputTxt p100">
		                     	<select style ="width :20%"  id="phone_tel1" name = "phone_tel1">
		                     	 	 <option  value ="" selected>선택</option> 
			                    	 <option value ="010"  >010</option>
			                     	 <option value ="017" >017</option>
			                     	 <option value ="018" >018</option>
		                     	 </select>
		                     	 -<input type="text" id="phone_tel2"  name = "phone_tel2" style ="width :30%; height :70%" maxlength="4" >
		                     	 -<input type="text"  id="phone_tel3" name = "phone_tel3" style ="width :30%; height :70%" maxlength="4"/>
		                  </tr>
		                  

		               
		                  <tr>
		                     <th scope="row">우편번호</th>
		             		  <td  class="inputTxt p100">
		             		  
		             		  	<input type="text"  name="zip_code" id="zip_code" style ="width :35%; height :90%" >
		             		 <input type="button" onclick="sample4_execDaumPostcode()" class="btnType blue" id="btnSearchGrpcod" name="btn"  value="우편번호 찾기"><br>
		             		  </td>			
		                  </tr>
		                  
		                  
		                  <!-- 주소 저장할 때 concat  -->
		                  <tr>
		                     <th scope="row">주소</th>
		                     <td colspan="3"><input type="text" class="inputTxt p100"
		                        name="addr" id="addr" /></td>
		                  </tr>
		                  
		                  <tr>
		                     <th scope="row">나머지주소</th>
		                     <td colspan="3"><input type="text" class="inputTxt p100"
		                        name="addr_detail" id="addr_detail" /></td>
		                  </tr>

		                  
		            
		                  
		                  <tr>
		                     <th scope="row" >업체이메일<span class="font_red">*</span></th>
			                     <td colspan="3"> <!--  칸 늘림  -->
			                     	<input type="text"  name="email1" id="email1" style ="width :20%; height :80%" > @ 
			                  		<select style ="width :20% "  name="email2" id="email2">
			                  			 <option  value ="none_email" selected>선택</option>
				                    	 <option  value ="naver.com">naver.com</option>
				                     	 <option  value ="daum.net">daum.net</option>
				                     	 <option  value ="gmail.com">gmail.com</option>
			                     	 </select>
			                    </td>
		                  </tr>
		                  
		                  <tr>
			                  <th scope="row" >업종<span class="font_red">*</span></th>
				                <td colspan="3">
				                   <input type="text"  name="job_type" id="job_type" style ="width :50%; height :80%" > 
				                 </td>
		                  </tr>
		                  
		                 <tr>
		                 	<th scope="row" >사업자등록번호<span class="font_red">*</span></th>
				               <td colspan="3">
				                  <input type="text"  name="cop_no1" id="cop_no1" style ="width :15%; height :80%"  maxlength="3">-
				                  <input type="text"  name="cop_no2" id="cop_no2" style ="width :15%; height :80%"  maxlength="2" >-
				                  <input type="text"  name="cop_no3" id="cop_no3" style ="width :15%; height :80%"  maxlength="5" >
				                   
				             </td>
		                  </tr>
		                  
		                   
		                  <tr>
		                     <th scope="row" >은행<span class="font_red">*</span></th>
			                     <td> <!--  칸 늘림  -->
			                  		<select id="bank" name="bank" style="width: 33%;"></select>
									<input class="inputTxt" style="width: 63%" type="text" id="account" name="account" maxlength="12">
			                    </td>
			                
		                   </tr>
		                    <tr>
			                  <th scope="row" >메모<span class="font_red">*</span></th>
				                <td colspan="3">
				                   <input type="text"  name="memo" id="memo" style ="width :50%; height :80%" > 
				                 </td>
		                  </tr>
		               </tbody>
		            </table>
		            <div class="btn_areaC mt30">
		               <a href="" class="btnType blue" id="btnSaveBiz" name="btn"><span>저장</span></a> 
		               <a href="" class="btnType blue" id="btnDeleteBiz" name="btn"><span>삭제</span></a> 
		               <a href=""   class="btnType gray"  id="btnCloseGrpCod" name="btn"><span>취소</span></a>
		            </div>
		         </dd>
		      </dl>
		      <a href="" class="closePop"><span class="hidden">닫기</span></a>
		   </div>
		   <!-- 모달1 끝 -->

		  
   	</form>

   </body>
</html>
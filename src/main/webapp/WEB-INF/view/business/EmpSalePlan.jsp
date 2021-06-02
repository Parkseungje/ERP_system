<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>JobKorea</title>

<!--vue.js  -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>


<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>


<!-- 영업계획  -->
<style>
	#layer1 {
  overflow-y: scroll;
}
</style>



<script type="text/javascript">

// 그룹코드 페이징 설정
var pageSizeSalePlan = 5;
var pageBlockSizeSalePlan = 5;



// 함수 시작
	$(document).ready(function(){
		
		//거래처 목록
		 planList();
		
		//모달창 초기화
		 pInitForm();
			
		// 버튼 이벤트 등록
		pRegisterButtonClickEvent();
		
		// 공통코드 comcombo 사용방법 ->
		// Group Code, Combo Name, Option("all" : 전체 / "sel" : 선택 , Select Value ) 사원등록 모달창
		comcombo("BKcd", "bank", "sel", "0"); //은행계좌

		
		//목록 거래처 이름 콤보박스 
		selectComCombo("cli", "client_search", "all", ""); 
		// -> 견적서등록 모달용 거래처 이름
		selectComCombo("cli", "client_search1", "all", "");   
	
		// 목록 SCM 제품
		productCombo("l", "scm_big_class", "all", "");
		// 모달안 SCM 제품
		productCombo("l", "scm_big_class1", "all", "");

		// datepicker 사용 선언 
		$('#from_date').datepicker();
		$('#to_date').datepicker();


	});





	/** 버튼 이벤트 등록 */
	function pRegisterButtonClickEvent() {
		$('a[name=btn]').click(function(e) {
			e.preventDefault();

			var btnIdPaln = $(this).attr('id'); // id값 들어오면 변수에 넣어준다 

			switch (btnIdPaln) {
				case 'btnUpdatePaln' : // 신규등록 , 수정사항 저장
					pSavePlan();
					break;
				case 'btnDeletePaln' : // 삭제 
					pDeletePlan();
					break;
				case 'btnSearchPaln': // 검색 
					pSearchPlan();
					break;
				case 'btnClosePaln' : // 모달 닫기 함수 [나는 하나로 썼음 ]
					gfCloseModal();
					break;
			}
		});
	}
	


	   /*  1.  모달 :  모달 실행 */
	   function PlanModal1(sales_pro_seq){
	      
	      // 신규 저장
	      if (sales_pro_seq == null || sales_pro_seq =="") {
	      
	         // Tranjection type 설정
	         $("#action").val("I");
	         
	         
	         //모달창 수정쪽  초기화 - 데이터 없음ㅡIF문 타고 신규등록으로감
	         pInitForm();
	         
	         // 모달 팝업         	
			 gfModalPop("#layer1");
	            
	         // 수정 저장 - 수정모달창
	      } else {
	         
	         // Tranjection type 설정
	         $("#action").val("U");
	         
	         // 그룹코드 단건 조회 
	         planOne(sales_pro_seq);   
	      }
	   }
		
	
	

/*  2 .단건조회 등등  모달창 값 초기화  */
	function pInitForm(data) {
	   
	   
		$("#planCnt").focus();
		 
	
	
		//2 - 1 신규등록	일 때
		if( data == "" || data == null || data == undefined) {
			
			$("#client_search").val("");
		
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
			
			$("#divtitle").append("<strong>신규계획등록</strong>");
			

		} else {


			//2 - 2 단건조회 수정 모달창 
			$("#sales_pro_seq").val(data.sales_pro_seq);
			$("#client_cd").val(data.client_cd);

			
		
			//담당자 이름
			$("#emp_nm").val(data.emp_nm);
			
			//담당자 번호 split [표본]
			$("#phone_tel2").val(data.emp_hp);
		
			
			// 셀렉트 
			$("#bank").val(data.bank).text();
			var bank0 = $("#bank").val();
			console.log("bank0 " ,  bank0);

			$("#account").val(data.account);
			$("#memo").val(data.memo);
			

			

			// 작성자 본인일때만 수정,삭제영역 보임
		 	if(planList.login_id!="${loginId}"){
				$("#changeArea").hide();
			} else{
				$("#changeArea").show();
			}
			
			
			$('#divtitle').empty();
			
			$("#divtitle").append("<strong>영업계획수정</strong>");
		}
	}



	/**  3.  목록 뿌려주기 */
	function planList(currentPage) {  
	
		currentPage = currentPage || 1;
		
		

		
		// 거래처 넘기기 
		var client_search =   $("#client_search").val();

		
	
		// 날짜 1
		var to_date = $("#to_date").val();
		// 날짜 2
		var from_date = $("#from_date").val();

     var param = {
			currentPage : currentPage
          	,pageSize : pageSizeSalePlan
     		,client_search:client_search
          	,to_date:to_date // 뷰단에 남아있는 날짜 데이터 넣어줘서 다시 조회
          	,from_date:from_date
     }

	     console.log(" param : " ,param);
		 console.log("param.valueOf()",  param.valueOf());

		 console.log("client_search", client_search);
		 
		 
		 //콜백
		var resultCallback = function(data) {
			console.log("=======resultCallback========");
		
			//목록 조회 결과 
			planListResult(data,currentPage);
			console.log(" 목록뿌려주기 조회결과 data ",data);
		};
		
		/*  보낼 링크 / 컨트롤러로 보낼 방식 /  받을 방식 ,데이터,, 비동기? 동기,     돌려 줄 함수  */
		callAjax("/business/planList.do", "post", "text",  true,param, resultCallback); //text
	 			//callAjax("/system/listComnGrpCod.do", "post", "text", true, param, resultCallback); 
	}


	/**  3-1.목록조회 콜백 함수 */
	function planListResult(data,currentPage) {
		
		console.log("목록조회 콜백함수 ",data);

		// 기존 목록 삭제
		$('#listPlan').empty(); 
		// 신규 목록 생성
		$("#listPlan").append(data);
		// 총 갯수 추출
		var planCnt = $("#planCnt").val();
		

		
		// 네비게이션
		//	현재페이지  , 행 갯수 , 리스트사이즈 , 블록 갯수 , 목록리스트함수 
		var planPartHtml = getPaginationHtml(
				currentPage, 
				planCnt,
				pageSizeSalePlan ,  
				pageBlockSizeSalePlan,
				'planList'
				);
		
		console.log("planPartHtml : " + planPartHtml);

		//네비게이션 비우고 다시 채우기
		$("#PlanPagination").empty().append( planPartHtml );
		
		// BizCurrentPage 에 현재 페이지 설정
		$("#PlanCurrentPage").val(currentPage);
		
		// 값이제대로 왔다 확인 
		var BizCurrentPage = $("#PlanCurrentPage").val();
		console.log("PlanCurrentPage " +  PlanCurrentPage);
		
		
	}
	

	/** 4-1. 단건 조회 */
	function planOne(sales_pro_seq) {

		var param = {
				sales_pro_seq : sales_pro_seq
		};
		
		var resultCallback = function(data) {
			planOneResult(data);
		};
		callAjax("/business/planListSelect.do", "post", "json", true, param, resultCallback);
	}
	

	
	
	/**  4-2 단건 조회 콜백 함수*/
	function planOneResult(data) {
		
		if (data.result == "SUCCESS") {

			// $("#cnt").val(data.bizpart.cnt);
			
			// 모달 팝업
			gfModalPop("#layer1");
			
			// 컨트롤러에서 온 데이터폼 데이터 설정
			pInitForm(data);

			
	 		var bank =  $("#bank").prop("checked");
	 		console.log("bank",bank);

		}	
	}


	
	 /* 팝업내 수정, 저장 validation */
	 function pValidatePopup(){
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
	 /* 팝업내 수정, 저장 validation 끝 */
	 
	 
	 
	 
	 
	 /*  신규 등록 및 저장  */
	 function pUpdatePlan(){
		 
		 alert("저장 함수 타는지!!!!!?? ");
		 
		 
		 // validation 체크 
		 if(!(pValidatePopup())){ return; }
		 
		 var resultCallback = function(data){
			 
			 pSaveResult(data); // 저장 콜백 함수 
		 };
		 
		//폼이름 =>$("#myNotice").serialize() => 직렬화해서 name 값들을 그냥 넘김.
		 callAjax("/business/updatePlanList.do", "post", "json", true, $("#salesForm1").serialize(), resultCallback);
	 	
	 }
	 

	 /*  단건 삭제 */
	 function pDeletePlan(){
		 var con = confirm("정말 삭제하겠습니까? \n 삭제시 복구불가합니다."); 
		 if(con){
			 var resultCallback = function(data){
				 bSaveBizResult(data); // 삭제한걸 저장
			 }																				 	// serialize => 함수를 json형태로 정렬한다 
			 callAjax("/business/deletePlanList.do", "post", "json", true, $("#bizForm").serialize(), resultCallback);
		
		 }else{
			 gfCloseModal();	// 모달 닫기
			 planList(currentPage); // 목록조회 함수 다시 출력 
			 pInitForm();// 입력폼 초기화
		 }
	 }
	 
	 
	 
	 
		/*  [저장 & 수정  함수 콜백 함수 */
		 function  pSaveResult(data){

			 var currentPage = currentPage || 1; 
		
			 if($("#action").val() != "I"){
				 currentPage = $("#currentPage").val();	
				 sales_pro_seq =  $('sales_pro_seq').val();
				 
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
			 planList(currentPage); // 목록조회 함수 다시 출력 
			 pInitForm();// 입력폼 초기화
		 }
		
	 
	 
	 
	 //검색구현
		function pSearchPlan(currentPage) {
		 
		 
		 /* 달력=>datepicker 사용했음 
		 document.ready에서 		
		$('#from_date').datepicker();
		$('#to_date').datepicker();  작성 후 검색구현 함수에서 값 가져오기  */
			
		currentPage = currentPage || 1;
	
		
	
		
		// 거래처 넘기기 
		var client_search =   $("#client_search").val();

		
			// 날짜 1
			var to_date = $("#to_date").val();
			// 날짜 2
			var from_date = $("#from_date").val();
			
			console.log('to_date' , to_date);
			console.log('from_date' , from_date);


			// 값 내용물 
			console.log("from_date : " + from_date.valueOf());     
			console.log("to_date : " + to_date.valueOf());     
			
			
			console.log('client_search ' ,   client_search);


			
	        var param = {
	        			client_search : client_search
	              ,    currentPage : currentPage //컨트롤러로 넘어가는 데이터들
	              ,    pageSize : pageSizeSalePlan //컨트롤러로 넘어가는 데이터들
	              ,    from_date : from_date //컨트롤러로 넘어가는 데이터들
	              ,    to_date : to_date //컨트롤러로 넘어가는 데이터들
	        }
		     console.log(" param : " ,param);
			 console.log("param.valueOf()",  param.valueOf());
			
			var resultCallback = function(data) {
				console.log("=======resultCallback========");
			
				//목록 조회 결과 
				planListResult(data,currentPage);
				console.log(" 검색 조회결과 data ",data);
			};
			
			
			// 목록조회에 던져준다.
			/*  순서 주의 :  보낼 링크 / 컨트롤러로 보낼 방식 /  받을 방식 ,데이터,, 비동기? 동기,     돌려 줄 함수  */
			callAjax("/business/planList.do", "post", "text",  true,param, resultCallback); //text

	        
	  } 
		
		// scm 대분류,중분류,제품 콤보박스 
       function selectmidcat(){
         var largecd = $("#scm_big_class").val();
         productCombo("m", "scm_middle_class", "all", largecd);   // 조회 종류   l : 대분류  m : 중분류  p:중분류 제품,   Combo Name, Option("all" : 전체     "sel" : 선택 ,  중분류 코드(제품 목록 조회시 필수))  

         $("#scm_middle_class").find("option").remove();
         $("#scm_product").find("option").remove();
       } 
       function selectproductlistcombo(){
         var margecd = $("#scm_middle_class").val();
         productCombo("p", "divproducttall", "all", margecd);   // 조회 종류   l : 대분류  m : 중분류  p:중분류 제품,   Combo Name, Option("all" : 전체     "sel" : 선택 ,  중분류 코드(제품 목록 조회시 필수))  
       }
	 
		// scm 대분류,중분류,제품 콤보박스 
       function selectmidcat1(){
         var largecd = $("#scm_big_class1").val();
         productCombo("m", "scm_middle_class1", "all", largecd);   // 조회 종류   l : 대분류  m : 중분류  p:중분류 제품,   Combo Name, Option("all" : 전체     "sel" : 선택 ,  중분류 코드(제품 목록 조회시 필수))  

         $("#scm_middle_class1").find("option").remove();
         $("#scm_product").find("option").remove();
       } 
       function selectproductlistcombo1(){
         var margecd = $("#scm_middle_class1").val();
         productCombo("p", "divproducttall1", "all", margecd);   // 조회 종류   l : 대분류  m : 중분류  p:중분류 제품,   Combo Name, Option("all" : 전체     "sel" : 선택 ,  중분류 코드(제품 목록 조회시 필수))  
       }
	 
	 

</script>



<body>
<form id="salesForm1" action=""  method="">
  
	   <input type="hidden" id="PlanCurrentPage" value="1">

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
	                        class="btn_nav">영업</a> <span class="btn_nav bold"> 영업계획
	                        </span> <a href=javascript:location.reload(); class="btn_set refresh">새로고침</a>
	                  </p>
	
	                  <p class="conTitle">
	                     <span>영업계획</span> <span class="fr"> <a
	                        class="btnType blue" href="javascript:PlanModal1();" name="modal"><span>계획등록</span></a>
	                     </span>
	                  </p>
	                  
	                  

	          <!-- 검색조회 -->
	          <!-- form 안에 form이 맞나? 버튼두고 자바스크립트로  보내기  자바스크립트 함수 하나 만들기   xxxxxx안하기로 함  -->        
	          <!--  == 콤보박스로 체크  -->   
	     
                 <!--검색   -->
                 <br>       
                 <div style = "padding : 3% 10% 3% 13%  ; border : 3px #CDECFA; border-style : solid ; margin: auto;">
	
	
						
					<div >	
						<b>거래처</b>
						<select name="client_search" id ='client_search'></select>

	                  	<!-- 달력 조회  -->
							<b>날짜 </b>
							<input type="text" id="from_date"  style="padding : 0.5%;">~<input type="text" id="to_date"  style="padding : 0.5% 0 0.5% 0;" >
							<tr>
							         <th scope="row">대분류<span class="font_red">*</span></th>
                   				<td>
										<select id="scm_big_class" name="scm_big_class" onChange="javascript:selectmidcat();"></select>
								</td>
	                             <th scope="row">중분류<span class="font_red">*</span></th>
								<td>
								<select id="scm_middle_class" name="scm_middle_class" onChange="javascript:selectproductlistcombo();"></select>
			    				<th scope="row">제품<span class="font_red">*</span></th>
									<td>
										<select id="divproducttall" name="divproducttall"></select>
								</td>
									</tr>
							
							<a href="" class="btnType blue" id="btnSearchPlan" name="btn" style ="float : right; ">
							 	<span>조회</span>
							</a> 
							
			
			               
					 </div>
				
			            
                  </div>
                   <!-- 검색조건 끝 -->
							
	
                  			
	                <!-- 조회목록 윗칸띄우기 -->
	                  <div class="zldf" style ="padding-top: 2%;margin: auto;"> </div>
                <!-- 조회목록 -->
                     <table class="col">
                        <caption>caption</caption>
                        <colgroup>
                           <col width="10%">
                           <col width="14%">
                           <col width="14%">
                           <col width="10%">
                           <col width="15%">
            
                           <col width="*">
	                </colgroup>
   
   
   				
   
                        <thead>
                           <tr>
                              <th scope="col">등록일</th>
                              <th scope="col">거래처이름</th>
                              <th scope="col">대분류</th>
                              <th scope="col">소분류</th>
                              <th scope="col">제품이름</th>
                              <th scope="col">목표수량</th>
                              <th scope="col">실적수량</th>
                              <th scope="col" >비고</th>
                           </tr>
                        </thead>
                        <tbody id="listPlan"></tbody>
                     </table>
                  </div>
                  <div class="paging_area"  id="PlanPagination"> </div>
   				</div>
   			</li>
   		</ul>
 	  </div>
   </div>
   
   

   <!-- 모달팝업 ==  신규 등록 1 -->
		   <div id="layer1" class="layerPop layerType2"  style="width: 800px;">
		      <dl>
		         <dt>
		            <div id="divtitle" style="color:white">계획 신규등록</div>
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
					
							 <!-- 목록조회 외에 UPDATE, INSERT , DELETE 등을 위해 필요함  hidden 값  // INT가 아닌것도 있음  -->
							  <td hidden=""><input type="text" class="inputTxt p100" name="estimate_no" id="estimate_no" /></td> 
		     
		                     <th scope="row">거래처 이름<span class="font_red">*</span></th>
		                     <td hidden=""><input type="hidden" id="client_nm"></td>
		                     				
							<td><!-- 거래처 콤보박스   -->
								<select name="client_search1" id ='client_search1'></select>	
							</td>
		                
			                  <tr>
			                     <th scope="row">대분류<span class="font_red">*</span></th>
                   				<td>
										<select id="scm_big_class1" name="scm_big_class1" onChange="javascript:selectmidcat1();"></select>
								</td>
	                             <th scope="row">중분류<span class="font_red">*</span></th>
								<td>
								<select id="scm_middle_class1" name="scm_middle_class1" onChange="javascript:selectproductlistcombo1();"></select>
			
								</td>
			                  </tr>
			          
			                  <tr>
	                             <th scope="row">제품<span class="font_red">*</span></th>
									<td>
										<select id="divproducttall1" name="divproducttall1"></select>
									</td>
									        <th scope="row">목표수량 </th>
			                    			 <td colspan="3">
			                    			 			<input type='number' name="goal_amt" id="goal_amt"  />
                    			 			</td>
			                	  </tr>

			               </tbody>
			            </table>
			            <div class="btn_areaC mt30">
			               <a href="" class="btnType blue" id="btnUpdatePlan" name="btn"><span>등록</span></a> 	
			               <a href=""   class="btnType gray"  id="btnClosePlan" name="btn"><span>취소</span></a>
			            </div>
			         </dd>
			      </dl>
			      <a href="" class="closePop"><span class="hidden">닫기</span></a>
			   </div>
			   <!-- 모달1 끝 -->
		
	</form>	   
      

</body>

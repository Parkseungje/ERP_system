<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>근태신청/조회</title>
<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>


<style type="text/css">
	
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

.right{
		align:right;
	}
.left{
		align:left;
	}
.center{
		display:flex;
		justify-content:center;
	}
.middle{
		vertical-align:middle;
	}
.title{
		font-size:40px;
		padding:30px;
	}
.sa{
		display:flex;
		justify-content:space-around;
	}

.hei{
		height:30px;
		margin: 0px 20px 0px 20px;
		width:200px;
	}

</style>
<script type="text/javascript">
	function fPopModalEmpTaApply(){
		gfModalPop('#layer2');
}
	function fPopModalEmpTaApplyreturn(){
		gfModalPop('#layer1');
}
	
	var currentPage;

	// 그룹코드 페이징 설정
	var pageSize = 5;
	var pageBlockSize = 5;  // 한번에 보여주는 로우수

	$(document).ready(function(){
		
		//comcombo("ACCcd", "bigSelect", "all", "");
		$("input:radio[name=dv_radio]").click(function(){
				 
			        if($("input[name=dv_radio]:checked").val() == "2"){
			            $("#can_reason").prop("disabled",true);
			            // radio 버튼의 value 값이 2이라면 반려사유창 비활성화
			 
			        }else if($("input[name=dv_radio]:checked").val() == "3"){
			              $("#can_reason").prop("disabled",false);
			            // radio 버튼의 value 값이 3이라면 반려사유창 활성화
			        }
			});
		
		fAappList();
		
		
	});
	
	
	
	/* 조회조건 계정정보 대분류에따른 소분류 콤보박스 */

	function fn_selectComCombo() {				
		var account_cd = $("#bigSelect").val();
		
		//selectComCombo("acc", "accSmall", "all",account_cd,"");
		//console.log("account_cd : " + account_cd);
		
	}


	// 모달창 승인 및 반려 업데이트
	function fUpdate(){
	   
	     var resultCallback = function(param) {
	    	 fModalResult(param);
	    	 
	     	};
	    
	     callAjax("/employee/taapproveUpdate.do", "post", "json", true, $("#myForm2").serialize(), resultCallback);
		

		
	  }
	  


	//관리자 공지사항 리스트 데이터 받아오기
	function fAappList(currentPage) {
		var start_date = $("#start_date").val();
		var end_date = $("#end_date").val();
		var loginID = $("#loginID").val();
		var name = $("#name").val();
		var ta_yn = $("#ta_yn").val();
		
		currentPage = currentPage || 1;
	 
		var param = {
				start_date : start_date,
				end_date : end_date,
				loginID : loginID,
				name : name,
				ta_yn : ta_yn,
				pageSize : pageSize,
				currentPage : currentPage
		}

		var resultCallback = function(data) {
			
			
			fAappResult(data, currentPage);
		};

		
		
		//Ajax실행 방식
		//callAjax("Controller Url",type,return,async or sync방식,넘겨준거,값,Callback함수 이름)
		// json으로 보내서 오류가 났음 , -> text
		callAjax("/employee/taapproveList.do", "post", "text", true, param,resultCallback);
		}
	
	
	//관리자 공지사항 리스트 데이터 출력
	function fAappResult(data, currentPage) {

		console.log("값가져오ㅏ ㅇㅅㅇ" + data);
		
		// 기존 목록 삭제
		$('#taapproveList').empty();  // tbody id넣는곳
		$("#taapproveList").append(data);
		//$('#listLec').find("tr").remove() 

		
		var admNoticeCnt = $("#totalCntBmDv").val();

		// 페이지 네비게이션 생성
		var paginationHtml = getPaginationHtml(currentPage, admNoticeCnt,
				pageSize, pageBlockSize, 'fAappList');
		
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
	   function fPopModalDetail(ta_no){
		    
		 
		    var param = { ta_no : ta_no };
			
			var resultCallback = function(data) {
				fAccSelectResult(data);
			};
			
			callAjax("/employee/taapproveUpdateSelect.do", "post", "json", true, param, resultCallback);
			
		}  
	   
	   /** 그룹코드 단건 조회 콜백 함수*/
		function fAccSelectResult(data) {

			if (data.result == "SUCCESS") {

				// 모달 팝업
				gfModalPop('#layer2');
				
				// 그룹코드 폼 데이터 설정
				fInitFormAcc(data.taapproveModel);
				
			} else {
				alert(data.resultMsg);
			}	
		}
	   
		/** 단건조회 폼 초기화 */
		function fInitFormAcc(object) {
				$("#dept_name").val(object.dept_name);
				$("#kind_hol").val(object.kind_hol);
				$("#name2").val(object.name);
				$("#loginID2").val(object.loginID);
				$("#tel").val(object.tel);
				$("#start_date2").val(object.start_date);			
				$("#end_date2").val(object.end_date); 
				$("#reason_hol").val(object.reason_hol); 
				$("#ta_reg_date").val(object.ta_reg_date); 
				$("#ta_no").val(object.ta_no);
				$("#dv_radio").val(object.ta_yn);
				
				
				//console.log("object.accolunt_type_cd : " + object.account_type_cd);
				//alert("object.account_type_cd : " + object.account_type_cd);
				
		}
	   
	 
	
		
		//모달 결과 
		function fModalResult(data) {

			if (data.result == "SUCCESS") {

				// 모달 팝업
				gfCloseModal();
				alert(data.result);
				fAappList();

			} 
			
			else {
				gfCloseModal();
				alert(data.resultMsgYes);
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
                     <span>근태 관리</span> 
                  </p>    
                  
                  <p class="conTitle">
                     <form> 				
        				등록일자<input type="date" id="start_date" name="start_date" />~<input type="date" id="end_date" name="end_date" />
  						<span id="text1">사번
        				<input type="text" style="width:100px" id="loginID" name="loginID">
        				</span>
  						<span id="text2" >사원명
        				<input type="text" style="width:100px" id="name" name="name">
        				</span>
        				<span id="text3">승인여부
        				<select id="ta_yn" name="ta_yn" class="boxx" style="margin-right:6%; width:80px;">
    						<option value="" selected>전체</option>
    						<option value="승인" >승인</option>
    						<option value="승인대기중" >승인대기중</option>
    						<option value="반려" >반려</option>
  						</select> </span>
  						 <a class="btnType blue" href="javascript:fAappList()" ><span id="searchEnter">검색</span></a>
    				 </form>
                  </p> 
                  
                  <div class="divComGrpCodList"  id="vuetable">
                     <table class="col">
                        <caption>caption</caption>
                        <colgroup>
                           <col width="7%">
                           <col width="7%">
                           <col width="7%">
                           <col width="7%">
                           <col width="12%">
                           <col width="12%">
                           <col width="12%">
                           <col width="10%">
                           <col width="10%">
                        </colgroup>
   
                        <thead>
                           <tr>
                              <th scope="col">번호</th>
                              <th scope="col">사번</th>
                              <th scope="col">사원명</th>
                              <th scope="col">신청구분</th>
                              <th scope="col">시작일자</th>
                              <th scope="col">종료일자</th>
                              <th scope="col">신청일자</th>
                              <th scope="col">승인자</th>
                              <th scope="col">승인여부</th>
                           </tr>
                        </thead>
                        <tbody id="taapproveList"></tbody>
                     </table>
                  </div>
   
                 <div class="paging_area" id="admPagination">
                  	
                  </div>

               </div> <!--// content -->

               <h3 class="hidden">풋터 영역</h3>
                  <jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
            </li>
         </ul>
      </div>
   </div>
</form>		

<form id="myForm2" action=""  method="">	
     <div id="layer2" class="layerPop layerType2" style="width: 800px; height:800px;">
     <input type="hidden" name="ta_no" id="ta_no">
      <dl>
         <dt>
            <strong>근태신청</strong>
         </dt>
         <dd class="content" style=" width: 740px; height: 500px; padding-bottom: 0px;">
         
            <table class="col" style="background-color:rgb(220,225,230);">
               <colgroup>
                  <col width="20%">
                  <col width="30%">
                  <col width="20%">
                  <col width="30%">
               </colgroup>
				<h1 class="center title">휴가 신청서</h1>
				<thead class="middle">
					<tr>
						<th scope="col">근무부서</th>
							<td  scope="col" style="padding:0px; width:200px;">
								<input style="width:200px; height:30px; padding:0px; text-align:center; display:block; margin: 0 auto;" type="text" id="dept_name" name="dept_name" readonly>
							</td>
						<th scope="col">근태종류</th>
						<td scope="col" class="center" style="width:200px; height:30px; padding:0px; text-align:center; display:block; margin: 0 auto;">
							<input style="width:200px; height:30px; padding:0px; text-align:center; display:block; margin: 0 auto;" type="text" id="kind_hol" name="kind_hol" readonly>
					</tr>
					<tr class="left">
						<th scope="col">성명</th>
							<td  scope="col" style="padding:0px; width:200px;">
								<input style="width:200px; height:30px; padding:0px; text-align:center; display:block; margin: 0 auto;" type="text" id="name2" name="name2" readonly>
							</td>
					</tr>
					<tr style="margin-bottom:20px;">
						<th scope="col">사번</th>
							<td  scope="col" style="padding:0px; width:200px;">
								<input style="width:200px; height:30px; padding:0px; text-align:center; display:block; margin: 0 auto;" type="text" id="loginID2" name="loginID2" readonly>
							</td>
					</tr>
					<tr style="margin-bottom:20px;">
						<th scope="col">비상연락처</th>
							<td  scope="col" style="padding:0px; width:200px;">
								<input style="width:200px; height:30px; padding:0px; text-align:center; display:block; margin: 0 auto;" type="text" id="tel" name="tel" readonly>
							</td>
					</tr>
				</thead>
				
            </table>
            
            <table class="col" style="background-color:rgb(220,225,230);">
            <colgroup>
                  <col width="20%">
                  <col width="80%">
               </colgroup>
            	<thead>
            		<tr scope="col">
						<th scope="col">기간</th>
						<td scope="col" >
							<span  style="position: relative;width:100%; height:30px; padding:0px; text-align:center; display:block; margin: 0 auto;">
								<input type="text" id="start_date2" name="start_date2" class="hei" readonly>~<input type="text" id="end_date2" name="end_date2" class="hei" readonly>
							</span>
						</td>
					</tr>
					<tr scope="col" style="height:100px;">
						<th scope="col">휴가사유</th>
						<td style="" class="center">
							<input type="text" style="height:100px; margin:6px 9.5px 6px 9.5px; width:100%" id="reason_hol" name="reason_hol" readonly>
						</td>
					</tr>
					<tr>
						<th scope="col"></th>
						<td class="center">
							<span style="font-size:15px; padding-top:10px">상기와 같은 사유로 휴가를 신청합니다.</span>
						</td>
					</tr>
					<tr>
						<th scope="col"></th>
						<td class="center">
							<span style="padding-top:13px; font-size: 13px;">신청일</span><input type="text" style="height:30px; margin:6px 9.5px 6px 9.5px; width:50%" id="ta_reg_date" name="ta_reg_date" readonly>
						</td>
					</tr>
            	</thead>
            </table>
            
             <table class="col" style="background-color:rgb(220,225,230);">
            <colgroup>
                  <col width="20%">
                  <col width="80%">
               </colgroup>
            	<thead>
            		<tr>
						<th scope="row">승인구분 <span class="font_red">*</span></th>
						<td colspan="3" style="padding-left: 10px; font-size: 13px;">
								<input type="radio" id="radioYes" name="dv_radio" value="2"> <label for="radioYes">승인</label>
								<input type="radio" id="radioNo" name="dv_radio" value="3"> <label for="radioNo">반려</label></td>
					</tr>
					<tr scope="col" style="height:100px;">
						<th scope="col">반려사유</th>
						<td style="" class="center">
							<input type="text" style="height:100px; margin:6px 9.5px 6px 9.5px; width:100%" name = "can_reason" id="can_reason">
						</td>
					</tr>
					
            	</thead>
            </table>
            
         </dd>
      </dl>
      
      <a href="" class="closePop"><span class="hidden">닫기</span></a>
      
            <div class="btn_areaC mt20" style="position:absolute; bottom:20px;">
               <a href="javascript:fUpdate();" class="btnType blue" id="submitBtn"><span id="">확인</span></a>
               <a href="" class="btnType blue" id="closeBtn"><span id="">닫기</span></a>
            </div>
   </div>
  </form>
 
	
</body>
</html>
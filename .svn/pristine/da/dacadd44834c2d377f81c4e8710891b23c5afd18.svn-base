<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>급여조회</title>
<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>
<script type="text/javascript">	
	
	//onLoad event 
	$(document).ready(function(){
		var date = new Date(); 
		var year = date.getFullYear(); 
		var month = new String(date.getMonth()+1); 

		// 한자리수일 경우 0을 채워준다. 
		if(month.length == 1){ 
		  month = "0" + month; 
		} 
		
		var initdate = year + "-" + month;
		
		$("#from_date").val(initdate);
		
		fListEmpPayHist(); //급여내역 조회
		
		$(function () {
		    $('[data-toggle="popover"]').popover()
		    })
		
		$(function () {
		 	  $('[data-toggle="tooltip"]').tooltip()
		  	})
	});
	
	
	
	/* //목록조회
	function fListEmpPayHist( loginID ) {
		
		var param = { loginID : loginID };
		
		var resultCallback = function(data) {
			fListEmpPayHistResult(data);
		};
		
		callAjax("/employee/empPayHistList.do", "post", "text", true, param, resultCallback);
	} */

	

	//급여내역 조회
	function fListEmpPayHist(){
		
		var searchmonth = $("#from_date").val();

		var param = {
				searchmonth : searchmonth
		} //controller로 보낼 파라미터
		
		var resultCallback = function(data){
			fListEmpPayHistResult(data);
		}
			//Ajax실행 방식
			//callAjax("Controller Url",type,return,async or sync방식,넘겨준거,값,Callback함수 이름)
			// json으로 보내서 오류가 났음 , -> text
			callAjax("/employee/empPayHistList.do", "post", "json", true, param, resultCallback);
		};
		
		//급여내역 조회 콜백
		function fListEmpPayHistResult(data){
			console.log(JSON.stringify(data));
			 if(data.result == "FAIL"){
					$('#year_salary').empty();
					$('#salary').empty();
					$('#nat_ps').empty();		
					$('#h_insure').empty();
					$('#e_insure').empty();	
					$('#income_tax').empty();	
					$('#net_pay').empty();	
					$('#ohs_insure').empty();
					$('#extra_pay').empty();
					alert(data.resultMsg);	
			}else{
			$('#year_salary').empty();			
			$('#year_salary').append(data.payHist.year_salary);
			
			$('#salary').empty();			
			$('#salary').append(data.payHist.salary);
			
			$('#nat_ps').empty();			
			$('#nat_ps').append(data.payHist.nat_ps);
			
			$('#h_insure').empty();			
			$('#h_insure').append(data.payHist.h_insure);
			
			$('#e_insure').empty();			
			$('#e_insure').append(data.payHist.e_insure);
			
			$('#income_tax').empty();			
			$('#income_tax').append(data.payHist.income_tax);
			
			$('#net_pay').empty();			
			$('#net_pay').append(data.payHist.net_pay);
			
			$('#ohs_insure').empty();			
			$('#ohs_insure').append(data.payHist.ohs_insure);
			
			$('#extra_pay').empty();			
			$('#extra_pay').append(data.payHist.extra_pay);
			}
		}

</script>
<style>
	th{
		text-align:center;
		color:#868686;
		border:solid 1px rgb(187,194,205);
	}
	.popover{
	width:140px;
	}
</style>
</head>
<body>
<form id="myForm">
	<div id="mask"></div>
	<div id="wrap_area">
	<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
	<div id="container">
		<ul>
			<li class="lnb"><jsp:include page="/WEB-INF/view/common/lnbMenu.jsp"></jsp:include></li>
			<li class="contents">
				<h3 class="hidden">contents 영역</h3>
				<div class="content">
					<p class="Location">
						<a href="" class="btn_set home">메인으로</a> 
						<a href="" class="btn_nav">인사•급여</a> <span class="btn_nav bold">급여내역서</span>
						<a href="" class="btn_set refresh">새로고침</a>
					</p>
				
				<!-- 관리자 공지사항 리스트 조회  -->
				<div class="EmpPayHistList">
					<p class="conTitle" >               
					  <span>급여내역서</span>
								<span class="fr" >
									<Strong>기  준  년  월 </Strong> <input type="month" id="from_date" name="from_date" value="yyyy-mm" max >
									<a class="btnType blue" href="javascript:fListEmpPayHist();" name="search"><span id="searchEnter">조회</span></a>
								</span>
				    </p> 
					<table class="col" style="margin-top:20px;">
					<caption>caption</caption>
						<colgroup>
							<col width="33%">
							<col width="33%">
							<col width="33%">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">사원명</th>
								<th scope="col">직    급</th>
								<th scope="col">근무연차</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${userNm}</td>
								<td>${posnm}</td>
								<td>${workyear}</td>
							</tr>
						</tbody>
					</table>
					<a tabindex="0" class="btn btn-lg btn-danger fr cen" data-placement="left" role="button" data-toggle="popover" data-trigger="focus" title="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;보험료율" data-content=" 국민연금 : 4.5%    건강보험 : 3.43%   고용보험 : 0.8%    산재보험 : 1.56%  &nbsp;&nbsp;소득세 &nbsp;: &nbsp;10%">
						<button type="button" class="btn btn-default fr" style="width:20px; margin-top:5px; margin-bottom:2px;" data-toggle="tooltip" data-placement="left" title="보험료율">?</button>
					</a>
					<table class="col" style="margin-top:20px;">
					<caption>caption</caption>
						<colgroup>
							<col width="33%">
							<col width="33%">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">항목</th>
								<th scope="col">금액(원)</th>
							</tr>
						</thead>
			
							<tr>
								<th>연봉</th>
								<td><div id="year_salary"></div></td>
							</tr>
							<tr>
								<th>기본급</th>
								<td><div id="salary"></div></td>
							</tr>
							<tr>
								<th>국민연금</th>
								<td><div id="nat_ps"></div></td>
							</tr>
							<tr>
								<th>건강보험료</th>
								<td><div id="h_insure"></div></td>
							</tr>
							<tr>
								<th>고용보험료</th>
								<td><div id="e_insure"></div></td>
							</tr>
							<tr>
								<th>산재보험료</th>
								<td><div id="ohs_insure"></div></td>
							</tr>
							<tr>
								<th>소득세</th>
								<td><div id="income_tax"></div></td>
							</tr>
							<tr>
								<th>비고금액</th>
								<td><div id="extra_pay"></div></td>
							</tr>
							<tr>
								<td>실수령액</td>
								<td><div id="net_pay"></div></td>
							</tr>
		
					
					</table>
				</div>
				<div class="paging_area" id="admPagination"></div>
								
				<div class="btn_areaC mt20">
					                      
                     </div>
               
				<h3 class="hidden">풋터 영역</h3> 
				<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
			</li>
		</ul> 
	</div>
	</div>
	

	<div id="layer1" class="layerPop layerType2" style="width: 650px; overflow:auto;">
	</div>
	</form>
	
	<form id="myForm">
     <div id="layer2" class="layerPop layerType2" style="width: 650px;">
      <dl>
         <dt>
            <strong>공지사항 등록하기</strong>
         </dt>
         <dd class="content">
            <table class="row">
               
               <colgroup>
                  <col width="12%">
                  <col width="*">
                  <col width="12%">
                  <col width="*">
               </colgroup>

               <tbody>
                  <tr>
                     <th scope="row">제목</th>
                     <td><input type="text" class="inputTxt p100" name="notice_tit" id="notice_tit" placeholder="제목을 입력하세요."/></td>
                  </tr>
                  <tr>
                     <th scope="row">내용</th>
                     <td><textarea class="inputTxt p100" name="notice_con" id="notice_con" style= "min-height:250px; resize:none;"></textarea></td>
                  </tr>
               </tbody>
            </table>
            
            <div class="btn_areaC mt20">
               <a href="javascript:fWrite();" class="btnType blue" id="submitBtn"><span id="">작성</span></a>
               <a href="" class="btnType blue" id="closeBtn"><span id="">닫기</span></a>
            </div>
         </dd>
      </dl>
      <a href="" class="closePop"><span class="hidden">닫기</span></a>
   </div>
  </form>
</body>
</html>
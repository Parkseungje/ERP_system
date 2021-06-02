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
<style type="text/css">
.right {
	align: right;
}

.left {
	align: left;
}

.center {
	display: flex;
	justify-content: center;
}

.middle {
	vertical-align: middle;
}

.title {
	font-size: 40px;
	padding: 30px;
}

.sa {
	display: flex;
	justify-content: space-around;
}

.hei {
	height: 30px;
	margin: 0px 20px 0px 20px;
	width: 200px;
}
.midcen{
	display: flex; 
	align-items: center;  
	justify-content: center; 
	margin:6px 9.5px; 
	padding:4px 0.5px; 
	background-color: #fff; 
	border: 1px solid rgb(187,194,205);
}
</style>
<script type="text/javascript">

	var pageSizeEmpTaApply = 5; //네비게이션에 표시할 페이지 수
	var pageBlockSizeEmpTaApply = 5; //그리드에 출력할 목록 수
	var today = getTimeStamp() ;
	function fPopModalEmpTaApply() {
		
	}
	function fPopModalEmpTaApplyreturn() {
		gfModalPop('#layer1');
	}

	
	/** 버튼 이벤트 등록 */
	function fRegisterButtonClickEvent() {
		$('a[name=btn]').click(function(e) {
			e.preventDefault();

			var btnId = $(this).attr('id');

			switch (btnId) {
				case 'btnSaveTaApply' :  
					fSaveEmpTaApply();
					break;
				case 'btnClose' :
					gfCloseModal();
					break;
			}
		});
	}
	//현재날짜
	function getTimeStamp() {

	    var d = new Date();
	    var s =
	        leadingZeros(d.getFullYear(), 4) + '-' +
	        leadingZeros(d.getMonth() + 1, 2) + '-' +
	        leadingZeros(d.getDate(), 2);

	    return s;
	}
	function leadingZeros(n, digits) {

	    var zero = '';
	    n = n.toString();

	    if (n.length < digits) {
	        for (i = 0; i < digits - n.length; i++)
	            zero += '0';
	    }
	    return zero + n;
	}
	
	//받아온 리스트데이터 호출
	$(document).ready(function() {

		fListEmpTaApply(); // 총연차수
		console.log("today : " + today);
		$("#to_date").change(function() {
			if ($("#to_date").val() < $("#from_date").val()) {
				swal("최소기간 보다 작을수 없습니다.")
				$("#to_date").val('');
			}
		});
		$("#to_date_modal").change(function() {
			if ($("#to_date_modal").val() < $("#from_date_modal").val()) {
				swal("최소기간 보다 작을수 없습니다.")
				$("#to_date_modal").val('');
			}
		});
		$("#from_date_modal").change(function() {
			if ($("#from_date_modal").val() < today) {
				swal("현재날짜 보다 작을수 없습니다.")
				$("#from_date_modal").val('');
			}
		});
	}); 
	
	//리스트 데이터 받아오기
	function fEmpTaApplyList(currentPage) {
		
		currentPage = currentPage || 1;
	 	var lev_type = $('#lev_type').val();
		var ta_yn = $('#ta_yn').val();
		var from_date = $("#from_date").val();
		var to_date = $("#to_date").val();

		var param = {
			currentPage : currentPage,
			pageSizeEmpTaApply : pageSizeEmpTaApply,
			lev_type : lev_type,
			ta_yn : ta_yn,
			from_date : from_date,
			to_date : to_date
		}
		var resultCallback = function(data) {
			fEmpTaApplyResult(data, currentPage);
		};
		//Ajax실행 방식
		//callAjax("Controller Url",type,return,async or sync방식,넘겨준거,값,Callback함수 이름)
		// json으로 보내서 오류가 났음 , -> text
		callAjax("/employee/empTaApplyCallback.do", "post", "text", true, param,resultCallback);
	}

	//리스트 데이터 콜백
	function fEmpTaApplyResult(data, currentPage) {
		console.log("data 값" + data);
		$('#empTaApplyList').empty();
		$('#empTaApplyList').append(data);
		
		var empTaApplyCnt = $("#totalEmpTaApplyCnt").val();
		console.log("empTaApplyCnt  :  " + empTaApplyCnt);
		
		//var paginationHtml = getPaginationHtml(currentPage, totalCntComnGrpCod, pageSizeComnGrpCod, pageBlockSizeComnGrpCod, 'fListComnGrpCod');
		var paginationHtml = getPaginationHtml(currentPage, empTaApplyCnt, pageSizeEmpTaApply, pageBlockSizeEmpTaApply, 'fEmpTaApplyList');
		console.log("paginationHtml : " + paginationHtml);

		//swal(paginationHtml);
		$("#empTaApplyPagination").empty().append(paginationHtml);

		// 현재 페이지 설정
		$("#currentPageEmpTaApply").val(currentPage);
	}
	

	
	//총연차수 조회
	function fListEmpTaApply(){
		
		var param = {
			};
		
		var resultCallback = function(data){
			fListEmpTaApplyResult(data);
		}
			//Ajax실행 방식
			//callAjax("Controller Url",type,return,async or sync방식,넘겨준거,값,Callback함수 이름)
			// json으로 보내서 오류가 났음 , -> text
			callAjax("/employee/empTaApplyAnList.do", "post", "json", true, param, resultCallback);
		};
		
		//총연차 조회 콜백
		function fListEmpTaApplyResult(data){
			console.log(JSON.stringify(data));
			 if(data.result == "FAIL"){
					$('#total_an').empty();
					$('#salary').empty();
					$('#nat_ps').empty();
					alert(data.resultMsg);	
			}else{
				$('#total_an').empty();			
				$('#use_an').empty();			
				$('#left_an').empty();
				
				$('#total_an').append(data.taApply.total_an);
				$('#use_an').append(data.taApply.use_an);
				$('#left_an').append(data.taApply.left_an);
				//fEmpTaApplyList();
				fEmpTaApplyList(); // 신청내역 리스트
			}
		}
		
		//반려사유
		function fPopModalEmpTaApplyReturn(ta_no) {
			
		       var param = {
		    		   ta_no : ta_no
		           };
		       var resultCallback = function(data) {
		         $('#layer1').empty().append(data);
		         gfModalPop("#layer1");
		       };
		       callAjax("/employee/empTaApplyReturn.do", "post", "text", true, param, resultCallback);
			   }
		
		//근태신청 모달창
		function fPopModalEmpTaApply(data){
			
			var param = {
		           };
			
				var resultCallback = function(data) {
			         //$('#layer2').empty().append(data);
					console.log("resultCallback : " + JSON.stringify(data));
			         if(data.taApplyModal.left_an != 0){
			         gfModalPop("#layer2");
			         if(data.result == "FAIL"){
								$('#loginID').empty();
								$('#name').empty();
								$('#dept_name').empty();
								$('#tel').empty();
								alert("실패 인디유");	
						}else{
							$('#loginID').empty();			
							$('#name').empty();			
							$('#dept_name').empty();			
							$('#tel').empty();			
							
							$('#loginID').text(data.taApplyModal.loginID);
							$('#name').text(data.taApplyModal.name);
							$('#dept_name').text(data.taApplyModal.dept_name);
							$('#tel').text(data.taApplyModal.tel);
			       }
				}else{
					alert("남은 연차가 없습니다.");
			}
			}
			callAjax("/employee/empTaApplyModal.do", "post", "json", true, param, resultCallback);
		}
		
		
		/** 지출결의건 저장 validation */
		function fValidateEmpTaApply() {
				var chk = checkNotEmpty(
						[
								[ "from_date_modal", "날짜를 입력해 주세요." ]
							,	[ "to_date_modal", "날짜를 입력해 주세요." ]
							,	[ "taApply_reason", "휴가사유를 입력해 주세요." ]
						]
				);
				if (!chk) {
					return;
				}
				return true;
		}
		
		/** 근태신청 저장 */
		function fSaveEmpTaApply() {
			// vaildation 체크
			if ( ! fValidateEmpTaApply() ) {
				return;
			}
			
			var param = {
					loginID: $('#loginID').text(),
					kind_hol : $('#lev_type').val(),
					reason_hol : $('#taApply_reason').val(),
					start_date : $('#from_date_modal').val(),
					end_date : $('#to_date_modal').val()
			};
			
			var resultCallback = function(data) {
				fSaveEmpTaApplyResult(data);
			};
			
			callAjax("/employee/saveEmpTaApply.do", "post", "json", true, param,resultCallback);
			console.log("serialize" + $("#myForm").serialize());
		}
		
		/** 근태신청 저장 콜백 함수 */
		function fSaveEmpTaApplyResult(data) {
			
			// 목록 조회 페이지 번호
			
			if (data.result == "SUCCESS") {
				
				// 응답 메시지 출력
				alert(data.resultMsg);
				// 모달 닫기
				gfCloseModal();
			} else {
				// 오류 응답 메시지 출력
				alert(data.resultMsg);
			}
		}

</script>  


</head>
<body>
	<form id="myForm">
	<%-- <input type="hidden" name="loginID" id="loginID" value="${loginID}"> --%>
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
								<a href="" class="btn_set home">메인으로</a> <a href="" class="btn_nav">인사•급여</a> <span class="btn_nav bold">근태신청/조회</span> <a href="" class="btn_set refresh">새로고침</a>
							</p>

							<!-- 근태신청 데이터 리스트 조회  -->
							<div class="divempTaApplyList">
								<p class="conTitle">
									<span>근태신청/조회</span> <span class="fr" style="margin-top:3.5px;"> <span> &nbsp;&nbsp;<Strong>일자 </Strong> <input type="date" id="from_date">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="date" id="to_date"><br>
									<Strong>근태종류</Strong>
									<select id="lev_type" style="width: 120px;">
										<option value="">전체</option>
										<option value="3">연차</option>
										<option value="2">월차</option>
										<option value="1">반차</option>
									</select> 
									&nbsp;<Strong>결재상태</Strong>
									<select id="ta_yn" style="width: 120px;">
											<option value="">전체</option>
											<option value="2">승인</option>
											<option value="3">반려</option>
											<option value="1">승인대기</option> 
									</select>
									&nbsp;<a class="btnType blue" href="javascript:fEmpTaApplyList()" name="search"> 
									 <span id="searchEnter">조회</span>
									 </a>
									</span>
									</span>
								</p>
								<table class="col" style="margin-top: 20px;">
									<caption>caption</caption>
									<thead>
										<tr>
											<th scope="col">총 연차</th>
											<th scope="col">사용 연차</th>
											<th scope="col">남은 연차</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td id = "total_an"></td>
											<td id = "use_an"></td>
											<td id = "left_an"></td>
										</tr>
									</tbody>
								</table>
							</div>

							<!-- <div class="paging_area" id="admPagination"></div> -->

							<div class="fr" style="margin: 3px 0px 3px 0px;">
								<a class="btnType blue" href="javascript:fPopModalEmpTaApply()" name="search"> <span id="searchEnter">개인근태신청</span>
								</a>
							</div>
							<table class="col">
								<colgroup>
									<col width="5%">
									<col width="10%">
									<col width="25%">
									<col width="25%">
									<col width="10%">
									<col width="10%">
									<col width="15%">
								</colgroup>
								<thead>
									<tr>
										<th scope="col">번호</th>
										<th scope="col">휴가종류</th>
										<th scope="col">시작일</th>
										<th scope="col">종료일</th>
										<th scope="col">사용연차</th>
										<th scope="col">결재자</th>
										<th scope="col">결재상태</th>
									</tr>
								</thead>
								<tbody id="empTaApplyList">
								</tbody>
							</table>
						<div class="paging_area" id="empTaApplyPagination"></div>
							</div>
							</ul>
							</div>
							</div>
	
	
	
	
	
	<!-- 반려사유 모달창  -->
		<div id="layer1" class="layerPop layerType2" style="width: 860px; height: 500px;">
		</div>


</form>
<form id="TaApplyModal">
		<!-- 근태신청 모달창 -->
		<div id="layer2" class="layerPop layerType2" style="width: 800px; height: 620px; position:absolute;">
			<dl>
				<dt>
					<strong>근태신청</strong>
				</dt>
				<dd class="content" style="width: 740px; height: 500px; padding:15px 30px 0px 30px;">

					<table class="col" style="background-color: rgb(220, 225, 230);">
						<colgroup>
							<col width="20%">
							<col width="30%">
							<col width="20%">
							<col width="30%">
						</colgroup>
						<h1 class="center title">근태 신청서</h1>
						<thead class="middle">
							<tr>
								<th scope="col">근무부서</th>
								<td scope="col" class="midcen" id= "dept_name">
									<!-- <input style="width: 200px; height: 30px; padding: 0px; text-align: center; display: block; margin: 0 auto;" type="text"> -->
								</td>
								<th scope="col">근태종류</th>
								<td scope="col" class="center" style="width: 200px; height: 30px; padding: 0px; text-align: center; display: block; margin: 0 auto;">
									<select id="lev_type" class="center" style="width: 200px; height: 30px; padding: 0px; text-align: center; display: block; margin: 4px 0px 4px 0px;">
										<option value="3">연차</option>
										<option value="2">월차</option>
										<option value="1">반차</option>
									</select> 
								</td>
							</tr>
							<tr class="left">
								<th scope="col">성명</th>
								<td scope="col" class="midcen" id="name">
								<!-- <input style="width: 200px; height: 30px; padding: 0px; text-align: center; display: block; margin: 0 auto;" type="text"> -->
								</td>
							</tr>
							<tr style="margin-bottom: 20px;">
								<th scope="col">사번</th>
								<td scope="col"  class="midcen"id="loginID">
									<!-- <input style="width: 200px; height: 30px; padding: 0px; text-align: center; display: block; margin: 0 auto;" type="text"> -->
								</td>
							</tr>
						</thead>
					</table>
					<table class="col" style="background-color: rgb(220, 225, 230);">
						<colgroup>
							<col width="20%">
							<col width="80%">
						</colgroup>
						<thead>
							<tr scope="col">
								<th scope="col">기간</th>
								<td scope="col"><span style="position: relative; width: 100%; height: 30px; padding: 0px; text-align: center; display: block; margin: 0 auto;"> 
								<input type="date" id="from_date_modal" class="hei">~<input type="date" id="to_date_modal" class="hei">
								</span></td>
							</tr>
							<tr scope="col" style="height: 200px;">
								<th scope="col">휴가사유</th>
								<td style="" class="center"><input id="taApply_reason"type="text" style="height: 200px; margin: 6px 9.5px 6px 9.5px; width: 100%"></td>
							</tr>
							<tr>
								<th scope="col">비상연락처</th>
								<td  class="midcen" id="tel">
									<!-- <input type="text" style="height: 30px; margin: 6px 9.5px 6px 9.5px; width: 100%"> -->
								</td>
							</tr>
						</thead>
					</table>
				</dd>
			</dl>
			<a href="" class="closePop" id=""><span class="hidden">닫기</span></a>

			<div class="btn_areaC mt20" style="position: absolute; bottom: 20px;">
				<a href="javascript:fSaveEmpTaApply();" class="btnType blue" id="btnSaveTaApply"><span id="">신청</span></a> <a href="" class="btnType blue" id="btnClose"><span id="">닫기</span></a>
			</div>
		</div>
	</form>
</body>
</html>
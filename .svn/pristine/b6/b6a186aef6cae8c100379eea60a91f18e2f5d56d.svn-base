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
<title>Job Korea :: 사원 관리</title>

<!-- 우편주소 찾기 -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- sweet alert import -->
<script src='${CTX_PATH}/js/sweetalert/sweetalert.min.js'></script>
<!-- 공통 js/css src 모은 jsp -->
<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>
<!-- 사원등록/수정 관련 js -->
<script src='${CTX_PATH}/js/empRegister.js'></script>

<script type="text/javascript">

	// 사원 리스트 페이징 설정
	var pageSizeEmpList = 10;
	var pageBlockSizeEmpList = 5;

	/* onload */
	$(document).ready(function(){
		if(${userType != 'A'} || ${userType ne 'A'}){ //-> C로 바꿔야함
			$('#registerBtn').hide();
		}
		showEmpList() //사원 리스트 불러오기
		
		//공통코드 검색조건
		selectComCombo("dept", "searchKey_dept", "all", ""); //부서
		comcombo("POScd", "searchKey_poscd", "all", "0");
		
		$("#to_date").change(function() {
			if ($("#to_date").val() < $("#from_date").val()) {
				swal("최소기간 보다 작을수 없습니다.")
				$("#to_date").val('');
			}
		});
	});

	/* 사원 리스트 조회 */
	function showEmpList(currentPage, retire_yn){
		if (retire_yn == 'y'){
			//재직자/퇴직자 버튼 색깔 변경
			$('#showOutEmp').removeClass('color1');
			$('#showOutEmp').addClass('color2');
			$('#showInEmp').removeClass('color2');
			$('#showInEmp').addClass('color1');
			$('#resign').hide();
			$('#retireDay').show();
		}else {
			//재직자/퇴직자 버튼 색깔 변경
			$('#showInEmp').removeClass('color1');
			$('#showInEmp').addClass('color2');
			$('#showOutEmp').removeClass('color2');
			$('#showOutEmp').addClass('color1');
			$('#retireDay').hide();
			$('#resign').show();
		}
		
		currentPage = currentPage || 1;
		retire_yn = retire_yn || 'n';
		var searchKey_dept = $('#searchKey_dept').val();
		var searchKey_poscd = $('#searchKey_poscd').val();
		var searchKey = $('#searchKey').val();
		var searchWord = $('#searchWord').val();
		var from_date = $("#from_date").val();
		var to_date = $("#to_date").val();

		$('#tmpEmpStatus').val(retire_yn);
		
		var param = {
					  retire_yn : retire_yn
					, searchKey_dept : searchKey_dept
					, searchKey_poscd : searchKey_poscd
					, searchKey : searchKey
					, searchWord : searchWord
					, from_date : from_date
					, to_date : to_date
					, currentPage : currentPage
					, pageSize : pageSizeEmpList
		}
		
		var resultCallback = function(data){
			showEmpListResult(data, currentPage);
		};
		
		callAjax("/employee/showEmpList.do", "post", "text", true, param, resultCallback);
		
	}//showInEmpList
	
	function showEmpListResult(data, currentPage){
		console.log(data);
		
		$('#empList').empty();
		
		$('#empList').append(data);
		
		var empTotalCnt = $('#empTotalCnt').val();
		
		var retire_yn = $('#tmpEmpStatus').val();
		var paginationHtml = getPaginationHtml(currentPage, empTotalCnt, pageSizeEmpList, pageBlockSizeEmpList, 'showEmpList', [retire_yn]);
		console.log("paginationHtml : " + paginationHtml);
		//swal(paginationHtml);
		$("#empPagination").empty().append(paginationHtml);
		
		// 현재 페이지 설정
		$("#currentPageEmpMgt").val(currentPage);
	}

	/* 사원정보 디테일 */
	function viewEmpDtl(loginID){
		var param = {loginID : loginID}
		
		var resultCallback = function(data){
			viewEmpDtlResult(data);
		};
		
		callAjax("/employee/viewEmpDtl.do", "post", "json", true, param, resultCallback);
	}
	
	function viewEmpDtlResult(data){
		if(data.result == "SUCCESS"){
			gfModalPop('#layer1');
			empRegisterInit(data)
		}else {
			swal("실패 : "+data.resultMsg);
		}
	}
	
	/* 퇴직처리 -> 퇴직사유 모달 팝업 */
	function fPopModalResignEmp(resignLoginID, resignName, resign_entry_date){
		$('#resignLoginID').val(resignLoginID);
		$('#resignName').val(resignName);
		$('#resign_entry_date').val(resign_entry_date);
		
		$("#confirm_retire_date").change(function() {
			if ($("#confirm_retire_date").val() < $("#resign_entry_date").val()) {
				swal("입사일 보다 퇴사일이 작을 수 없습니다.")
				$("#confirm_retire_date").val('');
			}
		});
		gfModalPop('#layer2');
	}
	
	/* 퇴직처리 */
	function resignEmp(){
		//alert("dfsf");
		var resignLoginID = $('#resignLoginID').val();
		var confirm_retire_date = $('#confirm_retire_date').val();
		var retire_note = $('#write_retire_note').val();
		
		console.log("resignLoginID : " + resignLoginID);
		
		if(confirm_retire_date == ""){
			swal("퇴사일을 입력해주세요.")
			return;
		}
		var param = {
				  loginID : resignLoginID
				, retire_date : confirm_retire_date
				, retire_note : retire_note
		}
		
		swal("퇴사처리하겠습니까?", {
			buttons : {
				yes : "예",
				no : "취소"
			}
		}).then((value) => {
			switch(value){
			case "yes" :
				var resultCallback = function(data){
					resignEmpResult(data);
				};
				
				callAjax("/employee/resignEmp.do", "post", "json", true, param, resultCallback);
				
				break;
			case "no" :
				break;
			}
		});
	}
	
	function resignEmpResult(data){
		if(data.result == "SUCCESS"){
			swal(data.resultMsg);
			gfCloseModal();
			showEmpList();
		}else {
			swal("퇴사처리에 실패하였습니다.");
		}
	}
	/* 사원 삭제(실수로 등록했을 경우) */
	function deleteEmp(){
		var loginID = $('#loginID').val();
		
		var param = {
				  loginID : loginID
		}
		
		swal("모든 정보를 삭제하시겠습니까?", {
			buttons : {
				yes : "예",
				no : "취소"
			}
		}).then((value) => {
			switch(value){
			case "yes" :
				var resultCallback = function(data){
					deleteEmpResult(data);
				};
				
				callAjax("/employee/deleteEmp.do", "post", "json", true, param, resultCallback);
				
				break;
			case "no" :
				break;
			}
		});
	}
	
	function deleteEmpResult(data){
		if(data.result == "SUCCESS"){
			swal(data.resultMsg);
			gfCloseModal();
			showEmpList();
		}else {
			swal("정보삭제에 실패하였습니다.");
		}
	}
</script>

</head>
<body>
<form id="myForm" action=""  method="">
	<input type="hidden" id="currentPageEmpMgt" value="1">
	<input type="hidden" id="tmpEmpStatus" value="">

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
							<a href="../dashboard/dashboard.do" class="btn_set home">메인으로</a> <span
								class="btn_nav bold">인사•급여</span> <span class="btn_nav bold">인사
								관리</span> <a href="/employee/empMgt.do" class="btn_set refresh">새로고침</a>
						</p>

						<p class="conTitle">
							<span>사원 기본정보</span> 
							<span class="fr"> 
								<a class="btnType blue" href="javascript:fPopModalEmpMgt();" name="modal" id = "registerBtn"><span>사원 등록</span></a>
							</span>
						</p>
						<table style="margin-bottom : 10px; border: 1px #e2e6ed; border-style:solid !important;" height = "50px" width="100%" align="left">
	                        <tr style="border: 0px; border-color: blue">
	                           	<td width="7%" height="25" style="font-size: 120%; text-align : center;">부서</td>
	                           	<td width="9%" height="25" style="font-size: 100%; text-align:left;">
	     	                   		<select id="searchKey_dept" name="searchKey_dept" style="width: 70px;"></select>
								</td>
								<td width="7%" height="25" style="font-size: 120%; text-align:center;">직급</td>
								<td width="10%" height="25" style="font-size: 100%; text-align:left;">
	     	                    	<select id="searchKey_poscd" name="searchKey_poscd" style="width: 70px;"></select>
								</td>
								<td width="9%" height="25" style="font-size: 100%; text-align:left; padding-left: 14px;">
	     	                      <select id="searchKey" name="searchKey" style="width: 70px;">
										<option value="loginID" >사번</option>
										<option value="name" >사원명</option>
								</select>
								</td>
								<td width="20%" height="25">
	     	                       <input type="text" style="width: 180px; height: 25px;" id="searchWord" name="searchWord">                    
	                           	</td>
	                           	<td width = "*" height="25" align="right" style="padding-right : 7px;">
	                           		<a href="javascript:showEmpList()" class="btnType3 color2" id="btnSearchEmpMgt" name="btn"><span>검  색</span></a>
	                           	</td>
	                        </tr>
                     	</table>
						<span class="fl"> 
							<a id="showInEmp" class="btnType3 color2" href="javascript:showEmpList(1, 'n')"><span>재직자</span></a> 
							<a id="showOutEmp" class="btnType3 color1" href="javascript:showEmpList(1, 'y')"><span>퇴직자</span></a>
						</span>
						
                     	<span class="fr">
							<p class="Location">
								<strong style="margin-left : 7%;">입사일 조회&nbsp;</strong>
								<input type="date" id="from_date" style = "width : 33%;">&nbsp~&nbsp<input type="date" id="to_date" style = "width : 33%;">
								<a class="btn_icon search" href="javascript:showEmpList()" name="search"><span id="searchEnter">조회</span></a>
							</p>
						</span>

						<!-- 재직자 리스트 -->
						<div class="divEmpList">
							<table class="col">
								<colgroup>
									<col width="16%">
									<col width="12%">
									<col width="12%">
									<col width="10%">
									<col width="15%">
									<col width="10%">
									<col width="15%">
								</colgroup>
	
								<thead>
									<tr>
										<th scope="col">사번</th>
										<th scope="col">사원명</th>
										<th scope="col">부서명</th>
										<th scope="col">직급</th>
										<th scope="col">입사일자</th>
										<th scope="col">재직 구분</th>
										<th scope="col" id = "resign">퇴직처리</th>
										<th scope="col" id = "retireDay">퇴사일자</th>
									</tr>
								</thead>
								<tbody id="empList"></tbody>
							</table>
						</div>
						<div class="paging_area"  id="empPagination"> </div>
						

					</div> <!--// content -->

					<h3 class="hidden">풋터 영역</h3>
						<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
				</li>
			</ul>
		</div>
	</div>
</form>

	<!-- 모달팝업 -->
	<!-- ***** 사원 등록 모달 ***** -->
	<form id = "empRegister">
	<input type ="hidden" name = "action" id = "action" value = "">
	<div id="layer1" class="layerPosition layerPop layerType2" style="width: 790px;">
		<dl>
			<dt>
				<strong>사원 등록</strong>
			</dt>
			<dd class="content">
				<!-- s : 여기에 내용입력 -->
				<table class="row">
					<caption>caption</caption>
					<colgroup>
						<col width="18%">
						<col width="14%">
						<col width="20%">
						<col width="14%">
						<col width="20%">
					</colgroup>

					<tbody>
						<tr>
							<td rowspan="3" id = "userProfile" class = "userProfile profile">
								<span id = "profilePreview">
								</span>
								<input type = "file" name = "profileUpload" id ="profileUpload" style = "display:none;">
							</td>
							<th scope="row">사번<span class="font_red">*</span></th>
							<td><input type="text" class="inputTxt p100" name="loginID" id="loginID" readonly /></td>
							<th scope="row">사원명<span class="font_red">*</span></th>
							<td><input type="text" class="inputTxt p100" name="name" id="name" /></td>
						</tr>
						<tr>
							<th scope="row">주민등록번호<span class="font_red">*</span></th>
							<td><input type="text" class="inputTxt p100" name="regno" id="regno" 
								placeholder="000000-0000000"/></td>
							<th scope="row">성별<span class="font_red">*</span></th>
							<td><input type="radio" id="sex-1"
								name="sex" value='1' /> <label for="sex-1">남</label>
								&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" id="sex-2"
								name="sex" value="2" /> <label for="sex-2">여</label>
							</td>
						</tr>
						
						<tr>
							<th scope="row">생년월일</th>
							<td><input type="text" class="inputTxt p100" name="birthday" id="birthday"
								placeholder="0000.00.00" /></td>
							<th scope="row">최종학력<span class="font_red">*</span></th>
							<td><select name="school" id="school" style="width: 90%;"></select></td>
						</tr>
						</tbody>
				</table>
				<table class="row" style="margin-top:0.5%;">
					<colgroup>
						<col width="12%">
						<col width="31%">
						<col width="12%">
						<col width="36%">
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">이메일<span class="font_red">*</span></th>
								<td><input class="inputTxt"
										style="width: 40%" type="text" id="mail1"
										name="mail1"> @ <input class="inputTxt" style="width: 45%" type="email" id = "mail2" name="mail2" 
										list="defaultEmails" placeholder="직접입력"> 
								             <datalist id="defaultEmails">
								                <option value="naver.com">
								                <option value="hanmail.net">
								                <option value="gmail.com">
								             </datalist>
								</td>
							<th scope="row">연락처<span class="font_red">*</span></th>
								<td><select name="tel1" id="tel1" style="width: 30%;">
										<option value="" selected="selected">선택</option>
										<option value="010">010</option>
										<option value="011">011</option>
										<option value="02">02</option>
									</select>
									 - <input class="inputTxt"
									style="width: 28%" maxlength="4" type="text" id="tel2"
									name="tel2"> - <input class="inputTxt"
									style="width: 28%" maxlength="4" type="text" id="tel3"
									name="tel3">
								</td>
						</tr>
						<tr>
							<th scope= "row" rowspan = "3">주소<span class="font_red">*</span></th>
								<td>
									<input type="text" class="inputTxt" style="width: 50%;" name="zip_code" id="zip_code" readonly/>
									<input type="button" value="우편번호 찾기" onclick="execDaumPostcode()" id ="post_cd"
										style="width: 35%; height: 100%; cursor: pointer;" />
								</td>
							<th scope= "row">은행계좌<span class="font_red">*</span></th>
								<td>
									<select id="bank" name="bank" style="width: 33%;"></select>
									<input class="inputTxt"
										style="width: 63%" type="text" id="account" name="account">
								</td>
						</tr>
						<tr>
							<td>
								<input type="text" class="inputTxt" style="width: 90%" name="addr" id="addr" readonly />
							</td>
						</tr>
						<tr>
							<td>
								<input type="text" class="inputTxt p100" name="addr_detail" id="addr_detail" />
							</td>
						</tr>
					</tbody>
				</table>
				<table class="row" style="margin-top:0.5%;">
					<colgroup>
						<col width="13%">
						<col width="17%">
						<col width="12%">
						<col width="20%">
						<col width="10%">
						<col width="19%">
					</colgroup>
					<tbody>
						<tr>
							<th scope= "row">부서<span class="font_red">*</span></th>
							<td>
								<select  id="dept_cd" name="dept_cd" style="width: 65%;"></select>
							</td>
							<th scope= "row">직무<span class="font_red">*</span></th>
							<td>
								<select id="user_type" name="user_type" style="width: 83%;"></select>
							</td>
							<th scope= "row">직급<span class="font_red">*</span></th>
							<td>
								<select id="poscd" name="poscd" style="width: 65%;"></select>
							</td>
						</tr>
						<tr>
							<th scope= "row">입사일<span class="font_red">*</span></th>
							<td><input type="date" id="entry_date" name = "entry_date" style = "width : 90%; height : 80%"></td>
							<th scope= "row">재직구분<span class="font_red">*</span></th>
							<td>
								<input type="radio" name="rest_yn" id="rest_yn" value='n' />
									<label for="rest_n" style="margin-right:2%;">재직</label>
								<input type="radio" name="rest_yn" id="rest_yn" value="y" />
									<label for="rest_y" style="margin-right:2%;">휴직</label>
								<input type="radio" name="out_yn" id="out_yn" value='out_y' disabled/>
									<label for="out_n">퇴직</label>
							</td>
							<th scope= "row">퇴사일</th>
							<td><input type="date" id="retire_date" name = "retire_date" style = "width : 90%; height : 80%" readonly></td>
						</tr>
						<tr>
							<th scope= "row">근무연차</th>
							<td><input type="text" class="inputTxt p100" name="workyear" id="workyear" style = "text-align : right;" readonly/></td>
							<th scope= "row">연봉<span class="font_red">*</span></th>
							<td>
								<input type="text" class="inputTxt" style="width: 67%"
									name="year_salary" id="year_salary" />
									<input type="button" value="호봉" onclick="payStep()"
									style="width: 27%; height: 100%; cursor: pointer;" />
							</td>
							<th scope= "row" rowspan = "2">비고</th>
							<td rowspan = "2"><textarea id = "memo" name ="memo" style = "resize:none;"></textarea></td>
						</tr>
						<tr>
							<th scope= "row">퇴직금</th>
							<td><input type="text" class="inputTxt p100" name="oamt" id="oamt" style = "text-align : right;" readonly/></td>
							<th scope= "row">퇴직사유</th>
							<td><input type="text" class="inputTxt p100" name="retire_note" id="retire_note" readonly/></td>
						</tr>
					</tbody>
				</table>
				
				<!-- e : 여기에 내용입력 -->

				<div class="btn_areaC mt30">
					<a href="javascript:empRegister()" class="btnType blue" id="btnEmpRegister" name="btn"><span>저장</span></a> 
					<!-- 혹시 잘못 저장했을 경우를 위한 삭제 --> 
					<a href="javascript:deleteEmp()" class="btnType blue" id="btnDeleteEmp" name="btn"><span>삭제</span></a> 
					<a href="" class="btnType gray" id="btnCloseEmp" name="btn"><span>취소</span></a>
				</div>
			</dd>
		</dl>
		<a href="" class="closePop"><span class="hidden">닫기</span></a>
	</div>
	</form> <!-- ***** 사원 등록 모달 끝 ***** -->

	<!-- ***** 퇴직처리 모달 ***** -->
	<div id="layer2" class="layerPop layerType2" style="width: 540px;">
		<dl>
			<dt>
				<strong>퇴직처리</strong>
			</dt>
			<dd class="content">

				<!-- s : 여기에 내용입력 -->

				<table class="row">
					<caption>caption</caption>
					<colgroup>
						<col width="50%">
						<col width="10%">
						<col width="50%">
						<col width="10%">
					</colgroup>

					<tbody>
						<tr>
							<th scope="row">사번 <span class="font_red">*</span></th>
							<td><input type="text" class="inputTxt" id="resignLoginID" name="resignLoginID" readonly/></td>
							<th scope="row">사원명 <span class="font_red">*</span></th>
							<td><input type="text" class="inputTxt" id="resignName" name="resignName" readonly/></td>
						</tr>
						<tr>
							<th scope="row">입사일<span class="font_red">*</span></th>
							<td><input type="date" id="resign_entry_date" style = "width : 90%; height : 80%" readonly></td>
							<th scope="row">퇴사일<span class="font_red">*</span></th>
							<td><input type="date" id="confirm_retire_date" style = "width : 90%; height : 80%"></td>
						</tr>
						
						<tr>
							<th scope="row" colspan ="4" style = "text-align : left;">퇴사 사유</th>
						</tr>
						<tr>
							<td colspan="4"><textarea id = "write_retire_note" name = "write_retire_note" style = "resize:none;"></textarea></td>
						</tr>
					</tbody>
				</table>

				<!-- e : 여기에 내용입력 -->

				<div class="btn_areaC mt30">
					<a href="javascript:resignEmp()" class="btnType blue" id="btnEmpOut"><span>퇴사처리</span></a>
					<a href="" class="btnType gray" id="btnCloseEmpOut"><span>취소</span></a>
				</div>
			</dd>
		</dl>
		<a href="" class="closePop"><span class="hidden">닫기</span></a>
	</div>
	<!-- ***** 퇴직처리 모달 끝 ***** -->
</body>
</html>
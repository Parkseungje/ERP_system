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
<title>Job Korea :: 사용자 관리</title>
<!-- sweet alert import -->
<script src='${CTX_PATH}/js/sweetalert/sweetalert.min.js'></script>
<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>

<script type="text/javascript">

	// 사용자관리 페이징 설정
	var pageSize = 5;
	var pageBlock = 5;

	/** OnLoad event */ 
	$(function() {
	
		// 사용자 목록 뿌리기
		fUserMgmtList();
		
		// 버튼 이벤트 등록
		fButtonClickEvent();
	});
	

	/* 버튼 이벤트 등록 - 저장, 수정, 삭제  */
	function fButtonClickEvent(){
		$('a[name=btn]').click(function(e){
			e.preventDefault(); // ?? 
					
			var btnId = $(this).attr('id');
			
			switch(btnId){
			case 'btnSaveUserMgmt' : fSaveUserMgmt(); // save 안에 저장,수정
				//alert("저장버튼 클릭!!!이벤트!!");
				break;
			case 'btnDeleteUserMgmt' : fDeleteUserMgmt();	// 만들자 
				//alert("삭제버튼 클릭!!!이벤트!!");		
				break;
			case 'btnClose' : gfCloseModal();  // 모달닫기 
									fUserMgmtList(); // 첫페이지 다시 로딩 
				break;
			case 'btnUpdateUserMgmt' : fUpdateUserMgmt();  // 수정하기
				break;
			case 'btnSearchUser' : fUserMgmtList();  // 검색해서 리스트 뿌리기
				break;
				
			}
		});
	}
	
	/* 사용자 목록 불러오기 + 사용자 검색  */
	function fUserMgmtList(currentPage){
		
		currentPage = currentPage || 1;   // or		
		
		//var sname = $("#sname");
	   // var searchKey = document.getElementById("searchKey");
	    var sname = $("#sname").val();
	    var oname = $("#searchKey").val();
	    
	    console.log("sname : " + sname);
	    console.log("oname : " + oname);
	    
		//var oname = searchKey.options[searchKey.selectedIndex].value;
		
		var param = {
				sname : sname , 
				oname : oname ,
				currentPage : currentPage ,
				pageSize : pageSize , 
		}

		
		var resultCallback = function(data){  // 데이터를 이 함수로 넘깁시다. 
			userMgmtListResult(data, currentPage); 
		}
		
		callAjax("/system/userMgmtList.do","post","text", true, param, resultCallback);
		
	}
	
	
	 /* 사용자 목록 data를 콜백함수를 통해 뿌려봅시당   */
	 function userMgmtListResult(data, currentPage){
		 
		 console.log(data);
		 
		 // 일단 기존 목록을 삭제합니다. (변경시 재부팅 용)
		 $('#listUser').empty();
		 
		 $('#listUser').append(data);
	
		 
		 // 리스트의 총 개수를 추출합니다. 
		 //var totalCnt = $data.find("#totalCnt").text();
		 var totalCnt = $("#totcnt").val();  // qnaRealList() 에서보낸값 
		 
		 // * 페이지 네비게이션 생성 (만들어져있는 함수를 사용한다 -common.js)
	     var list = $("#tmpList").val();
		 //var listnum = $("#tmpListNum").val();
	     var pagingnavi = getPaginationHtml(currentPage, totalCnt, pageSize, pageBlock, 'fUserMgmtList',[list]);
		 
	     console.log("pagingnavi : " + pagingnavi);
		 // 비운다음에 다시 append 
	     $("#pagingnavi").empty().append(pagingnavi); // 위에꺼를 첨부합니다. 
		 
		 // 현재 페이지 설정 
	    $("#currentPage").val(currentPage);
		 
	 }
	


	/* 회원가입 폼 불러오는 화면 */
	function fuserMgmtdetailModal(loginId){
		
		var param = {loginId : loginId};
		var resultCallback2 = function(data){
			fuserMgmtdetailResult(data);
		};
		
		callAjax("/system/userMgmtdetail.do", "post", "json", true, param, resultCallback2);
	}
	
	/* 회원가입 폼 불러오기 -> 콜백함수 */
	function fuserMgmtdetailResult(data){
		
		console.log(JSON.stringify(data));
		if(data.resultMsg == "SUCCESS"){
			
			//모달 팝업
			gfModalPop("#layer1");
			
				//모달에 정보 넣기
//				if(data.result.user_type == "B"){
					fEngineerModal(data.result);
					
//				} else if(data.result.user_type == "C"){
//					fCompanyModel(data.result);
//				} else {
//					alert('관리자입니다.');
//				}
				
		 }else{
			 alert(data.resultMsg);
			// jsp include 하는 방법은? 
		}
	}
	
	//일반회원일 경우
	 function fEngineerModal(object){
		 
		 $("#registerId").val(object.loginId);
		 $("#registerId").attr("readonly", true); // loginID 수정불가 
		 
//		 $("#registertype").val(object.user_type);

		 $("#registerName").val(object.name).show();
		 $("#rggender_td").val(object.gender_cd);

		 $("#birthday").val(object.birthday);
		 $("#registerEmail").val(object.user_email);
		 
		 $("#detailaddr").val(object.user_zipcode);
		 $("#loginaddr").val(object.user_address);
		 $("#loginaddr1").val(object.user_dt_address);
		 
		 $("#tel1").val(object.tel1);
		 $("#tel2").val(object.tel2);
		 $("#tel3").val(object.tel3);
		 
		 $("#btnDeleteUser").hide(); // 삭제버튼 보이기 
		 $("#btnSaveUser").hide();
		 $("#btnUpdateUser").css("display","");
	 }
	
	//기업회원일 경우
//	function fCompanyModel(object){
		
//		 $("#user_company").val(object.user_company);
//		 $("#email_cop").val(object.email_cop);
//	}
	 
</script>

</head>
							

<body>
<form id="myForm" action=""  method="">
	<input type="hidden" id="currentPage" value="1">  <!-- 현재페이지는 처음에 항상 1로 설정하여 넘김  -->
	<input type="hidden" id="tmpList" value="">
	<input type="hidden" id="tmpListNum" value="">
	<input type="hidden" name="action" id="action" value="">
	
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
							class="btn_nav bold">시스템관리</span> <span class="btn_nav bold">사용자
							관리</span> <a href="../system/userMgmt.do" class="btn_set refresh">새로고침</a>
					</p>
						
					<p class="conTitle">
						<span> 사용자 관리 </span> 
					</p>
						
					<table style="margin-top: 10px" width="100%" cellpadding="5" cellspacing="0" border="1"
                        align="left"
                        style="collapse; border: 1px #50bcdf;">
                        <tr style="border: 0px; border-color: blue">
                           <td width="20" height="25" style="font-size: 120%;">&nbsp;&nbsp;</td>
                           <td width="50" height="25" style="font-size: 100%; text-align:left; padding-right:25px;">
     	                      이 름 &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width: 250px; height: 25px;" id="sname" name="sname">  &nbsp;&nbsp;&nbsp;&nbsp;                
     	                      <select id="searchKey" name="searchKey" style="width: 150px;" v-model="searchKey">
     	                            <option value="">전체</option>
									<option value="B">일반회원</option>
									<option value="C" >기업회원</option>
							</select> 
                           </td> 
							<td width="100" height="70" style="font-size: 120%">
	                           <a href="" class="btnType blue" id="btnSearchUser" name="btn"><span>검  색</span></a>
                           </td>
                        </tr>
                     </table> 
					
						<div class="divUserList">
							<table class="col">
								<caption>caption</caption>
								<colgroup>
									<col width="15%">
									<col width="30%">
									<col width="20%">
									<col width="25%">
								</colgroup>
	
								<thead>
									<tr>
										<th scope="col">구분</th>
										<th scope="col">이름</th>
										<th scope="col">아이디</th>
										<th scope="col">가입일자</th>
									</tr>
								</thead>
 								<tbody id="listUser">
 									<tr>
										<td colspan="12">회원명으로 검색해 주세요.</td>
									</tr>
								</tbody>
							</table>
						</div>
	
						<div class="paging_area"  id="pagingnavi"> </div>
						
						
						

       					
					</div> <!--// content -->

					<h3 class="hidden">풋터 영역</h3>
						<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
				</li>
			</ul>
		</div>
	</div>


	<!-- 모달팝업 -->
		<!-- 회원가입 폼 화면 insert 예정 -->
	<div id="layer1" class="layerPosition layerPop layerType2" style="width: 600px;">
	      <!-- <input type="hidden" id="loginId" name="loginId" > 수정시 필요한 num 값을 넘김  -->
		<dl>
			<dt>
					<strong style="font-size:150%; font-family: Arial">&nbsp;&nbsp;회원정보</strong>
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
						<col width="120px">					
					</colgroup>
						<tbody>
							<tr class="hidden">
								<td><input type="text" name="div_cd" id="div_cd" /></td>
								<td><input type="text" name="del_cd" id="del_cd" /></td>
								<td><input type="text" name="approval_cd" id="approval_cd" /></td>
							</tr>

							<tr>
								<th scope="row">아이디</th>
								<td><input type="text" class="inputTxt p100"  name="loginId"  id="registerId" readonly/></td>
							</tr>
							
							<tr>
								<th scope="row" id="registerName_th">이름</th>
								<td><input type="text" class="inputTxt p100" name="name" id="registerName" readonly/></td>
							
								<th scope="row" id="rggender_th">성별</th>
								<td><input type="text" class="inputTxt p100" name="gender_cd"  id="rggender_td" readonly/></td>
							</tr>
						
							<tr>
								<th scope="row" id="rgcompany_th">회사명</th>
								<td id="rgcompany_td">
								<input type="text" class="inputTxt p100" name="user_company"  id="user_company" readonly/></td>
							</tr>
							
							<tr id="birthday1">
								<th scope="row">생년월일</th>
								<td><input type="text" class="inputTxt p100" name="birthday"  id="birthday" style="font-size: 15px" readonly/>
							</tr>
							
							<tr>
								<th scope="row">이메일</th>
									<td colspan="3"><input type="text" class="inputTxt p100" name="user_email" id="registerEmail" readonly/> 
							</tr>

							<tr id="email_cop2">
								<th scope="row">기업도메인</th>
								<td colspan="3"><input type="text" class="inputTxt p100" name="email_cop" id="email_cop" readonly/></td>
							</tr>
							<tr>
								<th scope="row">우편번호</th>
								<td colspan="3"><input type="text" class="inputTxt p100" name="user_zipcode" id="detailaddr" readonly/></td>
							</tr>
							<tr>
								<th scope="row">주소</th>
								<td colspan="3"><input type="text" class="inputTxt p100" name="user_address" id="loginaddr" readonly/></td>
							</tr>
							<tr>
								<th scope="row">상세주소</th>
								<td colspan="3"><input type="text" class="inputTxt p100" name="user_dt_address" id="loginaddr1" readonly/></td>
							</tr>
							<tr>
								<th scope="row">전화번호</th>
								<td colspan="3">
									<input class="inputTxt" style="width: 118px" maxlength="3" type="text" id="tel1" name="user_tel1" readonly/> - 
									<input class="inputTxt" style="width: 118px" maxlength="4" type="text" id="tel2" name="user_tel2" readonly/> - 
									<input class="inputTxt" style="width: 118px" maxlength="4" type="text" id="tel3" name="user_tel3" readonly/>
								</td>
							</tr>
							</tbody>
						</table>
						<!-- 	
							<tr id="user_type_li">
								<th scope="row">선호직무분야</th>
								<td colspan="3"><input type="text" class="inputTxt p100"
									name="user_address" id="loginaddr" value="${userinfo.user_address}"/></td>
								<td>	<select name="user_type" id="user_type" style="width: 400px; height: 28px;">
										<option value="" selected="selected">선택</option>
										<option value="A">경영·사무</option>
										<option value="B">마케팅·광고·홍보</option>
										<option value="C">IT·인터넷</option>
										<option value="D">디자인</option>
										<option value="E">무역·유통</option>
										<option value="F">영업·고객상담</option>
										<option value="G">연구개발·설계</option>
										<option value="H">생산·제조</option>
										<option value="I">미디어</option>
										<option value="J">전문·특수직</option>
								</select></td>
							</tr>
							
							<tr id="career_yn1">
								<th scope="row">경력기간</th>
								<td>
								<select v-model="selected" id="career_yn">
								  <option disabled value="">선택</option>
								  <option value="">1년미만</option>
								  <option value="">1</option>
								  <option value="">2</option>
								  <option value="">3</option>
								  <option value="">4</option>
								  <option value="">5</option>
								  <option value="">6</option>
								  <option value="">7</option>
								  <option value="">8</option>
								  <option value="">9</option>
								  <option value="">10</option>
								  <option value="">11</option>
								  <option value="">12</option>
								  <option value="">13</option>
								  <option value="">14</option>
								  <option value="">15</option>
								  <option value="">16</option>
								  <option value="">17</option>
								  <option value="">18</option>
								  <option value="">19</option>
								  <option value="">20이상</option>
								</select>
								<span>년</span>
							</td>
							</tr>
							<tr class="row" id="career_mm1">
								<th scope="row"></th>
								<td>
								<select v-model="selected" id="career_mm">
								  <option disabled value="">선택</option>
								  <option>1</option>
								  <option>2</option>
								  <option>3</option>
								  <option>4</option>
								  <option>5</option>
								  <option>6</option>
								  <option>7</option>
								  <option>8</option>
								  <option>9</option>
								  <option>10</option>
								  <option>11</option>
								  <option>12</option>
								</select>
								<span>월</span>
							</td>
							
							<tr class="row">
							<th scope="row" scope="row">희망연봉<span class="font_red">*</span></th>
								<td><input type="text" class="inputTxt p100"
									name="salary" id="salary" />만원</td>
							
								<th scope="row">협의가능여부</th>
								<td id="consult_yn"><select name="consult_yn1"
									id="consult_yn" style="width: 128px; height: 28px;">
										<option value="" selected="selected">선택</option>
										<option value="yes">가능</option>
										<option value="no">불가능</option>
								</select></td>
							</tr>
			
				</table>
				

				
				<div class="btn_areaC mt30">
					<a href="javascript:CompleteRegister();" class="btnType blue"
						id="RegisterCom" name="btn"> <span>회원가입 완료</span></a> <a 
						href="javascript:fcancleModal()" class="btnType gray" id="btnCloseLsmCod" name="btn"><span>취소</span></a>
				</div>
				 -->
				 
			</dd>
		</dl>
		<a href="" class="closePop"><span class="hidden">닫기</span></a>

	</div>

</body>
</html>
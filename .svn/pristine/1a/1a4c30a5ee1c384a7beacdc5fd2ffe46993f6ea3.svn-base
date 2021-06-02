<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Chain Maker :: Login</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>

<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>

<link rel="stylesheet" type="text/css"
	href="${CTX_PATH}/css/admin/login.css" />

<!-- 우편번호 조회 -->

<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${CTX_PATH}/js/popFindZipCode.js"></script>
	<!-- sweet alert import -->
<script src='${CTX_PATH}/js/sweetalert/sweetalert.min.js'></script>

<script type="text/javascript" src="${CTX_PATH}/js/login_pub.js"></script>
<script type="text/javascript">

var check;

/* OnLoad Event */
$(document).ready(function() {
	$("#confirm").hide();
	$("#loginRegister").hide();
	$("#loginEmail").hide();
	$("#loginPwd").hide();

	var cookie_user_id = getCookie('EMP_ID');
	if (cookie_user_id != "") {
		$("#EMP_ID").val(cookie_user_id);
		$("#cb_saveId").attr("checked", true);
	}

	$("#EMP_ID").focus();
	
	init();
	
});


function fcancleModal(){
	gfCloseModal();
	}

/* 회원가입 모달창 실행 */
function fRegister() {
	var div_cd;
	$("#action").val("I");
	// 모달 팝업
	gfModalPop("#layer1");
	instaffRegister();
}


 function init() {
	check = new Vue({
		el: '#layer1',
		data : {
			langitems: [],
			langitems1: [],
			langitems2: [],
			langitems3: [],	
			langitemss: [],
			langitemarea1: [],
			langitemarea2: [],
			langitemarea3: [],
			listlistCod: '',
			weblistCod:'',
			dblistCod:'',
			wslistCod:'',
			sklcdlistCod:'',
			areacdlistCod:'',
			skillgrpcd:'',
			skilldtlcd:''
			
		}
	})
 }

 /*체크리스트 콜백함수*/
 function checklistResult(data){ 	
	
	/*callAjax시 로그인 여부 확인 하므로 ajax 함수 직접 작성*/
 	$.ajax({
		url : '/checklist.do',
		type : 'post',
		data : data,
		dataType : 'json',
		async : true,
		success : function(data) {
			check.check = [];
			check.langitems = data.listlistCod;
			check.langitems1 = data.weblistCod;
			check.langitems2 = data.dblistCod;
			check.langitems3 = data.wslistCod;
			check.langitemss = data.sklcdlistCod;
			check.langitemarea1 = data.areacdlistCod;
			check.langitemarea2 = data.areacdlistCod;
			check.langitemarea3 = data.areacdlistCod;
			}
		});
		}

$("input[v-model=chkbox]:checked").each(function(){
	var chk = $(this).val();
})

var chk_arr = [];
$("input[v-model=chkbox]:checked").each(function(){
	var chk = $(this).val();
	chk_arr.push(chk);
})

/*일반 회원가입 폼 초기화*/
function instaffRegister(){
	
	$("#user_type").val("C");
	$("#div_cd").val("CommonMember");
	$("#user_type_li").hide();
	$("#registerId").val("");
	$("#registerPwd").val("");
	$("#registerPwdOk").val("");
	$("#rggender_th").show();
	$("#rggender_td").show();
	$("#rgcompany_th").hide();
	$("#rgcompany_td").hide();
	$("#registerName").show();
	$("#registerName_th").show();
 	$("#gender").val("");
	$("#user_company_li").hide("");
	$("#user_company").val("");
	$("#registerEmail").val("");
	$("#detailaddr").val("");
	$("#loginaddr").val("");
	$("#loginaddr1").val("");
	$("#tel1").val("");
	$("#tel2").val("");
	$("#tel3").val("");
	$("#del_cd").val("n");
	$("#approval_cd").val("n");
	$("#ckIdcheckreg").val("0");
	$("#birthday1").show();
	$("#email_cop2").hide();
	$("#consult_yn").show();
	$("#user_describe").show();
	$("#user_contents1").show();		
	$("#salary").val("");
	$("#user_hope_work").val("");
	$("#user_describe").val("");
	$("#grade").val("");
 	$("#area1").val("");
	$("#area2").val("");
	$("#area3").val(""); 
	$("#user_contents").val("");
	$("#singular_facts").val("");
	$("#item.dtl_cod").val("");

	console.log($("#div_cd").val());
	
	//체크리스트출력
	checklistResult(); 
		
}

/*기업 고객 회원가입 폼 초기화*/
function outstaffRegister(){

	$("#user_type").val("B");
	$("#div_cd").val("BusinessMember");
	$("#user_type_li").hide();
	$("#registerId").val("");
	$("#registerPwd").val("");
	$("#registerPwdOk").val("");
	$("#rggender_th").hide();
	$("#rggender_td").hide();
	$("#rgcompany_th").show();
	$("#rgcompany_td").show();
	$("#registerName").hide();
	$("#registerName_th").hide();
	$("#user_company").val("");
	$("#gender_li").hide();
	$("#registerEmail").val("");
	$("#detailaddr").val("");
	$("#gender").val("");
	$("#loginaddr").val("");
	$("#loginaddr1").val("");
	$("#tel1").val("");
	$("#tel2").val("");
	$("#tel3").val("");
	$("#del_cd").val("n");
	$("#approval_cd").val("n");
	$("#ckIdcheckreg").val("0");
	$("#birthday1").hide();
	$("#email_cop2").show();
	$("#salary").hide();
	$("#consult_yn").hide();
	$("#describe1").hide();
	$("#user_contents1").hide();
	$("#career_yn").hide();
	$("#salary").hide();
	$("#checktable").hide();	
	$("#salary").hide();
	$("#career_yn").hide();
	$("#career_mm").hide();
	
	checklistResult(hide); 

	/* console.log($("#user_type").val());
	console.log($("#div_cd").val()); */
}



/* 아이디/비밀번호 찾기 모달창 실행 */
function findIdPwd() {

	// 모달 팝업
	gfModalPop("#layer2");
	
}


/* 회원가입 validation */
function RegisterVal(){
	  
	var div_cd = $('#div_cd').val();
	var user_type = $('#user_type').val();
	var rgid = $('#registerId').val();
	var rgpwd = $('#registerPwd').val();
	var rgpwdok = $('#registerPwdOk').val();
	var rgname = $('#registerName').val();
	var user_company =$('#user_company').val();
	var rgemail = $('#registerEmail').val();
	var dtadr = $('#detailaddr').val();
	var lgadr = $('#loginaddr').val();
	var lgadr1 = $('#loginaddr1').val();
	var tel1 = $('#tel1').val();
	var tel2 = $('#tel2').val();
	var tel3 = $('#tel3').val();
/* 	var bank_cd = $('#bank_nm').val();
	var bank_account = $('#bank_account').val(); */

	if(user_type == ""){
		swal("타입을 입력해주세요.").then(function() {
			$("#user_type").focus();
		  });
		return false;
	}

	
	if(rgid.length < 1){
		swal("아이디를 입력하세요.").then(function() {
			$('#registerId').focus();
		  });
		return false;
	}
	
	if(rgpwd.length < 1){
		swal("비밀번호를 입력하세요.").then(function() {
			$('#registerPwd').focus();
		  });
		return false;
	}
	
	if(rgpwdok.length < 1){
		swal("비밀번호 확인을 입력하세요.").then(function() {
			$('#registerPwdOk').focus();
		  });
		return false;
	}
	
	if(rgpwd != rgpwdok){
		swal("비밀번호가 맞지 않습니다.").then(function() {
			$('#registerPwd').focus();
		  });
		return false;
	}
	
	if(rgname.length < 1){
		swal("이름을 입력하세요.").then(function() {
			$('#registerName').focus();
		  });
		return false;
	}
	
	
	if(div_cd == 'outstaff' && user_company.length < 1){
		swal("회사명을 입력하세요.").then(function() {
			$('#user_company').focus();
		  });
		return false;
	}
	
	if(rgemail.length < 1){
		swal("이메일을 입력하세요.").then(function() {
			$('#registerEmail').focus();
		  });
		return false;
	}
	
	if(dtadr.length < 1){
		swal("우편번호를 입력하세요.").then(function() {
			$('#detailaddr').focus();
		  });
		return false;
	}
	
	if(lgadr.length < 1){
		swal("주소를 입력하세요.").then(function() {
			$('#loginaddr').focus();
		  });
		return false;
	}
	
/* 	if(lgadr1.length < 1){
		alert("상세주소를 입력하세요.");
		$('#loginaddr1').focus();
		return false;
	} */
	
	if(tel1.length < 1){
		swal("전화번호를 입력하세요.").then(function() {
			$('#tel1').focus();
		  });
		return false;
	}
	
	if(tel2.length < 1){
		swal("전화번호를 입력하세요.").then(function() {
			$('#tel2').focus();
		  });
		return false;
	}
	
	if(tel3.length < 1){
		swal("전화번호를 입력하세요.").then(function() {
			$('#tel3').focus();
		  });
		return false;
	}
	
/* 	if(div_cd == 'outstaff' && bank_cd == "" ){
		swal("은행을 선택하세요.").then(function() {
			$('#bank_nm').focus();
		  });
		return false;
	}
	
	if(div_cd == 'outstaff' && bank_account.length <1 ){
		swal("계좌번호를 입력하세요.").then(function() {
			$('#bank_account').focus();
		  });
		return false;
	} */
	
	
	
	return true;
	
}
/*loginID 중복체크*/
function loginIdCheck(){
	
	var data = {"loginID" : $("#registerId").val()};
	
	var idRules =  /^[a-z0-9]{6,20}$/g ;
	var id = $("#registerId").val();

	/*callAjax시 로그인 여부 확인 하므로 ajax 함수 직접 작성*/
	$.ajax({
		url : '/check_loginID.do',
		type : 'post',
		data : data,
		dataType : 'text',
		async : true,
		success : function(data) {
			if($("#registerId").val()==""){
				console.log("입력 아이디 없음");
				swal("아이디를 입력해주세요.").then(function(){
					$("#registerId").focus();
				});
				$("#ckIdcheckreg").val("0");
			}
			 else if (data==1){
				console.log("아이디 있음");
				swal("중복된 아이디가 존재합니다.").then(function(){
					$("#registerId").focus();
				});
				console.log(data);
				$("#ckIdcheckreg").val("0");
			} else if(!idRules.test($("#registerId").val())){
				swal('아이디는 숫자,영문자 조합으로 6~20자리를 사용해야 합니다.').then(function(){
					$("#registerId").focus();
				});
				$("#ckIdcheckreg").val("0");
				return false;
			} else if(data == 0){
				console.log("아이디 없음");
				swal("사용할 수 있는 아이디 입니다.");
				$("#ckIdcheckreg").val("1");
			}
		}
	});
}

/*회원가입 버튼 아이디 중복 체크*/
function loginIdCheckComplete(){
	
	var data = {"loginID" : $("#registerId").val()}
	
	var idRules =  /^[a-z0-9]{6,20}$/g ;
	var id = $("#registerId").val();

	/*callAjax시 로그인 여부 확인 하므로 ajax 함수 직접 작성*/
	$.ajax({
		url : '/check_loginID.do',
		type : 'post',
		data : data,
		dataType : 'text',
		async : false,
		success : function(data) {
			if (data == 1){
				$("#ckIdcheckreg").val("0");
				console.log("아이디 있음");
				return false;
			} else if(!idRules.test($("#registerId").val())){
				$("#ckIdcheckreg").val("0");
				return false;
			}
		}
	});
}


/*-------  이메일 입력방식 선택  ------*/




/*이메일 중복 체크*/
function emailCheck(){
	var data = {"user_email" : $("#registerEmail").val()};

	$.ajax({
		url : '/check_email.do',
		type : 'post',
		data : data,
		dataType : 'text',
		async : false,
		success : function(data) {
			if(data == 1){
				$("#ckEmailcheckreg").val("0");
				console.log("이메일 있음");
				console.log(data);
				return false;
			} else {
				$("#ckEmailcheckreg").val("1");
				console.log(data);
				console.log("이메일 없음");
			}
			
		}
	});
}

/* 회원가입  완료*/
function CompleteRegister() {
	
	var param = $("#RegisterForm").serialize();
	/*패스워드 정규식*/
	var passwordRules = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
 	var password = $("#registerPwd").val();
 	/*이메일 정규식*/
	var emailRules = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	var email = $("#registerEmail").val();
	
	/*전화번호 정규식*/
	var tel1Rules = /^\d{2,3}$/;
	var tel2Rules = /^\d{3,4}$/;
	var tel3Rules = /^\d{4}$/;
	
	var tel1 = $("#tel1").val();
	var tel2 = $("#tel2").val();
	var tel3 = $("#tel3").val();
	//console.log(div_cd);
	/* validation 체크 */
	if(!RegisterVal()){
		return;
	}
		
	loginIdCheckComplete();
	emailCheck();
			 
	if (RegisterForm.ckIdcheckreg.value == "0"){
		swal("아이디 중복확인을 진행해주세요.").then(function() {
			$("#registerId").focus();
		  });
	} else if(!passwordRules.test($("#registerPwd").val())){
		swal('비밀 번호는 숫자,영문자,특수문자 조합으로 8~15자리를 사용해야 합니다.').then(function() {
			$("#registerPwd").focus();
		  });
		return false;
	} else if(!emailRules.test($("#registerEmail").val())){
		swal("이메일 형식을 확인해주세요.").then(function() {
			$("#registerEmail").focus();
		  });
	} else if(RegisterForm.ckEmailcheckreg.value =="0"){
		swal("중복된 이메일이 존재합니다. 다시 입력해주세요.").then(function() {
			$("#registerEmail").focus();
		  });
	} else if(!tel1Rules.test($("#tel1").val())){
		swal("전화번호를 확인해주세요.").then(function() {
			$("#tel1").focus();
		  });
	} else if(!tel2Rules.test($("#tel2").val())){
		swal("전화번호를 확인해주세요.").then(function() {
			$("#tel2").focus();
		  });
	} else if(!tel3Rules.test($("#tel3").val())){
		swal("전화번호를 확인해주세요.").then(function() {
			$("#tel3").focus();
		  });
	}
	else{
	
		var resultCallback = function(data) {
		fSaveRegister(data);
		}
	
	callAjax("/register.do", "post", "json", true, param, resultCallback);
	}

}

/* 회원 가입 저장 콜백함수 */
function fSaveRegister(data) {

	if (data.result == "SUCCESS") {
		alert(data.resultMsg);
		//gfCloseModal();
	} else {
		alert(data.resultMsg);
		return false;
	}
}


// 우편번호 api
function execDaumPostcode(q) {
	new daum.Postcode({
		oncomplete : function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}

			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			if (data.userSelectedType === 'R') {
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraAddr += (extraAddr !== '' ? ', '
							+ data.buildingName : data.buildingName);
				}
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('detailaddr').value = data.zonecode;
			document.getElementById("loginaddr").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("loginaddr1").focus();
		}
	}).open({
		q : q
	});
}


/* 로그인 validation */
function fValidateLogin() {

	var chk = checkNotEmpty([ [ "EMP_ID", "아이디를 입력해 주세요." ],
			[ "EMP_PWD", "비밀번호를 입력해 주세요." ] ]);

	if (!chk) {
		return;
	}

	return true;
}

/* 로그인 */
function fLoginProc() {
	if ($("#cb_saveId").is(":checked")) { // 저장 체크시
		saveCookie('EMP_ID', $("#EMP_ID").val(), 7);
	} else { // 체크 해제시는 공백
		saveCookie('EMP_ID', "", 7);
	}

	// vaildation 체크
	if (!fValidateLogin()) {
		return;
	}

	var resultCallback = function(data) {
		fLoginProcResult(data);
	};

	callAjax("/loginProc.do", "post", "json", true, $("#myForm")
			.serialize(), resultCallback);
}

/* 로그인 결과 */
function fLoginProcResult(data) {

	var lhost = data.serverName;

	if (data.result == "SUCCESS") {
		location.href = "${CTX_PATH}/dashboard/dashboard.do";
	} else {

		$("<div style='text-align:center;'>" + data.resultMsg + "</div>")
				.dialog({
					modal : true,
					resizable : false,
					buttons : [ {
						text : "확인",
						click : function() {
							$(this).dialog("close");
							$("#EMP_ID").val("");
							$("#EMP_PWD").val("");
							$("#EMP_ID").focus();
						}
					} ]
				});
		$(".ui-dialog-titlebar").hide();
	}
}


/*이메일 기능  (아이디 있는지 없는지 체크)*/
function SendEmail() {
	var data = {
		"user_email" : $("#emailText").val(),
		/*"data-code" : $("#emailText").attr("data-code")*/
	};

	$.ajax({
		url : "/selectFindInfoId.do",
		type : "post",
		dataType : "json",
		async : false,
		data : data,
		success : function(flag) {
				if ($("#emailText").val() == "") {
					swal("이메일을 입력해주세요.");
			}	else if (flag.result == "FALSE") {
					swal("존재하지 않는 이메일 입니다.");
				}
				else if (flag.result == "SUCCESS") {
					swal("해당 이메일로 인증번호를 전송하였습니다.");
					
					$("#authNumId").val(flag);
					$("#confirm").show();
					findMailSendId();
			} 
		}
	});
}

/*ID 찾기 이메일 전송*/
function findMailSendId(){
	var data = {
			"email" : $("#emailText").val(),
			"authNumId" : $("#authNumId").val()
		};
	$.ajax({
		url : "/sendmail.do",
		type : "post",
		dataType : "json",
		async : true,
		data : data,
		success : function(flag) {
				$("#authNumId").val(flag.authNumId);
		},
		error : function(request,status,error){
			swal("실패");
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
	
}

/* 이메일 인증 */
function SendComplete() {
 	var inputNum = $("#emailNum").val();
	var emailNum = $("#authNumId").val(); 
	console.log(emailNum);
	
	if (inputNum.length < 1) {
		swal("인증번호를 입력해주세요.");
		return false;
		
	} else if (emailNum != inputNum) {
		swal("인증번호가 틀렸습니다.");
		return false;
		}
	
	 else if (emailNum == inputNum) {
		swal("인증 되었습니다.");
		
		// 아이디 메일 전송 함수호출
		findId();
	}
}

/* 아이디 뜨게 하는 */
var findId = function() {
	var data = {
		"user_email" : $("#emailText").val()
	};
	$.ajax({
		url : '/selectFindInfoId.do',
		type : 'post',
		data : data,
		dataType : 'json',
		async : false,
		success : function(flag) {
			// 모달 or span 
			console.log(flag);
			swal("귀하의 아이디는  " + flag.resultModel.loginID + " 입니다");
			$("#emailText").val('');
			$("#confirm").hide();
			$("#emailText").val('');
			$("#authNumId").val('');
			$("#emailNum").val('');
			$("#authNumId").val('');
		gfCloseModal();
		}
	});
}

/* 비밀번호 찾기에서 아이디 체크하는 창(가입된 아이디가 알람창으로) */
function RegisterIdCheck(){
	var loginid = $("#emailIdText").val();

	
	var data = {
			"loginID" :loginid
	};
	console.log(data);
	
	$.ajax({
		url : "/registerIdCheck.do",
		type : "post",
		dataType : "json",
		async : false,
		data : data,
		success : function(data){
			if(loginid.length < 1){
				swal("아이디를 입력해주세요.");
				$("#loginEmail").hide();
			}
		
			else if (data.result == "SUCCESS"){
				
				swal("아이디가 존재합니다.");
				$("#loginEmail").show();
			}else{
				//console.log("data : " + JSON.stringify(data));
				swal("아이디가 존재하지 않습니다.");
				$("#loginEmail").hide();
			}
			
		}
		
	});
}

/* 이메일 기능 (비밀번호 기능)*/
function SendPwdEmail() {
	
	var data = {
		user_email : $("#emailPwdText").val(),
		loginID : $("#emailIdText").val(),
/* 		"data-code" : $("#emailPwdText").attr("data-code") */

	};
	
	console.log(data);
	
	
	
	$.ajax({
		url : "/selectFindInfoPw.do",
		type : "post",
		dataType : "json",
		async : false,
		data : data,
		success : function(flag) {
			
			
			if ($("#emailPwdText").val() == "") {
				swal("이메일을 입력해주세요.");
			} else if (flag.result == "FALSE") {
				swal("이메일이 틀렸습니다.");
				console.log("flag : " + JSON.stringify(flag));
			} else if (flag.result == "SUCCESS") {
				console.log("flag : " + JSON.stringify(flag));
				swal("해당 이메일로 인증번호를 전송하였습니다.");
				$("#authNumPwd").val(flag);
				$("#loginPwd").show();
				findMailSendPwd();
			}

		}
	});
}

/*비밀번호 찾기 이메일 전송*/
function findMailSendPwd(){
	var data = {
			"emailPwd" : $("#emailIdText").val(),
			"email" : $("#emailPwdText").val(),
			"authNumIdPwd" : $("#authNumPwd").val()
		};
	$.ajax({
		url : "/sendmail.do",
		type : "post",
		dataType : "json",
		async : true,
		data : data,
		success : function(flag) {
				$("#authNumPwd").val(flag.authNumId);
		},
		error : function(request,status,error){
			swal("실패");
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
	
}

/* function pwdCheck(){
	var email = $("#emailPwdText");
	
	if(email.length < 1){
		alert("이메일을 입력해주세요.");
	}
}
 */
 
/* 이메일 비밀번호 인증 */
function SendCompletePwd() {
	var inputPwd = $("#emailPwdNum").val();
	var emailPwdNum = $("#authNumPwd").val();
	if (inputPwd.length < 1) {
		swal("인증번호를 입력해주세요.");
		return false;
	} else if (emailPwdNum != inputPwd) {
		swal("인증번호가 틀렸습니다.");
		return false;
	} else if (emailPwdNum == inputPwd) {
		swal("인증번호가 맞습니다.");
		$("#authNumPwd").val('');

		// 비밀번호 호출하는 함수
		findPwd();
	}
}


/* 비밀번호 뜨게 하는 창 */
var findPwd = function() {
	var data = {
		"loginID" : $("#emailIdText").val(),
		"user_email" : $("#emailPwdText").val()
	};
	$.ajax({
		url : '/selectFindInfoPw.do',
		type : 'post',
		data : data,
		dataType : 'json',
		async : false,
		success : function(flag) {
			swal("귀하의 비밀번호는  " + flag.resultModel.password + " 입니다");
			$("#loginEmail").hide();
			$("#loginPwd ").hide();
			$("#emailIdText").val('');
			$("#emailPwdText").val('');
			$("#emailPwdNum").val('');
			gfCloseModal();
		}
	});
}

/* 아이디 찾기 버튼 클릭 이벤트 */
function fSelectId() {

	gfModalPop("#layer2");
	$("#registerEmailId").show();
	$("#loginRegister").hide();
	$("#loginEmail").hide();
	$("#loginPwd").hide();
	$("#emailText").val('');
}

/* 비밀번호 찾기 버튼 클릭 이벤트 */
function fSelectPwd() {

	$("#registerEmailId").hide();
	$("#confirm").hide();
	$("#loginRegister").show();
	$("#loginEmail").hide();
	$("#loginPwd").hide();
	$("#emailIdText").val('');
	gfModalPop("#layer2");
}

/* 아이디 찾기 메일 인증하기 버튼 클릭 이벤트 */
function fSelectIdOk() {
	$("#emailOk").on("click", function() {
		swal("인증이 완료 되었습니다.")
	});
}

/** ID 조회 */
function fSelectData() {
	var resultCallback = function(data) {
		fSelectDataResult(data);
	};
	callAjax("/selectFindInfoId.do", "post", "json", true, $("#modalForm")
			.serialize(), resultCallback);
}

/** PW 조회 */
function fSelectDataPw() {
	var resultCallback = function(data) {
		fSelectDataResultPw(data);
	};

	callAjax("/selectFindInfoPw.do", "post", "json", true, $("#modalForm2")
			.serialize(), resultCallback);
}

/** pw 저장 */
function fSaveData() {

	var resultCallback = function(data) {
		fSaveDataResult(data);
	};

	callAjax("/updateFindPw.do", "post", "json", true, $("#modalForm2")
			.serialize(), resultCallback);
}

/** 데이터 저장 콜백 함수 */
function fSaveDataResult(data) {
	if (data.result == "SUCCESS") {
		// 응답 메시지 출력
		swal(data.resultMsg);
		location.href = "/login.do";
	} else {
		// 오류 응답 메시지 출력
		alert(data.resultMsg);
	}
}

	
</script>
</head>
<body>
	<form id="myForm" action="" method="post">
	<div id="background_board" >
		<div class="login_form shadow" align="center">
		<div class="login-form-right-side">
                <div class="top-logo-wrap">
                <img src="${CTX_PATH}/images/admin/login/logo_img.png">
                </div>
                <h3>안되는 것이 실패가 아니라 포기하는 것이 실패다</h3>
                <p>
						성공은 실패의 꼬리를 물고 온다.
						지금 포기한 것이 있는가?<br>그렇다면 다시 시작해 보자.<br>
						안되는 것이 실패가 아니라 포기하는 것이 실패다.<br>
						포기한 순간이 성공하기 5분전이기 쉽다.<br> 실패에서 더 많이 배운다.<br>
						실패를 반복해서 경험하면 실망하기 쉽다. <br>하지만 포기를 생각해선 안된다.
						실패는 언제나 중간역이지 종착역은 아니다. <br>
               </p>
               <p>- 이대희, ‘1%의 가능성을 희망으로 바꾼 사람들’ 에서</p>
            </div>
		<div class= "login-form-left-side">
			<fieldset>
				<legend>로그인</legend>
				<p class="id">
					<label for="user_id">아이디</label> <input type="text" id="EMP_ID"
						name="lgn_Id" placeholder="아이디"
						onkeypress="if(event.keyCode==13) {fLoginProc(); return false;}"
						style="ime-mode: inactive;" />
				</p>
				<p class="pw">
					<label for="user_pwd">비밀번호</label> <input type="password"
						id="EMP_PWD" name="pwd" placeholder="비밀번호"
						onfocus="this.placeholder=''; return true"
						onkeypress="if(event.keyCode==13) {fLoginProc(); return false;}" />
				</p>
				<p class="member_info" style="font-size: 15px">
					<input type="checkbox" id="cb_saveId" name=""
						onkeypress="if(event.keyCode==13) {fLoginProc(); return false;}">
					<span class="id_save">ID저장</span> <br>
				</p>
				<a class="btn_login" href="javascript:fLoginProc();" id="btn_login"><strong>Login</strong></a>
				<br>
				<a href="javascript:fRegister();" id="RegisterBtn"
					name="modal"><strong>[회원가입]</strong></a> 
					<a href="javascript:findIdPwd();"><strong>[아이디/비밀번호 찾기]</strong></a>
			</fieldset>
			</div>
			
		</div>
	</div>
</form>
<!-- 모달팝업 -->


	<div id="layer1" class="layerPosition layerPop layerType2" style="width: 600px;">
      <form id="RegisterForm" action="" method="post">
	      <input type="hidden" name="action" id="action" value="">
	      <input type="hidden" name="ckIdcheckreg" id="ckIdcheckreg" value="0"/>
	      <input type="hidden" name="ckEmailcheckreg" id="ckEmailcheckreg" value="0"/>	
		<dl>
			<dt>
					<br>
					<br>
					<strong style="font-size:120%">&nbsp;&nbsp;&nbsp;&nbsp;회원가입</strong>
					<br>
			</dt>
			<dd class="content">
				<div class="btn_areaC">
					<a href="javascript:instaffRegister();" class="btnType blue" id="register_instaff"><span>일반회원</span></a>
					<a href="javascript:outstaffRegister();" class="btnType " id="register_outstaff"><span>기업회원</span></a>
					<br>
					<br>
				</div>
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
						 		<td><input type="text" name="user_type" id="user_type" /></td> 
								<td><input type="text" name="approval_cd" id="approval_cd" /></td>
							</tr>

							<tr>
								<th scope="row">아이디<span class="font_red">*</span></th>
								<td colspan="2"><input type="text" class="inputTxt p100"
									name="loginID" placeholder="숫자, 영문자 조합으로 6~20자리 "
									id="registerId" /></td>
								<td><input type="button" value="중복확인"
									onclick="loginIdCheck()" style="width: 130px; height: 20px;" /></td>
							</tr>
							<tr>
								<th scope="row">비밀번호 <span class="font_red">*</span></th>
								<td colspan="3"><input type="password"
									placeholder="숫자, 영문자, 특수문자 조합으로 8~15자리 " class="inputTxt p100"
									name="password" id="registerPwd" /></td>
							</tr>

							<tr>
								<th scope="row" style="padding: 0 0">비밀번호 확인<span
									class="font_red">*</span></th>
								<td colspan="3"><input type="password"
									class="inputTxt p100" name="password1" id="registerPwdOk" /></td>
							</tr>
							
							<tr>
								<th scope="row" id="registerName_th">이름 <span class="font_red">*</span></th>
								<td><input type="text" class="inputTxt p100" name="name"
									id="registerName" /></td>
							
								<th scope="row" id="rggender_th">성별</th>
								<td id="rggender_td">
								<select name="gender_cd" id="gender_cd" style="width: 128px; height: 28px;">
										<option value="" selected="selected">선택</option>
										<option value="male">남자</option>
										<option value="female">여자</option>
								</select></td>
							</tr>
							
							<tr>
								<th scope="row" id="rgcompany_th">회사명<span class="font_red">*</span></th>
								<td id="rgcompany_td"><input type="text"
									class="inputTxt p100" name="user_company" id="user_company" /></td>
							</tr>


							<tr id="birthday1">
								<th scope="row">생년월일 <span class="font_red"></span></th>
								<td><input type="date" class="inputTxt p100"
									name="birthday" id="birthday" style="font-size: 15px" />
							</tr>
							<tr>
								<th scope="row">이메일<span class="font_red">*</span></th>
									<td colspan="3"><input type="text" class="inputTxt p100"
									name="user_email" id="registerEmail" /> 
									
								<td colspan="3">	
									
								</td>
									
							</tr>



							<tr id="email_cop2">
								<th scope="row">기업도메인<span class="font_red">*</span></th>
								<td colspan="3"><input type="text" class="inputTxt p100"
									name="email_cop" id="email_cop" /></td>
							</tr>
							<tr>
								<th scope="row">우편번호<span class="font_red">*</span></th>
								<td colspan="2"><input type="text" class="inputTxt p100"
									name="user_zipcode" id="detailaddr" /></td>

								<td><input type="button" value="우편번호 찾기"
									onclick="execDaumPostcode()"
									style="width: 130px; height: 20px;" /></td>
							</tr>
							<tr>
								<th scope="row">주소<span class="font_red">*</span></th>
								<td colspan="3"><input type="text" class="inputTxt p100"
									name="user_address" id="loginaddr" /></td>
							</tr>
							<tr>
								<th scope="row">상세주소</th>
								<td colspan="3"><input type="text" class="inputTxt p100"
									name="user_dt_address" id="loginaddr1" /></td>
							</tr>
							<tr>

								<th scope="row">전화번호<span class="font_red">*</span></th>
								<td colspan="3"><input class="inputTxt"
									style="width: 118px" maxlength="3" type="text" id="tel1"
									name="user_tel1"> - <input class="inputTxt"
									style="width: 118px" maxlength="4" type="text" id="tel2"
									name="user_tel2"> - <input class="inputTxt"
									style="width: 118px" maxlength="4" type="text" id="tel3"
									name="user_tel3"></td>
							</tr>
<!-- 							<tr id="user_type_li">
								<th scope="row"><span class="font_red">*</span></th>
								<td colspan="3"><select name="user_type" id="user_type"
									style="width: 400px; height: 28px;">
								</select></td>
							</tr> -->
							
							<tr>
								<th scope="row">선호직무분야<span class="font_red">*</span></th>
								<td colspan="3"><select name="user_hope_work" id="user_hope_work"
									style="width: 400px; height: 28px;">
										<option value="" selected="selected">선택</option>
										<option>웹프로그래머</option>
										<option>응용프로그래머</option>
										<option>시스템프로그래머</option>
										<option>DBA·데이터베이스</option>
										<option>네트워크·서버·보안</option>
										<option>HTML·퍼블리싱·UI개발</option>
										<option>ERP·시스템분석</option>
										<option>빅데이터·AI(인공지능)</option>
										<option>소프트웨어·하드웨어</option>
								</select></td>
							</tr>
							
							<tr>
								<th scope="row">경력기간<span class="font_red">*</span></th>
								<td>
								<select id="career_yn" name="career_yn" >
								  <option value="">선택</option>
								  <option>1년미만</option>
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
								  <option>13</option>
								  <option>14</option>
								  <option>15</option>
								  <option>16</option>
								  <option>17</option>
								  <option>18</option>
								  <option>19</option>
								  <option>20이상</option>
								</select>
								<span>년</span>
							</td>
							</tr>
							<tr class="row" id="career_mm">
								<th scope="row"></th>
								<td>
								<select name="career_mm" id="career_mm">
								  <option value="">선택</option>
								  <option value="1">1</option>
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
								<td id="consult_yn"><select name="consult_yn"
									id="consult_yn" style="width: 128px; height: 28px;">
										<option value="" selected="selected">선택</option>
										<option value="yes">가능</option>
										<option value="no">불가능</option>
								</select></td>
							</tr>
			
				</table>
				
				<!-- 경력정보 ---------------------------------------------------------------------->
				<div>
					<br>
					<br>
					<strong style="font-size:120%">&nbsp;&nbsp;&nbsp;&nbsp;경력정보</strong>
					<br>
					<br>
				</div>
				
					<!-- 추가기술 -->
					<table class="row" id="describe1">
					<tr>
						<th scope="row">제목<span class="font_red">*</span></th>
							<td colspan=3>
								<input type="text" class="inputTxt p100" name="user_describe" id="user_describe" />
							</td>
					</tr>
					
					<!-- 체크리스트 -->

 						<tr>
								<th scope="row">Language<span class="font_red">*</span></th>
									<td colspan="2">
									    <table>
									      <template v-for="(row, index) in langitems" v-if="langitems.length" v-model="chkbox"> 
									      <tr>
									        <td><input type="checkbox" :id="row.dtl_cod" :name="row.dtl_cod" style="width: 15px; height: 15px;" ></td>								
										    <td>{{ row.dtl_cod }}</td>
										  </tr>  
										  </template>
									    </table>
                                   </td>
                                  
								<th scope="row">web<span class="font_red">*</span></th>
									<td colspan="2">
									    <table>
									      <template v-for="(row, index) in langitems1" v-if="langitems1.length" v-model="chkbox"> 
									      <tr>
									          <td><input type="checkbox"  :id="row.dtl_cod" :name="row.dtl_cod"  style="width: 15px; height: 15px;" ></td>								
										      <td>{{ row.dtl_cod }}</td>
										  </tr>    
										  </template>
									    </table>
								    </td>	    
						</tr>
						<tr>
								<th scope="row">DB<span class="font_red">*</span></th>
								<td colspan="2">
								      <table>
								       <template v-for="(row, index) in langitems2" v-if="langitems2.length" v-model="chkbox"> 
								         <tr>
								             <td><input type="checkbox" :id="row.dtl_cod" :name="row.dtl_cod" style="width: 15px; height: 15px;" ></td>								
									         <td>{{ row.dtl_cod_nm }}</td>
									     </tr>
									    </template> 
								     </table>
                                </td>
								<th scope="row">WS<span class="font_red">*</span></th>
								<td colspan="2">
								    <table>
								      <template v-for="(row, index) in langitems3" v-if="langitems3.length" v-model="chkbox"> 
								       <tr>
								          <td><input type="checkbox" :id="row.dtl_cod" :name="row.dtl_cod" style="width: 15px; height: 15px;" ></td>								
									      <td>{{ row.dtl_cod }}</td>
									   </tr>   
									   </template>
								    </table>
						        </td>
						        
						       
						</tr>
					</table> 
				
					<table class="row">
					<!-- 등급 -->
				
						<tr>
							<th scope="row">등급<span class="font_red">*</span></th>			
								<td>			
									<select type="selectbox" id="grade" name="grade">
									<template v-for="(item,index) in langitemss"  v-model="langitemss">
										<option :value="item.dtl_cod">{{ item.dtl_cod_nm }}</option>
									</template>
									</select>
								</td>
						</tr>
						
												
				
					<!-- 희망 근무지 -->				
						<tr>
							<th scope="row">희망근무지역<span class="font_red">*</span></th>								
								<td>
									<span>1순위</span>					
									<select type="selectbox" style="width:100px; height:25px;" id="area1" name="area1">
									<template v-for="(item,index) in langitemarea1"  v-model="langitemarea1">
										<option :value="item.dtl_cod">{{ item.dtl_cod_nm }}</option>
									</template>
									</select>
								
									<span>2순위</span>			
									<select type="selectbox" style="width:100px; height:25px;" id="area2" name="area2">
									<template v-for="(item,index) in langitemarea2"  v-model="langitemarea2">
										<option :value="item.dtl_cod">{{ item.dtl_cod_nm }}</option>
									</template>
									</select>
								
									<span>3순위</span>		
									<select type="selectbox" style="width:100px; height:25px;" id="area3" name="area3">
									<template v-for="(item,index) in langitemarea3"  v-model="langitemarea3">
										<option :value="item.dtl_cod">{{ item.dtl_cod_nm }}</option>
									</template>
									</select>
								</td>
						</tr>					
					</table>
					
					<table class="row">
						<tr>
							<th scope="row">경력내용<span class="font_red">*</span></th>
								<td>
									<textarea class="inputTxt p100" name="user_contents" id="user_contents" laceholder="경력사항을 입력하세요." /></textarea>
								</td>
						</tr>					
					</table>
					
					<table class="row">
						<tr>
							<th scope="row">특이사항<span class="font_red">*</span></th>
								<td>
									<textarea class="inputTxt p100" name="singular_facts" id="singular_facts" laceholder="특이사항을 입력하세요." /></textarea>
								</td>
						</tr>					
					</table>
					
					<table class="row">
						<tr>
							<th scope="row" >파일<span class="font_red">*</span></th>
								<td colspan="5">
									<!--multiple="multiple" -->
									<input type="file" name="file_nm" id="wfile_nm"  ></input>
									<!-- <img v-if="file_nm !='' "src="/images/treeview/minus.gif" @click="minusClickEvent"> -->
									
								</td>
						</tr>	
					</table>
				
				
				

							
					
				<div class="btn_areaC mt30">
					<a href="javascript:CompleteRegister();" class="btnType blue"
						id="RegisterCom" name="btn"> <span>회원가입 완료</span></a> <a 
						href="javascript:fcancleModal()" class="btnType gray" id="btnCloseLsmCod" name="btn"><span>취소</span></a>
				</div>
			</dd>
		</dl>
		<a href="" class="closePop"><span class="hidden">닫기</span></a>
	</form>	
	</div>


<!-- 아이디 비밀번호 찾기 모달 -->
<form id="sendForm" action="" method="post">
	<input type="hidden" name="authNumId" id="authNumId" value="" /> 
	<input type="hidden" name="authNumPwd" id="authNumPwd" value="" />
	<input type="hidden" name="ckIdcheck" id="ckIdcheck" value=""/>
	<div id="layer2" class="layerPop layerType2" style="width: 750px;">
		<dl>
			<dt>
				<strong>아이디/비밀번호 찾기</strong>
			</dt>
			<dd>
				<div class="btn_areaC mt30">
					<a href="javascript:fSelectId();" class="btnType gray" id="findId"><span>아이디
							찾기</span></a> <a href="javascript:fSelectPwd();" class="btnType gray"
						id="findPwd"><span>비밀번호 찾기</span></a>
				</div>
			</dd>
			<dd class="content">

				<!-- 아이디/비밀번호 찾기 폼 -->
				<table class="row" id="findForm">
					<tbody>
						<tr>
							<td id="registerEmailId"><input type="text" id="emailText"
								data-code="I" placeholder="가입하신 이메일을 입력하세요" size="30"
								style="height: 30px;" /> <a href="javascript:SendEmail();"
								class="btnType blue" id="findIdSubmit"><span>이메일 전송</span></a></td>

							<td id="confirm"><input type="text" id="emailNum" name="authnum"
								placeholder="전송된 인증번호를 입력하세요" size="30" style="height: 30px;" />
								<a href="javascript:SendComplete();" class="btnType blue"
								id="sendMail"><span>인증하기</span></a></td>
						</tr>
					</tbody>
				</table>

				<table class="row" id="findPwdForm">
					<tbody>
						<tr>
							<td id="loginRegister"><input type="text" id="emailIdText"
								placeholder="가입하신 아이디를 입력하세요" size="30" style="height: 30px;" />
								<a href="javascript:RegisterIdCheck();" class="btnType blue" id=""><span>아이디 체크</span></a></td>

							<td id="loginEmail"><input type="text" id="emailPwdText"
								data-code="P" placeholder="가입하신 이메일을 입력하세요" size="30"
								style="height: 30px;" /> <a href="javascript:SendPwdEmail();"
								class="btnType blue" id=""><span>이메일 전송</span></a></td>

							<td id="loginPwd"><input type="text" id="emailPwdNum"
								data-code="P" placeholder="전송된 비밀번호를 입력하세요" size="30"
								style="height: 30px;" /> <a
								href="javascript:SendCompletePwd();" class="btnType blue"
								id="emailOk"><span>인증하기</span></a></td>
						</tr>
					</tbody>
				</table>
			</dd>
		</dl>
		<a href="" class="closePop"><span class="hidden">닫기</span></a>
	</div>
</form>
</body>
</html>
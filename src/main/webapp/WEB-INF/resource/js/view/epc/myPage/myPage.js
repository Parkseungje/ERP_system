
$(function() {
	fdetailModal();
	fRegisterButtonClickEvent();
	

});


/** 버튼 이벤트 등록 */
function fRegisterButtonClickEvent() {
	$('a[name=btn]').click(function(e) {
		e.preventDefault();

		var btnId = $(this).attr('id');

		switch (btnId) {
		
			
		case 'btnDeleteUser' : 
			fDelUser();	// 삭제 
			//swal("삭제버튼");		
		break;
		
		case 'btnUpdateUser' : 
			fSaveUser();  // 수정하기
			//swal("수정 잘타나요");
		break;
		
		}
	});
}

/*회원정보 상세 조회*/
function fdetailModal() {
	//swal(" 상세 조회  ");

	var param = {
			/*loginID : loginID*/
	};
	
	console.log(param);
	var resultCallback2 = function(data) {
		fdetailResult(data);
	};

	callAjax("/epc/detailUser.do", "post", "json", true, param,
			resultCallback2);
	//swal(" 상세 조회  22");

}

function fdetailResult(data) {

		//swal("회원정보 상세조회  33");
		//모달 띄우기 
		

		//swal(data.result);
		// 모달에 정보 넣기 
		frealPopModal(data.result);

		//swal(data.resultMsg);
}

function frealPopModal(object) {

	
	 
		var div_cd = object.div_cd.toString();
		var del_cd = object.del_cd.toString();
		
			$('#checkstaff option[value=outstaff]').prop('selected', 'selected').change();
			$("#instaff").show();
			$("#outstaff").show();
			//$('#checkstaff').attr('disabled', 'true');
			$('#checkstaff option[value=instaff]').prop('disabled', true);
		
		

		$("#rloginID").val(object.loginID);
		$("#rloginID").attr("readonly", true); // loginID 수정불가 
		
		$("#password").val(object.password);
		$("#repassword").val(object.password);

		$("#name").val(object.name);
		$("#name2").val(object.name);
		$("#email").val(object.user_email);

		$("#tel1").val(object.user_tel1);
		$("#tel2").val(object.user_tel2);
		$("#tel3").val(object.user_tel3);
		
		
		$("#company").val(object.user_company);
		$("#chaCD").val(object.chaCD_name);
		
		$("#zipcode").val(object.user_zipcode);
		$("#address").val(object.user_address);
		$("#dt_address").val(object.user_dt_address);

	
		
		$("#btnUpdateUser").css("display", "");
		//if문써서 로그인 아이디 == 작성자 아이디 일치시  --- 추가하기 
		//$("#grp_cod").attr("readonly", false);  // false, true(읽기만)로 수정

	
}


function fValidatePopup() {
	/*var c1 = 
		//swal("밸리데이트 타나");
	if (){
		
	}*/
	/*패스워드 정규식*/
	var passwordRules = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
 	var password = $("#password").val();
 	var repassword = $("#repassword").val();
	/*이메일 정규식*/
	var emailRules = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	var email = $("#email").val();
	//swal(password);
	//swal(repassword);
		var chk = checkNotEmpty(
		[ [ "rloginID", "아이디를 입력해주세요!" ]
         ,[ "password", "비밀번호를 입력해주세요!" ]
		 ,[ "tel1", "연락처 기입해주세요!" ]
		 ,[ "tel2", "연락처 기입해주세요!" ]
		 ,[ "tel3", "연락처 기입해주세요!" ]
		 ,[ "email", "이메일을 입력해주세요!" ]
		 ,[ "zipcode", "우편번호를 입력해주세요!" ]
		 ,[ "address", "주소를 입력해주세요!" ]
		 ,[ "dt_address", "상세주소 기입해주세요!" ]
		 ,[ "name", "이름을 기입해주세요!" ]
		 ,[ "company", "회사명 기입해주세요!" ]]
		);
	
	
	if (!chk) {
		return;
	} else if(password!=repassword){
		swal('비밀 번호가 서로 일치하지 않습니다.');
		return;
	} else if(!passwordRules.test($("#password").val())){
		swal('비밀 번호는 숫자,영문자,특수문자 조합으로 8~15자리를 사용해야 합니다.');
		return;
	} else if(!emailRules.test($("#email").val())){
		swal("이메일 형식을 확인해주세요.");
		return;
	} 
	
	
	return true;
}

/* 회원 등록(저장) */
function fSaveUser() {
	
	/*if (!(fVailpass())) {
		return;
	}*/
	
	if (!fValidatePopup()) {
		return;
	}

	var resultCallback3 = function(data) {
		//swal(data);
		//console.log(data);
		fSaveUserResult(data);

	};

	$("#action").val("U"); 
	//swal("action까지 왔나");

	callAjax("/epc/userSave.do", "post", "json", true, $("#myUser")
			.serialize(), resultCallback3);

}

function fDelUser() {

	var con =  
		
		swal("정말 삭제하겠습니까? \n삭제시 복구불가합니다.", {
			  buttons:{
				  yes : "예",
				  no : "아니오"
			  }
			}).then((value) => {  /* 이건 이클립스가 게을러서 뜨는 에러!  */
				switch(value){
				case "yes":
					var resultCallback3 = function(data) {
					fSaveUserResult(data);
					}
					$("#action").val("D"); // delete
					callAjax("/epc/userSave.do", "post", "json", true, $("#myUser").serialize(), resultCallback3);
					location.href = "/login.do";
					
				
					break;
				case "no": 
					break;
				}
			});
		
		//confirm("정말 삭제하겠습니까? \n삭제시 복구불가합니다.");
/*	if (con) {
		var resultCallback3 = function(data) {
			fSaveUserResult(data);
		}
		$("#action").val("D"); // delete
		callAjax("/epc/userSave.do", "post", "json", true, $("#myUser").serialize(), resultCallback3);
		location.href = "/login.do";
	}*/
	


}

/* 저장 ,수정, 삭제 콜백 함수 처리  */
function fSaveUserResult(data) {
	


	if (data.resultMsg == "UPDATE") {
		//swal(data.resultMsg);	// 받은 메세지 출력 
		swal("수정 되었습니다.");
	
	} else if (data.resultMsg == "DELETE") {
		swal("삭제 되었습니다.");
	} else {
		//swal(data.resultMsg); //실패시 이거 탄다. 
		swal("실패 했습니다.");
	}

	/*frealPopModal();// 입력폼 초기화*/
	
}

//우편번호 api
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
			document.getElementById('zipcode').value = data.zonecode;
			document.getElementById("address").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("dt_address").focus();
		}
	}).open({
		q : q
	});
}

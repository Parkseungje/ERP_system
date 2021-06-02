/* 사원 등록 / 수정 Validation JS */
//사원 등록 모달 팝업
function fPopModalEmpMgt(){
	// 공통코드 comcombo 사용방법 -> Group Code, Combo Name, Option("all" : 전체 / "sel" : 선택 , Select Value ) 사원등록 모달창
	comcombo("EDUcd", "school", "sel", "0"); //최종학력
	comcombo("BKcd", "bank", "sel", "0"); //은행계좌
	selectComCombo("dept", "dept_cd", "sel", ""); //부서
	comcombo("USERcd", "user_type", "sel", "0"); //직무==userType 
	comcombo("POScd", "poscd", "sel", "0"); //직급
	
	
	$('#profilePreview').empty(); //프로필 프리뷰 영역 초기화
	
	//입사일 오늘 날짜로 default 지정
	document.getElementById("entry_date").value = new Date().toISOString().slice(0, 10); 
	
	$.ajax({
		url : "/employee/gainLoginID.do",
		type : "post",
		dataType : "json",
		async : true,
		success : function(data){
			$('#loginID').val(data.loginID);
		},
		error : function(err){
			alert("에러남 : "+err);
		}
	});
	gfModalPop('#layer1'); //사원등록 모달 팝업창 열기
	empRegisterInit();
	
	
	//사원 등록 -> 프로필 사진 미리보기 methods
	function check_file_image(file) {
		return file.type.substr(0, 5) === "image"			
	}
	function check_file_size(file){
		return file.size <= 1024 * 1024 * 5; //5mb까지 업로드 가능
	}
	function check_file_extension(file) {
		var exts = ["jpg", "jpeg", "png"];
		return exts.reduce(function(acc, x){
			return acc === true || file.type.substr(6).toLowerCase() === x
		});
	}

	$('#profileUpload').on("change", function(e){
		var files = e.target.files;
		for(var i = 0; i < files.length; i++){
			//파일 업로드 제한
			if(!check_file_image(files[i])){
				swal("이미지 파일만 업로드할 수 있습니다.")
				e.target.value = null;
				return;
			}//check_image
			
			//이미지 용량 제한
			if(!check_file_size(files[i])){
				swal("이미지 파일은 최대 5MB까지만 업로드 가능합니다.")
				e.target.value = null;
				return;
			}//checksize
			
			//파일 확장자 검사
			if(!check_file_extension(files[i])){
				swal("이미지 파일은 jpg, jpeg, png 확장자 파일 업로드 가능합니다.")
				e.target.value = null;
				return;
			}//checkExt
		}//for문
		
		//이미지 미리보기
		var reader = new FileReader();
		var str = "";
		reader.onload = function (e) {
			$('#userProfile').removeClass('profile');
			$('#profilePreview').empty();
			str += '<img src="'+e.target.result+'"id="filename"/>';
			$('#profilePreview').append(str);
		};
		reader.readAsDataURL(files[0]);
	});//사원등록 ->  프로필 사진 미리보기 methods 끝
}

//사원 등록 폼 초기화 -> 나중에 신규등록인지 수정인지 확인해서 init하는거 바꿔줘야함. 참고 jsp. std/learnmng/submittedWork.jsp
function empRegisterInit(object){
	if( object == "" || object == null || object == undefined) {
		$('#action').val("I");
		empDtlDisabled();
		$('#name').val(""); $('#regno').val("");
		$('input:radio[name="sex"]').removeAttr("checked"); $('#birthday').val("");
		$("#school option:eq(0)").prop("selected", true);
		$('#mail1').val(""); $('#mail2').val(""); $("#tel1 option:eq(0)").prop("selected", true);
		$('#tel2').val(""); $('#tel3').val(""); $('#zip_code').val(""); $('#addr').val(""); $('#addr_detail').val("");
		$("#bank option:eq(0)").prop("selected", true); $('#account').val("");
		$("#dept_cd option:eq(0)").prop("selected", true); $("#user_type option:eq(0)").prop("selected", true);
		$("#poscd option:eq(0)").prop("selected", true); $('input:radio[name="rest_yn"]').removeAttr("checked");
		$('input:radio[name="out_yn"]').removeAttr("checked");
		$('#workyear').val(""); $('#retire_date').val(""); $('#entry_date').val(""); 
		$('#oamt').val(""); $('#retire_note').val("");
		$('#year_salary').val(""); $('#memo').val("");
		$('#btnEmpRegister > span').text("저장");
		$('#btnDeleteEmp').hide();
		
	} else {
		
		var splitMail = (object.empDtl.mail ||'').split('@');;
		var splitTel = (object.empDtl.tel||'').split('-');;
		
		$('#profilePreview').empty();
		$('#btnDeleteEmp').show();
		if(object.empDtl.out_yn == 'n'){ //재직자일 경우
			tmpEmpStatus = 'n';
			$('#action').val("U");
			empDtlDisabled(tmpEmpStatus);
			$('#btnEmpRegister > span').text("수정");
			comcombo("EDUcd", "school", "sel", object.empDtl.school); //최종학력
			comcombo("BKcd", "bank", "sel", object.empDtl.bank); //은행계좌
			selectComCombo("dept", "dept_cd", "sel", "", object.empDtl.dept_cd); //부서
			comcombo("USERcd", "user_type", "sel", object.empDtl.user_type); //직무==userType 
			comcombo("POScd", "poscd", "sel", object.empDtl.poscd); //직급
			if(object.empDtl.filename != null){
				var str = "";
				$('#userProfile').removeClass('profile');
				str += '<img src="'+object.imgPath+'"id="filename"/>';
				$('#profilePreview').append(str);
			}//프로필사진 불러오기*/
			$('#loginID').val(object.empDtl.loginID); $('#name').val(object.empDtl.name); $('#regno').val(object.empDtl.regno);
			//성별
			$("input:radio[name=sex]:input[value='"+object.empDtl.sex+"']").prop("checked" , true);
			$("input:radio[name=sex]");
			$('#birthday').val(object.empDtl.birthday);
			$('#mail1').val(splitMail[0]); $('#mail2').val(splitMail[1]);
			$.each($("#tel1 > option"), function(index, item){
				if($(item).text() == splitTel[0]){
					$(item).prop("selected", true);
				}
			});//전화번호 앞자리
			$('#tel2').val(splitTel[1]); $('#tel3').val(splitTel[2]); 
			$('#zip_code').val(object.empDtl.zip_code); $('#addr').val(object.empDtl.addr); $('#addr_detail').val(object.empDtl.addr_detail);
			$('#account').val(object.empDtl.account);
			$('#entry_date').val(object.empDtl.entry_date).attr("readonly", true);
			//재직구분
			$("input:radio[name=rest_yn]:input[value='"+object.empDtl.rest_yn+"']").prop("checked" , true);
			$("input:radio[name=out_yn]").prop({checked : false, disabled : true});
			$('#workyear').val(object.workyear);
			$('#year_salary').val(object.empDtl.year_salary);
			$('#memo').val(object.empDtl.memo);
			$('#oamt').val(object.empDtl.oamt); $('#retire_note').val(object.empDtl.retire_note);
			
		}else { //퇴직자
			
			tmpEmpStatus = 'y';
			empDtlDisabled(tmpEmpStatus);
			$('#btnEmpRegister').hide();
			$('#btnDeleteEmp').show();
			comcombo("EDUcd", "school", "sel", object.empDtl.school); //최종학력
			comcombo("BKcd", "bank", "sel", object.empDtl.bank); //은행계좌
			selectComCombo("dept", "dept_cd", "sel", "", object.empDtl.dept_cd); //부서
			comcombo("USERcd", "user_type", "sel", object.empDtl.user_type); //직무==userType 
			comcombo("POScd", "poscd", "sel", object.empDtl.poscd); //직급
			if(object.empDtl.filename != null){
				var str = "";
				$('#userProfile').removeClass('profile');
				$('#profilePreview').empty();
				str += '<img src="'+object.imgPath+'"id="filename"/>';
				$('#profilePreview').append(str);
			}//프로필 사진 불러오기
			$('#loginID').val(object.empDtl.loginID); $('#name').val(object.empDtl.name); 
			$('#regno').val(object.empDtl.regno);
			 //성별
			$("input:radio[name=sex]:input[value='"+object.empDtl.sex+"']").prop("checked", true);
			$('#birthday').val(object.empDtl.birthday);
			$('#mail1').val(splitMail[0]); $('#mail2').val(splitMail[1]); 
			$.each($("#tel1 > option"), function(index, item){
				if($(item).text() == splitTel[0]){
					$(item).prop("selected", true);
				}
			});//전화번호 앞자리
			$('#tel2').val(splitTel[1]); $('#tel3').val(splitTel[2]); 
			$('#zip_code').val(object.empDtl.zip_code);
			$('#addr').val(object.empDtl.addr); 
			$('#addr_detail').val(object.empDtl.addr_detail);
			$('#account').val(object.empDtl.account);
			$('#entry_date').val(object.empDtl.entry_date);
			$('#retire_date').val(object.empDtl.retire_date);
			//재직구분
			$('input:radio[name=rest_yn]').prop("checked" , false);
			$("input:radio[name=out_yn]").prop("checked", true); 
			$('#workyear').val(object.workyear);
			$('#year_salary').val(object.empDtl.year_salary);
			$('#memo').val(object.empDtl.memo);
			$('#oamt').val(object.empDtl.oamt); 
			$('#retire_note').text(object.empDtl.retire_note);
		}//else(퇴직자)
	}//else(수정 시 기존정보)
}
//상세정보 disabled 처리 함수
function empDtlDisabled(tmpEmpStatus){
	if(tmpEmpStatus == 'y'){ //퇴직자 일 때
		$('#userProfile').attr('onclick', '').unbind('click');
		$('#userProfile').attr("style", "cursor : default");
		$("#school").prop("style", "pointer-events : none; width : 90%");
		$("#bank").prop("style", "pointer-events : none; width : 33%");
		$("#dept_cd").prop("style", "pointer-events : none; width : 65%");
		$("#user_type").prop("style", "pointer-events : none; width : 83%");
		$("#poscd").prop("style", "pointer-events : none; width : 65%");
		$("#tel1").prop("style", "pointer-events : none; width: 30%");
		$('#loginID').prop("disabled", "true"); $('#name').prop("disabled", "true"); 
		$('#regno').prop("disabled", "true");
		 //성별
		$("input:radio[name=sex]").prop("disabled", true); 
		$('#birthday').prop("disabled", true);
		$('#mail1').prop("disabled", true); $('#mail2').prop("disabled", true);; 
		$('#tel2').prop("disabled", true); $('#tel3').prop("disabled", true); 
		$('#post_cd').prop("style", "width: 35%; height: 100%; cursor : default");
		$('#post_cd').prop('onclick', '').unbind('click');
		$('#zip_code').prop("disabled", true);
		$('#addr').prop("disabled", true); 
		$('#addr_detail').prop("disabled", true);
		$('#account').prop("disabled", true);
		$('#entry_date').prop("disabled", true);
		$('#retire_date').prop("disabled", true);
		//재직구분
		$('input:radio[name=rest_yn]').prop("disabled" , true);
		$('input:radio[name=out_yn]').prop("disabled" , true);
		$('#workyear').prop("disabled", true);
		$('#year_salary').prop("disabled", true);
		$('#memo').prop("disabled", true);
		$('#oamt').prop("disabled", true); 
		$('#retire_note').prop("disabled", true);
	}else if(tmpEmpStatus == 'n') { //재직자일 시
		$('#userProfile').addClass('profile');
		$('#userProfile').attr('onclick', 'document.all.profileUpload.click()').bind('click');
		$('#userProfile').attr("style", "cursor : pointer");
		$("#school").prop("style", "pointer-events : ''; width : 90%");
		$("#bank").prop("style", "pointer-events : ''; width : 33%");
		$("#dept_cd").prop("style", "pointer-events : ''; width : 65%");
		$("#user_type").prop("style", "pointer-events : ''; width : 83%");
		$("#poscd").prop("style", "pointer-events : ''; width : 65%");
		$("#tel1").prop("style", "pointer-events : ''; width : 30%");
		$('#name').prop("disabled", false); 
		$('#regno').prop("disabled", false);
		 //성별
		$("input:radio[name=sex]").prop("disabled", false); 
		$('#birthday').attr("disabled", false);
		$('#mail1').attr("disabled", false); $('#mail2').attr("disabled", false); 
		$('#tel2').attr("disabled", false); $('#tel3').attr("disabled", false); 
		$('#post_cd').attr("style", "width: 35%; height: 100%; cursor : pointer");
		$('#post_cd').attr('onclick', 'execDaumPostcode()').bind('click');
		$('#zip_code').attr("disabled", false);
		$('#addr').attr("disabled", false); 
		$('#addr_detail').attr("disabled", false);
		$('#account').attr("disabled", false);
		$('#entry_date').attr("disabled", true); // -> 입사일 변경 막아놓기 위해 재직자와 신규등록 구분
		//재직구분
		$('input:radio[name=rest_yn]').prop("disabled" , false);
		$('#workyear').attr("disabled", false);
		$('#year_salary').attr("disabled", false);
		$('#memo').attr("disabled", false);
		$('#oamt').attr("disabled", false); 
		$('#retire_note').attr("disabled", false);
	}else {
		$('#userProfile').addClass('profile');
		$('#userProfile').attr('onclick', 'document.all.profileUpload.click()').bind('click');
		$('#userProfile').attr("style", "cursor : pointer");
		$("#school").attr("style", "pointer-events : ''; width : 90%");
		$("#bank").attr("style", "pointer-events : ''; width : 33%");
		$("#dept_cd").attr("style", "pointer-events : ''; width : 65%");
		$("#user_type").attr("style", "pointer-events : ''; width : 83%");
		$("#poscd").attr("style", "pointer-events : ''; width : 65%");
		$("#tel1").attr("style", "pointer-events : ''; width : 30%");
		$('#name').attr("disabled", false); 
		$('#regno').attr("disabled", false);
		$("input:radio[name=sex]").prop("disabled", false); 
		$('#birthday').attr("disabled", false);
		$('#mail1').attr("disabled", false); $('#mail2').attr("disabled", false);
		$('#tel2').attr("disabled", false); $('#tel3').attr("disabled", false); 
		$('#post_cd').attr("style", "width: 35%; height: 100%; cursor : pointer");
		$('#post_cd').attr('onclick', 'execDaumPostcode()').bind('click');
		$('#zip_code').attr("disabled", false);
		$('#addr').attr("disabled", false); 
		$('#addr_detail').attr("disabled", false);
		$('#account').attr("disabled", false);
		$('#entry_date').attr("disabled", false);
		//재직구분
		$('input:radio[name=rest_yn]').prop("disabled" , false);
		$('#workyear').attr("disabled", false);
		$('#year_salary').attr("disabled", false);
		$('#memo').attr("disabled", false);
		$('#oamt').attr("disabled", false); 
		$('#retire_note').attr("disabled", false);
	}
}

//사원 등록 -> 우편번호찾기 method
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
			document.getElementById('zip_code').value = data.zonecode;
			document.getElementById("addr").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("addr_detail").focus();
		}
	}).open({
		q : q
	});
}//사원 등록 -> 우편번호찾기 method 끝

//사원등록 -> 호봉 팝업 호출
function payStep(){
	window.open('empPaystep.do', '호봉테이블', 'left=100 top=80 width=606 height=470 scrollbars=yes');
}//사원등록 -> 호봉 팝업 호출 끝
	
//사원등록 validation
function validateEmp(){
	//사원명 체크
	var name = $('#name').val();
	var namePattern = /[-~!@#$%^&*_()+|<>?:{}]/;
	if(name == ""){
		swal("사원명을 입력해주세요.").then(function(){
			$('#name').focus();
		});	
		return false;
	}else if (name.length > 20){
		swal("이름은 20자 이하로 입력해주세요.").then(function(){
			$('#name').focus();
		});	
		return false;
	}else if (namePattern.test(name)){
		swal("이름에 특수 문자를 사용하실 수 없습니다.").then(function(){
			$('#name').focus();
		});	
		return false;
	}
	
	//주민등록번호 체크
	var regno = $('#regno').val();
	var regnoPattern = /^\d{6}-\d{7}$/;
	if(regno == ""){
		swal("주민등록번호를 입력해주세요.").then(function(){
			$('#regno').focus();
		});
		return false;
	}else if (!regnoPattern.test(regno)){
		swal("주민등록번호형식에 맞춰서 입력해주세요.\n예시 : 앞자리 6자리-뒷자리 7자리").then(function(){
			$('#regno').focus();
		});
		return false;
	}
	
	//성별 체크
	var sexChk = $('input:radio[name="sex"]');
	if(!sexChk.is(':checked')){
		swal("성별을 체크해주세요.");
		return false;
	}
	
	//최종학력 체크
	var educd = $('#school option:selected').text();
	if(educd == "선택"){
		swal("최종학력을 선택해주세요.");
		return false;
	}
	
	//이메일 체크
	var mail1 = $('#mail1').val();
	var mail2 = $('#mail2').val();
	var mailPattern = /[~!@#$%^&*()+|<>?:{}]/;
	if(mail1 == ""){
		swal("이메일을 입력해주세요.").then(function(){
			$('#mail1').focus();
		});
		return;
	}else if (mailPattern.test(mail1)){
		swal("이메일에 특수 문자를 사용하실 수 없습니다.").then(function(){
			$('#mail1').focus();
		});
		return false;
	}
	if(mail2 == ""){
		swal("이메일 주소를 입력해주세요.").then(function(){
			$('#mail2').focus();
		});
		return false;
	}else if (mailPattern.test(mail2)){
		swal("이메일 주소에 특수 문자를 사용하실 수 없습니다.").then(function(){
			$('#mail2').focus();
		});
		return false;
	}
	
	//연락처 체크
	var tel1 = $('#tel1 option:selected').text();
	var tel2 = $('#tel2').val();
	var tel3 = $('#tel3').val();
	var telPattern = /^[0-9]*$/;
	if(tel1 == "선택"){
		swal("연락처를 선택해주세요.");
		return false;
	}
	if(tel2 == ""){
		swal("연락처를 입력해주세요.").then(function(){
			$('#tel2').focus();
		});
		return false;
	} else if (!telPattern.test(tel2)){
		swal("숫자만 입력해주세요.").then(function(){
			$('#tel2').focus();
		});
		return false;
	} else if (tel2.length != 4){
		swal("연락처 형식을 맞춰주세요.").then(function(){
			$('#tel2').focus();
		});
		return false;
	}
	if(tel3 == ""){
		swal("연락처를 입력해주세요.").then(function(){
			$('#tel3').focus();
		});
		return false;
	} else if (!telPattern.test(tel3)){
		swal("숫자만 입력해주세요.").then(function(){
			$('#tel3').focus();
		});
		return false;
	} else if (tel3.length != 4){
		swal("연락처 형식을 맞춰주세요.").then(function(){
			$('#tel3').focus();
		});
		return false;
	}
	
	//주소 체크
	var zip_code = $('#zip_code').val();
	var addr = $('#addr').val();
	var addr_detail = $('#addr_detail').val();
	if(zip_code == ""){
		swal("우편번호 찾기로 주소를 입력해주세요.")
		return false;
	} else if (addr == ""){
		swal("우편번호 찾기로 주소를 입력해주세요.")
		return false;
	} else if (addr_detail == ""){
		swal("상세주소를 입력해주세요.").then(function(){
			$('#addr_detail').focus();
		});
		return false;
	}
	
	//은행계좌 체크
	var bank = $('#bank option:selected').text();
	var account = $('#account').val();
	var accountPattern =  /^[0-9-]*$/;
	if (bank == "선택"){
		swal("계좌와 연결된 은행을 선택해주세요")
		return false;
	}
	if(account == ""){
		swal("계좌번호를 입력해주세요.").then(function(){
			$('#account').focus();
		});
		return false;
	}else if (!accountPattern.test(account)){
		swal("올바른 계좌번호 형식으로 적어주세요.").then(function(){
			$('#account').focus();
		});
		return false;
	}
	
	//부서 체크
	var dept = $('#dept_cd option:selected').text();
	if(dept == "선택"){
		swal("부서를 선택해주세요.");
		return false;
	}
	
	//직무 체크
	var userType = $('#user_type option:selected').text();
	if(userType == "선택"){
		swal("직무를 선택해주세요.");
		return false;
	}
	
	//직급 체크
	var poscd = $('#POScd option:selected').text();
	if(poscd == "선택"){
		swal("직급을 선택해주세요.");
		return false;
	}
	
	//재직 휴직 체크
	var restChk = $('input:radio[name="rest_yn"]');
	if(!restChk.is(':checked')){
		swal("재직구분을 체크해주세요.");
		return false;
	}
	
	//
	var year_salary = $('#year_salary').val();
	var year_salaryPattern =  /^[0-9]*$/;
	if(year_salary == ""){
		swal("연봉을 기입해주세요.").then(function(){
			$('#year_salary').focus();
		});
		return false;
	}else if (!year_salaryPattern.test(year_salary)){
		swal("연봉에 숫자만 기입해주세요.").then(function(){
			$('#year_salary').focus();
		});
		return false;
	}
	
	return true;
	
}

//사원등록 저장
function empRegister(){
	var empRegisterForm = document.getElementById("empRegister");
	if(!validateEmp()){
		return;
	}
	
	empRegisterForm.enctype = 'multipart/form-data';
	
	var fileData = new FormData(empRegisterForm);
	var resultCallback = function(data) {
		empRegisterResult(data);
	};
	callAjaxFileUploadSetFormData("/employee/empRegister.do", "post", "json", true, fileData, resultCallback);

}

//사원등록 저장 callback함수
function empRegisterResult(data){
	if (data.result == "SUCCESS") {
		swal(data.resultMsg);
		gfCloseModal();
		showEmpList();
	}else {
		swal("등록에 실패하였습니다.");
	}
}
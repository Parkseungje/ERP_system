/**
 *  창고 정보 등록, 수정, 삭제 javascript와 *다음* 우편번호 찾기 API
 */
 
 // 창고 정보 등록 & 수정 & 삭제
  function whInfoControl(action) {
    console.log(action);

    if (!fValidateWhInfo()) {
      return;
    }

    let param;
    let resultCallBack;
    const url = "/scm/whinfo";

    switch (action) {
    case "produce":
      param = {
      action : action,
      ware_cd : $("#address").val().substr(0,2),
      ware_name : $("#ware_name").val(),
      ware_address : $("#address").val(),
      ware_dt_address : $("#dt_address").val(),
      ware_zipcode : $("#zipcode").val(),
      loginID : $("#selectMng option:selected").val()
      };
      resultCallBack = function(data) {
        const result = data.result;
        const resultMsg = data.resultMsg
        console.log(result);
        swal(resultMsg);
        location.href = "";
      };
      break;

    case "update":
      param = {
      action : action,
      ware_no : $("#ware_no").val(),
      ware_cd : $("#address").val().substr(0,2),
      ware_name : $("#ware_name").val(),
      ware_address : $("#address").val(),
      ware_dt_address : $("#dt_address").val(),
      ware_zipcode : $("#zipcode").val(),
      loginID : $("#selectMng option:selected").val()
      };
      resultCallBack = function(data) {
        const result = data.result;
        const resultMsg = data.resultMsg
        console.log(result);
        swal(resultMsg);
        location.href = "";
      };
      break;

    /*case "delete":
      param = {
      action : action,
      ware_no : $("#ware_no").val()
      };
      resultCallBack = function(data) {
        const result = data.result;
        const resultMsg = data.resultMsg
        console.log(result);
        swal(resultMsg);
        location.href = "";
      };
      break;*/
      
    default:
      swal("잘못된 접근 입니다.");
      location.href = "";
    }
    callAjax(url, "post", "json", true, param, resultCallBack);
  }

  /** 창고 정보 null check */
  function fValidateWhInfo() {

    const chk = checkNotEmpty([ 
      [ "ware_name", "창고 명을 입력해 주세요." ], 
      [ "zipcode", "우편 번호를 입력해 주세요." ], 
      ["mng_name", "배송담당자가 없습니다."],
      [ "address", "주소를 입력해 주세요." ], 
      [ "dt_address", "상세 주소를 입력해 주세요." ]
      ]);
    if (!chk) {
      return;
    }
    return true;
  }

  // 우편번호 api
  function execDaumPostcode(q) {
    new daum.Postcode({
      oncomplete : function(data) {
        // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

        // 각 주소의 노출 규칙에 따라 주소를 조합한다.
        // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
        let addr = ''; // 주소 변수
        let extraAddr = ''; // 참고항목 변수

        //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
        if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
          addr = data.roadAddress;
        } 
        else { // 사용자가 지번 주소를 선택했을 경우(J)
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
            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
          }
        }

        // 우편번호와 주소 정보를 해당 필드에 넣는다.
        document.getElementById('zipcode').value = data.zonecode;
        document.getElementById("address").value = addr;
        // 커서를 상세주소 필드로 이동한다.
        document.getElementById("address").focus();
      }
    }).open({
      q : q
    });
  }
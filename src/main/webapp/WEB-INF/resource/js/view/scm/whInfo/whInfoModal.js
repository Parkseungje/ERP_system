/**
 *  모달창에 정보를 뿌리는 javascript
 */
 
 // 창고 등록 정보
  function whInitModal(modalCD,wareNo) {
    
    let param;
    const url = "/scm/whmng";
    const resultCallback = function(data) {
      whMngInfo(data);
    };
    if (modalCD === 'init') {
      param = {
        modalCD : modalCD,
        ware_no : wareNo
      };
    } else if (modalCD === 'modify') {
      param = {
        modalCD : modalCD,
        ware_no : wareNo
      };
    }
    callAjax(url, "get", "json", true, param, resultCallback);
  }

  // 담당자 정보 조회
  function whMngInfo(data) {
    if (!(data.listMngInfo === "" || data.listMngInfo === null || data.listMngInfo === undefined)) {
      if (!(data.listMngWareInfo === "" || data.listMngWareInfo === null || data.listMngWareInfo === undefined)) {
        whInfoModalInit(data.listMngInfo, data.listMngWareInfo, data.modalCD, data.wareNo);
        gfModalPop("#wh");
      } else {
        swal("창고 정보가 없습니다.");
        whInfoModalInit(data.listMngInfo, data.listMngWareInfo, data.modalCD, data.wareNo);
        gfModalPop("#wh");
      }
    } else
      swal("담당자 정보가 없습니다.");

  }

  // 창고 등록 정보 모달창 초기화
  function whInfoModalInit(mngInfo, mngWareInfo, modalCD, wareNo) {

    // 모든 정보 초기화
    $("#ware_no").val("");
    $("#ware_name").val("");
    $("#zipcode").val("");
    $("#address").val("");
    $("#dt_address").val("");
    $("#tel").val("");
    $("#email").val("");
    $("#modalCD").val("");

    // select태그 밑에 모든 HTML 초기화. // 콤보박스 & 버튼박스 초기화
    $("#selectMng").html("");
    $("#btnBox").html("");
    $("#whInfoData").html("");

    if (modalCD === "init") {
      //  modalCD input에 init 저장
      $("#modalCD").val(modalCD);

      whInfoOptionInit(mngInfo, mngWareInfo);
      selectedMng(mngInfo[0].loginID);

      // btnBox에 btn생성 // 등록 & 취소버튼 생성
      $("#btnBox").append("<a href='javascript:whInfoControl(produce)' class='btnType blue' id='btnInitWhInfo' name='btn'><span>등록</span></a>");
      $("#btnBox").append("<a href='javascript:gfCloseModal()' class='btnType gray' id='btnClose' name='btn'><span>취소</span></a>");
      
       // 창고 코드 hide
      $("#ware_cd_th").hide();
      $("#ware_cd_td").hide();
    } else if (modalCD === "modify") {
      //  modalCD input에 modify 저장
      $("#modalCD").val(modalCD);

      whInfoOptionInit(mngInfo, mngWareInfo);
      selectedMng(mngInfo[0].loginID, wareNo);

      // btnBox에 btn생성 // 수정 & 삭제 & 취소버튼 생성
      $("#btnBox").append("<a href='javascript:whInfoControl(update)' class='btnType blue' id='btnUpdateWhInfo' name='btn'><span>수정</span></a>");
      //$("#btnBox").append("<a href='javascript:whInfoControl(del)' class='btnType blue' id='btnDeleteWhInfo' name='btn'><span>삭제</span></a>");
      $("#btnBox").append("<a href='javascript:gfCloseModal()' class='btnType gray' id='btnClose' name='btn'><span>취소</span></a>");
      
       // 창고 코드 show
      $("#ware_cd_th").show();
      $("#ware_cd_td").show();
    }
  }
  
  //  옵션 & 정보 생성
  function whInfoOptionInit(mngInfo, mngWareInfo) {

    mngInfo.forEach(function(list) {
      $("#selectMng").append("<option value='"+list.loginID+"'>" + list.name + "</option>");
      $("#whInfoData").append("<div id="+list.loginID+" class="+list.loginID+" name="+list.name+"></div>");
      $("#" + list.loginID).append("<input type='hidden' class='tel' value='"+list.user_tel1+"-"+list.user_tel2+"-"+list.user_tel3+"'>");
      $("#" + list.loginID).append("<input type='hidden' class='email' value='"+list.user_email+"'>");
    });
    if (!(mngWareInfo === "" || mngWareInfo === null || mngWareInfo === undefined)) {
      mngWareInfo.forEach(function(list) {
        $("#whInfoData").append("<div id='"+list.ware_no+"' class='"+list.ware_no+"' name='"+list.name+"' ></div>");
        $("#" + list.ware_no).append("<input type='hidden' class='ware_name' value='"+list.ware_name+"' >");
        $("#" + list.ware_no).append("<input type='hidden' class='ware_zipcode' value='"+list.ware_zipcode+"' >");
        $("#" + list.ware_no).append("<input type='hidden' class='ware_address' value='"+list.ware_address+"' >");
        $("#" + list.ware_no).append("<input type='hidden' class='ware_dt_address' value='"+list.ware_dt_address+"' >");
      });
    }
  }

  //  콤보 박스에서 선택된 값으로 유저 정보를 요청.
  function selectedMng(selected, wareNo = null) {
    
    console.log($("#selectMng option:selected").val());
    
    const option_name = $("#" + selected).attr("name");
    const option_tel = $("#whInfoData").find('.' + selected).children('.tel').val();
    const option_email = $("#whInfoData").find('.' + selected).children('.email').val();

    $("#mng_name").val(option_name);
    $("#tel").val(option_tel);
    $("#email").val(option_email);

    if(wareNo !== null){
      const option_ware_cd = $("#" + wareNo).attr("id");
      const option_ware_name = $("#" + wareNo).children(".ware_name").val();
      const option_name = $("#" + wareNo).attr("name");
      const option_tel = $("div[name="+option_name+"]").children(".tel").val();
      const option_email = $("div[name="+option_name+"]").children(".email").val();
      const option_zipcode = $("#" + wareNo).children(".ware_zipcode").val();
      const option_address = $("#" + wareNo).children(".ware_address").val();
      const option_dt_address = $("#" + wareNo).children(".ware_dt_address").val();
      
      $("#ware_no").val(option_ware_cd);
      $("#ware_name").val(option_ware_name);
      $("#mng_name").val(option_name);
      $("#tel").val(option_tel);
      $("#email").val(option_email);
      $("#zipcode").val(option_zipcode);
      $("#address").val(option_address);
      $("#dt_address").val(option_dt_address);
      
    }
  }
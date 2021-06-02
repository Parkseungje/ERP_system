
	// 페이징 설정 
	var noticePageSize = 10; // 화면에 뿌릴 데이터 수 
	var noticePageBlock = 5; // 블럭으로 잡히는 페이징처리 수

	// onload 이벤트  
	$(function() {
		// 자유게시판 리스트 뿌리기 함수 
		selectNoticeList();

		// 버튼 이벤트 등록 (저장, 수정, 삭제, 모달창 닫기)
		fButtonClickEvent();
		
		// DatePicker
		fDatePicker();
		
		
	});
	
	function resize(obj) {
		  obj.style.height = "1px";
		  obj.style.height = (12+obj.scrollHeight)+"px";
		}
	
	// 날짜 변한 함수  
 	function getFormatDate(date){
	    var year = date.getFullYear();              //yyyy
	    var month = (1 + date.getMonth());          //M
	    month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
	    var day = date.getDate();                   //d
	    day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
	    return  year + '-' + month + '-' + day;       //'-' 추가하여 yyyy-mm-dd 형태 생성 가능
	} 

	// 버튼 이벤트 등록 - 저장, 수정, 삭제  
	function fButtonClickEvent() {
		$('a[name=btn]').click(function(e) {
			e.preventDefault(); // ?? 

			var btnId = $(this).attr('id');

			//alert("btnId : " + btnId);

			switch (btnId) {
			case 'btnSaveNotice':
				fSaveNotice(); // save 안에 저장,수정
				//alert("저장버튼 클릭!!!이벤트!!");
				break;
			case 'btnDeleteNotice':
				fDeleteNotice(); // 만들자 
				//alert("삭제버튼 클릭!!!이벤트!!");		
				break;
			case 'btnClose':
				gfCloseModal(); // 모달닫기 
				selectNoticeList(); // 첫페이지 다시 로딩 
				break;
			case 'btnUpdateNotice':
				fUpdateNotice(); // 수정하기
				break;
			case 'searchBtn':
				board_search(); // 검색하기
				break;

			//case 'commentWrite' : fCommentInsert();   // 댓글--> 답변글로 변경 // 저장 
			//break;
			}
		});
	}
	
	// DatePicker
 	function fDatePicker(){
 	    $.datepicker.setDefaults($.datepicker.regional['ko']); 
 	    $( "#from_date" ).datepicker({
 	         changeMonth: true, 
 	         changeYear: true,
 	         nextText: '다음 달',
 	         prevText: '이전 달', 
 	         dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
 	         dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
 	         monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
 	         monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
 	         showAnim: "slide", //애니메이션을 적용한다.
 	         dateFormat: "yy-mm-dd",
 	         maxDate: 0,                       // 선택할수있는 최소날짜, ( 0 : 오늘 이후 날짜 선택 불가)
 	         onClose: function( selectedDate ) {    
 	              //시작일(startDate) datepicker가 닫힐때
 	              //종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
 	             $("#to_date").datepicker( "option", "minDate", selectedDate );
  
 	         }    

 	    });
 	    $( "#to_date" ).datepicker({
 	         changeMonth: true, 
 	         changeYear: true,
 	         nextText: '다음 달',
 	         prevText: '이전 달', 
 	         dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
 	         dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
 	         monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
 	         monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
 	         showAnim: "slide", //애니메이션을 적용한다.
 	         dateFormat: "yy-mm-dd",                    // 선택할수있는 최대날짜, ( 0 : 오늘 이후 날짜 선택 불가)
 	         onClose: function( selectedDate ) {    
 	             // 종료일(endDate) datepicker가 닫힐때
 	             // 시작일(startDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 시작일로 지정
 	             $("#from_date").datepicker( "option", "maxDate", selectedDate );

 	         }    

 	    }); 
 	    
 	    $("#from_date").datepicker('setDate', '-3M');
 	    $("#to_date").datepicker('setDate', 'today');
 	}
 	
	// 공지사항 리스트 호출
	function selectNoticeList(currentPage) {

		currentPage = currentPage || 1; // or		

		//alert("지금 현재 페이지를 찍어봅시다. " + currentPage);

		var param = {
			currentPage : currentPage,
			pageSize : noticePageSize
		}

		var resultCallback = function(data) { // 데이터를 이 함수로 넘깁시다. 
			noticeListResult(data, currentPage);
		}

		callAjax("/scm/noticeList.do", "post", "text", true, param,
				resultCallback);

	}

	/* callAjax 공통 common.js 에서 퍼옴  -> 이렇게 생긴 함수입니다.  
	
	function fOnloadImg(param){
		var resultCallback = function(data) {
			fOnloadImgResult(data);
		};
		callAjax("/image/selectImgSize.do", "post", "json", false, param, resultCallback);
	 } */

	
	// 공지사항 리스트 data를 콜백함수를 통해 뿌린다.  
	function noticeListResult(data, currentPage) {

		// 일단 기존 목록을 삭제합니다. (변경시 재부팅 용)
		$("#noticeList").empty();
		//alert("데이터!!! " + data);
		//console.log("data !!!! " +  data);

		//var $data = $( $(data).html() ); // data의 .html()통해서 html구문을 끌어온다.
		//alert("데이터 찍어보자!!!! " +  $data); // object

		$("#noticeList").append(data);

		// 리스트의 총 개수를 추출합니다. 
		//var totalCnt = $data.find("#totalCnt").text();
		var totalCnt = $("#totalCnt").val(); // qnaRealList() 에서보낸값 
		//alert("totalCnt 찍어봄!! " + totalCnt);

		// * 페이지 네비게이션 생성 (만들어져있는 함수를 사용한다 -common.js)
		// function getPaginationHtml(currentPage, totalCount, pageRow, blockPage, pageFunc, exParams)
		// 파라미터를 참조합시다. 
		var list = $("#tmpList").val();
		//var listnum = $("#tmpListNum").val();
		var pagingnavi = getPaginationHtml(currentPage, totalCnt,
				noticePageSize, noticePageBlock, 'selectNoticeList', [ list ]);

		console.log("pagingnavi : " + pagingnavi);
		// 비운다음에 다시 append 
		$("#pagingnavi").empty().append(pagingnavi); // 위에꺼를 첨부합니다. 

		// 현재 페이지 설정 
		$("#currentPage").val(currentPage);

	}

	// 검색 기능
	function board_search(currentPage) {

		currentPage = currentPage || 1;

		var sname = $('#sname');
		var searchKey = document.getElementById("searchKey");
		var oname = searchKey.options[searchKey.selectedIndex].value;
		
		var from_date = $('#from_date');
		var to_date = $('#to_date');
		
	
		var param = {
			sname : sname.val(),
			oname : oname,
			from_date : from_date.val(),
			to_date : to_date.val(),
			currentPage : currentPage,
			pageSize : noticePageSize
		}

		var resultCallback = function(data) {
			noticeListResult(data, currentPage);
		};

		callAjax("/scm/noticeList.do", "post", "text", true, param,
				resultCallback);
	}

	// 공지사항 모달창 호출
	function fNoticeModal(notice_no) {

		// 신규저장 하기 버튼 클릭시 (값이 null)
		if (notice_no == null || notice_no == "") {
			// Tranjection type 설정
			//alert("넘을 찍어보자!!!!!!" + notice_no);

			$("#action").val("I"); // insert 
			/* $("#notice_no").val(""); */
			frealPopModal(notice_no); // 공지사항 초기화 
			
			//모달 팝업 모양 오픈! (빈거) _ 있는 함수 쓰는거임. 
			
			gfModalPop("#notice");
			
			var d= new Date();
			d = getFormatDate(d);
			$("#notice_moddate").val(d);
			$("#notice_moddate").attr("readonly", true);
 
		} else {
			// Tranjection type 설정
			$("#action").val("U"); // update
			fdetailModal(notice_no); //번호로 -> 공지사항 상세 조회 팝업 띄우기
		}

	}

	// 공지사항 상세조회
	function fdetailModal(notice_no) {
		//alert("공지사항 상세 조회  ");

		var param = {
			notice_no : notice_no
		};
		var resultCallback2 = function(data) {
			fdetailResult(data);
		};

		callAjax("/scm/detailNoticeList.do", "post", "json", true, param,
				resultCallback2);
		//alert("공지사항 상세 조회  22");
	}

	// 공지사항 상세 조회 -> 콜백함수   
	function fdetailResult(data) {

		//alert("공지사항 상세 조회  33");
		if (data.resultMsg == "SUCCESS") {
			//모달 띄우기 
			gfModalPop("#notice");

			// 모달에 정보 넣기 
			frealPopModal(data.result, data.result2);

		} else {
			alert(data.resultMsg);
		}
	}

	// 공지사항 작성 or 공지사항 상세조회,수정 모달창 호출 
	function frealPopModal(object,fobject) {

		if (object == "" || object == null || object == undefined) {
			var writer = $("#swriter").val();

			$("#loginID").val(writer);
			$("#loginID").attr("readonly", true);

			$("#write_date").val();
			$("#notice_title").val("");
			$("#notice_content").val("");	
			
			// 파일 정보 초기화
			$("#file").val("");
			
			// 첨부파일 초기화
			$("#filedown").empty();
			
			$("#btnDeleteNotice").hide(); // 삭제버튼 숨기기
			$("#btnUpdateNotice").hide();
			$("#btnSaveNotice").show();

		} else {

			//alert("숫자찍어보세 : " + object.wno);// 페이징 처리가 제대로 안되서 
			$("#loginID").val(object.loginID);
			$("#loginID").attr("readonly", true); // 작성자 수정불가 
			
			$("#notice_moddate").val(object.notice_moddate);
			$("#notice_moddate").attr("readonly", true); // 처음 작성된 날짜 수정불가 
		
			$("#notice_title").val(object.notice_title);
			$("#notice_content").val(object.notice_content);
			
			$("#notice_no").val(object.notice_no); // 중요한 num 값도 숨겨서 받아온다. 		
	
			if(fobject != "NOT") {			          
				$("#filedown").empty().append("<a href='javascript:filedown("+ fobject.notice_no + ")'>" + fobject.file_ofname + "</a>");				                                 
			} 									

			$("#btnDeleteNotice").show(); // 삭제버튼 보이기 
			$("#btnSaveNotice").hide();
			$("#btnUpdateNotice").css("display", "");

		}
	}
	
	// 첨부파일 다운
	function filedown(notice_no){
 	 	var params = "";
		params += "<input type='hidden' name='notice_no' value='"+ notice_no +"' />"; 	
		jQuery("<form action='/scm/fileDown.do' method='post'>"+params+"</form>").appendTo('body').submit().remove(); 			
	}
	
	// 팝업내 수정, 저장 validation 
	function fValidatePopup() {
		var chk = checkNotEmpty([ [ "notice_title", "제목을 입력해주세요!" ],
				                  [ "notice_content", "내용을 입력해주세요!" ] ]);
		if (!chk) {
			return;
		}
		return true;
	}

	// 공지사항 등록(저장) 
	function fSaveNotice() {

		//alert("저장 함수 타는지!!!!!?? ");
		// validation 체크 
		if (!(fValidatePopup())) {
			return;
		}

		var resultCallback3 = function(data) {
			fSaveNoticeResult(data);
		};

		$("#action").val("I"); // insert
		var frm = document.getElementById("myNotice");
		var dataWithFile = new FormData(frm);	
		

		callAjaxFileUploadSetFormData("/scm/noticeSave.do", "post", "json", true, dataWithFile, resultCallback3);

		// $("#myNotice").serialize() => 직렬화해서 name 값들을 그냥 넘김.
	}

	// 저장 ,수정, 삭제 콜백 함수 처리 
	function fSaveNoticeResult(data) {
		var currentPage = currentPage || 1;

		if ($("#action").val() != "I") {
			currentPage = $("#currentPage").val();
		}

		if (data.resultMsg == "SUCCESS") {
			//alert(data.resultMsg);	// 받은 메세지 출력 
			alert("저장 되었습니다.");
		} else if (data.resultMsg == "UPDATE") {
			alert("수정 되었습니다.");
		} else if (data.resultMsg == "DELETE") {
			alert("삭제 되었습니다.");
		} else {
			alert(data.resultMsg); //실패시 이거 탄다. 
			alert("실패 했습니다.");
		}

		gfCloseModal(); // 모달 닫기
		selectNoticeList(currentPage); // 목록조회 함수 다시 출력 
		frealPopModal();// 입력폼 초기화
	}

	// 공지사항 등록(수정) 
	function fUpdateNotice() {

		//alert("수정  함수 타는지!!!!!?? ");
		// validation 체크 
		if (!(fValidatePopup())) {
			return;
		}

		var resultCallback3 = function(data) {
			fSaveNoticeResult(data);
		};

		$("#action").val("U"); // update
		var frm = document.getElementById("myNotice");
		var dataWithFile = new FormData(frm);	
		

		callAjaxFileUploadSetFormData("/scm/noticeSave.do", "post", "json", true, dataWithFile, resultCallback3);
		// $("#myQna").serialize() => 직렬화해서 name 값들을 그냥 넘김.
	}

	// 공지사항 게시판 1건 삭제 
	function fDeleteNotice() {
		var con = confirm("정말 삭제하겠습니까? \n 삭제시 복구불가합니다.");
		if (con) {
			var resultCallback3 = function(data) {
				fSaveNoticeResult(data);
			}
			$("#action").val("D"); // delete
			callAjax("/scm/noticeSave.do", "post", "json", true, $(
					"#myNotice").serialize(), resultCallback3);
			// num만 넘겨도되지만 그냥 귀찮으니깐...^^... 
		} else {
			gfCloseModal(); // 모달 닫기
			selectNoticeList(currentPage); // 목록조회 함수 다시 출력 
			frealPopModal();// 입력폼 초기화
		}
	}
	
	/* 	// 검색날짜 기본값 설정 from_date = 3달전 , to_date = 오늘날짜
 	$(document).ready(function() { 		
 	  document.getElementById('to_date').value = new Date().toISOString().substring(0, 10);
	  var from_date = new Date;
	  from_date.setMonth(from_date.getMonth()-3);
	  document.getElementById('from_date').value = from_date.toISOString().substring(0, 10);
	  //searchBtn.click();

 	}) */
	
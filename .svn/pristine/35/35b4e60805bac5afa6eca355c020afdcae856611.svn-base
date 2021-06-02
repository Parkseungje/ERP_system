
	// 페이징 설정 
	var noticePageSize = 10; // 화면에 뿌릴 데이터 수 
	var noticePageBlock = 5; // 블럭으로 잡히는 페이징처리 수

	// onload 이벤트  
	$(function() {
		// 반품 지시서  리스트 뿌리기 함수 
		selectrefundInsList();

		// DatePicker
		fDatePicker();			

	});
	
	// 날짜 변한 함수  
 	function getFormatDate(date){
	    var year = date.getFullYear();              //yyyy
	    var month = (1 + date.getMonth());          //M
	    month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
	    var day = date.getDate();                   //d
	    day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
	    return  year + '-' + month + '-' + day;       //'-' 추가하여 yyyy-mm-dd 형태 생성 가능
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
	function selectrefundInsList(currentPage) {

		currentPage = currentPage || 1; // or		

		//alert("지금 현재 페이지를 찍어봅시다. " + currentPage);

		var param = {
			currentPage : currentPage,
			pageSize : noticePageSize
		}

		var resultCallback = function(data) { // 데이터를 이 함수로 넘깁시다. 
			refundInsListResult(data, currentPage);
		}
		

		
		callAjax("/ged/profitAndLossList.do", "post", "text", true, param,
				resultCallback);
		

	}

	
	// 공지사항 리스트 data를 콜백함수를 통해 뿌린다.  
	function refundInsListResult(data, currentPage) {

		// 일단 기존 목록을 삭제합니다. (변경시 재부팅 용)
		$("#palList").empty();
		//alert("데이터!!! " + data);
		//console.log("data !!!! " +  data);

		//var $data = $( $(data).html() ); // data의 .html()통해서 html구문을 끌어온다.
		//alert("데이터 찍어보자!!!! " +  $data); // object

		$("#palList").append(data);

		// 리스트의 총 개수를 추출합니다. 
		//var totalCnt = $data.find("#totalCnt").text();
		var totalCnt = $("#totalCnt").val(); // qnaRealList() 에서보낸값 
		//alert("totalCnt 찍어봄!! " + totalCnt);

		// * 페이지 네비게이션 생성 (만들어져있는 함수를 사용한다 -common.js)
		// function getPaginationHtml(currentPage, totalCount, pageRow, blockPage, pageFunc, exParams)
		// 파라미터를 참조합시다. 
		//var listnum = $("#tmpListNum").val();
		var pagingnavi = getPaginationHtml(currentPage, totalCnt,
				noticePageSize, noticePageBlock, 'selectrefundInsList');

		console.log("pagingnavi : " + pagingnavi);
		// 비운다음에 다시 append 
		$("#pagingnavi").empty().append(pagingnavi); // 위에꺼를 첨부합니다. 

		// 현재 페이지 설정 
		$("#palcurrentPage").val(currentPage);

	}

	// 검색 기능
	function board_search(currentPage) {

		currentPage = currentPage || 1;

		var sname = $('#sname');
		var palD = $('#palD');
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
			pageSize : noticePageSize,
			company : palD.val()
			
		}

		var resultCallback = function(data) {
			refundInsListResult(data, currentPage);
		}
		
		
		callAjax("/ged/profitAndLossList.do", "post", "text", true, param,
				resultCallback);
		$("#palDList").empty();
		
	}

	// 테스트
	/** 상세코드 목록 조회 */
	function fpalDList(currentPage, company) {
		
		currentPage = currentPage || 1;

		// 그룹코드 정보 설정
		$("#palD").val(company);
		var from_date = $('#from_date');
		var to_date = $('#to_date');
				var param = {
					user_company : company
				,	currentPage : currentPage
				,	pageSize : noticePageSize
				,   from_date : from_date.val()
				, to_date : to_date.val()
		}
		
		var resultCallback = function(data) {
			fpalDListResult(currentPage, data);
		};
		
		callAjax("/ged/profitAndLossDList.do", "post", "text", true, param, resultCallback);
	}
	
	
	/** 상세코드 조회 콜백 함수 */
	function fpalDListResult(currentPage, data) {
		
		// 일단 기존 목록을 삭제합니다. (변경시 재부팅 용)
		$("#palDList").empty();
		//alert("데이터!!! " + data);
		//console.log("data !!!! " +  data);

		//var $data = $( $(data).html() ); // data의 .html()통해서 html구문을 끌어온다.
		//alert("데이터 찍어보자!!!! " +  $data); // object

		$("#palDList").append(data);

		// 리스트의 총 개수를 추출합니다. 
		//var totalCnt = $data.find("#totalCnt").text();
		var totalCnt = $("#totalCnt").val(); // qnaRealList() 에서보낸값 
		//alert("totalCnt 찍어봄!! " + totalCnt);

		// * 페이지 네비게이션 생성 (만들어져있는 함수를 사용한다 -common.js)
		// function getPaginationHtml(currentPage, totalCount, pageRow, blockPage, pageFunc, exParams)
		// 파라미터를 참조합시다. 
		var list = $("#palD").val();
		//var listnum = $("#tmpListNum").val();
		var pagingnavi = getPaginationHtml(currentPage, totalCnt,
				noticePageSize, noticePageBlock, 'fpalDList', [ list ]);

		console.log("pagingnavi : " + pagingnavi);
		// 비운다음에 다시 append 
		$("#pagingnaviD").empty().append(pagingnavi); // 위에꺼를 첨부합니다. 

		// 현재 페이지 설정 
		$("#palDcurrentPage").val(currentPage);
	}
	






	
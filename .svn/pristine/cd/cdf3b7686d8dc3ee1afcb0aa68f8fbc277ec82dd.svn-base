<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Job Korea :: 근태 현황 조회</title>

<!-- sweet alert import -->
<script src='${CTX_PATH}/js/sweetalert/sweetalert.min.js'></script>
<!-- 공통 js/css src 모은 jsp -->
<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>
<!-- fullCalendar css import -->
<link rel="stylesheet" type="text/css" href="${CTX_PATH}/css/fullcalendar/main.css" />
<!-- fullCalendar js import -->
<script src='${CTX_PATH}/js/fullcalendar/main.js'></script>
<script src='${CTX_PATH}/js/fullcalendar/ko.js'></script>
<script src='${CTX_PATH}/js/fullcalendar/moment.js'></script>

<script type="text/javascript">
	var calendarEl;
	var calendar;
	var empTaList;
	
	document.addEventListener('DOMContentLoaded', function() {
	    	calendarEl = document.getElementById('calendar');
    		calendar = new FullCalendar.Calendar(calendarEl, {
    	    initialView: 'dayGridMonth',
    	    contentHeight: 'auto',
    	    locale : 'ko',
    	    headerToolbar: {
    	      left : '',
    	      center: 'prev title next',
    	      right : 'today'
    	    },
    	   	events : function (info, callback){
    	   		$.ajax({
    	   			url : '/employee/empTaList.do',
    	   			type : 'POST',
    	   			data : {
    	   				  startDate: moment(info.start).format('YYYY-MM-DD')
    	   				, endDate: moment(info.end).format('YYYY-MM-DD')   				
    	   			},
    	   			dataType : 'json',
    	   			success : function(data){
    	   				var list = data.empTaList;
    	   				empTaList = [];
    	   				for(var i = 0; i < list.length; i++){
    	   					
	    	   					var ta_ynColor = "";
	    	   					if(list[i].ta_yn == '1'){
	    	   						ta_ynColor = "#ff0000";
	    	   					}else if (list[i].ta_yn == '2'){
	    	   						ta_ynColor = "#006600";
	    	   					}else if (list[i].ta_yn == '3'){
	    	   						ta_ynColor = "#800080";
	    	   					} 
	    	   					
	    	   					var ta_yn = "";
	    	   					if(list[i].ta_yn == '1'){
	    	   						ta_yn = "승인대기";
	    	   					}else if (list[i].ta_yn == '2'){
	    	   						ta_yn = "승인";
	    	   					}else if (list[i].ta_yn == '3'){
	    	   						ta_yn = "반려";
	    	   					}
	    	   					
	    	   				var taList = {	
	    	   					// 이벤트 추가
    	   				        title : ta_yn +' '+list[i].ta_yn_cnt+ '건 ',
    	   				        start : list[i].ta_reg_date,
    	   				        color : ta_ynColor,
    	   				        textColor : 'white',
    	   				        allDay : true,
    	   					};
	    	   				empTaList.push(taList);
    	   				}//for문
	    	   			callback(empTaList);
    	   			}//success
    	   		});//ajax 
    	   	}, //events
    	   	eventClick : function(info){
    	   		var taDate = moment(info.event.start).format('YYYY-MM-DD');
    	   		var ta_info = info.event.title.split(' ');
    	   		var ta_info2 = ta_info[0];
    	   		var ta_yn_kind;
    	   		if (ta_info2 == '승인대기'){
    	   			ta_yn_kind = 1;
    	   		}else if (ta_info2 == '승인'){
    	   			ta_yn_kind = 2;
    	   		}if (ta_info2 == '반려'){
    	   			ta_yn_kind = 3;
    	   		}
    	   		
    	   		var ta_datail_title = '';
				$('#ta_detail_title').empty();
				ta_datail_title += '<strong>' + taDate + ' ' + ta_info2 + ' 건 현황</strong>';
				$('#ta_detail_title').append(ta_datail_title);
    	   		
    	   		$.ajax({
    	   			url : '/employee/empTaDetailList.do',
    	   			type : 'POST',
    	   			data : {
    	   				  taDate : taDate
    	   				, ta_yn : ta_yn_kind  				
    	   			},
    	   			dataType : 'json',
    	   			success : function(data){
						var detailList = data.empTaDetailList;
						var ta_detailList = '';
						for(var i = 0; i < detailList.length; i++){
							$('#ta_detail').empty();
							ta_detailList += '<tr>';
							ta_detailList += '<td>'+ detailList[i].dept_name + '</td>';
							ta_detailList += '<td>'+ detailList[i].name + '</td>';
							ta_detailList += '<td>'+ detailList[i].kind_hol + '</td>';
							ta_detailList += '</tr>';
							
							$('#ta_detail').append(ta_detailList);
						} //for
						
						gfModalPop('#layer1');
    	   			}//success
    	   		});//ajax 
    	   	}//eventClick
	    });
	    calendar.render();
	    
   	});
	
	
</script>
</head>
<body>

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
							class="btn_nav bold">인사•급여</span> <span class="btn_nav bold">근태현황조회</span> <a href="/employee/empMgt.do" class="btn_set refresh">새로고침</a>
					</p>

					<p class="conTitle">
						<span>근태 현황 조회</span> 
					</p>
					<div id='calendar'></div>
					</div> <!--// content -->
				<h3 class="hidden">풋터 영역</h3>
					<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
			</li>
		</ul>
	</div>
</div>

<!-- 모달팝업 -->
<div id="layer1" class="layerPop layerType2" style="width: 500px;">
	<dl>
		<dt id = "ta_detail_title">
		</dt>
		<dd class="content">
			<!-- s : 여기에 내용입력 -->
			<div style = "overflow-y : auto; overflow-x : hidden; height : 300px; width : 443px;">
				<table class="col">
					<caption>caption</caption>
					<colgroup>
						<col width="30%">
						<col width="30%">
						<col width="35%">
					</colgroup>
					<thead>	
						<tr>
							<th scope = "col">부서</th>
							<th scope = "col">사원명</th>
							<th scope = "col">신청구분</th>
						</tr>
					</thead>
					<tbody id = "ta_detail">
					</tbody>
				</table>
			</div>
		</dd>
	</dl>
	<a href="" class="closePop"><span class="hidden">닫기</span></a>
</div>
</body>
</html>
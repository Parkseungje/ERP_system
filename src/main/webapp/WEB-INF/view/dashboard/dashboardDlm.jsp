<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>study | 배송담당자 페이지</title>

<!-- full calendar import -->
<link href='${CTX_PATH}/css/fullcalendar/main.css' rel='stylesheet' />
<script src='${CTX_PATH}/js/fullcalendar/main.js'></script>
<script src='${CTX_PATH}/js/fullcalendar/ko.js'></script>

<!-- sweet alert import -->
<script src='${CTX_PATH}/js/sweetalert/sweetalert.min.js'></script>

    <script>
    var calendarEl;
    var calendar;
		// 첫 로딩 시 호출되는 곳
      document.addEventListener('DOMContentLoaded', function() {
    	  
    	  
		calendarEl = document.getElementById('calendar');
        calendar = new FullCalendar.Calendar(calendarEl, {
		  initialView: 'dayGridMonth',
		  contentHeight: 'auto',
		  locale: 'ko',
		  dayMaxEventRows : 4,
		  dateClick: function(info) {
			// 배경색 바꾸기
			  $(".fc-month-view .fc-day").removeClass("selected");
			  $(info.dayEl).addClass("selected");
			  
			// 선택된 날짜의 이벤트 목록 가져오기
			  let str2arr = info.dateStr.split("-");
			  let s_date_obj = new Date(str2arr[0], str2arr[1] - 1, str2arr[2]);

			  let s_year = s_date_obj.getFullYear(); // 선택된날짜 연도
			  let s_month = s_date_obj.getMonth() + 1; // 선택된날짜 월
			  let s_date = s_date_obj.getDate(); // 선택된날짜 일
			  
			  const fullDate = s_year+'/'+s_month+'/'+s_date
			  $.ajax({
			    url: "/dashboard/shippingList.do",
			    type: "POST",
			    data: {
			    		thisDate : fullDate
			    },
			    dataType: "json",
			    success: function (res) {
			      if (res.length) {
			        // 이벤트 목록이 있을 때
			        var text = '';
			        for (var i =0; i<res.length;i++){
			        		text+= (i+1)+'. '+ res[i].user_company+'로 배송되는 '+res[i].ship_qty+'개의'+res[i].pro_name +' \n'
			        		text+= '[진행상황] : ' + res[i].ship_cd+'\n\n'
			        		text+= '[주문자] : ' + res[i].name+'\n\n'
			        }
			        swal(text);
			      } else {
			        // 이벤트 목록이 없을 때
			      }
			    }
			  });
			}
		});
		calendar.render();
        
     // 일정 조회
		fCalendar();
        
      });
 
      /** 일정 조회 */
  	function fCalendar() {
    	var param = { 
    			action : "getCalendar"
    	}  
  		var resultCallback = function(data) {
  			fCalendarResult(data);
  		};
  		//Ajax실행 방식
  		//callAjax("Url",type,return,async or sync방식,넘겨준거,값,Callback함수 이름)
  		callAjax("/dashboard/shippingList.do", "post", "json", true, param, resultCallback);
  	}
      
  	/** 일정 조회 콜백 함수 */
	function fCalendarResult(data) {
		console.log(data);
		fRedrawCalendar(data);

	}
  	
	/** 캘린더 그리기 함수 */
	function fRedrawCalendar(data) {
		for (var i=0;i<data.length;i++){
			calendar.addEvent( {
				'title':''+data[i].user_company+'에서 주문한 '+data[i].pro_name+'', 
				'start':''+data[i].ship_date+'', 
				});
		}
	}
      
    </script>
  </head>
  <body>
    <div id='calendar'></div>
  </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<script>
	/*그래프 데이터 변수 선언*/
	var dateArr = new Array();  //일별날짜
	var salesArr = new Array();  //매출
	var cumsalesArr = new Array(); //매출총이익
</script>
<c:forEach items="${listDaySalesChartModel}" var="list">
	<script>
		dateArr.push("${list.order_date}");
		salesArr.push("${list.sum_sales}");
		cumsalesArr.push("${list.cumsum_sales}");
	</script>
</c:forEach>


<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
google.charts.load('current', {packages: ['corechart']});
google.charts.setOnLoadCallback(drawChart);


function drawChart() {
	
	var data = new google.visualization.DataTable();
	data.addColumn('string','Date');
	data.addColumn('number','매출');
	data.addColumn('number','누적매출');
	
	for(var i=0;i<dateArr.length;i++){
		data.addRow([dateArr[i].substring(2),parseInt(salesArr[i]),parseInt(cumsalesArr[i])]);
	}
	var options = {
			legend: {'position':'top','alignment':'center'},
            height:400,
            label:'top',
            hAxis: {showTextEvery: 1,
            	fontSize:'5',
            	slantedText: true,
            	slantedTextAngle:45}, 
            vAxes: {0: {
            	title:'단위:십만원'
            }, 
            1: {
            	title:'단위:십만원'
            }},
            chartArea : {
				height: '70%',
				width : '60%'
			},
			animation : { //차트가 뿌려질때 실행될 애니메이션 효과
				startup : true,
				duration : 1000,
				easing : 'linear'
			},
			seriesType : 'bars',
			color:'blue',
			series : {1: {type:'line',
						  targetAxisIndex: 1,
						  color:'red'}}
          };

    var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));

    chart.draw(data, options);
	}
</script> 

<div id="chart_div"></div>             
      


				
							
						
							
							
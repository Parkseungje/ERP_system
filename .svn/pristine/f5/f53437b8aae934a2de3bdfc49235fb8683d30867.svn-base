<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	var dateArr = new Array();  //날짜
	var salesArr = new Array();  //매출
	var sproArr = new Array();  //영업이익
	var sproRateArr = new Array();  //영업이익률
</script>


<c:forEach items="${listMSalesModel}" var="list">
	<script>
	dateArr.push("${list.order_date}");  //날짜
	salesArr.push("${list.sum_sales}");  //매출
	sproArr.push("${list.sales_profit}");  //영업이익
	sproRateArr.push("${list.salesProfit_rate}");  //영업이익률
	</script>
</c:forEach>

<script>
google.charts.load('current', {packages: ['corechart']});
google.charts.setOnLoadCallback(drawChart);

//평균구하기
function average(array) {
	  var sum = 0.0;

	  for (var i = 0; i < array.length; i++)
	    sum += parseFloat(array[i]);

	  return Math.round(sum / array.length*100)/100;
	}

//구글차트 
function drawChart() {
	var data = new google.visualization.DataTable();
	data.addColumn('string','Date');
	data.addColumn('number','매출');
	data.addColumn('number','영업이익');
	data.addColumn('number','영업이익률');
	
	
	for(var i=0;i<dateArr.length;i++){
		data.addRow([dateArr[i],parseInt(salesArr[i]),parseInt(sproArr[i]),parseFloat(sproRateArr[i])]);
	}
    
    var options = {
            
            vAxes: {
                0:{
                	title:'단위:십만원'

            }, 
            	1:{
            		minValue: -100,
                    maxValue: 100,
                    title:'%'
            }},
            chartArea : {
				//height: '90%',
				width : '60%'
			},
			animation : { //차트가 뿌려질때 실행될 애니메이션 효과
				startup : true,
				duration : 1000,
				easing : 'linear'
			},
			seriesType : 'bars',
			series : {2: {type:'line',
						  targetAxisIndex: 1}}
          };

    var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));

    chart.draw(data, options);
  }
</script>

<div id="chart_div"></div>


	
             
      











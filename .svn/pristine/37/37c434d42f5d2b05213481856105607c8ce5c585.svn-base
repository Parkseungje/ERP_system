<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="https://www.gstatic.com/charts/loader.js"></script>


<script>
	var dateArr = new Array();  //년도
	var netproArr = new Array();    //당기순이익
	var sproArr = new Array();     //영업이익
	var salesArr = new Array();   //매출
	var salaryArr = new Array();    //인건비
	var etcArr = new Array();   //기타지출비
</script>

<c:forEach items="${listYSalesModel}" var="list">
	<script>
		dateArr.push("${list.order_date}");	//년도
		netproArr.push(parseInt("${list.net_profit}"));	//당기순이익
		sproArr.push(parseInt("${list.sales_profit}"));	 //영업이익
		salesArr.push(parseInt("${list.sum_sales}"));	//매출
		salaryArr.push(parseInt("${list.salary_cost}"));	//인건비
		etcArr.push(parseInt("${list.etc_cost}"));	 //기타지출비
	</script>
</c:forEach>

<script type="text/javascript">
google.charts.load('current', {packages: ['corechart','bar']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
	 
	 var data = new google.visualization.DataTable();
	 data.addColumn('string', '');
	 
	 for (var i=0; i < dateArr.length; i++) {
		 data.addColumn('number', dateArr[i]);
		 }
	
	 data.addRow(['당기순이익',netproArr[0],netproArr[1],netproArr[2]]);
	 data.addRow(['영업이익',sproArr[0],sproArr[1],sproArr[2]]);
	 data.addRow(['매출',salesArr[0],salesArr[1],salesArr[2]]);
	 data.addRow(['인건비',salaryArr[0],salaryArr[1],salaryArr[2]]);
	 data.addRow(['기타지출비',etcArr[0],etcArr[1],etcArr[2]]);
		

		var options = {
				vAxis : {
					title : '금액(단위:십만원)',
					viewWindow: { max: 220000, min:-50000 },
					gridlines:{count:5}
				},
			chartArea : {
				//height: '90%',
				width : '60%'
			},
			animation : { //차트가 뿌려질때 실행될 애니메이션 효과
				startup : true,
				duration : 1000,
				easing : 'linear'
			},
			seriesType : 'bars'
		};

		var chart = new google.visualization.ComboChart(document
				.getElementById('chart_div'));

		chart.draw(data, options);
	}
</script> 

<div id="chart_div"></div>     
      


				
							
						
							
							
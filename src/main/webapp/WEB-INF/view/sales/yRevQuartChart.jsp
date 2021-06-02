<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="https://www.gstatic.com/charts/loader.js"></script>


<script>
	var dateArr = new Array();  //년도
	var onsalesArr = new Array();  //온라인매출
	var offsalesArr = new Array();   //오프라인매출
	var sproArr = new Array();  //영업이익
	var sproRateArr = new Array();  //영업이익률
</script>

<c:forEach items="${listYSalesModel}" var="list">
	<script>
	dateArr.push("${list.order_date}");
	onsalesArr.push("${list.on_sales}");
	offsalesArr.push("${list.off_sales}");
	sproArr.push("${list.sales_profit}");
	sproRateArr.push("${list.salesProfit_rate}");	
	</script>
</c:forEach>
<c:forEach items="${listYSalesModel}">
	<script>
	offsalesArr.push("${list.off_sales}");
	</script>
</c:forEach>


<script type="text/javascript" var="list">
google.charts.load('current', {packages: ['corechart']});
google.charts.setOnLoadCallback(drawChart);


function drawChart() {

	var data = new google.visualization.DataTable();
		data.addColumn('string', 'Date');
		data.addColumn('number', '온라인');
		data.addColumn('number', '오프라인');
		data.addColumn('number', '영업이익');
		data.addColumn('number', '영업이익률');

		for (var i = 0; i < dateArr.length; i++) {
			data.addRow([ dateArr[i], parseInt(onsalesArr[i]),parseInt(offsalesArr[i]), parseInt(sproArr[i]),parseFloat(sproRateArr[i])]);
		}

		var options = {
			vAxes : [ {
				title : '금액(단위:십만원)'
			}, {
				title : '%'
			} ],
			colors : [ 'blue', 'red', 'green' ],
			seriesType : 'bars',
			legend : {
				position : 'top'
			},
			series : {
				0 : {
					targetAxisIndex : 0
				},
				3 : {
					targetAxisIndex : 1,
					type : 'line',
					color : 'purple'
				}
			},
			animation : { //차트가 뿌려질때 실행될 애니메이션 효과
				startup : true,
				duration : 1000,
				easing : 'linear'
			}
		};

		var chart = new google.visualization.ComboChart(document
				.getElementById("chart_div"));
		chart.draw(data, options);
	}
</script> 

<div id="chart_div"></div>     
      


				
							
						
							
							
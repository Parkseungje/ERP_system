<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- chart import -->
<script type="text/javascript" src="${CTX_PATH}/js/apexcharts/apexcharts.js"></script>

<!-- chart import css-->
<link rel="stylesheet" type="text/css" href="${CTX_PATH}/css/apexcharts/apexcharts.css">

<!-- font awesome css -->
<link rel="stylesheet" type="text/css" href="${CTX_PATH}/js/statistics/css/font-awesome.min.css">



<script src="${CTX_PATH}/js/view/dashboard/ged/dashboardGed.js"></script>


<style>

.canvas {
    padding-left: 0;
    padding-right: 0;
    margin-left: auto;
    margin-right: auto;
    display: block;
    
}
.first {
float:left;
margin-left: 1%;
}
.third{
float:right;
margin-right: 1%;
margin-bottom: 3%
}

</style>

</head>
<body>

				<p class="conTitle" style="margin-top: 1%">
					<span>월간 수익</span> <span class="fr"> 
					</span>
				</p>

		<div id="salesLineChart" class="canvas" style="height:300px; width:90%"></div>
		

				<p class="conTitle" style="margin-top: 1%">
					<span>이달의 매출 현황</span> <span class="fr"> 
					</span>
				</p>



		<div id="companyChart" class="first" style=" width:50%"></div>

	
<!-- 		<canvas id=companyTopChart class="first" style="height:300px; width:50%"></canvas>
 -->
	<!-- 	<canvas id=productTopChart class="third" style="height:300px; width:45%"></canvas>
 -->

		<div id="chart" style="width:40%;float:right;"></div>	
		
		
		<div id="beforeInit" style="height:400px;"></div>

</body>
</html>
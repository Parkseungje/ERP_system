<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>



	<table class="col">
		<caption>caption</caption>
		<colgroup>
			<col width="10%">
			<col width="12%">
			<col width="12%">
			<col width="12%">
		</colgroup>


		<thead>
			<tr>
				<th scope="col"></th>
				<c:forEach items="${listMSalesModel}" var="list">
					<th scope="col">${list.order_date}</th>
				</c:forEach>
			</tr>
		</thead>
	
		<tbody id="listmmRevenue">
			<tr>
				<th scope="col">매출</th>
				<c:forEach items="${listMSalesModel}" var="list">
					<td>${list.sum_sales}</td>
				</c:forEach>
			</tr>
			<tr>
				<th scope="col">매출원가</th>
				<c:forEach items="${listMSalesModel}" var="list">
					<td>${list.sum_cost}</td>
				</c:forEach>
			</tr>
			<tr>
				<th scope="col">매출총이익</th>
				<c:forEach items="${listMSalesModel}" var="list">
					<td>${list.margin}</td>
				</c:forEach>
			</tr>
			<tr>
				<th scope="col">영업이익</th>
				<c:forEach items="${listMSalesModel}" var="list">
					<td>${list.sales_profit}</td>
				</c:forEach>
			</tr>
			<tr>
				<th scope="col">영업이익률</th>
				
				<c:forEach items="${listMSalesModel}" var="list">
					<script>sproRateArr.push("${list.salesProfit_rate}");</script>
					<c:if test="${list.salesProfit_rate gt 0}">
						<td style="color:blue">▲<c:out value="${list.salesProfit_rate}" /></td>
					</c:if>
					<c:if test="${list.salesProfit_rate le 0}">
						<td style="color:red">▼<c:out value="${list.salesProfit_rate}" /></td>
					</c:if>
				
				</c:forEach>
				
				<td><span id="avg_proRate"></span></td>
				<script>
					proRateAvg = average(sproRateArr);
					if(proRateAvg>0) {
						document.getElementById("avg_proRate").innerHTML="▲"+proRateAvg;
						document.getElementById("avg_proRate").style.color = 'blue';
					}
					else {
						document.getElementById("avg_proRate").innerHTML="▼"+proRateAvg;
						document.getElementById("avg_proRate").style.color = 'red';
					}
				</script>
			</tr>
		</tbody>
	</table>
	
             
      











<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="https://www.gstatic.com/charts/loader.js"></script>

<table class="col">
	<colgroup>
		<col width="6%">
		<col width="10%">
		<col width="10%">
		<col width="10%">
	</colgroup>


	<thead>
		<tr>
			<th scope="col"></th>
			<c:forEach items="${listYSalesModel}" var="list">
				<th scope="col">${list.order_date}</th>
				<script>
					dateArr.push("${list.order_date}");
				</script>
			</c:forEach>
		</tr>
	</thead>

	<tbody id="listyyRevenue">
		<tr>
			<th scope="col">당기순이익</th>
			<c:forEach items="${listYSalesModel}" var="list">
				<td>${list.net_profit}</td>
			</c:forEach>
		</tr>
		<tr>
			<th scope="col">영업이익</th>
			<c:forEach items="${listYSalesModel}" var="list">
				<td>${list.sales_profit}</td>
			</c:forEach>
		</tr>
		<tr>
			<th scope="col">매출</th>
			<c:forEach items="${listYSalesModel}" var="list">
				<td>${list.sum_sales}</td>
			</c:forEach>
		</tr>
		<tr>
			<th scope="col">인건비</th>
			<c:forEach items="${listYSalesModel}" var="list">
				<td>${list.salary_cost}</td>
			</c:forEach>
		</tr>
		<tr>
			<th scope="col">기타지출</th>
			<c:forEach items="${listYSalesModel}" var="list">
				<td>${list.etc_cost}</td>
			</c:forEach>
		</tr>
		<tr>
			<th scope="col">전년대비매출성장률</th>
			<c:forEach items="${listYSalesModel}" var="list">
				<c:choose>
					<c:when test="${list.sales_growth gt 0}">
						<td><span style="color: blue">▲${list.sales_growth}%</span></td>
					</c:when>
					<c:when test="${list.sales_growth le 0}">
						<td><span style="color: red">▼${-list.sales_growth}%</span></td>
					</c:when>
				</c:choose>
			</c:forEach>
		</tr>
		<tr>
			<th scope="col">전년대비순이익성장률</th>
			<c:forEach items="${listYSalesModel}" var="list">
				<c:choose>
					<c:when test="${list.profit_growth gt 0}">
						<td><span style="color: blue">▲${list.profit_growth}%</span></td>
					</c:when>
					<c:when test="${list.profit_growth le 0}">
						<td><span style="color: red">▼${-list.profit_growth}%</span></td>
					</c:when>
				</c:choose>
			</c:forEach>
		</tr>
	</tbody>
</table>














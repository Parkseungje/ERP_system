<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


			<colgroup>
				<col width="10%">
				<col width="12%">
				<col width="12%">
				<col width="12%">
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
			<tbody>
			<tr>
					<th scope="row">주문건수</th>
						<c:forEach items="${listMSalesModel}" var="list">
							<td>${list.order_num}</td>
						</c:forEach>
				</tr>
				<tr>
					<th scope="row">매출</th>
						<c:forEach items="${listMSalesModel}" var="list">
							<td>${list.sum_sales}</td>
						</c:forEach>
				</tr>
				<tr>
					<th scope="row">매출원가</th>
						<c:forEach items="${listMSalesModel}" var="list">
							<td>${list.sum_cost}</td>
						</c:forEach>
				</tr>
				<tr>
					<th scope="row">매출총이익</th>
						<c:forEach items="${listMSalesModel}" var="list">
							<td>${list.margin}</td>
						</c:forEach>
				</tr>
				<tr>
					<th scope="row">영업비</th>
						<c:forEach items="${listMSalesModel}" var="list">
							<td>${list.sales_cost}</td>
						</c:forEach>
				</tr>
				<tr>
					<th scope="row">영업이익</th>
						<c:forEach items="${listMSalesModel}" var="list">
							<td>${list.sales_profit}</td>
						</c:forEach>
				</tr>
				<tr>
					<th scope="row">영업이익률</th>
					<c:forEach items="${listMSalesModel}" var="list">
						<c:choose>
						<c:when test="${list.salesProfit_rate gt 0}">
							<td><span style="color: blue">${list.salesProfit_rate}%</span></td>
						</c:when>
						<c:when test="${list.salesProfit_rate le 0}">
							<td><span style="color: red">▼${-list.salesProfit_rate}%</span></td>
						</c:when>
					</c:choose>
					</c:forEach>
				</tr>
			</tbody>

             
      











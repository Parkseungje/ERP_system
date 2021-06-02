<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 


<table class="col">
		<thead>
			<tr>
				<th scope="col" width="8%"></th>
				<c:forEach items="${listYSalesModel}" var="list">
					<th scope="col" colspan="2">${list.order_date}</th>
				</c:forEach>
			</tr>
			<tr>
				<th scope="col" width="14%"></th>
				<c:forEach items="${listYSalesModel}" var="list">
					<th scope="col" width="7%" style="word-break : break-all;">온라인</th>
					<th scope="col" width="7%" style="word-break : break-all;">오프라인</th>
				</c:forEach>
			</tr>
		</thead>
	
		<tbody id="listmmRevenue">
				<tr>
					<td>주문건수</td>
					<c:forEach items="${listYSalesModel}" var="list">
						<td>${list.on_num}</td>
						<td>${list.off_num}</td>
					</c:forEach>
				</tr>
				<tr>
					<td>매출</td>
					<c:forEach items="${listYSalesModel}" var="list">
						<td>${list.on_sales}</td>
						<td>${list.off_sales}</td>
					</c:forEach>
				</tr>
				<tr>
					<td>영업이익</td>
				<c:forEach items="${listYSalesModel}" var="list">
					<td colspan="2">${list.sales_profit}</td>
				</c:forEach>
				</tr>
				<tr>
					<td>영업이익률</td>
				<c:forEach items="${listYSalesModel}" var="list">
					<c:choose>
					<c:when test="${list.salesProfit_rate gt 0}">
						<td colspan="2"><span style="color: blue">▲${list.salesProfit_rate}%</span></td>
					</c:when>
					<c:when test="${list.salesProfit_rate le 0}">
						<td colspan="2"><span style="color: red">▼${-list.salesProfit_rate}%</span></td>
					</c:when>
				</c:choose>
				</c:forEach>
				</tr>
		</tbody>
	</table>	
	
             
      











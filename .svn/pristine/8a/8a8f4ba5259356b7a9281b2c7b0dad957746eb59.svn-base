<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
					<div class="divEmpty" style="overflow:scroll:auto; width:300px; height:150px; padding:10px; background-color:gold;">
						<table class="col">
							<thead>
								<tr>
		                                 <th scope="col">pc 번호</th>
		                                 <th scope="col">사용자 ID</th>
		                                 <th scope="col">일련번호</th>
		                                 <th scope="col">PC 총 사용금액</th>
		                                 <th scope="col">음식 주문 금액</th>
		                                 <th scope="col">합계금액</th>
		                                 <th scope="col">완납여부</th>
								</tr>
							</thead>
							<tbody id="paymentamt">
							<c:forEach items="${userAmt}" var="payment">
								<tr>
									<td>${payment.pc_no}</td>
									<td>${payment.loginID}</td>
									<td>${payment.seq}</td>
									<td>${payment.pcuseamt}</td>
									<td>${payment.foodamt}</td>
									<td>${payment.totalamt}</td>
									<td>${payment.cpl_yn}</td>
									<td>
	                                   <a class="btnType3 color1" href="javascript:fPopModalUserPayment('${payment.pc_no}','${payment.loginID}','${payment.seq}');"><span>결제</span></a>
	                               </td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
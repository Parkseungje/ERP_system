<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>					
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${empPaymentTotalCnt eq 0 }">
	<tr>
		<td colspan="15">데이터가 존재하지 않습니다.</td>
	</tr>
</c:if>

<c:if test="${empPaymentTotalCnt > 0 }">
	<c:set var="nRow" value="${pageSize*(currentPageEmpPayment-1)}" />
	<c:forEach items="${listEmployeeModel}" var="list">
		<tr>
			<c:if test="${list.payment_date != null || list.payment_date ne null }">
				<td class = "paymentTd" style = "font-size : 90%;">${list.payment_date }</td>
			</c:if>
			<c:if test="${list.payment_date == null || list.payment_date eq null}">
				<td class = "paymentTd" style = "font-size : 90%;"> - </td>
			</c:if>
			<td>${list.dept_name}</td>
			<td>${list.poscd}</td>
			<td class = "paymentTd"><a href = "javascript:empDtlPayment(1, '${list.loginID}')">${list.loginID}</a></td>
			<td class = "paymentTd">${list.name }</td>
			<td class = "paymentTd" style = "color : green;">${list.year_salary }</td>
			<td class = "paymentTd" style = "color : green;">${list.salary }</td>
			<c:if test = "${list.nat_ps == '0' || list.nat_ps eq '0' 
						|| list.h_insure == '0' || list.h_insure eq '0' 
						|| list.ohs_insure == '0' || list.ohs_insure eq '0'
						|| list.e_insure == '0' || list.e_insure eq '0' 
						|| list.income_tax == '0' || list.income_tax eq '0'}">
				<td class = "paymentTd" style = "color : red;">${list.nat_ps }</td>
				<td class = "paymentTd" style = "color : red;">${list.h_insure }</td>
				<td class = "paymentTd" style = "color : red;">${list.ohs_insure }</td>
				<td class = "paymentTd" style = "color : red;">${list.e_insure }</td>
				<td class = "paymentTd" style = "color : red;">${list.income_tax }</td>
			</c:if>
			<c:if test = "${list.nat_ps != '0' || list.nat_ps ne '0'
						|| list.h_insure != '0' || list.h_insure ne '0' 
						|| list.ohs_insure != '0' || list.ohs_insure ne '0'
						|| list.e_insure != '0' || list.e_insure ne '0' 
						|| list.income_tax != '0' || list.income_tax ne '0'}">
				<td class = "paymentTd" style = "color : red;">- ${list.nat_ps }</td>
				<td class = "paymentTd" style = "color : red;">- ${list.h_insure }</td>
				<td class = "paymentTd" style = "color : red;">- ${list.ohs_insure }</td>
				<td class = "paymentTd" style = "color : red;">- ${list.e_insure }</td>
				<td class = "paymentTd" style = "color : red;">- ${list.income_tax }</td>
			</c:if>
			<c:if test = "${list.extra_pay == '0' || list.extra_pay eq '0'}">
				<td class = "paymentTd" style = "color : blue;">0</td>
				<td class = "paymentTd" style = "color : green;">${list.net_pay }</td>
			</c:if>
			<c:if test = "${list.extra_pay != '0' || list.extra_pay ne '0' }">
				<td class = "paymentTd" style = "color : blue;">+ ${list.extra_pay }</td>
				<td class = "paymentTd" style = "color : green;">${list.net_pay }</td>
			</c:if>
			<td class = "paymentTd">
				<c:choose>
					<c:when test = "${list.payment_st == '0' || list.payment_st eq '0' }">
						<a class="btnType3 color2" href="javascript:empPaymentProcess('${list.loginID}')"><span>지급처리</span></a>
					</c:when>
					<c:when test = "${list.payment_st == '1' || list.payment_st eq '1' }">
						<a class="btnType3 color1" href="" style = "pointer-events : none; cursor : default;"><span>지급완료</span></a>
					</c:when>
					<c:when test = "${list.payment_st == '' || list.payment_st eq '' }">
						<a class="btnType3 color1" href="" style = "pointer-events : none; cursor : default;"><span>지급완료</span></a>
					</c:when>
				</c:choose>
			</td>
		</tr>
		<c:set var="nRow" value="${nRow + 1}" />
	</c:forEach>
</c:if>

<input type="hidden" id="empPaymentTotalCnt" name="empPaymentTotalCnt" value ="${empPaymentTotalCnt}"/>
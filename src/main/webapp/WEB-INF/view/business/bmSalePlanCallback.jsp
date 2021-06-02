<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

					
					
							<c:if test="${totalCntBmSalePlan eq 0 }">
								<tr>
									<td colspan="10">데이터가 존재하지 않습니다.</td>
								</tr>
							</c:if>
							
							<c:if test="${totalCntBmSalePlan > 0 }">
								<c:set var="nRow" value="${pageSize*(currentPageBmSalePlan-1)}" />
								<c:forEach items="${listBmSalePlanModel}" var="list">
									<tr>					
										<td>${list.sales_reg_date}</td>		
									<c:if test="${userType eq 'B'}">	
										<td>${list.loginID}</td>
									</c:if>						
										<td>${list.l_ct_nm}</td>
										<td>${list.m_ct_nm}</td>	
										<td>${list.prod_nm}</td>																						
										<td>${list.goal_amt}</td>		
										<td>${list.estimate_cnt}</td>
									<c:if test="${userType eq 'B'}">		
										<td>${list.a_rate}</td>
									</c:if>	
										<td>${list.memo}</td>									
									<c:set var="nRow" value="${nRow + 1}" />
								</c:forEach>
							</c:if>
							
							<input type="hidden" id="totalCntBmSalePlan" name="totalCntBmSalePlan" values="${totalCntBmSalePlan}"/>
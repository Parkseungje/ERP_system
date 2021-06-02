_<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

					
					
							<c:if test="${totalCntEmpDv eq 0 }">
								<tr>
									<td colspan="10">데이터가 존재하지 않습니다.</td>
								</tr>
							</c:if>
							
							<c:if test="${totalCntEmpDv > 0 }">
								<c:set var="nRow" value="${pageSize*(currentPageEmpDv-1)}" />
								<c:forEach items="${listEmpDvModel}" var="list">
									<tr>
										<td><a href="javascript:fPopModalEmpDv('${list.dv_no}')">${list.dv_no}</a></td>				<!-- 결의번호 -->
										<td>${list.group_name}</td>			<!-- 계정대분류명 -->
										<td>${list.detail_account_nm}</td>	<!-- 상세분류명 -->
										<td>${list.acc_name}</td>			<!-- 거래처명 -->
										<td>${list.dv_reg_date}</td>		<!-- 신청일자 -->
										<td>${list.dv_use_date}</td>		<!-- 사용일자 -->
										<td>${list.dv_amt}</td>				<!-- 지출금액 -->
										<td>
										<c:choose>
											<c:when test="${list.dv_app_yn eq '1'}">승인대기중</c:when>
											<c:when test="${list.dv_app_yn eq '2'}">승인</c:when>
											<c:otherwise>반려 </c:otherwise>										
										</c:choose>
										</td>								<!-- 승인여부 -->
										<td>${list.dv_app_date}</td>		<!-- 승인일자 -->
										<td>${list.dv_app_nm}</td>			<!-- 승인자 -->				
									</tr>
									<c:set var="nRow" value="${nRow + 1}" />
								</c:forEach>
							</c:if>
							
							<input type="hidden" id="totalCntEmpDv" name="totalCntEmpDv" values="${totalCntEmpDv}"/>
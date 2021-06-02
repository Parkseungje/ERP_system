<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>					
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
						   <c:set var = "dv_amt_sum" value = "0" />
						   <c:set var = "en_amt_sum" value = "0" />
							<c:if test="${totalCount eq 0 }">
								<tr>
									<td colspan="12">데이터가 존재하지 않습니다.</td>
								</tr>
							</c:if>
							<c:forEach items="${listAccSlipModelModal}" var="list">
									<tr>
										<td>${list.slip_no}</td>					<!-- 전표번호 --> 
										<td>${list.occur_date}</td>			<!-- 수주일자 -->
										<td>${list.receive_no}</td>			<!-- 수주번호  -->
										<td>${list.acc_name}</td>				<!-- 담당자  -->
										<td>${list.acc_name}</td>				<!-- 거래처명  -->
										<td>${list.group_name}</td>			<!-- 계정과목  -->
										<td>${list.dv_amt}</td>					<!-- 지출  -->
										<td>${list.en_amt}</td>					<!-- 수입  -->
										<td>${list.note}</td>						<!-- 비고  -->
									</tr>
								<c:set var= "dv_amt_sum" value="${dv_amt_sum + list.dv_amt}"/>
								<c:set var= "en_amt_sum" value="${en_amt_sum + list.en_amt}"/>
							</c:forEach>
							
							
                           <input type="hidden" id="inamt" name="inamt" value="${dv_amt_sum}"/>
                          <input type="hidden" id="outamt" name="outamt" value="${en_amt_sum}"/>

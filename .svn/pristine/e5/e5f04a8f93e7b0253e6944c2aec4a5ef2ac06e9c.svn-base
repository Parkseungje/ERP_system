<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>					
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

							<c:if test="${totalEmpTaApplyCnt eq 0 }">
								<tr>
									<td colspan="12">데이터가 존재하지 않습니다.</td>
								</tr>
							</c:if>
							<c:set var="nRow" value="${pageSize*(currentPageEmpTaApply-1)}" />
							<c:forEach items="${listEmpTaModel}" var="list">
							<c:if test="${list.ta_yn eq '반려' }">
									<tr>
										<td>${empTaApplyCnt + nRow +1}</td>
										<td>${list.kind_hol}</td>
										<td>${list.start_date}</td>
										<td>${list.end_date}</td>
										<td>${list.h_cnt+1}</td>
										<td>${list.ta_app_nm}</td>
										<td><a href = "javascript:fPopModalEmpTaApplyReturn('${list.ta_no}')" style = "cursor : pointer;">${list.ta_yn}</a></td>
									</tr>
							</c:if>
							<c:if test="${list.ta_yn != '반려' }">
									<tr>
										<td>${empTaApplyCnt + nRow +1}</td>
										<td>${list.kind_hol}</td>
										<td>${list.start_date}</td>
										<td>${list.end_date}</td>
										<td>${list.h_cnt}</td>
										<td>${list.ta_app_nm}</td>
										<td>${list.ta_yn}</td>
									</tr>
							</c:if>
								<c:set var="nRow" value="${nRow + 1}" />
							</c:forEach>
							<input type="hidden" id="totalEmpTaApplyCnt" name="totalEmpTaApplyCnt" value="${totalEmpTaApplyCnt}"/>
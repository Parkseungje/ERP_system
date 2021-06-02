<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
													
															
							
							<c:if test="${totalCntConSupportB eq 0 }">
								<tr>
									<td colspan="5">데이터가 존재하지 않습니다.</td>
								</tr>
							</c:if>
							<c:set var="nRow" value="${pageSize*(currentPage-1)}" />
							<c:forEach items="${userList}" var="list">
								<tr>
									<td><a href="javascript:fListperson(1, '${list.loginID}')">${list.name}</a></td>
									<td>${list.user_describe}</td>
									<td>${list.user_salary}</td>
									<td>${list.user_grade}</td>
									<td>${list.user_hope_work}</td>
									
								</tr>
								<c:set var="nRow" value="${nRow + 1}" />
							</c:forEach>
							
						
						<input type="hidden" id="totalCntDtlList" name="totalCntDtlList" value="${totalCntConSupportB}" />
					
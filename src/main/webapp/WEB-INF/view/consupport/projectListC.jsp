<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

							<c:if test="${totalCntConSupportC eq 0 }">
								<tr>
									<td colspan="5">데이터가 존재하지 않습니다.</td>
								</tr>
							</c:if>
							<c:set var="nRow" value="${pageSize*(currentPage-1)}" />
							<c:forEach items="${listConSupportCModel}" var="list">
								<tr>
									<td><a href="javascript:fListperson(1, '${list.pro_no}')">${list.pro_company}</a></td>
									<td>${list.pro_name}</td>
									<td>${list.pro_appstart}${list.pro_append}</td>
									<td>${list.pro_pcnt}</td>
									
																	
									
								</tr>
								<c:set var="nRow" value="${nRow + 1}" />
							</c:forEach>

					<input type="hidden" id="totcnt" name="totcnt" value="${totalCntConSupportC}" />
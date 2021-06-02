<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>					
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${empTotalCnt eq 0 }">
	<tr>
		<td colspan="9">데이터가 존재하지 않습니다.</td>
	</tr>
</c:if>

<c:if test="${empTotalCnt > 0 }">
	<c:set var="nRow" value="${pageSize*(currentPageEmpList-1)}" />
	<c:forEach items="${listEmployeeModel}" var="list">
		<tr>
			<td><a href="javascript:viewEmpDtl('${list.loginID }')">${list.loginID}</a></td>
			<td>${list.name}</td>
			<td>${list.dept_name}</td>
			<td>${list.poscd}</td>
			<td>${list.entry_date}</td>
			<c:choose>
				<c:when test = "${list.rest_yn == 'n'}"><td>재직</td></c:when>
				<c:when test = "${list.rest_yn == 'y'}"><td>휴직</td></c:when>
				<c:when test = "${list.out_yn == 'y'}"><td>퇴직</td></c:when>
			</c:choose>
			
			<c:if test = "${list.out_yn == 'n' }"><!-- 재직자 리스트 조회일 시 -->
				<td>
					<a class="btnType3 color1" href="javascript:fPopModalResignEmp('${list.loginID}', '${list.name}', '${list.entry_date}');"><span>퇴사처리</span></a>
				</td>
			</c:if>
			<c:if test ="${list.out_yn == 'y' }"> <!-- 퇴직자 리스트 조회일 시 -->
				<td>${list.retire_date}</td>
			</c:if>
		</tr>
		<c:set var="nRow" value="${nRow + 1}" />
	</c:forEach>
</c:if>

<input type="hidden" id="empTotalCnt" name="empTotalCnt" value ="${empTotalCnt}"/>

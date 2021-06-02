<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


				
		<!-- 갯수가 0인 경우  -->
		<c:if test="${userMgmtCnt eq 0 }">
			<tr>
				<td colspan="4">데이터가 존재하지 않습니다.</td>
			</tr>
		</c:if>
		

		<!-- 갯수가 있는 경우  -->
		<c:if test="${userMgmtCnt > 0 }">
			<c:set var="nRow" value="${pageSize*(currentPage-1)}" /> 
			<c:forEach items="${userMgmtList}" var="list">
				<tr>
						<td>
							<c:if test = "${list.user_type == 'A'}"> 관리자 </c:if>
							<c:if test = "${list.user_type == 'B'}"> 일반회원 </c:if>
							<c:if test = "${list.user_type == 'C'}"> 기업회원 </c:if>
						</td>
						<td><a href = "javascript:fuserMgmtdetailModal('${list.loginId}');">${list.name}</a></td>
					    <td>${list.loginId}</td>
						<td>${list.regDate}</td>
	
					<!-- List에 있는 js 함수 호출가능 이거 그대로 가지고 가기 때문에 !!  -->
				</tr>
				 <c:set var="nRow" value="${nRow + 1}" /> 
			</c:forEach>
		</c:if>
		
		<input type="hidden" id="totcnt" name="totcnt" value="${userMgmtCnt}">
		<!-- 이거 중간에 있으면 table 안먹힘  -->

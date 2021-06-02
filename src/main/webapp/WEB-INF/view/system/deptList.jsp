<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


				
		<!-- 갯수가 0인 경우  -->
		<c:if test="${deptCnt eq 0 }">
			<tr>
				<td colspan="4">데이터가 존재하지 않습니다.</td>
			</tr>
		</c:if>
		

		<!-- 갯수가 있는 경우  -->
		<c:if test="${deptCnt > 0 }">
			<c:set var="nRow" value="${pageSize*(currentPage-1)}" /> 
			<c:forEach items="${dept}" var="list">
				<tr>
					    <td><a href="javascript:fDeptModal('${list.dept_cd}');">${list.dept_name}</td> 
						<td>${list.dept_cd}</a></td>
				</tr>
				 <c:set var="nRow" value="${nRow + 1}" /> 
			</c:forEach>
		</c:if>
		
		<!-- 이거 중간에 있으면 table 안먹힘  -->

        <input type="hidden" id="totcnt" name="totcnt" value="${deptCnt}"/>

        
        
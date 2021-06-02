<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


								
			
     				<!-- tbody 제거 , comnGrpList.jsp 참고  -->
							<c:if test="${cliCnt eq 0 }">
								<tr>
									<td colspan="9">데이터가 존재하지 않습니다.</td>
								</tr>
							</c:if>
							
							
							<c:if test="${cliCnt > 0 }">
								<c:set var="nRow" value="${pageSize*(currentPage-1)}" />
		
								<c:forEach items="${clientList}" var="list"  >
									<tr>
										 <td>${list.reg_date}</td>
										 <!-- 거레처이름 누르면 모달1  -->
										 <td><a  href="javascript:BizPartnerModal1('${list.client_cd}')"><strong>${list.client_nm}</strong></a></td>
						                  <td> ${list.addr} ,  ${list.addr_detail }</td>
			                              <td> ${list.tel}</td>
			                              <td> ${list.emp_nm}</td> 
			                              <td> ${list.email}</td>
			                              <td> ${list.emp_hp}</td>
			                              <td> ${list.memo}</td>
			                              
									</tr>
									<c:set var="nRow" value="${nRow + 1}" /> <!-- 페이징 네비게이션 -->
								</c:forEach>
							</c:if>
			
			
			 			
							<input type="hidden"  id="cliCnt"  name="cliCnt"  value="${cliCnt}"/>
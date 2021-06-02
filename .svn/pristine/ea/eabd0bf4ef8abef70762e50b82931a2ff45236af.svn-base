<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


     				<!-- tbody 제거 , comnGrpList.jsp 참고  -->
							<c:if test="${planCnt eq 0 }">
								<tr>
									<td colspan="9">데이터가 존재하지 않습니다.</td>
								</tr>
							</c:if>
							
				
							<c:if test="${planCnt > 0 }">
								<c:set var="nRow" value="${pageSize*(currentPage-1)}" />
		
								<c:forEach items="${listPlan}" var="list"  >
									<tr>
						
										 <td><a  href="javascript:planOne('${list.sales_pro_seq}')" ><strong >${list.sales_reg_date} </strong></a></td>
						                  <td> ${list.client_nm} </td>
						                  <td> ${list.large_classifi} </td>
			                              <td> ${list.small_classifi}</td>
										  <td> ${list.prod_nm}</td>
			                              <td> ${list.goal_amt}</td>  
			                              <td> ${list.estimate_cnt}</td>
			                              <td> ${list.memo}</td>
									</tr>
									<c:set var="nRow" value="${nRow + 1}" /> <!-- 페이징 네비게이션 -->
								</c:forEach>
							</c:if>

							<!-- 단건조회시 카운트와 연관 깊음 --> 			
							<input type="hidden"  id="planCnt"  name="planCnt"  value="${planCnt}"/> 
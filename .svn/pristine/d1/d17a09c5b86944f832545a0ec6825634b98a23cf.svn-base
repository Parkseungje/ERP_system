<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="divEmpty">
   <div class="hiddenData">
   </div>
   <table class="col">
                          
      <tbody id="armngList">
      <c:set var="nRow" value="${pageSize*(admCurrentPage-1)}" />
	         <c:forEach var="list" items="${armngtitle}">  <!-- 컨트롤러에서 정해준 모델 객체이름 -->
	            <tr>
	            	<td>${list.receive_date}</td>
	         		<td>${list.order_cd}</td>
	         		<c:choose>
	         			<c:when test="${not empty list.client_nm}">
							<td>${list.client_nm}</td>
						</c:when>
						<c:when test="${empty list.client_nm}">
							<td>${list.name}</td>
						</c:when>
					</c:choose>
					<td>${list.scm_yn}</td>
					<td><a href="javascript:fPopModalDetail('${list.order_cd}');"><strong>${list.prod_nm}</strong></a></td>
					<td>${list.price}</td>
	            </tr>
	         <c:set var="nRow" value="${nRow + 1}" />
      		 </c:forEach>
      	
      </tbody>     
   </table>
</div>

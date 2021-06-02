<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
                          
      <c:forEach items="${listddAmtSumModel}" var="list"> 
	      <fmt:parseNumber value="${list.rev_total}" var="rev_total" />
	      <fmt:parseNumber value="${list.exp_total}" var="exp_total" />
	      <c:set var="profit" value="${rev_total-exp_total}" />
	            <tr>
	            	 <td>${list.rev_total}</td>
	            	 <td>${list.exp_total}</td>
	            	 <td>${list.ar_total}</td>
	            	 <c:choose>
	            	 	<c:when test="${profit>0}">
	            	 		<td><span style="color:blue">▲${profit}</span></td>
	            	 	</c:when>
	            	 	<c:when test="${profit<0}">
	            	 		<td><span style="color:red">▼${-profit}</span></td>
	            	 	</c:when>
	            	 	<c:otherwise>
	            	 		<td>${profit}</td>
	            	 	</c:otherwise>
	            	 </c:choose>
	            </tr>

      </c:forEach> 


				
							
						
							
							
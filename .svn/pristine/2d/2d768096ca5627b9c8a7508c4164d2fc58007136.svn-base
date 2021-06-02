<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                          
      <c:set var="nRow" value="${pageSize*(currentPageddRevenue-1)}" />
      <c:forEach items="${listDSalesModel}" var="list">
            <tr>
            	 <td>${list.order_date}</td>
            	 <td>${list.state_nm}</td>
		  		 <td>${list.client_cd}</td>
		  		 <td>${list.client_nm}</td>
				 <td>${list.prod_nm}</td>
				 <td>${list.order_cnt}</td>
				 <td>${list.purchase_price}</td>
				 <td>${list.sale_price}</td>
				 <td>${list.tax}</td>
				 <td>${list.pay_price}</td>
            </tr>
            
         <c:set var="nRow" value="${nRow + 1}" />
      </c:forEach> 
      
      <input type="hidden" id="totalCntddRevenue" name="totalCntddRevenue" value ="${totalCntddRevenue}"/>


				
							
						
							
							
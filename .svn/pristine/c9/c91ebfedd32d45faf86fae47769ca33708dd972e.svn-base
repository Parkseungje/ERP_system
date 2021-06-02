<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                          
      <c:set var="nRow" value="${pageSize*(currentPageddRevenue-1)}" />
      <c:forEach items="${listAccSlipModel}" var="list">  <!-- 컨트롤러에서 정해준 모델 객체이름 -->
            <tr>
            	 <td>${list.slip_no}</td>
            	 <td>${list.occur_date}</td>
            	 <td>${list.order_cd}</td>
		  		 <td>${list.client_nm}</td>
				 <td>${list.account_cd}</td>
				 <td>${list.account_nm}</td>
				 <td>${list.detail_account_cd}</td>
				 <td>${list.detail_account_nm}</td>
				 <td>${list.rev_amt}</td>
				 <td>${list.exp_amt}</td>
            </tr>
            
         <c:set var="nRow" value="${nRow + 1}" />
      </c:forEach> 
      
      <input type="hidden" id="totalCntddRevenue" name="totalCntddRevenue" value ="${totalCntddRevenue}"/>


				
							
						
							
							
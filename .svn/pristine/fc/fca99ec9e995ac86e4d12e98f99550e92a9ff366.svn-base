<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


				<!-- 모달이 여러개라 id값 name값 다르게-->
                      <c:forEach items="${oemDetailList}" var="list"  >
       					<tr>
		                 	 <td> ${list.prod_nm} </td>
                             <td> ${list.supply_val}</td>
                             <td> ${list.supply_tax}</td>
                             <td> ${list.supply_cost}</td>  
                             <td> ${list.estimate_cnt}</td>  
						</tr>
			
					</c:forEach>
	   <!-- 모달2 끝 -->

		  		<!-- 단건조회시 카운트와 연관 깊음 --> 			
				<input type="hidden"  id="oemDetailCnt"  name="oemDetailCnt"  value="${oemDetailCnt}"/> 

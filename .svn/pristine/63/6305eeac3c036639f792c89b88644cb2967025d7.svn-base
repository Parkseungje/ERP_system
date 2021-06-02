<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="divEmpty">
   <div class="hiddenData">
   </div>
   <table class="col">
                          
      <tbody id="acctitleList">
      <c:set var="nRow" value="${pageSize*(admCurrentPage-1)}" />
         <c:forEach var="list" items="${acctitle}">  <!-- 컨트롤러에서 정해준 모델 객체이름 -->
            <tr>
            	<td>${list.group_code}</td>
         		<td>${list.group_name}</td>
				<td>${list.detail_account_cd}</td>
				<td><a href="javascript:fPopModalDetail('${list.group_code}','${list.detail_account_cd}');"><strong>${list.detail_account_nm}</strong></a></td>
				<td>${list.account_type}</td>
				<td>${list.note}</td>
				<td>${list.use_yn}</td>
            </tr>
         <c:set var="nRow" value="${nRow + 1}" />
      </c:forEach> 
      </tbody>
   </table>
</div>
<input type="hidden" id="totalCntBmDv" name="totalCntBmDv" value="${totalCntBmDv}"/>
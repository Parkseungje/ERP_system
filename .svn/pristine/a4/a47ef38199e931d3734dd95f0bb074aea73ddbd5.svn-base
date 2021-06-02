<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



      <c:set var="nRow" value="${pageSize*(admCurrentPage-1)}" />
         <c:forEach var="list" items="${taapprove}">  <!-- 컨트롤러에서 정해준 모델 객체이름 -->
            <tr>
            	<td>${list.ta_no}</td>
         		<td><a href="javascript:fPopModalDetail('${list.ta_no}');"><strong>${list.loginID}</strong></a></td>
				<td>${list.name}</td>
				<td>${list.kind_hol}</td>
				<td>${list.start_date}</td>
				<td>${list.end_date}</td>
				<td>${list.ta_reg_date}</td>
				<td>${list.app_nm}</td>
				<td>${list.ta_yn}</td>
            </tr>
         <c:set var="nRow" value="${nRow + 1}" />
      </c:forEach> 

<input type="hidden" id="totalCntBmDv" name="totalCntBmDv" value="${totalCntBmDv}"/>
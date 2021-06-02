<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
					<div class="divEmpty">
						<div class="hiddenData">
							  <span id="totalCntComnDtlCod">${totalCntComnDtlCod}</span>
						</div>
						<table class="col">
							<thead>
								<tr>
									<th scope="col">순번</th>
									<th scope="col">그룹코드</th>
									<th scope="col">상세코드</th>
									<th scope="col">상세코드명</th>
									<th scope="col">상세코드 설명</th>
									<th scope="col">사용여부</th>
									<th scope="col">비고</th>
								</tr>
							</thead>
							<tbody id="listComnDtlCod">
							<c:if test="${totalCntComnDtlCod eq 0 }">
								<tr>
									<td colspan="12">데이터가 존재하지 않습니다.</td>
								</tr>
							</c:if>
							<c:set var="nRow" value="${pageSize*(currentPageComnDtlCod-1)}" />
							<c:forEach items="${listComnDtlCodModel}" var="list">
								<tr>
									<td>${totalCntComnDtlCod - nRow}</td>
									<td>${list.grp_cod}</td>
									<td>${list.dtl_cod}</td>
									<td>${list.dtl_cod_nm}</td>
									<td>${list.dtl_cod_eplti}</td>
									<td>${list.use_poa}</td>
									
									<td><a class="btnType3 color1" href="javascript:fPopModalComnDtlCod('${list.grp_cod}','${list.dtl_cod}');"><span>수정</span></a></td>
								</tr>
								<c:set var="nRow" value="${nRow + 1}" />
							</c:forEach>
							</tbody>
						</table>
					</div>
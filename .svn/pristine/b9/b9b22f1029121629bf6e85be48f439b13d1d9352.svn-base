<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>					
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
						   
							<c:if test="${groupcodecount eq 0 }">
								<tr>
									<td colspan="7">데이터가 존재하지 않습니다.</td>
								</tr>
							</c:if>			
							
							<c:if test="${groupcodecount > 0 }">
								<c:set var="nRow" value="${pageSize*(groupcodecurrentPage-1)}" />
								<c:forEach items="${groupcodelist}" var="list">
									<tr>
										<td>${groupcodecount - nRow}</td>
										<td><a href="javascript:fn_selectDtlCod(1, '${list.grp_cod}', '${list.grp_cod_nm}')">${list.grp_cod}</a></td>
										<td>${list.grp_cod_nm}</td>
										<td>${list.grp_cod_eplti}</td>
										<td>${list.use_poa}</td>
										<td>${list.reg_date}</td>
										<td>
											<a class="btnType3 color1" href="javascript:fn_editComnGrpCod('${list.grp_cod}');"><span>수정</span></a>
										</td>
									</tr>
									<c:set var="nRow" value="${nRow + 1}" />
								</c:forEach>
							</c:if>
							
							<input type="hidden" id="totalCntComnGrpCod" name="totalCntComnGrpCod" value ="${groupcodecount}"/>
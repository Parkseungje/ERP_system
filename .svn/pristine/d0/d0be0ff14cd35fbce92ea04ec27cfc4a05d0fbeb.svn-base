<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
 #est_client_nm,#erp_copnm {
 background-color: #BBC1CD;
 font-weight:bolder;
 text-align: center;

 
 }  

</style>

<!-- 모달이 여러개라 id값 name값 다르게-->


	 <!-- 모달팝업2 ==  readOnly -->
	   <div id="layer2" class="layerPop layerType2"  style="width: 800px;">
	      <dl>
	         <dt>
	            <div id="divtitle" style="color:white"><b>견적서 상세 조회</b></div>
	         </dt>
	         <dd class="content">
	            <!-- s : 여기에 내용입력 -->
	            <table class="row">
	               <caption>caption</caption>
	               <colgroup>
	                  <col width="120px">
	                  <col width="*">
	                  <col width="120px">
	                  <col width="*">
	               </colgroup>
	
	               <tbody>
	                <tr>
					   
					    
	                       <tr>
		                     <th scope="row" colspan="2"> <input type ="text"  name="est_client_nm" id="est_client_nm"   readOnly > </th>
		                      <th scope="row" colspan="2"><input type ="text"  name="erp_copnm" id="erp_copnm"   readOnly ></th>
		                  </tr>
		  
		                
		                  <tr>
		                  <!-- 목록조회 외에 UPDATE, INSERT , DELETE 등을 위해 필요함  hidden 값  // INT가 아닌것도 있음  -->
		                   <td hidden=""><input type="text" class="inputTxt p100" name="estimate_no" id="estimate_no" /></td> 
                       	   
                       	   <th scope="row">사업자등록번호</th>
		                     <td  class="inputTxt p100">  	
				                  <input type="text"   name="cop_no1" id="cop_no1" style ="width :20%; height :70%" maxlength="4"  readOnly>
				                     	 - <input type="text"   name="cop_no2" id="cop_no2" style ="width :20%; height :70%" maxlength="4"  readOnly>
				                     	 - <input type="text"  name="cop_no3" id="cop_no3" style ="width :20%; height :70%" maxlength="4" readOnly/>
		     
		     			 <th scope="row">사업자등록번호</th>
	                     	<td  class="inputTxt p100">
                  				 <input type="text"   name="erp_copnum1" id="erp_copnum1" style ="width :20%; height :70%" maxlength="4"  readOnly>
			                     	 - <input type="text"   name="erp_copnum2" id="erp_copnum2" style ="width :20%; height :70%" maxlength="4" readOnly >
			                     	 - <input type="text"  name="erp_copnum3" id="erp_copnum3" style ="width :20%; height :70%" maxlength="4" readOnly/>
	                  </tr>
	                  <tr>
	                     <th scope="row">담당자</th>
	                     <td><input type="text" class="inputTxt p100" name="direct_nm" id= "direct_nm" readOnly/></td>
	                      <th scope="row">담당자</th>
	                     <td><input type="text" class="inputTxt p100" name="emp_name" id= "emp_name" readOnly/></td>
	                  </tr>
	          
	                  <tr>
                         <th scope="row">주소</th>
	                     	<td >
	                     		<input type="text" class="inputTxt p100"  name="addr" id="addr" readOnly />
	                     	</td>
	                     	<th scope="row">주소</th>
		                     	<td>
		                     		<input type="text" class="inputTxt p100"  name="erp_addr" id="erp_addr"  readOnly/>
		                     	</td>
	                  </tr>
	                  <tr>
                         <th scope="row">나머지 주소</th>
	                     	<td >
	                     		<input type="text" class="inputTxt p100"  name="addr_other" id="addr_other"  readOnly/>
	                     	</td>
	                     	<th scope="row">나머지주소</th>
		                     	<td>
		                     		<input type="text" class="inputTxt p100"  name="erp_addr_other" id="erp_addr_other"  readOnly/>
		                     	</td>
	                  </tr>
	                   <tr> 	   
	                   	<th scope="row">TEL</th>
		                     <td  class="inputTxt p100">  	
				                  <input type="text"   name="local_tel1" id="local_tel1" style ="width :20%; height :70%" maxlength="4"  readOnly/>
				                     	 - <input type="text"   name="local_tel2" id="local_tel2" style ="width :20%; height :70%" maxlength="4"  readOnly/>
				                     	 - <input type="text"  name="local_tel3" id="local_tel3" style ="width :20%; height :70%" maxlength="4" readOnly/>
		     
		     			 <th scope="row">TEL</th>
	                     	<td  class="inputTxt p100">
                  				 <input type="text"   name="erp_tel1" id="erp_tel1" style ="width :20%; height :70%" maxlength="4"  readOnly/>
			                     	 - <input type="text"   name="erp_tel2" id="erp_tel2" style ="width :20%; height :70%" maxlength="4"  readOnly/>
			                     	 - <input type="text"  name="erp_tel3" id="erp_tel3" style ="width :20%; height :70%" maxlength="4" readOnly/>
              				
	                  </tr>
	                  
	                  	                  
	           <!-- 거래처 + erp 회사 정보 끝 -->
	           
	           
	                  <!--  한 칸 띄우기  -->
	            	  <tr>
                     	<td  colspan="4" class="inputTxt p100">
		              </tr>
		             						
				     	<tr>
                     		<td scope="row" colspan="4" >
	                     		<br>
	                     		    1. 귀사의 일익 번창하심을 기원합니다. <br>
	                     		    2.하기와 같이 견적드리오니 검토하기 바랍니다.<br>
		              	</tr>
           			<tr>
			   			 <th scope="row">견적작성일</th>
	                     	<td  class="inputTxt p100">
	                 			<input type="text"   name="estimate_date" id="estimate_date" style ="width :70%; height :70%"    readOnly/>
	                  </tr>
	                  
	                  <tr>
			   			 <th scope="row" class="han_money" id="han_money" >  합 계 </th>
			  				<td><input type="text" id="txt_money" maxlength="12"  readOnly  />
			  				</td>
			  			</tr>
	            
		              
                     <table class="col">
                        <caption>caption</caption>
                        <colgroup>
                           <col width="10%">
                           <col width="15%">
                            <col width="15%">
                           <col width="10%">
                           <col width="10%">
                           <col width="10%">
                        </colgroup>
                       <thead>
  
                           <tr>
                             <th scope="col">제품명</th>
                              <th scope="col">공급가액</th>
                               <th scope="col">세액</th>
                               <th scope="col">제품단가</th>
                               <th scope="col">수량</th>
                           </tr>
                        </thead>
	                    <tbody id="EstDetaillist"> </tbody>    <!--  detail 끼워넣기  -->
	            </table>
	            <div class="btn_areaC mt30">
	  
<!-- 	               <a href="" class="btnType blue" id="btnDeleteEst" name="btn"><span>삭제</span></a>  -->
	               <a href=""   class="btnType gray"  id="btnCloseEst" name="btn"><span>취소</span></a>
	            </div>
	         </dd>
	      </dl>
	      <a href="" class="closePop"><span class="hidden">닫기</span></a>
	   </div>
	   </tbody>
	   </table>
	   </dd>
	   </dl>
	   </div>
	   


	   
	   <!-- 모달2 끝 -->

		  

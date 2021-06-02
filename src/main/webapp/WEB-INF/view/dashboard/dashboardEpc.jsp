<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 슬라이드 쇼 slick 라이브러리 -->
<link rel="stylesheet" href="${CTX_PATH}/css/slick/slick.css"/>
<link rel="stylesheet" href="${CTX_PATH}/css/slick/slick-theme.css"/>
<script src="${CTX_PATH}/js/slick/slick.js"></script>
<script src="${CTX_PATH}/js/slick/slick.min.js"></script>



<%-- <script src="/webjars/sockjs-client/sockjs.min.js"></script>
<script src="/webjars/stomp-websocket/stomp.min.js"></script>
<script src="${CTX_PATH}/js/view/dashboard/epc/websocketEpc.js"></script> --%>


<link rel="stylesheet" href="${CTX_PATH}/css/chosen/chosen.css">
<script src="${CTX_PATH}/js/chosen/chosen.jquery.js"></script>


<script src="${CTX_PATH}/js/view/dashboard/epc/dashboardEpc.js"></script>


<script src="${CTX_PATH}/js/view/epc/productList/productList.js"></script>


<!-- font awesome css -->
<link rel="stylesheet" type="text/css" href="${CTX_PATH}/js/statistics/css/font-awesome.min.css">


<style>
/*post slider*/
.post-slider{
  width:90%;
  margin:0px auto;
  position:relative;
}
.post-slider .silder-title{
  text-align:center;
  margin:30px auto;
}
.post-slider .next{
  position:absolute;
  top:50%;
  right:30px;
  font-size:2em;
  color:gray;
  cursor: pointer;
}
.post-slider .prev{
  position:absolute;
  top:50%;
  left:30px;
  font-size:2em;
  color:gray;
  cursor: pointer;
}
.post-slider .post-wrapper{

  width:95%;
  height:350px;
  margin:0px auto;
  overflow: hidden;
  padding:10px 0px 10px 0px;
}
.post-slider .post-wrapper .post{
  width:600px;
  height:300px;
  margin:0px 10px;
  display:inline-block;
  background:white;
  border-radius: 5px;
}
.post-slider .post-wrapper .post .post-info{
  font-size:15px;
  height:30%;
  padding-left:10px;
}
.post-slider .post-wrapper .post .slider-image{
  width:100%;
  height:175px;
  border-top-left-radius:5px;
  border-top-right-radius:5px;
}


.img-button{
float: right;
background-image: url(/images/view/dashboard/epc/cart.png);

        border: none;
        width: 32px;
        height: 32px;
}


</style>

</head>
<body>
						<p class="conTitle">
							<span> 판매 상품</span> <span class="fr"> 
							</span>
						</p>
						
    <div class="page-wrapper" style="position:relative;">
      <!--page slider -->
      <div class="post-slider">
        <h1 class="silder-title"></h1>

        
        <select id="productCategory" style="float : left"
        onchange="fSelectedOptions(this.options[this.selectedIndex].value)"></select>
        
        <div class="post-wrapper"></div>
        </div>
      <!--post slider-->
    </div>

<div id="layer1" class="layerPop layerType2" style="width: 600px; height: 500px;">
		<dl>
			<dt>
				<strong>제품 상세보기</strong>
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
							<th scope="row">모델번호</th>
							<td><input type="text" maxlength="15" name="pro_num" id="pro_num" ></td>
							<th scope="row">제품이미지</th>
							<td colspan="2" style="text-align:center;">
								 	<img id="tempImg" style="object-fit: cover;max-width:100%" src="" alt="제품사진미리보기">
							</td>
						</tr>
						<tr>
							<th scope="row">제조사</th>
							<td><input type="text" maxlength="15" name="pro_manu_nm" id="pro_manu_nm" /></td>
								
							<th scope="row">주문수량</th>
							
							
							<!-- <input type="text"  name="od_qty" id="od_qty" value = "1"  /> -->
							
							<td><input type="number" id="od_qty" name = "od_qty" value="1" v-model="od_qty" class="num" min="1" /></td>
						</tr>
				
						<tr>
							<th scope="row">판매가격 </th>
							<td><input type="text" maxlength="10" name="pro_prc" id="pro_prc" ></td>
							
							<th scope="row">납품희망일</th>
							<td><input type="text" id="startDate" name = "startDate" readonly="readonly"></td>
                           	
						</tr>
						
						<tr>
							<th scope="row">상세정보</th>
								<td colspan="3">
							<textarea id="pro_det" maxlength="500" name="pro_det" style="height:130px;outline:none;resize:none;" placeholder="여기에 상세정보를 적어주세요.(500자 이내)"></textarea>
							</td>
						</tr>
					</tbody>
				</table>

				<!-- e : 여기에 내용입력 -->

				<div class="btn_areaC mt30">
					<a href="" class="btnType blue" id="btnInBasket" name="btn"><span>장바구니</span></a> 
					<a class="btnType blue" href="javascript:fAdminBankModal(${null});" name="modal">
									<span>주문하기</span></a> 
					<a href=""	class="btnType gray"  id="btnCloseProductList" name="btn"><span>취소</span></a>
				</div>
			</dd>
		</dl>
		<a href="" class="closePop"><span class="hidden">닫기</span></a>
	</div>
	
	<!-- admin bank 모달 -->
		<div id="admin_bank" class="layerPop layerType2" style="width: 500px; height: 500px;">
		<input type="hidden" id="loginID" name="loginID"> <!-- 수정시 필요한 num 값을 넘김  -->
           <dl>
			<dt>
				<strong>주문하기</strong>
			</dt>
			<dd class="content">
		
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
							<th style="width:70px" scope="row">은행명<span class="font_red">*</span></th>
						</tr>
						<tr>
							<td><span name="bank_name" id="bank_name"></span></td>
						</tr>
						<tr>
							<th style="width:70px" scope="row">계좌번호<span class="font_red">*</span></th>
						</tr>
						<tr>
							<td><span name="user_account" id="user_account"></span></td>
						</tr>
						<tr>
							<th style="width:70px" scope="row">예금주<span class="font_red">*</span></th>
						</tr>
						<tr>
							<td><span name="name" id="name"></span></td>
						</tr>
												<tr>
							<th style="width:70px" scope="row">결제금액<span class="font_red">*</span></th>
						</tr>
						<tr>
							<td><span name="totalHap" id="totalHap"></span></td>
						</tr>
						
							
					</tbody>
					
				</table>
				<div class="btn_areaC mt30">
					<a href="" class="btnType blue" id="btnInOrder" name="btn" ><span>주문하기</span></a>
					
					<!-- onClick="deposit_click()" -->			
					<a href=""	class="btnType gray"  id="btnCloseProductList" name="btn"><span>취소</span></a>
				</div>
		    </dd>
          </dl>
		<a href="" class="closePop"><span class="hidden">닫기</span></a>
     </div>
</body>
</html>
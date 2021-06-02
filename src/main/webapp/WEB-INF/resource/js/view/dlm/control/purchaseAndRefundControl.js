/**
 * 
 */

// 반품할 상품의 정보를 서버에 보내고 처리하는 함수.
function fRefundOrder() {

  const url = "/dlm/refundOrder";
  const checkedItem = $("input[name='chk']:checked");

  if (checkedItem.length === 0) {
    swal("선택 된 내역이 없습니다. \n하나 이상의 내역을 선택 해주세요.");
    return;
  }
  const param = createParam(checkedItem);
  console.log(param);

  const resultCallback = function(data) {
    //swal("refundResult - " + data.refundResult + "\ndirectionResult - " + data.directionResult + "\nproIoQtyResult - " + data.proIoQtyResult + "\npurchaseCDResult" + data.purchaseCDResult);
    location.href = "";
  };

  /* sweetalert 창에 대한 버튼 */
  swal("반품 처리 하시겠습니까?", {
    buttons: {
      yes: "예",
      no: "아니오"
    }
  }).then((value) => {
    switch (value) {
      case "yes":
        $.ajax({
          url: url,
          contentType: 'application/json',
          dataType: "json", //json 형태의 타입
          data: JSON.stringify(param),
          type: "POST",
          success: function(data) {
            resultCallback(data);
          },
          error: function(xhr, status, error) {
            console.log("xhr:" + xhr + ", status:" + status + ", error:" + error);
          }
        });
        break;
      case "no":
        break;
    }
  });




}

// 입고 처리될 정보를 서버에 보내고 처리하는 함수.
function fPurchaseOrder() {
  const url = "/dlm/purchaseOrder";
  const checkedItem = $("input[name='chk']:checked");

  if (checkedItem.length === 0) {
    swal("선택 된 내역이 없습니다. \n하나 이상의 내역을 선택 해주세요.");
    return;
  }

  if (!checkItems(checkedItem)) {
    swal("처리 개수가 부족한 항목이 있습니다. \n반품 먼저 진행해 주세요.");
    return;
  }
  // TODO : 반품 모달에 띄워줄 정보를 가져오는 함수
  //let storage = [];
  /*     checkedItem.each(function (index, item) {
        let origin = item.parentElement.parentElement.children[7].innerText;
        let compare = item.parentElement.parentElement.children[8].children[0].value;
        if(origin !== compare){
          
          storage[index] = {};
          storage[index].purchase_no = item.parentElement.parentElement.children[1].innerText;
          storage[index].pro_no = item.parentElement.parentElement.children[2].innerText;
          storage[index].detail_name = item.parentElement.parentElement.children[3].innerText;
          storage[index].pro_name = item.parentElement.parentElement.children[4].innerText;
          storage[index].pro_manu_name = item.parentElement.parentElement.children[5].innerText;
          storage[index].purchase_date = item.parentElement.parentElement.children[6].innerText;
          storage[index].pro_io_qty = item.parentElement.parentElement.children[8].children[0].value;
          storage[index].pro_deli_price = item.parentElement.parentElement.children[9].innerText;
          storage[index].ware_no = item.parentElement.parentElement.children[10].innerText;
  
        }
      }); */
  //console.log(storage);

  const param = createParam(checkedItem);

  console.log("param-- ", param);

  const resultCallback = function(data) {
    //swal("purchaseResult - " + data.purchaseResult + "\nproIoWarehouseResult - " + data.proIoWarehouseResult + "\nrealQuantityResult - " + data.realQuantityResult);
    location.href = "";
  };

  /* sweetalert 창에 대한 버튼 */
  swal("입고 처리 하시겠습니까?", {
    buttons: {
      yes: "예",
      no: "아니오"
    }
  }).then((value) => {  /* 이건 이클립스가 게을러서 뜨는 에러!  */
    switch (value) {
      case "yes":
        $.ajax({
          url: url,
          contentType: 'application/json',
          dataType: "json", //json 형태의 타입
          data: JSON.stringify(param),
          type: "POST",
          success: function(data) {
            resultCallback(data);
          },
          error: function(xhr, status, error) {
            console.log("xhr:" + xhr + ", status:" + status + ", error:" + error);
          }
        });
        break;
      case "no":
        break;
    }
  });


}

// 필요한 prop 생성
function createParam(items, param = []) {

  for (let i = 0; i < items.length; i++) {
    param[i] = {};
    param[i].purchase_no = items[i].parentElement.parentElement.children[1].innerText;
    param[i].ware_no = items[i].parentElement.parentElement.children[10].innerText;
    param[i].pro_no = items[i].parentElement.parentElement.children[2].innerText;
    param[i].pro_io_qty = items[i].parentElement.parentElement.children[8].children[0].value;
  }
  return param;
}

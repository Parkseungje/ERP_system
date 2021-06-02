/**
 *    전체 선택 & 해제 , 처리 개수 소수점, 최소값, 최대값 체크 함수부
      + 아이템 총 개수와 처리 개수 비교 
 */


// 전체 선택&해제 함수
function allCheckAble() {
  if ($("#chk_all").is(":checked"))
    $(".chk").prop("checked", true);
  else
    $(".chk").prop("checked", false);
}

// 하위 체크박스가 전체선택이 아닐시 전체선택 버튼 false
function allCheckDisable() {
  if ($("input[name='chk']:checked").length == $("input[name='chk']").length)
    $("#chk_all").prop("checked", true);
  else
    $("#chk_all").prop("checked", false);
}

// 처리 개수 체크
function checkCount(targetObj) {
  const id = $(targetObj).attr('class');
  let origin = $(targetObj).attr('value');
  let compare = $("." + id).val();

  origin = Number(origin);
  compare = Number(compare);

  // 소수점 체크하고, 반올림한 값을 나타냄.
  if (!numCheck(compare)) {
    swal("소숫점은 입력할 수 없습니다.");
    const roundVal = Math.round(compare);
    $("." + id).val(roundVal ? roundVal : 1);
    return;
  }
  //console.log(id, origin, compare);
  //console.log($("#" + id).children()[8].children[0].value);

  if (compare < 1) {
    swal("최소 한개의 처리 개수가 입력 되어야 합니다.");
    $("." + id).val(1);
  }
  if (compare > origin) {
    swal("주문 개수보다 큰 수량을 처리 할 수 없습니다.");
    $("." + id).val(origin);
  }
}

// 처리 개수 소수점 체크 함수
function numCheck(num) {
  const num_check = /^[0-9]*$/;
  if (!num_check.test(num)) {
    return false;
  }
  return true;
}

// 아이템 총 개수와 처리 개수 비교 함수
function checkItems(items) {
  let result = true;
  for (let i = 0; i < items.length; i++) {
    let origin = items[i].parentElement.parentElement.children[7].innerText;
    let compare = items[i].parentElement.parentElement.children[8].children[0].value;
    if (origin !== compare) {
      result = false;
      break;
    }
  }
  return result;
}
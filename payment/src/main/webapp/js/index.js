/* js파일에는 jsp 코드 사용불가*/


/* 기본 상품 정보 입력 */
export function gopage(){
	if(frm.product_name.value == "" || frm.product_price.value == "" || frm.product_code.value == "" || frm.product_ea.value == ""){
		alert("모든 사항을 기입해주세요.");
	}
	else if(frm.product_price.value < 1000){
		alert("금액은 1000원 이상부터 입력 가능합니다.");
	}
	else if(frm.product_ea.value <= 0){
		alert("수량은 1개부터 구매 가능합니다.");
	}
	else{
		frm.method = "POST";
		frm.action = "./index2.jsp";
		frm.submit();
	}
}

/* 적립금 확인 및 실제 결제 할 금액 체크*/
export function gopayment(money){

	var oksign = "";
	
	if(frm.point.value > 0){
		var ori_m = frm.price.value;
		var point = frm.point.value;
		var last_price = ori_m - point;
		frm.price.value = last_price;
		document.getElementById("total").innerText = last_price.toLocaleString();
		oksign = "ok";
	}
	else if(frm.point.value =="" || frm.point.value == "0"){
		frm.point.value = 0;
		frm.price.value = money;
		document.getElementById("total").innerText = money.toLocaleString();
		oksign = "ok";
	}
	else{
		/*oksign == ok*/
		
	}
	if(oksign == "ok"){
		frm.method = "POST";
		frm.action = "./index3.jsp";
		frm.submit();
	}
}
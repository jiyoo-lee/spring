<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// setAttribute, getAttribute 같이 사용 금지
	String mid = "hong";
	String mname = "홍길동";
	String mtel = "01012341234";
	String memail = "jeeyu-lee@naver.com";
	session.setAttribute("mid",mid);
	session.setAttribute("mname",mname);
	session.setAttribute("mtel",mtel);
	session.setAttribute("memail",memail);
	
	/*
	session.removeAttribute(mname);
	session.removeAttribute(mid);
	*/
	
	/*상품코드 6자리 난수 생성*/
	String temp = "";
	
	for(int i = 0; i < 6; i++){
		int productCode = (int)(Math.random()*9);
		temp += String.valueOf(productCode);		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품선택 부분</title>
</head>
<body>
<!-- 결제 시스템 상품코드는 최소 6자리~ 최대 12자리
상품수량 : 숫자만 입력가능하게 해야합니다. 
결제금액: 무조건 숫자만 입력 : 25,000(x), 25000(o) 
결제 금액은 최소 1000원부터 가능함
상품명: 불가 단어 주의(마약,담배,술..?)
-->
<form name="frm" id="frm">
상품코드 <input type ="text" name="product_code" value = "<%=temp%>" readonly="readonly"> <br>
상품명 : <input type="text" name="product_name" placeholder="공백없이 입력하세요"><br>
결제금액 : <input type="text" name="product_price" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1')" maxlength="20"><br>
수량 : <input type="text" name="product_ea" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1')" maxlength="10"><br>
<input type="button" value="상품구매확정" id="btn">
</form>
<!-- ECMA 형태의 script -->
<script type="module">
   import {gopage} from "./js/index.js";
   document.querySelector("#btn").addEventListener("click",gopage);
</script>
</body>
</html>
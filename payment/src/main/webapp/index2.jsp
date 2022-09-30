<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	String m1 = "mid"; 
	String m2 = "mname";
	String m3 = "mtel";
	String m4 = "memail";
	
	Object mid1 = session.getAttribute(m1);
	Object mname1 = session.getAttribute(m2);
	Object mtel1 =  session.getAttribute(m3);
	Object memail1 = session.getAttribute(m4);
	
	String product_code = request.getParameter("product_code");
	String product_name = request.getParameter("product_name");
	String product_ea = request.getParameter("product_ea");
	String product_price = request.getParameter("product_price");
	
	/*
	Double m = Double.parseDouble(product_price);
	DecimalFormat dc = new DecimalFormat("###,###");
	String money = dc.format(m);
	*/
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer's Information check</title>
</head>
<body>
<form name="frm" id="frm" enctype="application/x-www-form-urlencoded">
<!-- PG사에 제공되는 hidden값들 -->
<input type = "hidden" name="version" value="1.0">
<input type = "hidden" name="mid" value="">
<input type="hidden" name="oid" value="">

<!-- 최종 결제 금액 -->
<input type="hidden" name="price" value="<%=product_price%>">
<!-- 결제 시간 -->
<input type="hidden" name="timestamp" value="">
<input type="hidden" name="currency" value="WON">

<!-- 상품명 -->
<input type="hidden" name="goodname" value="<%=product_name%>">
<input type="hidden" name="buyername" value="<%=mname1%>">
<input type="hidden" name="buyertel" value="<%=mtel1%>">
<input type="hidden" name="buyeremail" value="<%=memail1%>">
<input type ="hidden" name ="buyerid" value="<%=mid1%>">
<input type="hidden" name="goodcode" value="<%=product_code%>">
<input type="hidden" name="goodea" value="<%=product_ea%>">

<h1>결제 정보</h1>
상품코드 : <%=product_code%> <br>
상품명 : <%=product_name%><br>
상품수량 : <%=product_ea%> EA<br>
결제금액 : <span id="m"></span>원<br>
<p>---------------------배송정보 입력 및 최종결제 금액 확정----------------------</p>
수령인 : <input type="text" name="rec_name" value=<%=mname1 %>><br>
수령인 연락처: <input type="text" name="rec_tel" value="<%=mtel1%>"><br>
배송지 : <input type="text" name="rec_addr" value="" placeholder="주소 입력해주세요"><br>
적립금 사용 : <input type="text" name="point" value="0"> <br>
최종 결제 금액: <b><span id="total"></span>원</b> <br>
<p>-----------------------------결제파트----------------------------------------------</p>
<input type ="radio" name="gopaymethod" value="CARD" checked> 신용카드 
<input type ="radio" name="gopaymethod" value="Directbank">계좌이체 
<input type ="radio" name="gopaymethod" value="vbank"> 가상계좌 <br>
<input type="button" value="결제하기" id="payment">
</form>

</body>

<script type="module">
	var money = <%=product_price %>; //상품 원금은 
 	import {gopayment} from "./js/index.js";

	document.getElementById("m").innerText = money.toLocaleString();
	document.getElementById("total").innerText = money.toLocaleString();

   	document.querySelector("#payment").addEventListener("click",function() {gopayment(money)});
</script>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.inicis.std.util.SignatureUtil"%>
<%@page import="java.util.*"%>
<%

   String mid               = "INIpayTest";                          // 상점아이디               
   String signKey             = "SU5JTElURV9UUklQTEVERVNfS0VZU1RS";   // 웹 결제 signkey
   String goodcode            = request.getParameter("goodcode");
   String mKey = SignatureUtil.hash(signKey, "SHA-256");

   String timestamp         = SignatureUtil.getTimestamp();         // util에 의해서 자동생성
   String orderNumber         = mid+"_"+goodcode;   // 가맹점 주문번호(가맹점에서 직접 설정)
   String price            = request.getParameter("price");                        // 상품가격(특수기호 제외, 가맹점에서 직접 설정)


   Map<String, String> signParam = new HashMap<String, String>();

   signParam.put("oid", orderNumber);
   signParam.put("price", price);
   signParam.put("timestamp", timestamp);

   String signature = SignatureUtil.makeSignature(signParam);
   
   /* index2.jsp 데이터 이관 */
   String version = request.getParameter("version");
   String currency = request.getParameter("currency");
   String goodname = request.getParameter("goodname");
   String buyername = request.getParameter("buyername");
   String buyertel = request.getParameter("buyertel");
   String buyeremail = request.getParameter("buyeremail");
   String rec_name = request.getParameter("rec_name");
   String rec_tel = request.getParameter("rec_tel");
   String rec_addr = request.getParameter("rec_addr");
   String point = request.getParameter("point");
   String gopaymethod = request.getParameter("gopaymethod");
   
   String buyerid = request.getParameter("buyerid");
   String goodea = request.getParameter("goodea");   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>최종결제금액</title>
</head>
<script language="javascript" type="text/javascript" src="https://stgstdpay.inicis.com/stdjs/INIStdPay.js" charset="UTF-8">
</script>
<script>
   function payment(){
      INIStdPay.pay('pay');
   }
</script>
<body>
<form name="pay" id="pay">
<input type="hidden" name="goodname" value="<%=goodname%>">
<input type="hidden" name="version" value="<%=version%>">
<input type="hidden" name="gopaymethod" value="<%=gopaymethod%>">
<input type="hidden" name="mid" value="<%=mid%>">
<input type="hidden" name="oid" value="<%=orderNumber%>">
<input type="hidden" name="price" value="<%=price%>">
<input type="hidden" name="timestamp" value="<%=timestamp%>">
<input type="hidden" name="signature" value="<%=signature%>">
<input type="hidden" name="mKey" value="<%=mKey%>">
<input type="hidden" name="currency" value="<%=currency%>">
<input type="hidden" name="buyername" value="<%=buyername%>">
<input type="hidden" name="buyertel" value="<%=buyertel%>">
<input type="hidden" name="buyeremail" value="<%=buyeremail%>">
<input type="hidden" name="returnUrl" value="http://jeeyulee.cafe24.com/payment/INIstdpay_pc_return.jsp">
<input type="hidden" name="closeUrl" value="http://jeeyulee.cafe24.com/payment/close.jsp">
<hr>
<p>결제자 정보</p>
<hr>
고객명 : <%=buyername %><br>
고객아이디 : <%=buyerid %><br>
고객연락처 : <%=buyertel %><br>
고객이메일 : <%=buyeremail %><br> 
<hr>
<p>상품 정보</p>
<hr>
상품코드 : <%=goodcode %><br>
상품명 : <%=goodname %><br>
상품갯수  : <%=goodea %>개<br>
<hr>
<p>배송 정보</p>
<hr>
수령인 : <%=rec_name %><br>
수령인연락처 : <%=rec_tel %><br>
수령지 : <%=rec_addr %><br>
<hr>
<p>결제 정보</p>
적립금 사용금액 : <%=point %><br>
최종결제금액 : <%=price %><br>
결제수단 : <%=gopaymethod %><br>
<hr>
<br><br>
<input type="button" value="결제하기" onclick="payment()">
</form>
</body>

</html>
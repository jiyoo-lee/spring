<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="f" id="f" method="post" enctype="application/x-www-form-urlencoded" action="http://192.168.100.216:8080/test3/check_page.do">
<input type="password" name="security">
<input type="submit" value="전송">
</form>
<hr>내부전송
<form name="fa" id="fa" method="get" action="./dataload.do">
<input type="text" name="users">
<input type="submit" value="내부전송">
</form>
</body>
</html>
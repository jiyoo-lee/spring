<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과</title>
</head>
<body>
외부 서버에서 값을 받음 : <%=request.getParameter("result") %>
<br><br>
<h1>내부 서버에서 값을 받음 : ${call} </h1>
</body>
</html>
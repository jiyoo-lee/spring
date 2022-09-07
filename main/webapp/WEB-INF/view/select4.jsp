<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="z" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select4.java와 연계 lombok으로 jdbc 연결</title>
</head>
<body>
<div style="border:1px solid lightgray; width: 500px; height: auto; text-align: left;">
<h1>Included DATA</h1>
<z:forEach  items ="${test}" var ="test">
ID : ${test.getId()} <br>
사용자 ID : ${test.getMid()} <br>
사용자명 : ${test.getUsernm()} <br>
사용자 나이 : ${test.getMage()} <br><br>
</z:forEach>
</div>
</body>
</html>
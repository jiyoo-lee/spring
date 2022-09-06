<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- JSTL : Taglib으로 생성하여 배열 값을 출력시킴
    pom 두가지를 설치해야함
    (jstl, taglib) 설정해야 함
     -->
<%@taglib prefix="z" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB select 화면 IOC 형태 (dbqueries controller와 연동)</title>
</head>
<body>
<!-- controller에서 model값으로 보내 준 클래스명으로 var로 변환하여 key로 출력시킴 -->
<z:forEach  items ="${list}" var ="test">
<h1>Included DATA :</h1>
고객명 :	${test.usernm} <br>
고객 전화번호 : ${test.tel} <br>
</z:forEach>
<br><hr>
</body>
</html>
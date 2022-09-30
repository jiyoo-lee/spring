<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mid1 = (String)session.getAttribute("mid");
	String mname1 = (String) session.getAttribute("mname");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[class]Session Test</title>
</head>
<body>
${mid}
${mname}
</body>
</html>
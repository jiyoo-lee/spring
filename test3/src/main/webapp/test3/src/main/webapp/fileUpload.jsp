<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="f" id="f" enctype="multipart/form-data" method="post" action="./fileupload">
<input type= "file" multiple="multiple" name="multifiles">
<input type="submit" value="전송">
</form>
</body>
</html>
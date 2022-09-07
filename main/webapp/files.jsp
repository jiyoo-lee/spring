<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 Spring-controller과 병행처리</title>
</head>
<body>
<form name="f" method="post" enctype="multipart/form-data" action="./fileupload.do">
<!-- 한번에 여러 파일을 받기위해선 같은 name명을 써준다. -->
<input type="file" name="file1">
<!-- 혹은 multiple = 'multiple' accept ='.jpg,.gif' 이런식으로 한줄에 여러파일을 받아서 controller에서 mutiplefile[] 배열 형태로 받으면 된다. -->
<input type="submit" value="로컬파일전송">
</form>

<form name="f" method="post" enctype="multipart/form-data" action="./fileupload2.do">
<!-- 한번에 여러 파일을 받기위해선 같은 name명을 써준다. -->
<input type="file" name="file2">
<!-- 혹은 multiple = 'multiple' accept ='.jpg,.gif' 이런식으로 한줄에 여러파일을 받아서 controller에서 mutiplefile[] 배열 형태로 받으면 된다. -->
<input type="submit" value="서버파일전송">
</form>
</body>
</html>
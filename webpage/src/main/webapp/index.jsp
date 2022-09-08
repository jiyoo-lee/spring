<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>	Shopping Mall main </title>
</head>
<script>
	function ajaxload() {
		var a = new XMLHttpRequest();
		a.open("GET","http://localhost:8080/webpage/controller2",true);
		a.send();
		
		a.onreadystatechange = function() {
			if(a.status == 200  && a.readyState == XMLHttpRequest.DONE){
				var datas = JSON.parse(a.response);
				document.getElementById("no").innerText = datas["idx"];
				document.getElementById("names").innerText = datas["name"];
				document.getElementById("person").innerText = datas["person"];
			}
		}
	}
</script>
<body>
프로젝트 페이지 뷰 
<input type="button" value="ajax로드" onclick="ajaxload()"> <br>
영화 순위<span id="no"></span><br>
영화 제목<span id="names"></span><br>
주 연<span id="person"></span><br>
</body>
</html>
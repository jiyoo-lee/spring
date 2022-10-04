<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JS이벤트 핸들링 추가 설명</title>
<script src ="./admin/ckeditor/ckeditor.js"></script>
</head>
<body>
<!-- 
onkeyup : 키보드의 key를 누르고 나서 뗐을때 반응 (한자키, 한영변환 반응안함)
onkeydown : 키보드의 키를 누를때 반응 (한자키,한영변환 반응 안함)
onkeypress :  키보드의 키를 누를때 반응(특수키는 반응을 안함)
 -->
<input type="text" id="aaa" onkeyup="abc()" onmouseover="bbb()">
<br><br>
<!-- datalist태그와 함께 사용을 하지만 onkeyup event는 지속적으로 적용하게 됩니다.
단 select의 경우 onkey이벤트는 절대 사용하지 않습니다. -->
<input type="text" id ="bbb" onkeyup="plus();" list="op"><br>
<datalist id="op">
	<option>01</option>
	<option>02</option>
	<option>03</option>
</datalist>
<input type="text" id="ccc" onkeyup="plus();"><br>
<input type="text" id="code" readonly="readonly"><br>
<br><br>
<form name="f" id="f" method="post">
<textarea name="contents" id="contents"></textarea><br>
<input type="button" value="전송" onclick ="ck()">
</form>
</body>
<script>
CKEDITOR.replace("contents");

//ckeditor는 별도의 instances를 가져와서 값을 검토 해야 합니다.
function ck() {
	var ct = CKEDITOR.instances.contents.getData();
	if(ct == ""){
		alert("내용을 입력해주세요")
	}
	else{
		f.submit();
	}
}

function  abc() {
	var a = document.getElementById("aaa").value;
	console.log(a);
}

function bbb() {
	alert('test');
}

function plus() {
	var aa = document.getElementById("bbb").value;
	var bb = document.getElementById("ccc").value;
	var z = aa + bb;
	document.getElementById("code").value = z;
}
</script>
</html>
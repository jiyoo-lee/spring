<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일일 박스오피스 순위 + movie_api.java와 연계</title>
</head>
<body>
<table border="1">
<thead>
	<tr>
		<td style = "width: 80"><b>순위</b></td>
		<td style = "width: 250"><b>영화제목</b></td>
		<td style = "width: 100"><b>누적관객수</b></td>
	</tr>
</thead>
<tbody id="listview">
</tbody>	
</table>
</body>
<script>
	var today = "2022-09-08";
	var ajax = new XMLHttpRequest();
		ajax.open("GET","http://localhost:8080/webpage/movie?apikey=movie_jy&apidate=" + today, true);
	ajax.send();
	
	ajax.onreadystatechange = function(){
		if(ajax.status == 200 && ajax.readyState == XMLHttpRequest.DONE){
			var mdata = JSON.parse(ajax.response);
			console.log(mdata);
			html_print(mdata);
		}
	}
	
	function html_print(mdata) {
		var pt = document.getElementById("listview");
		var ea = mdata.length;
		console.log(ea);
		
		var icon = ""; //신규진입 영화 아이콘 자리
		var k = 0;
		var htmlcode = "";
		
		do{
			if(mdata[k]['rank_part'] == 'NEW'){
				icon ="<b>[신규]</b>";
			}
			else{
				icon = "[기존]";
			}
			htmlcode += "<tr>";
			htmlcode += "<td>"+mdata[k]['rank']+"</td>";
			htmlcode += "<td>"+mdata[k]['movie']+ " " + icon + "</td>";
			htmlcode += "<td>"+ mdata[k]['person'] +"명</td>";
			htmlcode += "</tr>";
			k++;
		}while(k<ea);
		
		pt.innerHTML = htmlcode;
	}
	
</script>
</html>
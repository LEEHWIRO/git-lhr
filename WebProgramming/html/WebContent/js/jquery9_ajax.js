function fnXml(){
		$.ajax({
			url : "cd_catalog.xml"
			,type : "get" // post
			,data : {}
			,dataType : "xml"
			,success : function(data){
				makeArtistList(data);
			}
			,error : function(xhr){
				console.log(xhr);
				alert("오류 발생");
			}
		});
	}
function fnXml2(){
	$.ajax({
		url : "cd_catalog.xml"
		,type : "get" // post
		,data : {}
		,dataType : "xml"
		,success : function(data){
			makeTitleList(data);
		}
		,error : function(xhr){
			console.log(xhr);
			alert("오류 발생");
		}
	});
}
function fnXmlTable(){
	$.ajax({
		url : "cd_catalog1.xml"
			,type : "get" // post
				,data : {}
	,dataType : "xml"
		,success : function(data){
			makeTableList(data);
		}
	,error : function(xhr){
		console.log(xhr);
		alert("오류 발생");
	}
	});
}
	
function fnGet(){
	// submit 실행
	document.getElementById("fm"); // <form>
	fm.action = "jquery1.html?userId=test01$password=asdf"// url 세팅
	fm.method = "post";
	fm.submit();
}
	
function fnAjax(){
	$.ajax({
		url : "intro.html"
		, type : "GET"
// 			, data :
// 			, dataType : 
		, success : function(data){
			$("#divResult").html(data);
		}
		, error : function(){
			
		}

		
		
	});
};
	
function fnText(){
	$.ajax({
		url : "/jqueryPro/html/sample/data_text.txt"
// 			,type : "get"
// 			,data : {}
	,dataType : "html"
	,success : function(data){
		// 아래 둘다 무관. text이기 때문
// 				$("#divResult").text(data);
		$("#divResult").html(data);
		}
	});
}

function fnJsonObj(){
	$.ajax({
		url : "/jqueryPro/html/sample/data_json_obj.txt"
	,dataType : "json"
	,success : function(data){
		console.log(data);
		console.log(data.name);
		// div에 이름:~ , 나이:~
		
		var str = "";
		str += "이름 : " + data.name + "<br>"
		   +  "나이 : " + data.age + "<br>"
		   +  "성별 : " + data.gender;
		
	    $("#divResult").html(str);
		}
	});
}

function fnJsonArr(){
	$.ajax({
		url : "/jqueryPro/html/sample/data_json_arr.txt"
	,dataType : "json"
	,success : function(data){
		console.log(data);
		
		var str = "<ol>";
// 				for(var i = 0; i < data.length; i++){
// 					str += "<li>" + data[i] + "</li>";
// 				}
		$.each(data, function(idx){
			str += "<li>" + data[idx] + "</li>";
		});
		str += "</ol>";
		
		$("#divResult").html(str);
		}
		,error : function(data){
			console.log(data);
		}
	});
}

function fnJsonList(){
	$.ajax({
		url : "/jqueryPro/html/sample/data_json_list.txt"
	,dataType : "json"
	,success : function(data){
		console.log(data);
		// 1번째 회원
		// 이름 :~
		// 나이 :~
		var str = "";
		$.each(data, function(idx){
			str += (1+idx) + "번째 회원" + "<br>"
			+ "이름 : " + data[idx].name + "<br>" 
			+ "나이 : " + data[idx].age + "<br>"
			+ "성별 : " + data[idx].gender + "<br>"
			+ "------------------" + "<br>";
	});
		
		
		$("#divResult").html(str);
		}
	})
}
function fnJsonTable(){
	$.ajax({
		url : "/jqueryPro/html/sample/data_json_list.txt"
	,dataType : "json"
	,success : function(data){
		console.log(data);

		var str = "<table>";
		
		str += "<tr>"
			+ "<th>" + "번호"  + "</th>"
			+ "<th>" + "이름" + "</th>"
			+ "<th>" + "나이" + "</th>"
			+ "<th>" + "성별" + "</th>"
			+ "</tr>";
			
		$.each(data, function(idx){
			str += "<tr>" 
			+ "<td>" + (1+idx) + "</td>"
			+ "<td>" + data[idx].name + "</td>"
			+ "<td>" + data[idx].age + "</td>"
			+ "<td>" + data[idx].gender + "</td>"
			+ "</tr>";
	});
		str += "</table>";
		
		$("#divResult").html(str);
		}
	})
	
}
	function makeResult(param){
		var str = "<ol>";
	
	$.each(param, function(idx){
		str += "<li>" + param[idx] + "</li>";
	});
	str += "</ol>";
	
	$("#divResult").html(str);
}

function makeArtistList(param){
	console.log(param); // param ==> document
	//console.log(param.getElementByTagName("CATALOG"))
	//console.log(param.getElementByTagName("CD"))
	var arr = param.getElementsByTagName("ARTIST");
	console.log(arr);
	
	var str = "";
	for(var i=0; i<arr.length; i++){
		str += arr[i].innerHTML + "<br>"; // 가수 이름
	}
	$("#divResult").html(str);
}

function makeTitleList(param){
	var arr = param.getElementsByTagName("TITLE");
	
	var str = "";
	for(var i=0; i<arr.length; i++){
// 				str += arr[i].innerHTML + "<br>"; // 가수 이름
		str += arr[i].childNodes[0].nodeValue + "<br>"; // 가수 이름
	}
	$("#divResult").html(str);
}
function makeTableList(param){
	var arrCd = param.getElementsByTagName("CD");
	// var arrCd = $("CD", param);
	console.log(arrCd); // arr : HTMLCollection
	
	var str = "<table>";
	
	str += "<tr>"
		+ "<th>" + "NUMBER"  + "</th>"
		+ "<th>" + "TITLE"  + "</th>"
		+ "<th>" + "ARTIST" + "</th>"
		+ "<th>" + "COUNTRY" + "</th>"
		+ "<th>" + "COMPANY" + "</th>"
		+ "<th>" + "PRICE" + "</th>"
		+ "<th>" + "YEAR" + "</th>"
		+ "</tr>";
		
	for(var i = 0; i < arrCd.length; i++){
		var title = "", artist = "", country = "", company = "", price = "", year = "";
		
		var obj = arrCd[i];
		// obj : <CD>
		var objTitle = obj.getElementsByTagName("TITLE");
		if($(objTitle).length > 0){
			title = $(objTitle).html();
		}
		
		var objArtist = obj.getElementsByTagName("ARTIST");
		if($(objArtist).length > 0){
			artist = $(objArtist).html();
		}
		
		var objCountry = obj.getElementsByTagName("COUNTRY");
		if($(objCountry).length > 0){
			country = $(objCountry).html();
		}
		
		var objCompany = obj.getElementsByTagName("COMPANY");
		if($(objCompany).length > 0){
			company = $(objCompany).html();
		}
		
		var objPrice = obj.getElementsByTagName("PRICE");
		if($(objPrice).length > 0){
			price = $(objPrice).html();
		}
		
		var objYear = obj.getElementsByTagName("YEAR");
		if($(objYear).length > 0){
			year = $(objYear).html();
		}
		
		str += "<tr>" 
			+ "<td>" + (1+i) + "</td>"
			+ "<td>" + title + "</td>"
			+ "<td>" + artist + "</td>"
			+ "<td>" + country + "</td>"
			+ "<td>" + company + "</td>"
			+ "<td>" + price + "</td>"
			+ "<td>" + year + "</td>"
			+ "</tr>";
		
	}
	
	str += "</table>";
	
	$("#divResult").html(str);
}

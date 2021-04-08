/**
 * 
 */
// strUrl = "http://localhost:9090/JqueryPro/html/jquery9/jquery9_submit_result.html?userName=아이유&userAge=25&userId=jiro&password=ksske2"
// strKey = "userId"
function getValue(strUrl, strKey) {
	strUrl = "http://localhost:9090/JqueryPro/html/jquery9/jquery9_submit_result.html?userName=아이유&userAge=25&userId=jiro&password=ksske2"
	strKey = "userId"
	// strUrl 에서 strKey에 해당하는 값을 추출해서
	var valspl = strUrl.split("&")[2]
	val = valspl.substr(valspl.indexOf("="));
	return val;
}

function isEmpty(val){
	//val이 빈 값이거나 null이거나 undefined이거나 " ", "     "
	if(val == "" || val == null || val == "undefined" || val == " " || val == "    "){
		return true;
	}else {
		return false;
	}
	
}

function format(val, type){
	//010-1234-1234, 01012341234,010-12341234, 010 123 1234
	
	
	if(type == "hpno") {
		val = val.replaceAll("-", "").replaceAll(" ", "");
		val = val.replace(/(\d{3})(\d{3,4})(\d{4})/, "$1-$2-$3");
		return val;
	}
	if(type == "birth"){
		val = val.replaceAll("-","").replaceAll(" ", "").replaceAll(",", "").replaceAll("/", "")
				.replaceAll("년", "").replaceAll("월", "").replaceAll("일", "");
		val = val.replace(/(\d{2,4})(\d{1,2})(\d{1,2})/, "$1년$2월$3일");
	}
	
//		// 2020-04-08
//		val.replace(/(\d{3})(\d{3,4})(\d{4})/, "$1-$2-$3");
//		// 2020/04/08
//		val.replace(/(\d{3})(\d{3,4})(\d{4})/, "$1/$2/$3");
//		// 2020년04월08일
//		val.replace(/(\d{3})(\d{3,4})(\d{4})/, "$1년$2월$3일");
	
}
// regExp = /[가-힣]{2,5}$/
function chkRegExp(val, regExp){
	
	
	return val.match(regExp);
}

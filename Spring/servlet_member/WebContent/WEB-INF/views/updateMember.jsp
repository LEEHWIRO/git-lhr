<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
        <!-- meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"/ -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>회원가입</title>
        <!-- Bootstrap -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
        <script src="http://code.jquery.com/jquery.js"></script>
        <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

    <style type="text/css">
    	label {
    		color : black;
    	}
    </style>
<title>회원수정</title>
</head>
<body>
	<div class="container">
		<form class="form-horizontal" action="update" method="post" >
			<input type="hidden" name="memId" value="${member.memId }">
			<div class="form-group">
				<label class="col-lg-2 control-label">비밀번호</label>
				<input class="form-control" type="password" name="memPass"><br>
			</div>
			<div class="form-group">
				<label class="col-lg-2 control-label">이메일</label>
				<input class="form-control" type="text" name="memEmail"><br>
			</div>
			<div class="form-group">
				<label class="col-lg-2 control-label">전화번호</label>
				<input class="form-control" style="" type="text" name="memPhone"><br>
			</div>
			<input class="btn btn-primary" type="submit" value="수정">
		</form>
	</div>	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="${pageContext.request.contextPath }/resource/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <link href="${pageContext.request.contextPath }/resource/css/sb-admin-2.min.css" rel="stylesheet">
    <style type="text/css">
    	label {
    		color : black;
    	}
    </style>
<title>회원등록</title>
</head>
<body>
	<div class="container">
		<form class="form-horizontal" action="insert" method="post">
			<div class="form-group">
				<label class="col-lg-2 control-label">아이디</label>
				<input class="form-control"  type="text" name="memId"><br>
			</div>
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
				<input class="form-control" style="margin-bottom: 10px;" type="text" name="memPhone"><br>
			</div>
			<input class="btn btn-primary" type="submit" value="등록">
		</form>
	</div>	
</body>
</html>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
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
    <script src="${pageContext.request.contextPath }/js/jquery-3.6.0.js"></script>
    <link href="${pageContext.request.contextPath }/js/jquery-3.6.0.js">
    <link href="${pageContext.request.contextPath }/resource/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link 
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <link href="${pageContext.request.contextPath }/resource/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/resource/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
	<style type="text/css">
		td, th {
			text-align: center;
			color : black;
		}
		a:link {
			color : black;
			text-decoration: none;
		}
		a:visited {
			color : black;
			text-decoration: none;
		}
		a:hover {
			color : blue;
			text-decoration: none;
		}
		a {
			font-weight: bold;
			color: black;
			text-decoration: none;
		}
	</style>	
	<script type="text/javascript">
	$(document).ready(function() {
		if("${msg }"=="등록성공"){
			alert("등록성공");
		}else if("${msg }"=="등록실패"){
			alert("등록실패");
		}else if("${msg }"=="등록실패"){
			alert("등록실패");
		}else if("${msg }"=="삭제성공"){
			alert("삭제성공");
		}else if("${msg }"=="삭제실패"){
			alert("삭제실패");
		}
	});
	</script>
<title>회원리스트</title>
</head>
<body id="page-top">
<div class="container">
	<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>전화번호</th>
		</tr>
		<c:forEach var="i" begin="0" end="${memberList.size()-1 }" step="1">
		<c:if test="${empty memberList }">
			<tr>
				<td colspan="4">해당 내용이 없습니다.</td>
			</tr>
		</c:if>	
		<tr>
			<td><a href="${pageContext.request.contextPath }/listDetail?memId=${memberList[i].memId }">${memberList[i].memId }</a></td>
			<td>${memberList[i].memPass }</td>
			<td>${memberList[i].memEmail }</td>
			<td>${memberList[i].memPhone }</td>
		</tr>
		</c:forEach>	
		<tr>
			<td colspan="4" style="text-align: center;"><a href="${pageContext.request.contextPath }/insert">[등록]</a></td>			
		<tr>
	</table>
</div>	
</body>
</html>
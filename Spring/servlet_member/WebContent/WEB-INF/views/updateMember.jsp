<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	MemberVO member = (MemberVO) request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
</head>
<body>
	<form action="update" method="post" >
				<input type="hidden" name="memId" value="<%=member.getMemId() %>">
		비밀번호 : <input type="password" name="memPass"><br>
		이메일 : <input type="text" name="memEmail"><br>
		전화번호 : <input type="text" name="memPhone"><br>
		<input type="submit" value="수정">
	</form>
</body>
</html>
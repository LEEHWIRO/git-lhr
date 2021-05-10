<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록</title>
</head>
<body>
	<form action="insert" method="post">
		아이디 : <input type="text" name="memId"><br>
		비밀번호 : <input type="password" name="memPass"><br>
		이메일 : <input type="text" name="memEmail"><br>
		전화번호 : <input type="text" name="memPhone"><br>
		<input type="submit" value="등록">
	</form>
</body>
</html>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	MemberVO member = (MemberVO)request.getAttribute("member");
	String msg = String.valueOf(request.getAttribute("msg"));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
<%
	if(msg.equals("수정성공")){
%>	
	alert("수정성공")
<%		
	}else if(msg.equals("수정실패")){
%>	
	alert("수정실패")
<%		
	}
%>	
	

</script>
<title>회원상세리스트</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>전화번호</th>
		</tr>
		<tr>
			<td><%=member.getMemId() %></td>
			<td><%=member.getMemPass() %></td>
			<td><%=member.getMemEmail() %></td>
			<td><%=member.getMemPhone() %></td>
		</tr>
		<tr>
			<td colspan="4" style="text-align: center;"><a href="/servlet_member/list">[목록]</a></td>			
		<tr>
		<tr>
			<td colspan="4" style="text-align: center;"><a href="/servlet_member/update?memId=<%=member.getMemId() %>">[수정]</a></td>			
		<tr>
		<tr>
			<td colspan="4" style="text-align: center;"><a href="/servlet_member/delete?memId=<%=member.getMemId() %>">[삭제]</a></td>			
		<tr>
	</table>
</body>
</html>
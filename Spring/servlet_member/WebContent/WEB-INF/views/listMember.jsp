<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	List<MemberVO> memberList = (ArrayList<MemberVO>)request.getAttribute("memberList");
	String msg = String.valueOf(request.getAttribute("msg"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
<%
	if(msg.equals("등록성공")){
%>	
	alert("등록성공")
<%		
	}else if(msg.equals("등록실패")){
%>	
	alert("등록성공")
<%		
	}else if(msg.equals("삭제성공")){
%>	
	alert("삭제성공")
<%		
	}else if(msg.equals("삭제실패")){
%>	
	alert("삭제실패")
<%		
	}
%>
</script>
<title>회원리스트</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>전화번호</th>
		</tr>
<%
		for(int i=0; i<memberList.size(); i++){
%>			
		<tr>
			<td><a href="/servlet_member/listDetail?memId=<%=memberList.get(i).getMemId() %>"><%=memberList.get(i).getMemId() %></a></td>
			<td><%=memberList.get(i).getMemPass() %></td>
			<td><%=memberList.get(i).getMemEmail() %></td>
			<td><%=memberList.get(i).getMemPhone() %></td>
		</tr>
<%			
		}
%>
		<tr>
			<td colspan="4" style="text-align: center;"><a href="/servlet_member/insert">[등록]</a></td>			
		<tr>
	</table>
</body>
</html>
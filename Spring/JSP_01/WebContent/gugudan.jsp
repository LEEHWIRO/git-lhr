<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<% out.println(""); %>
<%="" %>


<%

	for(int i = 2; i <= 9; i++){
%>

<h3><%=i%>단입니다.</h3>

<%
		for(int j = 1; j <= 9; j++){
%>

<p><%=i%> *  <%=j%> =  <%=i*j%></p>

<%
		}
%>

<br>

<%		
	}
%>
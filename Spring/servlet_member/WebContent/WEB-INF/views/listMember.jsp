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
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Google Font: Source Sans Pro -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
	<!-- Font Awesome -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
	<!-- Theme style -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/dist/css/adminlte.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/list.css">
	<title>회원리스트</title>
</head>
<body>
	<div class="content">
		<div class="container-fluid">
			<div class = "row">
				<div class="col-sm-2"></div>
				<div class="col-sm-8">
					<div class="row">
						<div class="card col-sm-12"></div>
						<div class="card col-sm-12">
							<div class="card">
								<div class="card-header card-header-primary">
									<h1 class="card-title">회원 리스트</h1>
					            </div>
					            <div class="card-body">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th>아이디</th>
												<th>비밀번호</th>
												<th>이메일</th>
												<th>전화번호</th>
											</tr>
										</thead>
										<tbody>
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
										</tbody>
									</table>
					           	</div>
							</div>      				
      					</div>
					</div>
				</div>
				<div class="col-sm-2"></div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		<c:if test="${not empty msg}">
			alert("${msg}")
		</c:if>
	</script>
</body>
</html>
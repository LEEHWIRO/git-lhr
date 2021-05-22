<%@page import="kr.or.ddit.member.dto.MemberVO"%>
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
	<title>회원상세리스트</title>
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
								<div class="card-header">
									<h1 class="card-title">회원 상세 리스트</h1>
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
											<tr>
												<td>${member.memId }</td>
												<td>${member.memPass }</td>
												<td>${member.memEmail }</td>
												<td>${member.memPhone }</td>
											</tr>
											<tr>
												<td colspan="4" style="text-align: center;"><a href="${pageContext.request.contextPath }/list">[목록]</a></td>			
											<tr>
											<tr>
												<td colspan="4" style="text-align: center;"><a href="${pageContext.request.contextPath }/update?memId=${member.memId }">[수정]</a></td>			
											<tr>
											<tr>
												<td colspan="4" style="text-align: center;"><a href="${pageContext.request.contextPath }/delete?memId=${member.memId }">[삭제]</a></td>			
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
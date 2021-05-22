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
	<title>회원수정</title>
	
	<!-- Google Font: Source Sans Pro -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
	<!-- Font Awesome -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
	<!-- Theme style -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/dist/css/adminlte.min.css">
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
							<div class="card card-primary">
								<div class="card-header">
									<h3 class="card-title">회원 수정 페이지</h3>
								</div>
				            	<form action="update" method="post" >
						            <div class="card-body">
										<input type="hidden" name="memId" value="${member.memId }">
										<div class="form-group">
											<label for="exampleInputPassword">비밀번호</label>
											<input class="form-control" type="password" name="memPass" id="exampleInputPassword" placeholder="비밀번호">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail">이메일</label>
											<input class="form-control" type="text" name="memEmail" id="exampleInputEmail" placeholder="이메일">
										</div>
										<div class="form-group">
											<label for="exampleInputPhone">전화번호</label>
											<input class="form-control" style="" type="text" name="memPhone" id="exampleInputPhone" placeholder="전화번호">
										</div>
						           	</div>
									<div class="card-footer">
										<input class="btn btn-primary" type="submit" value="수정">
										<a href="${pageContext.request.contextPath }/listDetail?memId=${member.memId }">
											<button class="btn btn-primary" type="button">목록</button>
										</a>
									</div>
								</form>
							</div>      				
      					</div>
					</div>
				</div>
				<div class="col-sm-2"></div>
			</div>
		</div>
	</div>
</body>
</html>
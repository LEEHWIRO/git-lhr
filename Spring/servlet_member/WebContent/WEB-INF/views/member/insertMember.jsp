<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>회원등록</title>
	
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
				<div class="col-sm-12">
					<div class="row">
						<div class="card col-sm-12">
							<div class="card card-primary">
								<div class="card-header">
									<h3 class="card-title">회원 등록 페이지</h3>
								</div>
				            	<form action="insert" method="post" >
						            <div class="card-body">
										<div class="form-group">
											<label for="exampleInputId">아이디</label>
											<input class="form-control"  type="text" name="memId"  id="exampleInputId" placeholder="아이디">
										</div>
										<div class="form-group">
											<label for="exampleInputPassword">비밀번호</label>
											<input class="form-control" type="password" name="memPass" id="exampleInputPassword" placeholder="비밀번호">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail">이메일</label>
											<input class="form-control" type="text" name="memEmail" id="exampleInputEmail" placeholder="이메일">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail">회원상태</label>&nbsp&nbsp&nbsp
											<input class="custom-checkbox" type="checkbox" value="0" name="memEnabled" id="enabled1" >
											<label for="enabled1">퇴사</label>&nbsp&nbsp
											<input class="custom-checkbox" type="checkbox" value="1" name="memEnabled" id="enabled2" >
											<label for="enabled2">입사</label>&nbsp&nbsp
											<input class="custom-checkbox" type="checkbox" value="2" name="memEnabled" id="enabled3">
											<label for="enabled3">휴직</label>
										</div>
										<div class="form-group">
											<label for="exampleInputPhone">전화번호</label>
											<input class="form-control" type="text" name="memPhone" id="exampleInputPhone" placeholder="전화번호">
										</div>
										<div class="form-group">
											<label for="exampleInputPhone">이름</label>
											<input class="form-control" type="text" name="memName" id="exampleInputName" placeholder="이름">
										</div>
										<div class="form-group">
											<label for="exampleInputPhone">주소</label>
											<input class="form-control" type="text" name="memAddress" id="exampleInputAddress" placeholder="주소">
										</div>
						           	</div>
									<div class="card-footer">
										<input class="btn btn-primary" type="submit" value="등록">
										<a href="${pageContext.request.contextPath }/list">
											<button class="btn btn-primary" type="button">목록</button>
										</a>
									</div>
								</form>
							</div>      				
      					</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
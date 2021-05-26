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
				<div class="col-sm-2"></div>
				<div class="col-sm-8">
					<div class="row">
						<div class="card col-sm-12"></div>
						<div class="card col-sm-12">
							<div class="card card-primary">
								<div class="card-header">
									<h3 class="card-title">공지사항 등록 페이지</h3>
								</div>
				            	<form action="insert" method="post" >
						            <div class="card-body">
										<div class="form-group">
											<label for="exampleInputId">제목</label>
											<input class="form-control"  type="text" name="title"  id="exampleInputNno" placeholder="번호">
										</div>
										<div class="form-group">
											<label for="exampleInputPassword">작성자</label>
											<input class="form-control" type="password" name="writer" id="exampleInputWriter" placeholder="작성자">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail">내용</label>
											<input class="form-control" type="text" name="content" id="exampleInputContent" placeholder="내용">
										</div>
						           	</div>
									<div class="card-footer">
										<input class="btn btn-primary" type="submit" value="등록">
										<a href="${pageContext.request.contextPath }/listNotice">
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
<%@page import="kr.or.ddit.notice.dto.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>공지사항 수정 페이지</title>
	
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
									<h3 class="card-title">공지사항 수정 페이지</h3>
								</div>
				            	<form action="updateNotice" method="post" >
						            <div class="card-body">
										<input type="hidden" name="nno" value="${notice.nno }">
										<div class="form-group">
											<label for="exampleInputPassword">제목</label>
											<input class="form-control" type="text" name="title" id="exampleInputTitle" placeholder="제목">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail">내용</label>
											<input class="form-control" type="text" name="content" id="exampleInputContent" placeholder="내용">
										</div>
						           	</div>
									<div class="card-footer">
										<input class="btn btn-primary" type="submit" value="수정">
										<a href="${pageContext.request.contextPath }/listDetailNotice?nno=${notice.nno }">
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
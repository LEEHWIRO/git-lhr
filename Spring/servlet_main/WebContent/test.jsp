<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/adminlte.min.css">
<title></title>
</head>
<body>
	<div class="card card-primary card-outline">
		<div class="card-header">
			<h3 class="card-title">공지사항 등록 페이지</h3>
		</div>
		<!-- /.card-header -->
		<div class="card-body">
			<div class="form-group">
				<input class="form-control" name="title" placeholder="제목">
			</div>
			<div class="form-group">
				<input class="form-control" name="writer" value="mimi" placeholder="작성자">
			</div>
			<div class="form-group">
				<div class="note-editor note-frame card">
					<div class="note-editing-area">
						<textarea class="form-control" name="content" 
							 style="height: 500px; ">
						</textarea>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
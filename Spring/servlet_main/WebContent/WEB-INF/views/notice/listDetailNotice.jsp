<%@page import="kr.or.ddit.dto.NoticeVO"%>
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
	<title>공지사항 상세</title>
</head>
<body>
	<div class="content">
		<div class="container-fluid">
			<div class = "row">
				<div class="col-sm-12">
					<div class="row">
						<div class="card col-sm-12">
							<div class="card card-primary card-outline">
								<div class="card-header">
									<h1 class="card-title">${notice.nno}번 공지사항 상세 페이지</h1>
					            </div>
					            <div class="card-body">
					            	<div class="col-sm-12">
							            <div class = "row">
							            	<div class="col-sm-9">
							            		<p>${notice.title }</p>
							            	</div>
							            	<div class="col-sm-1">
					            				<a  href="<%=request.getContextPath() %>/notice/list.do">
					            					<button style="width: 80px; float: right;" class="btn btn-primary" type="button">목록</button>
				            					</a>		
							            	</div>
							            	<div class="col-sm-1">
					            				<a  href="<%=request.getContextPath() %>/notice/modifyForm.do?nno=${notice.nno }">
					            					<button style="width: 80px; float: right;" class="btn btn-primary" type="button">수정</button>
				            					</a>		
							            	</div>
							            	<div class="col-sm-1">
					            				<a  href="<%=request.getContextPath() %>/notice/remove.do?nno=${notice.nno }">
					            					<button style="width: 80px; float: right;" class="btn btn-primary" type="button">삭제</button>
				            					</a>		
							            	</div>
							            </div>
						            </div>
						            <div class="col-sm-12">
						            	<div class = "row">
						            		<div class="col-sm-12">&nbsp</div>
						            	</div>
						            </div>
						            <div class="card card-light card-outline">
						              <div class="card-header">
						                <h5 class="card-title">${notice.title }</h5>
						                <div class="card-tools">
						                  <a href="#" class="btn btn-tool">
						                    <i class="fas">${notice.writer }&nbsp/&nbsp</i>
						                    <i class="fas">${notice.regdate }</i>
						                  </a>
						                </div>
						              </div>
						              <div style="height: 500px;" class="card-body">
						                <p>
						                  ${notice.content }
						                </p>
						              </div>
						            </div>
					           	</div>
							</div>      				
      					</div>
					</div>
				</div>
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
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
    <!-- Google Font: Source Sans Pro -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
	<!-- Font Awesome -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
	<!-- Theme style -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/dist/css/adminlte.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/list.css">
	<title>공지사항상세</title>
</head>
<body>
	<div class="content">
		<div class="container-fluid">
			<div class = "row">
				<div class="col-sm-12">
					<div class="row">
						<div class="card col-sm-12">
							<div class="card">
								<div class="card-header">
									<h1 class="card-title">공지사항상세</h1>
					            </div>
					            <div class="card-body">
					            	<div class="col-sm-12">
							            <div class = "row">
							            	<div class="col-sm-9"></div>
							            	<div class="col-sm-1">
					            				<a  href="${pageContext.request.contextPath }/listNotice">
					            					<button style="width: 80px; float: right;" class="btn btn-primary" type="button">목록</button>
				            					</a>		
							            	</div>
							            	<div class="col-sm-1">
					            				<a  href="${pageContext.request.contextPath }/updateNotice?nno=${notice.nno }">
					            					<button style="width: 80px; float: right;" class="btn btn-primary" type="button">수정</button>
				            					</a>		
							            	</div>
							            	<div class="col-sm-1">
					            				<a  href="${pageContext.request.contextPath }/deleteNotice?nno=${notice.nno }">
					            					<button style="width: 80px; float: right;" class="btn btn-primary" type="button">삭제</button>
				            					</a>		
							            	</div>
							            </div>
						            </div>
									<table class="table table-bordered">
										<thead>
											<tr>
												<th>번호</th>
												<th>제목</th>
												<th>작성자</th>
												<th>내용</th>
												<th>작성날짜</th>
												<th>수정날짜</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>${notice.nno }</td>
												<td>${notice.title }</td>
												<td>${notice.writer }</td>
												<td>${notice.content }</td>
												<td>${notice.regdate }</td>
												<td>${notice.updatedate }</td>
											</tr>
										</tbody>
									</table>
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
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.ddit.dto.NoticeVO"%>
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
	<title>공지사항</title>
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
									<h1 class="card-title">공지사항</h1>
					            </div>
					            <div class="card-body">
					            	<div class="col-sm-12">
							            <div class = "row">
							            	<div class="col-sm-11"></div>
							            	<div class="col-sm-1">
					            				<a  href="<%=request.getContextPath() %>/notice/registForm.do">
					            					<button style="width: 80px; float: right;" class="btn btn-primary" type="button">등록</button>
				            					</a>		
							            	</div>
							            </div>
					            	</div>
					            	<div class="col-sm-12">
						            	<div class = "row">
						            		<div class="col-sm-12">&nbsp</div>
						            	</div>
						            </div>
									<table class="table table-bordered">
										<thead>
											<tr>
												<th>번호</th>
												<th>제목</th>
												<th>작성자</th>
												<th>작성날짜</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="i" begin="0" end="${noticeList.size()-1 }" step="1">
											<c:if test="${empty noticeList }">
												<tr>
													<td colspan="4">해당 내용이 없습니다.</td>
												</tr>
											</c:if>	
											<tr>
												<td><a href="<%=request.getContextPath() %>/notice/detail.do?nno=${noticeList[i].nno }">${noticeList[i].nno }</a></td>
												<td>${noticeList[i].title }</td>
												<td>${noticeList[i].writer }</td>
												<td>${noticeList[i].regdate }</td>
											</tr>
											</c:forEach>	
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
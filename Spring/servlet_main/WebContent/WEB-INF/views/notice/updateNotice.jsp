<%@page import="kr.or.ddit.dto.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
</head>
<title>공지사항 수정 페이지</title>
<body>
	<div class="content">
		<div class="container-fluid">
			<div class = "row">
				<div class="col-sm-12">
					<div class="row">
						<div class="card col-sm-12">
							<div class="card card-primary card-outline">
								<div class="card-header">
									<h3 class="card-title">${notice.nno }번 공지사항 수정 페이지</h3>
								</div>
				            	<form action="<%=request.getContextPath() %>/notice/update.do" method="post" >
						            <div class="card-body">
										<input type="hidden" name="nno" value="${notice.nno }">
										<div class="form-group">
											<label for="exampleInputPassword">작성자</label>
											<input class="form-control" type="text" name="writer" id="exampleInputWriter" value="${notice.writer }" placeholder="작성자" readonly="readonly">
										</div>
										<div class="form-group">
											<label for="exampleInputPassword">제목</label>
											<input class="form-control" type="text" name="title" id="exampleInputTitle" placeholder="제목">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail">내용</label>
											<textarea style="height: 300px; " class="form-control" name="content" id="exampleInputContent" placeholder="내용"></textarea>
										</div>
						           	</div>
									<div class="card-footer">
										<input class="btn btn-primary" type="submit" value="수정">
										<a href="<%=request.getContextPath() %>/notice/list.do?nno=${nno }">
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
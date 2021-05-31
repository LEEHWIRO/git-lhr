<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.ddit.dto.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/list.css">
</head>
<title>공지사항</title>
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
							            	<div class="col-sm-8"></div>
								            	<div class="col-sm-2">
								            		<div id="keyword" class="card-tools" style="width: 550px;">
														<div class="input-group row">
															<select class="form-control col-md-3" name="perPageNum" id="perPageNum"
																onchange="list_go()">
																<option value="10">정렬개수</option>
																<option value="2">2개씩</option>
																<option value="3">3개씩</option>
																<option value="5">5개씩</option>
															</select>
														</div>
													</div>
								            	</div>
								            <div class="col-sm-1"></div>	
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
												<th>조회수</th>
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
												<td>
													<fmt:formatDate value="${noticeList[i].regdate }" pattern="yyyy-MM-dd"/>
												</td>
												<td>${noticeList[i].viewcnt }</td>											</tr>
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
	<form id="jobForm">
		<input type="hidden" name="page" value=""/>
		<input type="hidden" name="perPageNum" value=""/>
	</form>	
	<script type="text/javascript">
		<c:if test="${not empty msg}">
			alert("${msg}")
		</c:if>
			
		function list_go(){
// 			alert("change!");
			$('input[name="perPageNum"]').val($('select#perPageNum').val());
			
			$('form#jobForm').attr({
				action:'list.do',
				method:'get'
			}).submit();
		}	
	</script>
</body>
</body>

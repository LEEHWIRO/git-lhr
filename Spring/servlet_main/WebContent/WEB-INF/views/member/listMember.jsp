<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.ddit.dto.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/list.css">
</head>
<title>회원리스트</title>
<body>
	<div class="content">
		<div class="container-fluid">
			<div class = "row">
				<div class="col-sm-12">
					<div class="row">
						<div class="card col-sm-12">
							<div class="card card-primary card-outline">
								<div class="card-header">
									<h1 class="card-title">회원 리스트</h1>
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
				            				<a  href="<%=request.getContextPath() %>/member/registForm.do">
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
											<th>아이디</th>
											<th>비밀번호</th>
											<th>이메일</th>
											<th>전화번호</th>
											<th>등록날짜</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="i" begin="0" end="${memberList.size()-1 }" step="1">
										<c:if test="${empty memberList }">
											<tr>
												<td colspan="4">해당 내용이 없습니다.</td>
											</tr>
										</c:if>	
										<tr>
											<td><a href="<%=request.getContextPath() %>/member/detail.do?id=${memberList[i].id }">${memberList[i].id }</a></td>
											<td>${memberList[i].pwd }</td>
											<td>${memberList[i].email }</td>
											<td>${memberList[i].phone }</td>
											<td>
												<fmt:formatDate value="${memberList[i].regdate }" pattern="yyyy-MM-dd"/>
											</td>
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

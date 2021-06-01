<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.ddit.dto.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="cri" value="${pageMaker.cri }" />
<head>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/list.css">
</head>
<title>공지사항</title>
<body>
	<section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>공지사항 목록</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="list.do">
				        	<i class="fa fa-dashboard"></i>공지사항
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	목록
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
	</section>
	<section class="content">
		<div class="card card-primary card-outline">
			<div class="card-header with-border">
				<button type="button" class="btn btn-primary" onclick="OpenWindow('registForm.do','공지등록',800,700)">회원등록</button>
  				<div id="keyword" class="card-tools" style="width:550px;">
  					 <div class="input-group row">	
  					 	  <!-- sort num -->
				  	<select class="form-control col-md-3" name="perPageNum" id="perPageNum"
				  		onchange="list_go();">
				  		<option value="10" >정렬개수</option>
				  		<option value="2" ${cri.perPageNum == 2 ? 'selected':''}>2개씩</option>
				  		<option value="3" ${cri.perPageNum == 3 ? 'selected':''}>3개씩</option>
				  		<option value="5" ${cri.perPageNum == 5 ? 'selected':''}>5개씩</option>
				  		
				  	</select>
				  	
				  	  <!-- search bar -->
				 	<select class="form-control col-md-3" name="searchType" id="searchType">
						<option value=""  ${cri.searchType eq '' ? 'selected':''}>검색구분</option>
						<option value="n"  ${cri.searchType eq 'n' ? 'selected':''}>번호</option>
						<option value="t"  ${cri.searchType eq 't' ? 'selected':''}>제목</option>
						<option value="w"  ${cri.searchType eq 'w' ? 'selected':''}>작성자</option>
					</select>
					<input  class="form-control" type="text" name="keyword" 
									placeholder="검색어를 입력하세요." value="${cri.keyword }"/>
					<span class="input-group-append">
						<button class="btn btn-primary" type="button" 
								id="searchBtn" data-card-widget="search" onclick="list_go(1);">
							<i class="fa fa-fw fa-search"></i>
						</button>
					</span>
				<!-- end : search bar -->		
  					 </div>
  				</div>   		
           </div>
           <div class="card-body">
            	<div class = "row">
            		<div class="col-sm-12">
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
           	<div class="card-footer">
	   			 <c:set var="list_url" value="list.do"/>
	   			 <%@ include file="/WEB-INF/views/common/pagination.jsp" %>
	   		</div>
		</div>      				
	</section>
	<script src="/resources/js/common.js"></script>
	<script type="text/javascript">
		<c:if test="${not empty msg}">
			alert("${msg}")
		</c:if>
	</script>
</body>

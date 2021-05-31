<%@page import="kr.or.ddit.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/list.css">
</head>
<title>회원상세리스트</title>
<body>
	<div class="content">
		<div class="container-fluid">
			<div class = "row">
				<div class="col-sm-12">
					<div class="row">
						<div class="card col-sm-12">
							<div class="card card-primary card-outline">
								<div class="card-header">
									<h1 class="card-title">회원 상세 리스트</h1>
					            </div>
					            <div class="card-body">
						            <div class="col-sm-12">
							            <div class = "row">
							            	<div class="col-sm-9"></div>
							            	<div class="col-sm-1">
					            				<a  href="<%=request.getContextPath() %>/member/list.do">
					            					<button style="width: 80px; float: right;" class="btn btn-primary" type="button">목록</button>
				            					</a>		
							            	</div>
							            	<div class="col-sm-1">
					            				<a  href="<%=request.getContextPath() %>/member/modifyForm.do?id=${member.id }">
					            					<button style="width: 80px; float: right;" class="btn btn-primary" type="button">수정</button>
				            					</a>		
							            	</div>
							            	<div class="col-sm-1">
					            				<a  href="<%=request.getContextPath() %>/member/remove.do?id=${member.id }">
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
						            <div class="col-sm-12">
						            	<div class="col-sm-12">
						            		<div class = "row">
						            			<div class="col-sm-11">
												<div class="form-group">
													<label for="exampleInputPassword">아이디</label>
													<input class="form-control" type="text" name="id" value="${member.id }" readonly="readonly">
												</div>
												</div>
												<div class="col-sm-1">
													<img alt="사진없음" style="width: 100px; height: 100px;" src="<%=request.getContextPath() %>/resources/images/${member.picture }">
												</div>
											</div>
										</div>
										<div class="form-group">
											<label for="exampleInputPassword">비밀번호</label>
											<input class="form-control" type="text" name="memPass" id="exampleInputPassword" value="${member.pwd }" readonly="readonly">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail">이메일</label>
											<input class="form-control" type="text" name="memEmail" id="exampleInputEmail" value="${member.email }" readonly="readonly">
										</div>
										<div class="form-group">
										<c:if test="${member.enabled == 0 }">
											<label for="exampleInputEmail">회원상태</label>
											<input class="form-control" type="text" name="enabled" id="enabled" value="퇴사" readonly="readonly">
										</c:if>
										<c:if test="${member.enabled == 1 }">
											<label for="exampleInputEmail">회원상태</label>
											<input class="form-control" type="text" name="enabled" id="enabled" value="재직" readonly="readonly">
										</c:if>
										<c:if test="${member.enabled == 2 }">
											<label for="exampleInputEmail">회원상태</label>
											<input class="form-control" type="text" name="enabled" id="enabled" value="휴직" readonly="readonly">
										</c:if>
										</div>
										<div class="form-group">
											<label for="exampleInputPhone">등록날짜</label>
											<input class="form-control" type="text" name="regdate" id="regdate" 
												value="<fmt:formatDate value="${member.regdate }" pattern="yyyy-MM-dd"/>" readonly="readonly">
										</div>
										<div class="form-group">
											<label for="exampleInputPhone">전화번호</label>
											<input class="form-control" type="text" name="memPhone" id="exampleInputPhone" value="${member.phone }" readonly="readonly">
										</div>
										<div class="form-group">
											<label for="exampleInputPhone">이름</label>
											<input class="form-control" type="text" name="name" id="name" value="${member.name }" readonly="readonly">
										</div>
										<div class="form-group">
											<label for="exampleInputPhone">등록자</label>
											<input class="form-control" type="text" name="register" id="register" value="${member.register }" readonly="readonly">
										</div>
										<div class="form-group">
											<label for="exampleInputPhone">주소</label>
											<input class="form-control" type="text" name="address" id="address" value="${member.address }" readonly="readonly">
										</div>
										<div class="form-group">
											<label for="exampleInputPhone">권한</label>
											<input class="form-control" type="text" name="authority" id="authority" value="${member.authority }" readonly="readonly">
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

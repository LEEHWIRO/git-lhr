<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<title>공지사항</title>

<body>

	<!-- Content Wrapper. Contains page content -->
<div>
  	<section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>등록페이지</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="#">
				        	<i class="fa fa-dashboard">공지등록</i>
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	공지작성
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
  	</section>
	<!-- Main content -->
	<section class="content">
			<div class="login-logo">
    			<a href="<%=request.getContextPath()%>/member/registForm.do"><b>공지등록</b></a>
  			</div>
			<!-- form start -->
			<div class="card">				
				<div class="register-card-body">
					<form role="form" class="form-horizontal" action="regist.do" method="post">						
						  <div class="form-group row">
							 <label for="writer" class="col-sm-3" style="font-size:0.9em;" >
							 	<span style="color:red;font-weight:bold;">*</span>작성자</label>	
							<div class="col-sm-9 input-group input-group-sm">
								<input name="writer" 
								type="text" class="form-control" id="writer" placeholder="작성자을 입력하세요">
							</div>								
						</div>
						<div class="form-group row">
							<label for="title" class="col-sm-3" style="font-size:0.9em;">
								<span style="color:red;font-weight:bold;">*</span>제목</label>
							<div class="col-sm-9 input-group-sm">								
								<input class="form-control" name="title" type="text" class="form-control" id="title"
										placeholder="제목을 입력하세요" />
							</div>
							
						</div>
						<div class="form-group row">
							<label for="content" class="col-sm-3" style="font-size:0.9em;">
								<span style="color:red;font-weight:bold;">*</span>내용</label>
							<div class="col-sm-9 input-group-sm">								
								<textarea class="form-control" name="content" type="text" class="form-control" id="content"
										placeholder="내용을 입력하세요" style="height: 300px;"></textarea>
							</div>
							
						</div>		
						
						<div class="card-footer">
							<div class="row">								
								<div class="col-sm-6">
									<button type="button" id="registBtn" onclick="regist_go()" class="btn btn-info">작성하기</button>
							 	</div>
							 	
							 	<div class="col-sm-6">
									<button type="button" id="cancelBtn" onclick="CloseWindow()"
										class="btn btn-default float-right">&nbsp;&nbsp;&nbsp;취 &nbsp;&nbsp;소&nbsp;&nbsp;&nbsp;</button>
								</div>
							
							</div>
						</div>
					</form>					
				</div><!-- register-card-body -->
			</div>
	</section>		<!-- /.content -->
</div>
<!-- /.content-wrapper -->



<script src="/resources/js/notice/regist.js"></script>


</body>
</html>












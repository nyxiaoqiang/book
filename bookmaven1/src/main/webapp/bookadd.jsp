<%@page import="java.util.List"%>
<%@page import="cn.edu.nyist.bookmaven1.vo.GetTypesVo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>s书籍添加</title>
<link href="bs/css/darkly/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bower_components/jquery-date-range-picker/dist/daterangepicker.min.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
.control-label, .btn-default {
	color: black;
	font-size: 4mm;
}
</style>
</head>
<body>
	<div class="container-fluid well">
		<div class="row">
			<div class="col-md-12">
				<form class="form-horizontal" role="form" method="post"
					action="bookadd" id="theform" enctype="multipart/form-data">
					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label"> 书名
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputName"
								name="name" />
						</div>
					</div>
					<div class="form-group">

						<label for="inputDescrib" class="col-sm-2 control-label">
							描述 </label>
						<div class="col-sm-10">
							<textarea rows="3" class="form-control" id="inputDescrib"
								name="describ">   
							</textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="selectTid" class="col-sm-2 control-label"> 类型
						</label>
						<div class="col-sm-10">
							<select name="id" class="form-control" id="selectTid">
								<% 
								List<GetTypesVo> li=(List<GetTypesVo>)request.getAttribute("li");
								    
									for(int i=0;i<li.size();i++){
										%>
										<option value="<%=li.get(i).getId()%>"><%=li.get(i).getName()%></option>
										<%
									}
								%>

							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPhoto" class="col-sm-2 control-label"> 图片
						</label>
						<div class="col-sm-10">
							<input type="file" class="form-control" id="inputPhoto"
								name="photo" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPrice" class="col-sm-2 control-label"> 价格
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputPrice"
								name="price" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputAuthor" class="col-sm-2 control-label">
							作者 </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputAuthor"
								name="author" />
						</div>
					</div>
										<div class="form-group">
						<label for="inputpubDate" class="col-sm-2 control-label">
							出版日期 </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputpubDate"
								name="pubDate" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="bower_components/jquery/dist/jquery.min.js">
		
	</script>
	<script type="text/javascript"
		src="bower_components/bootstrap/dist/js/bootstrap.min.js">
		
	</script>
	<script type="text/javascript"
		src="bower_components/jquery-validate/dist/jquery.validate.min.js">	
	</script>
	<script type="text/javascript" src="bower_components/moment/moment.js">
	</script>
	<script type="text/javascript" src="bower_components/jquery-date-range-picker/dist/jquery.daterangepicker.min.js">
	</script>
	<script type="text/javascript">
		$("#theform").validate({
			rules : {
				name : {
					required : true
				},
				pwd : {
					required : true
				}
			},
			messages : {
				name : "输入不能为空",
				pwd : "输入不能为空"
			},
			tooltip_options : {

				name : {
					placement : 'left',
				},
				desc : {
					placement : 'left',
				}
			}
		});
		$('#inputpubDate').dateRangePicker({
			autoClose: true,
			format: 'YYYY-MM-DD',
			language: 'cn',
			autoClose: true,
			singleDate : true,
			showShortcuts: false,
			singleMonth: true
});

	</script>
</body>
</html>
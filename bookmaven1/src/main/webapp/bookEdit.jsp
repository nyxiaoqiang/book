<%@page import="cn.edu.nyist.bookmaven1.vo.BookVo"%>
<%@page import="java.util.List"%>
<%@page import="cn.edu.nyist.bookmaven1.vo.GetTypesVo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>s书籍修改</title>
<link href="bs/css/darkly/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link
	href="bower_components/jquery-date-range-picker/dist/daterangepicker.min.css"
	rel="stylesheet" type="text/css" />
<style type="text/css">
.control-label, .btn-default {
	color: black;
	font-size: 4mm;
}
</style>
</head>
<body>
<div class="col-md-12">
					<div class="navbar-header">

						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span><span
								class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="main.jsp">图书管理主系统</a>
					</div>

					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">书籍管理<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li><a href="bookList">查看书籍</a></li>
									<li><a href="bookadd.jsp">添加书籍</a></li>
								</ul></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="#">修改密码</a></li>
							<li><a href="#">登录</a></li>
							<li><a href="#">退出</a></li>
						</ul>
					</div>
			<div  class="col-md-12">
				<div class="text-center" style="overflow: hidden;"><h2 style="color: green">图书修改界面</h2></div>
			</div>
			<%
				BookVo bookVo=(BookVo)request.getAttribute("bookVo");
			%>
	<div class="container-fluid well">
		<div class="row">
			<div class="col-md-12 text-center" style="width: 50%;margin-left: 30%">
				<form class="form-horizontal" role="form" method="post"
					action="doEdit" id="theform" enctype="multipart/form-data">
					<input type="hidden" value="<%=bookVo==null?"":bookVo.getTid() %>" name="tid">
					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label"> 书名
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" value="<%=bookVo==null?"":bookVo.getName()%>"id="inputName"
								name="name" />
						</div>
					</div>
					<div class="form-group">

						<label for="inputDescrib" class="col-sm-2 control-label">
							描述 </label>
						<div class="col-sm-10">
							<textarea rows="3" class="form-control"  id="inputDescrib"
								name="describ" ><%=bookVo==null?"":bookVo.getDescrib()%></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="selectTid" class="col-sm-2 control-label"> 类型
						</label>
						<div class="col-sm-10">
							<select name="id" class="form-control" id="selectTid">

							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="inputPhoto" class="col-sm-2 control-label"> 图片
						</label>
						<div class="col-sm-6">
							<input type="file" class="form-control" id="inputPhoto"
								name="photo" />
						</div>
						<div class="col-sm-4">
						<img alt="" src="upload/<%=bookVo==null?"":bookVo.getNewName()%>"
								width="150px" height="150px"></div>
					</div>
					<div class="form-group">
						<label for="inputPrice" class="col-sm-2 control-label"> 价格
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" value="<%=bookVo==null?"":bookVo.getPrice()%>" id="inputPrice"
								name="price" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputAuthor" class="col-sm-2 control-label">
							作者 </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" value="<%=bookVo==null?"":bookVo.getAuthor() %>" id="inputAuthor"
								name="author" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputpubDate"  class="col-sm-2 control-label">
							出版日期 </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" value="<%=bookVo==null?"":bookVo.getPubDate()%>" id="inputpubDate"
								name="pubDate" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default text-center" style=" width: 100px;">提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</div>
	<script type="text/javascript"
		src="bower_components/jquery/dist/jquery.min.js">
		
	</script>
	<script type="text/javascript"
		src="/bower_components/jquery-validation/dist/jquery.validate.js">
		
	</script>
	<script type="text/javascript"
		src="bower_components/bootstrap/dist/js/bootstrap.min.js">
		
	</script>
	<script type="text/javascript"
		src="bower_components/jquery-validate/dist/jquery.validate.min.js">
	</script>
	<script type="text/javascript" src="bower_components/moment/moment.js">
		
	</script>
	<script type="text/javascript"
		src="bower_components/jquery-date-range-picker/dist/jquery.daterangepicker.min.js">
		
	</script>
	<script type="text/javascript">

		$("#theform").validate({
			rules : {
				name : {
					required : true
				},
				describ : {
					required : true
				},
				price : {
					required : true
				},
				author : {
					required : true
				}
			},
			messages : {
				name : "输入不能为空",
				describ : "输入不能为空",
				price : "输入不能为空",
				author : "输入不能为空",
				
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
			autoClose : true,
			format : 'YYYY-MM-DD',
			language : 'cn',
			autoClose : true,
			singleDate : true,
			showShortcuts : false,
			singleMonth : true
		});
	</script>
	<script type="text/javascript">
		/*这个函数必须写到函数的使用上面必须先定义再使用*/
		function typeSel(types) {
			var sel = document.getElementById("selectTid");
			for (var i = 0; i < types.length; i++) {
				sel.appendChild(new Option(types[i].name, types[i].id));
			}
		}
	</script>
	<iframe src="getAllTypes" style="display: none"></iframe>
	<!-- onload 表示javaScript加载完毕，再去找var types这样才能找到 -->
	<!--  <script type="text/javascript" src="getAllTypes"></script>-->
	<!-- v6版本用ifram实现 -->
</body>
</html>
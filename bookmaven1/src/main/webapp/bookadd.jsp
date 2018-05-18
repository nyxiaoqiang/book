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
				sel.appendChild(new Option(types[i].name), types[i].id);
			}
		}
	</script>
	<iframe src="getAllTypes" style="display: none"></iframe>
	<!-- onload 表示javaScript加载完毕，再去找var types这样才能找到 -->
	<!--  <script type="text/javascript" src="getAllTypes"></script>-->
	<!-- v6版本用ifram实现 -->
</body>
</html>
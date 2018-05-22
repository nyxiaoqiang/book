<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录界面</title>
<link href="bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="bower_components/bootswatch-master/dist/slate/bootstrap.css"
	rel="stylesheet" type="text/css" />
<style type="text/css">
.container-fluid {
	width: 40%;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-left: -247px;
	margin-top: -79px;
}
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
					action="login" id="theform">
					<div class="alert alert-warning" role="alert"><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg")%></div>
					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label"> 账号
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputName"
								name="name"
								value="<%=request.getAttribute("name") == null ? "" : request.getAttribute("name")%>" />
						</div>
					</div>
					<div class="form-group">

						<label for="inputPassword3" class="col-sm-2 control-label">
							密码 </label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="inputPassword"
								name="pwd" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">
							验证码 </label>
						<div class="col-sm-6">
							<!-- 6代表输入框占六份，验证码占4份的宽度 -->
							<input type="password" class="form-control" id="inputPassword"
								name="vcode" />
						</div>
						<div class="col-sm-4">
							<img alt="" src="vcode.png" id="myimg">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">登录</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="bower_components/jquery/dist/jquery.min.js">
	</script>
	<script type="text/javascript"
		src="bower_components/bootstrap/dist/js/bootstrap.min.js">
	</script>
	<script type="text/javascript" src="bower_components/jquery-validate/dist/jquery.validate.min.js">
	</script>
	<script type="text/javascript">
		$(function() {
			$("#myimg").click(function(evt) {
				this.src = "vcode.png?t=" + Math.random();
			})
		});
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
			pwd : {
				placement : 'left',
			}
		}
	});
	</script>

</body>
</html>
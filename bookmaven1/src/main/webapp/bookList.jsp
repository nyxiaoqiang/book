<%@page import="java.sql.Types"%>
<%@page import="cn.edu.nyist.bookmaven1.vo.BookVo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
	<%
	/*	这是实现权限拦截的
	 * if(request.getSession().getAttribute("LoginSuccess")==null||!request.getSession().getAttribute("LoginSuccess").equals("1")) 
		{
			response.sendRedirect("login.jsp");
			return;
		}*/
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>图书管理主界面</title>
<!-- 告诉浏览器不要缩放 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="bs/css/darkly/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<style type="text/css">
.table_bordered tr {
	border: 1px solid black;
}
<%
		String findByType=(String)request.getAttribute("findByType");
		String findByName=(String)request.getAttribute("findByName");
%>
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-default" role="navigation">
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

				</nav>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-condensed table-hover table_bordered">
					<thead>
						<tr>
							<td colspan="9" class="text-center">
								<form class="form-inline " Id="serchFrm" method="post">
									<div class="form-group">
										<label for="exampleInputName2">书名</label> 
										<input type="text" class="form-control" id="exampleInputName2" 
										<% 
										if(!(findByName==null||"".equals(findByName)||"null".equals(findByName))){
											%>
											value="<%=findByName %>"
											<%
										}
										%>
										 name="findByName" placeholder="输入姓名">
									</div>
									<div class="form-group">
										<label for="exampleInputEmail2">类型</label> <input
											type="text" class="form-control" 											<% 
										if(!(findByType==null||"".equals(findByType)||"null".equals(findByType))){
											%>
											value="<%=findByType %>"
											<%
										}
										%>
											name="findByType" id="exampleInputEmail2"
											placeholder="输入类型">
									</div>
									<button type="submit" class="btn btn-default" id="whenClick">查找</button>
								</form>
							</td>
						</tr>
						<tr>
							<td>序号</td>
							<td>图片</td>
							<td>书名</td>
							<td>描述</td>
							<td>类型</td>
							<td>作者</td>
							<td>价格</td>
							<td>出版日期</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody>
						<%
							List<BookVo> li = (List<BookVo>) request.getAttribute("li");
							int pageNum = (Integer) request.getAttribute("pageNum");
							for (BookVo bookvo : li) {
						%>
						<tr>
							<td><%=bookvo.getTid()%></td>
							<td><img alt="" src="upload/<%=bookvo.getNewName()%>"
								width="150px" height="150px"></td>
							<td><%=bookvo.getName()%></td>
							<td><%=bookvo.getDescrib()%></td>
							<td><%=bookvo.getId()%></td>
							<td><%=bookvo.getAuthor()%></td>
							<td><%=bookvo.getPrice()%></td>
							<td><%=bookvo.getPubDate()%></td>
							<td><!-- bookDel?pageNum=3&tid=41 -->
								<a href="bookDel?pageNum=<%=pageNum%>&tid=<%=bookvo.getTid()%>" class="glyphicon glyphicon-remove" title="删除" onclick="confirmDel(event)"></a>&nbsp;&nbsp;
								<a href="<%=bookvo.getTid()%>" class="glyphicon glyphicon-pencil" title="修改"></a>
							</td>
						</tr>
						<%
							}
						%>
					</tbody>
					<tr>
						<td colspan="9" style="padding: 0px" class="text-center">
							<ul class="pagination active" style="color: #666666">
								<%
									int totalPage = (Integer) request.getAttribute("totalPage");
								    //int pageNum = (Integer) request.getAttribute("pageNum");
									if (pageNum > 1) {
								%>
								<li><a href="bookList?pageNum=<%=pageNum - 1%>">上一页</a></li>
								<%
									}
									if (totalPage <= 5) {/*如果总页数很少在五页以内的话全部输出出啦*/
										for (int i = 1; i <= totalPage; i++) {
								%>
								<li><a href="bookList?pageNum=<%=i%>"><%=i%></a></li>
								<%
									}
									} else if (pageNum <= 3) {/*如果是总页数多于五页，但是当前页在三页或者三页以内的话输出一样*/
								%>
								<li><a href="bookList?pageNum=1">1</a></li>
								<li><a href="bookList?pageNum=2">2</a></li>
								<li><a href="bookList?pageNum=3">3</a></li>
								<li><a href="bookList?pageNum=4">4</a></li>
								<li><a href="bookList?pageNum=<%=totalPage%>">...<%=totalPage%></a></li>
								<%
									} else if (pageNum >= totalPage - 3) {//如果当前页在后三页以内的话显示是  1 。。。   t-3  t-2  t-1  t;
								%>
								<li><a href="bookList?pageNum=1">1...</a></li>
								<li><a href="bookList?pageNum=<%=totalPage - 3%>"><%=totalPage - 3%></a></li>
								<li><a href="bookList?pageNum=<%=totalPage - 2%>"><%=totalPage - 2%></a></li>
								<li><a href="bookList?pageNum=<%=totalPage - 1%>"><%=totalPage - 1%></a></li>
								<li><a href="bookList?pageNum=<%=totalPage%>"><%=totalPage%></a></li>
								<%
									} else {//如果是好多且当前页在中间部分1.。。      pageNum-1  pageNum  pageNum+1  totalPage
								%>
								<li><a href="bookList?pageNum=1">1...</a></li>
								<li><a href="bookList?pageNum=<%=pageNum - 1%>"><%=pageNum - 1%></a></li>
								<li><a href="bookList?pageNum=<%=pageNum%>"><%=pageNum%></a></li>
								<li><a href="bookList?pageNum=<%=pageNum + 1%>"><%=pageNum + 1%></a></li>
								<li><a href="bookList?pageNum=<%=totalPage%>">...<%=totalPage%></a></li>
								<%
									}
									if (pageNum < totalPage) {
								%>
								<li><a href="bookList?pageNum=<%=pageNum + 1%>">下一页</a></li>
								<%
									}
								%>
								<!-- <li><a href="#">上一页</a></li>
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">下一页</a></li> -->
							</ul>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<p>&copy;软件设计二班李雪强</p>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="bower_components/jquery/dist/jquery.min.js">
		
	</script>
	<script type="text/javascript"
		src="bower_components/bootstrap/dist/js/bootstrap.min.js">
	</script>
	<script type="text/javascript">
	$(function() {
		$('a[href="bookList?pageNum=<%=pageNum%>"]').parent("li").addClass("active");

	});
	$(".pagination a[href^='bookList?pageNum=']").click(function() {
		alert('sb')
//		this.href+="&pageNum="+<%=pageNum%>;
		this.href+="&"+$("#serchFrm").serialize();
	});
	$("#whenClick").click(function() {//当表单提交时，把当前页改成第一页
		alert('dsb')
//		this.href+="&pageNum=1";
//		this.href+="&"+$("#serchFrm").serialize();
		document.getElementById("serchFrm").action="?pageNum=1";
	});
		function confirmDel(event) {
			if(!confirm("确认删除")){
					event.preventDefault();
				}
		}
	</script>
</body>
</html>
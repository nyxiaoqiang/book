package cn.edu.nyist.bookmaven1.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.impl.NewPooledConnection;

import cn.edu.nyist.bookmaven1.Util.DsUtil;
import cn.edu.nyist.bookmaven1.biz.BookBiz;
import cn.edu.nyist.bookmaven1.biz.impl.BookBizImpl;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取输入的信息
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		//在数据库查询之前，验证验证码是否正确，正确了接着执行，不行返回本界面，且提示验证码输入有误
		String vcode=request.getParameter("vcode");
		HttpSession session = request.getSession(); 
		String serverVode=(String) session.getAttribute("validateCode");
		if(!vcode.equalsIgnoreCase(serverVode)) {
			request.setAttribute("name", name);
			request.setAttribute("msg", "验证码输入有误错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);;
		}else {
			BookBiz loginBiz=new BookBizImpl();
			boolean re=loginBiz.findByNameAndPwd(name,pwd);
			//3.给用户响应
			if(re) {
				response.sendRedirect("main.jsp");
			}else {
				request.setAttribute("name", name);
				request.setAttribute("msg", "用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}

	}

}

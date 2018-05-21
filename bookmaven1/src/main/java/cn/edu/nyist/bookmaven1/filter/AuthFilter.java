package cn.edu.nyist.bookmaven1.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/*")
public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		String url=req.getRequestURI();
		//��logon��login.jsp,js,css,png������
		System.out.println("Ȩ�޹��˿�ʼ");
		if(url.endsWith("/login")||url.endsWith("login.jsp")||url.contains("/bower_components/")||url.endsWith("vcode.png")) {
			chain.doFilter(request, response);
			System.out.println("Ȩ�޹��˽���");  
			return;
		}
		if(req.getSession().getAttribute("LoginSuccess")==null||!req.getSession().getAttribute("LoginSuccess").equals("1")) 
		{
			res.sendRedirect("login.jsp");
			System.out.println("Ȩ�޹��˽���");
			return;
		}else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}

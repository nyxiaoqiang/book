package cn.edu.nyist.bookmaven1.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nyist.bookmaven1.biz.BookBiz;
import cn.edu.nyist.bookmaven1.biz.impl.BookAddBizImpl;
import cn.edu.nyist.bookmaven1.biz.impl.BookBizImpl;

@WebServlet("/bookDel")
public class BookDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BookDelServlet() {
        super();
            }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*	这是实现权限拦截的
		 * if(request.getSession().getAttribute("LoginSuccess")==null||!request.getSession().getAttribute("LoginSuccess").equals("1")) 
			{
				response.sendRedirect("login.jsp");
				return;
			}*/
		String strTid=request.getParameter("tid");
		int tid = Integer.parseInt(strTid);
		BookBiz bookBiz = new BookBizImpl();
		bookBiz.delBookByTid(tid);
		String page=null;
		try {
			page=request.getParameter("pageNum");
		} catch (Exception e) {
		}
		if(page!=null) {
			int pageNum=Integer.parseInt(page);
			request.setAttribute("pageNum", pageNum);
		}
		
		request.getRequestDispatcher("bookList").forward(request, response);
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

package cn.edu.nyist.bookmaven1.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nyist.bookmaven1.biz.BookBiz;
import cn.edu.nyist.bookmaven1.biz.impl.BookBizImpl;
import cn.edu.nyist.bookmaven1.vo.BookVo;

@WebServlet("/bookEdit")
public class BookEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public BookEditServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.得到参数
		String tid=request.getParameter("tid");
		//2.掉业务层，根据书的tid查到这本书的信息
		BookBiz bookBiz=new BookBizImpl();
		System.out.println(tid);
		BookVo bookVo=bookBiz.getBookByTid(tid);
		//3.给用户相应
		request.setAttribute("bookVo", bookVo);
		request.getRequestDispatcher("bookEdit.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

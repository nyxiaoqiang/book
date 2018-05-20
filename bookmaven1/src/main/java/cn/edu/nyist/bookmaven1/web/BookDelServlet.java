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
		String strTid=request.getParameter("tid");
		int tid = Integer.parseInt(strTid);
		BookBiz bookBiz = new BookBizImpl();
		bookBiz.delBookByTid(tid);
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

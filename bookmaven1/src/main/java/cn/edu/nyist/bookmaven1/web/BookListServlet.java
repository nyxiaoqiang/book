package cn.edu.nyist.bookmaven1.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nyist.bookmaven1.biz.BookBiz;
import cn.edu.nyist.bookmaven1.biz.impl.BookBizImpl;
import cn.edu.nyist.bookmaven1.vo.BookVo;
//这是搞书籍显示的部分的
@WebServlet("/bookList")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookListServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取当前页数参数
		String strPageNum;
		int pageNum = 0;
		try {
			//客户端传过来的时候是String类型的，需要通过Interger包装类转换一下
			strPageNum = request.getParameter("pageNum");
			pageNum=Integer.parseInt(strPageNum);
		} catch (Exception e) {
			pageNum=1;//默认看第一页
		}
		//调业务层
		BookBiz bookBiz= new BookBizImpl();
		//把当前页从客户端传到服务端，好让显示书籍的时候分页
		List<BookVo> li=bookBiz.findAllBook(pageNum);
		int totalPage=bookBiz.getCountPage();
		if(totalPage%2==0) {
			totalPage=totalPage/2;
		}else {
			totalPage=totalPage/2+1;
		}
		
		//给用户响应
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("li", li);
		
		request.getRequestDispatcher("bookList.jsp").forward(request, response);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

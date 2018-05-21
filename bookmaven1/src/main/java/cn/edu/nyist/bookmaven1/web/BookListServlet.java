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
//	/*	这是实现权限拦截的
//	 * if(request.getSession().getAttribute("LoginSuccess")==null||!request.getSession().getAttribute("LoginSuccess").equals("1")) 
//		{
//			response.sendRedirect("login.jsp");
//			return;
//		}*/
//		
//		//1.获取当前页数参数
//		
//		String strPageNum;
//		int pageNum = 0;
//		try {
//			//客户端传过来的时候是String类型的，需要通过Interger包装类转换一下
//			strPageNum = request.getParameter("pageNum");
//			pageNum=Integer.parseInt(strPageNum);
//		} catch (Exception e) {
//			pageNum=1;//默认看第一页
//		}
//		//获取查询参数
//		String findByName=null;
//		String findByType=null;
//		try {
//			findByName = request.getParameter("findByName");
//			findByName=new String(findByName.getBytes("ISO-8859-1"),"utf-8");
//			findByType = request.getParameter("findByType");
//			findByType=new String(findByType.getBytes("ISO-8859-1"),"utf-8");
//			System.out.println(findByType);
//		} catch (Exception e) {
//		
//		}
//		System.out.println(findByName);
//		//调业务层
//		BookBiz bookBiz= new BookBizImpl();
//		//把当前页从客户端传到服务端，好让显示书籍的时候分页
//		List<BookVo> li=bookBiz.findAllBook(pageNum,findByName,findByType);
//		int totalPage=bookBiz.getCountPage(findByName,findByType);
//		if(totalPage%3==0) {
//			totalPage=totalPage/3;
//		}else {
//			totalPage=totalPage/3+1;
//		}
//		//给用户响应
//		response.setContentType("text/html;charset=utf-8");
//		request.setAttribute("findByName", findByName);
//		request.setAttribute("findByType", findByType);
//		request.setAttribute("pageNum", pageNum);
//		request.setAttribute("totalPage", totalPage);
//		request.setAttribute("li", li);
//		
//		request.getRequestDispatcher("bookList.jsp").forward(request, response);
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
			String strPageNum;
			int pageNum = 0;
			try {
				//客户端传过来的时候是String类型的，需要通过Interger包装类转换一下
				strPageNum = req.getParameter("pageNum");
				pageNum=Integer.parseInt(strPageNum);
			} catch (Exception e) {
				pageNum=1;//默认看第一页
			}
			//获取查询参数
			String findByName = req.getParameter("findByName");
			String findByType = req.getParameter("findByType");
			System.out.println(findByType);
			System.out.println(findByName);
			//调业务层
			BookBiz bookBiz= new BookBizImpl();
			//把当前页从客户端传到服务端，好让显示书籍的时候分页
			List<BookVo> li=bookBiz.findAllBook(pageNum,findByName,findByType);
			for (BookVo bookVo : li) {
				
			}
			System.out.println("##############");
			int totalPage=bookBiz.getCountPage(findByName,findByType);
			if(totalPage%3==0) {
				totalPage=totalPage/3;
			}else {
				totalPage=totalPage/3+1;
			}
			//给用户响应
			//resp.setContentType("text/html;charset=utf-8");
			req.setAttribute("findByName", findByName);
			req.setAttribute("findByType", findByType);
			System.out.println(findByName+findByType);
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("totalPage", totalPage);
			req.setAttribute("li", li);
			
			req.getRequestDispatcher("bookList.jsp").forward(req, resp);
	}
}

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
//���Ǹ��鼮��ʾ�Ĳ��ֵ�
@WebServlet("/bookList")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookListServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡ��ǰҳ������
		String strPageNum;
		int pageNum = 0;
		try {
			//�ͻ��˴�������ʱ����String���͵ģ���Ҫͨ��Interger��װ��ת��һ��
			strPageNum = request.getParameter("pageNum");
			pageNum=Integer.parseInt(strPageNum);
		} catch (Exception e) {
			pageNum=1;//Ĭ�Ͽ���һҳ
		}
		//��ҵ���
		BookBiz bookBiz= new BookBizImpl();
		//�ѵ�ǰҳ�ӿͻ��˴�������ˣ�������ʾ�鼮��ʱ���ҳ
		List<BookVo> li=bookBiz.findAllBook(pageNum);
		int totalPage=bookBiz.getCountPage();
		if(totalPage%2==0) {
			totalPage=totalPage/2;
		}else {
			totalPage=totalPage/2+1;
		}
		
		//���û���Ӧ
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

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
		//��ȡ��ѯ����
		String findByName=null;
		String findByType=null;
		try {
			findByName = request.getParameter("findByName");
			findByName=new String(findByName.getBytes("ISO-8859-1"),"utf-8");
			findByType = request.getParameter("findByType");
			findByType=new String(findByType.getBytes("ISO-8859-1"),"utf-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(findByName);
		//��ҵ���
		BookBiz bookBiz= new BookBizImpl();
		//�ѵ�ǰҳ�ӿͻ��˴�������ˣ�������ʾ�鼮��ʱ���ҳ
		List<BookVo> li=bookBiz.findAllBook(pageNum,findByName,findByType);
		int totalPage=bookBiz.getCountPage(findByName,findByType);
		if(totalPage%3==0) {
			totalPage=totalPage/3;
		}else {
			totalPage=totalPage/3+1;
		}
		//���û���Ӧ
		response.setContentType("text/html;charset=utf-8");
		request.setAttribute("findByName", findByName);
		request.setAttribute("findByType", findByType);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("li", li);
		
		request.getRequestDispatcher("bookList.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doGet(req, resp);
	}
}

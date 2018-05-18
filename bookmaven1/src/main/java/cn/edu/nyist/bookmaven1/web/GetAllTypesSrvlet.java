package cn.edu.nyist.bookmaven1.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.Size2DSyntax;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nyist.bookmaven1.biz.GetAllTypesBiz;
import cn.edu.nyist.bookmaven1.biz.impl.GetAllTypesBizImpl;
import cn.edu.nyist.bookmaven1.vo.GetTypesVo;

@WebServlet("/getAllTypes")
public class GetAllTypesSrvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetAllTypesSrvlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Ĭ����get����
		//1.��ȡ���������ﲻ�û�ȡ������һ������д
		//2.����ҵ���
		
		GetAllTypesBiz getAllTypesBiz= new GetAllTypesBizImpl();
		List<GetTypesVo> li=getAllTypesBiz.foundAllTypes();
		
		//var types=[{id:1,name:'���'}{id:2,name:'������'}{id:3,name:'С˵'}
		String js="[";//������js��Ϊһ�����鴫�������У�jsp�˸���������types���Ϳ�����
			for(int i=0;i<li.size();i++) {
				js+="{id:"+li.get(i).getId()+","+"name:'"+li.get(i).getName()+"'}";
				if(i<li.size()-1) {
					js+=",";
				}
			}
		js+="]";
		//System.out.println(js);  var types=[{id:1,name:'���'}{id:2,name:'������'}{id:3,name:'С˵'}]
		
		//3.���û���Ӧ    
//		request.setAttribute("li", li);
//		request.getRequestDispatcher("bookadd.jsp").forward(request, response);
		response.setContentType("text/javascript;charset=utf-8");//���߿ͻ����ļ���ʲô����
		response.getWriter().write("typeSel("+js+")");//�����js��ʽ���ı�д���ͻ���
		
	}
}

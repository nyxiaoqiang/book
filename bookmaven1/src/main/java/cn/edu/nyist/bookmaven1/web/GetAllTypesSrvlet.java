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
		//默认是get请求
		//1.获取参数，这里不用获取参数第一步不用写
		//2.调用业务层
		
		GetAllTypesBiz getAllTypesBiz= new GetAllTypesBizImpl();
		List<GetTypesVo> li=getAllTypesBiz.foundAllTypes();
		
		//var types=[{id:1,name:'编程'}{id:2,name:'电子书'}{id:3,name:'小说'}
		String js="[";//把整个js作为一个数组传到函数中，jsp端给数组起名types，就可以了
			for(int i=0;i<li.size();i++) {
				js+="{id:"+li.get(i).getId()+","+"name:'"+li.get(i).getName()+"'}";
				if(i<li.size()-1) {
					js+=",";
				}
			}
		js+="]";
		//System.out.println(js);  var types=[{id:1,name:'编程'}{id:2,name:'电子书'}{id:3,name:'小说'}]
		
		//3.给用户响应    
//		request.setAttribute("li", li);
//		request.getRequestDispatcher("bookadd.jsp").forward(request, response);
		response.setContentType("text/javascript;charset=utf-8");//告诉客户端文件是什么类型
		response.getWriter().write("typeSel("+js+")");//把这个js格式的文本写到客户端
		
	}
}

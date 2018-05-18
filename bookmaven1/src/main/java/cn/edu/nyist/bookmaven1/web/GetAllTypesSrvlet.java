package cn.edu.nyist.bookmaven1.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		for (GetTypesVo getTypesVo : li) {
			System.out.println(getTypesVo.getId()+getTypesVo.getName());
		}
		//3.给用户响应    
		request.setAttribute("li", li);
		request.getRequestDispatcher("bookadd.jsp").forward(request, response);
	}
}

package cn.edu.nyist.bookmaven1.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cn.edu.nyist.bookmaven1.Util.DsUtil;
import cn.edu.nyist.bookmaven1.biz.BookAddBiz;
import cn.edu.nyist.bookmaven1.biz.impl.BookAddBizImpl;

@WebServlet("/bookadd")
@MultipartConfig
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BookAddServlet() {
        super();
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String describ=request.getParameter("describ");
		String inid=request.getParameter("id");
		int id=Integer.parseInt(inid);
		String inputPrice=request.getParameter("price");
		double price=Double.parseDouble(inputPrice);
		String author=request.getParameter("author");
		String pubDate=request.getParameter("pubDate");
		//处理文件上传
		Part part = request.getPart("photo");
		String filenam=part.getHeader("Content-Disposition").split(";")[2].split("=")[1].replace("\"", "");
		filenam=filenam.lastIndexOf("\\")==-1 ? filenam:filenam.substring(filenam.lastIndexOf("\\")+1);
		String ext = filenam.substring(filenam.lastIndexOf('.')+1);
		String newName=UUID.randomUUID().toString()+"."+ext;
		part.write(request.getServletContext().getRealPath("upload/"+newName));
		BookAddBiz bookAddBiz= new BookAddBizImpl();
		int re=bookAddBiz.saveBook(id,name,describ,newName,price,author,pubDate);
		if(re==1) {
			System.out.println("成功");
		}else {
			System.out.println("失败");
		}
	}

}

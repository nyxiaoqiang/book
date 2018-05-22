package cn.edu.nyist.bookmaven1.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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

import cn.edu.nyist.bookmaven1.Util.MyBeanUtils;
import cn.edu.nyist.bookmaven1.biz.BookAddBiz;
import cn.edu.nyist.bookmaven1.biz.BookBiz;
import cn.edu.nyist.bookmaven1.biz.impl.BookAddBizImpl;
import cn.edu.nyist.bookmaven1.biz.impl.BookBizImpl;
import cn.edu.nyist.bookmaven1.vo.BookVo;

@WebServlet("/doEdit")
@MultipartConfig
public class DoEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DoEditServlet() {
        super();
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//处理文件上传
		int tid=Integer.parseInt(request.getParameter("tid"));
		System.out.println(tid+"------------------------------");
		BookVo bookvo= new BookVo();
		MyBeanUtils.populate(bookvo, request.getParameterMap(), "yyyy-MM-dd");
		Part part = request.getPart("photo");
		String filenam=part.getHeader("Content-Disposition").split(";")[2].split("=")[1].replace("\"", "");
		filenam=filenam.lastIndexOf("\\")==-1 ? filenam:filenam.substring(filenam.lastIndexOf("\\")+1);
		String ext = filenam.substring(filenam.lastIndexOf('.')+1);
		String newName=UUID.randomUUID().toString()+"."+ext;
		part.write(request.getServletContext().getRealPath("upload/"+newName));
		BookBiz bookBiz= new BookBizImpl();
		bookvo.setNewName(newName);
		boolean re= bookBiz.saveEditBook(bookvo,tid);
		if(re) {
			request.getRequestDispatcher("bookaddsuccess.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("bookadd.jsp").forward(request, response);
		}
	}

}

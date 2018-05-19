package cn.edu.nyist.bookmaven1.biz.impl;

import java.util.List;

import cn.edu.nyist.bookmaven1.biz.BookBiz;
import cn.edu.nyist.bookmaven1.dao.BookAddDao;
import cn.edu.nyist.bookmaven1.dao.loginDao;
import cn.edu.nyist.bookmaven1.dao.impl.BookAddDaoImpl;
import cn.edu.nyist.bookmaven1.dao.impl.LoginDaoImpl;
import cn.edu.nyist.bookmaven1.vo.BookVo;

public class BookBizImpl implements BookBiz {

	@Override
	public boolean findByNameAndPwd(String name, String pwd) {
		loginDao loginDao = new LoginDaoImpl();
		return loginDao.get(name,pwd);
	}

	@Override
	public List<BookVo> findAllBook(int pageNum) {
		BookAddDao bookAddDao = new BookAddDaoImpl();
		return bookAddDao.find(pageNum);
	}

	@Override
	public int getCountPage() {
		BookAddDao bookAddDao = new BookAddDaoImpl();
		return bookAddDao.get();
	}


}

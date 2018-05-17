package cn.edu.nyist.bookmaven1.biz.impl;

import cn.edu.nyist.bookmaven1.biz.BookBiz;
import cn.edu.nyist.bookmaven1.dao.loginDao;
import cn.edu.nyist.bookmaven1.dao.impl.LoginDaoImpl;

public class BookBizImpl implements BookBiz {

	@Override
	public boolean findByNameAndPwd(String name, String pwd) {
		loginDao loginDao = new LoginDaoImpl();
		return loginDao.get(name,pwd);
	}

}

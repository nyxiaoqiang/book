package cn.edu.nyist.bookmaven1.biz.impl;

import cn.edu.nyist.bookmaven1.biz.BookAddBiz;
import cn.edu.nyist.bookmaven1.dao.BookAddDao;
import cn.edu.nyist.bookmaven1.dao.impl.BookAddDaoImpl;
import cn.edu.nyist.bookmaven1.vo.BookVo;

public class BookAddBizImpl implements BookAddBiz {
	@Override
	public int saveBook(BookVo bookvo) {
		BookAddDao bookAddDao = new BookAddDaoImpl();
		return bookAddDao.save(bookvo);
	}

}

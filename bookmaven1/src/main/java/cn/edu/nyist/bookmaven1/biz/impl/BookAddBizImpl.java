package cn.edu.nyist.bookmaven1.biz.impl;

import cn.edu.nyist.bookmaven1.biz.BookAddBiz;
import cn.edu.nyist.bookmaven1.dao.BookAddDao;
import cn.edu.nyist.bookmaven1.dao.impl.BookAddDaoImpl;

public class BookAddBizImpl implements BookAddBiz {
	@Override
	public int saveBook(int id, String name, String describ, String newName, double price, String author,String pubDate) {
		BookAddDao bookAddDao = new BookAddDaoImpl();
		return bookAddDao.save(id, name, describ, newName, price, author,pubDate);
	}

}

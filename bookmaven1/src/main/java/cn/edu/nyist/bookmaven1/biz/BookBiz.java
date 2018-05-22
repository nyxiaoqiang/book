package cn.edu.nyist.bookmaven1.biz;

import java.util.List;

import cn.edu.nyist.bookmaven1.vo.BookVo;

public interface BookBiz {

	boolean findByNameAndPwd(String name, String pwd);



	int getCountPage(String findByName,String findByType);



	List<BookVo> findAllBook(int pageNum, String findByname, String findByType);



	void delBookByTid(int tid);



	BookVo getBookByTid(String tid);



	boolean saveEditBook(BookVo bookVo, int tid);

}

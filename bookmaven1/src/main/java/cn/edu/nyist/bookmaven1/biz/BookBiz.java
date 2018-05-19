package cn.edu.nyist.bookmaven1.biz;

import java.util.List;

import cn.edu.nyist.bookmaven1.vo.BookVo;

public interface BookBiz {

	boolean findByNameAndPwd(String name, String pwd);



	List<BookVo> findAllBook(int pageNum);



	int getCountPage();

}

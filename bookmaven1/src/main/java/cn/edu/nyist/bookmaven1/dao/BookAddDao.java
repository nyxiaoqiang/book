package cn.edu.nyist.bookmaven1.dao;

import java.util.List;

import cn.edu.nyist.bookmaven1.vo.BookVo;

public interface BookAddDao {

	int save(BookVo bookvo);

	List<BookVo> find(int pageNum);

	int get();

}

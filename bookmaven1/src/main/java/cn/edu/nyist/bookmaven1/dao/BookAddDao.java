package cn.edu.nyist.bookmaven1.dao;

import java.util.List;

import cn.edu.nyist.bookmaven1.vo.BookVo;

public interface BookAddDao {

	int save(BookVo bookvo);


	int get(String findByName,String findByType);

	List<BookVo> find(int pageNum, String findByname, String findByType);


	void del(int tid);

}

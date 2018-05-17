package cn.edu.nyist.bookmaven1.biz;

public interface BookAddBiz {

	int saveBook(int id, String name, String describ, String newName, double price, String author,String pubDate);

}

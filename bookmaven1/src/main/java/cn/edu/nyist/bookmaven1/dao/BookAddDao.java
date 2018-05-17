package cn.edu.nyist.bookmaven1.dao;

public interface BookAddDao {

	int save(int id, String name, String describ, String newName, double price, String author,String pubDate);

}

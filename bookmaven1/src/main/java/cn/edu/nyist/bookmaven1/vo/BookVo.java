package cn.edu.nyist.bookmaven1.vo;

import java.io.Serializable;
import java.util.Date;

public class BookVo implements Serializable {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescrib() {
		return describ;
	}
	public void setDescrib(String describ) {
		this.describ = describ;
	}
	public int getId() {
		return id;
	}
	public void setId(int inid) {
		this.id = inid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	private String name;
	private String describ;
	private int id;
	private double price;
	private String author;
	private Date pubDate;
	private String newName;
	public BookVo() {
		
	}

}

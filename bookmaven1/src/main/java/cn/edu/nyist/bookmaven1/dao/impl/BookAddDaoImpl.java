package cn.edu.nyist.bookmaven1.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.edu.nyist.bookmaven1.Util.DsUtil;
import cn.edu.nyist.bookmaven1.dao.BookAddDao;

public class BookAddDaoImpl implements BookAddDao {
	@Override
	public int save(int id, String name, String describ, String newName, double price, String author,String pubDate) {
		Connection conn=null;
		PreparedStatement stmt=null;
		String sql="insert into t_book(id,name,describ,photo,price,author,pubDate) values(?,?,?,?,?,?,?)";
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(pubDate);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			conn=DsUtil.getConn();
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, describ);
			stmt.setString(4, newName);
			stmt.setDouble(5, price);
			stmt.setString(6, author);
			stmt.setDate(7, new java.sql.Date(date.getTime()));
			int re=stmt.executeUpdate();
			return re;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DsUtil.free(stmt, conn);
		}
		return 0;
	}
}

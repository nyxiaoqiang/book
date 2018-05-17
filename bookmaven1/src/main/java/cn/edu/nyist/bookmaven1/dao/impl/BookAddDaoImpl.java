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
import cn.edu.nyist.bookmaven1.vo.BookVo;

public class BookAddDaoImpl implements BookAddDao {
	@Override
	public int save(BookVo bookvo) {
		Connection conn=null;
		PreparedStatement stmt=null;
		String sql="insert into t_book(id,name,describ,photo,price,author,pubDate) values(?,?,?,?,?,?,?)";
		Date date = null;
		/*try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(bookvo.getPubDate());
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}*/
		try {
			conn=DsUtil.getConn();
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, bookvo.getId());
			stmt.setString(2, bookvo.getName());
			stmt.setString(3, bookvo.getDescrib());
			stmt.setString(4, bookvo.getNewName());
			stmt.setDouble(5, bookvo.getPrice());
			stmt.setString(6, bookvo.getAuthor());
			stmt.setDate(7, new java.sql.Date(bookvo.getPubDate().getTime()));
			
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

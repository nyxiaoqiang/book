package cn.edu.nyist.bookmaven1.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.edu.nyist.bookmaven1.Util.DsUtil;
import cn.edu.nyist.bookmaven1.dao.BookAddDao;
import cn.edu.nyist.bookmaven1.vo.BookVo;
import cn.edu.nyist.bookmaven1.vo.GetTypesVo;

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

	@Override
	public List<BookVo> find(int pageNum) {

		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		List<BookVo> li= new ArrayList<BookVo>();
		try {
			conn=DsUtil.getConn();
			stmt=conn.createStatement();
			//rs=stmt.executeQuery("select * from t_book");
			//��ӷ�ҳ���ҹ���
			rs=stmt.executeQuery("select * from t_book limit "+(2*(pageNum-1)+1-1)+",2");
			while(rs.next()) {
				BookVo bv=new BookVo();
				bv.setId(rs.getInt("id"));
				bv.setTid(rs.getInt("tid"));
				bv.setDescrib(rs.getString("describ"));
				bv.setName(rs.getString("name"));
				bv.setNewName(rs.getString("photo"));
				bv.setPubDate(rs.getDate("pubDate"));
				bv.setPrice(rs.getDouble("price"));
				bv.setAuthor(rs.getString("author"));
				li.add(bv);
			}
			return li;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DsUtil.free(rs, stmt, conn);
		}
		return null;
	}

	@Override
	public int get() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=DsUtil.getConn();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select count(*) from t_book");
			if(rs.next()){
				return rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DsUtil.free(rs, stmt, conn);
		}
		return 0;
	}
}

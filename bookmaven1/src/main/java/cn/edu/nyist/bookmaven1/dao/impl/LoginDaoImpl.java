package cn.edu.nyist.bookmaven1.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.nyist.bookmaven1.Util.DsUtil;
import cn.edu.nyist.bookmaven1.dao.loginDao;

public class LoginDaoImpl implements loginDao {

	@Override
	public boolean get(String name, String pwd) {
		//2.到数据库查询
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet resultSet=null;
		boolean re=false;
		try {
			conn=DsUtil.getConn();
			String sql="select * from t_admin where name=? and pwd=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, pwd);
			resultSet=stmt.executeQuery();
			if(resultSet.next()) {
				re=true;
			}else {
				re=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DsUtil.free(resultSet,stmt,conn);
		}
		return re;
	}

}

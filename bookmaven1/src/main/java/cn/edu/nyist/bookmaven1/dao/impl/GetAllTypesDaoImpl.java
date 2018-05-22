package cn.edu.nyist.bookmaven1.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.edu.nyist.bookmaven1.Util.DsUtil;
import cn.edu.nyist.bookmaven1.dao.GetAllTypesDao;
import cn.edu.nyist.bookmaven1.vo.GetTypesVo;

public class GetAllTypesDaoImpl implements GetAllTypesDao {

	@Override
	public List<GetTypesVo> find() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		List<GetTypesVo> li= new ArrayList<GetTypesVo>();
		try {
			conn=DsUtil.getConn();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from t_type");
			while(rs.next()) {
				GetTypesVo gtv=new GetTypesVo();
				gtv.setId(rs.getInt("id"));
				gtv.setName(rs.getString("name"));
				li.add(gtv);
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

}

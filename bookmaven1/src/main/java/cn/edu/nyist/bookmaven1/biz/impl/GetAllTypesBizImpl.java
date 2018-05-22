package cn.edu.nyist.bookmaven1.biz.impl;

import java.util.List;

import cn.edu.nyist.bookmaven1.biz.GetAllTypesBiz;
import cn.edu.nyist.bookmaven1.dao.GetAllTypesDao;
import cn.edu.nyist.bookmaven1.dao.impl.GetAllTypesDaoImpl;
import cn.edu.nyist.bookmaven1.vo.GetTypesVo;

public class GetAllTypesBizImpl implements GetAllTypesBiz {

	@Override
	public List<GetTypesVo> foundAllTypes() {
		GetAllTypesDao getAllTypesDao= new GetAllTypesDaoImpl();
		return getAllTypesDao.find();
	}

}

package com.company.service.impl;

import java.util.List;

import com.company.bean.Area;
import com.company.dao.IAreaDao;
import com.company.dao.IBlogDao;
import com.company.service.IAreaService;

public class AreaServiceImpl implements IAreaService {
	//IAreaDao areadao = new AreaDaoImpl();
	IAreaDao areadao = DataConnetor.getSqlSession().getMapper(IAreaDao.class);

	@Override
	public List<Area> findAreasByCid(String cityId) {

		return areadao.findAreasByCid(cityId);
	}

	@Override
	public Area findObject(String areaId) {

		return areadao.findObject(areaId);
	}

}

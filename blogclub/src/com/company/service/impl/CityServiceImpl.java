package com.company.service.impl;

import java.util.List;

import com.company.bean.City;
import com.company.dao.IBlogKindDao;
import com.company.dao.ICityDao;
import com.company.service.ICityService;

public class CityServiceImpl implements ICityService {
	//ICityDao citydao = new CityDaoImpl();
	ICityDao citydao = DataConnetor.getSqlSession().getMapper(ICityDao.class);
	@Override
	public List<City> findCitiesByPid(String provinceId) {

		return citydao.findCitiesByPid(provinceId);
	}

	@Override
	public City findObject(String cityId) {

		return citydao.findObject(cityId);
	}

}

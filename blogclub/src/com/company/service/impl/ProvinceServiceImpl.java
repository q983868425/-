package com.company.service.impl;

import java.util.List;

import com.company.bean.Province;
import com.company.dao.ICommentDao;
import com.company.dao.IProvinceDao;
import com.company.service.IProvinceService;

public class ProvinceServiceImpl implements IProvinceService {
	//IProvinceDao provincedao = new ProvinceDaoImpl();
	IProvinceDao provincedao = DataConnetor.getSqlSession().getMapper(IProvinceDao.class);
	@Override
	public List<Province> findAll() {

		return provincedao.findAll();
	}

	@Override
	public Province findObject(String provinceId) {
		return provincedao.findObject(provinceId);
	}

}

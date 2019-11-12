package com.company.service.impl;

import java.util.List;

import com.company.bean.BlogKind;
import com.company.dao.IAreaDao;
import com.company.dao.IBlogKindDao;
import com.company.service.IBlogKindService;

public class BlogKindServiceImpl implements IBlogKindService {
	//IBlogKindDao blogkinddao = new BlogKindDaoImpl();
	IBlogKindDao blogkinddao = DataConnetor.getSqlSession().getMapper(IBlogKindDao.class);

	@Override
	public List<BlogKind> findList() {

		return blogkinddao.findList();
	}

	@Override
	public BlogKind find(int id) {

		return blogkinddao.find(id);
	}

}

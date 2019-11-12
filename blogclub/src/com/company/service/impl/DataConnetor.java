package com.company.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataConnetor {

	public static SqlSession getSqlSession() {
		SqlSession session = null;
		try {
			String str = "configuration.xml";
			InputStream stream = Resources.getResourceAsStream(str);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
			session = sqlSessionFactory.openSession(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}

}

package com.mybatis.test;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;

@SpringBootTest
class TestApplicationTests {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Test
	void contextLoads() {
	}

	@Test
	public void connection_test() {
		try (Connection connection = sqlSessionFactory.openSession().getConnection()) {
			System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

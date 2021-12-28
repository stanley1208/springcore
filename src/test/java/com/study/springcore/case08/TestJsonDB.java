package com.study.springcore.case08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJsonDB {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext8.xml");
		JsonDB jsonDB = ctx.getBean("jsonDB", JsonDB.class);
		System.out.println(jsonDB.queryAll());
	}
}

package com.study.springcore.jdbc;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.aop_lab.AOPConfig;
import com.study.springcore.jdbc.entity.Emp;
import com.study.springcore.jdbc.template.EmpDao;

public class TemplateTest2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		int rowcount = 0;
		// 測試單筆新增 I
//		rowcount = empDao.addOne1("test1", 18);
//		System.out.println("測試單筆新增 I: " + rowcount);
		// 測試單筆新增 II
		// 測試多筆新增 I
		// 測試多筆新增 II
		rowcount = empDao.addOne2("test2", 19);
		System.out.println("測試單筆新增 II: " + rowcount);
	}

}

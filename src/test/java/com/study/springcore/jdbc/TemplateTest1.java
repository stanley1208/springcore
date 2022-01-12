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

public class TemplateTest1 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		System.out.println(empDao.queryAll());
		// 如何取得 eid=2 的員工姓名? 使用java8
		List<Map<String, Object>> emps = empDao.queryAll();
		String ename = emps.stream().filter(e -> (e.get("eid") + "").equals("2")).findFirst().get().get("ename") + "";

		System.out.println(ename);

	}

}

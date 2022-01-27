package com.study.springcore.jdbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.aop_lab.AOPConfig;
import com.study.springcore.jdbc.entity.Emp;
import com.study.springcore.jdbc.template.EmpDao;
import com.study.springcore.jdbc.template.EmpJobDao;

public class TemplateTest4Tx {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);

		empDao.addOneTx("TxTx", 20);
		System.out.println("addOneTx Ok!");
	}

}

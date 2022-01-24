package com.study.springcore.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.tx.controller.BookController;

public class TestBook {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("jdbc-config.xml");
		BookController bookController=ctx.getBean(BookController.class);
		System.out.println(bookController);
	}

}

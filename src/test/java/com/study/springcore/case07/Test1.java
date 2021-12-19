package com.study.springcore.case07;

import java.io.DataOutput;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext7.xml");
		
		User user=ctx.getBean("user",User.class);
		System.out.println(user);
	}
	
	
}

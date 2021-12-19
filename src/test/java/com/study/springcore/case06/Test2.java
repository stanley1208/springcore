package com.study.springcore.case06;

import java.io.DataOutput;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext6.xml");
		
		RoundArea a1=ctx.getBean("area",RoundArea.class);
		
		System.out.println(a1.getRoundArea());
	}
	
	
}

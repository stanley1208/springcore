package com.study.springcore.aop_lab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PerformanceTest {

	public static void main(String[] args) {
		// Java 配置
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);
		Performance performance = ctx.getBean("dancer", Performance.class);
		try {
			performance.perform();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

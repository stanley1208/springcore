package com.study.springcore.case08;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * 功能:
 *1. 建立 Person 資料
 * 		-> 輸入 name, birth
 * 2. 取得 Person 全部資料
 * 		-> 不用輸入參數
 * 3. 根據姓名取得 Person
 * 		-> 輸入 name
 * 4. 根據日期取得今日生日的 Person
 * 		-> 輸入今天日期
 * 5. 取得某一歲數以上的 Person
 * 		-> 輸入 age
 * 6. 根據姓名來修改 Person 的生日
 * 		-> 輸入 name, birth
 * 7. 根據姓名來刪除 Person
 * 		-> 輸入 name
 */
public class PersonSystem {
	private ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext8.xml");
	private PersonController personController = ctx.getBean("personController", PersonController.class);
	private boolean stop;	
	
	private void menu() {
		System.out.println("=========================================");
		
		System.out.println("1. 建立 Person 資料");
		System.out.println("2. 取得 Person 全部資料");
		//作業2
		System.out.println("3. 根據姓名取得 Person");
		System.out.println("4. 根據日期取得今日生日的 Person");
		System.out.println("5. 取得某一歲數以上的 Person");
		System.out.println("6. 根據姓名來修改 Person 的生日");
		System.out.println("7. 根據姓名來刪除 Person");
		System.out.println("=========================================");
		System.out.println("請選擇: ");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		switch (choice) {
		case 1:
			createPerson();
			break;
		case 2:
			printPerson();
			break;
		case 0: {
			System.out.println("離開系統");
			stop=true;
			break;
		}
		
	}
	}
	public void createPerson() {
		System.out.println("請輸入姓名 生日年 月 日:");
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		int yyyy=sc.nextInt();
		int MM=sc.nextInt();
		int dd=sc.nextInt();
				
		personController.addPerson(name, yyyy,MM,dd);
	}
	public void printPerson() {
		personController.printAllPersons();
	}
	public void start() {
		while(!stop) {
			menu();
		}
		personController.printAllPersons();
	}
	
	public static void main(String[] args) {
		new PersonSystem().start();
	}

}

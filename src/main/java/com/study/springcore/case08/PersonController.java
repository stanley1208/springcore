package com.study.springcore.case08;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/*
 * 功能:
 * 1. 建立 Person 資料
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
 * */

@Controller
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	public void addPerson(String name,int yyyy,int MM,int dd) {
		// 1. 判斷 name 與 yyyy,MM,dd 是否有資料?
		// 1. 將yyyy/mm/dd 轉日期格式
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date birth=sdf.parse(yyyy+"/"+MM+"/"+dd);
			addPerson(name, birth);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addPerson(String name,Date birth) {
		// 1. 判斷 name 與 birth 是否有資料?
		// 1. 建立 Person 資料
		
		boolean check=personService.append(name,birth);
		System.out.println("add person: "+check);
	}
	
	public Person getPersonByName(String name) {
		Person person=personService.getPerson(name);
		return person;

		
	}
	
	public void printAllPersons() {
		//資料呈現
		SimpleDateFormat sdf=new SimpleDateFormat();
		//System.out.println(personService.findAllPersons());
		List<Person>people=personService.findAllPersons();
		System.out.println("+--------------+---------+--------------+");
		System.out.println("|     name     |   age   |  birthday    |");
		System.out.println("+--------------+---------+--------------+");
		for(Person p:people) {
			String birthday=sdf.format(p.getBirth());
			System.out.printf("| %-12s | %7d | %12s |\n", p.getName(), p.getAge(), birthday);
			System.out.println("+--------------+---------+--------------+");
		}
	}
}

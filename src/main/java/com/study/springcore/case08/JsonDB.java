package com.study.springcore.case08;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.study.springcore.case08.Person;

@Component
public class JsonDB { // Json資料庫

	@Autowired
	private Gson gson;

	// Json file 資料庫存放地
	private static final Path PATH = Paths.get("src/main/java/com/study/springcore/case08/person.json");

	// 查詢全部
	public List<Person> queryAll() throws Exception {
		String jsonStr = Files.readAllLines(PATH).stream().collect(Collectors.joining());
		Type type = new TypeToken<ArrayList<Person>>() {
		}.getType();
		List<Person> people = gson.fromJson(jsonStr, type);
		// 請將 age 變為最新年齡
//		Date today=new Date();
//		LocalDate todayLocalDate=today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//		for(Person p:people) {
//			LocalDate birthLocalDate=today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//			int age=todayLocalDate.getYear()-birthLocalDate.getYear();
//			p.setAge(age);
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		int todayYear=calendar.get(Calendar.YEAR);
		for(Person person:people) {
			calendar.setTime(person.getBirth());
			int birthYear=calendar.get(calendar.YEAR);
			int age=todayYear-birthYear;
			person.setAge(age);
		}
	
	return people;
		
	}
	
	public boolean add(Person person) throws Exception{
		List<Person>people=queryAll();
		// 作業 
		// 如果 person 已經存在則 return false
		// name, age, birth 皆與目前資料庫某一 person 資料相同
		people.add(person);
		String newJsonString=gson.toJson(people);
		Files.write(PATH, newJsonString.getBytes("UTF-8"));
		return true;
	}
}

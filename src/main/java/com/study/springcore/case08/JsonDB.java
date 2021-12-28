package com.study.springcore.case08;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.study.springcore.case07.Person;

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

		return people;
	}
}

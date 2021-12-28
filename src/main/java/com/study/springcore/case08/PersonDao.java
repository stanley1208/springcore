package com.study.springcore.case08;

import java.util.List;

public interface PersonDao {
	// 建立
	public boolean create(Person person);
	// 查詢所有 person
	public List<Person>readAll();
	
}

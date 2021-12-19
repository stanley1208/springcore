package com.study.springcore.case05;

import java.util.List;
import java.util.Map;
import java.util.Set;

// 老師
public class Teacher {
	private Integer id; // 講師代號
	private String name; // 姓名
	private Set<Clazz> clazzes; // 授課項目
	private List<String> experties; // 專長
	private Map<String, Integer> salary; // 薪資結構

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Clazz> getClazzes() {
		return clazzes;
	}

	public void setClazzes(Set<Clazz> clazzes) {
		this.clazzes = clazzes;
	}

	public List<String> getExperties() {
		return experties;
	}

	public void setExperties(List<String> experties) {
		this.experties = experties;
	}

	public Map<String, Integer> getSalary() {
		return salary;
	}

	public void setSalary(Map<String, Integer> salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", clazzes=" + clazzes + ", experties=" + experties
				+ ", salary=" + salary + "]";
	}

}

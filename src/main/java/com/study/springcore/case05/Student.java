package com.study.springcore.case05;

import java.util.Set;

// 學生
public class Student {
	private Integer id;
	private String name;
	private Set<Clazz> clazzes; //所選課程

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

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", clazzes=" + clazzes + "]";
	}

}

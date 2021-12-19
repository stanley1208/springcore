package com.study.springcore.case07;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


// 在配置文件中有設定
// <context:include-filter type="assignable" expression="com.study.springcore.case07.User"/>
// 則可以不用加上@Component
@Component
public class User {
	@Value(value = "John")
	private String name;
	
	@Value(value = "18")
	private Integer age;
	
	@Value("#{${nicknames:{'Happy','Enjoy'}}}") // Spring EL
	private String[] nicknames;

	@Value("#{${subjects:{'國文','英文'}}}")
	private Set<String>subjects;

	@Value("#{${scores:{100,90,80}}}")
	private List<String>scores;

	@Value("#{${hobbies:{1:'Car',2:'Motor'}}}")
	private Map<Integer, String>hobbies;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String[] getNicknames() {
		return nicknames;
	}

	public void setNicknames(String[] nicknames) {
		this.nicknames = nicknames;
	}

	public Set<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<String> subjects) {
		this.subjects = subjects;
	}

	public List<String> getScores() {
		return scores;
	}

	public void setScores(List<String> scores) {
		this.scores = scores;
	}

	public Map<Integer, String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Map<Integer, String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", nicknames=" + Arrays.toString(nicknames) + ", subjects="
				+ subjects + ", scores=" + scores + ", hobbies=" + hobbies + "]";
	}
	
	
	
	
	
	
	
}

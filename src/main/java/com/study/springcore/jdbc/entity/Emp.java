package com.study.springcore.jdbc.entity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

public class Emp {
	// 欄位
	private Integer eid;
	private String ename;
	private Integer age;
	private Date createTime;
	// 關係
	private List<Job>jobs;
	public Emp() {
		super();
	}

	public Emp(String ename, Integer age) {
		
		
		this.ename = ename;
		this.age = age;
		
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + ", age=" + age + ", createTime=" + createTime + ", jobs="
					+ (jobs==null?"":jobs.stream().map(Job::getJname) .collect(toList()))+ "]";
	}

	

}

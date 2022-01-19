package com.study.springcore.jdbc.template;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.springcore.jdbc.entity.Emp;
import com.study.springcore.jdbc.entity.Job;

@Repository
public class EmpJobDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Emp>queryEmps(){
		// 請查出每個人的工作名稱為何?
		String sql="select eid, ename,age,createtime from emp";
		List<Emp> emps = jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
			Emp emp = new Emp();
			// 設定欄位
			emp.setEid(rs.getInt("eid"));
			emp.setEname(rs.getString("ename"));
			emp.setAge(rs.getInt("age"));
			emp.setCreateTime(rs.getTimestamp("createtime"));
			
			String sql2="select jid,jname,eid from job where eid=?";
			List<Job>jobs=jdbcTemplate.query(sql2, new BeanPropertyRowMapper(Job.class),emp.getEid());
			// 設定關聯
			emp.setJobs(jobs);
			
			return emp;
		});
		return emps;
	}
	
	public List<Job>queryJobs(){
		// 請查出每個工作的員工姓名為何?
		String sql="select jid, jname, eid from job";
		List<Job> jobs = jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
			Job job=new Job();
			job.setJid(rs.getInt("jid"));
			job.setJname(rs.getString("jname"));
			job.setEid(rs.getInt("eid"));
			
			
			String sql2="select eid, ename,age,createtime from emp where eid=?";
			List<Emp>emps=jdbcTemplate.query(sql2, new BeanPropertyRowMapper<>(Emp.class),job.getEid());
			if(emps!=null && emps.size()>0) {
				job.setEmp(emps.get(0));
			}
			
			return job;
		});
		return jobs;
	}
	
	public List<Emp>queryEmps2(){
		
		return null;
	}
	
	public List<Job>queryJobs2(){
		
		
		return null;
	}
}

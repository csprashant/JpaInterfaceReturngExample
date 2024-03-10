package com.inno;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Controller {

	@Autowired EmpRepo emp;
	@GetMapping("grouping")
	public List<GroupingInfo> getGroupInfo(){
		return emp.getGroupInfo();
	}
	
	@GetMapping("joindata")
	public List<JoinData> getFromJoinTable(){
		return emp.getFromJoinTable();
	}
	
	@GetMapping("report")
	public List<Report> report(){
		return emp.getReport();
	}
	
	@GetMapping("details")
	public List<Response> getFromJoinTab1le(){
		List<Emp> findAll = emp.findAll();
		List<Response> res =new  ArrayList<>();
		for(Emp emp:findAll) {
		Response r= new Response();
		r.setId(emp.getId());
		r.setName(emp.getName());
		r.setSalary(emp.getSalary());
		r.setDesignation(emp.getDesignation());
		r.setGrade(emp.getGrade());
		r.setDepartment(emp.getDepartment());
		res.add(r);
		}
		return res;
		}
	
	@GetMapping("data")
	public List<Data> getData(){
		return emp.getData();
	}
	
}

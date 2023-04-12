package com.link.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.link.entity.Employee;
import com.link.repository.EmpRepo;

@Component
public class EmpService{


    @Autowired
	private EmpRepo repo;;
	
	
	public void EmpAdd(Employee e) {
		
		this.repo.save(e);
		
		
	}
	
	
	public List<Employee> getAllEmp(){
		
	
		return (List<Employee>) repo.findAll();
		
	}
	
	public Employee getEmpById(int id) {
		
		Optional<Employee> emp=repo.findById(id);
		
		if(emp.isPresent())
		
			return emp.get();
			
		return null;
	}
	
	
	public void EmpDelete(int id) {
		
	this.repo.deleteById(id);
		
	
		
	}
public void Empupdate(Employee e,int id) {
		
	e.setId(id);
		this.repo.save(e);
		
		
	}
	
	
	
	

}

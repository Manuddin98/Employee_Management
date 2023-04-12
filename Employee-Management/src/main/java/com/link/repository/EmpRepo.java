package com.link.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.link.entity.Employee;


public interface EmpRepo extends CrudRepository<Employee, Integer>{

	
	
}

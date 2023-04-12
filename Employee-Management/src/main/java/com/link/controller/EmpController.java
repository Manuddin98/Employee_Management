package com.link.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.link.entity.Employee;
import com.link.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	
	@GetMapping("/")
	public String home(Model m) {
		
		List<Employee> emp=service.getAllEmp();
		m.addAttribute("emp", emp);
		
		return "index";
	}
	
	@GetMapping("/add_emp")
	public String AddEmp() {
		
		return "add_Emp";
	}
	
	@PostMapping("/register")
public String EmpRegister(@ModelAttribute Employee e,HttpSession session) {
		
		System.out.println(e);
		this.service.EmpAdd(e);
		
		session.setAttribute("msg", "Employee added successfully");
		
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
		
		Employee emp=service.getEmpById(id);
		
		m.addAttribute("emp", emp);
		
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e,HttpSession session,Model m) {
		
		int id=e.getId();
		e.setId(id);
		service.Empupdate(e,id);
	
		session.setAttribute("msg", "Emp data update successfully");
		
		List<Employee> emp=service.getAllEmp();
		m.addAttribute("emp", emp);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,Model m) {
		
		service.EmpDelete(id);
		List<Employee> emp=service.getAllEmp();
		m.addAttribute("emp", emp);
		
		return "redirect:/";
	}
	
	
	

}

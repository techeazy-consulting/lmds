package com.techeazy.lmds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techeazy.lmds.entity.Employee;
import com.techeazy.lmds.service.EmpService;

@RestController
@RequestMapping("/employee")
public class EmpController {

	@Autowired
	private EmpService empService;

	@PostMapping("/saveemp")
	public Employee saveEmp(@RequestBody Employee employee) {
		return empService.saveEmp(employee);
	}

	@GetMapping("/getallemp")
	public List<Employee> getAllEmp() {
		return empService.getAllEmp();
	}

	@GetMapping("/getsingleempI/{id}")
	public Employee getEmp(@PathVariable Integer id) {
		return empService.getEmp(id);
	}

	@PutMapping("/updateemp/{id}")
	public Employee updateEmp(@PathVariable Integer id, @RequestBody Employee employee) {
		Employee existing_employee = empService.getEmp(id);
		existing_employee.setName(employee.getName());
		existing_employee.setDesignation(employee.getDesignation());
		existing_employee.setLocation(employee.getLocation());
		existing_employee.setSalary(employee.getSalary());
		return empService.saveEmp(existing_employee);
	}

	@DeleteMapping("/deleteemp/{id}")
	public String deleteEmp(@PathVariable Integer id) {
		return empService.deleteEmp(id);
	}

	@GetMapping("/getsingleempD/{designation}")
	public List<Employee> getEmpDesignation(@PathVariable String designation) {
		return empService.getEmpDesignation(designation);
	}

}

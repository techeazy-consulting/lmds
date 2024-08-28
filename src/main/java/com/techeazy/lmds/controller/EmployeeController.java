package com.techeazy.lmds.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techeazy.lmds.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@GetMapping("/employees")
	public ResponseEntity<?> getAllEmployees() {
		
		ArrayList<Employee> list= new ArrayList<>();
		list.add(new Employee(101,"Kiran Rajput", "Developer"));
		list.add(new Employee(102,"Veer", "QA"));
		list.add(new Employee(103,"Jay", "UI/UX"));
		list.add(new Employee(104,"Shiv", "HR"));

		return ResponseEntity.ok(list);
	}

	
	
}

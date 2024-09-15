package com.techeazy.lmds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techeazy.lmds.entity.Employee;
import com.techeazy.lmds.repo.EmpRepo;

@Service
public class EmpService {

	@Autowired
	private EmpRepo empRepo;

	public Employee saveEmp(Employee employee) {
		return empRepo.save(employee);
	}

	public List<Employee> getAllEmp() {
		return empRepo.findAll();
	}

	public Employee getEmp(Integer id) {
		return empRepo.findById(id).get();
	}

	public String deleteEmp(Integer id) {
		empRepo.deleteById(id);
		return "Delete Employee with ID: " + id;
	}

	public List<Employee> getEmpDesignation(String designation) {
		return empRepo.findByDesignation(designation);
	}
}

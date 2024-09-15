package com.techeazy.lmds.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techeazy.lmds.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

	List<Employee> findByDesignation(String designation);

}

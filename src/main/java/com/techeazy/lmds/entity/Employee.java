package com.techeazy.lmds.entity;

public class Employee {
	public String empName;
	public Integer empId;
	public String empRole;
	
	
	
	public Employee(Integer empId,String empName,  String empRole) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.empRole = empRole;
	}
	public String getEmpName() {
		return empName;
	}
	public Integer getEmpId() {
		return empId;
	}
	public String getEmpRole() {
		return empRole;
	}
	public Employee() {
		super();
	
	}
	
	

}

package com.techeazy.lmds.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DRIVER")
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	
	private long mobile;
	
	private String email;

	private int age;

	private String license;

	private char isActive;

	private char isDeleted;
	
	private long parcleId;
	
	private long customerId;
	
	private String status;

}

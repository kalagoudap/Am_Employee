package com.employee.Employee_Service.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeid;
	@Column(name = "Name")
	private String name;
	@Column(name = "Phone_Number")
	private Long phone_number;
	@Column(name = "Address")
	private String address;
	@Column(name="Department_Id")
	private Long dept_id;

}

package com.employee.Employee_Service.dto;

import com.employee.Employee_Service.Entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response_Object {
	private Employee employee;
	private Department department;
}

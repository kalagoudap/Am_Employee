package com.employee.Employee_Service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employee.Employee_Service.Entity.Employee;
import com.employee.Employee_Service.Repo.Employee_Repo;
import com.employee.Employee_Service.dto.Department;
import com.employee.Employee_Service.dto.Response_Object;

@Service
public class Employee_Service {
	
	@Autowired
	Employee_Repo employee_Repo;
	
	@Autowired
	RestTemplate restTemplate;
	
	public Employee getemployeedetails(Long id) {
		 Employee emp=employee_Repo.getemployeedetailsbyid(id);
		 System.out.println(emp.getName());
		 return emp;
	}
	
	public ResponseEntity<Employee> saveEmployee(Employee employee) {
		System.out.println(Long.toString(employee.getPhone_number()).length());
		if(Long.toString(employee.getPhone_number()).length()==10) {
			 employee_Repo.save(employee);
			 return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		}
		else
			return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public Response_Object getresponseofbothfield(Long id) {
		Employee employee=employee_Repo.findById(id).get();
		
		Department dept=restTemplate.getForObject("http://localhost:5051/getdeptdetails/"+employee.getDept_id(), Department.class);
		
		Response_Object response_Object=new Response_Object();
		response_Object.setEmployee(employee);
		response_Object.setDepartment(dept);
		
		return response_Object;
	}
	
}

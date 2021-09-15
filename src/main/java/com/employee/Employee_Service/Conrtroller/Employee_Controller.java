package com.employee.Employee_Service.Conrtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Employee_Service.Entity.Employee;
import com.employee.Employee_Service.dto.Response_Object;
import com.employee.Employee_Service.service.Employee_Service;

@RestController
@RequestMapping("/employee")
public class Employee_Controller {
	
	@Autowired
	Employee_Service employee_Service;
	
	@GetMapping("/getemployee/{id}")
	public Employee getemployeedata(@PathVariable long id) {
		return employee_Service.getemployeedetails(id);
	}
	
	@PostMapping("/postemployee")
	public ResponseEntity<Employee> postemployeedata(@RequestBody Employee employee) {
		return employee_Service.saveEmployee(employee);
	}
	
	@GetMapping("/getalldetails/{id}")
	public Response_Object getalldetails(@PathVariable Long id) {
		return employee_Service.getresponseofbothfield(id);
	}
}

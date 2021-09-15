package com.employee.Employee_Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.employee.Employee_Service.Entity.Employee;
import com.employee.Employee_Service.Repo.Employee_Repo;
import com.employee.Employee_Service.service.Employee_Service;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class EmployeeServiceApplicationTests {
	
	@Autowired
	private Employee_Service employee_ser;
	
	@MockBean
	Employee_Repo repo;

	@Test
	void contextLoads() {
		try {
		when(repo.getemployeedetailsbyid((long)1)).thenReturn(new Employee((long)123, "kp", (long)8151, "address", (long)345));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(345, employee_ser.getemployeedetails((long)1).getDept_id());
	}

}

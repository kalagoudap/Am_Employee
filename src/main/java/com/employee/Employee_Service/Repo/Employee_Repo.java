package com.employee.Employee_Service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.Employee_Service.Entity.Employee;

@Repository
public interface Employee_Repo extends JpaRepository<Employee, Long> {
	@Query(value = "SELECT * FROM Employee WHERE employeeid=?1",nativeQuery = true)
	public Employee getemployeedetailsbyid(long id);
}

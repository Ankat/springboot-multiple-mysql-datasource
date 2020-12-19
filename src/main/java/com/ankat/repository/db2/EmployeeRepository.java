package com.ankat.repository.db2;

import com.ankat.model.db2.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}

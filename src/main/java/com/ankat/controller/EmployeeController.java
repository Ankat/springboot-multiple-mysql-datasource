package com.ankat.controller;

import com.ankat.model.db2.Employee;
import com.ankat.repository.db2.EmployeeRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Log
@RestController(value = "employeeController")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(value = "/getEmployees")
    public String getEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return Optional.ofNullable(employeeList).map(el -> el.isEmpty() ? "No Employee Found" : el.toString()).orElse("No Employee Found");
    }

    @GetMapping(value = "/getEmployeeById/{empId}")
    public Object getEmployeeById(@PathVariable Long empId) {
        log.info(String.valueOf(empId));
        Optional<Employee> employee = employeeRepository.findById(empId);
        return employee.orElseThrow(NullPointerException::new);
        //return Employee.map(e -> Employee.get().toString()).orElse("No Employee Found");
    }

    @GetMapping(value = "/getEmployeeById")
    public Object getEmployeeById(@RequestParam Optional<Long> empId) {
        log.info(String.valueOf(empId));
        return empId.map(eId -> employeeRepository.findById(eId).orElseThrow(NullPointerException::new)).orElseThrow(NullPointerException::new);
    }

    @PostMapping(value = "/addEmployee")
    public String addEmployee(@RequestBody Optional<Employee> Employee) {
        log.info(Employee.toString());
        return Optional.ofNullable(employeeRepository.save(Employee.get())).map(e -> e.toString()).orElse("No Employee Found");
    }

}

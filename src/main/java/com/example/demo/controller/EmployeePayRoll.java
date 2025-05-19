package com.example.demo.controller;



import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.EmployeePayRollDTO;
import com.example.demo.model.EmployeePayrollData;

import java.util.Map;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayRoll{

    @GetMapping("/")
    public String getAllEmployees() {
        return "Get all employee payroll data";
    }

    @GetMapping("/get/{id}")
    public String getEmployee(@PathVariable("id") int id) {
        return "Get employee data for ID: " + id;
    }

    
    @PostMapping("/create")
    public EmployeePayrollData createEmployee(@Valid @RequestBody EmployeePayRollDTO empDTO) {
        return new EmployeePayrollData(empDTO.getName(), empDTO.getSalary());
    }


    @PutMapping("/update")
    public String updateEmployee(@RequestBody Map<String, Object> employeeData) {
        return "Updated employee: " + employeeData;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        return "Deleted employee with ID: " + id;
    }
}
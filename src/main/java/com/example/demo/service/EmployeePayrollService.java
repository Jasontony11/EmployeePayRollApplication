package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeePayRollDTO;
import com.example.demo.model.EmployeePayrollData;

@Service
public class EmployeePayrollService{

   
    public String getAllEmployees() {
        return "Get all employee payroll data";
    }

    
    public String getEmployee(int id) {
        return "Get employee data for ID: " + id;
    }

    
    public EmployeePayrollData createEmployee(EmployeePayRollDTO empDTO) {
        return new EmployeePayrollData(empDTO.getName(), empDTO.getSalary());
    }

    public String updateEmployee( int id,EmployeePayRollDTO employeeData) {
        return "Updated employee: " + employeeData;
    }

    
    public String deleteEmployee( int id) {
        return "Deleted employee with ID: " + id;
    }
}
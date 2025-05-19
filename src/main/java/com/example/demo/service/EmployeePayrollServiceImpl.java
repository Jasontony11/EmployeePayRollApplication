package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeePayRollDTO;
import com.example.demo.model.EmployeePayrollData;

@Service
public class EmployeePayrollServiceImpl implements EmployeePayrollService {

    private final List<EmployeePayrollData> employeeList = new ArrayList<>();
    

    @Override
    public List<EmployeePayrollData> getAllEmployees() {
        return employeeList;
    }

    @Override
    public EmployeePayrollData getEmployeeById(int id) {
        return employeeList.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public EmployeePayrollData createEmployee(EmployeePayRollDTO empDTO) {
        EmployeePayrollData newEmployee = new EmployeePayrollData(empDTO.getName(), empDTO.getSalary());
        employeeList.add(newEmployee);
        return newEmployee;
    }

    @Override
    public EmployeePayrollData updateEmployee(int id, EmployeePayRollDTO empDTO) {
        EmployeePayrollData employee = getEmployeeById(id);
        if (employee != null) {
            employee.setName(empDTO.getName());
            employee.setSalary(empDTO.getSalary());
        }
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeList.removeIf(emp -> emp.getId() == id);
    }
}
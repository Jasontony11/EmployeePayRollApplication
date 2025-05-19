

package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EmployeePayRollDTO;
import com.example.demo.model.EmployeePayrollData;

public interface EmployeePayrollService {
    List<EmployeePayrollData> getAllEmployees();
    EmployeePayrollData getEmployeeById(int id);
    EmployeePayrollData createEmployee(EmployeePayRollDTO empDTO);
    EmployeePayrollData updateEmployee(int id, EmployeePayRollDTO empDTO);
    void deleteEmployee(int id);
}

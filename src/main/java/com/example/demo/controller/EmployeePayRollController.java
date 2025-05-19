package com.example.demo.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.EmployeePayRollDTO;
import com.example.demo.model.EmployeePayrollData;
import com.example.demo.service.EmployeePayrollService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayRollController {
    @Autowired
	private EmployeePayrollService eps;
    @GetMapping("/")
    public String getAllEmployees() {
        return eps.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public String getEmployee(@PathVariable("id") int id) {
        return eps.getEmployee(id);
    }
    
    @PostMapping("/create")
    public EmployeePayrollData createEmployee(@Valid @RequestBody EmployeePayRollDTO empDTO) {
        return eps.createEmployee(new EmployeePayRollDTO(empDTO.getName(),empDTO.getSalary()));
    }


    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable int id,@RequestBody EmployeePayRollDTO employeeData) {
        return eps.updateEmployee(id,new EmployeePayRollDTO(employeeData.getName(),employeeData.getSalary()) );
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        return eps.deleteEmployee(id);
    }
}
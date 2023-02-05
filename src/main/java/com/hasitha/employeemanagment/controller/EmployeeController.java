package com.hasitha.employeemanagment.controller;

import com.hasitha.employeemanagment.dto.EmployeeResponseDTO;
import com.hasitha.employeemanagment.entity.Employee;
import com.hasitha.employeemanagment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create")
    /*This method can be accessed for any user.
    No authentication/authorization will be happened for this method.
    */
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/getAll")
    /*
    * This method can be accessed for both users with the ROLE of HR or MANAGER
    * */
    @PreAuthorize("hasAuthority('ROLE_HR') or hasAuthority('ROLE_MANAGER')")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    /*
     * This method can be accessed for users with the ROLE of EMPLOYEE
     * */
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_EMPLOYEE')")
    public EmployeeResponseDTO getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Hasitha Estate PVT LTD.";
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ROLE_HR')")
    public EmployeeResponseDTO updateEmployeeRole(@RequestBody Employee employee){
        return employeeService.changeRoleOfEmployee(employee);
    }
}

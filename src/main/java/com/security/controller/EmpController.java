package com.security.controller;

import com.security.entity.Employee;
import com.security.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
       String username = SecurityContextHolder.getContext().getAuthentication().getName();
       emp.setUsername(username);
       Employee employee = employeeService.save(emp);
       return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @GetMapping("/get-by/name")
    public ResponseEntity<List<Employee>> findEmpByUsername() {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
           System.out.println(username);
        List<Employee> employees = employeeService.findEmpByUsername(username);
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("delete-by-id/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        employeeService.deleteById(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}

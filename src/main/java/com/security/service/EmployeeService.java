package com.security.service;

import com.security.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    Employee save(Employee emp);

    void deleteById(int id);

    List<Employee> findEmpByUsername(String username);
}

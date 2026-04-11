package com.security.serviceImpl;

import com.security.entity.Employee;
import com.security.repository.EmpRepository;
import com.security.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl  implements EmployeeService {
    @Autowired
    EmpRepository empRepository;
    @Override
    public Employee save(Employee emp) {
        return empRepository.save(emp);
    }

    @Override
    public void deleteById(int id) {

        empRepository.deleteById(id);
    }

    @Override
    public List<Employee> findEmpByUsername(String username) {

     List<Employee>  emp =  empRepository.findByUsername(username);
     return emp;
    }

    @Override
    public List<Employee> getAllEmp() {
        return empRepository.findAll();
    }
}

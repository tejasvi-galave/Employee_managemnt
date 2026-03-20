package com.security.repository;

import com.security.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepository  extends JpaRepository< Employee,Integer> {
    List<Employee> findByUsername(String username);
}

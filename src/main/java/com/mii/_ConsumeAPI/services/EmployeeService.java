/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.services;

import com.mii._ConsumeAPI.entities.Employee;
import com.mii._ConsumeAPI.repositories.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author iqbaloutlaw
 */
@Service
public class EmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepository; 
    
    public Iterable<Employee> getAll(){
        return employeeRepository.findAll();
    }
    
    public Employee getById(String id){
        return employeeRepository.findById(id).get();
    }
    
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
    
    public void delete(String id){
        employeeRepository.delete(new Employee(id));
    }
    
//    public List<Employee> getByEmployee(String id){
//        return employeeRepository.getByEmployee(id);
//    }
}

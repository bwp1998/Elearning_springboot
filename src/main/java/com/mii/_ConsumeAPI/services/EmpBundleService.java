/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.services;

import com.mii._ConsumeAPI.entities.EmpBundleAnswer;
import com.mii._ConsumeAPI.repositories.EmpBundleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author iqbaloutlaw
 */
@Service
public class EmpBundleService {
    
    @Autowired
    EmpBundleRepository empBARepo;
    
    
    public Iterable<EmpBundleAnswer> getAll(){
        return empBARepo.findAll();
    }
    
    public EmpBundleAnswer save(EmpBundleAnswer empba){
        return empBARepo.save(empba);
    }
    
    public List<EmpBundleAnswer> getByEmployee(String employee){
        return empBARepo.getByEmployee(employee);
    }
    
    public Integer getByDataBundleDesc(){
        return empBARepo.getByDataBundleDesc();
    }
}

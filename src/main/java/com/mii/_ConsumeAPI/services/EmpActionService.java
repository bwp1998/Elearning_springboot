/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.services;

import com.mii._ConsumeAPI.entities.EmpAction;
import com.mii._ConsumeAPI.entities.Employee;
import com.mii._ConsumeAPI.repositories.EmpActionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author iqbaloutlaw
 */
@Service
public class EmpActionService {
    @Autowired
    EmpActionRepository empactionRepository;
    
    public Iterable<EmpAction> getAll(){
        return empactionRepository.findAll();
    }
    
    public EmpAction getById(String id){
        return empactionRepository.findById(Integer.parseInt(id)).get();
    }
    
    public EmpAction save(EmpAction empa){
        return empactionRepository.save(empa);
    }
    
    public void delete(Integer id){
        empactionRepository.delete(new EmpAction(id));
    }
    
    public List<EmpAction> getByReplyF(String id){
        return empactionRepository.getByReplyF(Integer.parseInt(id));
    }
    
    
    public List<EmpAction> getByCreateF(String id){
        return empactionRepository.getByCreateF(Integer.parseInt(id));
    }
    
    public List<EmpAction> getByEmployee(String id){
        return empactionRepository.getByEmployee(id);
    }
}

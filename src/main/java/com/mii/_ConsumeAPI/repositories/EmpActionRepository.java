/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.repositories;

import com.mii._ConsumeAPI.entities.EmpAction;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author iqbaloutlaw
 */
@Repository
public interface EmpActionRepository extends CrudRepository<EmpAction, Integer>{
    @Query(value="select * from emp_action where forum = ?1 and action= 'reply'", nativeQuery = true)
    public List<EmpAction> getByReplyF(Integer id);
    @Query(value="select * from emp_action where forum = ?1 and action= 'create'", nativeQuery = true)
    public List<EmpAction> getByCreateF(Integer id);
    
//    @Query(value="select * from emp_action where forum = ?1 ", nativeQuery = true)
//    public List<EmpAction> getByEmployee(Integer id);
    
    
    
}

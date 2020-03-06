/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.repositories;

import com.mii._ConsumeAPI.entities.EmpBundleAnswer;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author iqbaloutlaw
 */
@Repository
public interface EmpBundleRepository extends CrudRepository<EmpBundleAnswer, Integer> {

    @Query(value = "select * from emp_bundle_answer where employee = ?1", nativeQuery = true)
    public List<EmpBundleAnswer> getByEmployee(String employee);

    @Query(value = "SELECT id FROM Emp_bundle_answer ORDER BY id DESC LIMIT 1", nativeQuery = true)
    public Integer getByDataBundleDesc();
}

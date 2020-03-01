/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.repositories;

import com.mii._ConsumeAPI.entities.Forum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author iqbaloutlaw
 */
@Repository
public interface ForumRepository extends CrudRepository<Forum, Integer>{
    
}

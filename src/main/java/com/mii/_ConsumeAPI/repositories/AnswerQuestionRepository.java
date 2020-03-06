/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.repositories;

import com.mii._ConsumeAPI.entities.AnswerQuestion;
import com.mii._ConsumeAPI.entities.Question;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HENSTECH
 */
@Repository
public interface AnswerQuestionRepository extends CrudRepository<AnswerQuestion, Integer>{
    @Query(value="Select * from answer_question where emp_budle_answer = ?1", nativeQuery = true)
    public Iterable<AnswerQuestion> getByBundle(String id);
}

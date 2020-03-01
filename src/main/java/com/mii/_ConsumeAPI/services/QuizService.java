/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.services;

import com.mii._ConsumeAPI.entities.Quiz;
import com.mii._ConsumeAPI.entities.Theory;
import com.mii._ConsumeAPI.repositories.QuizRepository;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author BWP
 */
@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;
    
    public Iterable<Quiz> getAll(){
        return quizRepository.findAll();
    }
    
    public Quiz getById(String id){
        return quizRepository.findById(id).get();
    }
    
    public Quiz save(Quiz quiz){
        return quizRepository.save(quiz);
    }
    
    public void delete(String id){
        quizRepository.delete(new Quiz(id));
    }
    
}

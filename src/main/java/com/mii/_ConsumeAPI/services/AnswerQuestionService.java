/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.services;

import com.mii._ConsumeAPI.entities.AnswerQuestion;
import com.mii._ConsumeAPI.repositories.AnswerQuestionRepository;
import com.mii._ConsumeAPI.repositories.QuestionRepositories;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author HENSTECH
 */
@Service
public class AnswerQuestionService {

    @Autowired
    AnswerQuestionRepository answerquestionRepository;

    public Iterable<AnswerQuestion> getAll() {
        return answerquestionRepository.findAll();
    }

    public AnswerQuestion getById(String id){
      return answerquestionRepository.findById(Integer.parseInt(id)).get();
  }

    public AnswerQuestion save(AnswerQuestion answer) {
        return answerquestionRepository.save(answer);
    }

    public void delete(String id) {
        answerquestionRepository.delete(new AnswerQuestion(Integer.parseInt(id)));
    }
}

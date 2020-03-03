/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.services;

import com.mii._ConsumeAPI.entities.Question;

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
public class QuestionServices {

    @Value("${data.url.jwt}")
    private String url;

    @Value("${data.api.key}")
    private String key;

    private static final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    QuestionRepositories questionRepository;

    public Iterable<Question> getAll() {
        return questionRepository.findAll();
    }

    public Question getById(String id) {
        return questionRepository.findById(id).get();
    }

    public Question save(Question question) {
        return questionRepository.save(question);
    }

    public void delete(String id) {
        questionRepository.delete(new Question(Integer.parseInt(id)));
    }

    private HttpHeaders getHeaders() {
        return new HttpHeaders() {
            {
                set("Authorization", key);
                setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            }
        };
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mii._ConsumeAPI.entities.Employee;
import com.mii._ConsumeAPI.entities.EmployeeLogin;
import com.mii._ConsumeAPI.entities.LoginData;
import com.mii._ConsumeAPI.repositories.LoginRepositories;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author BWP
 */
@Service
public class LoginRest {

//    @Value("${data.urlnya}")
    @Value("${data.url.jwt}")
    private String url;

    @Value("${data.api.key}")
    private String key;

    private static final RestTemplate restTemplate = new RestTemplate();
    
    @Autowired
    LoginRepositories repository;

    public EmployeeLogin login(LoginData loginData){
        HttpEntity<LoginData> request = new HttpEntity<LoginData>(loginData, getHeaders());
        System.out.println(request.getBody().getEmail()+"-"+request.getBody().getPassword());
        
        ResponseEntity<EmployeeLogin> responseEntity = restTemplate.exchange(
                url + "/login",
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<EmployeeLogin>(){
                }
        );
        
        EmployeeLogin result = responseEntity.getBody();
        return result;
    }

    //GETHEADER
    private HttpHeaders getHeaders() {
        return new HttpHeaders() {
            {
                set("Authorization", key);
                setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            }
        };
    }
    
    public Iterable<Employee> getAll(){
        return repository.findAll();
    }
    
    public Employee getById(String id){
        return repository.findById(id).get();
    }
    
    public Employee save(Employee employee){
        return repository.save(employee);
    }
    
    public void delete(String id){
        repository.delete(new Employee(id));
    }
}

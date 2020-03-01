/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.services;

import com.mii._ConsumeAPI.entities.Forum;
import com.mii._ConsumeAPI.repositories.ForumRepository;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author iqbaloutlaw
 */
@Service
public class ForumService {
//    
//    @Value("${data.url.jwt}")
//    private String url;
//    
//    @Value("${data.api.key}")
//    private String key;
//    
//    private static final RestTemplate restTemplate = new RestTemplate();
//    
  @Autowired
    ForumRepository forumRepository;
  
  public Iterable<Forum> getAll(){
      return forumRepository.findAll();
  }
  
  public Forum getById(String id){
      return forumRepository.findById(Integer.parseInt(id)).get();
  }
  
  public Forum save(Forum forumm){
      return forumRepository.save(forumm);
  }
  
  public void delete(String id){
      forumRepository.delete(new Forum(Integer.parseInt(id)));
  }
  
//  private HttpHeaders getHeaders() {
//        return new HttpHeaders() {
//            {
//                set("Authorization", key);
//                setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//            }
//        };
//    }
}

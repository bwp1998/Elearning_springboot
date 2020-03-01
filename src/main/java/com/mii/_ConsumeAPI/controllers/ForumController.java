/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.controllers;

import com.mii._ConsumeAPI.services.EmpActionService;
import com.mii._ConsumeAPI.services.ForumService;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author iqbaloutlaw
 */
@Controller
public class ForumController {
    
    @Autowired
    ForumService fservice;
    
    @Autowired
    EmpActionService empaservice;
    
    @RequestMapping("/forum")
    public String forum(Model model){
        model.addAttribute("forums",fservice.getAll());
        return "forum";
    }
    
    @RequestMapping("/forum_detail")
    public String forumDetail(Model model, HttpServletRequest request){
//        model.addAttribute("forumdetail",empaservice.getById("1"));
//        model.addAttribute("forumdetail", empaservice.getById(request.getParameter("id")));
//        System.out.println("INI SIAPA =" + request.getParameter("id"));
        return "forum_detail";
    }
}

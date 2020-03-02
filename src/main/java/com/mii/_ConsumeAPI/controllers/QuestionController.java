/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.controllers;

import com.mii._ConsumeAPI.services.QuestionServices;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HENSTECH
 */
@Controller
public class QuestionController {
     @Autowired
    QuestionServices service;
      
    
    @RequestMapping("/answer")
    public String question(Model model, HttpServletRequest request){
        model.addAttribute("nama", "Hallo " + request.getSession().getAttribute("employee"));
        System.out.println("nama33 = " + model.getAttribute("nama"));
        
        
        model.addAttribute("questions", service.getAll());
        return "answer";
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.controllers;

import com.mii._ConsumeAPI.entities.Quiz;
import com.mii._ConsumeAPI.services.QuizService;
import com.mii._ConsumeAPI.services.TheoryService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author BWP
 */
@Controller
public class TheoryController {
    
    @Autowired
    TheoryService theoryservice;
    
    @Autowired
    QuizService quizService;
    
    @RequestMapping("/theory")
    public String theory(Model model, HttpServletRequest request){
        model.addAttribute("nama", "Hallo "+request.getSession().getAttribute("employee"));
        model.addAttribute("theories", theoryservice.getAll());
        return "theory";
    }
    
    @RequestMapping("/theory_detail")
    public String theoryDetail(Model model, HttpServletRequest request){
//        Quiz quiz = new Quiz();
        
        model.addAttribute("nama", "Hallo "+request.getSession().getAttribute("employee"));
        model.addAttribute("theory", theoryservice.getById(request.getParameter("id")));
//        model.addAttribute("quiz",quizService.);
        System.out.println("IDNYA WEI "+request.getParameter("id"));
//        System.out.println("IDNYA WEI "+model.getAttribute("theory"));
        return "theory_detail";
    };
    
}

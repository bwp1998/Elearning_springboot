/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.controllers;

import com.mii._ConsumeAPI.entities.Employee;
import com.mii._ConsumeAPI.entities.Quiz;
import com.mii._ConsumeAPI.entities.StudyClass;
import com.mii._ConsumeAPI.entities.Theory;
import com.mii._ConsumeAPI.services.QuizService;
import com.mii._ConsumeAPI.services.TheoryService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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
        
        model.addAttribute("nama", "Hallo "+request.getSession().getAttribute("employee"));
        model.addAttribute("theory", theoryservice.getById(request.getParameter("id")));
//        model.addAttribute("quizs",quizService.getAll());
        model.addAttribute("quizs",quizService.getByTheory(request.getParameter("id")));
//        System.out.println(quizService.getByTheory(1));
        System.out.println("QUIZ = "+ request.getAttribute("quizs"));
        System.out.println("IDNYA WEI "+request.getParameter("id"));
//        System.out.println("IDNYA WEI "+model.getAttribute("theory"));
        return "theory_detail";
    }
    
    @RequestMapping("/theory_input")
    public String theory_input(Model model, HttpServletRequest request){
        model.addAttribute("nama", "Hallo "+request.getSession().getAttribute("employee"));
        model.addAttribute("theories", theoryservice.getAll());
        return "theory_input";
    }
    
    @PostMapping("/theory_detail/save")
    public String save(HttpServletRequest request){
        String title = request.getParameter("title");
        String definition = request.getParameter("definition");
        String upload = request.getParameter("upload");
        int kelas = Integer.parseInt(request.getParameter("kelas"));
        Theory t = new Theory(0,title, definition, upload, new Employee("16154"), new StudyClass(kelas));
        theoryservice.save(t);
        System.out.println(title +definition + upload + kelas);
        return "redirect:/theory";
    }
}

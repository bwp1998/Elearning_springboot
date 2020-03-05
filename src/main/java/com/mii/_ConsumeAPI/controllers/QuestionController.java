/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.controllers;

import com.mii._ConsumeAPI.entities.Question;
import com.mii._ConsumeAPI.entities.Quiz;
import com.mii._ConsumeAPI.services.QuestionServices;
import com.mii._ConsumeAPI.services.QuizService;
import com.mii._ConsumeAPI.services.TheoryService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String question(Model model, HttpServletRequest request) {
        model.addAttribute("nama", "Hallo " + request.getSession().getAttribute("employee"));
        model.addAttribute("questions", service.getByQuiz(request.getParameter("id")));
        System.out.println(request.getParameter("id"));
//        model.addAttribute("questions", service.getAll());
        return "answer";
    }

    @RequestMapping("/question_input")
    public String theory_input(Model model, HttpServletRequest request) {
//        model.addAttribute("nama", "Hallo "+request.getSession().getAttribute("employee"));
//        model.addAttribute("questions", service.getAll());
        return "question_input";
    }

    @PostMapping("/question_input/save")
    public String save(Model model, HttpServletRequest request) {
        String question = request.getParameter("question");
        String option1 = request.getParameter("option1");
        String option2 = request.getParameter("option2");
        String option3 = request.getParameter("option3");
        String option4 = request.getParameter("option4");
        String questionKey = request.getParameter("questionKey");
        String quiz = request.getParameter("quiz");

        Question t = new Question(0, question, option1, option2, option3, option4, questionKey, new Quiz(quiz));
//        Theory t = new Theory(0,title, definition, upload, new Employee("16154"), new StudyClass(kelas));
        service.save(t);
        return "redirect:/question_input";
    }
    

}

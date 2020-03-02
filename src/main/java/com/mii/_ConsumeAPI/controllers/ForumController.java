/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.controllers;

import com.mii._ConsumeAPI.services.EmpActionService;
import com.mii._ConsumeAPI.services.EmployeeService;
import com.mii._ConsumeAPI.services.ForumService;
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
    EmpActionService empaService;

    @Autowired
    EmployeeService empService;

    @RequestMapping("/forum")
    public String forum(Model model, HttpServletRequest request) {
        model.addAttribute("nama", "Hallo " + request.getSession().getAttribute("employee"));
        System.out.println("NAMA 44FORUM= " + model.getAttribute("nama"));
        model.addAttribute("forums", fservice.getAll());
        return "forum";
    }

    @RequestMapping("/forum_detail")
    public String forumDetail(Model model, HttpServletRequest request) {

        model.addAttribute("namaa", "Hallo " + request.getSession().getAttribute("employee"));
        System.out.println("nama33 = " + model.getAttribute("namaa"));

        System.out.println("IDNYA=" + request.getParameter("id"));
        model.addAttribute("forum", fservice.getById(request.getParameter("id")));
        System.out.println("forum = " + model.getAttribute("forum"));
//        model.addAttribute("quizs",quizService.getAll());

        model.addAttribute("empa", empaService.getByReplyF(request.getParameter("id")));
        System.out.println("empa = " + model.getAttribute("empa"));
//        model.addAttribute("employees",empService.getByEmployee(request.getParameter("id")));
//        System.out.println("employee = "+model.getAttribute("employees"));
//        System.out.println("QUIZ = "+ request.getAttribute("quizs"));
//        System.out.println("IDNYA WEI "+request.getParameter("id"));
//        System.out.println("IDNYA WEI "+model.getAttribute("theory"));
//        return "theory_detail";


        model.addAttribute("empname", empaService.getByCreateF(request.getParameter("id")));
//        model.addAttribute("employee", empService.getById("empname.employee.id"));
        System.out.println("isi emp = " + model.getAttribute("empname"));
        return "forum_detail";
    }
;
}
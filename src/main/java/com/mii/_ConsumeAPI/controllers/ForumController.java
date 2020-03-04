/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.controllers;

import com.mii._ConsumeAPI.entities.EmpAction;
import com.mii._ConsumeAPI.entities.Employee;
import com.mii._ConsumeAPI.entities.Forum;
import com.mii._ConsumeAPI.services.EmpActionService;
import com.mii._ConsumeAPI.services.EmployeeService;
import com.mii._ConsumeAPI.services.ForumService;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        if (request.getParameter("searchnya") == null) {
            model.addAttribute("forums", fservice.searchForum("%" + " " + "%"));
        } else {
            model.addAttribute("forums", fservice.searchForum("%" + request.getParameter("searchnya") + "%"));
        }
        model.addAttribute("rolenya", request.getSession().getAttribute("role"));
        return "forum";
    }

   @GetMapping("/forum_detail")
//    @ResponseBody
    public String forumDetail(@RequestParam String id, Model model, HttpServletRequest request) {

        model.addAttribute("nama", "Hallo " + request.getSession().getAttribute("employee"));
        model.addAttribute("namam", request.getSession().getAttribute("employee"));
        System.out.println("nama33 = " + model.getAttribute("nama"));

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
        System.out.println("id = "+id);
        model.addAttribute("idforum", id);
        return "forum_detail";
    };
    
//    @GetMapping("/forum_detail")
//    @ResponseBody
//    public String getforumDetail(@RequestParam String id, Model model, HttpServletRequest request) {
//
////        model.addAttribute("nama", "Hallo " + request.getSession().getAttribute("employee"));
////        model.addAttribute("namam", request.getSession().getAttribute("employee"));
////        System.out.println("nama33 = " + model.getAttribute("nama"));
////
////        System.out.println("IDNYA=" + request.getParameter("id"));
////        model.addAttribute("forum", fservice.getById(request.getParameter("id")));
////        System.out.println("forum = " + model.getAttribute("forum"));
////        model.addAttribute("quizs",quizService.getAll());
//
////        model.addAttribute("empa", empaService.getByReplyF(request.getParameter("id")));
////        System.out.println("empa = " + model.getAttribute("empa"));
////        model.addAttribute("employees",empService.getByEmployee(request.getParameter("id")));
////        System.out.println("employee = "+model.getAttribute("employees"));
////        System.out.println("QUIZ = "+ request.getAttribute("quizs"));
////        System.out.println("IDNYA WEI "+request.getParameter("id"));
////        System.out.println("IDNYA WEI "+model.getAttribute("theory"));
////        return "theory_detail";
//
////        model.addAttribute("empname", empaService.getByCreateF(request.getParameter("id")));
////        model.addAttribute("employee", empService.getById("empname.employee.id"));
////        System.out.println("isi emp = " + model.getAttribute("empname"));
//            System.out.println("id = "+id);
//          return "forum_detail?id="+id;
//    }
    
    @RequestMapping("/inputforum")
    public String inputForum(Model model, HttpServletRequest request) {
        model.addAttribute("nama", "Hallo " + request.getSession().getAttribute("employee"));
        return "inputforum";
    }

    @PostMapping("/forum_detail/save")
    public String save(Model model, HttpServletRequest request) {
        String topic = request.getParameter("topic");
        String description = request.getParameter("description");
//        String employee = request.getParameter("employee");
//        String forum = request.getParameter("forum");
        String pattern = "yyyy-mm-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        Date date = new Date();
        Timestamp ts = new Timestamp(System.currentTimeMillis());

        Forum f = new Forum(0, topic, description, ts);
        fservice.save(f);
        System.out.println(topic + description + ts.toString());
        int a = (int) request.getSession().getAttribute("forum");
        EmpAction ea = new EmpAction(0,"create",ts,"",0, new Employee(request.getSession().getAttribute("employeeid").toString()), new Forum(a));
        empaService.save(ea);
        return "redirect:/forum";
    }

    @PostMapping("/forum_detail/reply")
    public String reply(HttpServletRequest request) {
        String comment = request.getParameter("reply");
        String idforum = request.getParameter("idforum");

        String pattern = "yyyy-mm-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();

//        Emp f = new Forum(0, topic, description, date);
//        empaService.save(f);
//        System.out.println(topic + description + date);
        EmpAction ea = new EmpAction(0, "reply", date, comment, 2, new Employee(request.getSession().getAttribute("employeeid").toString()), new Forum(Integer.parseInt(idforum)));
        empaService.save(ea);
        return "redirect:/forum_detail?id="+idforum;
    }

    @GetMapping("/searchnya")
    public String searchnya(Model model, HttpServletRequest request) {
        model.addAttribute("nama", "Hallo " + request.getSession().getAttribute("employee"));
        System.out.println("NAMA 44FORUM= " + model.getAttribute("nama"));
        if (request.getParameter("searchnya") == null) {
            model.addAttribute("forums", fservice.searchForum("%" + " " + "%"));
        } else {
            model.addAttribute("forums", fservice.searchForum("%" + request.getParameter("searchnya") + "%"));
        }
        model.addAttribute("rolenya", request.getSession().getAttribute("role"));
        return "forum";
    }
}

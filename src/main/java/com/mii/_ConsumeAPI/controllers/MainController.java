/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author BWP
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String home(Model model, HttpServletRequest request) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("user", auth.getName());
        model.addAttribute("nama", "Hallo " + request.getSession().getAttribute("employee"));
        model.addAttribute("rolenya", request.getSession().getAttribute("role"));
        System.out.println("NAMANYA 2=" + model.getAttribute("nama"));
        return "index";
    }

}

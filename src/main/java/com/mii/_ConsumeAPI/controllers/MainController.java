/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.controllers;

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
    public String home(Model model){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("user", auth.getName());
        return"index";
    }
    
    @RequestMapping("/index2")
    public String index(Model model){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("user", auth.getName());
        return"index2";
    }
    
    
}

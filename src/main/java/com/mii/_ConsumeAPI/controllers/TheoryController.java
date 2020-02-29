/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.controllers;

import com.mii._ConsumeAPI.services.TheoryService;
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
    TheoryService service;
    
    @RequestMapping("/theory")
    public String theory(Model model){
        model.addAttribute("theories", service.getAll());
        return "theory";
    }
    
    
}

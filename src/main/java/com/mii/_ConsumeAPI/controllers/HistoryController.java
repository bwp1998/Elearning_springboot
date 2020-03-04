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
public class HistoryController {
    @RequestMapping("/history_quiz")
    public String forum(Model model, HttpServletRequest request) {
        model.addAttribute("nama", "Hallo " + request.getSession().getAttribute("employee"));
        System.out.println("NAMA 44FORUM= " + model.getAttribute("nama"));
        model.addAttribute("rolenya", request.getSession().getAttribute("role"));
        return "history_quiz";
    }
}

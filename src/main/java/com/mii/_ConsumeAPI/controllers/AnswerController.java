/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.controllers;

import com.mii._ConsumeAPI.entities.AnswerQuestion;
import com.mii._ConsumeAPI.services.AnswerQuestionService;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author BWP
 */
@Controller
public class AnswerController {

    @Autowired
    AnswerQuestionService answerQuestionService;

    @PostMapping(value = "/answerBundle/save")
    String getAnswer(HttpServletRequest request) {
//        JSONObject jo = new JSONObject();
        String answernya = request.getParameter("scorenya").toString();
        System.out.println("Score= "+ answernya);
        return "redirect:/";
        // your logic next
    }
}

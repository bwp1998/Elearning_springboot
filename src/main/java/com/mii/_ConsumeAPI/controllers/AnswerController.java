/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.controllers;

import com.mii._ConsumeAPI.entities.AnswerQuestion;
import com.mii._ConsumeAPI.entities.EmpBundleAnswer;
import com.mii._ConsumeAPI.entities.Employee;
import com.mii._ConsumeAPI.entities.Question;
import com.mii._ConsumeAPI.services.AnswerQuestionService;
import com.mii._ConsumeAPI.services.EmpBundleService;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author BWP
 */
@Controller
public class AnswerController {

    @Autowired
    AnswerQuestionService answerQuestionService;

    @Autowired
    EmpBundleService empBS;

    @PostMapping(value = "/answerBundle/save")
    String getAnswer(HttpServletRequest request) {
//        JSONObject jo = new JSONObject();
        String answernya = request.getParameter("scorenya").toString();
        System.out.println("Score= " + answernya);
        return "redirect:/";
        // your logic next
    }

    
    @RequestMapping(value = "/answer/savescore")

    public String getSearchResultViaAjax(Model model, HttpServletRequest request, @RequestParam(value = "totalscore") String savescore) {
//        String score = request.getParameter("score");
//        String pattern = "yyyy-mm-dd";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        Date date = new Date();
         
        System.out.println("total score = " + savescore);
        EmpBundleAnswer empBA = new EmpBundleAnswer(0, Integer.parseInt(savescore),new Date(0), new Employee(request.getSession().getAttribute("employeeid").toString()));
        empBS.save(empBA);
        int idbund = empBS.getByDataBundleDesc();

        System.out.println("Key = " + request.getParameter("istrue"));
        System.out.println("Answer = " + request.getParameter("answer"));

        String[] isTrue = request.getParameter("istrue").toString().split(",");
        String[] answer = request.getParameter("answer").toString().split(",");
        String[] question = request.getParameter("idquiz").toString().split(",");
        System.out.println("ID BUND="+ idbund);
        for (int i = 0; i < isTrue.length; i++) {

            AnswerQuestion eq = new AnswerQuestion();
//            AnswerQuestion eq = new AnswerQuestion(0, answer[i], Integer.parseInt(isTrue[i]), new EmpBundleAnswer(idbund), new Question(Integer.parseInt(question[i])));
            eq.setId(i);
            eq.setAnswer(answer[i]);
            eq.setIsTrue(Integer.parseInt(isTrue[i]));
            eq.setEmpBundleAnswer(new EmpBundleAnswer(idbund) );
            eq.setQuestion(new Question(Integer.parseInt(question[i])));
            answerQuestionService.save(eq);
            System.out.println("isTRUE = " + isTrue[i]);
        }
        return "redirect:/theory";

    }
}

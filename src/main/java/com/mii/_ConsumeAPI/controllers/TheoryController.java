/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.controllers;

import com.mii._ConsumeAPI.entities.Employee;
import com.mii._ConsumeAPI.entities.StudyClass;
import com.mii._ConsumeAPI.entities.Theory;
import com.mii._ConsumeAPI.services.QuestionServices;
import com.mii._ConsumeAPI.services.QuizService;
import com.mii._ConsumeAPI.services.TheoryService;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author BWP
 */
@Controller
public class TheoryController {

    private static final String UPLOADED_FOLDER = "D://METRO_DATA//ProjectWEB//33_ConsumeAPI//src//main//resources//static//file//";

    @Autowired
    TheoryService theoryservice;

    @Autowired
    QuizService quizService;
    @Autowired
    QuestionServices QuestionServices;

    @RequestMapping("/theory")
    public String theory(Model model, HttpServletRequest request) {
        model.addAttribute("nama", "Hallo " + request.getSession().getAttribute("employee"));
        model.addAttribute("rolenya", request.getSession().getAttribute("role"));
        model.addAttribute("theories", theoryservice.getAll());
        return "theory";
    }

    @RequestMapping("/theory_detail")
    public String theoryDetail(Model model, HttpServletRequest request) {

        model.addAttribute("nama", "Hallo " + request.getSession().getAttribute("employee"));
        model.addAttribute("rolenya", request.getSession().getAttribute("role"));
        model.addAttribute("theory", theoryservice.getById(request.getParameter("id")));
        model.addAttribute("quizs", quizService.getByTheory(request.getParameter("id")));

        System.out.println("question = " + request.getAttribute("question"));
        System.out.println("QUIZ = " + request.getAttribute("quizs"));
        System.out.println("IDNYA WEI " + request.getParameter("id"));
        return "theory_detail";
    }

    @RequestMapping("/theory_input")
    public String theory_input(Model model, HttpServletRequest request) {
        model.addAttribute("nama", "Hallo " + request.getSession().getAttribute("employee"));
        model.addAttribute("theories", theoryservice.getAll());
        model.addAttribute("rolenya", request.getSession().getAttribute("role"));

        return "theory_input";
    }

    @PostMapping("/theory_detail/save")
    public String save(HttpSession session, HttpServletRequest request, @RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/";
        }
        
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String title = request.getParameter("title");
        String definition = request.getParameter("definition");
        String upload = "http://localhost:8083/file/" + file.getOriginalFilename();
        int kelas = Integer.parseInt(request.getParameter("kelas"));
        Theory t = new Theory(0, title, definition, upload, new Employee("16154"), new StudyClass(kelas));
        theoryservice.save(t);
        System.out.println(title + definition + upload + kelas);
        return "redirect:/theory";
    }

}

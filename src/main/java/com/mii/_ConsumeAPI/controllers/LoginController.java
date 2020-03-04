/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.controllers;

import com.mii._ConsumeAPI.entities.Employee;
import com.mii._ConsumeAPI.entities.EmployeeLogin;
import com.mii._ConsumeAPI.entities.LoginData;
import com.mii._ConsumeAPI.services.LoginRest;
import com.mii._ConsumeAPI.services.SendMailServices;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author BWP
 */
@Controller
public class LoginController {

    @Autowired
    private LoginRest rest;
    
    @Autowired
    private SendMailServices sendMailServices;

    @GetMapping("/login")
    public String handlingLog() {
        String result = "";
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!auth.getName().equalsIgnoreCase("anonymousUser")) {
            result = "redirect:/";
        } else {
            result = "login";
        }
        return result;
    }

    @PostMapping("/verification")
    public String verification(LoginData loginData, RedirectAttributes redirect, HttpServletRequest request) { //, Model model perubahan parameter model ndak ada (coba)
        String result = "";
        EmployeeLogin employeeLogin = rest.login(loginData);
        System.out.println(employeeLogin.getStatus());

        if (employeeLogin.getStatus().equalsIgnoreCase("Login Success")) {
            //ambil semua role
            User user = new User(employeeLogin.getEmployee().getId(), "", getAuthorities(employeeLogin));
            //diberi akses 
            PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(user, "", user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            
//            System.out.println("NAMANYA = "+ employeeLogin.getEmployee().getFirstName()); // coba
//            System.out.println("id=" + employeeLogin.getEmployee().getId());
//            System.out.println("nama=" + employeeLogin.getEmployee().getLastName());
//            System.out.println("email=" + employeeLogin.getEmployee().getEmail());
            if (employeeLogin.getEmployee().getId() != null) {
                String pattern = "yyyy-mm-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                Date date;
                try {
                    date = simpleDateFormat.parse(employeeLogin.getEmployee().getBirthDate());
                    Employee employee = new Employee(employeeLogin.getEmployee().getId(),
                            employeeLogin.getEmployee().getFirstName() + " " + employeeLogin.getEmployee().getLastName(),
                            employeeLogin.getEmployee().getEmail(), 1, date);
                    rest.save(employee); //send ke database local
                    request.getSession().setAttribute("employee", employeeLogin.getEmployee().getFirstName());
                    request.getSession().setAttribute("employeeid", employeeLogin.getEmployee().getId());
                    System.out.println("IDNYA = " + request.getSession().getAttribute("employeeid"));
                    System.out.println("NAMANYA = " + request.getSession().getAttribute("employee"));
                    request.getSession().setAttribute("role", employeeLogin.getEmployee().getRoles());
                    System.out.println("Role = " + request.getSession().getAttribute("role"));
//                    SEND EMAIL
//                    sendMailServices.sendHistory(); 
                } catch (ParseException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            result = "redirect:/";
        } else {
            result = "redirect:/login";
        }
        return result;
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(EmployeeLogin employeeLogin) {
        final List<SimpleGrantedAuthority> authorities = new LinkedList<>();
        for (String role : employeeLogin.getEmployee().getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

}

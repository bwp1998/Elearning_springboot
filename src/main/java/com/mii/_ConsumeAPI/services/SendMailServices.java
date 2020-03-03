/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.services;

import com.mii._ConsumeAPI.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author BWP
 */
@Service
public class SendMailServices {
    private JavaMailSender javaMailSender;
    
    @Autowired 
    public SendMailServices(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    
    public void sendHistory() throws MailException{
        //send mail
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("baguswidyantoroputro@gmail.com");
        
        //pengirim
        mail.setFrom("cobakirimjava@gmail.com");
        
        //subject email
        mail.setSubject("History Quiz");
        
        //isi emailnya
        mail.setText("test semoga bisa :V");
        javaMailSender.send(mail);
    }
}

package com.gdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdm.service.implementation.MailService;

@Controller
public class EnviarMailController {

    @Autowired
    private MailService mailService;

    @GetMapping("/send")
    public String indsend_mail_view(){
        return "send_mail_view";
    }

    @PostMapping("/sendMail")
    public String enviarEmail(@RequestParam("name") String nombre, @RequestParam("mail") String mail, @RequestParam("titulo") String subject, @RequestParam("cuerpo") String cuerpoEmail){

        String message = cuerpoEmail +"\n\n Datos de contacto: " + "\nNombre: " + nombre + "\nE-mail: " + mail;
        mailService.sendMail(mail,"afcordoba09@gmail.com",subject,message);

        return "send_mail_view";
    }
}

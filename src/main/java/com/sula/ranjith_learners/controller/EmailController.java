package com.sula.ranjith_learners.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

@RestController
@RequestMapping(
        value = "/api",
        produces = "application/json")
@Transactional

@CrossOrigin(origins = {
        "*"

},
        allowedHeaders = "*",

        maxAge = 15 * 60,
        methods = {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.DELETE,
                RequestMethod.PUT
        })
public class EmailController {

    @Autowired
    private JavaMailSender sender;

    @GetMapping("/mail/{email}/{msg}")
    //@ResponseBody
    String home(@PathVariable String email, @PathVariable String msg) {

        System.out.println("XXXX"+email+msg);

        try {
            sendEmail(email, msg);
            return "Email Sent!";
        }catch(Exception ex) {
            return "Error in sending email: "+ex;
        }
    }

    private void sendEmail(String email, String msg) throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        String txt=msg;

        helper.setTo(email);
        helper.setText(txt);
        helper.setSubject("Hi");

        sender.send(message);
    }
}

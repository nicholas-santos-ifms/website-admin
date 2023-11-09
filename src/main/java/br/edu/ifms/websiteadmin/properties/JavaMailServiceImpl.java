/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.websiteadmin.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author santos
 */
@Service
@Profile("mail")
public class JavaMailServiceImpl implements IMailService {

    @Autowired
    private JavaMailSender mailSender;
    
    @Override
    public void send(SimpleMailMessage msg) {
        mailSender.send(msg);
    }
    
}

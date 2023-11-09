/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.websiteadmin.properties;

import org.springframework.context.annotation.Profile;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 *
 * @author santos
 */
@Service
@Profile("!mail")
public class NoopMailServiceImpl implements IMailService {
    
    @Override
    public void send(SimpleMailMessage msg) {
        System.err.println("--** Dummy implementation, no e-mail is being sent **--");
    }
    
}

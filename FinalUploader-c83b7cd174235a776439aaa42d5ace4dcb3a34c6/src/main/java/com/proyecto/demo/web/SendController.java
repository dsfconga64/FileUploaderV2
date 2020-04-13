package com.proyecto.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.demo.domain.User;

@RestController
public class SendController {
	
	private static final String DESTINATION_NAME = "testqueue";

	@Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/messages")
    public String postMessage(@RequestParam String message) {
        
        jmsTemplate.convertAndSend(DESTINATION_NAME, new User(message).getFirstName());
        return message;
    }

}

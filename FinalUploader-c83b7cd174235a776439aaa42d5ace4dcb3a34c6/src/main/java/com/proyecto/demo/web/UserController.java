package com.proyecto.demo.web;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.demo.domain.User;
import com.proyecto.demo.service.UserService;

import reactor.core.publisher.Flux;

@Controller
public class UserController {

	@Autowired
	UserService serv;

	private static final String DESTINATION_NAME = "testqueue";

	@Autowired
	private JmsTemplate jmsTemplate;

	@RequestMapping("")
	public String indexPage(Model model) throws ParseException {
		User user = new User();
		model.addAttribute("user", new User());
		model.addAttribute("user", user);
		return "index";
	}

	@PostMapping("/usuario/registrar")
	public String addUser(@RequestBody User newUser) {
		jmsTemplate.convertAndSend(DESTINATION_NAME, newUser.getFirstName());
		serv.saveUser(newUser);
		return "redirect:/Test/";

	}

	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<User> getUser() {

		return serv.getAllUsers();
	}
}

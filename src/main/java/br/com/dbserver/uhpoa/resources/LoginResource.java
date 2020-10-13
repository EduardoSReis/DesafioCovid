package br.com.dbserver.uhpoa.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginResource {
	
	@GetMapping
	@RequestMapping("/login")
	public String login(){
		return "login";
	}

}

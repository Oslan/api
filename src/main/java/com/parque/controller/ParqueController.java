package com.parque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParqueController {
	
	
	@RequestMapping("/default")
	public String novo() {
		
		return "parque/novo";
	}
	
	

}

package com.ncoronel.ar.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/holamundo")
public class HolaMundoController {

	
	@GetMapping("/saludar")
	public String saludar(){
		return "hola";
	}
}

package com.ncoronel.ar.springboot.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ncoronel.ar.springboot.constant.Constant;

@ControllerAdvice //Clase encargada si se produce un error, manejo de excepciones
public class ErrorController {
	
	@ExceptionHandler(Exception.class)
	public String showInternalServerError() {
		return Constant.ERROR_VIEW_500;
	}

}

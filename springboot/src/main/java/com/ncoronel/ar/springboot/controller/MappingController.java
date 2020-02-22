package com.ncoronel.ar.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ncoronel.ar.springboot.constant.Constant;
import com.ncoronel.ar.springboot.model.Person;

@Controller
@RequestMapping("index")
public class MappingController {

	
	//primera forma de enviar por GET
	//localhost:8080/index/requestGet1?nameParameter=valueParameter
	//localhost:8080/index/requestGet1?nameParameter=valueParameter&name2Parameter=value2Parameter--En el caso de enviar de un parametro

	@GetMapping("requestGet1") // esto se lo agrego para que no se obligatorio el parametro
	public ModelAndView getMapping( @RequestParam(name="nameParameter", required=false,defaultValue = "NULL") String name) {
		ModelAndView mav = new ModelAndView(Constant.MAPPING_VIEW_EXAMPLE_GET_PARAMETER);
		mav.addObject("nameParameter_in_model",name);
		return mav;
	}
	
	
	
	//Segunda forma de enviar por get
	
	//localhost:8080/index/requestGet2/parameter
	@GetMapping("requestGet2/{nameParameter}") //nombre del parametro
	public ModelAndView getMapping2(@PathVariable("nameParameter") String name) {
		ModelAndView mav = new ModelAndView(Constant.MAPPING_VIEW_EXAMPLE_GET_PARAMETER);
		mav.addObject("nameParameter_in_model",name);
		return mav;
	}
	
	@GetMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("person", new Person());
		return Constant.MAPPING_VIEW_EXAMPLE_FORM;
	}
	
	
	@PostMapping("addPerson")
	public ModelAndView addPerson(@ModelAttribute("person") Person persona){//es el nombre del objeto que tiene en la vista
		ModelAndView mav = new ModelAndView(Constant.MAPPING_VIEW_EXAMPLE_RESULT);
		mav.addObject("person_model", persona);
		return mav;
		
	}
}

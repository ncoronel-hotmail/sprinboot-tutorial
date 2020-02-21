package com.ncoronel.ar.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ncoronel.ar.springboot.constant.Constant;
import com.ncoronel.ar.springboot.model.Person;

@Controller
@RequestMapping("/example")
public class ExampleController {

	// Primera forma de retornar un view- de la forma de un String

	@GetMapping("/string")//la peticion se realiza por get, puede ser por POST,DELETE, PUT, PATCH
	public String exampleString() {
		return Constant.EXAMPLE_VIEW_EXAMPLE; // example es el nombre de la vista, no hace falta poner la extension html,jsp
							// etc.
	}

	// Segunda forma de retornar un view- de la forma de un ModelAndView

	@GetMapping("/modelandview")
	public ModelAndView exampleMdelAndView() {
		return new ModelAndView(Constant.EXAMPLE_VIEW_EXAMPLE);
	}
	
	
	@GetMapping("/stringDatoSimple")//la peticion se realiza por get, puede ser por POST,DELETE, PUT, PATCH
	public String exampleStringDatoSimple(Model model) {
		model.addAttribute("name","nicolas");//name es el nombre que tiene en la vista
		return Constant.EXAMPLE_VIEW_EXAMPLE_NAME; 
	}
	
	@GetMapping("/modelandviewDatoSimple")
	public ModelAndView exampleMdelAndViewDatoSimple() {
		ModelAndView mav =new  ModelAndView(Constant.EXAMPLE_VIEW_EXAMPLE_NAME);
		mav.addObject("name", "alejandro");
		return mav;
	}
	
	@GetMapping("/stringDatoComplejo")//la peticion se realiza por get, puede ser por POST,DELETE, PUT, PATCH
	public String exampleStringDatoComplejo(Model model) {
		model.addAttribute("person",new Person("nicolas", 30));//name es el nombre que tiene en la vista
		return Constant.EXAMPLE_VIEW_EXAMPLE_COMPLEX; 
	}
	
	@GetMapping("/modelandviewDatoComplejo")
	public ModelAndView exampleMdelAndViewDatoComplejo() {
		ModelAndView mav =new  ModelAndView(Constant.EXAMPLE_VIEW_EXAMPLE_COMPLEX);
		mav.addObject("person",new Person("yesica", 30));
		return mav;
	}
	
	
	
	@GetMapping("/stringDatoList")//la peticion se realiza por get, puede ser por POST,DELETE, PUT, PATCH
	public String exampleStringDatoList(Model model) {
		model.addAttribute("people",getPeople());//name es el nombre que tiene en la vista
		return Constant.EXAMPLE_VIEW_EXAMPLE_LIST; 
	}
	
	@GetMapping("/modelandviewDatoList")
	public ModelAndView exampleMdelAndViewDatoList() {
		ModelAndView mav =new  ModelAndView(Constant.EXAMPLE_VIEW_EXAMPLE_LIST);
		mav.addObject("people",getPeople());
		return mav;
	}
	
	
	private List<Person> getPeople(){
		List<Person> person = new ArrayList<Person>();
		person.add(new Person("yesica", 30));
		person.add(new Person("nicolas", 23));
		person.add(new Person("valeria", 32));
		person.add(new Person("alejandro", 14));
		person.add(new Person("calderon", 36));
		person.add(new Person("coronel", 34));
		person.add(new Person("calderon", 36));

		
		person= person.stream().filter(p->p.getAge() <31).distinct().collect(Collectors.toList());
		return person;

		
	}

}

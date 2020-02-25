package com.ncoronel.ar.springboot.controller;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ncoronel.ar.springboot.constant.Constant;
import com.ncoronel.ar.springboot.entity.Course;
import com.ncoronel.ar.springboot.service.CourseService;

/**
 * 
 * @author coronel Nicolas
 *
 */

@Controller
@RequestMapping("/course")
public class CourseController {

	private static final Log LOGGER = org.apache.commons.logging.LogFactory.getLog(CourseController.class);
	
	
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;
	
	
	@GetMapping("/")
	public RedirectView redirectList() {
		return new RedirectView("list");
	}
	
	
	/**
	 * Metodo que retorna la vista con la  lista de cursos disponibles
	 * @return
	 */
	@GetMapping("/list")
	public  ModelAndView list() {
		
		LOGGER.info("Ingreso al metodo list");
		ModelAndView mav =new ModelAndView(Constant.COURSE_VIEW_COURSE);
		mav.addObject("listCourse", courseService.getAll());
		mav.addObject("course", new Course());

		return mav;
	
	
	}

	
	
	@PostMapping("createCourse")// en modelAtributte el nombre "course" es el nombre de la variable
	// que recibe de la vista del formulario
	public RedirectView createCourse( @ModelAttribute("course") Course course) {
		LOGGER.info("Ingreso al metodo createCourse");

		courseService.saveCourse(course);
		
		return new RedirectView("list");
		
	}
	
	
	
}

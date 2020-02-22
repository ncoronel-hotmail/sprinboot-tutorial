package com.ncoronel.ar.springboot.service;

import java.util.List;

import com.ncoronel.ar.springboot.model.Person;

public interface PersonService {
	
	
	public  List<Person> allPerson();
	public Person getPersonByName(String name);

}

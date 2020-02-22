package com.ncoronel.ar.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.ncoronel.ar.springboot.model.Person;
import com.ncoronel.ar.springboot.service.PersonService;


@Service("personService")
public class PersonServiceImpl implements PersonService {
	
	
	private static  final Log LOGGER = LogFactory.getLog(PersonServiceImpl.class);

	@Override
	public List<Person> allPerson() {
		
		LOGGER.info("Ingreso por el servicio PersonServiceImpl" );
		List<Person> person = new ArrayList<Person>();
		person.add(new Person("yesica", 30));
		person.add(new Person("nicolas", 23));
		person.add(new Person("valeria", 32));
		person.add(new Person("alejandro", 14));
		person.add(new Person("calderon", 36));
		person.add(new Person("coronel", 34));
		person.add(new Person("calderon", 36));
		return person;
	}

	@Override
	public Person getPersonByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

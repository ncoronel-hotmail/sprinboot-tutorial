package com.ncoronel.ar.springboot.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("exampleComponent")
public class ExampleComponent {
	
	private static final Log LOGGER = LogFactory.getLog(ExampleComponent.class);
	
	public void saludar() {
		
		 LOGGER.info("Ingreso por el component ExampleComponent");
	}

}

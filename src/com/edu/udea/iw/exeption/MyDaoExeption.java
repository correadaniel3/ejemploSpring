package com.edu.udea.iw.exeption;

import org.apache.log4j.Logger;

/**
 * Clase para el manejo de excepciones
 * @author Daniel Correa Arango
 *
 */
public class MyDaoExeption extends Exception {


	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(this.getClass());
	public MyDaoExeption(String arg0, Throwable arg1) {
		super(arg0, arg1);
		log.error(arg0);
	}

	public MyDaoExeption(Throwable arg0) {
		super(arg0);
		log.error(arg0.getMessage());
	}
	
} 

package com.CRUD.prueba.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class noexcepcion extends RuntimeException{
	
private static final long serialVersionUID = 1L;
	
	public noexcepcion(String message) {
		super(message);
	}
}

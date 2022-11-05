package com.DemoSpring.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NewException {
	@ExceptionHandler
	public String NoElement(Exception ex) {
		return ex.toString();
	}

}

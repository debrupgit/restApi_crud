package com.dsr.rest_crud.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dsr.rest_crud.helper.ResponseStructure;

@RestControllerAdvice
public class MyExceptionHandler 
{
	@Autowired
	ResponseStructure structure;
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ResponseStructure> handle(DataNotFoundException exception)
	{
		structure.setData(exception.getMessage());
		structure.setMessage("data not present");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
//		return structure;
		return new ResponseEntity<ResponseStructure>(structure,HttpStatus.NOT_FOUND);
	}
}

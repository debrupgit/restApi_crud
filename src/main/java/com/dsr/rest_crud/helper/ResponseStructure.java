package com.dsr.rest_crud.helper;

import org.springframework.stereotype.Component;

import com.dsr.rest_crud.dto.Student;

import lombok.Data;

@Component
@Data
public class ResponseStructure <T>
{
	String message;
	int status;
	T data;
}

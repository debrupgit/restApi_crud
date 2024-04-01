package com.dsr.rest_crud.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DataNotFoundException extends RuntimeException 
{
	String message="data not found";
}

package com.dsr.rest_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dsr.rest_crud.dto.Student;
import com.dsr.rest_crud.helper.ResponseStructure;
import com.dsr.rest_crud.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class StudentController 
{
//	@PostMapping("/students")
//	public Student saveStudents(@RequestBody Student student)
//	{
//		return student;
//	}
	
	@Autowired
	StudentService service;
	
	
	@Autowired
	ResponseStructure structure;
	
//	@PostMapping("/students")
//	public ResponseStructure saveStudent(@RequestBody Student student)
//	{
//		structure.setMessage("data saved success");
//		structure.setStatus(HttpStatus.CREATED.value());
//		structure.setData(student);
//		return structure;
//	}
	
	@Operation(summary = "saving one student record")
	@PostMapping("/students")
	public ResponseEntity<ResponseStructure> saveStudent(@RequestBody Student student)
	{
//		return service.saveStudent(student);
		
		return new ResponseEntity<ResponseStructure>(service.saveStudent(student),HttpStatus.CREATED);
	}
	
	@Operation(summary = "fetch student by Id")
	@GetMapping("/students/{id}")
	public ResponseStructure findStudentById(@PathVariable int id)
	{
		return service.findById(id);
	}
	
	@Operation(summary = "fetch all student record")
	@GetMapping("/students")
	public ResponseStructure findAllRecord()
	{
		return service.fetchAllRecord();
	}
	
	@Operation(summary = "save all the student record at once")
	@PostMapping("/students/many")
	public ResponseStructure saveAll(@RequestBody List<Student> students)
	{
		return service.saveMultiple(students);
	}
	
	@Operation(summary = "fetch student by name")
	@GetMapping("/students/name/{name}")
	public ResponseStructure findByName(@PathVariable String name)
	{
		return service.findByName(name);
	}

	@Operation(summary = "fetch student by mobile")
	@GetMapping("students/mobile/{mobile}")
	public ResponseStructure findByMobile(@PathVariable Long mobile)
	{
		return service.findByMobile(mobile);
	}
	
	@Operation(summary = "fetch student by result")
	@GetMapping("students/result/{result}")
	public ResponseStructure findByResult(@PathVariable String result)
	{
		return service.findByResult(result);
	}
	
	@Operation(summary = "fetch students whose  english marks is greater than 60")
	@GetMapping("students/english/greater/{english}")
	public ResponseStructure findGreaterThanEqualSixty(@PathVariable int english)
	{
		return service.findByEnglishGreaterThanSixty(english);
	}
	
	
	@GetMapping("students/{subject}/greater/{marks}")
	public ResponseStructure findByMarksAndSubjectGreater(@PathVariable String subject,@PathVariable int marks)
	{
		return service.findBySubjectMarksGreater(subject,marks);
	}
	
	@Operation(summary = "fetch students whose  subject marks is between initial and last ")
	@GetMapping("students/{subject}/between/{marks}/{marks2}")
	public ResponseStructure findByMarksBetween(@PathVariable String subject,@PathVariable int marks,@PathVariable int marks2)
	{
		return service.findByMarksBetween(subject,marks,marks2);
	}
	
	
	
}

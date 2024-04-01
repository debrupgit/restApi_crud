package com.dsr.rest_crud.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dsr.rest_crud.dto.Student;
import com.dsr.rest_crud.repository.StudentRepository;

@Controller
public class StudentDao 
{
	
	@Autowired
	StudentRepository repository;
	
	
	public void saveStudent(Student student)
	{
		repository.save(student);
	}


	public Optional<Student> findById(int id) 
	{
		return repository.findById(id);
	}

	public List<Student> fetchAllRecord() 
	{
		return repository.findAll();
	}


	public List<Student> saveMultiple(List<Student>students) 
	{
		return repository.saveAll(students);
		
	}


	public List<Student> findByName(String name) 
	{
		return repository.findByName(name);
	}


	public List<Student> findByMobile(Long mobile) {
		
		return repository.findByMobile(mobile);
	}


	public List<Student> findByResult(String result) 
	{
		return repository.findByResult(result);
	}


	public List<Student> findByEnglishGreaterThanSixty(int english) 
	{
		return repository.findByEnglishGreaterThan(60);
	}


	public List<Student> findByEnglishAndMathGreaterThanSixty(int english, int math) 
	{
		return repository.findByEnglishAndMathGreaterThan(english,math);
	}


	public List<Student> findBySubjectMarksGreater(String subject, int marks) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Student> findByMathGreater(int marks) 
	{
		// TODO Auto-generated method stub
		return repository.findByMathGreaterThanEqual(marks);
	}


	public List<Student> findByEnglishGreater(int marks) 
	{
		// TODO Auto-generated method stub
		return repository.findByEnglishGreaterThanEqual(marks);
	}
	
	public List<Student> findByScienceGreater(int marks) 
	{
		// TODO Auto-generated method stub
		return repository.findByScienceGreaterThanEqual(marks);
	}


	public List<Student> findByMathBetween(int marks, int marks2)
	{
		// TODO Auto-generated method stub
		return repository.findByMathBetween(marks,marks2);
	}

	
	public List<Student> findByEnglishBetween(int marks, int marks2)
	{
		// TODO Auto-generated method stub
		return repository.findByEnglishBetween(marks,marks2);
	}
	
	public List<Student> findByScienceBetween(int marks, int marks2)
	{
		// TODO Auto-generated method stub
		return repository.findByScienceBetween(marks,marks2);
	}
	
	
	
//	public List<Student> findBySubjectAndMarksBetween(String subject ,int marks, int marks2) 
//	{
//		// TODO Auto-generated method stub
//		return repository.findBySubjectAndMarksBetween(subject,marks,marks2);
//	}


	
	
	
	
	
	
}

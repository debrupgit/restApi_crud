package com.dsr.rest_crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsr.rest_crud.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>
{

	List<Student> findByName(String name);

	List<Student> findByMobile(Long mobile);

	List<Student> findByResult(String result);

	List<Student> findByEnglishGreaterThan(int i);

	List<Student> findByEnglishAndMathGreaterThan(int english, int math);

	List<Student> findByMathGreaterThanEqual(int marks);

	List<Student> findByEnglishGreaterThanEqual(int marks);

	List<Student> findByScienceGreaterThanEqual(int marks);

	List<Student> findByMathBetween(int marks, int marks2);

	List<Student> findByEnglishBetween(int marks, int marks2);

	List<Student> findByScienceBetween(int marks, int marks2);

}

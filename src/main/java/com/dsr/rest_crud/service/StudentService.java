package com.dsr.rest_crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.dsr.rest_crud.dao.StudentDao;
import com.dsr.rest_crud.dto.Student;
import com.dsr.rest_crud.exception.DataNotFoundException;
import com.dsr.rest_crud.helper.ResponseStructure;

@Component
public class StudentService 
{
	
	
	@Autowired
	StudentDao dao;

	@Autowired
	ResponseStructure structure;
	
	
	
	public ResponseStructure saveStudent(Student student) 
	{
		double percentage=(student.getEnglish()+student.getMath()+student.getScience())/3.0;
		student.setPercentage(percentage);
		
		if(student.getEnglish()<35 || student.getMath()>=35 || student.getScience()>=35)
		{
			student.setResult("fail");
		}
		
		else 
		{
			if(student.getPercentage()>=85)
			{
				student.setResult("distinction");
			}
			
			else if((student.getPercentage()>=60))
			{
				student.setResult("first class");
			}
			
			else if((student.getPercentage()>=35))
			{
				student.setResult("second division");
			}
			
			else 
			{
				student.setResult("fail");
			}
			
		}
		
		dao.saveStudent(student);
		structure.setMessage("record saved success");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(student);
		return structure;
	}



	public ResponseStructure findById(int id) 
	{
		Optional<Student> op=dao.findById(id);
		if(op.isEmpty())
		{
			throw new DataNotFoundException("data not found at id "+id);
		}
		
		else
		{
			structure.setData(op.get());
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());
		}
		return structure;
	}

	public ResponseStructure fetchAllRecord() 
	{
		List<Student>list=dao.fetchAllRecord();
		if(list.isEmpty())
		{
			throw new DataNotFoundException();
		}
		
		else
		{
			structure.setData(list);
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());
		}
		return structure;
	}



	public ResponseStructure saveMultiple(List<Student> students) 
	{
		for(Student student:students)
		{
			double percentage=(student.getEnglish()+student.getMath()+student.getScience())/3.0;
			student.setPercentage(percentage);
			
			if(student.getEnglish()<35 || student.getMath()>=35 || student.getScience()>=35)
			{
				student.setResult("fail");
			}
			
			else 
			{
				if(student.getPercentage()>=85)
				{
					student.setResult("distinction");
				}
				
				else if((student.getPercentage()>=60))
				{
					student.setResult("first class");
				}
				
				else if((student.getPercentage()>=35))
				{
					student.setResult("second division");
				}
				
				else 
				{
					student.setResult("fail");
				}
				
			}
		}
		
		dao.saveMultiple(students);
		structure.setData(students);
		structure.setMessage("all data saved at once");
		structure.setStatus(HttpStatus.CREATED.value());
		return structure;
		
	}
	
	public ResponseStructure findByName(String name)
	{
		List<Student> list=dao.findByName(name);
		if(list.isEmpty())
		{
			throw new DataNotFoundException("data not found with this "+name);
		}
		
		else
		{
			structure.setData(list);
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());
		}
		return structure;
	}



	public ResponseStructure findByMobile(Long mobile) 
	{
		List<Student> list=dao.findByMobile(mobile);
		
		if(list.isEmpty())
		{
			throw new DataNotFoundException("data not found with this "+mobile);
		}
		
		else
		{
			structure.setData(list);
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());
		}
		return structure;
	}



	public ResponseStructure findByResult(String result) 
	{
		List<Student> list=dao.findByResult(result);
		if(list.isEmpty())
		{
			throw new DataNotFoundException("data not found with this "+result);
		}
		
		else
		{
			structure.setData(list);
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());
		}
		return structure;
	}



	public ResponseStructure findByEnglishGreaterThanSixty(int english) 
	{
		List<Student> list=dao.findByEnglishGreaterThanSixty(english);
		
		if(list.isEmpty())
		{
			throw new DataNotFoundException();
		}
		
		else
		{
			structure.setData(list);
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());
		}
		return structure;
	}



	public ResponseStructure findByEnglishAndMathGreaterThan(int english, int math) 
	{
		
		List<Student>list=dao.findByEnglishAndMathGreaterThanSixty(english,math);
		if(list.isEmpty())
		{
			structure.setData(null);
			structure.setMessage("data nit found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		
		else
		{
			structure.setData(list);
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());
		}
		return structure;
	}



	public ResponseStructure findBySubjectMarksGreater(String subject, int marks)
	{
		List<Student>list=null;
		if(subject.equals("math"))
		{
			list=dao.findByMathGreater(marks);
		}
		
		else if(subject.equals("english"))
		{
			list=dao.findByEnglishGreater(marks);
		}
		
		else if(subject.equals("science"))
		{
			list=dao.findByScienceGreater(marks);
		}
		
		else
		{
			list=new ArrayList<Student>();
		}
		
		if(list.isEmpty())
		{
			structure.setData(null);
			structure.setMessage("data nit found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		
		else
		{
			structure.setData(list);
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());
		}
		
		return structure;
	}



	public ResponseStructure findByMarksBetween(String subject,int marks, int marks2) 
	{
		List<Student>list=null;
		if(subject.equals("math"))
		{
			list=dao.findByMathBetween(marks,marks2);
		}
		
		else if(subject.equals("english"))
		{
			list=dao.findByScienceBetween(marks,marks2);
		}
		
		else if(subject.equals("science"))
		{
			list=dao.findByEnglishBetween(marks,marks2);
		}
		
		else
		{
			list=new ArrayList<Student>();
		}
		
		if(list.isEmpty())
		{
			structure.setData(null);
			structure.setMessage("data nit found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		
		else
		{
			structure.setData(list);
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());
		}
		return structure;
	}



	

}
package com.usersPage.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usersPage.Entity.Student;
import com.usersPage.Repository.StudentRepository;

@Service
public class StudentServicesImpl  implements StudentServices{
	
	@Autowired
	StudentRepository sr;

	@Override
	public Student getStudentById(String userId) {
		return sr.findById(userId).orElse(null);
	}

	@Override
	public List<String> getEnrolledCoursesByUserId(String userId) {
		Student student=sr.findById(userId).orElse(null);
		
		return (student != null)? student.getEnrolledCourse():null;
	}

	@Override
	public List<String> getLikedCoursesByUserId(String userId) {
		Student student=sr.findById(userId).orElse(null);
		return (student != null) ? student.getLikedCourse() : null;
	}

	@Override
	public void addEnrolledCourse(String userId) {
		  Student student = sr.findById(userId).orElse(null);
	        if (student != null) {
//	            student.getEnrolledCourse().add(course);
	            sr.save(student);
	        }		
	}

	@Override
	public void addLikedCourse(String userId) {
		 Student student = sr.findById(userId).orElse(null);
	        if (student != null) {
//	            student.getLikedCourse().add(course);
	            sr.save(student);
	        }		
	}

	@Override
	public Student addStudent(Student student) {
		return sr.save(student);
	}

	@Override
	public Student upDateStudent(Student student) {
		
		return sr.save(student);
	}

	@Override
	public void deleteStudentById(String userId) {
		sr.delete(getStudentById(userId));
	}



}

package com.usersPage.Services;

import java.util.List;

import com.usersPage.Entity.Course;

public interface CourseService {
	
	public List<Course> getCourses();
	
	public Course getCourse(String courseId);
	
	public Course addCourse(Course course);
	
	public String deleteCourse(String courseId);

	public Course getCourseById(String courseId);

	public List<Course> getAllCourses();
	
	List<Course> getCoursesByTrainerId(String trainerId);
	
	String deleteCourseById(String courseId);
	
	public void deleteCourseWithUserId(String trainerId);
}

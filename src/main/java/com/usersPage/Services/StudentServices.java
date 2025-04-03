package com.usersPage.Services;

import java.util.List;

import com.usersPage.Entity.Student;

public interface StudentServices {
	
    Student getStudentById(String userId);

    List<String> getEnrolledCoursesByUserId(String userId);

    List<String> getLikedCoursesByUserId(String userId);

    void addEnrolledCourse(String userId);

    void addLikedCourse(String userId);
    
    Student addStudent(Student student);
    
    Student upDateStudent(Student student);
    
    public void deleteStudentById(String userId);

}

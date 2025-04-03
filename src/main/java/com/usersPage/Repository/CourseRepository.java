package com.usersPage.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.usersPage.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, String> {
	
	@Query("Select COUNT(c.courseId) from Course c")
	int getCourseCount();
	
	
	List<Course> findByTrainerId(String trainerId);
}

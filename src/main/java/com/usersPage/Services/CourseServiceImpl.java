package com.usersPage.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usersPage.Entity.Course;
import com.usersPage.Entity.Lessons;
import com.usersPage.Repository.CourseRepository;
import com.usersPage.Repository.LessonRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository cr;
	
	@Autowired
	private LessonServices ls;
	
	@Autowired
	private LessonRepository lr;
	
	 public List<Course> getAllCourses() {
        return cr.findAll();
    }
	 
    public Course getCourseById(String courseId) {
        return cr.findById(courseId).orElse(null);

    }
	

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		cr.save(course);
		return course;
	}

	@Override
	public String deleteCourse(String courseId) {
		String Message="Couser Deleted Successfully of "+courseId;
		cr.deleteById(courseId);
		return Message;
	}


	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course getCourse(String courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	  @Override
	    public List<Course> getCoursesByTrainerId(String trainerId) {
	        return cr.findByTrainerId(trainerId);
	    }

	@Override
	public String deleteCourseById(String courseId) {
		//get Course by course Id
		Course course =getCourseById(courseId);
        // Check if noOfLessons is greater than 0 before deleting lessons
		if(course.getNoOfLessons() > 0)
		{
            List<Lessons> lessons = ls.getLessons(courseId);
            
            for (Lessons lesson : lessons) {
                lr.deleteById(lesson.getLsnId());
            }
         
            
            
            
		}
		
		
		String message=deleteCourse(courseId);
		
		return message;
		
	}

	@Override
	public void deleteCourseWithUserId(String trainerId) {
		cr.deleteAll(getCoursesByTrainerId(trainerId));
		
	}

}

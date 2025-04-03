package com.usersPage.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usersPage.Entity.Course;
import com.usersPage.Entity.Lessons;
import com.usersPage.Repository.LessonRepository;
import com.usersPage.Services.CourseService;
import com.usersPage.Services.LessonServices;

@RestController
//@CrossOrigin("http://localhost:3000/")
@CrossOrigin(origins = {"http://localhost:3000/", "https://learn-guru.vercel.app/"})
public class LessonCntroller {
	
	@Autowired
	LessonRepository lr;
	
	@Autowired
	LessonServices ls;
	
	@Autowired
	CourseService cs;
	
	@GetMapping("/lhome")
	public String lhome()
	{
		return "Spring Project";
	}
	
//to add lesson by course Id
	@PostMapping("/lessons")
	public Lessons addLessonToCourse(@RequestBody Lessons lesson)
	{
		Course course=cs.getCourseById(lesson.getCourseId());
		
		//Set the lessonId for the lesson
		lesson.setLsnId(generateUniqueLessonId(lesson.getTrainerId(), lesson.getLsnTitle(),lesson.getCourseId()));
		
	    // Update the number of lessons in the course
		course.setNoOfLessons(lr.getCountByCourseId(lesson.getCourseId())+1);
		
	    // Save the updated course 
	    cs.addCourse(course);
	    
		return ls.addLessons(lesson);
	}
	
	//to get all lesson by the courseId
	@GetMapping("/lessons/{courseId}")
	public List<Lessons> getAllofCourse(@PathVariable String courseId)
	{
		List<Lessons> lessonList= lr.findAllByCourseId(courseId);
		return lessonList;
	}
	
	@GetMapping("/lesson/{lsnId}")
	public Lessons getLessonById(@PathVariable String lsnId)
	{
		Lessons lesson=ls.getLessonById(lsnId);
		return lesson;
	}
	
	// Update lesson by lsnId
    @PutMapping("/lesson/{lsnId}")
    public Lessons updateLessonById(@PathVariable String lsnId, @RequestBody Lessons updatedLesson) {
        // Check if the lesson with the given lsnId exists
        Lessons existingLesson = ls.getLessonById(lsnId);

        if (existingLesson != null) {
            // Update the existing lesson with the new data
            existingLesson.setLsnTitle(updatedLesson.getLsnTitle());
            existingLesson.setLsnSubTitle(updatedLesson.getLsnSubTitle());
            existingLesson.setLsnContent(updatedLesson.getLsnContent());
            existingLesson.setLsnContentUrl(updatedLesson.getLsnContentUrl());
            existingLesson.setLsnDescription(updatedLesson.getLsnDescription());
            
            // Save the updated lesson
            return ls.addLessons(existingLesson);
        } else {
            System.out.println("Lesson id is present");
            return null;
        }
    }

	
	
	//Method to create CourseId
	public String generateUniqueLessonId(String trainerId,String lessonTitle,String courseId) {
		
		String lt=lessonTitle.toUpperCase();
		int count=lr.getCountByCourseId(courseId)+1;
		return "LS"+trainerId.substring(trainerId.length()-5)+lt.substring(0,4)+count;
		
	}
}

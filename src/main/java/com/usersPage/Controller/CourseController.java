package com.usersPage.Controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import com.usersPage.Entity.Course;
import com.usersPage.Entity.Trainer;
import com.usersPage.Repository.CourseRepository;
import com.usersPage.Services.CourseService;
import com.usersPage.Services.StudentServices;
import com.usersPage.Services.TrainerServices;

@RestController
@CrossOrigin(origins = {"http://localhost:3000/", "https://learn-guru.vercel.app/"})
public class CourseController {

	@Autowired
	CourseService cs;
	
	@Autowired
	CourseRepository cr;
	
	@Autowired
	StudentServices ss;
	
	@Autowired
	TrainerServices ts;
	
	@GetMapping("/chome")
	public String chome()
	{
		return "Spring Project";
	}
	
	
	
	@PostMapping("/course")
	public ResponseEntity<Object> addCourse(@RequestParam("courseTitle") String courseTitle,
			@RequestParam("courseSubTitle") String courseSubTitle,
			@RequestParam("courseDescription") String courseDescription,
			@RequestParam("courseSkills") String courseSkills, @RequestParam("courseImage") MultipartFile courseImage,
			@RequestParam("trainerId") String trainerId) {
		try {
			byte[] imageData = courseImage.getBytes();
			Course c = new Course();
			String cId=generateUniqueCourseId(trainerId, courseTitle);
			c.setCourseId(cId);
			c.setCourseTitle(courseTitle);
			c.setCourseSubTitle(courseSubTitle);
			c.setCourseDescription(courseDescription);
			c.setCourseSkills(courseSkills);
			c.setTrainerId(trainerId);
			c.setCourseImage(imageData);
			c.setNoOfLessons(0);
			c.setCourseLikes(53);
			c.setCourseEnroll(53);
			c.setLikedId(new ArrayList<String>());
			c.setEnrolledId(new ArrayList<String>());
			c.setCourseRating(4.5);
			
			Trainer trainer=ts.getTrainerById(trainerId);
			Map<String, String> mp=trainer.getCourse();
			mp.put(cId, courseTitle);
			ts.upDateTrainer(trainer);
			cs.addCourse(c);

			return new ResponseEntity<>(cId, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return

			new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/course/{courseId}")
	public ResponseEntity<Object> getCourseWithCourseId(@PathVariable String courseId) {
	    Course course = cs.getCourseById(courseId);

	    // Convert image data to Base64 string
	    byte[] imageData = course.getCourseImage();
	    //String base64Image = Base64.getEncoder().encodeToString(imageData);

	    // Create response object with course information and Base64 image
	    Course response = new Course(course.getCourseId(), course.getCourseTitle(),
	            course.getCourseSubTitle(), course.getCourseDescription(), course.getCourseSkills(), course.getTrainerId(),
	            imageData, 0,course.getCourseLikes(),course.getCourseEnroll(),course.getLikedId(),course.getEnrolledId(),course.getCourseRating());
	    

	    return ResponseEntity.ok(response);
	}
	




	@GetMapping("/courses/{userId}")
	public ResponseEntity<Object> getAllCoursesByUserId(@PathVariable String userId) {
	    List<Course> courses = cs.getCoursesByTrainerId(userId);

	    // This method should return a list of courses associated with the given userId

	    // Create a list to store the response for each course
	    List<Course> responseCourses = new ArrayList<Course>();

	    
	    
	    
	    // Iterate through the courses and convert image data to Base64 string for each course
	    for (Course course : courses) {
	        byte[] imageData = course.getCourseImage();
	        Course response = new Course(course.getCourseId(), course.getCourseTitle(),
	                course.getCourseSubTitle(), course.getCourseDescription(), course.getCourseSkills(), course.getTrainerId(),
	                imageData,course.getNoOfLessons(),course.getCourseLikes(),course.getCourseEnroll(),course.getLikedId(),course.getEnrolledId(),course.getCourseRating());
	        responseCourses.add(response);
	    }

	    return ResponseEntity.ok(responseCourses);
	}

	@GetMapping("/courses")
	public ResponseEntity<Object> getAllCourses() {
	    List<Course> courses = cs.getAllCourses();

	    // This method should return a list of courses associated with the given userId

	    // Create a list to store the response for each course
	    List<Course> responseCourses = new ArrayList<Course>();

	    // Iterate through the courses and convert image data to Base64 string for each course
	    for (Course course : courses) {
	        byte[] imageData = course.getCourseImage();
	        Course response = new Course(course.getCourseId(), course.getCourseTitle(),
	                course.getCourseSubTitle(), course.getCourseDescription(), course.getCourseSkills(), course.getTrainerId(),
	                imageData,course.getNoOfLessons(),course.getCourseLikes(),course.getCourseEnroll(),course.getLikedId(),course.getEnrolledId(),course.getCourseRating());
	        responseCourses.add(response);
	    }

	    return ResponseEntity.ok(responseCourses);
	}

	 


	    
	    
	    @DeleteMapping("/course/{courseId}")
	    public ResponseEntity<Object> deleteCourseWithLessons(@PathVariable String courseId) {
	        String message = cs.deleteCourseById(courseId);
	        return new ResponseEntity<>(message, HttpStatus.OK);
	    }
	    
	    
	    @DeleteMapping("/deleteCourse/{trainerId}")
	    public void deleteCourseByTrainerId(@PathVariable String trainerId){
	    	cs.deleteCourseWithUserId(trainerId);
	    	
	    }
	    
	    
	    @PutMapping("/course/{courseId}")
	    public ResponseEntity<Object> updateCourse(@PathVariable String courseId,
	            @RequestParam("courseTitle") String courseTitle,
	            @RequestParam("courseSubTitle") String courseSubTitle,
	            @RequestParam("courseDescription") String courseDescription,
	            @RequestParam("courseSkills") String courseSkills,
	            @RequestParam("courseImage") MultipartFile courseImage,
	            @RequestParam("trainerId") String trainerId) {

	        try {
	            // Retrieve the existing course
	            Course existingCourse = cs.getCourseById(courseId);

	            // Check if the course exists
	            if (existingCourse == null) {
	                return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
	            }

	            // Update the course details
	            existingCourse.setCourseTitle(courseTitle);
	            existingCourse.setCourseSubTitle(courseSubTitle);
	            existingCourse.setCourseDescription(courseDescription);
	            existingCourse.setCourseSkills(courseSkills);
	            existingCourse.setTrainerId(trainerId);

	            // Check if a new image is provided
	            if (courseImage != null) {
	                byte[] imageData = courseImage.getBytes();
	                existingCourse.setCourseImage(imageData);
	            }

	            // Save the updated course
	            cs.addCourse(existingCourse);

	            return new ResponseEntity<>("Course updated successfully", HttpStatus.OK);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    
	    @GetMapping("/enrollCourses/{userId}")
	    public ResponseEntity<Object> getEnrolledCourses(@PathVariable String userId) {

	        // Get the list of enrolled course IDs for the given userId
	        List<String> enrolledCourseIds = ss.getEnrolledCoursesByUserId(userId);
	        System.out.println(enrolledCourseIds);
	        // Create a list to store the response for each enrolled course
	        List<Course> responseCourses = new ArrayList<>();

	        // Iterate through the enrolled course IDs and fetch details for each course
	        for (String courseId : enrolledCourseIds) {
	        	System.out.println(courseId);
	        	
	            Course course = cs.getCourseById(courseId);
	            
	            // Check if the course exists before adding it to the response
	            if (course != null) {
	                // Convert image data to Base64 string if needed
	                byte[] imageData = course.getCourseImage(); // assuming this is a byte array


	                // Create a response course object with converted image data
	                Course response = new Course(course.getCourseId(), course.getCourseTitle(),
		                course.getCourseSubTitle(), course.getCourseDescription(), course.getCourseSkills(), course.getTrainerId(),
			                imageData,course.getNoOfLessons(),course.getCourseLikes(),course.getCourseEnroll(),course.getLikedId(),course.getEnrolledId(),course.getCourseRating()); // assuming course image is a string

	                responseCourses.add(response);
	            }
	        }

	        return ResponseEntity.ok(responseCourses);
	    }

	    
	    


	    
	    
	    
	    
	    
// the method to generate unique CourseId	    
	    public String generateUniqueCourseId(String trainerId, String courseTitle) {
	        String ct = courseTitle.toUpperCase();
	        int courseCount = 0;
	        int count = cr.getCourseCount();

	        if (count == 0) {
	            courseCount = 1;
	        } else {
	            courseCount = count + 1;
	        }

	        // Ensure that ct has at least 4 characters before extracting a substring
	        if (ct.length() < 4) {
	            // Handle the case where the courseTitle is too short (e.g., throw an exception or handle it in a way suitable for your application)
	            throw new IllegalArgumentException("Course title must have at least 4 characters");
	        }

	        return "CU" + trainerId.substring(trainerId.length() - 5) + ct.substring(0, 4) + courseCount;
	    }

	
}

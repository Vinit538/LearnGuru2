package com.usersPage.Controller;

import com.usersPage.Entity.Course;
import com.usersPage.Entity.Student;
import com.usersPage.Entity.Users;
import com.usersPage.Services.CourseService;
import com.usersPage.Services.StudentServices;
import com.usersPage.Services.UserServies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000/", "https://web-learn-guru.vercel.app/"})
//@CrossOrigin("https://web-learn-guru.vercel.app/")
public class StudentController {

    @Autowired
    private StudentServices studentService;
    
    @Autowired
    private CourseService cs;
    
    @Autowired
    private UserServies us;
    
    
    
    @PostMapping("/student/{userId}")
    public Student addNewStudent(@PathVariable String userId) {
        Student stu = new Student();
        Users user = us.getUser(userId);
        stu.setUserId(userId);
        stu.setStudentName(user.getUserName());
        stu.setStudentEmail(user.getUserEmail());
        stu.setStudentPhone(user.getUserPhone());
        
        // set Gender  
    	   stu.setStudentGender(" ");
       
       //set Dob
    	   stu.setStudentDob(" ");
       
       //set Address
    	   stu.setStudentAddress(" ");

       
       //set Education
    	   stu.setStudentEducation(" ");
       
       //set Branch 
    	   stu.setStudentBranch(" ");
    	   
    	   // Check if likedCourse is null or empty
               stu.setLikedCourse(new ArrayList<>());
               stu.setEnrolledCourse(new ArrayList<>());

        return studentService.addStudent(stu);
    }

    
    
    @PutMapping("/updateStudent/{userId}")
    public Student UpdateStudent(@PathVariable String userId,@RequestBody Student s) {
    	
    	
        Student stu = studentService.getStudentById(userId); 
        // set Gender  
       if(s.getStudentGender().equals(null))
       {
    	   stu.setStudentGender(" ");
       }
       else {
    	   stu.setStudentGender(s.getStudentGender());
       }
       
       //set Dob
       if(s.getStudentDob().equals(null))
       {
    	   stu.setStudentDob("no Data ");
       }
       else {
    	   stu.setStudentDob(s.getStudentDob());
       }
       
       //set Address
       if(s.getStudentAddress().equals(null))
       {
    	   stu.setStudentAddress("no Data");
       }
       else {
    	   stu.setStudentAddress(s.getStudentAddress());
       }

       
       //set Education
       if(s.getStudentEducation().equals(null))
       {
    	   stu.setStudentEducation("no Data");
       }
       else
       {
    	   stu.setStudentEducation(s.getStudentEducation());
       }
       //set Branch
       
       if(s.getStudentBranch().equals(null))
       {
    	   stu.setStudentBranch("no Data");
       }
       else
       {
    	   stu.setStudentBranch(s.getStudentBranch());
       }
      
        return studentService.addStudent(stu);
    }
    
    @GetMapping("studentProfile/{userId}")
    public Student getStudentById(@PathVariable String userId) {
        return studentService.getStudentById(userId);
    }

    @GetMapping("/{userId}/enrolled-courses")
    public List<String> getEnrolledCoursesByUserId(@PathVariable String userId) {
        return studentService.getEnrolledCoursesByUserId(userId);
    }

    @GetMapping("/{userId}/liked-courses")
    public List<String> getLikedCoursesByUserId(@PathVariable String userId) {
        return studentService.getLikedCoursesByUserId(userId);
    }

    @PostMapping("/likedCourse/{userId}/{likedCourse}")
    public boolean addLikedCourse(@PathVariable String userId, @PathVariable String likedCourse) {
       
    	Course course=cs.getCourseById(likedCourse);
    	Student s=studentService.getStudentById(userId);
    	
    	List<String> listLiked=studentService.getLikedCoursesByUserId(userId);
    	
    	listLiked.add(likedCourse);
    	
    	s.setLikedCourse(listLiked);
    	course.setCourseLikes(course.getCourseLikes()+1);
    	List<String> LikesList=course.getLikedId();
    	LikesList.add(userId);
    	course.setLikedId(LikesList);
    	cs.addCourse(course);
    	System.out.println(s);
    	studentService.upDateStudent(s);
    	return true;
    }
   
    @PostMapping("/enrollCourse/{userId}/{EnrolledCourse}")
    public Student addEnrollCourse(@PathVariable String userId, @PathVariable String EnrolledCourse) {
       
    	Course course=cs.getCourseById(EnrolledCourse);

    	Student s=studentService.getStudentById(userId);
    	
    	List<String> listEnroll=studentService.getEnrolledCoursesByUserId(userId);
    	
    	listEnroll.add(EnrolledCourse);
    	
    	s.setEnrolledCourse(listEnroll);
    	course.setCourseEnroll(course.getCourseEnroll()+1);
    	List<String> EnrollList = course.getEnrolledId();
    	EnrollList.add(userId);
    	course.setEnrolledId(EnrollList);
    	cs.addCourse(course);
    	return studentService.upDateStudent(s);
    }
    @PutMapping("/likedCourse/{userId}/{likedCourse}")
    public Student upDateLikedCourse(@PathVariable String userId, @PathVariable String likedCourse) {
       
    	Course course=cs.getCourseById(likedCourse);
    	Student s=studentService.getStudentById(userId);
    	
    	List<String> listLiked=studentService.getLikedCoursesByUserId(userId);
    	
    	listLiked.remove(likedCourse);
    	
    	s.setLikedCourse(listLiked);
    	course.setCourseLikes(course.getCourseLikes()-1);
    	List<String> LikesList=course.getLikedId();
    	LikesList.remove(userId);
    	course.setLikedId(LikesList);
    	cs.addCourse(course);
    	System.out.println(s);
    	return studentService.upDateStudent(s);
    }
   
    @PutMapping("/enrollCourse/{userId}/{EnrolledCourse}")
    public Student upDateEnrollCourse(@PathVariable String userId, @PathVariable String EnrolledCourse) {
       
    	Course course=cs.getCourseById(EnrolledCourse);

    	Student s=studentService.getStudentById(userId);
    	
    	List<String> listEnroll=studentService.getEnrolledCoursesByUserId(userId);
    	
    	listEnroll.remove(EnrolledCourse);
    	
    	s.setEnrolledCourse(listEnroll);
    	course.setCourseEnroll(course.getCourseEnroll()-1);
    	List<String> EnrollList = course.getEnrolledId();
    	EnrollList.remove(userId);
    	course.setEnrolledId(EnrollList);
    	cs.addCourse(course);
    	return studentService.upDateStudent(s);
    }
    
    @DeleteMapping("/DeleteStudent/{userId}")
    public void deleteStudentById(@PathVariable String userId){
    	studentService.deleteStudentById(userId);
    }
    
    
    @GetMapping("/TestEnroll/{userId}")
    public List<String> getEnrolledCourse(@PathVariable String usedId)
    {
    	return studentService.getEnrolledCoursesByUserId(usedId);
    }
    
}

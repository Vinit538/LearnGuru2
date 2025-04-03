package com.usersPage.Controller;

import java.time.Year;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usersPage.Entity.Users;
import com.usersPage.Repository.UsersRepository;
import com.usersPage.Services.UserServies;

@RestController
//@CrossOrigin("http://localhost:3000/")
@CrossOrigin(origins = {"http://localhost:3000/", "https://web-learn-guru.vercel.app/"})
public class UserController {
	@Autowired
	UserServies us;
	
	@Autowired
	UsersRepository ur;
	
	@Autowired
	TrainerController tc;
	
	@Autowired
	CourseController cc;
	
	@Autowired
	StudentController sc;
	
	@GetMapping("/home")
	public String home()
	{
		return "Spring Project";
	}
	
	@PostMapping("/users")
	public Users addUsers(@RequestBody Users newUser) {
	    Users user = new Users();
	    String userId=getUsId(newUser.getUserName(),newUser.getUserRole());
	    user.setUserId(userId);
	    user.setUserName(newUser.getUserName());
	    user.setUserEmail(newUser.getUserEmail());
	    user.setUserPhone(newUser.getUserPhone());
	    user.setUserPassword(newUser.getUserPassword());
	    user.setUserRole(newUser.getUserRole());

	    
	    us.addUser(user);
	    
	    if(newUser.getUserRole().equals("Trainer")) {
	    	tc.addNewTrainer(userId);
	    }
	    else {
	    	sc.addNewStudent(userId);
	    }
	    
	    // Now that userId is assigned, you can save the entity
	    return user;
	}

	@GetMapping("/users/{userId}")
	public Users getUsers(@PathVariable String userId)
	{
		Users user=us.getUser(userId);
		return user;
		
	}
	
	@GetMapping("/users")
	public ResponseEntity<Object> loginUser(@RequestParam("userEmail") String userEmail,
	                                       @RequestParam("userPassword") String userPassword) {
	    if (ur.existsByuserEmail(userEmail)) {
	        Users user = us.getUserByEmail(userEmail);
	        if (user.getUserPassword().equals(userPassword)) {
	            // Passwords match
	            return ResponseEntity.ok(user);
	        } else {
	            // Passwords don't match
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Password does not match.");
	        }
	    } else {
	        // User not found
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
	    }
	}

	@PutMapping("/deleteAccount/{userId}")
	public String deleteUserById(@PathVariable String userId)
	{
		try {
				Users user=us.getUser(userId);
				if(user.getUserRole().equals("Trainer")) {
					tc.deleteTrainerById(userId);
					cc.deleteCourseByTrainerId(userId);
				}
				else
				{
					sc.deleteStudentById(userId);
				}
				us.deleteUser(userId);
				return "Account Deleted Successfully";
		}
		catch (Exception e) {
			
			return "Your Account Not Deleted";
		}
	}

	  public String getUsId(String name, String role) {
 
		String userName=name.toUpperCase();
		long userCount=000;
	    long count = role.equals("Trainer") ? ur.getTrCountUsers() : ur.getStCountUsers();
	    if (count == 0) {
	      userCount =userCount+count+ 1;
	    } else {
	      userCount=userCount+count+1;
	    }
	    
	    String prefix = role.equals("Trainer") ? "TR" : "ST";
	    return prefix + Year.now() + userName.substring(0, 4)+ count;
	  }
	
}

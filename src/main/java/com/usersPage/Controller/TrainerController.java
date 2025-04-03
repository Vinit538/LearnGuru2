package com.usersPage.Controller;

import java.util.HashMap;

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
import org.springframework.web.bind.annotation.RestController;

import com.usersPage.Entity.Trainer;
import com.usersPage.Entity.Users;
import com.usersPage.Services.TrainerServices;
import com.usersPage.Services.UserServies;

@RestController
@CrossOrigin(origins = {"http://localhost:3000/", "https://learn-guru.vercel.app/"})
public class TrainerController {

	@Autowired
	TrainerServices ts;
	
	@Autowired
	UserServies us;
	
	
	@PostMapping("/trainer/{trainerId}")
	 public ResponseEntity<Object> addNewTrainer(@PathVariable String trainerId){
	        try {
	        		Users user = us.getUser(trainerId);
	        		
	        		Trainer trainer=new Trainer();
	        		trainer.setTrainerId(user.getUserId());
	        		trainer.setTrainerName(user.getUserName());
	        		trainer.setTrainerEmail(user.getUserEmail());
	        		trainer.setTrainerPhone(user.getUserPhone());
	        			trainer.setCourse(new HashMap<>());
	        			trainer.setTrainerGender(" ");
	        			trainer.setTrainerDob(" ");
	        			trainer.setTrainerAddress(" ");
	        			trainer.setTrainerEducation(" ");        			
	        			trainer.setTrainerBranch(" ");
	        		
	        		
	        		ts.addTrainer(trainer);
	            return new ResponseEntity<>("User Data Update successfully", HttpStatus.OK);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	}
	
	     @PutMapping("/upDateTrainer/{trainerId}")
	   	 public ResponseEntity<Object> addTrainer(@PathVariable String trainerId,@RequestBody Trainer t){
	   	        try {
	   	        		
	   	        		Trainer trainer=ts.getTrainerById(trainerId);
	   	       
	   	        		if(t.getTrainerGender().equals(null)) {
	   	        			trainer.setTrainerGender(" ");
	   	        		}
	   	        		else {
	   	        			trainer.setTrainerGender(t.getTrainerGender());
	   	        		}
	   	        		
	   	        		if(t.getTrainerDob().equals(null)) {
	   	        			trainer.setTrainerDob(" ");
	   	        		}
	   	        		else {
	   	        			trainer.setTrainerDob(t.getTrainerDob());
	   	        		}
	   	        		
	   	        		if(t.getTrainerAddress().equals(null))
	   	        		{
	   	        			trainer.setTrainerAddress(" ");
	   	        		}
	   	        		else {
	   	        			trainer.setTrainerAddress(t.getTrainerAddress());
	   	        		}
	   	        		if(t.getTrainerEducation().equals(null)) {
	   	        			trainer.setTrainerEducation(" ");        			
	   	        		}
	   	        		else {
	   	        			trainer.setTrainerEducation(t.getTrainerEducation());
	   	        		}
	   	        		if(t.getTrainerBranch().equals(null)) {
	   	        			trainer.setTrainerBranch(" ");
	   	        		}
	   	        		else {
	   	        			trainer.setTrainerBranch(t.getTrainerBranch());
	   	        		}
	   	        		
	   	        		ts.upDateTrainer(trainer);
	   	            return new ResponseEntity<>("User Data Update successfully", HttpStatus.OK);
	   	        } catch (Exception e) {
	   	            e.printStackTrace();
	   	            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
	   	        }
	     }
	     
	     
	     @DeleteMapping("/deleteTrainer")
	     public void deleteTrainerById(@PathVariable String trainerId)
	     {
	    	 ts.deleteUser(trainerId);
	     }
	     
	    @GetMapping("/getTrainer/{trainerId}")
	    public Trainer getTrainer(@PathVariable String trainerId) {
	    	return ts.getTrainerById(trainerId);
	    }    
}

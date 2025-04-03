package com.usersPage.Services;

import java.util.Map;

import com.usersPage.Entity.Trainer;

public interface TrainerServices {
	
	Trainer getTrainerById(String trainerId);
	
	Map<String, String> getCourseOfTrainer(String trainerId);
	
	Trainer addTrainer(Trainer trainer);
	
	Trainer upDateTrainer(Trainer trainer);
	
	public void deleteUser(String trainerId);

}

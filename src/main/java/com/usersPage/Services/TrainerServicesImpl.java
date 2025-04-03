package com.usersPage.Services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usersPage.Entity.Trainer;
import com.usersPage.Repository.TrainerRepository;

@Service
public class TrainerServicesImpl implements TrainerServices{
	
	@Autowired
	TrainerRepository tr;

	@Override
	public Trainer getTrainerById(String trainerId) {
		return tr.findById(trainerId).orElse(null);
	}

	@Override
	public Map<String, String> getCourseOfTrainer(String trainerId) {
		   Trainer trainer = tr.findById(trainerId).orElse(null);
	        return trainer != null ? trainer.getCourse() : null;	
	 }

	@Override
	public Trainer addTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		return tr.save(trainer);
	}

	@Override
	public Trainer upDateTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		return tr.save(trainer);
	}

	@Override
	public void deleteUser(String trainerId) {
		tr.delete(getTrainerById(trainerId));
	}

}

package com.usersPage.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usersPage.Entity.Lessons;
import com.usersPage.Repository.LessonRepository;

@Service
public class LessonServicesImpl implements LessonServices{

	@Autowired
	LessonRepository lr;
	
	@Override
	public List<Lessons> getLessons(String courseId) {
		
		return lr.findAll();
	}

	@Override
	public Lessons getLessonById(String lsnId) {
		return lr.getLessonByLsnId(lsnId);
	}

	@Override
	public Lessons addLessons(Lessons lsn) {
		// TODO Auto-generated method stub
		return lr.save(lsn);
	}

	@Override
	public String deleteLessons(String lnsId) {
		return null;
	}

	
	
	
}

package com.usersPage.Services;

import java.util.List;

import com.usersPage.Entity.Lessons;

public interface LessonServices {
	
	public List<Lessons> getLessons(String courseId);
	
	public Lessons getLessonById(String lsnId);
	
	public Lessons addLessons(Lessons lsn);
	
	public String deleteLessons(String lnsId);

}

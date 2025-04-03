package com.usersPage.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.usersPage.Entity.Lessons;

public interface LessonRepository extends JpaRepository<Lessons, String> {
	
    
    @Query("SELECT COUNT(l.courseId) FROM Lessons l WHERE l.courseId = :courseId")
    int getCountByCourseId(@Param("courseId") String courseId);

    List<Lessons> findAllByCourseId(String courseId);
    
    @Query("SELECT l FROM Lessons l WHERE l.lsnId=:lsnId")
    Lessons getLessonByLsnId(@Param("lsnId") String lsnId);
}

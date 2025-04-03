package com.usersPage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.usersPage.Entity.Users;

public interface UsersRepository  extends JpaRepository<Users, String>{
	
	
	@Query("Select COUNT(u.userId) from Users u where u.userRole='Trainer'")
	int getTrCountUsers();
	@Query("Select COUNT(u.userId) from Users u where u.userRole='Student'")
	int getStCountUsers();
	
	boolean existsByuserEmail(String userEmail);
	
	Users findByUserEmail(String userEmail);
}

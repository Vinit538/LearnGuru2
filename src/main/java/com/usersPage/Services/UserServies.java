package com.usersPage.Services;

import java.util.List;

import com.usersPage.Entity.Users;

public interface UserServies {
	
	public List<Users> getUsers();
	
	public Users getUser(String userId);
	
	public Users addUser(Users user);
	
	public Users updateUser(Users user);

	public void deleteUser(String userId);
	
	public boolean findByuserEmial(String userEmail);
	
	public Users getUserByEmail(String userEmail);
}

package com.usersPage.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usersPage.Entity.Users;
import com.usersPage.Repository.UsersRepository;

@Service
public class UserServicesImpl implements UserServies {

	@Autowired
	private UsersRepository ur;
	
	@Override
	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}

	@Override
	public Users getUser(String userId) {
		
		Optional<Users> user=ur.findById(userId);
		return user.orElse(null);
	}
    


	@Override
	public Users addUser(Users user) {
		ur.save(user);
		return user;
	}

	@Override
	public Users updateUser(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String userId) {
		Optional<Users> user=ur.findById(userId);	
		ur.delete(user.get());
		
	}

	@Override
	public boolean findByuserEmial(String userEmail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Users getUserByEmail(String userEmail) {
		
		return ur.findByUserEmail(userEmail);
	}

}

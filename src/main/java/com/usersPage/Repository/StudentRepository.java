package com.usersPage.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usersPage.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, String>{

	

}

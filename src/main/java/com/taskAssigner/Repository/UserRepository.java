package com.taskAssigner.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taskAssigner.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

//	@Query("SELECT t FROM User t WHERE t.name = :name AND t.password = :password")
//	User findByNameAndPassword(String name, String password);
//	User findById(1);

	User findByEmail(String email);
	

}

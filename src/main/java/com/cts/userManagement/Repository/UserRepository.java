package com.cts.userManagement.Repository;

import javax.transaction.Transactional;

import com.cts.userManagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer>
{
	
	@Query(value="select u from User u where u.username= :username and u.password= :password")
	public User validateUser(String username, String password);//login
	User findByUsername(String username);

}

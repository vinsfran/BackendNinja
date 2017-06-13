package com.udemy.repository;

import com.udemy.entity.User;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable>{
    
    public abstract User findByUserName(String username);
    
}
package com.example.Supermart.repo;

import com.example.Supermart.model.Supermart;
import com.example.Supermart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

}
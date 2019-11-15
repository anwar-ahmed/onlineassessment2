package com.myapp.onlineassessmentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.onlineassessmentsystem.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}

package com.curd.dao;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curd.entity.User;

public interface Repo extends JpaRepository<User,Integer> {

     public User findByUserName(String userName);

     

    
}
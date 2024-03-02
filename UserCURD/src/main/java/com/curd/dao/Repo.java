package com.curd.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curd.entity.User;

public interface Repo extends JpaRepository<User,Integer> {

    
}
package com.curd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curd.dao.Repo;
import com.curd.entity.User;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private Repo repo;

    @Override
    public List<User> getUser() {
        // TODO Auto-generated method stub
        return repo.findAll();
       
    }

    @Override
	public void save(User user) {

		repo.save(user);
	}

    @Override
    public User findById(Integer id) {
        // TODO Auto-generated method stub

        return repo.findById(id).get();
      
    }

    @Override
    public void delete(User user) {
        // TODO Auto-generated method stub
         repo.delete(user);
    }

    @Override
    public User findbyUserName(String userName) {
        // TODO Auto-generated method stub
        return repo.findByUserName(userName);
        
    }


    
}

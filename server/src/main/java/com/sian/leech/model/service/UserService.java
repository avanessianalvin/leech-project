package com.sian.leech.model.service;

import com.sian.leech.model.entity.User;
import com.sian.leech.model.repository.UserDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserDA userDA;
    public void save(User user){
        userDA.save(user);
    }

    public void remove(User user){
        userDA.delete(user);
    }

    public User get (long id){
        return userDA.findById(id).orElse(null);
    }

    public List<User> findAll(){
        return userDA.findAll();
    }

    public Optional<User> findByUsername(String username){
        return userDA.findByUsername(username);
    }
}

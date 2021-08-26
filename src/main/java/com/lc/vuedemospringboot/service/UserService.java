package com.lc.vuedemospringboot.service;

import com.lc.vuedemospringboot.dao.UserDao;
import com.lc.vuedemospringboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }

    public User getByUsernameAndPassword(String username,String password){
        return userDao.getByUsernameAndPassword(username,password);
    }

}

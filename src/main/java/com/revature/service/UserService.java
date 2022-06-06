package com.revature.service;

import com.revature.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> userList = new ArrayList<>();

    public List<User> getAllUsers() {
        return userList;
    }

    public void addUser(User user){
        userList.add(user);
    }

    public User getById(int id){
        for(User user : userList){
            if(user.getId() == id)
                return user;
        }
        return null;
    }
}

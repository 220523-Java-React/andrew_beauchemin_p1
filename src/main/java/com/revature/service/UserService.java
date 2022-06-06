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
        userList.get(userList.size()-1).setId(getUniqueId());
    }

    public User getById(int id){
        for(User user : userList){
            if(user.getId() == id)
                return user;
        }
        return null;
    }

    // unique ID is just increment of last ID
    private int getUniqueId(){
        return userList.size();
    }
}

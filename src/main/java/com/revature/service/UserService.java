package com.revature.service;

import com.revature.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    public void addUser(User user){
        userList.add(user);
    }


}

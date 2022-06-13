package com.revature.service;

import com.revature.model.User;
import com.revature.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private UserRepository userRepository;

    public UserService(){userRepository = new UserRepository();}

    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    public User createUser(User user){

       return userRepository.create(user);
    }


    public User getUserById(int id){
        return userRepository.getById(id);
    }

    public User updateUserById(User user){
        return userRepository.update(user);
    }

    public boolean deleteUserById(int id){
        return userRepository.deleteById(id);
    }

}

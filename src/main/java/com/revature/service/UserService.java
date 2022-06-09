package com.revature.service;

import com.revature.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> userList = new ArrayList<>();

    public List<User> getAllUsers() {
        return userList;
    }

    public boolean createUser(User user){
        userList.add(user);
        userList.get(userList.size()-1).setId(getUniqueId());

        //TODO: add cases in which this would be false, eg trying to add a duplicate user or same id
        return true;
    }

    public boolean removeUserById(User user){
        for(User selectedUserL: userList){
            if(user.getId() == selectedUserL.getId()){
                userList.remove(selectedUserL);
                return true;
            }
        }

        return false;
    }

    public boolean updateUserById(User user){
        for(User selectedUser: userList){
            if(user.getId() == selectedUser.getId()){
                selectedUser = user;
                return true;
            }
        }

        return false;
    }

    public boolean deleteUserById(User user){
        for(User selectedUser: userList){
            if(user.getId() == selectedUser.getId()){
                userList.remove(selectedUser);
                return true;
            }
        }

        return false;
    }

    public User getById(int id){
        for(User user : userList){
            if(user.getId() == id)
                return user;
        }
        return null;
    }

    // unique ID is just increment of last ID; probably change later
    private int getUniqueId(){
        return userList.size();
    }
}

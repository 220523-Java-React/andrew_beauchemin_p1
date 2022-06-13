package com.revature.repository;

import com.revature.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements DAO<User> {
    private List<User> userList;

    public UserRepository(){userList = new ArrayList<>();}

    public UserRepository(List<User> user){
        this.userList = user;
    }

    @Override
    public User create(User user) {
        if(userList.add(user)){
            return user;
        }else{
            return null;
        }
    }

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public User getById(int id) {
        for(User user : userList){
            if(user.getId() == id)
                return user;
        }
        return null;
    }

    @Override
    public User update(User user) {
        for(User selectedUser: userList){
            if(user.getId() == selectedUser.getId()){
                selectedUser = user;
                return user;
            }
        }

        return null;
    }

    @Override
    public boolean deleteById(int id) {
        for(User selectedUserL: userList){
            if(id == selectedUserL.getId()){
                userList.remove(selectedUserL);
                return true;
            }
        }
        return false;
    }
}

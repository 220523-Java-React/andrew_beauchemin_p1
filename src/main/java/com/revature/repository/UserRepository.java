package com.revature.repository;

import com.revature.model.User;

import java.util.List;

public class UserRepository implements DAO<User> {

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}

package com.revature.controller;

import com.revature.model.User;
import com.revature.service.UserService;
import io.javalin.http.Handler;

import java.util.List;

public class UserController {
    UserService userService = new UserService();

    public Handler getAllUsers = ctx -> {
        List<User> users = userService.getAllUsers();
    };

    public Handler getUserById = ctx -> {
        String param = ctx.pathParam("id");
        int id = Integer.parseInt(param);

        ctx.json(userService.getById(id));
    };

    public Handler setUser = ctx -> {
        User user = ctx.bodyAsClass(User.class);
        userService.addUser(user);
    };

}

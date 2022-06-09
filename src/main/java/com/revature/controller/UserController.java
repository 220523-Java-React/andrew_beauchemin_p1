package com.revature.controller;

import com.revature.model.User;
import com.revature.service.UserService;
import io.javalin.http.Handler;

import java.util.List;

public class UserController {
    UserService userService = new UserService();

    public Handler getAllUsers = ctx -> {
        List<User> users = userService.getAllUsers();
        ctx.json(users);
    };

    public Handler getUserById = ctx -> {
        String param = ctx.pathParam("userid");
        int id = Integer.parseInt(param);

        User user = userService.getById(id);
        if(user != null) {
            ctx.json(user);
        }else {
            ctx.status(400).json(parseError("User not found"));
        }
    };

    public Handler setUser = ctx -> {
        User user = ctx.bodyAsClass(User.class);
        if(!userService.createUser(user)){
            ctx.status(400).json(parseError("Invalid creation"));
        }
    };

    public Handler updateUserById = ctx -> {
        User user = ctx.bodyAsClass(User.class);
        if(!userService.updateUserById(user)){
            ctx.status(400).json(parseError("User not found"));
        }
    };

    public Handler deleteUserById = ctx -> {
        User user = ctx .bodyAsClass(User.class);
        if(!userService.deleteUserById(user)){
            ctx.status(400).json(parseError("User not found"));
        }
    };

    public Handler test = ctx -> {
        System.out.println("Test");
    };

    private String parseError(String message){
        return "{\"success\":false, \"message\":\"" + message + "\"}";
    }
}

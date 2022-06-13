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

        User user = userService.getUserById(id);
        if(user != null) {
            ctx.status(200).json(user);
        }else {
            ctx.status(400).json(parseError("User not found"));
        }
    };

    public Handler setUser = ctx -> {
        User user = ctx.bodyAsClass(User.class);
        User userSet = userService.createUser(user);
        if(userSet == null){
            ctx.status(400).json(parseError("Invalid creation"));
        }else{
            ctx.status(201).json(userSet);
        }
    };

    public Handler updateUserById = ctx -> {
        User user = ctx.bodyAsClass(User.class);
        User userUpdate = userService.updateUserById(user);
        if(userUpdate == null){
            ctx.status(400).json(parseError("User not found"));
        }else{
            ctx.status(201).json(userUpdate);
        }
    };

    public Handler deleteUserById = ctx -> {
        User user = ctx .bodyAsClass(User.class);
        if(!userService.deleteUserById(user.getId())){
            ctx.status(400).json(parseError("User not found"));
        }else{
            ctx.status(200);
        }
    };

    public Handler test = ctx -> {
        System.out.println("Test");
    };

    private String parseError(String message){
        return "{\"success\":false, \"message\":\"" + message + "\"}";
    }
}

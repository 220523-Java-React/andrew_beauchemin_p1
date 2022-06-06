package com.revature;

import com.revature.controller.UserController;
import com.revature.model.User;
import io.javalin.Javalin;

public class Driver {
    public static void main(String[] args) {
        UserController userController = new UserController();
        Javalin app = Javalin.create().start(8080);
        app.get("/", ctx -> ctx.result("Homepage")/* TODO: Add options that user can take*/);

        app.get("/users", userController.getAllUsers);
        app.post("/users", userController.setUser);
        app.get("/users/{id}", userController.getUserById);
        //app.get("users/{id}/", userController.)



    }
}

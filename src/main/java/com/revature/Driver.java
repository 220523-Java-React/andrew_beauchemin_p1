package com.revature;

import com.revature.model.User;
import io.javalin.Javalin;

public class Driver {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8080);



        User u = new User(User.Role.CUSTOMER, "TestUser");
        System.out.println("test");

    }
}

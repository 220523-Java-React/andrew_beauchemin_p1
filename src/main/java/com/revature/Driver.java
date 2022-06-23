package com.revature;

import com.revature.controller.CarController;
import com.revature.controller.UserController;
import com.revature.model.User;
import io.javalin.Javalin;

public class Driver {
    public static void main(String[] args) {
        UserController userController = new UserController();
        CarController carController = new CarController();

        Javalin app = Javalin.create().start(8080);
        app.get("/", ctx -> ctx.status(100).result("Homepage\n/users\n/offers\n/cars")/* TODO: Add options that user can take*/);


        app.get("/users", userController.getAllUsers);

        // CRUD Operations for Users
        app.post("/users", userController.setUser);
        app.get("/users/{userid}", userController.getUserById);
        app.put("/users/{userid}", userController.updateUserById);
        app.delete("/users/{userid}", userController.deleteUserById);


        //app.get("/users/{userid}/offers", userController.test);

        app.get("/cars", carController.getAllCars);
        app.post("/cars", carController.setCar);
        app.put("/cars/{carid}", carController.updateCarById);
        app.delete("cars/{carid}", carController.deleteCarById);
    }
}

package com.revature;

import com.revature.controller.AuthController;
import com.revature.controller.CarController;
import com.revature.controller.OfferController;
import com.revature.controller.UserController;
import io.javalin.Javalin;

public class Driver {
    public static void main(String[] args) {
        UserController userController = new UserController();
        CarController carController = new CarController();
        OfferController offerController = new OfferController();

        Javalin app = Javalin.create().start(8080);
        app.get("/", ctx -> ctx.status(100).result("Homepage\n/users\n/offers\n/cars")/* TODO: Add options that user can take*/);

        // register for service, no autherntifiction required
        app.post("/register", userController.setUser);

        app.before("/car_view", AuthController.withAuth);
        app.get("/car_view", carController.getAllCars);

        //

        // CRUD Operations for Users
        app.get("/users", userController.getAllUsers);
        app.post("/users", userController.setUser);
        app.get("/users/{userid}", userController.getUserById);
        app.put("/users/{userid}", userController.updateUserById);
        app.delete("/users/{userid}", userController.deleteUserById);

        // CRUD operations for car
        app.get("/cars", carController.getAllCars);
        app.get("/cars/{carid}", carController.getCarById);
        app.post("/cars", carController.setCar);
        app.put("/cars/{carid}", carController.updateCarById);
        app.delete("/cars/{carid}", carController.deleteCarById);

        //CRUD operations for offers
        app.get("/offers", offerController.getAllOffers);
        app.get("/offers/{offerid}", offerController.getOfferById);
        app.post("/offers", offerController.setOffer);
        app.put("/offers/{offerid}", offerController.updateOfferById);
        app.delete("/offers/{offerid}", offerController.deleteOfferById);

        // authernticator checker and creator
        app.before("/offers", AuthController.withAuth);
        app.before("/users", AuthController.withAuth);
        app.before("/cars", AuthController.validEmployee);
        app.post("/authenticate", AuthController.authenticate);
    }
}

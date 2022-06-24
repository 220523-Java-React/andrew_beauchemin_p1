package com.revature.controller;

import com.revature.model.Car;
import com.revature.model.User;
import com.revature.service.CarService;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.List;

public class CarController {
    CarService carService = new CarService();

    public Handler getAllCars = ctx -> {
        String customerIdString = ctx.queryParam("userid");


        List<Car> cars1 = carService.getAllCars();
        List<Car> cars = new ArrayList<>();
        if(customerIdString != null){
            int customerId = Integer.parseInt(customerIdString);
            for(Car car: cars1){
                if(car.getOwnerId() == customerId)
                    cars.add(car);
            }
        }

        ctx.json(cars);
    };

    public Handler getCarById = ctx -> {
        String param = ctx.pathParam("carid");
        int id = Integer.parseInt(param);

        Car car = carService.getCarById(id);
        if(car != null) {
            ctx.status(200).json(car);
        }else {
            ctx.status(400).json(parseError("Car not found"));
        }
    };

    public Handler setCar = ctx -> {
        Car car = ctx.bodyAsClass(Car.class);
        Car carSet = carService.createCar(car);
        if(carSet == null){
            ctx.status(400).json(parseError("Invalid creation"));
        }else{
            ctx.status(201).json(carSet);
        }
    };

    public Handler updateCarById = ctx -> {
        Car car = ctx.bodyAsClass(Car.class);
        Car carUpdate = carService.updateCarById(car);
        if(carUpdate == null){
            ctx.status(400).json(parseError("Car not found"));
        }else{
            ctx.status(201).json(carUpdate);
        }
    };

    public Handler deleteCarById = ctx -> {
        //User user = ctx.bodyAsClass(User.class);
        String param = ctx.pathParam("carid");
        if(!carService.deleteCarById(Integer.parseInt(param))){
            ctx.status(400).json(parseError("Car not found"));
        }else{
            ctx.status(200).json(parseSuccess("Car Deleted"));
        }
    };

    private String parseError(String message){
        return "{\"success\":false, \"message\":\"" + message + "\"}";
    }

    private String parseSuccess(String message){
        return "{\"success\":true, \"message\":\"" + message + "\"}";
    }
}

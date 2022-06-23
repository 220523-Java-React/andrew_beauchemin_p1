package com.revature.service;

import com.revature.model.Car;
import com.revature.model.User;
import com.revature.repository.CarRepository;
import com.revature.repository.UserRepository;

import java.util.List;

public class CarService {

    private CarRepository carRepository;

    public CarService(){carRepository = new CarRepository();}

    public List<Car> getAllCars() {
        return carRepository.getAll();
    }

    public Car createCar(Car car){return carRepository.create(car);}


    public Car getCarById(int id){return carRepository.getById(id);}

    public Car updateCarById(Car car){return carRepository.update(car);}

    public boolean deleteCarById(int id){
        return carRepository.deleteById(id);
    }

}

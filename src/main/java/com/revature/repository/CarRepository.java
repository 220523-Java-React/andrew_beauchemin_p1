package com.revature.repository;

import com.revature.model.Car;
import com.revature.model.Role;
import com.revature.model.User;
import com.revature.util.ConnectionUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepository implements DAO<Car>{
    @Override
    public Car create(Car car) {
        String sql = "insert into cars(model, vin, owner_id) values(?,?,?)";

        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, car.getModel());
            stmt.setString(2, car.getVinNumber());
            if(car.getOwnerId() != null)
                stmt.setInt(3, car.getOwnerId());
            else
                stmt.setNull(3, Types.INTEGER);

            int suceess = stmt.executeUpdate();

            // something went wrong
            if(suceess != 1)
                return null;

            // check to see if the key was generated and then return user by id
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                return car.setId(rs.getInt(1));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Car> getAll() {
        List<Car> cars = new ArrayList<>();
        String sql = "select * from cars";

        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet results = stmt.executeQuery();

            while(results.next()){
                // go through each result, build a User object for that data, add that user object the users list
                cars.add(new Car()
                        .setModel(results.getString("model"))
                        .setId(results.getInt("id"))
                        .setOwnerId(results.getInt("owner_id"))
                        .setVinNumber(results.getString("vin")));

            }


        }catch(SQLException e){
            e.printStackTrace();
        }

        return cars;
    }

    @Override
    public Car getById(int id) {
        String sql = "select * from cars where id = ?";

        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet results = stmt.executeQuery();

            if(results.next()) {
                // there better only be one user or primary key isnt working
                Car resultCar = new Car()
                        .setModel(results.getString("model"))
                        .setId(results.getInt("id"))
                        .setOwnerId(results.getInt("owner_id"))
                        .setVinNumber(results.getString("vin"));

                return resultCar;

                // if no result return null
            }else {
                return null;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Car update(Car car) {
        String sql = "update cars set model = ?, vin = ?, owner_id = ? where id = ?";

        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, car.getModel());
            stmt.setString(2, car.getVinNumber());
            stmt.setInt(3, car.getOwnerId());
            stmt.setInt(4, car.getId());

            int suceess = stmt.executeUpdate();

            // not 1 row affected, something must be wrong
            if(suceess != 1)
                return null;

            // returns the user by id if set correctly
            return car;

        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean deleteById(int id) {
        String sql = "delete from cars where id = ?";

        try(Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            int suceess = stmt.executeUpdate();

            // not 1 row affected, something must be wrong
            if(suceess != 1)
                return false;

            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }


        return false;
    }

}

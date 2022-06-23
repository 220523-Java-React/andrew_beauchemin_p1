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
            stmt.setInt(3, car.getOwnerId());

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
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String sql = "select * from users";

        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet results = stmt.executeQuery();

            while(results.next()){
                // go through each result, build a User object for that data, add that user object the users list
                users.add(new User()
                        .setLastName(results.getString("last_name"))
                        .setUsername(results.getString("username"))
                        .setPassword(results.getString("password"))
                        .setFirstName(results.getString("first_name"))
                        .setId(results.getInt("id"))
                        .setRole(Role.values()[results.getInt("role_id")]));


                User user2 = new User().setFirstName("first");
            }


        }catch(SQLException e){
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User getById(int id) {
        String sql = "select * from users where id = ?";

        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet results = stmt.executeQuery();

            if(results.next()) {
                // there better only be one user or primary key isnt working
                User resultUser = new User()
                        .setLastName(results.getString("last_name"))
                        .setUsername(results.getString("username"))
                        .setPassword(results.getString("password"))
                        .setFirstName(results.getString("first_name"))
                        .setId(results.getInt("id"))
                        .setRole(Role.values()[results.getInt("role_id")]);

                return resultUser;

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
    public User update(User user) {
        String sql = "update users set first_name = ?, last_name = ?, username = ?, password = ? where id = ?";

        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getPassword());
            stmt.setInt(5, user.getId());

            int suceess = stmt.executeUpdate();

            // not 1 row affected, something must be wrong
            if(suceess != 1)
                return null;

            // returns the user by id if set correctly
            return getById(user.getId());

        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean deleteById(int id) {
        String sql = "delete from users where id = ?";

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

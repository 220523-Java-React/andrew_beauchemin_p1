package com.revature.repository;

import com.revature.model.User;
import com.revature.util.ConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements DAO<User> {

    @Override
    public User create(User user) {
        String sql = "insert into users(first_name, last_name, username, password) values(?,?,?,?)";

        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getPassword());

            int suceess = stmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }

        //TODO: return get user
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
                        .setId(results.getInt("id")));

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

            stmt.setString(1, Integer.toString(id));

            ResultSet results = stmt.executeQuery();

            // there better only be one user or primary key isnt working
            User resultUser = new User()
                    .setLastName(results.getString("last_name"))
                    .setUsername(results.getString("username"))
                    .setPassword(results.getString("password"))
                    .setFirstName(results.getString("first_name"))
                    .setId(results.getInt("id"));

            //TODO: figure out how to send null if query not good
            return resultUser;


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
            stmt.setString(5, Integer.toString(user.getId()));

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
    public boolean deleteById(int id) {return false;    }
}

package com.revature.repository;

import com.revature.model.Offer;
import com.revature.model.Role;
import com.revature.model.Status;
import com.revature.model.User;
import com.revature.util.ConnectionUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OfferRepository implements DAO<Offer>{
    @Override
    public Offer create(Offer offer) {
        String sql = "insert into offers(amount, customer_id, car_id, status_id) values(?,?,?,?)";

        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setFloat(1, offer.getAmount());
            stmt.setInt(2, offer.getCustomerId());
            stmt.setInt(3, offer.getCarID());
            stmt.setInt(4, offer.getStatus().ordinal());

            int suceess = stmt.executeUpdate();

            // something went wrong
            if(suceess != 1)
                return null;

            // check to see if the key was generated and then return user by id
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                return offer.setId(rs.getInt(1));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Offer> getAll() {
        List<Offer> offers = new ArrayList<>();
        String sql = "select * from offers";

        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet results = stmt.executeQuery();

            while(results.next()){
                // go through each result, build a User object for that data, add that user object the users list
                offers.add(new Offer()
                        .setAmount(results.getFloat("amount"))
                        .setCustomerId(results.getInt("customer_id"))
                        .setCarID(results.getInt("car_id"))
                        .setStatus(Status.values()[results.getInt("status_id")]));


            }


        }catch(SQLException e){
            e.printStackTrace();
        }

        return offers;
    }

    @Override
    public Offer getById(int id) {
        String sql = "select * from offers where id = ?";

        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet results = stmt.executeQuery();

            if(results.next()) {
                // there better only be one user or primary key isnt working
                Offer resultOffer = new Offer()
                        .setAmount(results.getFloat("amount"))
                        .setCustomerId(results.getInt("customer_id"))
                        .setCarID(results.getInt("car_id"))
                        .setStatus(Status.values()[results.getInt("status_id")]);

                return resultOffer;

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
    public Offer update(Offer offer) {
        String sql = "update offers set amount = ?, customer_id = ?, car_id = ?, status_id = ? where id = ?";

        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setFloat(1, offer.getAmount());
            stmt.setInt(2, offer.getCustomerId());
            stmt.setInt(3, offer.getCarID());
            stmt.setInt(4, offer.getStatus().ordinal());
            stmt.setInt(5, offer.getId());

            int suceess = stmt.executeUpdate();

            // not 1 row affected, something must be wrong
            if(suceess != 1)
                return null;

            // returns the user by id if set correctly
            return offer;

        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean deleteById(int id) {
        String sql = "delete from offers where id = ?";

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

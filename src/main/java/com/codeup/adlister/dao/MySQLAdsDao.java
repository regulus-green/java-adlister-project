package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    public List<Ad> getAdsBySpecificUser(long id){
        List<Ad> adsBySpecificUser = new ArrayList<>();

        try{
            String query = "SELECT * From ads WHERE user_id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                adsBySpecificUser.add(new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }

        }catch(SQLException e) {
            throw new RuntimeException("Error retrieving ads by specific user", e);
        }
        return adsBySpecificUser;
    }

    @Override
    public Ad individualAdID(long id) {
        Ad ad = null;
        try{
            String query = "SELECT * FROM ads WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                ad =  new Ad(
                     rs.getLong("id"),
                     rs.getLong("user_id"),
                     rs.getString("title"),
                     rs.getString("description")
                );
            }
        }catch (SQLException e){
            throw new RuntimeException("Error retrieving ad.", e);
        }
        return ad;
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
    // delete method - alfonso
    public void deleteAd(long id ){
        String deleteStmt = "DELETE FROM ads WHERE id = '" + id + "'";
        try {
            PreparedStatement stmt = connection.prepareStatement(deleteStmt);
            stmt.executeUpdate(deleteStmt);
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting ad by id", e);
        }
    }
    // update method - alfonso
    public void updateAd(Ad ad){
//        boolean rowUpdated;
        String updateStmt = "UPDATE ads SET title = ?, description = ? WHERE id = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(updateStmt);
            stmt.setString(1, ad.getTitle());
            stmt.setString(2, ad.getDescription());
            stmt.setLong(3, ad.getId());

            stmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Error updating ad by id");
        }
//        System.out.println(rowUpdated);
//        return rowUpdated;
    }

    public Ad findById(long id){
        Ad ad = null;
        String findStmt = "SELECT * FROM ads WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(findStmt);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs);
            if(rs.next()){
                ad = new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                );
            }
        } catch (SQLException e){
            throw new RuntimeException("Error finding ad by id");
        }
        System.out.println(ad);
        return ad;
    }
    }


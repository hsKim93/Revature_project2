package dev.chirp.dao.implementations;

import dev.chirp.utility.ConnectionDB;
import dev.chirp.dao.interfaces.RelationshipsDAOInt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RelationshipsDAO implements RelationshipsDAOInt {

    @Override
    public int getLikesByPostId(int postId) {
        try(Connection connection= ConnectionDB.createConnection()){
            String sql = "select count(*) from project2.likes where post_id = ?";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, postId);
            ResultSet returned =statement.executeQuery();
            if(returned.next()){
            return returned.getInt(1);}
            else{return 0;}
        }catch (SQLException e){
            e.printStackTrace();
            return 0;

        }
    }

    @Override
    public boolean likeByIds(int userId, int postId) {
        try(Connection connection= ConnectionDB.createConnection()){
            String sql = "insert into project2.likes values(?, ?) returning post_id";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, postId);
            ResultSet returned =statement.executeQuery();
            return returned.next();
        }catch (SQLException e){
            e.printStackTrace();
            return false;

        }
    }

    @Override
    public boolean unlikeByIds(int userId, int postId) {
        try(Connection connection= ConnectionDB.createConnection()){
            String sql = "delete from project2.likes where user_id = ? and post_id = ? returning post_id";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, postId);
            ResultSet returned =statement.executeQuery();
            return returned.next();
        }catch (SQLException e){
            e.printStackTrace();
            return false;

        }
    }

    @Override
    public List<Integer> getFollowingByUserId(int userId) {
        try(Connection connection= ConnectionDB.createConnection()){
            String sql = "select target_id from project2.relationships where user_id = ?";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet returned =statement.executeQuery();
            List<Integer> returnList = new ArrayList<>();
            while(returned.next()){
                returnList.add(returned.getInt(1));
            }
            return returnList;
        }catch (SQLException e){
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public List<Integer> getFollowersByUserId(int userId) {
        try(Connection connection= ConnectionDB.createConnection()){
            String sql = "select user_id from project2.relationships where target_id = ?";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet returned =statement.executeQuery();
            List<Integer> returnList = new ArrayList<>();
            while(returned.next()){
                returnList.add(returned.getInt(1));
            }
            return returnList;
        }catch (SQLException e){
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public boolean followByIds(int myId, int targetId) {
        try(Connection connection= ConnectionDB.createConnection()){
            String sql = "insert into project2.relationships values(?, ?) returning target_id";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, myId);
            statement.setInt(2, targetId);
            ResultSet returned =statement.executeQuery();
            return returned.next();
        }catch (SQLException e){
            e.printStackTrace();
            return false;

        }

    }

    @Override
    public boolean unfollowByIds(int myId, int targetId) {
        try(Connection connection= ConnectionDB.createConnection()){
            String sql = "delete from project2.relationships where user_id = ? and target_id = ? returning target_id";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, myId);
            statement.setInt(2, targetId);
            ResultSet returned =statement.executeQuery();
            return returned.next();
        }catch (SQLException e){
            e.printStackTrace();
            return false;

        }
    }
}

package dev.chirp.dao.implementations;

import dev.chirp.customexceptions.PostNotFound;
import dev.chirp.dao.interfaces.RelationshipsDAOInt;
import dev.chirp.utility.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RelationshipsDAOImp implements RelationshipsDAOInt {

    @Override
    public int getLikesByPostId(int postId) {
        try(Connection connection= ConnectionDB.createConnection()){
            String sql = "select count(*) from posts where post_id = ?";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, postId);
            ResultSet returned =statement.executeQuery();
            return returned.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
            return 0;

        }
    }

    @Override
    public boolean likeByIds(int userId, int postId) {
        return false;
    }

    @Override
    public boolean unlikeByIds(int userId, int postId) {
        return false;
    }

    @Override
    public List<Integer> getFollowingByUserId(int userId) {
        return null;
    }

    @Override
    public List<Integer> getFollowersByUserId(int userId) {
        return null;
    }

    @Override
    public boolean followByIds(int myId, int targetId) {
        return false;
    }

    @Override
    public boolean unfollowByIds(int myId, int targetId) {
        return false;
    }
}

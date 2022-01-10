package dev.chirp.dao.implementations;

import dev.chirp.customexceptions.PostNotFound;
import dev.chirp.dao.interfaces.PostDAOInt;
import dev.chirp.entities.Post;
import dev.chirp.utility.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAO implements PostDAOInt {
    @Override
    public boolean createPost(Post post) {
        try (Connection connection = ConnectionDB.createConnection()) {
            String sql = "insert into project2.posts values(default, ?, ?, default) returning post_id";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, post.getUserId());
            statement.setString(2, post.getContent());
            ResultSet returned = statement.executeQuery();
            return returned.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }


    }

    @Override
    public List<Post> getPostModule(int userId) {
        try (Connection connection = ConnectionDB.createConnection()) {
            String sql = "select users.user_id, user_name,first_name,last_name,post_content,post_id,\"date\" \n" +
                    "from project2.users inner join project2.posts on users.user_id = posts.user_id where posts.user_id = ?";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet returned = statement.executeQuery();
            List<Post> postList = new ArrayList<>();

            while (returned.next()) {
                Post returnedPost = new Post(
                        returned.getInt("post_id"),
                        returned.getInt("user_id"),
                        returned.getString("post_content"),
                        returned.getString("date"),
                        returned.getString("user_name"),
                        returned.getString("first_name"),
                        returned.getString("last_name")
                );
                postList.add(returnedPost);
            }
            return postList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }


    }

    @Override
    public Post getPostById(int postId) {
        try (Connection connection = ConnectionDB.createConnection()) {
            String sql = "select * from project2.posts where post_id = ?";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, postId);
            ResultSet returned = statement.executeQuery();
            if (returned.next()) {
                return new Post(
                        returned.getInt("post_id"),
                        returned.getInt("user_id"),
                        returned.getString("post_content"),
                        returned.getString("date")
                );
            } else {
                throw new PostNotFound("Post not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public List<Post> getAllPosts() {
        try (Connection connection = ConnectionDB.createConnection()) {
            String sql = "select * from project2.posts";
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet returned = statement.executeQuery(sql);
            List<Post> postList = new ArrayList<>();

            while (returned.next()) {
                Post returnedPost = new Post(
                        returned.getInt("post_id"),
                        returned.getInt("user_id"),
                        returned.getString("post_content"),
                        returned.getString("date")
                );
                postList.add(returnedPost);

            }
            return postList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Post> getPostsByUserId(int userId) {
        try (Connection connection = ConnectionDB.createConnection()) {
            String sql = "select * from project2.posts where user_id = ?";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet returned = statement.executeQuery();
            List<Post> postList = new ArrayList<>();
            while (returned.next()) {
                Post returnedPost = new Post(
                        returned.getInt("post_id"),
                        returned.getInt("user_id"),
                        returned.getString("post_content"),
                        returned.getString("date")
                );
                postList.add(returnedPost);

            }
            return postList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deletePostById(int postId) {
        try (Connection connection = ConnectionDB.createConnection()) {
            String sql = "delete from project2.posts where post_id = ? returning post_id";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, postId);
            ResultSet returned = statement.executeQuery();
            if (returned.next()) {
                return true;
            } else {
                throw new PostNotFound("Post not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }
}

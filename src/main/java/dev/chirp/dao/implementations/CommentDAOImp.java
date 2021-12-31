package dev.chirp.dao.implementations;

import dev.chirp.customexceptions.CommentNotFound;
import dev.chirp.dao.interfaces.CommentDAO;
import dev.chirp.entities.Comment;
import dev.chirp.utility.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDAOImp implements CommentDAO {

    @Override
    public Comment createComment(Comment comment) {
        try (Connection connection = ConnectionDB.createConnection()){
           String sql = "insert into project2.comments values(default, ?, ?, ?, default)";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           preparedStatement.setInt(1, comment.getPostId());
           preparedStatement.setInt(2, comment.getUserId());
           preparedStatement.setString(3, comment.getCommentContent());
           preparedStatement.execute();
           ResultSet resultSet = preparedStatement.getGeneratedKeys();
           resultSet.next();
           comment.setCommentId(resultSet.getInt("comment_id"));
           return comment;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return false;
    }

    @Override
    public Comment getCommentById(int commentId) {
        try (Connection connection = ConnectionDB.createConnection()){
            String sql = "select * from project2.comments where comment_id = ?";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, commentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return new Comment(
                    resultSet.getInt("comment_id"),
                    resultSet.getInt("post_id"),
                    resultSet.getInt("user_id"),
                    resultSet.getString("comment_content"),
                    resultSet.getString("date")
                );
            } else {
                throw new CommentNotFound("Comment not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Comment> getCommentsByPostId(int postId) {
        try (Connection connection = ConnectionDB.createConnection()){
            String sql = "select * from project2.comments where post_id = ?";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, postId);
            ResultSet resultSet = statement.executeQuery();
            List<Comment> comments = new ArrayList<>();
            while(resultSet.next()){
                Comment comment = new Comment(
                        resultSet.getInt("comment_id"),
                        resultSet.getInt("post_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("comment_content"),
                        resultSet.getString("date")
                );
                comments.add(comment);
            }
            return comments;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Comment> getAllComments() {
        try (Connection connection = ConnectionDB.createConnection()){
            String sql = "select * from project2.comments";
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Comment> comments = new ArrayList<>();
            while(resultSet.next()){
                Comment comment = new Comment(
                        resultSet.getInt("comment_id"),
                        resultSet.getInt("post_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("comment_content"),
                        resultSet.getString("date")
                );
                comments.add(comment);
            }

            return comments;

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteCommentById(int commentId) {
        try(Connection connection= ConnectionDB.createConnection()){
            String sql = "delete from project2.comments where comment_id = ? returning comment_id";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, commentId);
            ResultSet returned =statement.executeQuery();
            if (returned.next()){
                return true;
            }
            else {
                throw new CommentNotFound("Comment not found");
            }
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}

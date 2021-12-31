package dev.chirp.dao.implementations;

import dev.chirp.dao.interfaces.CommentDAO;
import dev.chirp.entities.Comment;
import dev.chirp.utility.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    }

    @Override
    public Comment getCommentById(int commentId) {
        try (Connection connection = ConnectionDB.createConnection()){
            String sql = "select * from comments where comment_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, commentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Comment comment = new Comment(
                    resultSet.getInt("comment_id"),
                    resultSet.getInt("post_id"),
                    resultSet.getString("comment_content"),
                    resultSet.getString("date")
            );
            return comment;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Comment> getCommentsByPostId(int postId) {
        return null;
    }

    @Override
    public List<Comment> getAllComments() {
        return null;
    }

    @Override
    public boolean deleteCommentById(int commentId) {
        return false;
    }
}

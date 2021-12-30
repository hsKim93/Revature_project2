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
    public boolean createComment(Comment comment) {
//        try (){
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
        return false;
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

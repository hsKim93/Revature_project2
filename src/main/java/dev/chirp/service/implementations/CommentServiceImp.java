package dev.chirp.service.implementations;

import dev.chirp.customexceptions.InvalidInputException;
import dev.chirp.dao.interfaces.CommentDAOInt;
import dev.chirp.entities.Comment;
import dev.chirp.service.interfaces.CommentService;

import java.util.List;

public class CommentServiceImp implements CommentService {

    CommentDAOInt commentDAO;

    public CommentServiceImp(CommentDAOInt commentDAO){
        this.commentDAO = commentDAO;
    }

    @Override
    public Comment serviceCreateComment(Comment comment) {

        if (comment.getUserId() < 0 || comment.getPostId() < 0 || comment.getCommentContent().isEmpty() ||
                comment.getCommentContent().length() > 500) {
            throw new InvalidInputException();
        }
            return this.commentDAO.createComment(comment);
    }

    @Override
    public Comment serviceGetCommentById(int commentId) {
        if (commentId <= 0) {
            throw new InvalidInputException();
        }
        return this.commentDAO.getCommentById(commentId);
    }

    @Override
    public List<Comment> serviceGetCommentsByPostId(int postId) {
        if (postId <= 0) {
            throw new InvalidInputException();
        }
        return this.commentDAO.getCommentsByPostId(postId);
    }

    @Override
    public List<Comment> serviceGetAllComments() {
        return this.commentDAO.getAllComments();
    }

    @Override
    public boolean serviceDeleteCommentById(int commentId) {
        if (commentId <= 0) {
            throw new InvalidInputException();
        }
        return this.commentDAO.deleteCommentById(commentId);
    }
}

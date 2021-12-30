package dev.chirp.service.implementations;

import dev.chirp.dao.interfaces.CommentDAO;
import dev.chirp.entities.Comment;
import dev.chirp.service.interfaces.CommentService;

import java.util.List;

public class CommentServiceImp implements CommentService {

    CommentDAO commentDAO;

    public CommentServiceImp (CommentDAO commentDAO){
        this.commentDAO = commentDAO;
    }

    @Override
    public Comment serviceCreateComment(Comment comment) {
        return this.commentDAO.createComment(comment);
    }

    @Override
    public Comment serviceGetCommentById(int commentId) {
        return this.commentDAO.getCommentById(commentId);
    }

    @Override
    public List<Comment> serviceGetCommentsByPostId(int postId) {
        return this.commentDAO.getCommentsByPostId(postId);
    }

    @Override
    public List<Comment> serviceGetAllComments() {
        return this.commentDAO.getAllComments();
    }

    @Override
    public boolean serviceDeleteCommentById(int commentId) {
        return this.commentDAO.deleteCommentById(commentId);
    }
}

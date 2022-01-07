package dev.chirp.service.implementations;

import dev.chirp.dao.implementations.CommentDAO;
import dev.chirp.entities.Comment;
import dev.chirp.service.interfaces.CommentServiceInt;

import java.util.EmptyStackException;
import java.util.List;

public class CommentService implements CommentServiceInt {

    CommentDAO commentDAO;

    public CommentService(CommentDAO commentDAO){
        this.commentDAO = commentDAO;
    }

    @Override
    public Comment serviceCreateComment(Comment comment) {

        if (comment.getCommentContent().equals("")) {
            throw new EmptyStackException();
        } else {
            return this.commentDAO.createComment(comment);
        }
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

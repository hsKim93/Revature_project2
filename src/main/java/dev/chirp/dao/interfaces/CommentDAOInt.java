package dev.chirp.dao.interfaces;

import dev.chirp.entities.Comment;

import java.util.List;

public interface CommentDAOInt {

    Comment createComment(Comment comment);

    Comment getCommentById(int commentId);

    List<Comment> getCommentsByPostId(int postId);

    List<Comment> getAllComments();

    boolean deleteCommentById(int commentId);
}


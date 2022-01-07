package dev.chirp.service.interfaces;


import dev.chirp.entities.Comment;

import java.util.List;

public interface CommentServiceInt {
    Comment serviceCreateComment(Comment comment);

    Comment serviceGetCommentById(int commentId);

    List<Comment> serviceGetCommentsByPostId(int postId);

    List<Comment> serviceGetAllComments();

    boolean serviceDeleteCommentById(int commentId);
}

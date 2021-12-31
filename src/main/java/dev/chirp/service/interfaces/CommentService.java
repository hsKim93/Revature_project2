package chirp.service.interfaces;


import chirp.entities.Comment;

import java.util.List;

public interface CommentService {
    Comment serviceCreateComment(Comment comment);

    Comment serviceGetCommentById(int commentId);

    List<Comment> serviceGetCommentsByPostId(int postId);

    List<Comment> serviceGetAllComments();

    boolean serviceDeleteCommentById(int commentId);
}

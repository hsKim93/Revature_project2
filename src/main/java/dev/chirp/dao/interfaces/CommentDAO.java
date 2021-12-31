package chirp.dao.interfaces;

import chirp.entities.Comment;

import java.util.List;

public interface CommentDAO {

    Comment createComment(Comment comment);

    Comment getCommentById(int commentId);

    List<Comment> getCommentsByPostId(int postId);

    List<Comment> getAllComments();

    boolean deleteCommentById(int commentId);
}


package dao;

import dev.chirp.customexceptions.CommentNotFound;
import dev.chirp.dao.implementations.CommentDAOImp;
import dev.chirp.entities.Comment;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CommentDAOTests {

    CommentDAOImp commentDAO = new CommentDAOImp();

    @Test
    void createComment() {
        Comment newComment = new Comment(904, 900, 900, "Test Comment Create", "0");
        Comment returnedComment = commentDAO.createComment(newComment);
        Assert.assertTrue(returnedComment.getCommentId() != 0);
    }

    @Test
    void selectCommentById() {
        Comment comment = commentDAO.getCommentById(901);
        Assert.assertEquals(comment.getCommentId(), 901);
    }

    @Test(expectedExceptions = CommentNotFound.class, expectedExceptionsMessageRegExp = "Comment not found")
    void selectCommentByIdFail(){
        Comment comment = commentDAO.getCommentById(1111111);
    }

    @Test
    void getCommentsByPostId() {
        List<Comment> comments = commentDAO.getCommentsByPostId(900);
        Assert.assertTrue(comments.size() > 0);
    }

    @Test
    void getAllComments() {
        List<Comment> comments = commentDAO.getAllComments();
        Assert.assertTrue(comments.size() > 0);
    }

    @Test
    void deleteCommentById() {
        boolean deletedComment = commentDAO.deleteCommentById(902);
        Assert.assertTrue(deletedComment);
    }

}

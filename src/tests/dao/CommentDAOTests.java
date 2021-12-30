<<<<<<< HEAD
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
        Comment newComment = new Comment(0, 2, 3, "Test Comment", "0");
        Comment returnedComment = commentDAO.createComment(newComment);
        Assert.assertTrue(returnedComment.getCommentId() != 0);
    }

    @Test
    void selectCommentById() {
        Comment comment = commentDAO.getCommentById(1);
        Assert.assertEquals(comment.getCommentId(), 1);
    }

    @Test(expectedExceptions = CommentNotFound.class, expectedExceptionsMessageRegExp = "Comment not found")
    void selectCommentByIdFail(){
        Comment comment = commentDAO.getCommentById(1111111);
    }

    @Test
    void getCommentsByPostId() {
        List<Comment> comments = commentDAO.getCommentsByPostId(2);
        Assert.assertTrue(comments.size() > 0);
    }

    @Test
    void getAllComments() {
        List<Comment> comments = commentDAO.getAllComments();
        Assert.assertTrue(comments.size() > 0);
    }

    @Test
    void deleteCommentById() {
        boolean deletedComment = commentDAO.deleteCommentById(2);
        Assert.assertTrue(deletedComment);
    }

}
=======
//package tests.dao;
//
//import dev.chirp.dao.implementations.CommentDAOImp;
//import dev.chirp.dao.interfaces.CommentDAO;
//import dev.chirp.entities.Comment;
//import org.testng.Assert;
//
//public class CommentDAOTests {
//
//    CommentDAO commentDAO = new CommentDAOImp();
//
//    @Test
//    void selectCommentById() {
//        Comment comment = commentDAO.getCommentById(1);
//        Assert.assertEquals(comment.getCommentByID(), 1);
//    }
//}
>>>>>>> 05e947a51837296044351a9eaf830d3bdab0f71d

package service;

import dev.chirp.dao.implementations.CommentDAO;
import dev.chirp.entities.Comment;
import dev.chirp.service.implementations.CommentService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.EmptyStackException;


public class CommentServiceTests {
    static CommentDAO commentDAO = new CommentDAO();
    static CommentService commentService = new CommentService(commentDAO);

    @Test
    void createCommentWithEmptyContent(){
        try {
            Comment comment = new Comment(0, 2, 3, "", "0");
            Comment comment1 = commentService.serviceCreateComment(comment);
            Assert.assertEquals(comment1.getCommentContent(), "");
        }catch (EmptyStackException e){
            Assert.assertTrue(true);
        }
    }
}

package service;

import dev.chirp.dao.implementations.CommentDAOImp;
import dev.chirp.dao.interfaces.CommentDAO;
import dev.chirp.entities.Comment;
import dev.chirp.service.implementations.CommentServiceImp;
import dev.chirp.service.interfaces.CommentService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.EmptyStackException;


public class CommentServiceTests {
    static CommentDAO commentDAO = new CommentDAOImp();
    static CommentService commentService = new CommentServiceImp(commentDAO);

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

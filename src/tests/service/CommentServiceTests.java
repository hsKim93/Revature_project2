package service;

import chirp.dao.implementations.CommentDAOImp;
import chirp.dao.interfaces.CommentDAO;
import chirp.entities.Comment;
import chirp.service.implementations.CommentServiceImp;
import chirp.service.interfaces.CommentService;
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

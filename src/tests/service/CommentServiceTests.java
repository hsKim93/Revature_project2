package service;

import dev.chirp.customexceptions.InvalidInputException;
import dev.chirp.dao.implementations.CommentDAO;
import dev.chirp.entities.Comment;
import dev.chirp.service.implementations.CommentServiceImp;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class CommentServiceTests {
    public CommentDAO commentDAO;
    public CommentServiceImp commentService;

    @BeforeClass
    public void setup() {
        commentDAO = Mockito.mock(CommentDAO.class);
        commentService = new CommentServiceImp(commentDAO);
    }

    int validCommentId = 1;
    int negativeId = -1;
    String emptyComment = "";
    String validComment = "Lorem ipsum dolor sit amet";
    String longComment = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam semper sapien sit " +
            "amet placerat condimentum. In eu tincidunt diam. Integer hendrerit volutpat eros eu imperdiet. " +
            "Vestibulum aliquam placerat ante. Sed porttitor, eros id vehicula rutrum, lorem lacus maximus dui," +
            " in commodo turpis neque id lectus. Aliquam erat volutpat. Nulla viverra, lectus vitae facilisis " +
            "imperdiet, sapien lacus tempor sapien, id suscipit lorem sapien ut libero. Cras aliquam sapien eu " +
            "ante iaculis laoreet. Vivamus ultrices enim eget magna feugiat auctor. Sed vitae augue lectus. " +
            "Etiam malesuada magna sem, a pretium tellus rhoncus sit amet. Vestibulum in risus in odio venenatis " +
            "commodo ac.";


    /**Service Create Comment**/
    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    public void serviceCreateLongComment(){
        Comment comment = new Comment(validCommentId, validCommentId, validCommentId, longComment, validComment);
        commentService.serviceCreateComment(comment);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    public void serviceCreateEmptyComment(){
        Comment comment = new Comment(validCommentId, validCommentId, validCommentId, emptyComment, validComment);
        commentService.serviceCreateComment(comment);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    public void serviceCreateNegativePostID(){
        Comment comment = new Comment(validCommentId, negativeId, validCommentId, validComment, validComment);
        commentService.serviceCreateComment(comment);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    public void serviceCreateNegativeUserID(){
        Comment comment = new Comment(validCommentId, validCommentId, negativeId, validComment, validComment);
        commentService.serviceCreateComment(comment);
    }

    @Test
    public void serviceCreateComment(){
        Comment result = new Comment(validCommentId, validCommentId, validCommentId, validComment, validComment);
        Mockito.when(commentDAO.createComment(result)).thenReturn(result);
        Assert.assertEquals(commentService.serviceCreateComment(result),result);
    }



    /**Service Get Comment By ID**/
    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceGetCommentByNegativeId() {
        commentService.serviceGetCommentById(negativeId);
    }

    @Test
    public void serviceGetCommentByID(){
        Comment result = new Comment(validCommentId, validCommentId, validCommentId, validComment, validComment);
        Mockito.when(commentDAO.getCommentById(validCommentId)).thenReturn(result);
        Assert.assertEquals(commentService.serviceGetCommentById(validCommentId),result);
    }



    /**Service Get All Comments By Post Ids**/
    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    public void serviceGetCommentsByNegativePostID(){
        commentService.serviceGetCommentsByPostId(negativeId);
    }

    @Test
    public void serviceGetCommentsByPostID(){
        Comment postOb = new Comment(validCommentId, validCommentId, validCommentId, validComment, validComment);
        List<Comment> result = new ArrayList<>();
        result.add(postOb);
        Mockito.when(commentDAO.getCommentsByPostId(validCommentId)).thenReturn(result);
        Assert.assertEquals(commentService.serviceGetCommentsByPostId(validCommentId),result);
    }



    /**Service Delete Comment**/
    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceDeleteCommentByNegativeId() {
        commentService.serviceDeleteCommentById(negativeId);
    }

    @Test
    public void serviceDeleteCommentByID(){
        Mockito.when(commentDAO.deleteCommentById(validCommentId)).thenReturn(true);
        boolean result = commentService.serviceDeleteCommentById(validCommentId);
        Assert.assertTrue(result);
    }
}

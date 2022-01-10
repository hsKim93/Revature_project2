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

    int positiveId = 1;
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
        Comment comment = new Comment(positiveId, positiveId, positiveId, longComment, validComment);
        commentService.serviceCreateComment(comment);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    public void serviceCreateEmptyComment(){
        Comment comment = new Comment(positiveId, positiveId, positiveId, emptyComment, validComment);
        commentService.serviceCreateComment(comment);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    public void serviceCreateNegativePostID(){
        Comment comment = new Comment(positiveId, negativeId, positiveId, validComment, validComment);
        commentService.serviceCreateComment(comment);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    public void serviceCreateNegativeUserID(){
        Comment comment = new Comment(positiveId, positiveId, negativeId, validComment, validComment);
        commentService.serviceCreateComment(comment);
    }

    @Test
    public void serviceCreateComment(){
        Comment result = new Comment(positiveId, positiveId, positiveId, validComment, validComment);
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
        Comment result = new Comment(positiveId, positiveId, positiveId, validComment, validComment);
        Mockito.when(commentDAO.getCommentById(positiveId)).thenReturn(result);
        Assert.assertEquals(commentService.serviceGetCommentById(positiveId),result);
    }



    /**Service Get All Comments By Post Ids**/
    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    public void serviceGetCommentsByNegativePostID(){
        commentService.serviceGetCommentsByPostId(negativeId);
    }

    @Test
    public void serviceGetCommentsByPostID(){
        Comment postOb = new Comment(positiveId, positiveId, positiveId, validComment, validComment);
        List<Comment> result = new ArrayList<>();
        result.add(postOb);
        Mockito.when(commentDAO.getCommentsByPostId(positiveId)).thenReturn(result);
        Assert.assertEquals(commentService.serviceGetCommentsByPostId(positiveId),result);
    }



    /**Service Delete Comment**/
    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceDeleteCommentByNegativeId() {
        commentService.serviceDeleteCommentById(negativeId);
    }

    @Test
    public void serviceDeleteCommentByID(){
        Mockito.when(commentDAO.deleteCommentById(positiveId)).thenReturn(true);
        boolean result = commentService.serviceDeleteCommentById(positiveId);
        Assert.assertTrue(result);
    }
}

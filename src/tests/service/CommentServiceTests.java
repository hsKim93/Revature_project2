package service;

import dev.chirp.dao.implementations.CommentDAO;
import dev.chirp.service.implementations.CommentServiceImp;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CommentServiceTests {
    public CommentDAO commentDAO;
    public CommentServiceImp commentService;

    @BeforeClass
    public void setup() {
        commentDAO = Mockito.mock(CommentDAO.class);
        commentService = new CommentServiceImp(commentDAO);
    }

    int positiveId = 1;
    int negativeID = -1;
    String emptyComment = "";
    String validString = "Lorem ipsum dolor sit amet";
    String longComment = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt " +
            "ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
            "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit " +
            "esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in" +
            " culpa qui officia deserunt mollit anim id est laborum.";

//    /**Service Create Comment**/
//    @Test
//    public void serviceCreateLongComment(){
//        return null;
//    }
//
//    @Test
//    public void serviceCreateEmptyComment(){
//        return null;
//    }
//
//    @Test
//    public void serviceCreateNegativeCommentID(){
//        return null;
//    }
//
//    /**Service Get Comment By ID**/
//    @Test
//    public void serviceGetCommentByNegativeID(){
//        return null;
//    }
//
//    @Test
//    public void serviceGetCommentByID(){
//        return null;
//    }
//
//    /**Service Get All Comments By Post Ids**/
//    @Test
//    public void serviceGetCommentsByNegativePostID(){
//        return null;
//    }
//
//    @Test
//    public void serviceGetCommentsByPostID(){
//        return null;
//    }
//
//    /**Service Get All Comments**/
//    @Test
//    public void serviceGetAllComments(){
//        return null;
//    }

    /**Service Delete Comment**/
    @Test
    public void serviceDeleteCommentByNegativeID(){
        Mockito.when(commentDAO.deleteCommentById(negativeID)).thenReturn(true);
        boolean result = commentService.serviceDeleteCommentById(negativeID);
        Assert.assertTrue(result);
    }

    @Test
    public void serviceDeleteCommentByID(){
        Mockito.when(commentDAO.deleteCommentById(positiveId)).thenReturn(true);
        boolean result = commentService.serviceDeleteCommentById(positiveId);
        Assert.assertTrue(result);
    }
}

package service;

import dev.chirp.customexceptions.InvalidInputException;
import dev.chirp.dao.implementations.PostDAO;
import dev.chirp.entities.Post;
import dev.chirp.service.implementations.PostService;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PostServiceTests {
    PostDAO postDAO;
    PostService postService;

    @BeforeClass
    void setup() {
        postDAO = Mockito.mock(PostDAO.class);
        postService = new PostService(postDAO);
    }

    int positiveId = 1;
    int negativeID = -1;
    String emptyString = "";
    String validString = "Lorem ipsum dolor sit amet";
    String longString = "Lorem ipsum dolor sit amet," +
            "consectetuer adipiscing elit. Aenean commodo " +
            "ligula eget dolor. Aenean massa. Cum sociis natoque " +
            "penatibus et magnis dis parturient montes, nascetur ridiculus " +
            "mus. Donec quam felis, ultricies nec, pellentesque eu, pretium " +
            "quis, sem. Nulla consequat massa quis enim. Donec pede justo, " +
            "fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, " +
            "rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum " +
            "felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. " +
            "Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. " +
            "Aenean leo ligula, porttitor eu,";


    /**
     * TESTING VALID AND INVALID INPUTS FOR serviceCreatePost
     **/

    @Test()
    void serviceCreatePostValid() {
        Post postOb = new Post(positiveId, positiveId, validString, validString);
        Mockito.when(postDAO.createPost(postOb)).thenReturn(true);
        Assert.assertTrue(postService.serviceCreatePost(postOb));
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceCreatePostLongsString() {
        Post postOb = new Post(positiveId, positiveId, longString, validString);
        postService.serviceCreatePost(postOb);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceCreatePostEmptyString() {
        Post postOb = new Post(positiveId, positiveId, emptyString, validString);
        postService.serviceCreatePost(postOb);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceCreatePostNegativeUserId() {
        Post postOb = new Post(positiveId, negativeID, emptyString, validString);
        postService.serviceCreatePost(postOb);
    }

    /**
     * TESTING VALID AND INVALID INPUTS FOR serviceGetPostById
     **/
    @Test()
    void serviceGetPostByIdValid() {
        Post postOb = new Post(positiveId, positiveId, validString, validString);
        Mockito.when(postDAO.getPostById(positiveId)).thenReturn(postOb);
        Assert.assertEquals(postService.serviceGetPostById(positiveId),postOb);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceGetPostByIdInvalidId() {
        postService.serviceGetPostById(negativeID);
    }


    /**
     * TESTING VALID AND INVALID INPUTS FOR serviceGetPostModuleByPostId
     **/
    @Test()
    void serviceGetPostModuleByIdValid() {
        Post postOb = new Post(positiveId, positiveId, validString, validString);
        List<Post> postList = new ArrayList<>();
        postList.add(postOb);
        Mockito.when(postDAO.getPostModule(positiveId)).thenReturn(postList);
        Assert.assertEquals(postService.serviceGetPostModuleByPostId(positiveId),postList);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceGetPostModuleByIdInvalidId() {
        postService.serviceGetPostModuleByPostId(negativeID);
    }


    /**
     * TESTING VALID AND INVALID INPUTS FOR serviceGetPostModuleByPostId
     **/
    @Test()
    void serviceGetPostByUserIdValid() {
        Post postOb = new Post(positiveId, positiveId, validString, validString);
        List<Post> postList = new ArrayList<>();
        postList.add(postOb);
        Mockito.when(postDAO.getPostsByUserId(positiveId)).thenReturn(postList);
        Assert.assertEquals(postService.serviceGetPostByUserId(positiveId),postList);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceGetPostByUserIdInvalidId() {
        postService.serviceGetPostByUserId(negativeID);
    }


    /**
     * TESTING VALID AND INVALID INPUTS FOR serviceDeletePostById
     **/
    @Test()
    void serviceDeletePostByIdValid() {
        Mockito.when(postDAO.deletePostById(positiveId)).thenReturn(true);
        Assert.assertTrue(postService.serviceDeletePostById(positiveId));
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceDeletePostByIdInvalidId() {
        postService.serviceDeletePostById(negativeID);
    }

}

package service;

import dev.chirp.customexceptions.InvalidInputException;
import dev.chirp.dao.implementations.PostDAO;
import dev.chirp.entities.Post;
import dev.chirp.service.implementations.PostService;
import org.mockito.Mockito;
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
        postService.serviceCreatePost(postOb);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceCreatePostLongsString() {
        Post postOb = new Post(positiveId, positiveId, longString, validString);
        Mockito.when(postDAO.createPost(postOb)).thenReturn(true);
        postService.serviceCreatePost(postOb);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceCreatePostEmptyString() {
        Post postOb = new Post(positiveId, positiveId, emptyString, validString);
        Mockito.when(postDAO.createPost(postOb)).thenReturn(true);
        postService.serviceCreatePost(postOb);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceCreatePostNegativeUserId() {
        Post postOb = new Post(positiveId, negativeID, emptyString, validString);
        Mockito.when(postDAO.createPost(postOb)).thenReturn(true);
        postService.serviceCreatePost(postOb);
    }

    /**
     * TESTING VALID AND INVALID INPUTS FOR serviceGetPostById
     **/
    @Test()
    void serviceGetPostByIdValid() {
        Post postOb = new Post(positiveId, positiveId, validString, validString);
        Mockito.when(postDAO.getPostById(positiveId)).thenReturn(postOb);
        postService.serviceGetPostById(positiveId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceGetPostByIdInvalidId() {
        Post postOb = new Post(positiveId, positiveId, validString, validString);
        Mockito.when(postDAO.getPostById(negativeID)).thenReturn(postOb);
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
        postService.serviceGetPostModuleByPostId(positiveId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceGetPostModuleByIdInvalidId() {
        Post postOb = new Post(positiveId, positiveId, validString, validString);
        List<Post> postList = new ArrayList<>();
        postList.add(postOb);
        Mockito.when(postDAO.getPostModule(negativeID)).thenReturn(postList);
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
        postService.serviceGetPostByUserId(positiveId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceGetPostByUserIdInvalidId() {
        Post postOb = new Post(positiveId, positiveId, validString, validString);
        List<Post> postList = new ArrayList<>();
        postList.add(postOb);
        Mockito.when(postDAO.getPostsByUserId(negativeID)).thenReturn(postList);
        postService.serviceGetPostByUserId(negativeID);
    }


    /**
     * TESTING VALID AND INVALID INPUTS FOR serviceDeletePostById
     **/
    @Test()
    void serviceDeletePostByIdValid() {
        Mockito.when(postDAO.deletePostById(positiveId)).thenReturn(true);
        postService.serviceDeletePostById(positiveId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceDeletePostByIdInvalidId() {
        Mockito.when(postDAO.deletePostById(negativeID)).thenReturn(true);
        postService.serviceDeletePostById(negativeID);
    }

}

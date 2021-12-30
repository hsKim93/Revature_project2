package service;

import dev.chirp.entities.Post;
import dev.chirp.service.implementations.PostService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.EmptyStackException;

public class PostServiceTests {

    PostService postService = new PostService();

    @Test
    void createPost(){
        Post samplePost = new Post(0,8000,"Sample Post", "0");
        boolean post = postService.serviceCreatePost(samplePost);
        Assert.assertTrue(post);
    }
    @Test
    void createPostWithEmptyContent(){
        try {
            Post samplePost = new Post(0, 1, "", "0");
            boolean post = postService.serviceCreatePost(samplePost);
            Assert.assertTrue(post);
        }catch (EmptyStackException e){
            Assert.assertTrue(true);
        }
        }
}

package dao;

import dev.chirp.dao.implementations.PostDAOImp;
import dev.chirp.entities.Post;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PostDAOTests {
    PostDAOImp postDao = new PostDAOImp();
    @Test
    void createPost(){
        Post samplePost = new Post(0,1,"Sample Post", "0");
        boolean post = postDao.createPost(samplePost);
        Assert.assertTrue(post);
    }
    @Test
    void getPostById(){
        Post post = postDao.getPostById(2);
        Assert.assertTrue(post.getPostId() != 0);
    }
    @Test
    void getAllPosts(){
        List<Post> postList = postDao.getAllPosts();
        Assert.assertTrue(postList.size() > 0);
    }
    @Test
    void getPostsByUserId(){
        List<Post> postList = postDao.getPostsByUserId(1);
        Assert.assertTrue(postList.size() > 0);
    }
    @Test
    void deletePostsByPostId(){
        boolean deleted = postDao.deletePostById(10);
        Assert.assertTrue(deleted);
    }
}

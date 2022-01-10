package dao;

import dev.chirp.customexceptions.PostNotFound;
import dev.chirp.dao.implementations.PostDAO;
import dev.chirp.entities.Post;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PostDAOTests {
    PostDAO postDao = new PostDAO();

    @Test
    void createPost() {
        Post samplePost = new Post(0, 8000, "Sample Post", "0");
        boolean post = postDao.createPost(samplePost);
        Assert.assertTrue(post);
    }

    @Test
    void createPostWrongUserId() {

        Post samplePost = new Post(0, 0, "Sample Post", "0");
        boolean post = postDao.createPost(samplePost);
        Assert.assertFalse(post);
    }

    @Test
    void getPostById() {
        Post post = postDao.getPostById(8000);
        Assert.assertTrue(post.getPostId() != 0);
    }

    @Test
    void getPostByNonExistingId() {
        try {
            Post post = postDao.getPostById(0);
            Assert.assertTrue(post.getPostId() != 0);
        } catch (PostNotFound e) {
            Assert.assertSame(e.getMessage(), "Post not found");
        }

    }

    @Test
    void getAllPosts() {
        List<Post> postList = postDao.getAllPosts();
        Assert.assertTrue(postList.size() > 0);
    }

    @Test
    void getPostsByUserId() {
        List<Post> postList = postDao.getPostsByUserId(8000);
        Assert.assertTrue(postList.size() > 0);
    }

    @Test
    void getPostsByNonExistingUserId() {
        List<Post> postList = postDao.getPostsByUserId(1);
        Assert.assertEquals(postList.size(), 0);
    }

    @Test
    void deletePostsByPostId() {
        try {
            boolean deleted = postDao.deletePostById(8002);
            Assert.assertTrue(deleted);
        } catch (PostNotFound e) {
            Assert.assertSame(e.getMessage(), "Post not found");
        }
    }
}

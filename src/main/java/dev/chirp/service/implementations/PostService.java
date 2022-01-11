package dev.chirp.service.implementations;

import dev.chirp.customexceptions.InvalidInputException;
import dev.chirp.dao.implementations.PostDAO;
import dev.chirp.entities.Post;
import dev.chirp.service.interfaces.PostServiceInt;

import java.util.List;

public class PostService implements PostServiceInt {

    PostDAO postDAO;

    public PostService(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    @Override
    public boolean serviceCreatePost(Post post) {
        if (post.getUserId() < 0 || post.getContent().isEmpty() || post.getContent().length() > 500) {
            throw new InvalidInputException();
        }
        return this.postDAO.createPost(post);
    }

    @Override
    public Post serviceGetPostById(int postId) {
        if (postId <= 0) {
            throw new InvalidInputException();
        }
        return this.postDAO.getPostById(postId);
    }

    @Override
    public List<Post> serviceGetPostModuleByPostId(int userId) {
        if (userId <= 0) {
            throw new InvalidInputException();
        }
        return this.postDAO.getPostModule(userId);
    }

    @Override
    public List<Post> serviceGetAllPosts() {
        return this.postDAO.getAllPosts();
    }

    @Override
    public List<Post> serviceGetPostByUserId(int userId) {
        if (userId <= 0) {
            throw new InvalidInputException();
        }
        return this.postDAO.getPostsByUserId(userId);
    }

    @Override
    public boolean serviceDeletePostById(int postId) {
        if (postId <= 0) {
            throw new InvalidInputException();
        }
        return this.postDAO.deletePostById(postId);
    }
}

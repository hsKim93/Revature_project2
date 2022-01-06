package dev.chirp.service.implementations;

import dev.chirp.dao.implementations.PostDAO;
import dev.chirp.entities.Post;
import dev.chirp.service.interfaces.PostServiceInt;

import java.util.EmptyStackException;
import java.util.List;

public class PostService implements PostServiceInt {

    PostDAO postDao = new PostDAO();

    @Override
    public boolean serviceCreatePost(Post post) {
            if (post.getContent().equals("")){
                throw new EmptyStackException();
            }else {
                return this.postDao.createPost(post);
            }
    }

    @Override
    public Post serviceGetPostById(int postId) {
        return this.postDao.getPostById(postId);
    }
    @Override
    public List<Post> serviceGetPostModuleByPostId(int userId) {
        return this.postDao.getPostModule(userId);
    }
    @Override
    public List<Post> serviceGetAllPosts() {
        return this.postDao.getAllPosts();
    }

    @Override
    public List<Post> serviceGetPostByUserId(int userId) {
        return this.postDao.getPostsByUserId(userId);
    }

    @Override
    public boolean serviceDeletePostById(int postId) {
        return this.postDao.deletePostById(postId);
    }
}

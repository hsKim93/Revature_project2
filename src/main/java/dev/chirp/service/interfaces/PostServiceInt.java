package dev.chirp.service.interfaces;

import dev.chirp.entities.Post;

import java.util.List;

public interface PostServiceInt {

    boolean serviceCreatePost(Post post);
    Post serviceGetPostById(int postId);
    List<Post> serviceGetAllPosts();
    List<Post> serviceGetPostByUserId(int userId);
    boolean serviceDeletePostById(int postId);
}

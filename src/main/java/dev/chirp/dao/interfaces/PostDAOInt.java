package dev.chirp.dao.interfaces;

import dev.chirp.entities.Post;

import java.util.List;

public interface PostDAOInt {

    boolean createPost(Post post);

    Post getPostById(int postId);

    List<Post> getAllPosts();

    List<Post> getPostsByUserId(int userId);

    boolean deletePostById(int postId);


}

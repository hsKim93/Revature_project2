package dev.chirp.app.controller.controllers;

import com.google.gson.Gson;
import dev.chirp.customexceptions.PostNotFound;
import dev.chirp.entities.Post;
import dev.chirp.service.implementations.PostService;
import io.javalin.http.Handler;

import java.util.List;

public class PostController {
    PostService postService;
    public PostController(PostService postService){
        this.postService = postService;
    }
    public Handler createPost = ctx ->{
        try{
        Gson gson = new Gson();
        Post newPost = gson.fromJson(ctx.body(), Post.class);
        boolean createdPost = this.postService.serviceCreatePost(newPost);
        String createdPostJson = gson.toJson(createdPost);
        ctx.result(createdPostJson);
        ctx.status(201);
    }catch (IllegalArgumentException e){
            ctx.result(e.getMessage());
            ctx.status(400);
        }catch (Exception e){
            ctx.result("Exception " + e.getMessage());
            ctx.status(400);
        }};

    public Handler getPostById = ctx ->{
        try{
        int id = Integer.parseInt(ctx.pathParam("id"));
        Post gotPost = this.postService.serviceGetPostById(id);
        Gson gson = new Gson();
        String jsonPost = gson.toJson(gotPost);
        ctx.result(jsonPost);
        ctx.status(201);
    }catch (PostNotFound e){
        ctx.result(e.getMessage());
        ctx.status(404);
    }catch (IllegalArgumentException e){
            ctx.result("Type error:" + e.getMessage());
            ctx.status(400);
        }};
    public Handler getPostsByUserId = ctx ->{
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));
            List<Post> gotPost = this.postService.serviceGetPostByUserId(id);
            Gson gson = new Gson();
            String jsonPost = gson.toJson(gotPost);
            ctx.result(jsonPost);
            ctx.status(201);
        }catch (IllegalArgumentException e){
            ctx.result("Type error:" + e.getMessage());
            ctx.status(400);
        }};
    public Handler getAllPosts = ctx ->{
        List<Post> gotPost = this.postService.serviceGetAllPosts();
        Gson gson = new Gson();
        String jsonPost = gson.toJson(gotPost);
        ctx.result(jsonPost);
        ctx.status(201);

    };
    public Handler deletePostById = ctx ->{
        try{
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean gotPost = this.postService.serviceDeletePostById(id);
        Gson gson = new Gson();
        String jsonPost = gson.toJson(gotPost);
        ctx.result(jsonPost);
        ctx.status(201);
    } catch (PostNotFound e){
        ctx.result(e.getMessage());
        ctx.status(404);
    }catch (IllegalArgumentException e){
            ctx.result("Type error:" + e.getMessage());
            ctx.status(400);
        }};
}

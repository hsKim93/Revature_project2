package dev.chirp.app.controller.controllers;

import com.google.gson.Gson;
import dev.chirp.entities.Post;
import dev.chirp.service.implementations.PostService;
import dev.chirp.service.implementations.RelationshipsService;
import dev.chirp.service.implementations.UserService;
import dev.chirp.service.interfaces.CommentService;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.List;

public class MixedController {
    UserService userService;
    PostService postService;
    CommentService commentService;
    RelationshipsService relationshipsService;
    public MixedController(PostService postService, UserService userService, CommentService commentService, RelationshipsService relationshipsService) {
        this.postService=postService;
        this.userService=userService;
        this.commentService = commentService;
        this.relationshipsService = relationshipsService;
    }

    public Handler getPostsModuleByUserId = ctx ->{
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));
            List<Integer> gotFollowing = this.relationshipsService.serviceGetFollowingByUserId(id);
            gotFollowing.add(id);
            List<Object> returnList = new ArrayList<>();
            for(int a : gotFollowing){
                List<Post> posts = this.postService.serviceGetPostModuleByPostId(a);
                for(Post b :posts){
                    b.setLikes(this.relationshipsService.serviceGetLikesByPostId(b.getPostId()));
                    b.setComment(this.commentService.serviceGetCommentsByPostId(b.getPostId()));
                    returnList.add(b);
                }
            }
            Gson gson = new Gson();
            String jsonPost = gson.toJson(returnList, List.class);
            ctx.result(jsonPost);
            ctx.status(200);
        }catch (Exception e){
            ctx.result("Type error:" + e.getMessage());
            ctx.status(400);
        }};

}

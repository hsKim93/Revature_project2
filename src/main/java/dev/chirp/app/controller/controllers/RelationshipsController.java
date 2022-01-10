package dev.chirp.app.controller.controllers;

import com.google.gson.Gson;
import dev.chirp.service.implementations.RelationshipsService;
import io.javalin.http.Handler;

import java.util.List;
import java.util.Map;

public class RelationshipsController {
    RelationshipsService relationshipsService;

    public RelationshipsController(RelationshipsService relationshipsService) {
        this.relationshipsService = relationshipsService;
    }

    public Handler getLikesByPostById = ctx -> {
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));
            int getPost = this.relationshipsService.serviceGetLikesByPostId(id);
            Gson gson = new Gson();
            String jsonPost = gson.toJson(getPost);
            ctx.result(jsonPost);
            ctx.status(201);
        } catch (IllegalArgumentException e) {
            ctx.result(e.getMessage());
            ctx.status(400);
        }
    };
    public Handler likeByIds = ctx -> {
        try {
            Gson gson = new Gson();
            Map<String, Double> newFollow = gson.fromJson(ctx.body(), Map.class);
            boolean like = this.relationshipsService.serviceLikeByIds(newFollow.get("userId").intValue(), newFollow.get("postId").intValue());
            String jsonPost = gson.toJson(like);
            ctx.result(jsonPost);
            ctx.status(201);
        } catch (Exception e) {
            ctx.result(e.getMessage());
            ctx.status(400);
        }
    };
    public Handler unlikeByIds = ctx -> {
        try {
            Gson gson = new Gson();
            Map<String, Double> newFollow = gson.fromJson(ctx.body(), Map.class);
            boolean unlike = this.relationshipsService.serviceUnlikeByIds(newFollow.get("userId").intValue(), newFollow.get("postId").intValue());
            String jsonPost = gson.toJson(unlike);
            ctx.result(jsonPost);
            ctx.status(201);
        } catch (Exception e) {
            ctx.result(e.getMessage());
            ctx.status(400);
        }
    };

    public Handler getFollowingById = ctx -> {
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));
            List<Integer> following = this.relationshipsService.serviceGetFollowingByUserId(id);
            Gson gson = new Gson();
            String jsonPost = gson.toJson(following);
            ctx.result(jsonPost);
            ctx.status(201);
        } catch (IllegalArgumentException e) {
            ctx.result(e.getMessage());
            ctx.status(400);
        }
    };
    public Handler getFollowersById = ctx -> {
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));
            List<Integer> followers = this.relationshipsService.serviceGetFollowersByUserId(id);
            Gson gson = new Gson();
            String jsonPost = gson.toJson(followers);
            ctx.result(jsonPost);
            ctx.status(201);
        } catch (IllegalArgumentException e) {
            ctx.result(e.getMessage());
            ctx.status(400);
        }
    };

    public Handler followByIds = ctx -> {
        try {
            Gson gson = new Gson();
            Map<String, Double> newFollow = gson.fromJson(ctx.body(), Map.class);
            boolean follow = this.relationshipsService.serviceFollowByIds(newFollow.get("userId").intValue(), newFollow.get("targetId").intValue());
            String jsonPost = gson.toJson(follow);
            ctx.result(jsonPost);
            ctx.status(201);
        } catch (Exception e) {
            ctx.result(e.getMessage());
            ctx.status(400);
        }
    };

    public Handler unfollowByIds = ctx -> {
        try {
            Gson gson = new Gson();
            Map<String, Double> newFollow = gson.fromJson(ctx.body(), Map.class);
            boolean unfollow = this.relationshipsService.serviceUnfollowByIds(newFollow.get("userId").intValue(), newFollow.get("targetId").intValue());
            String jsonPost = gson.toJson(unfollow);
            ctx.result(jsonPost);
            ctx.status(201);
        } catch (Exception e) {
            ctx.result(e.getMessage());
            ctx.status(400);
        }
    };
}

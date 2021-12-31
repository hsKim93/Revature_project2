package dev.chirp.app.controller.controllers;

import com.google.gson.Gson;
import dev.chirp.customexceptions.CommentNotFound;
import dev.chirp.entities.Comment;
import dev.chirp.service.interfaces.CommentService;
import io.javalin.http.Handler;

import java.util.List;


public class CommentController {
    CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    public Handler createComment = ctx ->{
        Gson gson = new Gson();
        Comment newComment = gson.fromJson(ctx.body(), Comment.class);
        Comment createdComment = this.commentService.serviceCreateComment(newComment);
        String createdCommentJSON = gson.toJson(createdComment);
        ctx.result(createdCommentJSON);
        ctx.status(201);
    };

    public Handler getCommentById = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        try{
            Comment comment = this.commentService.serviceGetCommentById(id);
            Gson gson = new Gson();
            String commentJSON = gson.toJson(comment);
            ctx.result(commentJSON);
            ctx.status(201);
        } catch (CommentNotFound e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };

    public Handler getCommentByPostId = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        try {
            List<Comment> comments = this.commentService.serviceGetCommentsByPostId(id);
            Gson gson = new Gson();
            String commentJSON = gson.toJson(comments);
            ctx.result(commentJSON);
            ctx.status(201);
        } catch (CommentNotFound e) {
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };

    public Handler getAllComments = ctx -> {
        List<Comment> comments = this.commentService.serviceGetAllComments();
        Gson gson = new Gson();
        String commentsJSONs = gson.toJson(comments);
        ctx.result(commentsJSONs);
        ctx.status(200);
    };

    public Handler deleteComment = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        try {
            boolean comment = this.commentService.serviceDeleteCommentById(id);
            Gson gson = new Gson();
            String commentJSON = gson.toJson(comment);
            ctx.result(commentJSON);
            ctx.status(201);
        } catch (CommentNotFound e) {
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };
}

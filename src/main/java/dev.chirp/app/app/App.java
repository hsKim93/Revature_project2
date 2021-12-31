package dev.chirp.app.app;

import dev.chirp.app.controller.AppController;
import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.enableDevLogging();
            config.enableCorsForAllOrigins();
        });

        AppController appController = new AppController();

        app.post("/comment/create", appController.commentController.createComment);
        app.get("/comment/commentId/{id}", appController.commentController.getCommentById);
        app.get("/comment/postId/{id}", appController.commentController.getCommentByPostId);
        app.get("/comments", appController.commentController.getAllComments);
        app.delete("/comment/commentId/{id}", appController.commentController.deleteComment);

        app.start();
    }
}

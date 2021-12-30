package dev.chirp.app.app;

import dev.chirp.app.controller.AppController;
import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.enableDevLogging();
        });

        AppController appController = new AppController();

        app.post("/post/create", appController.postController.createPost);
        app.get("/post/byPostId/{id}", appController.postController.getPostById);
        app.get("/post/byUserId/{id}", appController.postController.getPostsByUserId);
        app.get("/post/delete/{id}", appController.postController.deletePostById);
        app.get("/post/all", appController.postController.getAllPosts);

        app.start();

    }
}
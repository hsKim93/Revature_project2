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

//  Irfan
        app.post("/post/create", appController.postController.createPost);
        app.get("/post/byPostId/{id}", appController.postController.getPostById);
        app.get("/post/byUserId/{id}", appController.postController.getPostsByUserId);
        app.get("/post/delete/{id}", appController.postController.deletePostById);
        app.get("/post/all", appController.postController.getAllPosts);

        app.get("post/likes/{id}", appController.relationshipsController.getLikesByPostById);
        app.post("post/like",appController.relationshipsController.likeByIds);
        app.post("post/unlike",appController.relationshipsController.unlikeByIds);
        app.get("/following/{id}",appController.relationshipsController.getFollowingById);
        app.get("/followers/{id}",appController.relationshipsController.getFollowersById);
        app.post("/follow", appController.relationshipsController.followByIds);
        app.post("/unfollow", appController.relationshipsController.unfollowByIds);
        
//  Hyungsuk
        app.post("/login", appController.userController.requestLogin);
        app.post("/user", appController.userController.createAccount);
        app.get("/user/{id}", appController.userController.getUserById);
        app.get("/search/{firstName}", appController.userController.getUsersByFirstName);
        app.patch("/user/{id}", appController.userController.editUserInformationById);
        app.delete("/user/{id}", appController.userController.deleteUserById);

        app.start();
    }
}


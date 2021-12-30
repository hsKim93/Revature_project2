package dev.chirp.app.controller;

import dev.chirp.app.controller.controllers.PostController;
import dev.chirp.app.controller.controllers.RelationshipsController;
import dev.chirp.service.implementations.PostService;
import dev.chirp.service.implementations.RelationshipsService;
import dev.chirp.app.controller.controllers.UserController;

public class AppController {
//   Irfan
    public PostService postService = new PostService();
    public RelationshipsService relationshipsService = new RelationshipsService();

    public RelationshipsController relationshipsController = new RelationshipsController(relationshipsService);
    public PostController postController = new PostController(postService);
//   Hyungsuk
    public UserController userController = new UserController();
}
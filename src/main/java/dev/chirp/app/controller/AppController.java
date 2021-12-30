package dev.chirp.app.controller;

import dev.chirp.app.controller.controllers.PostController;
import dev.chirp.app.controller.controllers.RelationshipsController;
import dev.chirp.service.implementations.PostService;
import dev.chirp.service.implementations.RelationshipsService;

public class AppController {
    public PostService postService = new PostService();
    public RelationshipsService relationshipsService = new RelationshipsService();

    public RelationshipsController relationshipsController = new RelationshipsController(relationshipsService);
    public PostController postController = new PostController(postService);
}
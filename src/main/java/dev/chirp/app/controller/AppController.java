package dev.chirp.app.controller;

import dev.chirp.app.controller.controllers.PostController;
import dev.chirp.service.implementations.PostService;

public class AppController {
    public PostService postService = new PostService();
    public PostController postController = new PostController(postService);
}
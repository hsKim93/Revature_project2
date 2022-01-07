package dev.chirp.app.controller;

import dev.chirp.app.controller.controllers.CommentController;
import dev.chirp.app.controller.controllers.PostController;
import dev.chirp.app.controller.controllers.RelationshipsController;
import dev.chirp.app.controller.controllers.UserController;
import dev.chirp.dao.implementations.CommentDAO;
import dev.chirp.dao.implementations.UserDAO;
import dev.chirp.service.implementations.CommentService;
import dev.chirp.service.implementations.PostService;
import dev.chirp.service.implementations.RelationshipsService;
import dev.chirp.service.implementations.UserService;


public class AppController {
    //   Irfan
    public PostService postService = new PostService();
    public RelationshipsService relationshipsService = new RelationshipsService();
    public RelationshipsController relationshipsController = new RelationshipsController(relationshipsService);
    public PostController postController = new PostController(postService);
    //   Hyungsuk
    public UserController userController = new UserController(new UserService(new UserDAO()));
    // Loc
    public CommentDAO commentDAO = new CommentDAO();
    public CommentService commentService = new CommentService(commentDAO);
    public CommentController commentController = new CommentController(commentService);
}

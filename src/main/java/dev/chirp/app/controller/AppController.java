package dev.chirp.app.controller;

import dev.chirp.app.controller.controllers.*;
import dev.chirp.dao.implementations.CommentDAO;
import dev.chirp.dao.implementations.PostDAO;
import dev.chirp.dao.implementations.RelationshipsDAO;
import dev.chirp.dao.implementations.UserDAO;
import dev.chirp.dao.interfaces.CommentDAOInt;
import dev.chirp.service.implementations.CommentServiceImp;
import dev.chirp.service.implementations.PostService;
import dev.chirp.service.implementations.RelationshipsService;
import dev.chirp.service.implementations.UserService;
import dev.chirp.service.interfaces.CommentService;

public class AppController {
   //   Hyungsuk
    public UserController userController = new UserController(new UserService(new UserDAO()));
    // Loc
    public CommentDAOInt commentDAO = new CommentDAO();
    public CommentService commentService = new CommentServiceImp(commentDAO);
    public CommentController commentController = new CommentController(commentService);
    //   Irfan
    public RelationshipsController relationshipsController = new RelationshipsController(new RelationshipsService(new RelationshipsDAO()));
    public PostController postController = new PostController(new PostService(new PostDAO()));
    public MixedController mixedController = new MixedController(
            new PostService(new PostDAO()),
            new UserService(new UserDAO()),
            commentService,
            new RelationshipsService(new RelationshipsDAO()));

}

package dev.chirp.app.controller;

import dev.chirp.app.controller.controllers.*;
import dev.chirp.dao.implementations.CommentDAOImp;
import dev.chirp.dao.implementations.UserDAO;
import dev.chirp.dao.interfaces.CommentDAO;
import dev.chirp.service.implementations.CommentServiceImp;
import dev.chirp.service.implementations.PostService;
import dev.chirp.service.implementations.RelationshipsService;
import dev.chirp.service.implementations.UserService;
import dev.chirp.service.interfaces.CommentService;

public class AppController {
    // Loc
    public CommentDAO commentDAO = new CommentDAOImp();
    public CommentService commentService = new CommentServiceImp(commentDAO);
    public CommentController commentController = new CommentController(commentService);
    //   Irfan
    public PostService postService = new PostService();
    public RelationshipsService relationshipsService = new RelationshipsService();
    public RelationshipsController relationshipsController = new RelationshipsController(relationshipsService);
    public PostController postController = new PostController(postService);
    public MixedController mixedController = new MixedController(postService,new UserService(new UserDAO()),commentService,relationshipsService);


    //   Hyungsuk
    public UserController userController = new UserController(new UserService(new UserDAO()));

}

package dev.chirp.app.controller;


import dev.chirp.app.controller.controllers.CommentController;
import dev.chirp.dao.implementations.CommentDAOImp;
import dev.chirp.dao.interfaces.CommentDAO;
import dev.chirp.service.implementations.CommentServiceImp;
import dev.chirp.service.interfaces.CommentService;

public class AppController {
    public CommentDAO commentDAO = new CommentDAOImp();
    public CommentService commentService = new CommentServiceImp(commentDAO);
    public CommentController commentController = new CommentController(commentService);
}

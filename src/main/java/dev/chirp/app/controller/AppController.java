package chirp.app.controller;


import chirp.app.controller.controllers.CommentController;
import chirp.dao.implementations.CommentDAOImp;
import chirp.dao.interfaces.CommentDAO;
import chirp.service.implementations.CommentServiceImp;
import chirp.service.interfaces.CommentService;

public class AppController {
    public CommentDAO commentDAO = new CommentDAOImp();
    public CommentService commentService = new CommentServiceImp(commentDAO);
    public CommentController commentController = new CommentController(commentService);
}

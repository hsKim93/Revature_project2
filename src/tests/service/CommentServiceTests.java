package service;

import dev.chirp.customexceptions.InvalidInputException;
import dev.chirp.dao.implementations.CommentDAO;
import dev.chirp.entities.Comment;
import dev.chirp.service.implementations.CommentServiceImp;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class CommentServiceTests {
    public CommentDAO commentDAO;
    public CommentServiceImp commentService;


}

package service;

import dev.chirp.dao.implementations.CommentDAOImp;
import dev.chirp.dao.interfaces.CommentDAO;
import dev.chirp.service.implementations.CommentServiceImp;
import dev.chirp.service.interfaces.CommentService;
import org.testng.annotations.Test;


public class CommentServiceTests {
    static CommentDAO commentDAO = new CommentDAOImp();
    static CommentService commentService = new CommentServiceImp(commentDAO);

    @Test
    void noneRightNow() {
        return null;
    }
}

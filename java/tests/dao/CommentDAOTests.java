package tests.dao;

import dev.chirp.dao.implementations.CommentDAOImp;
import dev.chirp.dao.interfaces.CommentDAO;
import dev.chirp.entities.Comment;
import org.testng.Assert;

public class CommentDAOTests {

    CommentDAO commentDAO = new CommentDAOImp();

    @Test
    void selectCommentById() {
        Comment comment = commentDAO.getCommentById(1);
        Assert.assertEquals(comment.getCommentByID(), 1);
    }
}

package dao;

import dev.chirp.dao.implementations.RelationshipsDAO;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RelationshipsDAOTests {
    RelationshipsDAO relationshipsDAO = new RelationshipsDAO();

    @Test
    void getLikesByPostId(){
        int likeNumber = relationshipsDAO.getLikesByPostId(2);
        Assert.assertTrue(likeNumber > 1);
    }

    @Test
    void likeByIds(){
        boolean liked = relationshipsDAO.likeByIds(1,2);
        Assert.assertTrue(liked);
    }
    @Test
    void unlikeByIds(){
        boolean unliked = relationshipsDAO.unlikeByIds(1,2);
        Assert.assertTrue(unliked);
    }
    @Test
    void getFollowingByUserId(){
        List<Integer> following = relationshipsDAO.getFollowingByUserId(1);
        Assert.assertTrue(following.size() > 1);
    }
    @Test
    void getFollowersByUserId(){
        List<Integer> followers = relationshipsDAO.getFollowersByUserId(1);
        Assert.assertTrue(followers.size() > 1);
    }
    @Test
    void followByIds(){
        boolean follow = relationshipsDAO.followByIds(1,2);
        Assert.assertTrue(follow);
    }
    @Test
    void unfollowByIds(){
        boolean unfollow = relationshipsDAO.unfollowByIds(1,2);
        Assert.assertTrue(unfollow);
    }

}

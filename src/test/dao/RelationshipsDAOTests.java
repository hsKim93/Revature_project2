package dao;

import dev.chirp.dao.implementations.RelationshipsDAO;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RelationshipsDAOTests {
    RelationshipsDAO relationshipsDAO = new RelationshipsDAO();




    @Test
    void likeByIds() {
        boolean unliked = relationshipsDAO.unlikeByIds(8001, 8000);
        Assert.assertTrue(unliked);
    }

    @Test
    void getLikesByPostId() {
        int likeNumber = relationshipsDAO.getLikesByPostId(8000);
        Assert.assertTrue(likeNumber > 0);
    }
    @Test
    void likeByIdsNonExistingUserId() {
        boolean liked = relationshipsDAO.likeByIds(0, 8000);
        Assert.assertFalse(liked);
    }

    @Test
    void getLikesByNonExistingPostId() {
        int likeNumber = relationshipsDAO.getLikesByPostId(0);
        Assert.assertEquals(likeNumber, 0);
    }

    @Test
    void likeByIdsNonExistingPostId() {
        boolean liked = relationshipsDAO.likeByIds(8000, 0);
        Assert.assertFalse(liked);
    }

    @Test
    void unlikeByIds() {
        boolean unliked = relationshipsDAO.unlikeByIds(8003, 8000);
        Assert.assertTrue(unliked);
    }

    @Test
    void unlikeByIdsNonExistingUserId() {
        boolean unliked = relationshipsDAO.unlikeByIds(0, 8001);
        Assert.assertFalse(unliked);
    }

    @Test
    void unlikeByIdsNonExistingPostId() {
        boolean unliked = relationshipsDAO.unlikeByIds(8000, 0);
        Assert.assertFalse(unliked);
    }
    @Test
    void followByIds() {
        boolean follow = relationshipsDAO.followByIds(8000, 8001);
        Assert.assertTrue(follow);
    }

    @Test
    void getFollowingByUserId() {
        List<Integer> following = relationshipsDAO.getFollowingByUserId(8000);
        Assert.assertTrue(following.size() > 0);
    }

    @Test
    void getFollowingByNonExistingUserId() {
        List<Integer> following = relationshipsDAO.getFollowingByUserId(0);
        Assert.assertEquals(following.size(), 0);
    }

    @Test
    void getFollowersByUserId() {
        List<Integer> followers = relationshipsDAO.getFollowersByUserId(8000);
        Assert.assertTrue(followers.size() > 0);
    }

    @Test
    void getFollowersByNonExistingUserId() {
        List<Integer> followers = relationshipsDAO.getFollowersByUserId(0);
        Assert.assertEquals(followers.size(), 0);
    }


    @Test
    void followByIdsNonExistingMyId() {
        boolean follow = relationshipsDAO.followByIds(0, 8003);
        Assert.assertFalse(follow);
    }

    @Test
    void followByIdsNonExistingTargetId() {
        boolean follow = relationshipsDAO.followByIds(8000, 0);
        Assert.assertFalse(follow);
    }

    @Test
    void unfollowByIds() {
        boolean unfollow = relationshipsDAO.unfollowByIds(8003, 8000);
        Assert.assertTrue(unfollow);
    }

    @Test
    void unfollowByIdsNonExistingMyId() {
        boolean unfollow = relationshipsDAO.unfollowByIds(0, 8003);
        Assert.assertFalse(unfollow);
    }

    @Test
    void unfollowByIdsNonExistingTargetId() {
        boolean unfollow = relationshipsDAO.unfollowByIds(8000, 0);
        Assert.assertFalse(unfollow);
    }

}

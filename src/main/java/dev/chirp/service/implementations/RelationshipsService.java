package dev.chirp.service.implementations;

import dev.chirp.dao.implementations.RelationshipsDAO;
import dev.chirp.service.interfaces.RelationshipsServiceInt;

import java.util.List;

public class RelationshipsService implements RelationshipsServiceInt {

    RelationshipsDAO relationshipsDAO = new RelationshipsDAO();

    @Override
    public int serviceGetLikesByPostId(int postId) {
        return this.relationshipsDAO.getLikesByPostId(postId);
    }

    @Override
    public boolean serviceLikeByIds(int userId, int postId) {
        return this.relationshipsDAO.likeByIds(userId,postId);
    }

    @Override
    public boolean serviceUnlikeByIds(int userId, int postId) {
        return this.relationshipsDAO.unlikeByIds(userId,postId);
    }

    @Override
    public List<Integer> serviceGetFollowingByUserId(int userId) {
        return this.relationshipsDAO.getFollowingByUserId(userId);
    }

    @Override
    public List<Integer> serviceGetFollowersByUserId(int userId) {
        return this.relationshipsDAO.getFollowersByUserId(userId);
    }

    @Override
    public boolean serviceFollowByIds(int myId, int targetId) {
        return this.relationshipsDAO.followByIds(myId,targetId);
    }

    @Override
    public boolean serviceUnfollowByIds(int myId, int targetId) {
        return this.relationshipsDAO.unfollowByIds(myId, targetId);
    }
}

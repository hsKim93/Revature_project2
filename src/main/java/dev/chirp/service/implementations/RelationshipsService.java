package dev.chirp.service.implementations;

import dev.chirp.customexceptions.InvalidInputException;
import dev.chirp.dao.implementations.RelationshipsDAO;
import dev.chirp.service.interfaces.RelationshipsServiceInt;

import java.util.List;

public class RelationshipsService implements RelationshipsServiceInt {

    RelationshipsDAO relationshipsDAO;

    public RelationshipsService(RelationshipsDAO relationshipsDAO) {
        this.relationshipsDAO = relationshipsDAO;
    }

    @Override
    public int serviceGetLikesByPostId(int postId) {
        if (postId <= 0) {
            throw new InvalidInputException();
        }
        return this.relationshipsDAO.getLikesByPostId(postId);
    }

    @Override
    public boolean serviceLikeByIds(int userId, int postId) {
        if (postId <= 0 || userId <= 0) {
            throw new InvalidInputException();
        }
        return this.relationshipsDAO.likeByIds(userId, postId);
    }

    @Override
    public boolean serviceUnlikeByIds(int userId, int postId) {
        if (postId <= 0 || userId <= 0) {
            throw new InvalidInputException();
        }
        return this.relationshipsDAO.unlikeByIds(userId, postId);
    }

    @Override
    public List<Integer> serviceGetFollowingByUserId(int userId) {
        if (userId <= 0) {
            throw new InvalidInputException();
        }
        return this.relationshipsDAO.getFollowingByUserId(userId);
    }

    @Override
    public List<Integer> serviceGetFollowersByUserId(int userId) {
        if (userId <= 0) {
            throw new InvalidInputException();
        }
        return this.relationshipsDAO.getFollowersByUserId(userId);
    }

    @Override
    public boolean serviceFollowByIds(int myId, int targetId) {
        if (myId <= 0 || targetId <= 0) {
            throw new InvalidInputException();
        }
        return this.relationshipsDAO.followByIds(myId, targetId);
    }

    @Override
    public boolean serviceUnfollowByIds(int myId, int targetId) {
        if (myId <= 0 || targetId <= 0) {
            throw new InvalidInputException();
        }
        return this.relationshipsDAO.unfollowByIds(myId, targetId);
    }
}

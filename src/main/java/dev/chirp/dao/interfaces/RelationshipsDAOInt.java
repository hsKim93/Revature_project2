package dev.chirp.dao.interfaces;

import java.util.List;

public interface RelationshipsDAOInt {

    int getLikesByPostId(int postId);

    boolean likeByIds(int userId, int postId);

    boolean unlikeByIds(int userId, int postId);

    List<Integer> getFollowingByUserId(int userId);

    List<Integer> getFollowersByUserId(int userId);

    boolean followByIds(int myId, int targetId);

    boolean unfollowByIds(int myId, int targetId);
}

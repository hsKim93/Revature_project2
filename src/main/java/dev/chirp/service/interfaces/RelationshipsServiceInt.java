package dev.chirp.service.interfaces;

import java.util.List;

public interface RelationshipsServiceInt {

    int serviceGetLikesByPostId(int postId);

    boolean serviceLikeByIds(int userId, int postId);

    boolean serviceUnlikeByIds(int userId, int postId);

    List<Integer> serviceGetFollowingByUserId(int userId);

    List<Integer> serviceGetFollowersByUserId(int userId);

    boolean serviceFollowByIds(int myId, int targetId);

    boolean serviceUnfollowByIds(int myId, int targetId);
}

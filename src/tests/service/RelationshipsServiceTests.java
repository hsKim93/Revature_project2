package service;

import dev.chirp.customexceptions.InvalidInputException;
import dev.chirp.dao.implementations.RelationshipsDAO;
import dev.chirp.service.implementations.RelationshipsService;
import org.mockito.Mockito;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RelationshipsServiceTests {
    RelationshipsDAO relationshipsDAO;
    RelationshipsService relationshipsService;

    @BeforeClass
    void setup() {
        relationshipsDAO = Mockito.mock(RelationshipsDAO.class);
        relationshipsService = new RelationshipsService(relationshipsDAO);
    }

    int negativeId = -1;
    int positiveId = 1;

    /**
     * TESTING VALID AND INVALID INPUTS FOR serviceLikeByIds
     **/

    @Test()
    void serviceLikeByIdsValid() {
        Mockito.when(relationshipsDAO.likeByIds(positiveId, positiveId)).thenReturn(true);
        relationshipsService.serviceLikeByIds(positiveId, positiveId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceLikeByIdsNegativeUserId() {
        Mockito.when(relationshipsDAO.likeByIds(negativeId, positiveId)).thenReturn(true);
        relationshipsService.serviceLikeByIds(negativeId, positiveId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceLikeByIdsNegativePostId() {
        Mockito.when(relationshipsDAO.likeByIds(positiveId, negativeId)).thenReturn(true);
        relationshipsService.serviceLikeByIds(positiveId, negativeId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceLikeByIdsNegativeIds() {
        Mockito.when(relationshipsDAO.likeByIds(negativeId, negativeId)).thenReturn(true);
        relationshipsService.serviceLikeByIds(negativeId, negativeId);
    }

    /**
     * TESTING VALID AND INVALID INPUTS FOR serviceUnlikeByIds
     **/

    @Test()
    void serviceUnlikeByIdsValid() {
        Mockito.when(relationshipsDAO.unlikeByIds(positiveId, positiveId)).thenReturn(true);
        relationshipsService.serviceUnlikeByIds(positiveId, positiveId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceUnlikeByIdsNegativeUserId() {
        Mockito.when(relationshipsDAO.unlikeByIds(negativeId, positiveId)).thenReturn(true);
        relationshipsService.serviceUnlikeByIds(negativeId, positiveId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceUnlikeByIdsNegativePostId() {
        Mockito.when(relationshipsDAO.unlikeByIds(positiveId, negativeId)).thenReturn(true);
        relationshipsService.serviceUnlikeByIds(positiveId, negativeId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceUnlikeByIdsNegativeIds() {
        Mockito.when(relationshipsDAO.unlikeByIds(negativeId, negativeId)).thenReturn(true);
        relationshipsService.serviceUnlikeByIds(negativeId, negativeId);
    }


    /**
     * TESTING VALID AND INVALID INPUTS FOR serviceGetFollowingByUserId
     **/

    @Test()
    void serviceGetFollowingByUserIdValid() {
        List<Integer> userIdList = new ArrayList<>();
        Mockito.when(relationshipsDAO.getFollowingByUserId(positiveId)).thenReturn(userIdList);
        relationshipsService.serviceGetFollowingByUserId(positiveId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceGetFollowingByUserIdNegativeUserId() {
        List<Integer> userIdList = new ArrayList<>();
        Mockito.when(relationshipsDAO.getFollowingByUserId(negativeId)).thenReturn(userIdList);
        relationshipsService.serviceGetFollowingByUserId(negativeId);
    }

    /**
     * TESTING VALID AND INVALID INPUTS FOR serviceGetFollowersByUserId
     **/

    @Test()
    void serviceGetFollowersByUserIdValid() {
        List<Integer> userIdList = new ArrayList<>();
        Mockito.when(relationshipsDAO.getFollowersByUserId(positiveId)).thenReturn(userIdList);
        relationshipsService.serviceGetFollowersByUserId(positiveId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceGetFollowersByUserIdNegativeUserId() {
        List<Integer> userIdList = new ArrayList<>();
        Mockito.when(relationshipsDAO.getFollowersByUserId(negativeId)).thenReturn(userIdList);
        relationshipsService.serviceGetFollowersByUserId(negativeId);
    }

    /**
     * TESTING VALID AND INVALID INPUTS FOR serviceFollowByIds
     **/

    @Test()
    void serviceFollowByIdsValid() {
        Mockito.when(relationshipsDAO.followByIds(positiveId, positiveId)).thenReturn(true);
        relationshipsService.serviceFollowByIds(positiveId, positiveId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceFollowByIdsNegativeMyId() {
        Mockito.when(relationshipsDAO.followByIds(negativeId, positiveId)).thenReturn(true);
        relationshipsService.serviceFollowByIds(negativeId, positiveId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceFollowByIdsNegativeTargetId() {
        Mockito.when(relationshipsDAO.followByIds(positiveId, negativeId)).thenReturn(true);
        relationshipsService.serviceFollowByIds(positiveId, negativeId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceFollowByIdsNegativeIds() {
        Mockito.when(relationshipsDAO.followByIds(negativeId, negativeId)).thenReturn(true);
        relationshipsService.serviceFollowByIds(negativeId, negativeId);
    }

    /**
     * TESTING VALID AND INVALID INPUTS FOR serviceUnfollowByIds
     **/

    @Test()
    void serviceUnfollowByIdsValid() {
        Mockito.when(relationshipsDAO.unfollowByIds(positiveId, positiveId)).thenReturn(true);
        relationshipsService.serviceUnfollowByIds(positiveId, positiveId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceUnfollowByIdsNegativeMyId() {
        Mockito.when(relationshipsDAO.unfollowByIds(negativeId, positiveId)).thenReturn(true);
        relationshipsService.serviceUnfollowByIds(negativeId, positiveId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceUnfollowByIdsNegativeTargetId() {
        Mockito.when(relationshipsDAO.unfollowByIds(positiveId, negativeId)).thenReturn(true);
        relationshipsService.serviceUnfollowByIds(positiveId, negativeId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceUnfollowByIdsNegativeIds() {
        Mockito.when(relationshipsDAO.unfollowByIds(negativeId, negativeId)).thenReturn(true);
        relationshipsService.serviceUnfollowByIds(negativeId, negativeId);
    }
}


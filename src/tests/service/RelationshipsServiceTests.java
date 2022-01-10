package service;

import dev.chirp.customexceptions.InvalidInputException;
import dev.chirp.dao.implementations.RelationshipsDAO;
import dev.chirp.service.implementations.RelationshipsService;
import org.mockito.Mockito;
import org.testng.Assert;
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
        Assert.assertTrue(relationshipsService.serviceLikeByIds(positiveId, positiveId));
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceLikeByIdsNegativeUserId() {
        relationshipsService.serviceLikeByIds(negativeId, positiveId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceLikeByIdsNegativePostId() {
        relationshipsService.serviceLikeByIds(positiveId, negativeId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceLikeByIdsNegativeIds() {
        relationshipsService.serviceLikeByIds(negativeId, negativeId);
    }

    /**
     * TESTING VALID AND INVALID INPUTS FOR serviceUnlikeByIds
     **/

    @Test()
    void serviceUnlikeByIdsValid() {
        Mockito.when(relationshipsDAO.unlikeByIds(positiveId, positiveId)).thenReturn(true);
        Assert.assertTrue(relationshipsService.serviceUnlikeByIds(positiveId, positiveId));
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceUnlikeByIdsNegativeUserId() {
        relationshipsService.serviceUnlikeByIds(negativeId, positiveId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceUnlikeByIdsNegativePostId() {
        relationshipsService.serviceUnlikeByIds(positiveId, negativeId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceUnlikeByIdsNegativeIds() {
        relationshipsService.serviceUnlikeByIds(negativeId, negativeId);
    }


    /**
     * TESTING VALID AND INVALID INPUTS FOR serviceGetFollowingByUserId
     **/

    @Test()
    void serviceGetFollowingByUserIdValid() {
        List<Integer> userIdList = new ArrayList<>();
        Mockito.when(relationshipsDAO.getFollowingByUserId(positiveId)).thenReturn(userIdList);
        Assert.assertEquals(relationshipsService.serviceGetFollowingByUserId(positiveId),userIdList);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceGetFollowingByUserIdNegativeUserId() {
        relationshipsService.serviceGetFollowingByUserId(negativeId);
    }

    /**
     * TESTING VALID AND INVALID INPUTS FOR serviceGetFollowersByUserId
     **/

    @Test()
    void serviceGetFollowersByUserIdValid() {
        List<Integer> userIdList = new ArrayList<>();
        Mockito.when(relationshipsDAO.getFollowersByUserId(positiveId)).thenReturn(userIdList);
        Assert.assertEquals(relationshipsService.serviceGetFollowersByUserId(positiveId),userIdList);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceGetFollowersByUserIdNegativeUserId() {
        relationshipsService.serviceGetFollowersByUserId(negativeId);
    }

    /**
     * TESTING VALID AND INVALID INPUTS FOR serviceFollowByIds
     **/

    @Test()
    void serviceFollowByIdsValid() {
        Mockito.when(relationshipsDAO.followByIds(positiveId, positiveId)).thenReturn(true);
        Assert.assertTrue(relationshipsService.serviceFollowByIds(positiveId, positiveId));
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceFollowByIdsNegativeMyId() {
        relationshipsService.serviceFollowByIds(negativeId, positiveId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceFollowByIdsNegativeTargetId() {
        relationshipsService.serviceFollowByIds(positiveId, negativeId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceFollowByIdsNegativeIds() {
        relationshipsService.serviceFollowByIds(negativeId, negativeId);
    }

    /**
     * TESTING VALID AND INVALID INPUTS FOR serviceUnfollowByIds
     **/

    @Test()
    void serviceUnfollowByIdsValid() {
        Mockito.when(relationshipsDAO.unfollowByIds(positiveId, positiveId)).thenReturn(true);
        Assert.assertTrue(relationshipsService.serviceUnfollowByIds(positiveId, positiveId));
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceUnfollowByIdsNegativeMyId() {
        relationshipsService.serviceUnfollowByIds(negativeId, positiveId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceUnfollowByIdsNegativeTargetId() {
        relationshipsService.serviceUnfollowByIds(positiveId, negativeId);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceUnfollowByIdsNegativeIds() {
        relationshipsService.serviceUnfollowByIds(negativeId, negativeId);
    }
}


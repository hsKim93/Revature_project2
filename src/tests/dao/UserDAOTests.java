package dao;

import dev.chirp.dao.implementations.UserDAO;
import dev.chirp.entities.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class UserDAOTests {

    UserDAO userDAO = new UserDAO();

    /**
     * requestLogin
     */

    String correct_id = "test";
    String correct_pw = "pw";
    String incorrect_id = "tes";
    String incorrect_pw = "pww";

    @Test
    void testRequestLoginSuccess() {
        User user = userDAO.requestLogin(correct_id, correct_pw);
        Assert.assertEquals(user.getUserName(), correct_id);
    }

    @Test
    void testRequestLoginIncorrectCredentialsCase1() {
        Assert.assertNull(userDAO.requestLogin(incorrect_id, incorrect_pw));
    }

    @Test
    void testRequestLoginIncorrectCredentialsCase2() {
        Assert.assertNull(userDAO.requestLogin(correct_id, incorrect_pw));
    }

    @Test
    void testRequestLoginIncorrectCredentialsCase3() {
        Assert.assertNull(userDAO.requestLogin(incorrect_id, correct_pw));
    }

    /**
     * createAccount
     */

    String userName = "test1";
    String password = "test123";
    String firstName = "tester";
    String lastName = "the tester";
    String email = "test@test.net";
    String existingUserName = "test";
    String existingEmail = "test@test.com";
    @Test(priority = 1)
    void testCreateAccountSuccess() {
        User user = userDAO.createAccount(userName, password, firstName, lastName, email);
        String[] actual = {
                user.getUserName(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        };
        String[] expected = {
                userName,
                firstName,
                lastName,
                email
        };
        Assert.assertEquals(actual, expected);
    }

    @Test
    void testCreateAccountExistingEmail() {
        Assert.assertNull(userDAO.createAccount(existingUserName, password, firstName, lastName, email));
    }

    @Test
    void testCreateAccountExistingUserName() {
        Assert.assertNull(userDAO.createAccount(userName, password, firstName, lastName, existingEmail));
    }

    /**
     * getUserById
     */

    int existingId = 9000;
    int nonExistingId = 1232141214;

    @Test
    void testGetUserByIdSuccess() {
        User user = userDAO.getUserById(existingId);
        Assert.assertEquals(user.getUserId(), existingId);
    }

    @Test
    void testGetUserByIdNonExistingId() {
        Assert.assertNull(userDAO.getUserById(nonExistingId));
    }

    /**
     * getUserByFirstName
     */

    String existingFirstName = "test";
    String nonExistingFirstName = "agsdhjqpowerjt1";

    @Test
    void testGetUsersByFirstNameSuccess() {
        ArrayList<User> users = userDAO.getUsersByFirstName(existingFirstName);
        for (User user : users) {
            if (!user.getFirstName().equals(existingFirstName)) {
                Assert.fail();
            }
        }
        Assert.assertTrue(true);
    }

    @Test
    void testGetUsersByFirstNameNonExistingFirstName() {
        Assert.assertNull(userDAO.getUsersByFirstName(nonExistingFirstName));
    }

    /**
     * editUserInformationById
     */

    int toBeEditedId = 9001;
    String newUserName = "";
    String newPassword = "editor";
    String newFirstName = "tester";
    String newLastName = "the editor";
    String newEmail = "edited@successfully.net";

    @Test
    void testEditUserInformationByIdSuccess() {
        User user = userDAO.editUserInformationById(
                toBeEditedId,
                newUserName,
                newPassword,
                newFirstName,
                newLastName,
                newEmail
        );
        String[] actual = {
                user.getUserName(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        };
        String[] expected = {
                newUserName,
                newFirstName,
                newLastName,
                newEmail
        };
        Assert.assertEquals(actual, expected);
    }

    @Test
    void testEditUserInformationByIdExistingName() {
        Assert.assertNull(userDAO.editUserInformationById(
                toBeEditedId,
                existingUserName,
                newPassword,
                newFirstName,
                newLastName,
                newEmail
        ));
    }

    @Test
    void testEditUserInformationByIdExistingEmail() {
        Assert.assertNull(userDAO.editUserInformationById(
                toBeEditedId,
                newUserName,
                newPassword,
                newFirstName,
                newLastName,
                existingEmail
        ));
    }

    @Test
    void testEditUserInformationByIdNonExistingId() {
        Assert.assertNull(userDAO.editUserInformationById(
                nonExistingId,
                newUserName,
                newPassword,
                newFirstName,
                newLastName,
                newEmail
        ));
    }

    /**
     * deleteUserById
     */

    int toBeDeletedId = 9002;
    @Test(priority = 2)
    void testDeleteUserByIdSuccess() {
        User user = userDAO.deleteUserById(toBeDeletedId);
        Assert.assertEquals(user.getUserId(), toBeDeletedId);
    }

    @Test
    void testDeleteUserByIdNonExistingId() {
        Assert.assertNull(userDAO.deleteUserById(nonExistingId));
    }
}











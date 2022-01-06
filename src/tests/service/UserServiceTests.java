package service;

import dev.chirp.customexceptions.InvalidInputException;
import dev.chirp.dao.implementations.UserDAO;
import dev.chirp.service.implementations.UserService;
import org.mockito.Mockito;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserServiceTests {

    public UserDAO userDAO;
    public UserService userService;

    @BeforeClass
    public void setup() {
        userDAO = Mockito.mock(UserDAO.class);
        userService = new UserService(userDAO);
    }

    String longStr = "abcdefghijklmnopqrstuvwxyz";
    String validStr = "abc";
    String emptyStr = "";
    int invalidId = -1;
    int validId = 0;
    String longEmail = "01234567890123456789012345678901234567890";

    /**
     * serviceRequestLogin
     */

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceRequestLoginLongUserName() {
        Mockito.when(userDAO.requestLogin(longStr, validStr)).thenThrow(InvalidInputException.class);
        userService.serviceRequestLogin(longStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceRequestLoginLongPassword() {
        Mockito.when(userDAO.requestLogin(validStr, longStr)).thenThrow(InvalidInputException.class);
        userService.serviceRequestLogin(validStr, longStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceRequestLoginLongUserNameAndPassword() {
        Mockito.when(userDAO.requestLogin(longStr, longStr)).thenThrow(InvalidInputException.class);
        userService.serviceRequestLogin(longStr, longStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceRequestLoginEmptyUserName() {
        Mockito.when(userDAO.requestLogin(emptyStr, validStr)).thenThrow(InvalidInputException.class);
        userService.serviceRequestLogin(emptyStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceRequestLoginEmptyPassword() {
        Mockito.when(userDAO.requestLogin(validStr, emptyStr)).thenThrow(InvalidInputException.class);
        userService.serviceRequestLogin(validStr, emptyStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceRequestLoginEmptyUserNameAndPassword() {
        Mockito.when(userDAO.requestLogin(emptyStr, emptyStr)).thenThrow(InvalidInputException.class);
        userService.serviceRequestLogin(emptyStr, emptyStr);

    }

    /**
     * serviceCreateAccount
     */

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceCreateAccountLongUserName() {
        Mockito.when(userDAO.createAccount(longStr, validStr, validStr, validStr, validStr))
                .thenThrow(InvalidInputException.class);
        userService.serviceCreateAccount(longStr, validStr, validStr, validStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceCreateAccountLongPassword() {
        Mockito.when(userDAO.createAccount(validStr, longStr, validStr, validStr, validStr))
                .thenThrow(InvalidInputException.class);
        userService.serviceCreateAccount(validStr, longStr, validStr, validStr, validStr);

    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceCreateAccountLongFirstName() {
        Mockito.when(userDAO.createAccount(validStr, validStr, longStr, validStr, validStr))
                .thenThrow(InvalidInputException.class);
        userService.serviceCreateAccount(validStr, validStr, longStr, validStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceCreateAccountLongLastName() {
        Mockito.when(userDAO.createAccount(validStr, validStr, validStr, longStr, validStr))
                .thenThrow(InvalidInputException.class);
        userService.serviceCreateAccount(validStr, validStr, validStr, longStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceCreateAccountLongEmail() {
        Mockito.when(userDAO.createAccount(validStr, validStr, validStr, validStr, longEmail))
                .thenThrow(InvalidInputException.class);
        userService.serviceCreateAccount(validStr, validStr, validStr, validStr, longEmail);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceCreateAccountEmptyUserName() {
        Mockito.when(userDAO.createAccount(emptyStr, validStr, validStr, validStr, validStr))
                .thenThrow(InvalidInputException.class);
        userService.serviceCreateAccount(emptyStr, validStr, validStr, validStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceCreateAccountEmptyPassword() {
        Mockito.when(userDAO.createAccount(validStr, emptyStr, validStr, validStr, validStr))
                .thenThrow(InvalidInputException.class);
        userService.serviceCreateAccount(validStr, emptyStr, validStr, validStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceCreateAccountEmptyFirstName() {
        Mockito.when(userDAO.createAccount(validStr, validStr, emptyStr, validStr, validStr))
                .thenThrow(InvalidInputException.class);
        userService.serviceCreateAccount(validStr, validStr, emptyStr, validStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceCreateAccountEmptyLastName() {
        Mockito.when(userDAO.createAccount(validStr, validStr, validStr, emptyStr, validStr))
                .thenThrow(InvalidInputException.class);
        userService.serviceCreateAccount(validStr, validStr, validStr, emptyStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceCreateAccountEmptyEmail() {
        Mockito.when(userDAO.createAccount(validStr, validStr, validStr, validStr, emptyStr))
                .thenThrow(InvalidInputException.class);
        userService.serviceCreateAccount(validStr, validStr, validStr, validStr, emptyStr);
    }

    /**
     * serviceGetUserById
     */

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceGetUserByIdNegativeId() {
        Mockito.when(userDAO.getUserById(invalidId)).thenThrow(InvalidInputException.class);
        userService.serviceGetUserById(invalidId);
    }

    /**
     * serviceGetUsersByFirstName
     */

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceGetUserByFirstNameLongFirstName() {
        Mockito.when(userDAO.getUsersByFirstName(longStr)).thenThrow(InvalidInputException.class);
        userService.serviceGetUsersByFirstName(longStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceGetUserByFirstNameEmptyFirstName() {
        Mockito.when(userDAO.getUsersByFirstName(emptyStr)).thenThrow(InvalidInputException.class);
        userService.serviceGetUsersByFirstName(emptyStr);
    }

    /**
     * serviceEditUserInformationById
     */

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceEditUserInformationByIdNegativeId() {
        Mockito.when(userDAO.editUserInformationById(invalidId, validStr, validStr, validStr, validStr, validStr))
                .thenThrow(InvalidInputException.class);
        userService.serviceEditUserInformationById(invalidId, validStr, validStr, validStr, validStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceEditUserInformationByIdLongUserName() {
        Mockito.when(userDAO.editUserInformationById(validId, longStr, validStr, validStr, validStr, validStr))
                .thenThrow(InvalidInputException.class);
        userService.serviceEditUserInformationById(validId, longStr, validStr, validStr, validStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceEditUserInformationByIdLongPassword() {
        Mockito.when(userDAO.editUserInformationById(validId, validStr, longStr, validStr, validStr, validStr))
                .thenThrow(InvalidInputException.class);
        userService.serviceEditUserInformationById(validId, validStr, longStr, validStr, validStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceEditUserInformationByIdLongFirstName() {
        Mockito.when(userDAO.editUserInformationById(validId, validStr, validStr, longStr, validStr, validStr))
                .thenThrow(InvalidInputException.class);
        userService.serviceEditUserInformationById(validId, validStr, validStr, longStr, validStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceEditUserInformationByIdLongLastName() {
        Mockito.when(userDAO.editUserInformationById(validId, validStr, validStr, validStr, longStr, validStr))
                .thenThrow(InvalidInputException.class);
        userService.serviceEditUserInformationById(validId, validStr, validStr, validStr, longStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceEditUserInformationByIdLongEmail() {
        Mockito.when(userDAO.editUserInformationById(validId, validStr, validStr, validStr, validStr, longEmail))
                .thenThrow(InvalidInputException.class);
        userService.serviceEditUserInformationById(validId, validStr, validStr, validStr, validStr, longEmail);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceEditUserInformationByIdEmptyUserName() {
        Mockito.when(userDAO.editUserInformationById(validId, emptyStr, validStr, validStr, validStr, validStr))
                .thenThrow(InvalidInputException.class);
        userService.serviceEditUserInformationById(validId, emptyStr, validStr, validStr, validStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceEditUserInformationByIdEmptyFirstName() {
        Mockito.when(userDAO.editUserInformationById(validId, validStr, validStr, emptyStr, validStr, validStr))
                .thenThrow(InvalidInputException.class);
        userService.serviceEditUserInformationById(validId, validStr, validStr, emptyStr, validStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceEditUserInformationByIdEmptyLastName() {
        Mockito.when(userDAO.editUserInformationById(validId, validStr, validStr, validStr, emptyStr, validStr))
                .thenThrow(InvalidInputException.class);
        userService.serviceEditUserInformationById(validId, validStr, validStr, validStr, emptyStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceEditUserInformationByIdEmptyEmail() {
        Mockito.when(userDAO.editUserInformationById(validId, validStr, validStr, validStr, validStr, emptyStr))
                .thenThrow(InvalidInputException.class);
        userService.serviceEditUserInformationById(validId, validStr, validStr, validStr, validStr, emptyStr);
    }

    /**
     * serviceDeleteUserById
     */

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceDeleteUserByIdNegativeId() {
        Mockito.when(userDAO.deleteUserById(invalidId)).thenThrow(InvalidInputException.class);
        userService.serviceDeleteUserById(invalidId);
    }
}


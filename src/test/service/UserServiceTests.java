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
        userService.serviceRequestLogin(longStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceRequestLoginLongPassword() {
        userService.serviceRequestLogin(validStr, longStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceRequestLoginLongUserNameAndPassword() {
        userService.serviceRequestLogin(longStr, longStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceRequestLoginEmptyUserName() {
        userService.serviceRequestLogin(emptyStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceRequestLoginEmptyPassword() {
        userService.serviceRequestLogin(validStr, emptyStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void serviceRequestLoginEmptyUserNameAndPassword() {
        userService.serviceRequestLogin(emptyStr, emptyStr);

    }

    /**
     * serviceCreateAccount
     */

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceCreateAccountLongUserName() {
        userService.serviceCreateAccount(longStr, validStr, validStr, validStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceCreateAccountLongPassword() {
        userService.serviceCreateAccount(validStr, longStr, validStr, validStr, validStr);

    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceCreateAccountLongFirstName() {
        userService.serviceCreateAccount(validStr, validStr, longStr, validStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceCreateAccountLongLastName() {
        userService.serviceCreateAccount(validStr, validStr, validStr, longStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceCreateAccountLongEmail() {
        userService.serviceCreateAccount(validStr, validStr, validStr, validStr, longEmail);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceCreateAccountEmptyUserName() {
        userService.serviceCreateAccount(emptyStr, validStr, validStr, validStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceCreateAccountEmptyPassword() {
        userService.serviceCreateAccount(validStr, emptyStr, validStr, validStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceCreateAccountEmptyFirstName() {
        userService.serviceCreateAccount(validStr, validStr, emptyStr, validStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceCreateAccountEmptyLastName() {
        userService.serviceCreateAccount(validStr, validStr, validStr, emptyStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceCreateAccountEmptyEmail() {
        userService.serviceCreateAccount(validStr, validStr, validStr, validStr, emptyStr);
    }

    /**
     * serviceGetUserById
     */

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceGetUserByIdNegativeId() {
        userService.serviceGetUserById(invalidId);
    }

    /**
     * serviceGetUsersByFirstName
     */

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceGetUserByFirstNameLongFirstName() {
        userService.serviceGetUsersByFirstName(longStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceGetUserByFirstNameEmptyFirstName() {
        userService.serviceGetUsersByFirstName(emptyStr);
    }

    /**
     * serviceEditUserInformationById
     */

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceEditUserInformationByIdNegativeId() {
        userService.serviceEditUserInformationById(invalidId, validStr, validStr, validStr, validStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceEditUserInformationByIdLongUserName() {
        userService.serviceEditUserInformationById(validId, longStr, validStr, validStr, validStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceEditUserInformationByIdLongPassword() {
        userService.serviceEditUserInformationById(validId, validStr, longStr, validStr, validStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceEditUserInformationByIdLongFirstName() {
        userService.serviceEditUserInformationById(validId, validStr, validStr, longStr, validStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceEditUserInformationByIdLongLastName() {
        userService.serviceEditUserInformationById(validId, validStr, validStr, validStr, longStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceEditUserInformationByIdLongEmail() {
        userService.serviceEditUserInformationById(validId, validStr, validStr, validStr, validStr, longEmail);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceEditUserInformationByIdEmptyUserName() {
        userService.serviceEditUserInformationById(validId, emptyStr, validStr, validStr, validStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceEditUserInformationByIdEmptyFirstName() {
        userService.serviceEditUserInformationById(validId, validStr, validStr, emptyStr, validStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceEditUserInformationByIdEmptyLastName() {
        userService.serviceEditUserInformationById(validId, validStr, validStr, validStr, emptyStr, validStr);
    }

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceEditUserInformationByIdEmptyEmail() {
        userService.serviceEditUserInformationById(validId, validStr, validStr, validStr, validStr, emptyStr);
    }

    /**
     * serviceDeleteUserById
     */

    @Test(expectedExceptions = InvalidInputException.class, expectedExceptionsMessageRegExp = "Invalid Input")
    void testServiceDeleteUserByIdNegativeId() {
        userService.serviceDeleteUserById(invalidId);
    }
}


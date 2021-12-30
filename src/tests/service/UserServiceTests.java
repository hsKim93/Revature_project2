package service;

import dev.chirp.customexceptions.InvalidInputException;
import dev.chirp.service.implementations.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserServiceTests {

    UserService userService = new UserService();

    String longStr = "abcdefghijklmnopqrstuvwxyz";
    String validStr = "abc";
    String emptyStr = "";
    int invalidId = -1;
    int validId = 0;
    String longEmail = "01234567890123456789012345678901234567890";

    /**
     * serviceRequestLogin
     */

    @Test
    void serviceRequestLoginLongUserName() {
        try {
            userService.serviceRequestLogin(longStr, validStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void serviceRequestLoginLongPassword() {
        try {
            userService.serviceRequestLogin(validStr, longStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void serviceRequestLoginLongUserNameAndPassword() {
        try {
            userService.serviceRequestLogin(longStr, longStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void serviceRequestLoginEmptyUserName() {
        try {
            userService.serviceRequestLogin(emptyStr, validStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void serviceRequestLoginEmptyPassword() {
        try {
            userService.serviceRequestLogin(validStr, emptyStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void serviceRequestLoginEmptyUserNameAndPassword() {
        try {
            userService.serviceRequestLogin(emptyStr, emptyStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    /**
     * serviceCreateAccount
     */

    @Test
    void testServiceCreateAccountLongUserName() {
        try {
            userService.serviceCreateAccount(longStr, validStr, validStr, validStr, validStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void testServiceCreateAccountLongPassword() {
        try {
            userService.serviceCreateAccount(validStr, longStr, validStr, validStr, validStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void testServiceCreateAccountLongFirstName() {
        try {
            userService.serviceCreateAccount(validStr, validStr, longStr, validStr, validStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void testServiceCreateAccountLongLastName() {
        try {
            userService.serviceCreateAccount(validStr, validStr, validStr, longStr, validStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void testServiceCreateAccountLongEmail() {
        try {
            userService.serviceCreateAccount(validStr, validStr, validStr, validStr, longEmail);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void testServiceCreateAccountEmptyUserName() {
        try {
            userService.serviceCreateAccount(emptyStr, validStr, validStr, validStr, validStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void testServiceCreateAccountEmptyPassword() {
        try {
            userService.serviceCreateAccount(validStr, emptyStr, validStr, validStr, validStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void testServiceCreateAccountEmptyFirstName() {
        try {
            userService.serviceCreateAccount(validStr, validStr, emptyStr, validStr, validStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void testServiceCreateAccountEmptyLastName() {
        try {
            userService.serviceCreateAccount(validStr, validStr, validStr, emptyStr, validStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void testServiceCreateAccountEmptyEmail() {
        try {
            userService.serviceCreateAccount(validStr, validStr, validStr, validStr, emptyStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    /**
     * serviceGetUserById
     */

    @Test
    void testServiceGetUserByIdNegativeId() {
        try {
            userService.serviceGetUserById(invalidId);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    /**
     * serviceGetUsersByFirstName
     */

    @Test
    void testServiceGetUserByFirstNameLongFirstName() {
        try {
            userService.serviceGetUsersByFirstName(longStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void testServiceGetUserByFirstNameEmptyFirstName() {
        try {
            userService.serviceGetUsersByFirstName(emptyStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    /**
     * serviceEditUserInformationById
     */

    @Test
    void testServiceEditUserInformationByIdNegativeId() {
        try {
            userService.serviceEditUserInformationById(invalidId, validStr, validStr, validStr, validStr, validStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void testServiceEditUserInformationByIdLongUserName() {
        try {
            userService.serviceEditUserInformationById(validId, longStr, validStr, validStr, validStr, validStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void testServiceEditUserInformationByIdLongPassword() {
        try {
            userService.serviceEditUserInformationById(validId, validStr, longStr, validStr, validStr, validStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void testServiceEditUserInformationByIdLongFirstName() {
        try {
            userService.serviceEditUserInformationById(validId, validStr, validStr, longStr, validStr, validStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void testServiceEditUserInformationByIdLongLastName() {
        try {
            userService.serviceEditUserInformationById(validId, validStr, validStr, validStr, longStr, validStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void testServiceEditUserInformationByIdLongEmail() {
        try {
            userService.serviceEditUserInformationById(validId, validStr, validStr, validStr, validStr, longEmail);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void testServiceEditUserInformationByIdEmptyUserName() {
        try {
            userService.serviceEditUserInformationById(validId, emptyStr, validStr, validStr, validStr, validStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void testServiceEditUserInformationByIdEmptyPassword() {
        try {
            userService.serviceEditUserInformationById(validId, validStr, emptyStr, validStr, validStr, validStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void testServiceEditUserInformationByIdEmptyFirstName() {
        try {
            userService.serviceEditUserInformationById(validId, validStr, validStr, emptyStr, validStr, validStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void testServiceEditUserInformationByIdEmptyLastName() {
        try {
            userService.serviceEditUserInformationById(validId, validStr, validStr, validStr, emptyStr, validStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    void testServiceEditUserInformationByIdEmptyEmail() {
        try {
            userService.serviceEditUserInformationById(validId, validStr, validStr, validStr, validStr, emptyStr);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }

    /**
     * serviceDeleteUserById
     */

    @Test
    void testServiceDeleteUserByIdNegativeId() {
        try {
            userService.serviceDeleteUserById(invalidId);
            Assert.fail();
        } catch (InvalidInputException e) {
            Assert.assertTrue(true);
        }
    }
}


package dev.chirp.service.implementations;

import dev.chirp.customexceptions.InvalidInputException;
import dev.chirp.dao.implementations.UserDAO;
import dev.chirp.entities.User;
import dev.chirp.service.interfaces.UserServiceInt;

import java.util.ArrayList;

public class UserService implements UserServiceInt {

    UserDAO userDAO = new UserDAO();

    @Override
    public User serviceRequestLogin(String userName, String password) throws InvalidInputException {
        if (userName.length() > 20 || password.length() > 20 ||
                userName.isEmpty() || password.isEmpty()) {
            throw new InvalidInputException();
        }
        return userDAO.requestLogin(userName, password);
    }

    @Override
    public User serviceCreateAccount(String userName, String password, String firstName,
                                     String lastName, String email) throws InvalidInputException {
        if (userName.length() > 20 || password.length() > 20 || firstName.length() > 20 ||
                lastName.length() > 20 || email.length() > 40 ||
                userName.isEmpty() || password.isEmpty() || firstName.isEmpty() ||
                lastName.isEmpty() || email.isEmpty()) {
            throw new InvalidInputException();
        }
        return userDAO.createAccount(userName, password, firstName, lastName, email);
    }

    @Override
    public User serviceGetUserById(int id) throws InvalidInputException {
        if (id < 0) {
            throw new InvalidInputException();
        }
        return userDAO.getUserById(id);
    }

    @Override
    public ArrayList<User> serviceGetUsersByFirstName(String firstName) throws InvalidInputException {
        if (firstName.length() > 20 || firstName.isEmpty()) {
            throw new InvalidInputException();
        }
        return userDAO.getUsersByFirstName(firstName);
    }

    @Override
    public User serviceEditUserInformationById(int id, String userName, String password, String firstName, String lastName,
                                               String email) throws InvalidInputException {
        if (id < 0 || userName.length() > 20 || password.length() > 20 || firstName.length() > 20 ||
                lastName.length() > 20 || email.length() > 40 ||
                userName.isEmpty() || password.isEmpty() || firstName.isEmpty() ||
                lastName.isEmpty() || email.isEmpty()) {
            throw new InvalidInputException();
        }
        return userDAO.editUserInformationById(id, userName, password, firstName, lastName, email);
    }

    @Override
    public User serviceDeleteUserById(int id) throws InvalidInputException {
        if (id < 0) {
            throw new InvalidInputException();
        }
        return userDAO.deleteUserById(id);
    }


}

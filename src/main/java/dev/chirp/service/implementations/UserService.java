package dev.chirp.service.implementations;

import dev.chirp.customexceptions.InvalidInputException;
import dev.chirp.dao.implementations.UserDAO;
import dev.chirp.entities.User;
import dev.chirp.service.interfaces.UserServiceInt;

import java.util.ArrayList;

public class UserService implements UserServiceInt {


    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User serviceRequestLogin(String userName, String password) {
        if (userName.length() > 20 || password.length() > 20 ||
                userName.isEmpty() || password.isEmpty()) {
            throw new InvalidInputException();
        }
        return userDAO.requestLogin(userName, password);
    }

    @Override
    public User serviceCreateAccount(String userName, String password, String firstName,
                                     String lastName, String email) {
        if (userName.length() > 20 || password.length() > 20 || firstName.length() > 20 ||
                lastName.length() > 20 || email.length() > 40 ||
                userName.isEmpty() || password.isEmpty() || firstName.isEmpty() ||
                lastName.isEmpty() || email.isEmpty()) {
            throw new InvalidInputException();
        }
        return userDAO.createAccount(userName, password, firstName, lastName, email);
    }

    @Override
    public ArrayList<User> serviceGetUsers() {
        return userDAO.getUsers();
    }

    @Override
    public User serviceGetUserById(int id) {
        if (id < 0) {
            throw new InvalidInputException();
        }
        return userDAO.getUserById(id);
    }

    @Override
    public ArrayList<User> serviceGetUsersByFirstName(String firstName) {
        if (firstName.length() > 20 || firstName.isEmpty()) {
            throw new InvalidInputException();
        }
        return userDAO.getUsersByFirstName(firstName);
    }

    @Override
    public User serviceEditUserInformationById(int id, String userName, String password, String firstName, String lastName,
                                               String email) {
        if (id < 0 || userName.length() > 20 || password.length() > 20 || firstName.length() > 20 ||
                lastName.length() > 20 || email.length() > 40 ||
                userName.isEmpty() || firstName.isEmpty() ||
                lastName.isEmpty() || email.isEmpty()) {
            throw new InvalidInputException();
        }
        return userDAO.editUserInformationById(id, userName, password, firstName, lastName, email);
    }

    @Override
    public User serviceDeleteUserById(int id) {
        if (id < 0) {
            throw new InvalidInputException();
        }
        return userDAO.deleteUserById(id);
    }


}

package dev.chirp.dao.interfaces;

import dev.chirp.entities.User;

import java.util.ArrayList;

public interface UserDAOInt {

    User requestLogin(String userName, String password);
    User createAccount(String userName, String password, String firstName,
                      String lastName, String email);
    User getUserById(int id);
    ArrayList<User> getUsersByFirstName(String firstName);
    User editUserInformationById(int id, String userName, String password, String firstName, String LastName, String email);
    User deleteUserById(int id);
}

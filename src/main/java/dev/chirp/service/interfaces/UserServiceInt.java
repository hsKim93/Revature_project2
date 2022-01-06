package dev.chirp.service.interfaces;

import dev.chirp.customexceptions.InvalidInputException;
import dev.chirp.entities.User;

import java.util.ArrayList;

public interface UserServiceInt {
    User serviceRequestLogin(String userName, String password);

    User serviceCreateAccount(String userName, String password, String firstName,
                              String lastName, String email);

    User serviceGetUserById(int id);

    ArrayList<User> serviceGetUsers();

    ArrayList<User> serviceGetUsersByFirstName(String firstName);

    User serviceEditUserInformationById(int id, String userName, String password, String firstName, String lastName,
                                        String email);

    User serviceDeleteUserById(int id);
}

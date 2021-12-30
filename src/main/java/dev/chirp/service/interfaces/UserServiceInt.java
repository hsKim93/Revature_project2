package dev.chirp.service.interfaces;

import dev.chirp.customexceptions.InvalidInputException;
import dev.chirp.entities.User;

import java.util.ArrayList;

public interface UserServiceInt {
    User serviceRequestLogin(String userName, String password) throws InvalidInputException;

    User serviceCreateAccount(String userName, String password, String firstName,
                              String lastName, String email) throws InvalidInputException;

    User serviceGetUserById(int id) throws InvalidInputException;

    ArrayList<User> serviceGetUsersByFirstName(String firstName) throws InvalidInputException;

    User serviceEditUserInformationById(int id, String userName, String password, String firstName, String lastName,
                                        String email) throws InvalidInputException;

    User serviceDeleteUserById(int id) throws InvalidInputException;
}

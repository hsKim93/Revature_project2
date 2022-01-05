package dev.chirp.app.controller.controllers;

import com.google.gson.Gson;
import dev.chirp.customexceptions.InvalidInputException;
import dev.chirp.entities.User;
import dev.chirp.service.implementations.UserService;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public Handler requestLogin = ctx -> {
        try {
            Gson gson = new Gson();
            User user = gson.fromJson(ctx.body(), User.class);
            User returnUser = userService.serviceRequestLogin(user.getUserName(), user.getPassword());
            if (returnUser == null) {
                ctx.result("Invalid credentials");
                ctx.status(404);
            } else {
                ctx.result(gson.toJson(returnUser));
                ctx.status(200);
            }
        } catch (InvalidInputException e) {
            ctx.result(e.getMessage());
            ctx.status(404);
        } catch (NullPointerException e) {
            ctx.result("Invalid argument");
            ctx.status(404);
        }
    };

    public Handler createAccount = ctx -> {
        try {
            Gson gson = new Gson();
            User user = gson.fromJson(ctx.body(), User.class);
            User returnUser = userService.serviceCreateAccount(user.getUserName(), user.getPassword(),
                    user.getFirstName(), user.getLastName(), user.getEmail());
            if (returnUser == null) {
                ctx.result("Error creating account");
                ctx.status(404);
            } else {
                ctx.result(gson.toJson(returnUser));
                ctx.status(201);
            }
        } catch (InvalidInputException e) {
            ctx.result(e.getMessage());
            ctx.status(404);
        } catch (NullPointerException e) {
            ctx.result("Invalid argument");
            ctx.status(404);
        }
    };

    public Handler getUserById = ctx -> {
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));
            User returnUser = userService.serviceGetUserById(id);
            if (returnUser == null) {
                ctx.result("User not found");
                ctx.status(404);
            } else {
                Gson gson = new Gson();
                ctx.result(gson.toJson(returnUser));
                ctx.status(200);
            }
        } catch (NumberFormatException e) {
            ctx.result("Invalid input");
            ctx.status(404);
        } catch (InvalidInputException e) {
            ctx.result(e.getMessage());
            ctx.status(404);
        } catch (NullPointerException e) {
            ctx.result("Invalid argument");
            ctx.status(404);
        }
    };

    public Handler getUsers = ctx -> {
        ArrayList<User> users = userService.serviceGetUsers();
        if (users == null) {
            ctx.result("No Users found");
            ctx.status(404);
        } else {
            Gson gson = new Gson();
            ctx.result(gson.toJson(users));
            ctx.status(200);
        }
    };

    public Handler getUsersByFirstName = ctx -> {
        try {
            String firstName = ctx.pathParam("firstName");
            ArrayList<User> users = userService.serviceGetUsersByFirstName(firstName);
            if (users == null) {
                ctx.result("No match found");
                ctx.status(404);
            } else {
                Gson gson = new Gson();
                ctx.result(gson.toJson(users));
                ctx.status(200);
            }
        } catch (InvalidInputException e) {
            ctx.result(e.getMessage());
            ctx.status(404);
        } catch (NullPointerException e) {
            ctx.result("Invalid argument");
            ctx.status(404);
        }
    };

    public Handler editUserInformationById = ctx -> {
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));
            Gson gson = new Gson();
            User user = gson.fromJson(ctx.body(), User.class);
            User returnUser = userService.serviceEditUserInformationById(id, user.getUserName(),
                    user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail());
            if (returnUser == null) {
                ctx.result("Username or email already exists");
                ctx.status(404);
            } else {
                ctx.result(gson.toJson(returnUser));
                ctx.status(200);
            }
        } catch (NumberFormatException e) {
            ctx.result("Invalid input");
            ctx.status(404);
        } catch (InvalidInputException e) {
            ctx.result(e.getMessage());
            ctx.status(404);
        } catch (NullPointerException e) {
            ctx.result("Invalid argument");
            ctx.status(404);
        }
    };

    public Handler deleteUserById = ctx -> {
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));
            User returnUser = userService.serviceDeleteUserById(id);
            if (returnUser == null) {
                ctx.result("User not found");
                ctx.status(404);
            } else {
                Gson gson = new Gson();
                ctx.result(gson.toJson(returnUser));
                ctx.status(200);
            }
        } catch (InvalidInputException e) {
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };
}

package dev.chirp.app.app;

import dev.chirp.app.controller.AppController;
import io.javalin.Javalin;

public class App {

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.enableDevLogging();
        });

        AppController appController = new AppController();
        app.post("/login", appController.userController.requestLogin);
        app.post("/user", appController.userController.createAccount);
        app.get("/user/{id}", appController.userController.getUserById);
        app.get("/search/{firstName}", appController.userController.getUsersByFirstName);
        app.patch("/user/{id}", appController.userController.editUserInformationById);
        app.delete("/user/{id}", appController.userController.deleteUserById);

        app.start();

    }
}

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

        app.get("/", appController.userController.requestLogin);

        app.start();

    }
}

package dev.chirp.app.controller.controllers;

import io.javalin.http.Handler;

public class UserController {

    public Handler requestLogin = ctx -> {
        ctx.result("testing");
        ctx.status(200);
    };
}

package dev.chirp.customexceptions;

public class PostNotFound extends RuntimeException{
    public PostNotFound(String message){super(message);}
}

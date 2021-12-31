package chirp.customexceptions;

public class CommentNotFound extends RuntimeException{
    public CommentNotFound(String message){super(message);}
}

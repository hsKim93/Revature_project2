package dev.chirp.entities;

import java.util.Objects;

public class Comment {
    private int commentId;
    private int postId;
    private String commentContent;
    private String date;

    public Comment(){}

    public Comment(int postId, int commentId, String commentContent, String date) {
        this.commentId = commentId;
        this.postId = postId;
        this.commentContent = commentContent;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                ", commentId=" + commentId +
                ", postId=" + postId +
                ", commentContent='" + commentContent + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return commentId == comment.commentId && postId == comment.postId && Objects.equals(commentContent, comment.commentContent) && Objects.equals(date, comment.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, postId, commentContent, date);
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

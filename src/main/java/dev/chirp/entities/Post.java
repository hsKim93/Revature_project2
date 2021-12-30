package dev.chirp.entities;

import java.util.Objects;

public class Post {
    private int postId;
    private int userId;
    private String content;
    private String date;

    public Post(){}

    public Post(int postId, int userId, String content, String date) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return postId == post.postId && userId == post.userId && content.equals(post.content) && date.equals(post.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, userId, content, date);
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

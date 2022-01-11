package dev.chirp.entities;

import java.util.List;
import java.util.Objects;

public class Post {
    private String userName;
    private String firstName;
    private String lastName;
    private int postId;
    private int userId;
    private String content;
    private String date;
    private int likes;
    private List<Comment> comment;


    public Post() {
    }

    public Post(int postId, int userId, String content, String date) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.date = date;
    }

    public Post(int postId, int userId, String content, String date, String userName, String firstName, String lastName) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.date = date;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return postId == post.postId && userId == post.userId && likes == post.likes && Objects.equals(userName, post.userName) && Objects.equals(firstName, post.firstName) && Objects.equals(lastName, post.lastName) && Objects.equals(content, post.content) && Objects.equals(date, post.date) && Objects.equals(comment, post.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, firstName, lastName, postId, userId, content, date, likes, comment);
    }
}
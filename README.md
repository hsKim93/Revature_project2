# PROJECT2 REVATURE

## Project Description

A social media platform where you can intereact with your friends.

[test](#contributors)

## Technologies Used

* Tech 1 - JAVA 17
* Tech 2 - PostgresSQL
* Tech 3 - Javelin
* Tech 4 - Javascript es6
* Tech 5 - Amazon RDS
* Tech 6 - TestNG
* Tech 7 - Cucumber
* Tech 8 - Selenium
* Tech 9 - JDBC
* Tech 10 - HTML
* Tech 11 - CSS, Boostrap

## Features

List of features ready and TODOs for future development
* Create/Delete posts
* Create/Delete comments
* Like/Unlike posts
* Search for users
* Follow/Unfollow users
* Login/Logout
* Create Account
* View posts on homepage
* Edit account information


To-do list:
* Add about me on my profile
* upload profile pictures
* optimize code

## Getting Started

Step 1: clone the repository
```
git clone https://github.com/hsKim93/Revature_project_2.git
```

Step 2: Run the following PostgreSQL script in your SQL client tool
```
create table users (
    user_id serial primary key,
    user_name varchar(20) not null unique,
    "password" varchar(20) not null,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    email varchar(40) not null unique,
    is_admin boolean not null default false
);

create table posts (
    post_id serial primary key,
    user_id int references users(user_id) on delete cascade,
    post_content varchar(500) not null,
    "date" timestamp not null default clock_timestamp()
);

create table "comments" (
    comment_id serial primary key,
    post_id int references posts(post_id) on delete cascade,
    user_id int references users(user_id) on delete cascade,
    comment_content varchar(500) not null,
    "date" timestamp not null default clock_timestamp()
);

create table relationships(
    user_id int references users(user_id) on delete cascade,
    target_id int references users(user_id) on delete cascade,
    primary key (user_id, target_id)
);

create table likes(
    user_id int references users(user_id) on delete cascade,
    post_id int references posts(post_id) on delete cascade,
    primary key (user_id, post_id)
);
```

Step 3: Set up your environment variables available from your client tool into your Java IDE, then run App.java

Step 4: Open Index.html and enjoy

## Usage for user

> 1. Create an account of the login page.
> 2. After being redirected to the homepage, simply create a post by typing content into the text box and clicking the chirp button.
> 3. To create a comment, click on the comments button on the bottom of a post,insert comment content and click chirp next to the text box.
> 4. To view all your posts click the My Profile button on the navigation bar.
> 5. To delete posts go to your profile and click delete button on the top right corner of a post.
> 6. To delete comment click the delete button the far right of the comment.(Note that you can only delete comments on your post or comments that were created by you)
> 7. To search for a user, locate the search bar on the navigation var and type in the first name of the person you are searching for, click search and finally 
> click on the search result to be redirected to their page.
> 8. Click follow/Unfollow button on a user profile to unfollow or follow that user.
> 9. Click Like button the like or unlike a post.


## Usage for admin

> 1. Login as an admin
> 2. on the homepage click the delete bbutton to delete a user.
> 3. Click posts page to see posts.
> 4. Click delete button on post page to delete a post.
> 5. Click show comments the post page to show the comments on a post.
> 6. Click delete comment button to delete a comment after clicking show comments on the post page.

## Contributors
- [Hyungsuk Kim](https://github.com/hsKim93)
- [Irfan Uludag](https://github.com/Uirfan)
- [Loc Phan](https://github.com/LocPhanRevature)

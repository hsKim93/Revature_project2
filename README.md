# PROJECT2 REVATURE

## Project Description

A social media platform where you can intereact with your friends.

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

## Usage

Here, you instruct other people on how to use your project after they’ve installed it. This would also be a good place to include screenshots of your project in action.

## Contributors
- [Hyungsuk Kim](https://github.com/hsKim93)
- [Irfan Uludag](https://github.com/Uirfan)
- [Loc Phan](https://github.com/LocPhanRevature)

## License
This project uses the following license: [<license_name>](<link>).

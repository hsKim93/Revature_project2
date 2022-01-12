Feature: As a user I want to perform various actions to manage posts, likes, and comments

  Scenario: As a user I want to make a post so I can share my thoughts with others
    Given the user is on homepage
    When the user enters something
    When the user clicks post button
    Then the post will be displayed at the top of the feed

  Scenario: As a user I want to delete a post so I can undo my mistakes
    Given the user is on homepage
    When the user goes to their profile
    When the user clicks delete post button
    Then the post will be deleted

  Scenario:As a user I want to like a post so I can show my interest in a post
    Given the user is on homepage
    When the user clicks like post button
    Then the like count will increment by one

  Scenario:As a user I want to unlike a post so I can undo my mistakes
    Given the user is on homepage
    When the user clicks unlike comment button
    Then the like count will decrement by one

  Scenario:As a user I want to leave a comment to a post to share my thoughts about the post
    Given the user is on homepage
    When the user enters their comment
    When the user clicks comment button
    Then the comment will be displayed

  Scenario:As a user I want to delete my comment from a post
    Given the user is on homepage
    When the user clicks on delete comment button
    Then the comment will be deleted

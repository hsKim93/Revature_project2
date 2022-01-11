Feature: As an admin I should be able to manage content

  Scenario: as an admin I should be able to delete accounts so that I cann punish users againts TOS
    Given the admin is on admin page
    When the admin clicks delete user
    Then the user should not appear on the users list


  Scenario: as an admin I should be able to delete posts so that I can moderate posts
    Given the admin is on admin page
    When the admin clicks on posts
    When the admin clicks delete posts
    Then the post should not appear on the post list

  Scenario: as an admin I should be able to delete comments so that I can moderate comments
    Given the admin is on the admin page
    When the admin clicks on posts
    When the admin clicks see comments button
    When the admin clicks delete comment
    Then the comment should not appear on the comments list

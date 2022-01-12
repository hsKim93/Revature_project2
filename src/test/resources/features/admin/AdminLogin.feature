Feature:  As an admin I want to log in, and log out

  Scenario: as an admin I should be able to log in so that I can moderate the website
    Given the user is on the login page
    When the admin enters the username
    When the admin enters the password
    When the admin clicks login button
    Then the admin should be redirected to the admin page

  Scenario: as a admin I should be able to log out so that my computer does not store my information
    Given the admin is on the admin page
    When the admin clicks log out button
    Then the admin should be redirected to the log in page

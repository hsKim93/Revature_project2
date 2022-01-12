Feature:  As a user I want create account, log in, and log out

  Scenario: As a user I want to create an account so I can use the web service
    Given the user is on login page
    When the user enters username
    When the user enters password
    When the user enters first name
    When the user enters last name
    When the user enters email
    When the user clicks on create register button
    Then the user will be redirected to the homepage

  Scenario: As a user I want to log in so I can access my profile
    Given the user is on login page
    When the user enters username
    When the user enters password
    When the user clicks login button
    Then the user will be redirected to the homepage

  Scenario: As a user I want to log out so my information does not stay visible
    Given the user is on homepage
    When the user clicks logout button
    Then the user will be redirected to the login page

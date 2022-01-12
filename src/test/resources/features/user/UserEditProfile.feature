Feature: As a user I want to edit my profile

  Scenario: As a user I want to edit my profile so I can update my information
    Given the user is on homepage
    When the user goes to their profile
    When the users clicks edit profile
    When the user enters new username
    When the user enters new first name
    When the user enters new last name
    When the user enters new email
    When the user clicks update
    Then the user's profile will be edited



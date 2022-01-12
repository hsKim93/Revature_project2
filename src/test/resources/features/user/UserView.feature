Feature: As an user, I want to view profiles

  Scenario: As an user, I want to search other users using their name
    Given the user is on homepage
    When the user enters other user's first name on the search bar
    When the user clicks search button
    Then the user should see the searched user's name and a link to their profile

  Scenario: As an user, I want to view my profile
    Given the user is on homepage
    When the user clicks on the My Profile button
    Then the user should be redirect to their profile page

  Scenario: As an user, I want to view other profiles
    Given the user is on homepage
    When the user enters other user's first name on the search bar
    When the user clicks search button
    When the user clicks on the searched person
    Then the user should be redirected to the searched user's profile page

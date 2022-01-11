Feature: As an user, I want to manage my follows so that I know whose profile I am interested in

  Scenario: As an user, I want to follow other users
    Given the user is on the other user's profile page
    When the user click on the follow button
    Then the user should now be followed and the follow button should change to unfollow

  Scenario: As an user, I want to unfollow other users
    Given the user is on the other user's profile page
    When the user clicks on the unfollow button
    Then the user should now be unfollowed and the unfollow button should change to follow

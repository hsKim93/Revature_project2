package E2E.steps.user;

import E2E.runner.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class UserEditProfile {
    @When("the users clicks edit profile")
    public void the_users_clicks_edit_profile() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userMyProfilePage.getEditButton));
        TestRunner.userMyProfilePage.getEditButton.click();
    }

    @When("the user enters new username")
    public void the_user_enters_new_username() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userMyProfilePage.getInputUsername));
        TestRunner.userMyProfilePage.getInputUsername.sendKeys("");
    }


    @When("the user enters new first name")
    public void the_user_enters_new_first_name() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userMyProfilePage.getInputFirstName));
        TestRunner.userMyProfilePage.getInputFirstName.sendKeys("");
    }

    @When("the user enters new last name")
    public void the_user_enters_new_last_name() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userMyProfilePage.getInputLastName));
        TestRunner.userMyProfilePage.getInputLastName.sendKeys("");
    }

    @When("the user enters new email")
    public void the_user_enters_new_email() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userMyProfilePage.getInputEmail));
        TestRunner.userMyProfilePage.getInputEmail.sendKeys("newEmail@email.com");

    }

    @When("the user clicks update")
    public void the_user_clicks_update() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userMyProfilePage.getUpdateProfileButton));
        TestRunner.userMyProfilePage.getUpdateProfileButton.click();
    }

    @Then("the user's profile will be edited")
    public void the_user_s_profile_will_be_edited() {
        TestRunner.driver.get("http://127.0.0.1:5500/front-end/src/users/myProfile/myProfile.html");
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userMyProfilePage.getEmail));
        String name = TestRunner.userMyProfilePage.getEmail.getText();
        Assert.assertEquals(name, "newEmail@email.com");
    }
}

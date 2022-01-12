package E2E.steps.admin;

import E2E.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminAction {
    @Given("the admin is on admin page")
    public void the_admin_is_on_admin_page() {
        TestRunner.driver.get("http://127.0.0.1:5500/front-end/src/login/");
        TestRunner.loginPage.getSignInUserName.sendKeys("reg_admin");
        TestRunner.loginPage.getSignInPassword.sendKeys("test_admin");
        TestRunner.loginPage.getSignInButton.click();
    }

    @When("the admin clicks delete user")
    public void the_admin_clicks_delete_user() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.adminHomePage.getDeleteUserButton));
        TestRunner.adminHomePage.getDeleteUserButton.click();    }

    @Then("the user should not appear on the users list")
    public void the_user_should_not_appear_on_the_users_list() {
        TestRunner.explicitWait.until(ExpectedConditions.invisibilityOf(TestRunner.adminHomePage.getDeleteUserButton));

    }
    @When("the admin clicks on posts")
    public void the_admin_clicks_on_posts() {
        TestRunner.adminHomePage.getPostButton.click();
    }

    @When("the admin clicks delete posts")
    public void the_admin_clicks_delete_posts() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.adminPostPage.getDeletePostButton));
        TestRunner.adminPostPage.getDeletePostButton.click();
    }

    @Then("the post should not appear on the post list")
    public void the_post_should_not_appear_on_the_post_list() {
        TestRunner.explicitWait.until(ExpectedConditions.invisibilityOf(TestRunner.adminPostPage.getDeletePostButton));

    }

    @When("the admin clicks see comments button")
    public void the_admin_clicks_see_comments_button() {
        TestRunner.adminPostPage.getShowCommentsButton.click();
    }

    @When("the admin clicks delete comment")
    public void the_admin_clicks_delete_comment() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.adminPostPage.getDeleteCommentButton));
        TestRunner.adminPostPage.getDeleteCommentButton.click();
    }

    @Then("the comment should not appear on the comments list")
    public void the_comment_should_not_appear_on_the_comments_list() {
        TestRunner.explicitWait.until(ExpectedConditions.invisibilityOf(TestRunner.adminPostPage.getDeleteCommentButton));

    }
}

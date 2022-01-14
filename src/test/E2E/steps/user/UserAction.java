package E2E.steps.user;

import E2E.runner.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserAction {

    /*Create Post*/
    @When("the user enters something")
    public void the_user_enters_something() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userHomepage.getPostInput));
        TestRunner.userHomepage.getPostInput.sendKeys("E2E Test Post");
    }

    @When("the user clicks post button")
    public void the_user_clicks_post_button() {
        TestRunner.userHomepage.getSendPostButton.click();
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userHomepage.getFirstPost));
    }

    @Then("the post will be displayed at the top of the feed")
    public void the_post_will_be_displayed_at_the_top_of_the_feed() {
        Assert.assertNotNull(TestRunner.userHomepage.getFirstPost);
    }

    /*Delete Post*/
    @When("the user goes to their profile")
    public void the_user_goes_to_their_profile() {
        TestRunner.userHomepage.getMyProfileButton.click();
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userMyProfilePage.getEditButton));
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "My Profile");
    }

    @When("the user clicks delete post button")
    public void the_user_clicks_delete_post_button() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userMyProfilePage.getDeletePostButton));
        TestRunner.userMyProfilePage.getDeletePostButton.click();
    }

    @Then("the post will be deleted")
    public void the_post_will_be_deleted() {
        TestRunner.explicitWait.until(ExpectedConditions.invisibilityOf(TestRunner.userMyProfilePage.getDeletePostButton));
    }

    /*Like Post*/
    @When("the user clicks like post button")
    public void the_user_clicks_like_post_button() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userHomepage.getLikeButton));
        TestRunner.userHomepage.getLikeButton.click();
    }

    @Then("the like count will increment by {int}")
    public void the_like_count_will_increment_by() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userHomepage.getLikeButton));
        String result = TestRunner.userHomepage.getLikeStatus.getText();
        Assert.assertEquals(result, "1");
    }

    /*Unlike Post*/
    @When("the user clicks unlike comment button")
    public void the_user_clicks_unlike_comment_button() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userHomepage.getLikeButton));
        TestRunner.userHomepage.getLikeButton.click();
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userHomepage.getLikeButton));
        TestRunner.userHomepage.getLikeButton.click();
    }

    @Then("the like count will decrement by {int}")
    public void the_like_count_will_decrement() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userHomepage.getLikeButton));
        String result = TestRunner.userHomepage.getLikeStatus.getText();
        Assert.assertEquals(result, "0");
    }

    /*Create Comment*/
    @When("the user enters their comment")
    public void the_user_enters_their_comment() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userHomepage.getCommentCollapse));
        TestRunner.userHomepage.getCommentCollapse.click();
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userHomepage.getCommentInput));
        TestRunner.userHomepage.getCommentInput.sendKeys("E2E comment");
    }

    @When("the user clicks comment button")
    public void the_user_clicks_comment_button() {
        TestRunner.userHomepage.getSendCommentButton.click();
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userHomepage.getFirstComment));
    }

    @Then("the comment will be displayed")
    public void the_comment_will_be_displayed() {
        Assert.assertNotNull(TestRunner.userHomepage.getFirstComment);
    }

    /*Delete Comment*/
    @When("the user clicks on delete comment button")
    public void the_user_clicks_on_delete_comment_button() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userHomepage.getCommentCollapse));
        TestRunner.userHomepage.getCommentCollapse.click();
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userMyProfilePage.getDeleteCommentButton));
        TestRunner.userMyProfilePage.getDeleteCommentButton.click();
    }

    @Then("the comment will be deleted")
    public void the_comment_will_be_deleted() {
        TestRunner.explicitWait.until(ExpectedConditions.invisibilityOf(TestRunner.userMyProfilePage.getDeleteCommentButton));
    }
}

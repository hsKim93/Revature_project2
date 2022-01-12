package E2E.steps.user;

import E2E.runner.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserFollow {
    @When("the user goes to other user's profile page")
    public void the_user_goes_to_other_user_s_profile_page() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userHomepage.getSearchInput));
        TestRunner.userHomepage.getSearchInput.sendKeys("l");
        TestRunner.userHomepage.getSearchButton.click();
        TestRunner.userHomepage.getFirstSearchResult.click();
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userOtherProfilePage.getName));
        String name = TestRunner.userOtherProfilePage.getName.getText();
        Assert.assertEquals(name, "l p");
    }

    @When("the user click on the follow button")
    public void the_user_click_on_the_follow_button() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userOtherProfilePage.getFollowButton));
        TestRunner.userOtherProfilePage.getFollowButton.click();
    }

    @Then("the user should now be followed and the follow button should change to unfollow")
    public void the_user_should_now_be_followed_and_the_follow_button_should_change_to_unfollow() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userOtherProfilePage.getFollowButton));
        String follow = TestRunner.driver.findElement(By.id("followButton")).getAttribute("value");
        Assert.assertEquals(follow, "Following");
    }

    @When("the user clicks on the unfollow button")
    public void the_user_clicks_on_the_unfollow_button() {
        TestRunner.userOtherProfilePage.getFollowButton.click();
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userOtherProfilePage.getFollowButton));
        TestRunner.userOtherProfilePage.getFollowButton.click();
    }

    @Then("the user should now be unfollowed and the unfollow button should change to follow")
    public void the_user_should_now_be_unfollowed_and_the_unfollow_button_should_change_to_follow() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userOtherProfilePage.getFollowButton));
        String follow = TestRunner.userOtherProfilePage.getFollowButton.getText();
        Assert.assertEquals(follow, "Follow");
    }
}

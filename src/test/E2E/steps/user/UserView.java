package E2E.steps.user;

import E2E.runner.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserView {

    @When("the user enters other user's first name on the search bar")
    public void the_user_enters_other_user_s_first_name_on_the_search_bar() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userHomepage.getSearchInput));
        TestRunner.userHomepage.getSearchInput.sendKeys("irfan");
    }

    @When("the user clicks search button")
    public void the_user_clicks_search_button() {
        TestRunner.userHomepage.getSearchButton.click();
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userHomepage.getFirstSearchResult));
    }

    @Then("the user should see the searched user's name and a link to their profile")
    public void the_user_should_see_the_searched_user_s_name_and_a_link_to_their_profile() {
        Assert.assertNotNull(TestRunner.userHomepage.getFirstSearchResult);
    }

    @When("the user clicks on the My Profile button")
    public void the_user_clicks_on_the_my_profile_button() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userHomepage.getMyProfileButton));
        TestRunner.userHomepage.getMyProfileButton.click();
    }

    @Then("the user should be redirect to their profile page")
    public void the_user_should_be_redirect_to_their_profile_page() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userHomepage.getSearchInput));
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "My Profile");
    }

    @When("the user clicks on the searched person")
    public void the_user_clicks_on_the_searched_person() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userHomepage.getFirstSearchResult));
        TestRunner.userHomepage.getFirstSearchResult.click();
    }

    @Then("the user should be redirected to the searched user's profile page")
    public void the_user_should_be_redirected_to_the_searched_user_s_profile_page() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userOtherProfilePage.getName));
        String name = TestRunner.userOtherProfilePage.getName.getText();
        Assert.assertEquals(name, "irfan uludag");
    }
}

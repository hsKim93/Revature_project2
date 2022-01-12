package E2E.steps.user;

import E2E.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class UserLogin {
    @Given("the user is on login page")
    public void the_user_is_on_login_page() {
        TestRunner.driver.get("http://127.0.0.1:5500/front-end/src/login/index.html");
    }

    @When("the user enters username")
    public void the_user_enters_username() {
        TestRunner.loginPage.getCreateUserName.sendKeys("cucumber");
    }

    @When("the user enters password")
    public void the_user_enters_password() {
        TestRunner.loginPage.getCreatePassword.sendKeys("cucumber");
    }

    @When("the user enters first name")
    public void the_user_enters_first_name() {
        TestRunner.loginPage.getCreateFirstName.sendKeys("selnium");
    }

    @When("the user enters last name")
    public void the_user_enters_last_name() {
        TestRunner.loginPage.getCreateLastName.sendKeys("cucumber");
    }

    @When("the user enters email")
    public void the_user_enters_email() {
        TestRunner.loginPage.getCreateEmail.sendKeys("cucumber@cucumber.com");
    }

    @When("the user clicks on create register button")
    public void the_user_clicks_on_create_register_button() {
        TestRunner.loginPage.getCreateButton.click();
    }

    @When("the user enters username for signIn")
    public void the_user_enters_username_for_signIn() {
        TestRunner.loginPage.getSignInUserName.sendKeys("reg_user");
    }

    @When("the user enters password for signIn")
    public void the_user_enters_password_for_signIn() {
        TestRunner.loginPage.getSignInPassword.sendKeys("test123");
    }

    @When("the user clicks login button")
    public void the_user_clicks_login_button() {
        TestRunner.loginPage.getSignInButton.click();
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userHomepage.getSearchButton));
    }

    @Then("the user will be redirected to the homepage")
    public void the_user_will_be_redirected_to_the_homepage() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userHomepage.getSearchButton));
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "Homepage");
    }

    @Given("the user is on homepage")
    public void the_user_is_on_homepage() {
        TestRunner.driver.get("http://127.0.0.1:5500/front-end/src/login/index.html");
        TestRunner.loginPage.getSignInUserName.sendKeys("reg_user");
        TestRunner.loginPage.getSignInPassword.sendKeys("test123");
        TestRunner.loginPage.getSignInButton.click();
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userHomepage.getLogoutButton));
    }

    @When("the user clicks logout button")
    public void the_user_clicks_logout_button() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userHomepage.getLogoutButton));
        TestRunner.userHomepage.getLogoutButton.click();
    }

    @Then("the user will be redirected to the login page")
    public void the_user_will_be_redirected_to_the_login_page() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.loginPage.getSignInButton));
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "Login Page");
    }
}

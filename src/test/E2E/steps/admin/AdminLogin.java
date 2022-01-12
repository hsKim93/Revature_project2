//package E2E.steps.admin;
//
//import E2E.runner.TestRunner;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//public class AdminLogin {
//
//    @Given("the user is on the login page")
//    public void the_user_is_on_the_login_page() {
//        TestRunner.driver.get("http://127.0.0.1:5500/front-end/src/login/");}
//
//    @When("the admin enters the username")
//    public void the_admin_enters_the_username_username() {
//        TestRunner.loginPage.getSignInUserName.sendKeys("reg_admin");
//    }
//
//    @When("the admin enters the password")
//    public void the_admin_enters_the_password_password() {
//        TestRunner.loginPage.getSignInPassword.sendKeys("test_admin");
//    }
//
//    @When("the admin clicks login button")
//    public void the_admin_clicks_login_button() {
//        TestRunner.loginPage.getSignInButton.click();
//    }
//
//    @Then("the admin should be redirected to the admin page")
//    public void the_admin_should_be_redirected_to_the_admin_page() {
//        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.adminHomePage.getLogoutButton));
//        String title = TestRunner.driver.getTitle();
//        Assert.assertEquals(title, "Admin Home Page");
//    }
//
//    @Given("the admin is on the admin page")
//    public void the_admin_is_on_the_admin_page() {
//        TestRunner.driver.get("http://127.0.0.1:5500/front-end/src/login/");
//        TestRunner.loginPage.getSignInUserName.sendKeys("reg_admin");
//        TestRunner.loginPage.getSignInPassword.sendKeys("test_admin");
//        TestRunner.loginPage.getSignInButton.click();
//    }
//
//    @When("the admin clicks log out button")
//    public void the_admin_clicks_log_out_button() {
//        TestRunner.adminHomePage.getLogoutButton.click();
//    }
//
//    @Then("the admin should be redirected to the log in page")
//    public void the_admin_should_be_redirected_to_the_log_in_page() {
//        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.loginPage.getSignInButton));
//        String title = TestRunner.driver.getTitle();
//        Assert.assertEquals(title, "Login Page");
//
//    }
//}

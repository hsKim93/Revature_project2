package E2E.runner;

import E2E.poms.LoginPage;
import E2E.poms.admin.AdminHomePage;
import E2E.poms.admin.AdminPostPage;
import E2E.poms.user.UserHomepage;
import E2E.poms.user.UserMyProfilePage;
import E2E.poms.user.UserOtherProfilePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(features="classpath:features", glue="E2E.steps", plugin = {"pretty", "html:src/test/resources/reports/html-reports.html"})
public class TestRunner {
    public static WebDriver driver;
    public static WebDriverWait explicitWait;

    // POMs
    public static LoginPage loginPage;
    public static AdminHomePage adminHomePage;
    public static AdminPostPage adminPostPage;

    public static UserHomepage userHomepage;
    public static UserMyProfilePage userMyProfilePage;
    public static UserOtherProfilePage userOtherProfilePage;

    @BeforeClass
    public static void setup() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // POMs
        loginPage = new LoginPage(driver);
        adminHomePage = new AdminHomePage(driver);
        adminPostPage = new AdminPostPage(driver);
        userHomepage = new UserHomepage(driver);
        userMyProfilePage = new UserMyProfilePage(driver);
        userOtherProfilePage = new UserOtherProfilePage(driver);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        explicitWait = new WebDriverWait(driver, 20);


    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}

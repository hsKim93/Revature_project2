package E2E.runner;


import E2E.poms.LoginPage;
import E2E.poms.user.UserHomepage;
import E2E.poms.user.UserMyProfilePage;
import E2E.poms.user.UserOtherProfilePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(features="classpath:features", glue="E2E.steps")
public class TestRunner {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static UserHomepage userHomepage;
    public static UserMyProfilePage userMyProfilePage;
    public static UserOtherProfilePage userOtherProfilePage;
    public static WebDriverWait explicitWait;

    @BeforeClass
    public static void setup() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();

        // POMs

        loginPage = new LoginPage(driver);
        userHomepage = new UserHomepage(driver);
        userMyProfilePage = new UserMyProfilePage(driver);
        userOtherProfilePage = new UserOtherProfilePage(driver);


        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        explicitWait = new WebDriverWait(driver, 10);


    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}

package E2E.runner;

import E2E.poms.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.concurrent.TimeUnit;




public class TestRunner {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static WebDriverWait explicitWait;

    @BeforeClass
    public static void setup() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();

        /**
         * POMs
         */
        loginPage = new LoginPage(driver);

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        explicitWait = new WebDriverWait(driver, 1);


    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}

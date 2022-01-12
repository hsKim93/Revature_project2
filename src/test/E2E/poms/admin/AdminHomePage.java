package E2E.poms.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
    private WebDriver driver;

    public AdminHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "logout")
    public WebElement getLogoutButton;

    @FindBy(id = "posts")
    public WebElement getPostButton;

    @FindBy(id = "8003d")
    public WebElement getDeleteUserButton;

}

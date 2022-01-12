package E2E.poms.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserOtherProfilePage {

    private WebDriver driver;

    public UserOtherProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "name")
    public WebElement getName;

    @FindBy(id = "followButton")
    public WebElement getFollowButton;

    @FindBy(id="followers")
    public WebElement getFollowersCount;

}

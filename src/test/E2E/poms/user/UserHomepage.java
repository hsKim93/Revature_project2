package E2E.poms.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomepage {

    private WebDriver driver;

    public UserHomepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "postInput")
    public WebElement getPostInput;

    @FindBy(id = "sendPostButton")
    public WebElement getSendPostButton;

    @FindBy(id = "myProfile")
    public WebElement getMyProfileButton;

    @FindBy(id = "search1")
    public WebElement getSearchInput;

    @FindBy(id = "searchButton")
    public WebElement getSearchButton;

    @FindBy(id = "logout")
    public WebElement getLogoutButton;

    @FindBy(id = "likeButton28")
    public WebElement getLikeButton;

    @FindBy(xpath = "//*[@id=\"searchList\"]/li[1]/a/span/p")
    public WebElement getFirstSearchResult;
}

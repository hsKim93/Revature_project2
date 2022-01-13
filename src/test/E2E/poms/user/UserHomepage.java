package E2E.poms.user;

import org.mockito.internal.matchers.Find;
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

    @FindBy(id = "likeButton950")
    public WebElement getLikeButton;

    @FindBy(xpath = "//*[@id=\"searchList\"]/li[1]/a/span/p")
    public WebElement getFirstSearchResult;

    @FindBy(id = "likeStatus950")
    public WebElement getLikeCount;

    @FindBy(xpath = "//*[@id=\"headingNew\"]")
    public WebElement getFirstPost;

    @FindBy(id = "heading950")
    public WebElement getPostContent;

    @FindBy(xpath = "//*[@id=\"heading950\"]/div[2]/p[1]/a[2]")
    public WebElement getCommentCollapseForC;

    @FindBy(xpath = "//*[@id=\"heading951\"]/div[2]/p[1]/a[2]")
    public WebElement getCommentCollapseForD;

    @FindBy(id = "inputComment950")
    public WebElement getCommentInput;

    @FindBy(xpath = "//*[@id=\"commentSection950\"]/button")
    public WebElement getSendCommentButton;
}

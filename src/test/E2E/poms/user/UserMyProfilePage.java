package E2E.poms.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserMyProfilePage {

    private WebDriver driver;
    public UserMyProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    public WebElement getEmail;

    @FindBy(id = "editButton")
    public WebElement getEditButton;

    @FindBy(id = "editUsername")
    public WebElement getInputUsername;

    @FindBy(id = "editFirstName")
    public WebElement getInputFirstName;

    @FindBy(id = "editLastName")
    public WebElement getInputLastName;

    @FindBy(id = "editEmail")
    public WebElement getInputEmail;

    @FindBy(id = "editProfileButton")
    public WebElement getUpdateProfileButton;

    @FindBy(xpath = "//*[@id=\"heading952\"]/a[1]")
    public WebElement getDeletePostButton;

    @FindBy(id = "deleteComment951")
    public WebElement getDeleteCommentButton;
}

package E2E.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inputUserName")
    public WebElement getSignInUserName;

    @FindBy(id = "inputPassword")
    public WebElement getSignInPassword;

    @FindBy(id = "signInButton")
    public WebElement getSignInButton;

    @FindBy(id = "createFirstName")
    public WebElement getCreateFirstName;

    @FindBy(id = "createUserLastName")
    public WebElement getCreateLastName;

    @FindBy(id = "createUserName")
    public WebElement getCreateUserName;

    @FindBy(id = "createPassword")
    public WebElement getCreatePassword;

    @FindBy(id = "createEmail")
    public WebElement getCreateEmail;

    @FindBy(id = "signUpButton")
    public WebElement getCreateButton;

}

package E2E.poms.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPostPage {
    private WebDriver driver;

    public AdminPostPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "showComments8000")
    public WebElement getShowCommentsButton;

    @FindBy(id = "deletePost8003")
    public WebElement getDeletePostButton;

    @FindBy(id = "deleteComment8003")
    public WebElement getDeleteCommentButton;
}

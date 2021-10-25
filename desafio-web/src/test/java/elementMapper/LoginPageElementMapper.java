package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElementMapper {
    @FindBy(css = "#email_create")
    public WebElement newAccountEmailInput;

    @FindBy(css = "#SubmitCreate")
    public WebElement createAccountButton;

    public WebElement email;

    public WebElement passwd;

    public WebElement SubmitLogin;
}

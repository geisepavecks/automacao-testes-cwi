package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPageElementMapper {
    @FindBy(css = "#block_top_menu > ul > li:nth-child(2) > a")
    public WebElement dressesLink;
}

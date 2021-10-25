package pageObjects;

import elementMapper.MyAccountPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class MyAccountPage extends MyAccountPageElementMapper {
    public MyAccountPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    @Step("Clicou no dresses")
    public void clickDressesLink() {
        dressesLink.click();
    }
}

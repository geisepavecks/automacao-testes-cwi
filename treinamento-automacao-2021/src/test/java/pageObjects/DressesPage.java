package pageObjects;

import elementMapper.DressesPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class DressesPage extends DressesPageElementMapper {
    public DressesPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    @Step("Clicou no botão Add to Cart do Chiffon Dress")
    public void clickChiffonDressAddToCartButton() {
        BasePage.mouseOver(printedChiffonDress);
        printedChiffonDressAddToCartButton.click();
    }

    @Step("Clicou no Proceed to checkout")
    public void clickCheckoutButton() {
        proceedToCheckoutButton.click();
    }
}

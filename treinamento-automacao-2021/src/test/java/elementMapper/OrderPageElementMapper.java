package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPageElementMapper {
    @FindBy(css = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium")
    public WebElement proceedToCheckoutButton;

    @FindBy(css = "#center_column > form > p > button")
    public WebElement submitButton;

    @FindBy(css = "#cgv")
    public WebElement agreementInput;

    @FindBy(css = "#form > p > button")
    public WebElement processCarrierButton;

    @FindBy(css = "#HOOK_PAYMENT > div:nth-child(1) > div > p > a")
    public WebElement payByBankWireLink;

    @FindBy(css = "#cart_navigation > button")
    public WebElement confirmOrderButton;
}

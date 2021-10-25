package pageObjects;

import elementMapper.OrderPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class OrderPage extends OrderPageElementMapper {
    public OrderPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    @Step("Clicou no Proceed to checkout 2")
    public void clickProceedButton() {
        proceedToCheckoutButton.click();
    }

    @Step("Clicou no Proceed to checkout 3")
    public void clickSubmitButton() {
        submitButton.click();
    }

    @Step("Clicou no input de agreement")
    public void clickAgreeInput() {
        agreementInput.click();
    }

    @Step("Clicou no Proceed to checkout 4")
    public void clickProcessCarrierButton() {
        processCarrierButton.click();
    }

    @Step("Clicou no Pay by bank wire")
    public void clickPayByBankWireLink() {
        payByBankWireLink.click();
    }

    @Step("Clicou no I confirm my order")
    public void clickConfirmButton() {
        confirmOrderButton.click();
    }
}

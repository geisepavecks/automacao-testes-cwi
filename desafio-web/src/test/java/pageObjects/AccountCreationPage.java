package pageObjects;

import elementMapper.AccountCreationPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class AccountCreationPage extends AccountCreationPageElementMapper {
    public AccountCreationPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    @Step("Escolheu title")
    public void selectTitle() {
        mrsTitle.click();
    }

    @Step("Preencheu first name")
    public void fillFirstName(String name) {
        firstName.sendKeys(name);
    }

    @Step("Preencheu last name")
    public void fillLastName(String name) {
        lastName.sendKeys(name);
    }

    @Step("Preencheu password")
    public void fillPassword(String word) {
        password.sendKeys(word);
    }

    @Step("Escolheu day of birth")
    public void selectDayOfBirth() {
        dayOfBirthOption.click();
    }

    @Step("Escolheu month of birth")
    public void selectMontOfBirth() {
        monthOfBirthOption.click();
    }

    @Step("Escolheu year of birth")
    public void selectYearOfBirth() {
        yearOfBirthOption.click();
    }

    @Step("Preencheu company")
    public void fillAddressCompany(String name) {
        company.sendKeys(name);
    }

    @Step("Preencheu address")
    public void fillAddress(String name) {
        address.sendKeys(name);
    }

    @Step("Preencheu address (line 2)")
    public void fillAddressLineTwo(String address) {
        addressLineTwo.sendKeys(address);
    }
    @Step("Preencheu city")
    public void fillCity(String name) {
        city.sendKeys(name);
    }

    @Step("Escolheu state")
    public void selectState() {
        optionFlorida.click();
    }

    @Step("Preencheu zip postal code")
    public void fillZip(String code) {
        zip.sendKeys(code);
    }

    @Step("Escolheu Country")
    public void selectCountry() {
        unitedStatesCountry.click();
    }

    @Step("Preencheu mobile phone")
    public void fillMobilePhone(String number) {
        mobilePhone.sendKeys(number);
    }

    @Step("Clicou em register")
    public void clickBtnSubmitRegister() {
        registerButton.click();
    }
}
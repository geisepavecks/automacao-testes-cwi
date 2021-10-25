package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreationPageElementMapper {
    @FindBy(css = "#id_gender2")
    public WebElement mrsTitle;

    @FindBy(css = "#customer_firstname")
    public WebElement firstName;

    @FindBy(css = "#customer_lastname")
    public WebElement lastName;

    @FindBy(css = "#passwd")
    public WebElement password;

    @FindBy(css = "#days > option:nth-child(13)")
    public WebElement dayOfBirthOption;

    @FindBy(css = "#months > option:nth-child(9)")
    public WebElement monthOfBirthOption;

    @FindBy(css = "#years > option:nth-child(31)")
    public WebElement yearOfBirthOption;

    @FindBy(css = "#firstname")
    public WebElement addressFirstName;

    @FindBy(css = "#lastname")
    public WebElement addressLastName;

    @FindBy(css = "#company")
    public WebElement company;

    @FindBy(css = "#address1")
    public WebElement address;

    @FindBy(css = "#address2")
    public WebElement addressLineTwo;

    @FindBy(css = "#city")
    public WebElement city;

    @FindBy(css = "#id_state > option:nth-child(11)")
    public WebElement optionFlorida;

    @FindBy(css = "#postcode")
    public WebElement zip;

    @FindBy(css = "#id_country > option:nth-child(2)")
    public WebElement unitedStatesCountry;

    @FindBy(css = "#phone_mobile")
    public WebElement mobilePhone;

    @FindBy(css = "#alias")
    public WebElement addressAlias;

    @FindBy(css = "#submitAccount")
    public WebElement registerButton;
}

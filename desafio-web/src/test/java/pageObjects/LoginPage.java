package pageObjects;

import elementMapper.AccountCreationPageElementMapper;
import elementMapper.LoginPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class LoginPage extends LoginPageElementMapper {

    public LoginPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    @Step("Preencheu o email")
    public void fillEmail(){
        email.sendKeys("geise.pavecks@gmail.com");
    }

    @Step("Preencheu a senha")
    public void fillPasswd(){
        passwd.sendKeys("teste01");
    }

    @Step("Clicou em Sign In")
    public void clickBtnSubmitLogin(){
        SubmitLogin.click();
    }

    @Step("Preencheu o email de criação de nova conta")
    public void fillNewAccEmail() {
        newAccountEmailInput.sendKeys(getRandomAccount());
    }

    @Step("Clicou no botão de create account")
    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    private String getRandomAccount() {
        StringBuilder newRandomAccount = new StringBuilder("a");

        for(int i = 0; i < 10; i++) {
            newRandomAccount.append((int)(Math.random() * 10));
        }
        newRandomAccount.append("@gmail.com");

        return newRandomAccount.toString();
    }
}

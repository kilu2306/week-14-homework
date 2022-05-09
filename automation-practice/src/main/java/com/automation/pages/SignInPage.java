package com.automation.pages;

import com.automation.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends Utility {
    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;
    @FindBy(id = "passwd")
    WebElement passWordField;
    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    WebElement signInButton;
    @FindBy(xpath = "//h1[@class='page-heading']")
    WebElement authenticationTextField;
    @FindBy(xpath = "//h3[normalize-space()='Create an account']")
    WebElement creatAccountTextField;
    @FindBy(xpath = "//span[normalize-space()='Create an account']")
    WebElement creatAccoutnButtonField;
    @FindBy(xpath = "//input[@id='email_create']")
    WebElement emailFieldInCreatAccount;

    public void enterEmailForCreatAccount(String email) {
        sendTextToElement(emailFieldInCreatAccount, email);
    }

    public void clickOnCreatAccountButton() {
        clickOnElement(creatAccoutnButtonField);
    }

    public void enterEmailForSignIn(String email) {
        sendTextToElement(emailField, email);
    }

    public void enterPasswordForSignIn(String password) {
        sendTextToElement(passWordField, password);
    }

    public String getAuthenticationText() {
        return getTextFromElement(authenticationTextField);
    }

    public String getCreatAnAccountText() {
        return getTextFromElement(creatAccountTextField);
    }

    public void clickOnSignInButton() {
        clickOnElement(signInButton);
    }

    public void signInApplication(String username, String password) {
        enterEmailForSignIn(username);
        enterPasswordForSignIn(password);
        clickOnElement(signInButton);

    }

}

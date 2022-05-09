package com.automation.pages;

import com.automation.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver,this);
    }

@FindBy(xpath = "//a[@title='Women']")
    WebElement womenField;
    @FindBy(xpath = "//li[@class='sfHover']//a[@title='Dresses'][normalize-space()='Dresses']']")
    WebElement dressesField;
    @FindBy(xpath = "//li[@class='sfHover']//a[@title='T-shirts'][normalize-space()='T-shirts']']")
    WebElement tshirtField;
    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    WebElement signInLinkField;


    public void clickOnWomanField(){
        clickOnElement(womenField);
    }
    public void clickOnDressesFiled(){
        clickOnElement(dressesField);
    }
    public void tshirtField(){
        clickOnElement(tshirtField);
    }
    public void clickOnsignInLinkFiled(){
    clickOnElement(signInLinkField);
    }
    public boolean signOutLinkDisplayed(){
        return signInLinkField.isDisplayed();
    }







}

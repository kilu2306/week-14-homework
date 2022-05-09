package com.automation.pages;

import com.automation.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends Utility {
    public MyAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='page-heading']")
    WebElement myaccountTextField;
    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement signOutLinkFiled;

    public String getMyaccountText() {
        return getTextFromElement(myaccountTextField);
    }
    public Boolean signOutLinkDisplayed(){
        return signOutLinkFiled.isDisplayed();
    }
    public void clickOnSignOutLink(){
        clickOnElement(signOutLinkFiled);

    }
}

package com.automation.testsuits;

import com.automation.pages.CreateAccountPage;
import com.automation.pages.HomePage;
import com.automation.pages.MyAccountPage;
import com.automation.pages.SignInPage;
import com.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreatAccountPageTest extends TestBase {
    HomePage homePage;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;
     MyAccountPage myAccountPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        signInPage = new SignInPage();
        createAccountPage = new CreateAccountPage();
        myAccountPage= new MyAccountPage();
    }


    @Test(groups = {"sanity"})
    public void verifyThatUserShouldCreateAccountSuccessfully() throws InterruptedException {
        homePage.clickOnsignInLinkFiled();
        signInPage.enterEmailForCreatAccount("pahal1234@gmail.com");
        signInPage.clickOnCreatAccountButton();
        createAccountPage.enterFirstNameInInfo("dhyani");
        createAccountPage.enterlastNameInInfo("patel");
        createAccountPage.enterPasswordInInfo("patel123");
        createAccountPage.enterAddress("6 ramnagar");
        Thread.sleep(2000);
        createAccountPage.enterCity("surat");
        createAccountPage.selectStateFromDropDown("Delaware");
        createAccountPage.enterZipCode("23456");
        //createAccountPage.clickOnCountrydropDownField();
        createAccountPage.selectCountryFromDropDown("United States");
        createAccountPage.enterHomePhoneNumber("9856738994");
        createAccountPage.enterAliasAddress("34 hemilton");
        createAccountPage.clickOnRegisterField();
        String actualText=myAccountPage.getMyaccountText();
        String expactedText="My Account";
        Assert.assertEquals(actualText,expactedText,"displayed message wrong ");


    }


}

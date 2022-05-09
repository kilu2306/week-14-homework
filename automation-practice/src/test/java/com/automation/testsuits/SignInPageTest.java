package com.automation.testsuits;

import com.automation.pages.AuthenticationPage;
import com.automation.pages.HomePage;
import com.automation.pages.MyAccountPage;
import com.automation.pages.SignInPage;
import com.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class SignInPageTest extends TestBase {
    HomePage homePage;
    SignInPage signInPage;
    AuthenticationPage authenticationPage;
    MyAccountPage myAccountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        signInPage = new SignInPage();
        authenticationPage = new AuthenticationPage();
        myAccountPage = new MyAccountPage();
    }

    @Test(groups = {"sanity",  "regression"})
    public void userShouldNavigateToSignInPageSuccessFully() {
        homePage.clickOnsignInLinkFiled();
        String expactedText = "AUTHENTICATION";
        String actualText = signInPage.getAuthenticationText();
        Assert.assertEquals(expactedText, actualText, "displayed Message wrong ");
    }

    @Test(dataProvider = "credential", dataProviderClass = TestData.class, groups = {"smoke", "regression"})

    public void verifyTheErrorMessageWithInValidCredentials(String username, String password, String message) {
        homePage.clickOnsignInLinkFiled();
        signInPage.enterEmailForSignIn(username);
        signInPage.enterPasswordForSignIn(password);
        signInPage.clickOnSignInButton();
        String actualMessage = authenticationPage.getErrorMessage();
        String expactedMessage = message;
        Assert.assertEquals(actualMessage, expactedMessage, "displayed wrong message");

    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {
        homePage.clickOnsignInLinkFiled();
        signInPage.enterEmailForSignIn("priya1234@gmail.com");
        signInPage.enterPasswordForSignIn("patel123");
        signInPage.clickOnSignInButton();
        Assert.assertTrue(myAccountPage.signOutLinkDisplayed());

    }
    @Test(groups = "regression")
    public void verifyThatUserShouldLogOutSuccessFully(){
        homePage.clickOnsignInLinkFiled();
        homePage.clickOnsignInLinkFiled();
        signInPage.enterEmailForSignIn("priya1234@gmail.com");
        signInPage.enterPasswordForSignIn("patel123");
        signInPage.clickOnSignInButton();
        myAccountPage.clickOnSignOutLink();
        Assert.assertTrue(homePage.signOutLinkDisplayed());


    }


}

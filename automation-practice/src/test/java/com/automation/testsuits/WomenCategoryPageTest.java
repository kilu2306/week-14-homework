package com.automation.testsuits;

import com.automation.pages.HomePage;
import com.automation.pages.ProductPage;
import com.automation.pages.WomenCategoryPage;
import com.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class WomenCategoryPageTest extends TestBase {
    HomePage homePage;
    WomenCategoryPage womenCategoryPage;
    ProductPage productPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        womenCategoryPage = new WomenCategoryPage();
        productPage = new ProductPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToWomenCategoryPageSuccessfully() {
        homePage.clickOnWomanField();
        String actualtext = womenCategoryPage.getWomenText();
        String expactedText = "WOMWN";
        Assert.assertEquals(actualtext, expactedText, "displayed text is wrong ");

    }

    @Test(dataProvider = "cart", dataProviderClass = TestData.class, groups = {"smoke", "regression"})
    public void verifyUserShouldAddProductToTheCartSuccessfully(String product, String qty, String size, String colour) throws InterruptedException {
        homePage.clickOnWomanField();
        womenCategoryPage.clickOnProduct(product);
        productPage.enterQuantity(qty);
        productPage.selectSize(size);
        productPage.clickOnColur(colour);
        productPage.clickOnAddCart();
        Thread.sleep(2000);
        String actualText = productPage.getSuccessFullyAddedText();
        Assert.assertTrue(actualText.contains("Product successfully added to your shopping cart"));
        //Assert.assertEquals(actualText,expactedtText,"displayed message is wrong ");
        productPage.clickOnCloseWindowTab();


    }


}

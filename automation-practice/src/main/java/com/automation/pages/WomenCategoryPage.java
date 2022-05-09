package com.automation.pages;

import com.automation.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WomenCategoryPage extends Utility {
    public WomenCategoryPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h2[@class='title_block']")
    WebElement womanTextField;
    @FindBy(xpath = "//div[@class='block_content']//a[normalize-space()='Tops']")
    WebElement topLinkField;
    @FindBy(xpath = "//div[@class='block_content']//a[contains(@title,'Find your favorites dresses from our wide choice of evening, casual or summer dresses!')][normalize-space()='Dresses']")
    WebElement dressesLink;
    @FindBy(xpath = "//div[@class='block_content']//a[contains(@title,'Find your favorites dresses from our wide choice of evening, casual or summer dresses!')][normalize-space()='Dresses']")
    WebElement shortBydropDownField;
    @FindBy(xpath = "//a[@class=\"product-name\"]")
    List<WebElement> productLists;
    @FindBy(xpath = "//a[normalize-space()='Blouse']")
    WebElement blouse;
    public String getWomenText() {
        return getTextFromElement(womanTextField);
    }
    public void clickOnTopsLink() {
        clickOnElement(topLinkField);
    }
    public void clickOnDressesLink() {
        clickOnElement(dressesLink);
    }
    public void clickOnDropDownField() {
        clickOnElement(shortBydropDownField);
    }
    public int getProductListsize() {
        List<WebElement> lists = productLists;
        return lists.size();
    }
    public String getTextFromBlouseLink() {
        return getTextFromElement(blouse);
    }
    public void clickOnProduct(String product) {
        for (WebElement lists : productLists)
            if (lists.getText().matches(product)) {
                lists.click();
                break;

            }
    }

}



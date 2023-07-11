package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class BuildYourOwnComputerPage extends Utility {

    By buildYourOwnComputerText = By.xpath("//h1[normalize-space()='Build your own computer']");
    By selectProcessor = By.xpath("//select[@id='product_attribute_1']");
    By selectRam = By.xpath("//select[@id='product_attribute_2']");

    By totalPrice = By.xpath("//div[@class='product-price']//span");
    By microsoftOfficeSoftwareOption = By.xpath("//input[@id='product_attribute_5_10']");
    By totalCommanderSoftwareOption = By.id("product_attribute_5_12");
    By addToCart = By.xpath("//button[@id='add-to-cart-button-1']");
    By successfullyText = By.xpath("//div[@id='bar-notification']");
    By closeNotificationBar = By.xpath("//span[@title='Close']");
    By goToCart = By.xpath("//button[normalize-space()='Go to cart']");


    public String getBuildYourOwnComputerText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(buildYourOwnComputerText);
    }

    public void selectProcessor(String name) throws InterruptedException {
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(selectProcessor, name);
    }

    public void selectRam(String name) throws InterruptedException {
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(selectRam, name);
    }

    public void selectHDD(String value) throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(By.xpath("//label[normalize-space()='" + value + "']"));
    }

    public void selectOs(String value) throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(By.xpath("//label[contains(normalize-space(),'" + value + "')]"));
    }

//    public void selectMicrosoftOfficeSoftwareOption() throws InterruptedException {
//        Thread.sleep(1000);
//        selectCheckBox();
//    }
//
//    private void selectCheckBox() {
//
//    }

    public void softwareSelect() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(totalCommanderSoftwareOption);
    }

    public String getTotalPriceText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(totalPrice);
    }

    public void clickOnAddtoCart() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(addToCart);
    }

    public String getSuccessfullyAddedToCartText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(successfullyText);
    }

    public void closeNotificationBar() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(closeNotificationBar);
    }


}

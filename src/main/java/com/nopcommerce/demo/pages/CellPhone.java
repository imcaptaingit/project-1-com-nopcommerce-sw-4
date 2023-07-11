package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class CellPhone extends Utility {

    By cellPhone = By.xpath("//h1[normalize-space()='Cell phones']");
    By ProductName = By.xpath("//h1[normalize-space()='Nokia Lumia 1020']");
    By PriceName = By.xpath("//div[@class='product-price']//span[normalize-space()='$349.00']");
    By listView = By.xpath("//a[normalize-space()='List']");
    By updateQuantity = By.xpath("//input[@id='product_enteredQuantity_20']");
    By addToCart = By.xpath("//button[@id='add-to-cart-button-20']");
    By clearCartQuantity = By.xpath("//input[@id='product_enteredQuantity_20']");
    By successfullyText = By.xpath("//div[@id='bar-notification']");
    By closeNotificationBar = By.xpath("//span[@title='Close']");


    public String getCellPhoneText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(cellPhone);
    }

    public void clickOnListViewIcon() {
        clickOnElement(listView);
    }

    public void selectPhoneFromList(String phone) throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'" + phone + "')]"));
    }


    public String getProductNameText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(ProductName);
    }

    public String getPriceText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(PriceName);
    }

    public void clearCartValue() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(clearCartQuantity).clear();
    }

    public void updateQuantity(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(updateQuantity, value);
    }

    public void clickOnAddToCart() throws InterruptedException {
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

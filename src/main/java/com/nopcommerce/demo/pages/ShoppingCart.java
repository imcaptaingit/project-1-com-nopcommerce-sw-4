package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class ShoppingCart extends Utility {

    By shoppingCartText = By.xpath("//h1[normalize-space()='Shopping cart']");
    By priceText = By.xpath("//span[@class='value-summary']//strong");
    By quantity = By.xpath("//input[contains(@id,'itemquantity')]");
    By updateShoppingCart = By.xpath("//button[@id='updatecart']");
    By termsAndCondition = By.xpath("//input[@id='termsofservice']");
    By checkOut = By.xpath("//button[@id='checkout']");
    By shoppingCart = By.xpath("//span[@class='cart-label']");


    By goToCart = By.xpath("//button[normalize-space()='Go to cart']");
//    By quantityValue = By.xpath("//input[contains(@id,'itemquantity')]");

    By quantityValue = By.xpath("//input[@class = 'qty-input']");


    public String getShoppingCartText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(shoppingCartText);
    }

    public void quantityClear() {
        driver.findElement(quantityValue).clear();
    }

    public void changeValueOfQuantity(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(quantityValue, value);
    }

    public void updateShoppingCart() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(updateShoppingCart);
    }

    public String getPriceText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(priceText);
    }

    public void selectTermsAndCondition() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(termsAndCondition);
    }

    public void clickOnCheckOut() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(checkOut);
    }

    public void mouseHoverToShoppingCart() throws InterruptedException {
        Thread.sleep(1000);
        mouseHoverToElement(shoppingCart);
    }

    public void mouseHoverToGoToCartAndClick() throws InterruptedException {
        Thread.sleep(1000);
        mouseHoverToElementAndClick(goToCart);
    }

    public void mouseHoverToShoppingCartAndClickOnCart() throws InterruptedException {
        Thread.sleep(1000);
        mouseHoverToElement(shoppingCart);
        mouseHoverToElementAndClick(goToCart);
    }


    public String getNumberOfQuantityValue() throws InterruptedException {
        Thread.sleep(1000);
        return getAttributeValueFromElement(quantityValue);
    }


}

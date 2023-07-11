package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerPage extends Utility {

    By desktop = By.xpath("//li[@class='active last']//a[normalize-space()='Desktops']");
    By sortingFilter = By.xpath("//select[@id='products-orderby']");


    //click on Desktop
    public void clickOnDesktop() {
        clickOnElement(desktop);
    }

    public void selectFilterFromDropDown(String text) throws InterruptedException {
        Thread.sleep(1000);
        WebElement dropDown = driver.findElement(sortingFilter);
        Select select = new Select(dropDown);
        //Select by Visible Text Method
        select.selectByVisibleText(text);
        Thread.sleep(1000);
    }

    /**
     * click Add to cart by Product name
     */

    public void clickToShoppingCart(String productName) throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(By.xpath("(//h2//a[normalize-space()='" + productName + "']//following::button)[1]"));
    }

    /**
     * sorting ZtoA
     */

    public List<String> sortDesktopByPositionByZtoA() throws InterruptedException {

        Thread.sleep(2000);
        List<WebElement> beforeSortValue = driver.findElements(By.xpath("//h2[@class='product-title']//a"));
        List<String> beforeSortDesktopValue = new ArrayList<>();
        for (WebElement value : beforeSortValue) {
            beforeSortDesktopValue.add(value.getText());
        }

        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        Thread.sleep(2000);
        waitUntilVisibilityOfElementLocated(By.xpath("//div[@class='picture']//img"),5);

        // After sorting value
        List<WebElement> afterSortValue = driver.findElements(By.xpath("//h2[@class='product-title']//a"));
        List<String> afterSortDesktopValue = new ArrayList<>();

        for (WebElement value1 : afterSortValue) {
            afterSortDesktopValue.add(value1.getText());
        }

        Collections.sort(beforeSortDesktopValue);// Ascending order

        Collections.reverse(beforeSortDesktopValue);// reverse

        return afterSortDesktopValue;
    }

    public List<String> getAllProductNamesAfterSorting() throws InterruptedException {

        Thread.sleep(2000);
        waitUntilVisibilityOfElementLocated(By.xpath("//div[@class='picture']//img"),5);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        Thread.sleep(2000);
        waitUntilVisibilityOfElementLocated(By.xpath("//div[@class='picture']//img"),5);

        // After sorting value
        List<WebElement> afterSortValue = driver.findElements(By.xpath("//h2[@class='product-title']//a"));
        List<String> afterSortDesktopValue = new ArrayList<>();

        for (WebElement value1 : afterSortValue) {
            afterSortDesktopValue.add(value1.getText());
        }
        return afterSortDesktopValue;
    }


}
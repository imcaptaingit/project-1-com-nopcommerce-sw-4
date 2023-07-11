package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest {


    HomePage homePage = new HomePage();
    ComputerPage computersPage = new ComputerPage();
    BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    ShoppingCart shoppingCartPage = new ShoppingCart();
    LoginPage loginPage = new LoginPage();
    CheckOutPage checkOutPage = new CheckOutPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        homePage.clickOnComputerTab();
        computersPage.clickOnDesktop();
        String actualOrder = computersPage.sortDesktopByPositionByZtoA().toString();
        String ExceptedOrder = computersPage.getAllProductNamesAfterSorting().toString();
        Assert.assertTrue(ExceptedOrder.contains(actualOrder));

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        String expectedMessage = "Build your own computer";
        homePage.clickOnComputerTab();
        computersPage.clickOnDesktop();
        computersPage.selectFilterFromDropDown("Name: A to Z");
        computersPage.clickToShoppingCart("Build your own computer");
        String actualMessage = buildYourOwnComputerPage.getBuildYourOwnComputerText();
        Assert.assertEquals(expectedMessage, actualMessage, "Unable to click on add to card");

        buildYourOwnComputerPage.selectProcessor("2.2 GHz Intel Pentium Dual-Core E2200");
        buildYourOwnComputerPage.selectRam("8GB [+$60.00]");
        buildYourOwnComputerPage.selectHDD("400 GB [+$100.00]");
        buildYourOwnComputerPage.selectOs("Vista Premium");
//      buildYourOwnComputerPage.selectMicrosoftOfficeSoftwareOption();
        buildYourOwnComputerPage.softwareSelect();
        Thread.sleep(2000);
        expectedMessage = "$1,475.00";
        actualMessage = buildYourOwnComputerPage.getTotalPriceText();
        Assert.assertEquals(expectedMessage, actualMessage, "Wrong Configuration");

        buildYourOwnComputerPage.clickOnAddtoCart();
        expectedMessage = "The product has been added to your shopping cart";
        actualMessage = buildYourOwnComputerPage.getSuccessfullyAddedToCartText();
        Assert.assertEquals(expectedMessage, actualMessage, "Not added in cart");

        buildYourOwnComputerPage.closeNotificationBar();
        shoppingCartPage.mouseHoverToShoppingCartAndClickOnCart();
        expectedMessage = "Shopping cart";
        actualMessage = shoppingCartPage.getShoppingCartText();
        Assert.assertEquals(expectedMessage, actualMessage, "Unable to click on cart");
        shoppingCartPage.quantityClear();
        shoppingCartPage.changeValueOfQuantity("2");
        shoppingCartPage.updateShoppingCart();
        expectedMessage = "$2,950.00";
        actualMessage = shoppingCartPage.getPriceText();
        Assert.assertEquals(expectedMessage, actualMessage, "Price not Updated");

        shoppingCartPage.selectTermsAndCondition();
        shoppingCartPage.clickOnCheckOut();
        expectedMessage = "Welcome, Please Sign In!";
        actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage, "Unable to checkout");

        loginPage.clickOnGuestCheckout();
        checkOutPage.enterFirstname("Sarvat");
        checkOutPage.enterLastname("Shaikh");
        checkOutPage.enterEmail("iambossy@gmail.com");
        checkOutPage.selectCountry("United Kingdom");
        checkOutPage.enterCity("London");
        checkOutPage.enterAddress1("283 High Road");
        checkOutPage.enterZipCode("EN8 7EF");
        checkOutPage.enterPhoneNumber("9825868472");
        checkOutPage.clickOnContinue();
        checkOutPage.selectNextDayAir();
        checkOutPage.clickOnShippingContinue();
        checkOutPage.clickOnCreditCard();
        checkOutPage.clickOnPaymentContinue();
        checkOutPage.selectCreditCardType("Master card");
        checkOutPage.enterCardHolderName("Mr Boss");
        checkOutPage.enterCardNumber("5534 5678 1234 5678");
        checkOutPage.selectExpirationDate("05", "2025");
        checkOutPage.enterCardCode("007");
        checkOutPage.clickOnPaymentInfoContinue();
        expectedMessage = "Credit Card";
        actualMessage = checkOutPage.getPaymentTypeText();
        Assert.assertEquals(expectedMessage, actualMessage, "Unable to checkout");

        expectedMessage = "Next Day Air";
        actualMessage = checkOutPage.getShippingMethodText();
        Assert.assertEquals(expectedMessage, actualMessage, "Unable to checkout");

        expectedMessage = "$2,950.00";
        actualMessage = checkOutPage.getTotalPriceText();
        Assert.assertEquals(expectedMessage, actualMessage, "Unable to checkout");

        checkOutPage.clickOnConfirm();
        expectedMessage = "Thank you";
        actualMessage = homePage.getThankYouText();
        Assert.assertEquals(expectedMessage, actualMessage, "Unable to checkout");

        expectedMessage = "Your order has been successfully processed!";
        actualMessage = homePage.getSuccessfulText();
        Assert.assertEquals(expectedMessage, actualMessage, "Unable to checkout");

        homePage.clickOnContinue();

        expectedMessage = "Welcome to our store";
        actualMessage = homePage.getWelcomeStoreText();
        Assert.assertEquals(expectedMessage, actualMessage, "Unable to checkout");

    }
}

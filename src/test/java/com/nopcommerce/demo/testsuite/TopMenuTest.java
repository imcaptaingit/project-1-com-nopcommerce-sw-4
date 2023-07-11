package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.Electronics;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {

    // HomePage homePage = new HomePage();
    Electronics electronicsPage =new Electronics();



    @Test
    public void verifyPageNavigation() {

        String menuName = "Electronics";
        String expectedMessage = "Electronics";
        electronicsPage.selectMenu(menuName);
        String actualMessage= electronicsPage.getElectronicsHeaderText();
        Assert.assertEquals(expectedMessage,actualMessage,"Unable to click on");
    }

}
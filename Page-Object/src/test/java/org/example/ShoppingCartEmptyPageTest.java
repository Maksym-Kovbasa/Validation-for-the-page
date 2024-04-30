package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;

public class ShoppingCartEmptyPageTest {

    private WebDriver driver;
    private ShoppingCartEmptyPage shoppingCartEmptyPage;

    @BeforeAll
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:/reer/Email/lib/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");
        shoppingCartEmptyPage = new ShoppingCartEmptyPage(driver);
    }

    @Test
    public void testEmptyShoppingCart() {
        // Click on Shopping Cart in the main menu
        HomePage homePage = shoppingCartEmptyPage.clickShoppingCart();

        // Verify that the page is empty
        Assert.assertEquals(shoppingCartEmptyPage.getEmptyCartLabelText(), "Your shopping cart is empty!");

        // Click on Continue button
        homePage = shoppingCartEmptyPage.clickContinueButton();

        // Verify that HomePage is loaded
        Assert.assertTrue(homePage.isHomePageLoaded());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

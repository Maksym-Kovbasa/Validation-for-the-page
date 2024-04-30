package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartEmptyPage extends TopPart {
   

    // WebElements
    @FindBy(xpath = "//h1[contains(text(), 'Shopping Cart')]")
    private WebElement shoppingCartLabel;

    @FindBy(xpath = "//p[contains(text(), 'Your shopping cart is empty!')]")
    private WebElement emptyCartLabel;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;

    // Constructor
    public ShoppingCartEmptyPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Methods to obtain text from fields
    public String getShoppingCartLabelText() {
        return shoppingCartLabel.getText();
    }

    public String getEmptyCartLabelText() {
        return emptyCartLabel.getText();
    }

    // Method to click on the Continue button
    public ShoppingCartEmptyPage clickContinueButton() {
        continueButton.click();
        return new ShoppingCartEmptyPage(getDriver());
    }
}

package org.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends Page {
    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement logoutOption;

    public void logOutFromTheAccount(){
        accountIcon.click();
        logoutOption.click();
        System.out.println("The user is logged out ");
    }
}

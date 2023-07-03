package org.opencart.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static String webDriverType = "Chrome";
    private static org.opencart.managers.DriverManager instance;
    private WebDriver driver;

    private DriverManager() {
        switch (webDriverType.toUpperCase()) {
            case "CHROME":
                driver = new ChromeDriver();
                System.out.println("The Chrome Driver was initiated! ");
                break;

            case "FIREFOX":
                driver = new FirefoxDriver();
                System.out.println("The Firefox Driver was initiated! ");
                break;

            case "EDGE":
                driver = new EdgeDriver();
                System.out.println("The Edge Driver was initiated! ");
                break;
            default:
                System.out.println("There is not defined such a driver: " + webDriverType);
        }
    }

    public static org.opencart.managers.DriverManager getInstance() {
        if (instance == null) {
            instance = new org.opencart.managers.DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            org.opencart.managers.DriverManager.getInstance();
        }
        return driver;
    }

    public void quitTheDriver(){
        driver.quit();
        driver = null;
        instance = null;
        System.out.println("Web driver is quit and the instance is reset!");
    }
}


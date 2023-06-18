package org.opencart;

import org.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {

        // Define a driver object that will be used for future action
        WebDriver driver = DriverManager.getInstance().getDriver();

        driver.get("https://www.youtube.com/");

        String currentWindowName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://github.com/");
        Thread.sleep(5000);

        driver.close();

        driver.switchTo().window(currentWindowName);

        driver.get("https:  //point.md/");
        Thread.sleep(1000);


        driver.quit();

        System.out.println("The execution was finished");


    }
}
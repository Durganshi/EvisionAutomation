package com.evision.eauf.evision_automation;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    public WebDriver getDriver(String browserName) {

            WebDriver driver = null;

            if (browserName != null) {
                try {

                    switch (browserName.toLowerCase()) {

                        case "chrome":
                            System.setProperty("webdriver.chrome.driver", "D:\\java\\chromedriver.exe");
                            driver = new ChromeDriver();
                            break;
                        case "firefox":
                            System.setProperty("webdriver.gecko.driver", "D:\\java\\geckodriver.exe");
                            driver = new FirefoxDriver();
                            break;

                        // Add cases for other browsers if needed
                        default:
                            throw new IllegalArgumentException("unsupported browser:  " + browserName);
                    }
                }
                    catch(Exception e){
                        System.out.println("Error initializing webDriver "+ e);
                    }
                }
             else {
                System.out.println("Please provide browser name! ");
            }
             return driver;
    }
}


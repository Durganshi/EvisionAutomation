package com.evision.eauf.evision_automation;

import com.evision.eauf.evision_automation.selenium.Utility.LoggerUtil;
import com.evision.eauf.evision_automation.utility.AllMethods;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import com.evision.eauf.evision_automation.utility.AllMethods;


public class EvisionAutomationApplication {
	private Properties properties;
	static WebDriver driver;
	public BrowserFactory browserFactory;

	AllMethods allMethods=new AllMethods();

	public EvisionAutomationApplication() {
		properties = new Properties();
		browserFactory = new BrowserFactory();
	}

	@BeforeClass(groups = {"FullRun", "smoke", "regression"})
	public void initialize() throws IOException {
		LoggerUtil.configureLogger();
		loadProperties();
		LoggerUtil.logInfo("Property file loaded :  ");
		initializeDriver();
		LoggerUtil.logInfo("Driver initialized : ");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1L));

	}


	public void loadProperties() throws IOException {
		FileInputStream fis = new FileInputStream("D:\\Java\\evision_automation\\src\\main\\java\\com\\evision\\eauf\\evision_automation\\mydata\\Config.properties");
		properties = new Properties();
		properties.load(fis);
	}


	public void initializeDriver() {

		driver = browserFactory.getDriver(properties.getProperty("browser"));

		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
		LoggerUtil.logInfo("Window maximized : ");

	}


	@Test(groups = {"FullRun", "regression"})
	public void validateTitle() {
		String expectedTitle = "Google";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1L));
		wait.until(ExpectedConditions.titleContains(expectedTitle));

		String actualTitle = driver.getTitle();
		WebElement searchInput = driver.findElement(By.id("APjFqb"));
		searchInput.sendKeys("search.query");

		WebElement button = driver.findElement(By.xpath("//input[@value='Google Search']"));
		button.submit();

		LoggerUtil.logInfo("Title validate : ");

		if (allMethods.compareStrings(actualTitle,expectedTitle)) {
			System.out.println("Title verification passed!");
		} else {
			System.out.println("Title verification failed!");
		}
	}


	@Test(groups = {"FullRun", "smoke"})
	public void validateUrl() {
		String expectedURLContains = properties.getProperty("expected.url.contains");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1L));
		wait.until(ExpectedConditions.urlContains(expectedURLContains));

		String currentUrl = driver.getCurrentUrl();
		LoggerUtil.configureLogger();
		LoggerUtil.logInfo("Current URL : ");
		if (allMethods.prefixAndCharacterString()) {
			System.out.println("URL verified");
		} else {
			System.out.println("URL not verified");
		}

	}

	@Test(groups = {"FullRun", "regression"})
	public void validateFeelingLucky() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1L));
		WebElement feelingLuckyButton = driver.findElement(By.xpath("(//*[@name = 'btnI'])[2]"));
		LoggerUtil.logInfo("Feeling Lucky button: ");
		if (feelingLuckyButton.isDisplayed()) {
			System.out.println("I'm Feeling Lucky button is present!");
		} else {
			System.out.println("I'm Feeling Lucky button is not present!");
		}
	}


	@Test(groups = {"FullRun", "smoke"})
	public void validateGmailLink() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1L));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Gmail")));

		WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
		LoggerUtil.logInfo("Gmail link: ");
		if (gmailLink.isDisplayed()) {
			System.out.println("Gmail link  present!");
		} else {
			System.out.println("Gmail link isn't present!");
		}
	}

	@AfterClass(groups = {"FullRun", "regression", "smoke"})
	public void closeBrowser() {
		driver.close();
	}

  }




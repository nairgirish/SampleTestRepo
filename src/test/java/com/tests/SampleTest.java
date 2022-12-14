package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SampleTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().clearDriverCache().forceDownload().setup();     
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); 
        options.addArguments("--disable-dev-shm-usage");
     
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.amazon.in/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
        

    }

    @Test(priority = 1)
    public void verifyTitleIsAsExpected() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");

    }

    @Test(priority = 2)
    public void verifyLogoIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.cssSelector("#nav-logo-sprites")).isDisplayed());
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}

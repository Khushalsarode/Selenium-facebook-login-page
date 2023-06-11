package com.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws InterruptedException {
        // Set up Chrome driver
        System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to Facebook.com
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);

        // Enter email/phone and password
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("pass"));
        emailField.sendKeys("seleniumtest");
        passwordField.sendKeys("Mavenselenuim");

        // Click login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        loginButton.click();

        Thread.sleep(3000);

        // Logout
        WebElement navigationClick = driver.findElement(By.id("userNavigationLabel"));
        WebElement logout = driver.findElement(By.xpath("//span[contains(text(),'Log Out')]"));
        navigationClick.click();

        if (logout.isEnabled() && logout.isDisplayed()) {
            logout.click();
        } else {
            System.out.println("Element not found");
        }

        // Quit the driver
        driver.quit();
    }
}

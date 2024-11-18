package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.trendyol.com/giris");
        driver.manage().window().maximize();
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("login-email")).sendKeys("forjavaintellij@hotmail.com");
        driver.findElement(By.id("login-password-input")).sendKeys("987654Sev.");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).submit();
        Thread.sleep(3000);
        String value=driver.findElement(By.cssSelector("[class='link account-user'] p")).getText();
        System.out.println(value);
    }
}

package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseTest {

    public  LoginPage fillMail(String text) {
        WebElement element=driver.findElement(By.id("login-email"));
        element.clear();
        element.sendKeys(text);
        //driver.findElement(By.id("login-email")).clear();
        //driver.findElement(By.id("login-email")).sendKeys(text);
        return this;
    }

    public LoginPage fillPassword(String text) {
        WebElement element=driver.findElement(By.id("login-password-input"));
        element.clear();
        element.sendKeys(text);
        //driver.findElement(By.id("login-password-input")).clear();
        //driver.findElement(By.name("login-password")).sendKeys(text);
        return this;

    }

    public LoginPage clickLoginButton(){

        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).submit();
        return this;
    }
    public String getErrorMessage(){

        String value = driver.findElement(By.cssSelector("[class='message']")).getText();
        return value;
    }
}

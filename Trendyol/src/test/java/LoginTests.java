import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {
    WebDriver driver;
    @BeforeMethod
    public void OpenBrowser(){

        driver= new ChromeDriver();
        driver.get("https://www.trendyol.com/giris");
        driver.manage().window().maximize();

    }
    @Test
    public void LoginSuccessful() throws InterruptedException {


        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("login-email")).sendKeys("forjavaintellij@hotmail.com");
        driver.findElement(By.id("login-password-input")).sendKeys("987654Sev.");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).submit();
        Thread.sleep(3000);
        String value=driver.findElement(By.cssSelector("[class='link account-user'] p")).getText();
        System.out.println(value);
        Assert.assertEquals("Hesabım", value);

    }

    @Test
    public void LoginUnSuccessful() throws InterruptedException {


        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("login-email")).sendKeys("forjavaintellij@hotmail.com");
        driver.findElement(By.id("login-password-input")).sendKeys("987654Sev");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).submit();
        Thread.sleep(3000);
        String value=driver.findElement(By.id("error-box-wrapper")).getText();
        System.out.println(value);
        Assert.assertEquals("E-posta adresiniz ve/veya şifreniz hatalı.", value);

    }

    @Test
    public void LoginRequiredControlEmail() throws InterruptedException {


        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(3000);
        //driver.findElement(By.id("login-email")).sendKeys("");
        //driver.findElement(By.id("login-password-input")).sendKeys("");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).submit();
        Thread.sleep(3000);
        String value=driver.findElement(By.id("error-box-wrapper")).getText();
        System.out.println(value);
        Assert.assertEquals("Lütfen geçerli bir e-posta adresi giriniz.", value);

    }
    @Test
    public void LoginRequiredControlPassword() throws InterruptedException {


        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("login-email")).sendKeys("forjavaintellij@hotmail.com");
        //driver.findElement(By.id("login-password-input")).sendKeys("");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).submit();
        Thread.sleep(3000);
        String value=driver.findElement(By.cssSelector("[class='message']")).getText();
        System.out.println(value);
        Assert.assertEquals("Lütfen şifrenizi giriniz.", value);

    }

    @Test
    public void MinMaxCharacterControl() throws InterruptedException {


        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("login-email")).sendKeys("a");
        driver.findElement(By.id("login-password-input")).sendKeys("a");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).submit();
        Thread.sleep(3000);
        String value=driver.findElement(By.id("error-box-wrapper")).getText();
        System.out.println(value);
        Assert.assertEquals("Lütfen geçerli bir e-posta adresi giriniz.", value);
        driver.findElement(By.id("login-email")).clear();
        driver.findElement(By.id("login-email")).sendKeys("forjavaintellij@hotmail.com");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).submit();
        Thread.sleep(3000);
        String value1=driver.findElement(By.id("error-box-wrapper")).getText();
        System.out.println(value1);
        Assert.assertEquals("E-posta adresiniz ve/veya şifreniz hatalı.", value1);
        driver.findElement(By.id("login-password-input")).clear();
        driver.findElement(By.id("login-password-input")).sendKeys("987654Sev.");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).submit();
        Thread.sleep(3000);
        String value2=driver.findElement(By.cssSelector("[class='link account-user'] p")).getText();
        System.out.println(value2);
        Assert.assertEquals("Hesabım", value2);

    }


    @AfterMethod
    public void CloseBrowser(){

        driver.quit();

    }
}

import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTestsBaseTestData extends BaseTest {

    LoginPage login = new LoginPage();
    MainPage mainPage=new MainPage();
    @Test
    public void LoginSuccessful() throws InterruptedException {

        login.fillMail(mail)
                .fillPassword(password)
                .clickLoginButton();

        sleep(3000);
        String value= mainPage.getAccountName();
        assertEquals("Hesabım", value);

    }

    @Test
    public void LoginUnSuccessful() throws InterruptedException {


        login.fillMail(mail)
                .fillPassword("abc")
                .clickLoginButton();
        //driver.findElement(By.id("login-email")).sendKeys(mail);
        //driver.findElement(By.id("login-password-input")).sendKeys(password);
        //driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).submit();
        //String value = driver.findElement(By.id("error-box-wrapper")).getText();
        //System.out.println(value);
        sleep(3000);
        String value= login.getErrorMessage();
        assertEquals("E-posta adresiniz ve/veya şifreniz hatalı.", value);
    }

    @Test
    public void LoginRequiredControlEmail() throws InterruptedException {


        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(3000);
        //driver.findElement(By.id("login-email")).sendKeys("");
        //driver.findElement(By.id("login-password-input")).sendKeys("");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).submit();
        Thread.sleep(3000);
        String value = driver.findElement(By.id("error-box-wrapper")).getText();
        System.out.println(value);
        assertEquals("Lütfen geçerli bir e-posta adresi giriniz.", value);

    }

    @Test
    public void LoginRequiredControlPassword() throws InterruptedException {


        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("login-email")).sendKeys(mail);
        //driver.findElement(By.id("login-password-input")).sendKeys("");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).submit();
        Thread.sleep(3000);
        String value = driver.findElement(By.cssSelector("[class='message']")).getText();
        System.out.println(value);
        assertEquals("Lütfen şifrenizi giriniz.", value);

    }

    @Test
    public void MinMaxCharacterControl() throws InterruptedException {


        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("login-email")).sendKeys("a");
        driver.findElement(By.id("login-password-input")).sendKeys("a");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).submit();
        Thread.sleep(3000);
        String value = driver.findElement(By.id("error-box-wrapper")).getText();
        System.out.println(value);
        assertEquals("Lütfen geçerli bir e-posta adresi giriniz.", value);
        driver.findElement(By.id("login-email")).clear();
        driver.findElement(By.id("login-email")).sendKeys(mail);
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).submit();
        Thread.sleep(3000);
        String value1 = driver.findElement(By.id("error-box-wrapper")).getText();
        System.out.println(value1);
        assertEquals("E-posta adresiniz ve/veya şifreniz hatalı.", value1);
        driver.findElement(By.id("login-password-input")).clear();
        driver.findElement(By.id("login-password-input")).sendKeys(password);
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).submit();
        Thread.sleep(3000);
        String value2 = driver.findElement(By.cssSelector("[class='link account-user'] p")).getText();
        System.out.println(value2);
        assertEquals("Hesabım", value2);

    }
}

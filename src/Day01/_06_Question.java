package Day01;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _06_Question extends BaseDriver {
    // SENARYO
    // 1-Siteye Login
    // 2-Login olduğunuzu title ile doğrulayınız.
    @Test
    public void Test1() {
        // Sonradan login işlemlerini BaseDriver'a taşıyabiliriz.
        driver.get("https://opencart.abstracta.us/");
        driver.manage().window().maximize();

        WebElement myAcc = driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/a/span[1]"));
        myAcc.click();
        Tools.Wait(2);

        WebElement login = driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[2]/a"));
        login.click();
        Tools.Wait(2);

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //WebElement git = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/h2"));
        //js.executeScript("arguments[0].scrollIntoView();",git);
        //Tools.Bekle(2);

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("yasetest1@gmail.com");
        Tools.Wait(2);

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("messi");
        Tools.Wait(2);

        WebElement loginButton = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/form/input"));
        loginButton.click();
        Tools.Wait(2);

        WebElement title = driver.findElement(By.xpath("//*[@id='content']/h2[1]"));
        Assert.assertTrue(title.getText().equals("My Account"),"Failed");

    }

}

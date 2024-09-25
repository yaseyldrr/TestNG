package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Tools {
    public static void Bekle(int sn) {
        try {
            Thread.sleep(sn * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void SuccessMessageValidation() {
        WebElement success= BaseDriver.driver.findElement(By.xpath("//*[@id='account-account']/div[1]"));
        Assert.assertTrue(success.getText().contains("Success"), "Error 404");
    }
}

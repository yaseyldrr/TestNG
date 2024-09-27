package Day04;

/*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra url deki success yazısını doğrulayınız.
 */

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _02_ContactUsParameter extends BaseDriver {
    //@Parameters({"mesaj","mesaj2"})

    @Test
    @Parameters("message") // xml de ki ile aynı name olmalı
    public void ContactUs(String receivedMessage)
    {
        WebElement contactUsBtn=driver.findElement(By.linkText("Contact Us"));
        contactUsBtn.click();

        WebElement enquiryArea=driver.findElement(By.id("input-enquiry"));
        enquiryArea.sendKeys(receivedMessage);

        WebElement submitBtn=driver.findElement(By.cssSelector("[type='submit']"));
        submitBtn.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("success"), "Transaction is incorrect.");
    }

}

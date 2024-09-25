package Day01;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _08_SubscribeNewsLetter extends BaseDriver {
    By link= By.xpath("(//a[text()='Newsletter'])[1]");
    By subYes = By.xpath("//input[@value='1']");
    By cntBtn=By.xpath("//input[@value='Continue']");
    By subNo= By.xpath("//input[@value='0']");
    /*
  Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe işlemini abone lunuz(YES), işlemin başarılı olduğunu kontrol ediniz.
   */

    @Test(priority = 1)
    public void Test1() {

        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath("/html/body/footer/div/div/div[1]/h5")))
                .build()
                .perform();

        WebElement newsLetter = driver.findElement(By.xpath("//*[@id='content']/ul[4]/li/a"));
        newsLetter.click();

        WebElement yes = driver.findElement(By.xpath("//*[@id='content']/form/fieldset/div/div/label[1]/input"));
        yes.click();

        WebElement subscribe = driver.findElement(By.xpath("//input[@value='Continue']"));
        subscribe.click();

        Tools.SuccessMessageValidation();
    }
    /*
  Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe işlemini abone lunuz(NO), işlemin başarılı olduğunu kontrol ediniz.
   */

    @Test
    public void Test2() {
        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath("/html/body/footer/div/div/div[1]/h5")))
                .build()
                .perform();

        WebElement newsLetter = driver.findElement(By.xpath("//*[@id='content']/ul[4]/li/a"));
        newsLetter.click();

        WebElement no = driver.findElement(By.xpath("//*[@id='content']/form/fieldset/div/div/label[2]/input"));
        no.click();

        WebElement subscribe = driver.findElement(By.xpath("//input[@value='Continue']"));
        subscribe.click();

        WebElement continue1 = driver.findElement(By.xpath("//*[@id='content']/form/div/div[2]/input"));
        continue1.click();

        Tools.SuccessMessageValidation();
    }
    @Test
    public void Test3() {
        WebElement newLettersLink = driver.findElement(link);
        newLettersLink.click();

        WebElement subscribeYes = driver.findElement(subYes);
        WebElement subscribeNo = driver.findElement(subNo);

        if(subscribeYes.isSelected())
            subscribeNo.click();
        else
            subscribeYes.click();

        WebElement continue1 = driver.findElement(By.xpath("//*[@id='content']/form/div/div[2]/input"));
        continue1.click();

        Tools.SuccessMessageValidation();

    }

}

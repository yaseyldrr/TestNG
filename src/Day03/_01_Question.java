package Day03;
/*
  Senaryo
  1- Siteyi açınız.
  2- Edit Account sayfasına ulaşınız.
  3- Ad ve soyadı değiştirip tekrar kaydedidiniz.
 */

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _01_Question extends BaseDriver {
    @Test
    public void EditAccount() {
        WebElement editAccount = driver.findElement(By.xpath("//*[@id='content']/ul[1]/li[1]/a"));
        editAccount.click();

        WebElement name = driver.findElement(By.name("firstname"));
        name.clear();
        name.sendKeys("aaa");
        Tools.Bekle(1);

        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.clear();
        lastname.sendKeys("bbb");
        Tools.Bekle(1);

        WebElement cont = driver.findElement(By.xpath("//*[@id='content']/form/div/div[2]/input"));
        cont.click();
        Tools.Bekle(2);

        Tools.SuccessMessageValidation();
    }

}

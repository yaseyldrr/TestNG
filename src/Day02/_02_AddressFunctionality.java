package Day02;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/*     Senaryo;
       1- Siteyi açınız.
       2- Adres ekleyiniz.
       3- En son adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En sondan 2. adresi siliniz.
 */

public class _02_AddressFunctionality extends BaseDriver {;

    @Test(priority = 1)
    public void AddressBook() {
        WebElement addressBook = driver.findElement(By.xpath("//*[@id='content']/ul[1]/li[3]/a"));
        addressBook.click();
        Tools.Wait(2);
    }

    @Test(priority = 2)
    public void AddAddress() {
        WebElement add = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/a"));
        add.click();
        Tools.Wait(2);
    }

    @Test(dependsOnMethods = {"AddAddress", "AddressBook"}, priority = 3)
    public void FillInfos() {
        WebElement name = driver.findElement(By.name("firstname"));
        name.sendKeys("yase");
        Tools.Wait(1);

        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys("test");
        Tools.Wait(1);

        WebElement company = driver.findElement(By.name("company"));
        company.sendKeys("Batch-6");
        Tools.Wait(1);

        WebElement address1 = driver.findElement(By.name("address_1"));
        address1.sendKeys("TR Batch-6");
        Tools.Wait(1);

        WebElement address2 = driver.findElement(By.name("address_2"));
        address2.sendKeys("TR Batch-6-1");
        Tools.Wait(1);

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Manisa");
        Tools.Wait(1);

        WebElement postcode = driver.findElement(By.name("postcode"));
        postcode.sendKeys("45001");
        Tools.Wait(1);

        WebElement country = driver.findElement(By.name("country_id"));
        Select countryMenu = new Select(country);
        countryMenu.selectByVisibleText("Turkey");
        wait.until(ExpectedConditions.elementToBeClickable(company));

        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath("//*[@id='content']/form/div/div[2]/input")))
                .build()
                .perform();
        Tools.Wait(1);

        WebElement region = driver.findElement(By.name("zone_id"));
        Select regionMenu = new Select(region);
        regionMenu.selectByVisibleText("Manisa");
        Tools.Wait(2);

        WebElement cont = driver.findElement(By.xpath("//*[@id='content']/form/div/div[2]/input"));
        cont.click();
    }

    @Test(priority = 4)
    public void EditAddress() {
        WebElement editButton = driver.findElement(By.xpath("//*[@id='content']/div[1]/table/tbody/tr/td[2]/a[1]"));
        editButton.click();
        Tools.Wait(2);

        WebElement name = driver.findElement(By.name("firstname"));
        name.clear();
        name.sendKeys("YASE");
        Tools.Wait(1);

        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.clear();
        lastname.sendKeys("TEST");
        Tools.Wait(1);

        WebElement cont = driver.findElement(By.xpath("//*[@id='content']/form/div/div[2]/input"));
        cont.click();
    }

    @Test(priority = 5)
    public void deleteAddress() {
        WebElement delete = driver.findElement(By.xpath("(//a[text()='Delete'])[2]"));
        delete.click();
        Tools.Wait(2);

        WebElement success = driver.findElement(By.xpath("//*[text()=' Your address has been successfully deleted']"));
        Assert.assertTrue(success.getText().contains("successfully"), "error");

    }
}

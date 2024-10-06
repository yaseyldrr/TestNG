package Day06;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_Question extends BaseDriver {
    /*
   Senaryo :
   1- Siteyi açınız.
   2- Sitede "ipod" kelimesini aratınız
   3- Çıkan sonuçlardan ilkini sepete atınız.
   4- Shopping Chart a tıklatınız.
   5- Checkout yapınız.
   6- Continue butonalarına tıklatıp bilgileri giriniz.
   7- En confirm ile siparişi verdiğinizi doğrulayınız.
      doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
*/
    @Test
    public void SearchAddAndConfirm() {
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='search']/input"));
        searchBox.sendKeys("ipod" + Keys.ENTER);
        wait.until(ExpectedConditions.urlToBe("https://opencart.abstracta.us/index.php?route=product/search&search=ipod"));

        WebElement product = driver.findElement(By.xpath("//*[@id='content']/div[3]/div[1]/div/div[2]/div[2]/button[1]/span"));
        product.click();

        WebElement cart = driver.findElement(By.xpath("//*[@id='top-links']/ul/li[4]/a/span"));
        cart.click();
        wait.until(ExpectedConditions.urlToBe("https://opencart.abstracta.us/index.php?route=checkout/cart"));

        WebElement checkout = driver.findElement(By.xpath("//*[@id='content']/div[3]/div[2]/a"));
        checkout.click();
        wait.until(ExpectedConditions.urlToBe("https://opencart.abstracta.us/index.php?route=checkout/checkout"));

        WebElement cont1 = driver.findElement(By.xpath("//*[@id='button-payment-address']"));
        cont1.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='button-shipping-address']")));
        WebElement cont2 = driver.findElement(By.xpath("//*[@id='button-shipping-address']")) ;
        cont2.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='button-shipping-method']")));
        WebElement cont3 = driver.findElement(By.xpath("//*[@id='button-shipping-method']")) ;
        cont3.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapse-payment-method']/div/div[3]/div/input[1]")));
        WebElement checkBox = driver.findElement(By.xpath("//*[@id='collapse-payment-method']/div/div[3]/div/input[1]"));
        checkBox.click();

        WebElement cont4 = driver.findElement(By.xpath("//*[@id='button-payment-method']"));
        cont4.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='button-confirm']")));
        WebElement confirmOrder = driver.findElement(By.xpath("//*[@id='button-confirm']"));
        confirmOrder.click();

        WebElement message = driver.findElement(By.xpath("//div[@id='content']/h1"));
        Assert.assertEquals(message.getText(),"Your order has been placed!");

    }
}

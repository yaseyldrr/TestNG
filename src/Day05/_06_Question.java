package Day05;

/*
  Senaryo;
  1- Brands menusune gidiniz.
  2- Burada her bir markanın üstünde yer alan harf ile başladığını doğrulayınız
*/

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class _06_Question extends BaseDriver {
    @Test
    public void Test1() {
        WebElement brands = driver.findElement(By.linkText("Brands"));
        brands.click();

        List<WebElement> letter = driver.findElements(By.xpath("//h2"));
        List<WebElement> word = driver.findElements(By.xpath("//div[@id='content']//div[@class='col-sm-3']"));

        Assert.assertTrue(letter.get(2).getText().equals(word.get(3).getText().substring(0, 1)), "Failed");
        word.remove(3);

        int i = 0;
        for (WebElement e : word) {
            Assert.assertTrue(e.getText().substring(0, 1).equals(letter.get(i++).getText()), "Failed");
        }

    }
}

    /*@Test
    public void BrandsValidation()
    {
        WebElement brandsLink = driver.findElement(By.linkText("Brands"));
        brandsLink.click();

        List<WebElement> harfler=driver.findElements(By.cssSelector("[id='content'] h2")); //A C H
        List<WebElement> markalarSatiri=driver.findElements(By.cssSelector("[id='content'] > div")); // Hav Htc

        for (int i = 0; i < harfler.size(); i++) {
            String harf= harfler.get(i).getText(); // A
            WebElement harfinAltindakiSatir= markalarSatiri.get(i); // Apple Apple2

            List<WebElement> markalar= harfinAltindakiSatir.findElements(By.tagName("div"));  //Apple Apple2

            for (WebElement marka: markalar) {
                System.out.println(harf+" "+marka.getText());
                Assert.assertTrue(harf.charAt(0)==marka.getText().charAt(0), "Başlık ve marka uyumlu değil");
            }
                //Markanın ilk harfi Harf ile başlıyor mu?
                //Assert.assertTrue(marka.startsWith(harf)
        }

}
*/

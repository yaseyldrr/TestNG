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

        Assert.assertTrue(letter.get(2).getText().equals(word.get(3).getText().substring(0,1)),"Failed");
        word.remove(3);

        int i = 0;
        for (WebElement e : word){
            Assert.assertTrue(e.getText().substring(0,1).equals(letter.get(i++).getText()),"Failed");
        }

    }

}


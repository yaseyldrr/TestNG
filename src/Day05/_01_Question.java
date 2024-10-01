package Day05;

/*

   Senaryo:
   1- Siteye gidiniz
   2- Specials tiklayiniz
   3- Çıkan urun lerde (bütün ürünlerde indirim var mı, eski fiyat yeni fiyat var mı)
   4- Yukarıdaki işlemden sonra her ürünün önceki fiyatının şu andaki fiyattan
      yüksek olduğunu doğrulayınız.
   5- Yukarıdaki işlemi 2 farklı browserda ve paralel şekilde test ediniz.
*/

import Utility.BaseDriver;
import Utility.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class _01_Question extends BaseDriverParameter {
    @Test
    public void Specials() {
        WebElement specials = driver.findElement(By.linkText("Specials")); // a tag lilerde linktext kullanılabilir, span lerde olmaz!
        specials.click();



        List<WebElement> priceNew = driver.findElements(By.className("price-new"));
        List<WebElement> priceOld = driver.findElements(By.className("price-old"));
        List<Double> prices = new ArrayList<>();


        Assert.assertTrue(priceNew.size() == priceOld.size(), "Not all product has discount");


        for (WebElement e : priceNew){
            String a = e.getText();
            double b = Double.parseDouble(a.substring(1));
            prices.add(b);
        }
        for (WebElement e : priceOld){
            String a = e.getText();
            double b = Double.parseDouble(a.substring(1));
            prices.add(b);
        }

        Assert.assertTrue(prices.get(2)-prices.get(0) > 0, "no discount");
        Assert.assertTrue(prices.get(3)-prices.get(1) > 0, "no discount");

    }


}

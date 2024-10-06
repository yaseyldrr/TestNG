package Day07;

/*
   Senaryo :
   1- Siteyi açınız.
   2- Sitede "ipod" kelimesini aratınız
   3- Çıkan sonuçlardan random birini sepete atınız.
   4- Shopping Chart a tıklatınız.
   5- Seçilen ürünün sepette olduğunu doğrulayınız.
   6- POM ile çözünüz.


   ihtiyaç olacak ise:

    @FindBy(xpath = "//span[text()='Add to Cart']")
    public List<WebElement> addToChartLAR;
 */


import Day06._03_PlaceOrderElements;
import Utility.BaseDriver;
import Utility.BaseDriverGeneral;
import Utility.Tools;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Question extends BaseDriver {


    @Test
    public void addToCart()
    {
        BaseDriverGeneral.logEkle.info("addToCart test is started.");
        _03_PlaceOrderElements poe=new _03_PlaceOrderElements();
        _01_Elements sre= new _01_Elements();

        poe.searchInput.sendKeys("ipod"+ Keys.ENTER);

        int randomSelect= Tools.randomGenerator(sre.productListAddCart.size()); // 0,1,2,3
        System.out.println(randomSelect);

        //tıkaltmadan önce ürürnün ismini saklayalım
        String productToClick=sre.productListCaption.get(randomSelect).getText();
        sre.productListAddCart.get(randomSelect).click(); // Add chart a tıklandı

        poe.shoppingChart.click();

//        boolean productFound=false;
//        for(WebElement urun : sre.productListBasket)
//        {
//            if (urun.getText().equals(productToClick)) {
//                productFound = true;
//                break;
//            }
//        }

        boolean productFound=Tools.listContainsString(sre.productListBasket, productToClick); // yukarıdaki döngü metod yapıldı
        Assert.assertTrue(productFound,"The chosen product was not found");
    }


}
